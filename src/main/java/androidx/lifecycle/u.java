package androidx.lifecycle;

/* compiled from: ViewModelProvider */
public class u {

    /* renamed from: a  reason: collision with root package name */
    private final a f1494a;

    /* renamed from: b  reason: collision with root package name */
    private final v f1495b;

    /* compiled from: ViewModelProvider */
    public interface a {
        <T extends t> T a(Class<T> cls);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ViewModelProvider */
    public static abstract class b extends c implements a {
        b() {
        }

        @Override // androidx.lifecycle.u.a
        public <T extends t> T a(Class<T> cls) {
            throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
        }

        public abstract <T extends t> T c(String str, Class<T> cls);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ViewModelProvider */
    public static class c {
        c() {
        }

        /* access modifiers changed from: package-private */
        public void b(t tVar) {
        }
    }

    public u(v vVar, a aVar) {
        this.f1494a = aVar;
        this.f1495b = vVar;
    }

    public <T extends t> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) b("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public <T extends t> T b(String str, Class<T> cls) {
        T t = (T) this.f1495b.b(str);
        if (cls.isInstance(t)) {
            a aVar = this.f1494a;
            if (aVar instanceof c) {
                ((c) aVar).b(t);
            }
            return t;
        }
        a aVar2 = this.f1494a;
        T t2 = aVar2 instanceof b ? (T) ((b) aVar2).c(str, cls) : (T) aVar2.a(cls);
        this.f1495b.d(str, t2);
        return t2;
    }
}
