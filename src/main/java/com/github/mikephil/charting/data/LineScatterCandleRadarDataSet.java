package com.github.mikephil.charting.data;

import android.graphics.DashPathEffect;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;

public abstract class LineScatterCandleRadarDataSet<T extends Entry> extends BarLineScatterCandleBubbleDataSet<T> implements ILineScatterCandleRadarDataSet<T> {
    protected boolean mDrawHorizontalHighlightIndicator;
    protected boolean mDrawVerticalHighlightIndicator;
    protected DashPathEffect mHighlightDashPathEffect;
    protected float mHighlightLineWidth;

    public LineScatterCandleRadarDataSet(List<T> list, String str) {
        super(list, str);
        this.mDrawVerticalHighlightIndicator = true;
        this.mDrawHorizontalHighlightIndicator = true;
        this.mHighlightLineWidth = 0.5f;
        this.mHighlightDashPathEffect = null;
        this.mHighlightLineWidth = Utils.convertDpToPixel(0.5f);
    }

    public void disableDashedHighlightLine() {
        this.mHighlightDashPathEffect = null;
    }

    public void enableDashedHighlightLine(float f2, float f3, float f4) {
        this.mHighlightDashPathEffect = new DashPathEffect(new float[]{f2, f3}, f4);
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet
    public DashPathEffect getDashPathEffectHighlight() {
        return this.mHighlightDashPathEffect;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet
    public float getHighlightLineWidth() {
        return this.mHighlightLineWidth;
    }

    public boolean isDashedHighlightLineEnabled() {
        return this.mHighlightDashPathEffect != null;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet
    public boolean isHorizontalHighlightIndicatorEnabled() {
        return this.mDrawHorizontalHighlightIndicator;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet
    public boolean isVerticalHighlightIndicatorEnabled() {
        return this.mDrawVerticalHighlightIndicator;
    }

    public void setDrawHighlightIndicators(boolean z) {
        setDrawVerticalHighlightIndicator(z);
        setDrawHorizontalHighlightIndicator(z);
    }

    public void setDrawHorizontalHighlightIndicator(boolean z) {
        this.mDrawHorizontalHighlightIndicator = z;
    }

    public void setDrawVerticalHighlightIndicator(boolean z) {
        this.mDrawVerticalHighlightIndicator = z;
    }

    public void setHighlightLineWidth(float f2) {
        this.mHighlightLineWidth = Utils.convertDpToPixel(f2);
    }
}
