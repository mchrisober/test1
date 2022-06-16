package com.github.mikephil.charting.components;

import android.graphics.Paint;
import com.github.mikephil.charting.utils.Utils;

public class YAxis extends AxisBase {
    private AxisDependency mAxisDependency;
    private boolean mDrawBottomYLabelEntry;
    private boolean mDrawTopYLabelEntry;
    protected boolean mDrawZeroLine;
    protected boolean mInverted;
    protected float mMaxWidth;
    protected float mMinWidth;
    private YAxisLabelPosition mPosition;
    protected float mSpacePercentBottom;
    protected float mSpacePercentTop;
    protected int mZeroLineColor;
    protected float mZeroLineWidth;

    public enum AxisDependency {
        LEFT,
        RIGHT
    }

    public enum YAxisLabelPosition {
        OUTSIDE_CHART,
        INSIDE_CHART
    }

    public YAxis() {
        this.mDrawBottomYLabelEntry = true;
        this.mDrawTopYLabelEntry = true;
        this.mInverted = false;
        this.mDrawZeroLine = false;
        this.mZeroLineColor = -7829368;
        this.mZeroLineWidth = 1.0f;
        this.mSpacePercentTop = 10.0f;
        this.mSpacePercentBottom = 10.0f;
        this.mPosition = YAxisLabelPosition.OUTSIDE_CHART;
        this.mMinWidth = Utils.FLOAT_EPSILON;
        this.mMaxWidth = Float.POSITIVE_INFINITY;
        this.mAxisDependency = AxisDependency.LEFT;
        this.mYOffset = Utils.FLOAT_EPSILON;
    }

    @Override // com.github.mikephil.charting.components.AxisBase
    public void calculate(float f2, float f3) {
        if (this.mCustomAxisMin) {
            f2 = this.mAxisMinimum;
        }
        if (this.mCustomAxisMax) {
            f3 = this.mAxisMaximum;
        }
        float abs = Math.abs(f3 - f2);
        if (abs == Utils.FLOAT_EPSILON) {
            f3 += 1.0f;
            f2 -= 1.0f;
        }
        if (!this.mCustomAxisMin) {
            this.mAxisMinimum = f2 - ((abs / 100.0f) * getSpaceBottom());
        }
        if (!this.mCustomAxisMax) {
            this.mAxisMaximum = f3 + ((abs / 100.0f) * getSpaceTop());
        }
        this.mAxisRange = Math.abs(this.mAxisMaximum - this.mAxisMinimum);
    }

    public AxisDependency getAxisDependency() {
        return this.mAxisDependency;
    }

    public YAxisLabelPosition getLabelPosition() {
        return this.mPosition;
    }

    public float getMaxWidth() {
        return this.mMaxWidth;
    }

    public float getMinWidth() {
        return this.mMinWidth;
    }

    public float getRequiredHeightSpace(Paint paint) {
        paint.setTextSize(this.mTextSize);
        return ((float) Utils.calcTextHeight(paint, getLongestLabel())) + (getYOffset() * 2.0f);
    }

    public float getRequiredWidthSpace(Paint paint) {
        paint.setTextSize(this.mTextSize);
        float calcTextWidth = ((float) Utils.calcTextWidth(paint, getLongestLabel())) + (getXOffset() * 2.0f);
        float minWidth = getMinWidth();
        float maxWidth = getMaxWidth();
        if (minWidth > Utils.FLOAT_EPSILON) {
            minWidth = Utils.convertDpToPixel(minWidth);
        }
        if (maxWidth > Utils.FLOAT_EPSILON && maxWidth != Float.POSITIVE_INFINITY) {
            maxWidth = Utils.convertDpToPixel(maxWidth);
        }
        if (((double) maxWidth) <= Utils.DOUBLE_EPSILON) {
            maxWidth = calcTextWidth;
        }
        return Math.max(minWidth, Math.min(calcTextWidth, maxWidth));
    }

    public float getSpaceBottom() {
        return this.mSpacePercentBottom;
    }

    public float getSpaceTop() {
        return this.mSpacePercentTop;
    }

    public int getZeroLineColor() {
        return this.mZeroLineColor;
    }

    public float getZeroLineWidth() {
        return this.mZeroLineWidth;
    }

    public boolean isDrawBottomYLabelEntryEnabled() {
        return this.mDrawBottomYLabelEntry;
    }

    public boolean isDrawTopYLabelEntryEnabled() {
        return this.mDrawTopYLabelEntry;
    }

    public boolean isDrawZeroLineEnabled() {
        return this.mDrawZeroLine;
    }

    public boolean isInverted() {
        return this.mInverted;
    }

    public boolean needsOffset() {
        return isEnabled() && isDrawLabelsEnabled() && getLabelPosition() == YAxisLabelPosition.OUTSIDE_CHART;
    }

    public void setDrawTopYLabelEntry(boolean z) {
        this.mDrawTopYLabelEntry = z;
    }

    public void setDrawZeroLine(boolean z) {
        this.mDrawZeroLine = z;
    }

    public void setInverted(boolean z) {
        this.mInverted = z;
    }

    public void setMaxWidth(float f2) {
        this.mMaxWidth = f2;
    }

    public void setMinWidth(float f2) {
        this.mMinWidth = f2;
    }

    public void setPosition(YAxisLabelPosition yAxisLabelPosition) {
        this.mPosition = yAxisLabelPosition;
    }

    public void setSpaceBottom(float f2) {
        this.mSpacePercentBottom = f2;
    }

    public void setSpaceTop(float f2) {
        this.mSpacePercentTop = f2;
    }

    @Deprecated
    public void setStartAtZero(boolean z) {
        if (z) {
            setAxisMinimum(Utils.FLOAT_EPSILON);
        } else {
            resetAxisMinimum();
        }
    }

    public void setZeroLineColor(int i2) {
        this.mZeroLineColor = i2;
    }

    public void setZeroLineWidth(float f2) {
        this.mZeroLineWidth = Utils.convertDpToPixel(f2);
    }

    public YAxis(AxisDependency axisDependency) {
        this.mDrawBottomYLabelEntry = true;
        this.mDrawTopYLabelEntry = true;
        this.mInverted = false;
        this.mDrawZeroLine = false;
        this.mZeroLineColor = -7829368;
        this.mZeroLineWidth = 1.0f;
        this.mSpacePercentTop = 10.0f;
        this.mSpacePercentBottom = 10.0f;
        this.mPosition = YAxisLabelPosition.OUTSIDE_CHART;
        this.mMinWidth = Utils.FLOAT_EPSILON;
        this.mMaxWidth = Float.POSITIVE_INFINITY;
        this.mAxisDependency = axisDependency;
        this.mYOffset = Utils.FLOAT_EPSILON;
    }
}
