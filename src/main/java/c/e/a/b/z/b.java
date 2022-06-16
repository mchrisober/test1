package c.e.a.b.z;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;

/* compiled from: MaterialAttributes */
public class b {
    public static TypedValue a(Context context, int i2) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i2, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static boolean b(Context context, int i2, boolean z) {
        TypedValue a2 = a(context, i2);
        if (a2 == null || a2.type != 18) {
            return z;
        }
        return a2.data != 0;
    }

    public static int c(Context context, int i2, String str) {
        TypedValue a2 = a(context, i2);
        if (a2 != null) {
            return a2.data;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i2)));
    }

    public static int d(View view, int i2) {
        return c(view.getContext(), i2, view.getClass().getCanonicalName());
    }
}
