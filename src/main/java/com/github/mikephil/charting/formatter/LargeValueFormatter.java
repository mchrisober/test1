package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.BuildConfig;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.text.DecimalFormat;

public class LargeValueFormatter implements IValueFormatter, IAxisValueFormatter {
    private static final int MAX_LENGTH = 5;
    private static String[] SUFFIX = {BuildConfig.FLAVOR, "k", "m", "b", "t"};
    private DecimalFormat mFormat;
    private String mText;

    public LargeValueFormatter() {
        this.mText = BuildConfig.FLAVOR;
        this.mFormat = new DecimalFormat("###E00");
    }

    private String makePretty(double d2) {
        String format = this.mFormat.format(d2);
        int numericValue = Character.getNumericValue(format.charAt(format.length() - 1));
        String replaceAll = format.replaceAll("E[0-9][0-9]", SUFFIX[Integer.valueOf(Character.getNumericValue(format.charAt(format.length() - 2)) + BuildConfig.FLAVOR + numericValue).intValue() / 3]);
        while (true) {
            if (replaceAll.length() <= 5 && !replaceAll.matches("[0-9]+\\.[a-z]")) {
                return replaceAll;
            }
            replaceAll = replaceAll.substring(0, replaceAll.length() - 2) + replaceAll.substring(replaceAll.length() - 1);
        }
    }

    public int getDecimalDigits() {
        return 0;
    }

    @Override // com.github.mikephil.charting.formatter.IValueFormatter
    public String getFormattedValue(float f2, Entry entry, int i2, ViewPortHandler viewPortHandler) {
        return makePretty((double) f2) + this.mText;
    }

    public void setAppendix(String str) {
        this.mText = str;
    }

    public void setSuffix(String[] strArr) {
        SUFFIX = strArr;
    }

    @Override // com.github.mikephil.charting.formatter.IAxisValueFormatter
    public String getFormattedValue(float f2, AxisBase axisBase) {
        return makePretty((double) f2) + this.mText;
    }

    public LargeValueFormatter(String str) {
        this();
        this.mText = str;
    }
}
