/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.89;
import me.darki.konas.8e_0;
import me.darki.konas.8h_0;
import me.darki.konas.8k_0;
import net.minecraft.client.gui.GuiScreen;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 3O
extends 3E {
    public static 8h_0<89> 1 = new 8h_0("MainStart", new 89(-3659736));
    public static 8h_0<89> 2 = new 8h_0("MainEnd", new 89(-3659736));
    public static 8h_0<89> 3 = new 8h_0("AccentStart", new 89(-2343896));
    public static 8h_0<89> 4 = new 8h_0("AccentEnd", new 89(-2343896));
    public static 8h_0<89> 5 = new 8h_0("CategoryStart", new 89(-6612197));
    public static 8h_0<89> 6 = new 8h_0("CategoryEnd", new 89(-6612197));
    public static 8h_0<89> 7 = new 8h_0("OutlineStart", new 89(0x33FFFFFF));
    public static 8h_0<89> 8 = new 8h_0("OutlineEnd", new 89(0x33FFFFFF));
    public static 8h_0<89> 9 = new 8h_0("BackgroundStart", new 89(-1440603614));
    public static 8h_0<89> a = new 8h_0("BackgroundEnd", new 89(-1440603614));
    public static 8h_0<89> b = new 8h_0("ForegroundStart", new 89(0x60000000));
    public static 8h_0<89> d = new 8h_0("ForegroundEnd", new 89(0x60000000));
    public static 8h_0<89> e = new 8h_0("PrimaryStart", new 89(-4934476));
    public static 8h_0<89> f = new 8h_0("PrimaryEnd", new 89(-4934476));
    public static 8h_0<89> g = new 8h_0("SecondaryStart", new 89(-13092808));
    public static 8h_0<89> h = new 8h_0("SecondaryEnd", new 89(-13092808));
    public static 8h_0<89> i = new 8h_0("SliderStart", new 89(-6842473));
    public static 8h_0<89> j = new 8h_0("SliderEnd", new 89(-6842473));
    public static 8h_0<89> k = new 8h_0("TextBoxStart", new 89(-2302756));
    public static 8h_0<89> l = new 8h_0("TextBoxEnd", new 89(-2302756));
    public static 8h_0<89> m = new 8h_0("FontStart", new 89(-1));
    public static 8h_0<89> n = new 8h_0("FontEnd", new 89(-1));
    public static 8h_0<89> o = new 8h_0("DarkFontStart", new 89(-16777216));
    public static 8h_0<89> p = new 8h_0("DarkFontEnd", new 89(-16777216));
    public static 8h_0<89> q = new 8h_0("SubFontStart", new 89(-3355444));
    public static 8h_0<89> r = new 8h_0("SubFontEnd", new 89(-3355444));
    public static 8h_0<Float> s = new 8h_0("Highlight", Float.valueOf(0.7f), Float.valueOf(0.9f), Float.valueOf(0.5f), Float.valueOf(0.1f));
    public static 8h_0<Boolean> t = new 8h_0("Reload", false);
    public static 8h_0<Integer> u = new 8h_0("Height", 400, 600, 300, 10);
    public static 8e_0<Boolean> c = new 8e_0("SingleColumn", false, 3O::c);
    public static int 1 = -1;

    @Override
    public void c() {
        this.d();
        c.displayGuiScreen((GuiScreen)8k_0.c.c);
    }

    public 3O() {
        super("KonasGui", "Aimware-Styled single panel GUI", 54, 3D.5, new String[0]);
    }

    public static void c(Boolean bl) {
        t.2(Boolean.valueOf(true));
    }
}

