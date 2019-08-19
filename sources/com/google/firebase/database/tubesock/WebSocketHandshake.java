package com.google.firebase.database.tubesock;

import android.util.Base64;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
class WebSocketHandshake {
    private static final String WEBSOCKET_VERSION = "13";
    private Map<String, String> extraHeaders = null;
    private String nonce = null;
    private String protocol = null;
    private URI url = null;

    public WebSocketHandshake(URI url2, String protocol2, Map<String, String> extraHeaders2) {
        this.url = url2;
        this.protocol = protocol2;
        this.extraHeaders = extraHeaders2;
        this.nonce = createNonce();
    }

    public byte[] getHandshake() {
        String str;
        String path = this.url.getPath();
        String query = this.url.getQuery();
        StringBuilder sb = new StringBuilder();
        sb.append(path);
        if (query == null) {
            str = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("?");
            sb2.append(query);
            str = sb2.toString();
        }
        sb.append(str);
        String path2 = sb.toString();
        String host = this.url.getHost();
        if (this.url.getPort() != -1) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(host);
            sb3.append(":");
            sb3.append(this.url.getPort());
            host = sb3.toString();
        }
        LinkedHashMap<String, String> header = new LinkedHashMap<>();
        header.put("Host", host);
        String str2 = "Upgrade";
        header.put(str2, "websocket");
        header.put("Connection", str2);
        header.put("Sec-WebSocket-Version", WEBSOCKET_VERSION);
        header.put("Sec-WebSocket-Key", this.nonce);
        String str3 = this.protocol;
        if (str3 != null) {
            header.put("Sec-WebSocket-Protocol", str3);
        }
        Map<String, String> map = this.extraHeaders;
        if (map != null) {
            for (String fieldName : map.keySet()) {
                if (!header.containsKey(fieldName)) {
                    header.put(fieldName, (String) this.extraHeaders.get(fieldName));
                }
            }
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append("GET ");
        sb4.append(path2);
        sb4.append(" HTTP/1.1\r\n");
        String handshake = sb4.toString();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(handshake);
        sb5.append(generateHeader(header));
        String handshake2 = sb5.toString();
        StringBuilder sb6 = new StringBuilder();
        sb6.append(handshake2);
        sb6.append("\r\n");
        byte[] tmpHandShakeBytes = sb6.toString().getBytes(Charset.defaultCharset());
        byte[] handshakeBytes = new byte[tmpHandShakeBytes.length];
        System.arraycopy(tmpHandShakeBytes, 0, handshakeBytes, 0, tmpHandShakeBytes.length);
        return handshakeBytes;
    }

    private String generateHeader(LinkedHashMap<String, String> headers) {
        String header = new String();
        for (String fieldName : headers.keySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(header);
            sb.append(fieldName);
            sb.append(": ");
            sb.append((String) headers.get(fieldName));
            sb.append("\r\n");
            header = sb.toString();
        }
        return header;
    }

    private String createNonce() {
        byte[] nonce2 = new byte[16];
        for (int i = 0; i < 16; i++) {
            nonce2[i] = (byte) rand(0, 255);
        }
        return Base64.encodeToString(nonce2, 2);
    }

    public void verifyServerStatusLine(String statusLine) {
        int statusCode = Integer.parseInt(statusLine.substring(9, 12));
        if (statusCode == 407) {
            throw new WebSocketException("connection failed: proxy authentication not supported");
        } else if (statusCode == 404) {
            throw new WebSocketException("connection failed: 404 not found");
        } else if (statusCode != 101) {
            StringBuilder sb = new StringBuilder();
            sb.append("connection failed: unknown status code ");
            sb.append(statusCode);
            throw new WebSocketException(sb.toString());
        }
    }

    public void verifyServerHandshakeHeaders(HashMap<String, String> headers) {
        if (!((String) headers.get("Upgrade")).toLowerCase(Locale.US).equals("websocket")) {
            throw new WebSocketException("connection failed: missing header field in server handshake: Upgrade");
        } else if (!((String) headers.get("Connection")).toLowerCase(Locale.US).equals("upgrade")) {
            throw new WebSocketException("connection failed: missing header field in server handshake: Connection");
        }
    }

    private int rand(int min, int max) {
        double random = Math.random();
        double d = (double) max;
        Double.isNaN(d);
        double d2 = random * d;
        double d3 = (double) min;
        Double.isNaN(d3);
        return (int) (d2 + d3);
    }
}
