package android.support.p000v4.view.animation;

import android.view.animation.Interpolator;

/* renamed from: android.support.v4.view.animation.LookupTableInterpolator */
abstract class LookupTableInterpolator implements Interpolator {
    private final float mStepSize = (1.0f / ((float) (this.mValues.length - 1)));
    private final float[] mValues;

    protected LookupTableInterpolator(float[] values) {
        this.mValues = values;
    }

    public float getInterpolation(float input) {
        if (input >= 1.0f) {
            return 1.0f;
        }
        if (input <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.mValues;
        int position = Math.min((int) (((float) (fArr.length - 1)) * input), fArr.length - 2);
        float f = (float) position;
        float f2 = this.mStepSize;
        float weight = (input - (f * f2)) / f2;
        float[] fArr2 = this.mValues;
        return fArr2[position] + ((fArr2[position + 1] - fArr2[position]) * weight);
    }
}
