package com.google.android.exoplayer2.mediacodec;

import android.annotation.TargetApi;
import android.media.MediaFormat;
import com.google.android.exoplayer2.h0.i;
import java.nio.ByteBuffer;
import java.util.List;

@TargetApi(16)
/* compiled from: MediaFormatUtil */
public final class c {
    public static void a(MediaFormat mediaFormat, String str, byte[] bArr) {
        if (bArr != null) {
            mediaFormat.setByteBuffer(str, ByteBuffer.wrap(bArr));
        }
    }

    public static void b(MediaFormat mediaFormat, i iVar) {
        if (iVar != null) {
            d(mediaFormat, "color-transfer", iVar.f5884d);
            d(mediaFormat, "color-standard", iVar.f5882b);
            d(mediaFormat, "color-range", iVar.f5883c);
            a(mediaFormat, "hdr-static-info", iVar.f5885e);
        }
    }

    public static void c(MediaFormat mediaFormat, String str, float f2) {
        if (f2 != -1.0f) {
            mediaFormat.setFloat(str, f2);
        }
    }

    public static void d(MediaFormat mediaFormat, String str, int i2) {
        if (i2 != -1) {
            mediaFormat.setInteger(str, i2);
        }
    }

    public static void e(MediaFormat mediaFormat, List<byte[]> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            mediaFormat.setByteBuffer("csd-" + i2, ByteBuffer.wrap(list.get(i2)));
        }
    }
}
