package b.a.o;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* compiled from: ActionMode */
public abstract class b {

    /* renamed from: b  reason: collision with root package name */
    private Object f2058b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2059c;

    /* compiled from: ActionMode */
    public interface a {
        boolean a(b bVar, Menu menu);

        void b(b bVar);

        boolean c(b bVar, MenuItem menuItem);

        boolean d(b bVar, Menu menu);
    }

    public abstract void c();

    public abstract View d();

    public abstract Menu e();

    public abstract MenuInflater f();

    public abstract CharSequence g();

    public Object h() {
        return this.f2058b;
    }

    public abstract CharSequence i();

    public boolean j() {
        return this.f2059c;
    }

    public abstract void k();

    public abstract boolean l();

    public abstract void m(View view);

    public abstract void n(int i2);

    public abstract void o(CharSequence charSequence);

    public void p(Object obj) {
        this.f2058b = obj;
    }

    public abstract void q(int i2);

    public abstract void r(CharSequence charSequence);

    public void s(boolean z) {
        this.f2059c = z;
    }
}
