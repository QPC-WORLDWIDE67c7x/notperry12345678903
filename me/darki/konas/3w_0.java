/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.3t_0;
import org.lwjgl.util.vector.Vector2f;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.3w
 */
public class 3w_0
extends 3t_0 {
    public float 5;
    public float 6;

    @Override
    public boolean 3() {
        return true;
    }

    @Override
    public void 9() {
        this.c = new Vector2f[4];
        this.c[0] = new Vector2f(this.c, this.0);
        this.c[1] = new Vector2f(this.c, this.0 + this.6);
        this.c[2] = new Vector2f(this.c + this.5, this.0 + this.6);
        this.c[3] = new Vector2f(this.c + this.5, this.0);
    }

    public 3w_0(float f2, float f3, float f4, float f5) {
        this.c = f2;
        this.0 = f3;
        this.5 = f4;
        this.6 = f5;
        this.9();
        this.8();
    }
}

