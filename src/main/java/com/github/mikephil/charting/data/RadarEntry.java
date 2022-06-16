package com.github.mikephil.charting.data;

import android.annotation.SuppressLint;
import com.github.mikephil.charting.utils.Utils;

@SuppressLint({"ParcelCreator"})
public class RadarEntry extends Entry {
    public RadarEntry(float f2) {
        super(Utils.FLOAT_EPSILON, f2);
    }

    public float getValue() {
        return getY();
    }

    @Override // com.github.mikephil.charting.data.Entry
    @Deprecated
    public float getX() {
        return super.getX();
    }

    @Override // com.github.mikephil.charting.data.Entry
    @Deprecated
    public void setX(float f2) {
        super.setX(f2);
    }

    public RadarEntry(float f2, Object obj) {
        super((float) Utils.FLOAT_EPSILON, f2, obj);
    }

    @Override // com.github.mikephil.charting.data.Entry
    public RadarEntry copy() {
        return new RadarEntry(getY(), getData());
    }
}
