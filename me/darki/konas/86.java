/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.3F;
import me.darki.konas.8e_0;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 86
extends 3E {
    public static float c = (float)new 8e_0("Zoom", Float.valueOf(1.1f), Float.valueOf(1.5f), Float.valueOf(0.5f), Float.valueOf(0.05f), 86::c);
    public static 8e_0<Float> c;

    @Override
    public void c() {
        c = 86.c.gameSettings.fovSetting;
        86.c.gameSettings.fovSetting *= 1.6f - ((Float)c.6()).floatValue();
    }

    public 86() {
        super("Zoom", "Zoom in properly, not with perspective modification", 3D.2, new String[0]);
    }

    @Override
    public void 7() {
        86.c.gameSettings.fovSetting = c;
    }

    public static void c(Float f2) {
        if (3F.c(86.class).f()) {
            86.c.gameSettings.fovSetting = c * (1.6f - f2.floatValue());
        }
    }
}

