package com.google.firebase.database.tubesock;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.SocketTimeoutException;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
class WebSocketReceiver {
    private WebSocketEventHandler eventHandler = null;
    private DataInputStream input = null;
    private byte[] inputHeader = new byte[112];
    private Builder pendingBuilder;
    private volatile boolean stop = false;
    private WebSocket websocket = null;

    WebSocketReceiver(WebSocket websocket2) {
        this.websocket = websocket2;
    }

    /* access modifiers changed from: 0000 */
    public void setInput(DataInputStream input2) {
        this.input = input2;
    }

    /* access modifiers changed from: 0000 */
    public void run() {
        this.eventHandler = this.websocket.getEventHandler();
        while (!this.stop) {
            try {
                int offset = 0 + read(this.inputHeader, 0, 1);
                boolean fin = (this.inputHeader[0] & 128) != 0;
                if (!((this.inputHeader[0] & 112) != 0)) {
                    byte opcode = (byte) (this.inputHeader[0] & 15);
                    int offset2 = offset + read(this.inputHeader, offset, 1);
                    byte length = this.inputHeader[1];
                    long payload_length = 0;
                    if (length < 126) {
                        payload_length = (long) length;
                    } else if (length == 126) {
                        int offset3 = offset2 + read(this.inputHeader, offset2, 2);
                        payload_length = (((long) (this.inputHeader[2] & 255)) << 8) | ((long) (this.inputHeader[3] & 255));
                    } else if (length == Byte.MAX_VALUE) {
                        payload_length = parseLong(this.inputHeader, (offset2 + read(this.inputHeader, offset2, 8)) - 8);
                    }
                    byte[] payload = new byte[((int) payload_length)];
                    read(payload, 0, (int) payload_length);
                    if (opcode == 8) {
                        this.websocket.onCloseOpReceived();
                    } else if (opcode != 10) {
                        if (!(opcode == 1 || opcode == 2 || opcode == 9)) {
                            if (opcode != 0) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Unsupported opcode: ");
                                sb.append(opcode);
                                throw new WebSocketException(sb.toString());
                            }
                        }
                        appendBytes(fin, opcode, payload);
                    }
                } else {
                    throw new WebSocketException("Invalid frame received");
                }
            } catch (SocketTimeoutException e) {
            } catch (IOException ioe) {
                handleError(new WebSocketException("IO Error", ioe));
            } catch (WebSocketException e2) {
                handleError(e2);
            }
        }
    }

    private void appendBytes(boolean fin, byte opcode, byte[] data) {
        if (opcode == 9) {
            if (fin) {
                handlePing(data);
                return;
            }
            throw new WebSocketException("PING must not fragment across frames");
        } else if (this.pendingBuilder != null && opcode != 0) {
            throw new WebSocketException("Failed to continue outstanding frame");
        } else if (this.pendingBuilder == null && opcode == 0) {
            throw new WebSocketException("Received continuing frame, but there's nothing to continue");
        } else {
            if (this.pendingBuilder == null) {
                this.pendingBuilder = MessageBuilderFactory.builder(opcode);
            }
            if (!this.pendingBuilder.appendBytes(data)) {
                throw new WebSocketException("Failed to decode frame");
            } else if (fin) {
                WebSocketMessage message = this.pendingBuilder.toMessage();
                this.pendingBuilder = null;
                if (message != null) {
                    this.eventHandler.onMessage(message);
                    return;
                }
                throw new WebSocketException("Failed to decode whole message");
            }
        }
    }

    private void handlePing(byte[] payload) {
        if (payload.length <= 125) {
            this.websocket.pong(payload);
            return;
        }
        throw new WebSocketException("PING frame too long");
    }

    private long parseLong(byte[] buffer, int offset) {
        return (((long) buffer[offset + 0]) << 56) + (((long) (buffer[offset + 1] & 255)) << 48) + (((long) (buffer[offset + 2] & 255)) << 40) + (((long) (buffer[offset + 3] & 255)) << 32) + (((long) (buffer[offset + 4] & 255)) << 24) + ((long) ((buffer[offset + 5] & 255) << 16)) + ((long) ((buffer[offset + 6] & 255) << 8)) + ((long) ((buffer[offset + 7] & 255) << 0));
    }

    private int read(byte[] buffer, int offset, int length) throws IOException {
        this.input.readFully(buffer, offset, length);
        return length;
    }

    /* access modifiers changed from: 0000 */
    public void stopit() {
        this.stop = true;
    }

    /* access modifiers changed from: 0000 */
    public boolean isRunning() {
        return !this.stop;
    }

    private void handleError(WebSocketException e) {
        stopit();
        this.websocket.handleReceiverError(e);
    }
}
