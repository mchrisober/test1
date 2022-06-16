package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.PieRadarChartBase;
import java.util.ArrayList;
import java.util.List;

public abstract class PieRadarHighlighter<T extends PieRadarChartBase> implements IHighlighter {
    protected T mChart;
    protected List<Highlight> mHighlightBuffer = new ArrayList();

    public PieRadarHighlighter(T t) {
        this.mChart = t;
    }

    /* access modifiers changed from: protected */
    public abstract Highlight getClosestHighlight(int i2, float f2, float f3);

    @Override // com.github.mikephil.charting.highlight.IHighlighter
    public Highlight getHighlight(float f2, float f3) {
        if (this.mChart.distanceToCenter(f2, f3) > this.mChart.getRadius()) {
            return null;
        }
        float angleForPoint = this.mChart.getAngleForPoint(f2, f3);
        T t = this.mChart;
        if (t instanceof PieChart) {
            angleForPoint /= t.getAnimator().getPhaseY();
        }
        int indexForAngle = this.mChart.getIndexForAngle(angleForPoint);
        if (indexForAngle < 0 || indexForAngle >= this.mChart.getData().getMaxEntryCountSet().getEntryCount()) {
            return null;
        }
        return getClosestHighlight(indexForAngle, f2, f3);
    }
}
