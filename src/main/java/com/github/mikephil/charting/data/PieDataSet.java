package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class PieDataSet extends DataSet<PieEntry> implements IPieDataSet {
    private boolean mAutomaticallyDisableSliceSpacing;
    private float mShift = 18.0f;
    private float mSliceSpace = Utils.FLOAT_EPSILON;
    private int mValueLineColor;
    private float mValueLinePart1Length;
    private float mValueLinePart1OffsetPercentage;
    private float mValueLinePart2Length;
    private boolean mValueLineVariableLength;
    private float mValueLineWidth;
    private ValuePosition mXValuePosition;
    private ValuePosition mYValuePosition;

    public enum ValuePosition {
        INSIDE_SLICE,
        OUTSIDE_SLICE
    }

    public PieDataSet(List<PieEntry> list, String str) {
        super(list, str);
        ValuePosition valuePosition = ValuePosition.INSIDE_SLICE;
        this.mXValuePosition = valuePosition;
        this.mYValuePosition = valuePosition;
        this.mValueLineColor = -16777216;
        this.mValueLineWidth = 1.0f;
        this.mValueLinePart1OffsetPercentage = 75.0f;
        this.mValueLinePart1Length = 0.3f;
        this.mValueLinePart2Length = 0.4f;
        this.mValueLineVariableLength = true;
    }

    @Override // com.github.mikephil.charting.data.DataSet
    public DataSet<PieEntry> copy() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.mValues.size(); i2++) {
            arrayList.add(((PieEntry) this.mValues.get(i2)).copy());
        }
        PieDataSet pieDataSet = new PieDataSet(arrayList, getLabel());
        pieDataSet.mColors = this.mColors;
        pieDataSet.mSliceSpace = this.mSliceSpace;
        pieDataSet.mShift = this.mShift;
        return pieDataSet;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public float getSelectionShift() {
        return this.mShift;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public float getSliceSpace() {
        return this.mSliceSpace;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public int getValueLineColor() {
        return this.mValueLineColor;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public float getValueLinePart1Length() {
        return this.mValueLinePart1Length;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public float getValueLinePart1OffsetPercentage() {
        return this.mValueLinePart1OffsetPercentage;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public float getValueLinePart2Length() {
        return this.mValueLinePart2Length;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public float getValueLineWidth() {
        return this.mValueLineWidth;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public ValuePosition getXValuePosition() {
        return this.mXValuePosition;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public ValuePosition getYValuePosition() {
        return this.mYValuePosition;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public boolean isAutomaticallyDisableSliceSpacingEnabled() {
        return this.mAutomaticallyDisableSliceSpacing;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public boolean isValueLineVariableLength() {
        return this.mValueLineVariableLength;
    }

    public void setAutomaticallyDisableSliceSpacing(boolean z) {
        this.mAutomaticallyDisableSliceSpacing = z;
    }

    public void setSelectionShift(float f2) {
        this.mShift = Utils.convertDpToPixel(f2);
    }

    public void setSliceSpace(float f2) {
        if (f2 > 20.0f) {
            f2 = 20.0f;
        }
        if (f2 < Utils.FLOAT_EPSILON) {
            f2 = Utils.FLOAT_EPSILON;
        }
        this.mSliceSpace = Utils.convertDpToPixel(f2);
    }

    public void setValueLineColor(int i2) {
        this.mValueLineColor = i2;
    }

    public void setValueLinePart1Length(float f2) {
        this.mValueLinePart1Length = f2;
    }

    public void setValueLinePart1OffsetPercentage(float f2) {
        this.mValueLinePart1OffsetPercentage = f2;
    }

    public void setValueLinePart2Length(float f2) {
        this.mValueLinePart2Length = f2;
    }

    public void setValueLineVariableLength(boolean z) {
        this.mValueLineVariableLength = z;
    }

    public void setValueLineWidth(float f2) {
        this.mValueLineWidth = f2;
    }

    public void setXValuePosition(ValuePosition valuePosition) {
        this.mXValuePosition = valuePosition;
    }

    public void setYValuePosition(ValuePosition valuePosition) {
        this.mYValuePosition = valuePosition;
    }

    /* access modifiers changed from: protected */
    public void calcMinMax(PieEntry pieEntry) {
        if (pieEntry != null) {
            calcMinMaxY(pieEntry);
        }
    }
}
