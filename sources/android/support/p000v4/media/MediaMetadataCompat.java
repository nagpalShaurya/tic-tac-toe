package android.support.p000v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.p000v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Set;

/* renamed from: android.support.v4.media.MediaMetadataCompat */
public final class MediaMetadataCompat implements Parcelable {
    public static final Creator<MediaMetadataCompat> CREATOR = new Creator<MediaMetadataCompat>() {
        public MediaMetadataCompat createFromParcel(Parcel in) {
            return new MediaMetadataCompat(in);
        }

        public MediaMetadataCompat[] newArray(int size) {
            return new MediaMetadataCompat[size];
        }
    };
    static final ArrayMap<String, Integer> METADATA_KEYS_TYPE = new ArrayMap<>();
    public static final String METADATA_KEY_ADVERTISEMENT = "android.media.metadata.ADVERTISEMENT";
    public static final String METADATA_KEY_ALBUM = "android.media.metadata.ALBUM";
    public static final String METADATA_KEY_ALBUM_ART = "android.media.metadata.ALBUM_ART";
    public static final String METADATA_KEY_ALBUM_ARTIST = "android.media.metadata.ALBUM_ARTIST";
    public static final String METADATA_KEY_ALBUM_ART_URI = "android.media.metadata.ALBUM_ART_URI";
    public static final String METADATA_KEY_ART = "android.media.metadata.ART";
    public static final String METADATA_KEY_ARTIST = "android.media.metadata.ARTIST";
    public static final String METADATA_KEY_ART_URI = "android.media.metadata.ART_URI";
    public static final String METADATA_KEY_AUTHOR = "android.media.metadata.AUTHOR";
    public static final String METADATA_KEY_BT_FOLDER_TYPE = "android.media.metadata.BT_FOLDER_TYPE";
    public static final String METADATA_KEY_COMPILATION = "android.media.metadata.COMPILATION";
    public static final String METADATA_KEY_COMPOSER = "android.media.metadata.COMPOSER";
    public static final String METADATA_KEY_DATE = "android.media.metadata.DATE";
    public static final String METADATA_KEY_DISC_NUMBER = "android.media.metadata.DISC_NUMBER";
    public static final String METADATA_KEY_DISPLAY_DESCRIPTION = "android.media.metadata.DISPLAY_DESCRIPTION";
    public static final String METADATA_KEY_DISPLAY_ICON = "android.media.metadata.DISPLAY_ICON";
    public static final String METADATA_KEY_DISPLAY_ICON_URI = "android.media.metadata.DISPLAY_ICON_URI";
    public static final String METADATA_KEY_DISPLAY_SUBTITLE = "android.media.metadata.DISPLAY_SUBTITLE";
    public static final String METADATA_KEY_DISPLAY_TITLE = "android.media.metadata.DISPLAY_TITLE";
    public static final String METADATA_KEY_DOWNLOAD_STATUS = "android.media.metadata.DOWNLOAD_STATUS";
    public static final String METADATA_KEY_DURATION = "android.media.metadata.DURATION";
    public static final String METADATA_KEY_GENRE = "android.media.metadata.GENRE";
    public static final String METADATA_KEY_MEDIA_ID = "android.media.metadata.MEDIA_ID";
    public static final String METADATA_KEY_MEDIA_URI = "android.media.metadata.MEDIA_URI";
    public static final String METADATA_KEY_NUM_TRACKS = "android.media.metadata.NUM_TRACKS";
    public static final String METADATA_KEY_RATING = "android.media.metadata.RATING";
    public static final String METADATA_KEY_TITLE = "android.media.metadata.TITLE";
    public static final String METADATA_KEY_TRACK_NUMBER = "android.media.metadata.TRACK_NUMBER";
    public static final String METADATA_KEY_USER_RATING = "android.media.metadata.USER_RATING";
    public static final String METADATA_KEY_WRITER = "android.media.metadata.WRITER";
    public static final String METADATA_KEY_YEAR = "android.media.metadata.YEAR";
    static final int METADATA_TYPE_BITMAP = 2;
    static final int METADATA_TYPE_LONG = 0;
    static final int METADATA_TYPE_RATING = 3;
    static final int METADATA_TYPE_TEXT = 1;
    private static final String[] PREFERRED_BITMAP_ORDER;
    private static final String[] PREFERRED_DESCRIPTION_ORDER;
    private static final String[] PREFERRED_URI_ORDER;
    private static final String TAG = "MediaMetadata";
    final Bundle mBundle;
    private MediaDescriptionCompat mDescription;
    private Object mMetadataObj;

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.media.MediaMetadataCompat$BitmapKey */
    public @interface BitmapKey {
    }

