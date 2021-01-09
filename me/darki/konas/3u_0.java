/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.3t_0;
import org.lwjgl.util.vector.Vector2f;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.3u
 */
public class 3u_0
extends 3t_0 {
    public float 5;
    public float 6;
    public boolean c;

    @Override
    public void 9() {
        this.c = new Vector2f[3];
        if (this.c) {
            this.c[0] = new Vector2f(0.0f + this.c, this.6 + this.0);
            this.c[1] = new Vector2f(0.5f * this.5 + this.c, this.0);
            this.c[2] = new Vector2f(this.5 + this.c, this.6 + this.0);
        } else {
            this.c[0] = new Vector2f(0.0f + this.c, this.0);
            this.c[1] = new Vector2f(0.5f * this.5 + this.c, this.6 + this.0);
            this.c[2] = new Vector2f(this.5 + this.c, this.0);
        }
    }

    public 3u_0(float f2, float f3, float f4, float f5, boolean bl) {
        this.c = f2;
        this.0 = f3;
        this.5 = f4;
        this.6 = f5;
        this.c = bl;
        this.9();
        this.8();
    }

    @Override
    public boolean 3() {
        return false;
    }
}

