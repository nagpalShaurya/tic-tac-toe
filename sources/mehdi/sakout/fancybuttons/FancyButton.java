package mehdi.sakout.fancybuttons;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.support.p000v4.view.GravityCompat;
import android.support.p000v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;

public class FancyButton extends LinearLayout {
    public static final int POSITION_BOTTOM = 4;
    public static final int POSITION_LEFT = 1;
    public static final int POSITION_RIGHT = 2;
    public static final int POSITION_TOP = 3;
    public static final String TAG = FancyButton.class.getSimpleName();
    private int mBorderColor = 0;
    private int mBorderWidth = 0;
    private Context mContext;
    private int mDefaultBackgroundColor = ViewCompat.MEASURED_STATE_MASK;
    private int mDefaultIconColor = -1;
    private String mDefaultIconFont = "fontawesome.ttf";
    private int mDefaultTextColor = -1;
    private String mDefaultTextFont = "robotoregular.ttf";
    private int mDefaultTextGravity = 17;
    private int mDefaultTextSize = Utils.spToPx(getContext(), 15.0f);
    private int mDisabledBackgroundColor = Color.parseColor("#f6f7f9");
    private int mDisabledBorderColor = Color.parseColor("#dddfe2");
    private int mDisabledTextColor = Color.parseColor("#bec2c9");
    private boolean mEnabled = true;
    private int mFocusBackgroundColor = 0;
    private String mFontIcon = null;
    private int mFontIconSize = Utils.spToPx(getContext(), 15.0f);
    private TextView mFontIconView;
    private boolean mGhost = false;
    private int mIconPaddingBottom = 0;
    private int mIconPaddingLeft = 10;
    private int mIconPaddingRight = 10;
    private int mIconPaddingTop = 0;
    private int mIconPosition = 1;
    private Drawable mIconResource = null;
    private Typeface mIconTypeFace = null;
    private ImageView mIconView;
    /* access modifiers changed from: private */
    public int mRadius = 0;
    private int mRadiusBottomLeft = 0;
    private int mRadiusBottomRight = 0;
    private int mRadiusTopLeft = 0;
    private int mRadiusTopRight = 0;
    private String mText = null;
    private boolean mTextAllCaps = false;
    private int mTextPosition = 1;
    private Typeface mTextTypeFace = null;
    private TextView mTextView;
    private boolean mUseRippleEffect = true;
    private boolean mUseSystemFont = false;

    @TargetApi(21)
    private class CustomOutline extends ViewOutlineProvider {
        int height;
        int width;

        CustomOutline(int width2, int height2) {
            this.width = width2;
            this.height = height2;
        }

        public void getOutline(View view, Outline outline) {
            if (FancyButton.this.mRadius == 0) {
                outline.setRect(0, 10, this.width, this.height);
                return;
            }
            outline.setRoundRect(0, 10, this.width, this.height, (float) FancyButton.this.mRadius);
        }
    }

    public FancyButton(Context context) {
        super(context);
        this.mContext = context;
        this.mTextTypeFace = Utils.findFont(this.mContext, this.mDefaultTextFont, null);
        this.mIconTypeFace = Utils.findFont(this.mContext, this.mDefaultIconFont, null);
        initializeFancyButton();
    }

