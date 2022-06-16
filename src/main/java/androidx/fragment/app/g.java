package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import b.l.c;
import com.github.mikephil.charting.BuildConfig;
import java.util.ArrayList;

/* compiled from: FragmentContainerView */
public final class g extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<View> f1271b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<View> f1272c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1273d = true;

    g(Context context, AttributeSet attributeSet, m mVar) {
        super(context, attributeSet);
        String str;
        String classAttribute = attributeSet.getClassAttribute();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.f2777e);
        classAttribute = classAttribute == null ? obtainStyledAttributes.getString(c.f2778f) : classAttribute;
        String string = obtainStyledAttributes.getString(c.f2779g);
        obtainStyledAttributes.recycle();
        int id = getId();
        Fragment X = mVar.X(id);
        if (classAttribute != null && X == null) {
            if (id <= 0) {
                if (string != null) {
                    str = " with tag " + string;
                } else {
                    str = BuildConfig.FLAVOR;
                }
                throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + classAttribute + str);
            }
            Fragment a2 = mVar.h0().a(context.getClassLoader(), classAttribute);
            a2.A0(context, attributeSet, null);
            u j2 = mVar.j();
            j2.t(true);
            j2.e(this, a2, string);
            j2.l();
        }
    }

    private void a(View view) {
        ArrayList<View> arrayList;
        if (view.getAnimation() != null || ((arrayList = this.f1272c) != null && arrayList.contains(view))) {
            if (this.f1271b == null) {
                this.f1271b = new ArrayList<>();
            }
            this.f1271b.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (m.n0(view) != null) {
            super.addView(view, i2, layoutParams);
            return;
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    /* access modifiers changed from: protected */
    public boolean addViewInLayout(View view, int i2, ViewGroup.LayoutParams layoutParams, boolean z) {
        if (m.n0(view) != null) {
            return super.addViewInLayout(view, i2, layoutParams, z);
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (this.f1273d && this.f1271b != null) {
            for (int i2 = 0; i2 < this.f1271b.size(); i2++) {
                super.drawChild(canvas, this.f1271b.get(i2), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j2) {
        ArrayList<View> arrayList;
        if (!this.f1273d || (arrayList = this.f1271b) == null || arrayList.size() <= 0 || !this.f1271b.contains(view)) {
            return super.drawChild(canvas, view, j2);
        }
        return false;
    }

    public void endViewTransition(View view) {
        ArrayList<View> arrayList = this.f1272c;
        if (arrayList != null) {
            arrayList.remove(view);
            ArrayList<View> arrayList2 = this.f1271b;
            if (arrayList2 != null && arrayList2.remove(view)) {
                this.f1273d = true;
            }
        }
        super.endViewTransition(view);
    }

    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            getChildAt(i2).dispatchApplyWindowInsets(new WindowInsets(windowInsets));
        }
        return windowInsets;
    }

    public void removeAllViewsInLayout() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            a(getChildAt(childCount));
        }
        super.removeAllViewsInLayout();
    }

    /* access modifiers changed from: protected */
    public void removeDetachedView(View view, boolean z) {
        if (z) {
            a(view);
        }
        super.removeDetachedView(view, z);
    }

    public void removeView(View view) {
        a(view);
        super.removeView(view);
    }

    public void removeViewAt(int i2) {
        a(getChildAt(i2));
        super.removeViewAt(i2);
    }

    public void removeViewInLayout(View view) {
        a(view);
        super.removeViewInLayout(view);
    }

    public void removeViews(int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            a(getChildAt(i4));
        }
        super.removeViews(i2, i3);
    }

    public void removeViewsInLayout(int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            a(getChildAt(i4));
        }
        super.removeViewsInLayout(i2, i3);
    }

    /* access modifiers changed from: package-private */
    public void setDrawDisappearingViewsLast(boolean z) {
        this.f1273d = z;
    }

    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (Build.VERSION.SDK_INT < 18) {
            super.setLayoutTransition(layoutTransition);
            return;
        }
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    public void startViewTransition(View view) {
        if (view.getParent() == this) {
            if (this.f1272c == null) {
                this.f1272c = new ArrayList<>();
            }
            this.f1272c.add(view);
        }
        super.startViewTransition(view);
    }
}
