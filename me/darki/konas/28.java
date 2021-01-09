/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.awt.Color;
import java.util.ArrayList;
import me.darki.konas.27;
import me.darki.konas.31;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.3F;
import me.darki.konas.89;
import me.darki.konas.94;
import me.darki.konas.9f;
import net.minecraft.client.gui.Gui;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 28
extends Gui {
    public float c;
    public ArrayList<3E> c;
    public float 0;
    public int c;
    public float 1;
    public float 2;
    public 27 c;
    public 3D c = 57;
    public int 0 = 0;

    public void c() {
        if (this.c.size() != 0) {
            27 var1_1 = 27.c;
            for (27 var5_5 : 27.values()) {
                if (var5_5.equals((Object)this.c)) {
                    this.c = var1_1;
                    break;
                }
                var1_1 = var5_5;
            }
        }
    }

    public void c(float f2, float f3) {
        this.c = (float)this.c(this.c, f2, f3);
        if (this.c != 27.c) {
            this.c((ArrayList<3E>)this.c, f2, f3);
        } else {
            this.0 = 0;
        }
    }

    public void 4() {
        block4: {
            block5: {
                if (this.c != 27.c) break block5;
                3D d2 = 3D.values()[3D.values().length - 1];
                for (3D d3 : 3D.values()) {
                    if (d3.equals((Object)this.c)) {
                        this.c = d2;
                        break block4;
                    }
                    d2 = d3;
                }
                break block4;
            }
            if (this.c != 27.0 || this.c.size() == 0) break block4;
            int n2 = this.c.size() - 1;
            for (3E e2 : this.c) {
                if (this.c.indexOf(e2) == this.0) {
                    this.0 = n2;
                    break;
                }
                n2 = this.c.indexOf(e2);
            }
        }
    }

    public int 3() {
        if (this.c == 27.0) {
            return this.c;
        }
        return 61;
    }

    public void c(float f2) {
        this.1 = f2;
    }

    public float 1() {
        return this.1;
    }

    public void c(int n2) {
        this.c = n2;
    }

    public void 2() {
        if (this.c == 27.c) {
            int n2 = 0;
            for (3D d2 : 3D.values()) {
                if (d2.equals((Object)this.c)) {
                    n2 = 1;
                    continue;
                }
                if (n2 != true) continue;
                this.c = d2;
                n2 = 2;
                break;
            }
            if (n2 == 1) {
                this.c = 3D.values()[0];
            }
        } else if (this.c == 27.0 && this.c.size() != 0) {
            int n3 = 0;
            for (3E e2 : this.c) {
                if (this.c.indexOf(e2) == this.0) {
                    n3 = 1;
                    continue;
                }
                if (n3 != true) continue;
                this.0 = this.c.indexOf(e2);
                n3 = 2;
                break;
            }
            if (n3 == 1) {
                this.0 = 0;
            }
        }
    }

    public void c(ArrayList<3E> arrayList, float f2, float f3) {
        this.0 = this.2;
        int[] nArray = new int[]{67};
        arrayList.forEach(arg_0 -> 28.c(nArray, arg_0));
        for (3E e2 : arrayList) {
            int n2 = Color.WHITE.hashCode();
            94.c(f2 + 61.0f, f3 + this.0, (float)nArray[0], (float)(9f.c() + 3), new Color(43, 43, 43, 200).hashCode());
            int n3 = 65;
            if (this.0 == arrayList.indexOf(e2)) {
                94.c(f2 + 61.0f, f3 + this.0, 2.0f, (float)(9f.c() + 2), ((89)31.1.6()).c());
                n3 = 67;
            }
            if (e2.f()) {
                n2 = ((89)31.2.6()).c();
            }
            9f.0(e2.b(), (int)f2 + n3, (int)f3 + (int)(this.0 + 2.0f), n2);
            this.0 += (float)(9f.c() + 3);
        }
        this.c(61 + nArray[0]);
        this.c(this.0);
    }

    public 28() {
        this.1 = this.0;
        this.2 = this.0;
        this.c = 27.c;
        this.c = 3D.c;
    }

    public static void c(int[] nArray, 3E e2) {
        if (9f.0(e2.b()) > (float)nArray[0]) {
            nArray[0] = (int)(9f.0(e2.b()) + 6.0f);
        }
    }

    public ArrayList<3E> c(3D d2, float f2, float f3) {
        this.0 = 1.0f;
        94.c(f2 + 2.0f, f3 + this.0 - 1.0f, 57.0f, 1.0f, new Color(43, 43, 43, 200).hashCode());
        for (3D d3 : 3D.values()) {
            int n2 = new Color(43, 43, 43, 200).hashCode();
            int n3 = 6;
            94.c(f2 + 2.0f, f3 + this.0, 57.0f, (float)(9f.c() + 3), n2);
            if (d3.equals((Object)d2)) {
                94.c(f2 + 2.0f, f3 + this.0, 2.0f, (float)(9f.c() + 2), ((89)31.1.6()).c());
                n3 = 8;
                this.2 = this.0;
            }
            9f.0(d3.toString().substring(0, 1).toUpperCase() + d3.toString().substring(1).toLowerCase(), (int)(f2 + (float)n3), (int)((float)((int)f3) + (this.0 + 2.0f)), d3.equals((Object)this.c) ? ((89)31.1.6()).c() : Color.white.hashCode());
            this.0 += (float)(9f.c() + 3);
        }
        this.c(this.c + 1.0f + (float)((9f.c() + 3) * 3D.values().length));
        return 3F.c(d2);
    }

    public void 0() {
        block3: {
            int n2 = 0;
            if (this.c.size() == 0) break block3;
            for (27 var5_5 : 27.values()) {
                if (var5_5.equals((Object)this.c)) {
                    n2 = 1;
                    continue;
                }
                if (n2 != true) continue;
                this.c = var5_5;
                n2 = 2;
                break;
            }
            if (n2 == 1) {
                ((3E)this.c.get(this.0)).d();
            }
        }
    }
}

