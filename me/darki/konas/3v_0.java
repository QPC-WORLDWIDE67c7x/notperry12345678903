/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.3t_0;
import org.lwjgl.util.vector.Vector2f;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.3v
 */
public class 3v_0
extends 3t_0 {
    public float 5;
    public float 6;

    public 3v_0(float f2, float f3, float f4, float f5) {
        this.c = f2;
        this.0 = f3;
        this.5 = f4;
        this.6 = f5;
        this.9();
        this.8();
    }

    @Override
    public void 9() {
        this.c = new Vector2f[3];
        this.c[0] = new Vector2f(0.22222222f * this.5 + this.c, 0.5f * this.6 + this.0);
        this.c[1] = new Vector2f(0.44444445f * this.5 + this.c, 0.7222222f * this.6 + this.0);
        this.c[2] = new Vector2f(0.7777778f * this.5 + this.c, 0.2777778f * this.6 + this.0);
    }

    @Override
    public boolean 3() {
        return false;
    }
}

