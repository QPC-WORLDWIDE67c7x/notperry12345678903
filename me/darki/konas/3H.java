/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.3G;
import me.darki.konas.89;
import me.darki.konas.8e_0;
import me.darki.konas.8h_0;
import me.darki.konas.8k_0;
import me.darki.konas.9d;
import me.darki.konas.i_0;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 3H
extends 3E {
    public static int 1 = -1;
    public static 8h_0<Boolean> 1;
    public static 8h_0<89> 2;
    public static 8h_0<89> 3;
    public static 8h_0<89> 4;
    public static 8h_0<89> 5;
    public static 8h_0<89> 6;
    public static 8h_0<Float> 7;
    public static 8h_0<Integer> 8;
    public static 8h_0<Boolean> 9;
    public static 8h_0<Boolean> a;
    public static 8h_0<Boolean> b;
    public static 8h_0<Integer> d;
    public static 8h_0<Integer> e;
    public 8h_0<Boolean> f = new 8e_0("CustomFont", true, new 3G(this));
    public static 9d c;

    public 3H() {
        super("ClickGUI", "Default Konas GUI", 21, 3D.5, new String[0]);
    }

    public static boolean c() {
        return (Boolean)a.6() == false && (Boolean)b.6() != false;
    }

    static {
        1 = (int)new 8h_0("Binds", false);
        2 = new 8h_0("Color", new 89(-4581958));
        3 = new 8h_0("Font", new 89(-1));
        4 = new 8h_0("Secondary", new 89(-16777216));
        5 = new 8h_0("Header", new 89(-587202560));
        6 = new 8h_0("Background", new 89(-587202560));
        7 = new 8h_0("MaxHeight", Float.valueOf(500.0f), Float.valueOf(500.0f), Float.valueOf(200.0f), Float.valueOf(3.5f));
        8 = new 8h_0("ScrollSpeed", 14, 28, 7, 1);
        9 = new 8h_0("Hover", true);
        a = new 8h_0("Animate", true);
        b = new 8h_0("Outline", false).c(3H::0);
        d = new 8h_0("Thickness", 1, 5, 1, 1).c(3H::c);
        e = new 8h_0("AnimationSpeed", 10, 20, 1, 1).c(a::6);
        c = new 9d(i_0.2, 17.0f);
    }

    public static boolean 0() {
        return (Boolean)a.6() == false;
    }

    @Override
    public void c() {
        this.d();
        c.displayGuiScreen(8k_0.c.c);
    }
}

