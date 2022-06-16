package f.a.a.a.b.l.n0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.b;
import com.github.mikephil.charting.R;
import f.a.a.a.b.d.a0;
import f.a.a.a.b.d.b0;
import gov.va.mobilehealth.ncptsd.covid.Activities.Act_manage;
import gov.va.mobilehealth.ncptsd.covid.CComp.j;
import gov.va.mobilehealth.ncptsd.covid.CComp.m;
import vainstrum.Components.FABTracking;

/* compiled from: Frag_tool_RID_decide */
public class b extends vainstrum.Components.b implements View.OnClickListener {
    private Act_manage c0;
    private FABTracking d0;
    private FABTracking e0;
    private Button f0;
    private TextView g0;
    private EditText h0;
    private b0 i0;
    private b0 j0;
    private a0 k0;
    private int l0;
    private String m0;
    private String n0;
    private String o0;
    private Boolean p0;
    private Boolean q0;
    private BroadcastReceiver r0;

    /* compiled from: Frag_tool_RID_decide */
    class a extends BroadcastReceiver {
        a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("gov.va.mobilehealth.ACTION_DONE")) {
                b.this.W1();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f.a.a.a.b.l.n0.b$b  reason: collision with other inner class name */
    /* compiled from: Frag_tool_RID_decide */
    public class DialogInterface$OnClickListenerC0211b implements DialogInterface.OnClickListener {
        DialogInterface$OnClickListenerC0211b(b bVar) {
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
        }
    }

    public b() {
        Boolean bool = Boolean.FALSE;
        this.p0 = bool;
        this.q0 = bool;
    }

    public static b X1(b0 b0Var, b0 b0Var2, a0 a0Var, int i2, String str, String str2, String str3) {
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putSerializable("tool", b0Var);
        bundle.putSerializable("selected_tool", b0Var2);
        bundle.putSerializable("symptom", a0Var);
        bundle.putInt("old_distress", i2);
        bundle.putString("last_tool_name", str);
        bundle.putString("what", str2);
        bundle.putString("how", str3);
        bVar.v1(bundle);
        return bVar;
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void E0() {
        n().unregisterReceiver(this.r0);
        super.E0();
    }

    @Override // androidx.fragment.app.Fragment, vainstrum.Components.b
    public void J0() {
        IntentFilter intentFilter = new IntentFilter("gov.va.mobilehealth.ACTION_DONE");
        this.r0 = new a();
        try {
            n().registerReceiver(this.r0, intentFilter);
        } catch (IllegalArgumentException unused) {
        }
        super.J0();
    }

    @Override // androidx.fragment.app.Fragment
    public void K0(Bundle bundle) {
        bundle.putSerializable("tool", this.i0);
        bundle.putSerializable("selected_tool", this.j0);
        bundle.putSerializable("symptom", this.k0);
        bundle.putInt("old_distress", this.l0);
        bundle.putString("last_tool_name", this.m0);
        bundle.putString("what", this.n0);
        bundle.putString("how", this.o0);
        super.K0(bundle);
    }

    public void W1() {
        String obj = this.h0.getText().toString();
        if (!obj.isEmpty()) {
            j.d(n(), this.h0);
            this.c0.W(j.b2(this.i0, this.j0, this.k0, this.l0, this.m0, this.n0, this.o0, obj), Q(R.string.rid_summary));
            return;
        }
        b.a h2 = j.h(n(), Q(R.string.missing_fields_rid_identify));
        h2.k(R.string.ok, new DialogInterface$OnClickListenerC0211b(this));
        h2.a().show();
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(Bundle bundle) {
        super.o0(bundle);
        this.c0 = (Act_manage) n();
        if (bundle != null) {
            this.i0 = (b0) bundle.getSerializable("tool");
            this.j0 = (b0) bundle.getSerializable("selected_tool");
            this.k0 = (a0) bundle.getSerializable("symptom");
            this.l0 = bundle.getInt("old_distress");
            this.m0 = bundle.getString("last_tool_name");
            this.n0 = bundle.getString("what");
            this.o0 = bundle.getString("how");
        } else if (u() != null) {
            this.i0 = (b0) u().getSerializable("tool");
            this.j0 = (b0) u().getSerializable("selected_tool");
            this.k0 = (a0) u().getSerializable("symptom");
            this.l0 = u().getInt("old_distress");
            this.m0 = u().getString("last_tool_name");
            this.n0 = u().getString("what");
            this.o0 = u().getString("how");
        }
    }

    public void onClick(View view) {
        if (view.getId() == this.d0.getId()) {
            this.q0 = Boolean.valueOf(m.o(n(), this.j0, this.d0, this.e0, this.q0, this.p0));
            this.p0 = Boolean.FALSE;
        }
        if (view.getId() == this.e0.getId()) {
            this.p0 = Boolean.valueOf(m.n(n(), this.j0, this.d0, this.e0, this.q0, this.p0));
            this.q0 = Boolean.FALSE;
        }
        if (view.getId() == this.f0.getId()) {
            m.c0(true, this.c0, this.k0, this.i0, this.l0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frag_tool_rid_decide, (ViewGroup) null);
        this.d0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_thumb_up);
        this.e0 = (FABTracking) inflate.findViewById(R.id.bottom_tool_btn_thumb_down);
        this.f0 = (Button) inflate.findViewById(R.id.bottom_tool_btn_new_tool);
        this.g0 = (TextView) inflate.findViewById(R.id.rid_decide_txt_title);
        this.h0 = (EditText) inflate.findViewById(R.id.rid_decide_edt_decide);
        m.R0(n(), inflate.findViewById(R.id.rid_decide_layout));
        if (this.k0 == null) {
            this.f0.setVisibility(8);
        }
        this.d0.setOnClickListener(this);
        this.e0.setOnClickListener(this);
        this.f0.setOnClickListener(this);
        m.f0(this.j0.d(), this.d0, this.e0);
        this.q0 = Boolean.valueOf(m.C0(n(), this.j0.d(), this.d0, false));
        this.p0 = Boolean.valueOf(m.B0(n(), this.j0.d(), this.e0, false));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(Q(R.string.rid));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(b.h.d.a.b(n(), R.color.red)), 2, 3, 33);
        this.g0.setText(spannableStringBuilder);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void t0() {
        super.t0();
    }
}
