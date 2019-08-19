package mehdi.sakout.fancybuttons;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Utils {
    private static Map<String, Typeface> cachedFontMap = new HashMap();

    public static int pxToSp(Context context, float px) {
        return Math.round(px / context.getResources().getDisplayMetrics().scaledDensity);
    }

    public static int spToPx(Context context, float sp) {
        return Math.round(context.getResources().getDisplayMetrics().scaledDensity * sp);
    }

    public static Typeface findFont(Context context, String fontPath, String defaultFontPath) {
        String str = "";
        if (fontPath == null) {
            return Typeface.DEFAULT;
        }
        String fontName = new File(fontPath).getName();
        String defaultFontName = "";
        if (!TextUtils.isEmpty(defaultFontPath)) {
            defaultFontName = new File(defaultFontPath).getName();
        }
        if (cachedFontMap.containsKey(fontName)) {
            return (Typeface) cachedFontMap.get(fontName);
        }
        try {
            AssetManager assets = context.getResources().getAssets();
            if (Arrays.asList(assets.list(str)).contains(fontPath)) {
                Typeface typeface = Typeface.createFromAsset(context.getAssets(), fontName);
                cachedFontMap.put(fontName, typeface);
                return typeface;
            } else if (Arrays.asList(assets.list("fonts")).contains(fontName)) {
                Typeface typeface2 = Typeface.createFromAsset(context.getAssets(), String.format("fonts/%s", new Object[]{fontName}));
                cachedFontMap.put(fontName, typeface2);
                return typeface2;
            } else if (Arrays.asList(assets.list("iconfonts")).contains(fontName)) {
                Typeface typeface3 = Typeface.createFromAsset(context.getAssets(), String.format("iconfonts/%s", new Object[]{fontName}));
                cachedFontMap.put(fontName, typeface3);
                return typeface3;
            } else if (TextUtils.isEmpty(defaultFontPath) || !Arrays.asList(assets.list(str)).contains(defaultFontPath)) {
                throw new Exception("Font not Found");
            } else {
                Typeface typeface4 = Typeface.createFromAsset(context.getAssets(), defaultFontPath);
                cachedFontMap.put(defaultFontName, typeface4);
                return typeface4;
            }
        } catch (Exception e) {
            Log.e(FancyButton.TAG, String.format("Unable to find %s font. Using Typeface.DEFAULT instead.", new Object[]{fontName}));
            cachedFontMap.put(fontName, Typeface.DEFAULT);
            return Typeface.DEFAULT;
        }
    }
}