    /* renamed from: android.support.v4.media.MediaMetadataCompat$Builder */
    public static final class Builder {
        private final Bundle mBundle;

        public Builder() {
            this.mBundle = new Bundle();
        }

        public Builder(MediaMetadataCompat source) {
            this.mBundle = new Bundle(source.mBundle);
        }

        @RestrictTo({Scope.LIBRARY_GROUP})
        public Builder(MediaMetadataCompat source, int maxBitmapSize) {
            this(source);
            for (String key : this.mBundle.keySet()) {
                Object value = this.mBundle.get(key);
                if (value instanceof Bitmap) {
                    Bitmap bmp = (Bitmap) value;
                    if (bmp.getHeight() > maxBitmapSize || bmp.getWidth() > maxBitmapSize) {
                        putBitmap(key, scaleBitmap(bmp, maxBitmapSize));
                    }
                }
            }
        }

        public Builder putText(String key, CharSequence value) {
            if (!MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(key) || ((Integer) MediaMetadataCompat.METADATA_KEYS_TYPE.get(key)).intValue() == 1) {
                this.mBundle.putCharSequence(key, value);
                return this;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("The ");
            sb.append(key);
            sb.append(" key cannot be used to put a CharSequence");
            throw new IllegalArgumentException(sb.toString());
        }

        public Builder putString(String key, String value) {
            if (!MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(key) || ((Integer) MediaMetadataCompat.METADATA_KEYS_TYPE.get(key)).intValue() == 1) {
                this.mBundle.putCharSequence(key, value);
                return this;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("The ");
            sb.append(key);
            sb.append(" key cannot be used to put a String");
            throw new IllegalArgumentException(sb.toString());
        }

        public Builder putLong(String key, long value) {
            if (!MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(key) || ((Integer) MediaMetadataCompat.METADATA_KEYS_TYPE.get(key)).intValue() == 0) {
                this.mBundle.putLong(key, value);
                return this;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("The ");
            sb.append(key);
            sb.append(" key cannot be used to put a long");
            throw new IllegalArgumentException(sb.toString());
        }

        public Builder putRating(String key, RatingCompat value) {
            if (!MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(key) || ((Integer) MediaMetadataCompat.METADATA_KEYS_TYPE.get(key)).intValue() == 3) {
                if (VERSION.SDK_INT >= 19) {
                    this.mBundle.putParcelable(key, (Parcelable) value.getRating());
                } else {
                    this.mBundle.putParcelable(key, value);
                }
                return this;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("The ");
            sb.append(key);
            sb.append(" key cannot be used to put a Rating");
            throw new IllegalArgumentException(sb.toString());
        }

        public Builder putBitmap(String key, Bitmap value) {
            if (!MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(key) || ((Integer) MediaMetadataCompat.METADATA_KEYS_TYPE.get(key)).intValue() == 2) {
                this.mBundle.putParcelable(key, value);
                return this;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("The ");
            sb.append(key);
            sb.append(" key cannot be used to put a Bitmap");
            throw new IllegalArgumentException(sb.toString());
        }

        public MediaMetadataCompat build() {
            return new MediaMetadataCompat(this.mBundle);
        }

        private Bitmap scaleBitmap(Bitmap bmp, int maxSize) {
            float maxSizeF = (float) maxSize;
            float scale = Math.min(maxSizeF / ((float) bmp.getWidth()), maxSizeF / ((float) bmp.getHeight()));
            return Bitmap.createScaledBitmap(bmp, (int) (((float) bmp.getWidth()) * scale), (int) (((float) bmp.getHeight()) * scale), true);
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.media.MediaMetadataCompat$LongKey */
    public @interface LongKey {
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.media.MediaMetadataCompat$RatingKey */
    public @interface RatingKey {
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.media.MediaMetadataCompat$TextKey */
    public @interface TextKey {
    }

    static {
        ArrayMap<String, Integer> arrayMap = METADATA_KEYS_TYPE;
        Integer valueOf = Integer.valueOf(1);
        String str = METADATA_KEY_TITLE;
        arrayMap.put(str, valueOf);
        ArrayMap<String, Integer> arrayMap2 = METADATA_KEYS_TYPE;
        String str2 = METADATA_KEY_ARTIST;
        arrayMap2.put(str2, valueOf);
        ArrayMap<String, Integer> arrayMap3 = METADATA_KEYS_TYPE;
        Integer valueOf2 = Integer.valueOf(0);
        arrayMap3.put(METADATA_KEY_DURATION, valueOf2);
        ArrayMap<String, Integer> arrayMap4 = METADATA_KEYS_TYPE;
        String str3 = METADATA_KEY_ALBUM;
        arrayMap4.put(str3, valueOf);
        ArrayMap<String, Integer> arrayMap5 = METADATA_KEYS_TYPE;
        String str4 = METADATA_KEY_AUTHOR;
        arrayMap5.put(str4, valueOf);
        ArrayMap<String, Integer> arrayMap6 = METADATA_KEYS_TYPE;
        String str5 = METADATA_KEY_WRITER;
        arrayMap6.put(str5, valueOf);
        ArrayMap<String, Integer> arrayMap7 = METADATA_KEYS_TYPE;
        String str6 = METADATA_KEY_COMPOSER;
        arrayMap7.put(str6, valueOf);
        METADATA_KEYS_TYPE.put(METADATA_KEY_COMPILATION, valueOf);
        METADATA_KEYS_TYPE.put(METADATA_KEY_DATE, valueOf);
        METADATA_KEYS_TYPE.put(METADATA_KEY_YEAR, valueOf2);
        METADATA_KEYS_TYPE.put(METADATA_KEY_GENRE, valueOf);
        METADATA_KEYS_TYPE.put(METADATA_KEY_TRACK_NUMBER, valueOf2);
        METADATA_KEYS_TYPE.put(METADATA_KEY_NUM_TRACKS, valueOf2);
        METADATA_KEYS_TYPE.put(METADATA_KEY_DISC_NUMBER, valueOf2);
        ArrayMap<String, Integer> arrayMap8 = METADATA_KEYS_TYPE;
        String str7 = METADATA_KEY_ALBUM_ARTIST;
        arrayMap8.put(str7, valueOf);
        ArrayMap<String, Integer> arrayMap9 = METADATA_KEYS_TYPE;
        Integer valueOf3 = Integer.valueOf(2);
        String str8 = METADATA_KEY_ART;
        arrayMap9.put(str8, valueOf3);
        ArrayMap<String, Integer> arrayMap10 = METADATA_KEYS_TYPE;
        String str9 = METADATA_KEY_ART_URI;
        arrayMap10.put(str9, valueOf);
        ArrayMap<String, Integer> arrayMap11 = METADATA_KEYS_TYPE;
        String str10 = METADATA_KEY_ALBUM_ART;
        arrayMap11.put(str10, valueOf3);
        ArrayMap<String, Integer> arrayMap12 = METADATA_KEYS_TYPE;
        String str11 = METADATA_KEY_ALBUM_ART_URI;
        arrayMap12.put(str11, valueOf);
        ArrayMap<String, Integer> arrayMap13 = METADATA_KEYS_TYPE;
        String str12 = str11;
        Integer valueOf4 = Integer.valueOf(3);
        arrayMap13.put(METADATA_KEY_USER_RATING, valueOf4);
        METADATA_KEYS_TYPE.put(METADATA_KEY_RATING, valueOf4);
        METADATA_KEYS_TYPE.put(METADATA_KEY_DISPLAY_TITLE, valueOf);
        METADATA_KEYS_TYPE.put(METADATA_KEY_DISPLAY_SUBTITLE, valueOf);
        METADATA_KEYS_TYPE.put(METADATA_KEY_DISPLAY_DESCRIPTION, valueOf);
        METADATA_KEYS_TYPE.put(METADATA_KEY_DISPLAY_ICON, valueOf3);
        METADATA_KEYS_TYPE.put(METADATA_KEY_DISPLAY_ICON_URI, valueOf);
        METADATA_KEYS_TYPE.put(METADATA_KEY_MEDIA_ID, valueOf);
        METADATA_KEYS_TYPE.put(METADATA_KEY_BT_FOLDER_TYPE, valueOf2);
        METADATA_KEYS_TYPE.put(METADATA_KEY_MEDIA_URI, valueOf);
        METADATA_KEYS_TYPE.put(METADATA_KEY_ADVERTISEMENT, valueOf2);
        METADATA_KEYS_TYPE.put(METADATA_KEY_DOWNLOAD_STATUS, valueOf2);
        PREFERRED_DESCRIPTION_ORDER = new String[]{str, str2, str3, str7, str5, str4, str6};
        PREFERRED_BITMAP_ORDER = new String[]{METADATA_KEY_DISPLAY_ICON, str8, str10};
        PREFERRED_URI_ORDER = new String[]{METADATA_KEY_DISPLAY_ICON_URI, str9, str12};
    }

    MediaMetadataCompat(Bundle bundle) {
        this.mBundle = new Bundle(bundle);
    }

    MediaMetadataCompat(Parcel in) {
        this.mBundle = in.readBundle();
    }

    public boolean containsKey(String key) {
        return this.mBundle.containsKey(key);
    }

    public CharSequence getText(String key) {
        return this.mBundle.getCharSequence(key);
    }

    public String getString(String key) {
        CharSequence text = this.mBundle.getCharSequence(key);
        if (text != null) {
            return text.toString();
        }
        return null;
    }

    public long getLong(String key) {
        return this.mBundle.getLong(key, 0);
    }

    public RatingCompat getRating(String key) {
        try {
            if (VERSION.SDK_INT >= 19) {
                return RatingCompat.fromRating(this.mBundle.getParcelable(key));
            }
            return (RatingCompat) this.mBundle.getParcelable(key);
        } catch (Exception e) {
            Log.w(TAG, "Failed to retrieve a key as Rating.", e);
            return null;
        }
    }

    public Bitmap getBitmap(String key) {
        try {
            return (Bitmap) this.mBundle.getParcelable(key);
        } catch (Exception e) {
            Log.w(TAG, "Failed to retrieve a key as Bitmap.", e);
            return null;
        }
    }

    public MediaDescriptionCompat getDescription() {
        MediaDescriptionCompat mediaDescriptionCompat = this.mDescription;
        if (mediaDescriptionCompat != null) {
            return mediaDescriptionCompat;
        }
        String mediaId = getString(METADATA_KEY_MEDIA_ID);
        CharSequence[] text = new CharSequence[3];
        Bitmap icon = null;
        Uri iconUri = null;
        CharSequence displayText = getText(METADATA_KEY_DISPLAY_TITLE);
        if (TextUtils.isEmpty(displayText)) {
            int textIndex = 0;
            int keyIndex = 0;
            while (textIndex < text.length) {
                String[] strArr = PREFERRED_DESCRIPTION_ORDER;
                if (keyIndex >= strArr.length) {
                    break;
                }
                int keyIndex2 = keyIndex + 1;
                CharSequence next = getText(strArr[keyIndex]);
                if (!TextUtils.isEmpty(next)) {
                    int textIndex2 = textIndex + 1;
                    text[textIndex] = next;
                    textIndex = textIndex2;
                }
                keyIndex = keyIndex2;
            }
        } else {
            text[0] = displayText;
            text[1] = getText(METADATA_KEY_DISPLAY_SUBTITLE);
            text[2] = getText(METADATA_KEY_DISPLAY_DESCRIPTION);
        }
        int i = 0;
        while (true) {
            String[] strArr2 = PREFERRED_BITMAP_ORDER;
            if (i >= strArr2.length) {
                break;
            }
            Bitmap next2 = getBitmap(strArr2[i]);
            if (next2 != null) {
                icon = next2;
                break;
            }
            i++;
        }
        int i2 = 0;
        while (true) {
            String[] strArr3 = PREFERRED_URI_ORDER;
            if (i2 >= strArr3.length) {
                break;
            }
            String next3 = getString(strArr3[i2]);
            if (!TextUtils.isEmpty(next3)) {
                iconUri = Uri.parse(next3);
                break;
            }
            i2++;
        }
        Uri mediaUri = null;
        String mediaUriStr = getString(METADATA_KEY_MEDIA_URI);
        if (!TextUtils.isEmpty(mediaUriStr)) {
            mediaUri = Uri.parse(mediaUriStr);
        }
        android.support.p000v4.media.MediaDescriptionCompat.Builder bob = new android.support.p000v4.media.MediaDescriptionCompat.Builder();
        bob.setMediaId(mediaId);
        bob.setTitle(text[0]);
        bob.setSubtitle(text[1]);
        bob.setDescription(text[2]);
        bob.setIconBitmap(icon);
        bob.setIconUri(iconUri);
        bob.setMediaUri(mediaUri);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.mBundle;
        String str = METADATA_KEY_BT_FOLDER_TYPE;
        if (bundle2.containsKey(str)) {
            bundle.putLong(MediaDescriptionCompat.EXTRA_BT_FOLDER_TYPE, getLong(str));
        }
        Bundle bundle3 = this.mBundle;
        String str2 = METADATA_KEY_DOWNLOAD_STATUS;
        if (bundle3.containsKey(str2)) {
            bundle.putLong(MediaDescriptionCompat.EXTRA_DOWNLOAD_STATUS, getLong(str2));
        }
        if (!bundle.isEmpty()) {
            bob.setExtras(bundle);
        }
        this.mDescription = bob.build();
        return this.mDescription;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeBundle(this.mBundle);
    }

    public int size() {
        return this.mBundle.size();
    }

    public Set<String> keySet() {
        return this.mBundle.keySet();
    }

    public Bundle getBundle() {
        return this.mBundle;
    }

    public static MediaMetadataCompat fromMediaMetadata(Object metadataObj) {
        if (metadataObj == null || VERSION.SDK_INT < 21) {
            return null;
        }
        Parcel p = Parcel.obtain();
        MediaMetadataCompatApi21.writeToParcel(metadataObj, p, 0);
        p.setDataPosition(0);
        MediaMetadataCompat metadata = (MediaMetadataCompat) CREATOR.createFromParcel(p);
        p.recycle();
        metadata.mMetadataObj = metadataObj;
        return metadata;
    }

    public Object getMediaMetadata() {
        if (this.mMetadataObj == null && VERSION.SDK_INT >= 21) {
            Parcel p = Parcel.obtain();
            writeToParcel(p, 0);
            p.setDataPosition(0);
            this.mMetadataObj = MediaMetadataCompatApi21.createFromParcel(p);
            p.recycle();
        }
        return this.mMetadataObj;
    }
}
