package b.h.k;

import android.graphics.Rect;
import android.os.Build;
import android.view.Gravity;

/* compiled from: GravityCompat */
public final class e {
    public static void a(int i2, int i3, int i4, Rect rect, Rect rect2, int i5) {
        if (Build.VERSION.SDK_INT >= 17) {
            Gravity.apply(i2, i3, i4, rect, rect2, i5);
        } else {
            Gravity.apply(i2, i3, i4, rect, rect2);
        }
    }

    public static int b(int i2, int i3) {
        return Build.VERSION.SDK_INT >= 17 ? Gravity.getAbsoluteGravity(i2, i3) : i2 & -8388609;
    }
}
