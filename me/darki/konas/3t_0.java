/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import org.lwjgl.util.vector.Vector2f;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.3t
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 3t_0 {
    public Vector2f[] c;
    public Vector2f c;
    public float c;
    public float 0;
    public float 1;
    public float 2;
    public float 3;
    public float 4;

    public float a() {
        return this.1;
    }

    public boolean 3() {
        return false;
    }

    public Vector2f[] 7() {
        return this.c;
    }

    public float c() {
        return this.c;
    }

    public void 8() {
        block1: {
            if (this.c.length <= 0) break block1;
            this.1 = this.c[0].x;
            this.2 = this.c[0].y;
            this.3 = this.c[0].x;
            this.4 = this.c[0].y;
            for (Vector2f vector2f : this.c) {
                this.1 = Math.max(vector2f.x, this.1);
                this.2 = Math.max(vector2f.y, this.2);
                this.3 = Math.min(vector2f.x, this.3);
                this.4 = Math.min(vector2f.y, this.4);
            }
            this.1();
        }
    }

    public float 0() {
        return this.2;
    }

    public float 5() {
        return this.4;
    }

    public Vector2f 2() {
        return this.c;
    }

    public void 1() {
        this.c = new Vector2f(0.0f, 0.0f);
        int n2 = this.c.length;
        for (Vector2f vector2f : this.c) {
            this.c.x += vector2f.x;
            this.c.y += vector2f.y;
        }
        this.c.x /= (float)n2 / 2.0f;
        this.c.y /= (float)n2 / 2.0f;
    }

    public void 9() {
    }

    public float 4() {
        return this.0;
    }

    public float 6() {
        return this.3;
    }
}