    public FancyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        TypedArray attrsArray = context.obtainStyledAttributes(attrs, C0525R.styleable.FancyButtonsAttrs, 0, 0);
        initAttributesArray(attrsArray);
        attrsArray.recycle();
        initializeFancyButton();
    }

    private void initializeFancyButton() {
        initializeButtonContainer();
        this.mTextView = setupTextView();
        this.mIconView = setupIconView();
        this.mFontIconView = setupFontIconView();
        removeAllViews();
        setupBackground();
        ArrayList<View> views = new ArrayList<>();
        int i = this.mIconPosition;
        if (i == 1 || i == 3) {
            ImageView imageView = this.mIconView;
            if (imageView != null) {
                views.add(imageView);
            }
            TextView textView = this.mFontIconView;
            if (textView != null) {
                views.add(textView);
            }
            TextView textView2 = this.mTextView;
            if (textView2 != null) {
                views.add(textView2);
            }
        } else {
            TextView textView3 = this.mTextView;
            if (textView3 != null) {
                views.add(textView3);
            }
            ImageView imageView2 = this.mIconView;
            if (imageView2 != null) {
                views.add(imageView2);
            }
            TextView textView4 = this.mFontIconView;
            if (textView4 != null) {
                views.add(textView4);
            }
        }
        Iterator it = views.iterator();
        while (it.hasNext()) {
            addView((View) it.next());
        }
    }

    private TextView setupTextView() {
        if (this.mText == null) {
            this.mText = "Fancy Button";
        }
        TextView textView = new TextView(this.mContext);
        textView.setText(this.mText);
        textView.setGravity(this.mDefaultTextGravity);
        textView.setTextColor(this.mEnabled ? this.mDefaultTextColor : this.mDisabledTextColor);
        textView.setTextSize((float) Utils.pxToSp(getContext(), (float) this.mDefaultTextSize));
        textView.setLayoutParams(new LayoutParams(-2, -2));
        if (!isInEditMode() && !this.mUseSystemFont) {
            textView.setTypeface(this.mTextTypeFace);
        }
        return textView;
    }

    private TextView setupFontIconView() {
        if (this.mFontIcon == null) {
            return null;
        }
        TextView fontIconView = new TextView(this.mContext);
        fontIconView.setTextColor(this.mEnabled ? this.mDefaultIconColor : this.mDisabledTextColor);
        LayoutParams iconTextViewParams = new LayoutParams(-2, -2);
        iconTextViewParams.rightMargin = this.mIconPaddingRight;
        iconTextViewParams.leftMargin = this.mIconPaddingLeft;
        iconTextViewParams.topMargin = this.mIconPaddingTop;
        iconTextViewParams.bottomMargin = this.mIconPaddingBottom;
        if (this.mTextView != null) {
            int i = this.mIconPosition;
            if (i == 3 || i == 4) {
                iconTextViewParams.gravity = 17;
                fontIconView.setGravity(17);
            } else {
                fontIconView.setGravity(16);
                iconTextViewParams.gravity = 16;
            }
        } else {
            iconTextViewParams.gravity = 17;
            fontIconView.setGravity(16);
        }
        fontIconView.setLayoutParams(iconTextViewParams);
        if (!isInEditMode()) {
            fontIconView.setTextSize((float) Utils.pxToSp(getContext(), (float) this.mFontIconSize));
            fontIconView.setText(this.mFontIcon);
            fontIconView.setTypeface(this.mIconTypeFace);
        } else {
            fontIconView.setTextSize((float) Utils.pxToSp(getContext(), (float) this.mFontIconSize));
            fontIconView.setText("O");
        }
        return fontIconView;
    }

    private ImageView setupIconView() {
        if (this.mIconResource == null) {
            return null;
        }
        ImageView iconView = new ImageView(this.mContext);
        iconView.setImageDrawable(this.mIconResource);
        iconView.setPadding(this.mIconPaddingLeft, this.mIconPaddingTop, this.mIconPaddingRight, this.mIconPaddingBottom);
        LayoutParams iconViewParams = new LayoutParams(-2, -2);
        if (this.mTextView != null) {
            int i = this.mIconPosition;
            if (i == 3 || i == 4) {
                iconViewParams.gravity = 17;
            } else {
                iconViewParams.gravity = GravityCompat.START;
            }
            iconViewParams.rightMargin = 10;
            iconViewParams.leftMargin = 10;
        } else {
            iconViewParams.gravity = 16;
        }
        iconView.setLayoutParams(iconViewParams);
        return iconView;
    }

    private void initAttributesArray(TypedArray attrsArray) {
        this.mDefaultBackgroundColor = attrsArray.getColor(C0525R.styleable.FancyButtonsAttrs_fb_defaultColor, this.mDefaultBackgroundColor);
        this.mFocusBackgroundColor = attrsArray.getColor(C0525R.styleable.FancyButtonsAttrs_fb_focusColor, this.mFocusBackgroundColor);
        this.mDisabledBackgroundColor = attrsArray.getColor(C0525R.styleable.FancyButtonsAttrs_fb_disabledColor, this.mDisabledBackgroundColor);
        this.mEnabled = attrsArray.getBoolean(C0525R.styleable.FancyButtonsAttrs_android_enabled, true);
        this.mDisabledTextColor = attrsArray.getColor(C0525R.styleable.FancyButtonsAttrs_fb_disabledTextColor, this.mDisabledTextColor);
        this.mDisabledBorderColor = attrsArray.getColor(C0525R.styleable.FancyButtonsAttrs_fb_disabledBorderColor, this.mDisabledBorderColor);
        this.mDefaultTextColor = attrsArray.getColor(C0525R.styleable.FancyButtonsAttrs_fb_textColor, this.mDefaultTextColor);
        this.mDefaultIconColor = attrsArray.getColor(C0525R.styleable.FancyButtonsAttrs_fb_iconColor, this.mDefaultTextColor);
        this.mDefaultTextSize = (int) attrsArray.getDimension(C0525R.styleable.FancyButtonsAttrs_fb_textSize, (float) this.mDefaultTextSize);
        this.mDefaultTextSize = (int) attrsArray.getDimension(C0525R.styleable.FancyButtonsAttrs_android_textSize, (float) this.mDefaultTextSize);
        this.mDefaultTextGravity = attrsArray.getInt(C0525R.styleable.FancyButtonsAttrs_fb_textGravity, this.mDefaultTextGravity);
        this.mBorderColor = attrsArray.getColor(C0525R.styleable.FancyButtonsAttrs_fb_borderColor, this.mBorderColor);
        this.mBorderWidth = (int) attrsArray.getDimension(C0525R.styleable.FancyButtonsAttrs_fb_borderWidth, (float) this.mBorderWidth);
        this.mRadius = (int) attrsArray.getDimension(C0525R.styleable.FancyButtonsAttrs_fb_radius, (float) this.mRadius);
        this.mRadiusTopLeft = (int) attrsArray.getDimension(C0525R.styleable.FancyButtonsAttrs_fb_radiusTopLeft, (float) this.mRadius);
        this.mRadiusTopRight = (int) attrsArray.getDimension(C0525R.styleable.FancyButtonsAttrs_fb_radiusTopRight, (float) this.mRadius);
        this.mRadiusBottomLeft = (int) attrsArray.getDimension(C0525R.styleable.FancyButtonsAttrs_fb_radiusBottomLeft, (float) this.mRadius);
        this.mRadiusBottomRight = (int) attrsArray.getDimension(C0525R.styleable.FancyButtonsAttrs_fb_radiusBottomRight, (float) this.mRadius);
        this.mFontIconSize = (int) attrsArray.getDimension(C0525R.styleable.FancyButtonsAttrs_fb_fontIconSize, (float) this.mFontIconSize);
        this.mIconPaddingLeft = (int) attrsArray.getDimension(C0525R.styleable.FancyButtonsAttrs_fb_iconPaddingLeft, (float) this.mIconPaddingLeft);
        this.mIconPaddingRight = (int) attrsArray.getDimension(C0525R.styleable.FancyButtonsAttrs_fb_iconPaddingRight, (float) this.mIconPaddingRight);
        this.mIconPaddingTop = (int) attrsArray.getDimension(C0525R.styleable.FancyButtonsAttrs_fb_iconPaddingTop, (float) this.mIconPaddingTop);
        this.mIconPaddingBottom = (int) attrsArray.getDimension(C0525R.styleable.FancyButtonsAttrs_fb_iconPaddingBottom, (float) this.mIconPaddingBottom);
        this.mTextAllCaps = attrsArray.getBoolean(C0525R.styleable.FancyButtonsAttrs_fb_textAllCaps, false);
        this.mTextAllCaps = attrsArray.getBoolean(C0525R.styleable.FancyButtonsAttrs_android_textAllCaps, false);
        this.mGhost = attrsArray.getBoolean(C0525R.styleable.FancyButtonsAttrs_fb_ghost, this.mGhost);
        this.mUseSystemFont = attrsArray.getBoolean(C0525R.styleable.FancyButtonsAttrs_fb_useSystemFont, this.mUseSystemFont);
        String text = attrsArray.getString(C0525R.styleable.FancyButtonsAttrs_fb_text);
        if (text == null) {
            text = attrsArray.getString(C0525R.styleable.FancyButtonsAttrs_android_text);
        }
        this.mIconPosition = attrsArray.getInt(C0525R.styleable.FancyButtonsAttrs_fb_iconPosition, this.mIconPosition);
        String fontIcon = attrsArray.getString(C0525R.styleable.FancyButtonsAttrs_fb_fontIconResource);
        String iconFontFamily = attrsArray.getString(C0525R.styleable.FancyButtonsAttrs_fb_iconFont);
        String textFontFamily = attrsArray.getString(C0525R.styleable.FancyButtonsAttrs_fb_textFont);
        try {
            this.mIconResource = attrsArray.getDrawable(C0525R.styleable.FancyButtonsAttrs_fb_iconResource);
        } catch (Exception e) {
            this.mIconResource = null;
        }
        if (fontIcon != null) {
            this.mFontIcon = fontIcon;
        }
        if (text != null) {
            this.mText = this.mTextAllCaps ? text.toUpperCase() : text;
        }
        if (!isInEditMode()) {
            if (iconFontFamily != null) {
                this.mIconTypeFace = Utils.findFont(this.mContext, iconFontFamily, this.mDefaultIconFont);
            } else {
                this.mIconTypeFace = Utils.findFont(this.mContext, this.mDefaultIconFont, null);
            }
            if (textFontFamily != null) {
                this.mTextTypeFace = Utils.findFont(this.mContext, textFontFamily, this.mDefaultTextFont);
            } else {
                this.mTextTypeFace = Utils.findFont(this.mContext, this.mDefaultTextFont, null);
            }
        }
    }

    @TargetApi(21)
    private Drawable getRippleDrawable(Drawable defaultDrawable, Drawable focusDrawable, Drawable disabledDrawable) {
        if (!this.mEnabled) {
            return disabledDrawable;
        }
        return new RippleDrawable(ColorStateList.valueOf(this.mFocusBackgroundColor), defaultDrawable, focusDrawable);
    }

    private void applyRadius(GradientDrawable drawable) {
        int i = this.mRadius;
        if (i > 0) {
            drawable.setCornerRadius((float) i);
            return;
        }
        int i2 = this.mRadiusTopLeft;
        int i3 = this.mRadiusTopRight;
        int i4 = this.mRadiusBottomRight;
        int i5 = this.mRadiusBottomLeft;
        drawable.setCornerRadii(new float[]{(float) i2, (float) i2, (float) i3, (float) i3, (float) i4, (float) i4, (float) i5, (float) i5});
    }

    @SuppressLint({"NewApi"})
    private void setupBackground() {
        GradientDrawable defaultDrawable = new GradientDrawable();
        applyRadius(defaultDrawable);
        if (this.mGhost) {
            defaultDrawable.setColor(getResources().getColor(17170445));
        } else {
            defaultDrawable.setColor(this.mDefaultBackgroundColor);
        }
        GradientDrawable focusDrawable = new GradientDrawable();
        applyRadius(focusDrawable);
        focusDrawable.setColor(this.mFocusBackgroundColor);
        GradientDrawable disabledDrawable = new GradientDrawable();
        applyRadius(disabledDrawable);
        disabledDrawable.setColor(this.mDisabledBackgroundColor);
        disabledDrawable.setStroke(this.mBorderWidth, this.mDisabledBorderColor);
        int i = this.mBorderColor;
        if (i != 0) {
            defaultDrawable.setStroke(this.mBorderWidth, i);
        }
        if (!this.mEnabled) {
            defaultDrawable.setStroke(this.mBorderWidth, this.mDisabledBorderColor);
            if (this.mGhost) {
                disabledDrawable.setColor(getResources().getColor(17170445));
            }
        }
        if (!this.mUseRippleEffect || VERSION.SDK_INT < 21) {
            StateListDrawable states = new StateListDrawable();
            GradientDrawable drawable2 = new GradientDrawable();
            applyRadius(drawable2);
            if (this.mGhost) {
                drawable2.setColor(getResources().getColor(17170445));
            } else {
                drawable2.setColor(this.mFocusBackgroundColor);
            }
            int i2 = this.mBorderColor;
            if (i2 != 0) {
                if (this.mGhost) {
                    drawable2.setStroke(this.mBorderWidth, this.mFocusBackgroundColor);
                } else {
                    drawable2.setStroke(this.mBorderWidth, i2);
                }
            }
            if (!this.mEnabled) {
                if (this.mGhost) {
                    drawable2.setStroke(this.mBorderWidth, this.mDisabledBorderColor);
                } else {
                    drawable2.setStroke(this.mBorderWidth, this.mDisabledBorderColor);
                }
            }
            if (this.mFocusBackgroundColor != 0) {
                states.addState(new int[]{16842919}, drawable2);
                states.addState(new int[]{16842908}, drawable2);
                states.addState(new int[]{-16842910}, disabledDrawable);
            }
            states.addState(new int[0], defaultDrawable);
            if (VERSION.SDK_INT < 16) {
                setBackgroundDrawable(states);
            } else {
                setBackground(states);
            }
        } else {
            setBackground(getRippleDrawable(defaultDrawable, focusDrawable, disabledDrawable));
        }
    }

    private void initializeButtonContainer() {
        int i = this.mIconPosition;
        if (i == 3 || i == 4) {
            setOrientation(1);
        } else {
            setOrientation(0);
        }
        if (getLayoutParams() == null) {
            setLayoutParams(new LayoutParams(-2, -2));
        }
        setGravity(17);
        setClickable(true);
        setFocusable(true);
        if (this.mIconResource == null && this.mFontIcon == null && getPaddingLeft() == 0 && getPaddingRight() == 0 && getPaddingTop() == 0 && getPaddingBottom() == 0) {
            setPadding(20, 20, 20, 20);
        }
    }

    public void setText(String text) {
        String text2 = this.mTextAllCaps ? text.toUpperCase() : text;
        this.mText = text2;
        TextView textView = this.mTextView;
        if (textView == null) {
            initializeFancyButton();
        } else {
            textView.setText(text2);
        }
    }

    public void setTextAllCaps(boolean textAllCaps) {
        this.mTextAllCaps = textAllCaps;
        setText(this.mText);
    }

    public void setTextColor(int color) {
        this.mDefaultTextColor = color;
        TextView textView = this.mTextView;
        if (textView == null) {
            initializeFancyButton();
        } else {
            textView.setTextColor(color);
        }
    }

    public void setIconColor(int color) {
        TextView textView = this.mFontIconView;
        if (textView != null) {
            textView.setTextColor(color);
        }
    }

    public void setBackgroundColor(int color) {
        this.mDefaultBackgroundColor = color;
        if (this.mIconView != null || this.mFontIconView != null || this.mTextView != null) {
            setupBackground();
        }
    }

    public void setFocusBackgroundColor(int color) {
        this.mFocusBackgroundColor = color;
        if (this.mIconView != null || this.mFontIconView != null || this.mTextView != null) {
            setupBackground();
        }
    }

    public void setDisableBackgroundColor(int color) {
        this.mDisabledBackgroundColor = color;
        if (this.mIconView != null || this.mFontIconView != null || this.mTextView != null) {
            setupBackground();
        }
    }

    public void setDisableTextColor(int color) {
        this.mDisabledTextColor = color;
        TextView textView = this.mTextView;
        if (textView == null) {
            initializeFancyButton();
        } else if (!this.mEnabled) {
            textView.setTextColor(color);
        }
    }

    public void setDisableBorderColor(int color) {
        this.mDisabledBorderColor = color;
        if (this.mIconView != null || this.mFontIconView != null || this.mTextView != null) {
            setupBackground();
        }
    }

    public void setTextSize(int textSize) {
        this.mDefaultTextSize = Utils.spToPx(getContext(), (float) textSize);
        TextView textView = this.mTextView;
        if (textView != null) {
            textView.setTextSize((float) textSize);
        }
    }

    public void setTextGravity(int gravity) {
        this.mDefaultTextGravity = gravity;
        if (this.mTextView != null) {
            setGravity(gravity);
        }
    }

    public void setIconPadding(int paddingLeft, int paddingTop, int paddingRight, int paddingBottom) {
        this.mIconPaddingLeft = paddingLeft;
        this.mIconPaddingTop = paddingTop;
        this.mIconPaddingRight = paddingRight;
        this.mIconPaddingBottom = paddingBottom;
        ImageView imageView = this.mIconView;
        if (imageView != null) {
            imageView.setPadding(this.mIconPaddingLeft, this.mIconPaddingTop, this.mIconPaddingRight, this.mIconPaddingBottom);
        }
        TextView textView = this.mFontIconView;
        if (textView != null) {
            textView.setPadding(this.mIconPaddingLeft, this.mIconPaddingTop, this.mIconPaddingRight, this.mIconPaddingBottom);
        }
    }

    public void setIconResource(int drawable) {
        this.mIconResource = this.mContext.getResources().getDrawable(drawable);
        ImageView imageView = this.mIconView;
        if (imageView == null || this.mFontIconView != null) {
            this.mFontIconView = null;
            initializeFancyButton();
            return;
        }
        imageView.setImageDrawable(this.mIconResource);
    }

    public void setIconResource(Drawable drawable) {
        this.mIconResource = drawable;
        ImageView imageView = this.mIconView;
        if (imageView == null || this.mFontIconView != null) {
            this.mFontIconView = null;
            initializeFancyButton();
            return;
        }
        imageView.setImageDrawable(this.mIconResource);
    }

    public void setIconResource(String icon) {
        this.mFontIcon = icon;
        TextView textView = this.mFontIconView;
        if (textView == null) {
            this.mIconView = null;
            initializeFancyButton();
            return;
        }
        textView.setText(icon);
    }

    public void setFontIconSize(int iconSize) {
        this.mFontIconSize = Utils.spToPx(getContext(), (float) iconSize);
        TextView textView = this.mFontIconView;
        if (textView != null) {
            textView.setTextSize((float) iconSize);
        }
    }

    public void setIconPosition(int position) {
        if (position <= 0 || position >= 5) {
            this.mIconPosition = 1;
        } else {
            this.mIconPosition = position;
        }
        initializeFancyButton();
    }

    public void setBorderColor(int color) {
        this.mBorderColor = color;
        if (this.mIconView != null || this.mFontIconView != null || this.mTextView != null) {
            setupBackground();
        }
    }

    public void setBorderWidth(int width) {
        this.mBorderWidth = width;
        if (this.mIconView != null || this.mFontIconView != null || this.mTextView != null) {
            setupBackground();
        }
    }

    public void setRadius(int radius) {
        this.mRadius = radius;
        if (this.mIconView != null || this.mFontIconView != null || this.mTextView != null) {
            setupBackground();
        }
    }

    public void setRadius(int[] radius) {
        this.mRadiusTopLeft = radius[0];
        this.mRadiusTopRight = radius[1];
        this.mRadiusBottomLeft = radius[2];
        this.mRadiusBottomRight = radius[3];
        if (this.mIconView != null || this.mFontIconView != null || this.mTextView != null) {
            setupBackground();
        }
    }

    public void setCustomTextFont(String fontName) {
        this.mTextTypeFace = Utils.findFont(this.mContext, fontName, this.mDefaultTextFont);
        TextView textView = this.mTextView;
        if (textView == null) {
            initializeFancyButton();
        } else {
            textView.setTypeface(this.mTextTypeFace);
        }
    }

    public void setCustomIconFont(String fontName) {
        this.mIconTypeFace = Utils.findFont(this.mContext, fontName, this.mDefaultIconFont);
        TextView textView = this.mFontIconView;
        if (textView == null) {
            initializeFancyButton();
        } else {
            textView.setTypeface(this.mIconTypeFace);
        }
    }

    public void setEnabled(boolean value) {
        super.setEnabled(value);
        this.mEnabled = value;
        initializeFancyButton();
    }

    public void setGhost(boolean ghost) {
        this.mGhost = ghost;
        if (this.mIconView != null || this.mFontIconView != null || this.mTextView != null) {
            setupBackground();
        }
    }

    public void setUsingSystemFont(boolean status) {
        this.mUseSystemFont = status;
    }

    public CharSequence getText() {
        TextView textView = this.mTextView;
        if (textView != null) {
            return textView.getText();
        }
        return "";
    }

    public TextView getTextViewObject() {
        return this.mTextView;
    }

    public TextView getIconFontObject() {
        return this.mFontIconView;
    }

    public ImageView getIconImageObject() {
        return this.mIconView;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (VERSION.SDK_INT >= 21) {
            setOutlineProvider(new CustomOutline(w, h));
        }
    }
}
