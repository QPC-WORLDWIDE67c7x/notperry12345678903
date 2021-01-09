/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import me.darki.konas.2A;
import me.darki.konas.2B;
import me.darki.konas.2C;
import me.darki.konas.2D;
import me.darki.konas.2E;
import me.darki.konas.2r_0;
import me.darki.konas.2y_0;
import me.darki.konas.2z_0;
import me.darki.konas.3D;
import me.darki.konas.8k_0;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.2n
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 2n_0
extends GuiScreen {
    public ArrayList<2C> c;
    public boolean c = false;
    public static boolean 0 = false;
    public static boolean 1 = false;

    public boolean 2() {
        return this.c;
    }

    public void mouseClickMove(int n2, int n3, int n4, long l2) {
        super.mouseClickMove(n2, n3, n4, l2);
        this.3().forEach(arg_0 -> 2n_0.c(n2, n3, n4, l2, arg_0));
    }

    public boolean doesGuiPauseGame() {
        return false;
    }

    public static void c(int n2, int n3, float f2, 2C c2) {
        c2.c(n2, n3, f2);
    }

    public static void c(2C c2) {
        c2.c(false);
    }

    public static boolean c() {
        return 0;
    }

    public static void c(char c2, int n2, 2C c3) {
        c3.c(c2, n2);
    }

    public static void c(int n2, int n3, int n4, long l2, 2C c2) {
        c2.c(n2, n3, n4, l2);
    }

    public void drawScreen(int n2, int n3, float f2) {
        super.drawScreen(n2, n3, f2);
        this.3().forEach(arg_0 -> 2n_0.c(n2, n3, f2, arg_0));
    }

    public static void c(2C c2, 2r_0 r_02) {
        r_02.0(c2.5(), c2.6() + (float)((2z_0)c2).3());
    }

    public static void 0(boolean bl) {
        1 = bl;
    }

    public static void 0(2C c2) {
        block0: {
            if (c2 instanceof 2A) break block0;
            c2.0(true);
        }
    }

    public static void c(int n2, int n3, int n4, 2C c2) {
        c2.c(n2, n3, n4);
    }

    public void mouseReleased(int n2, int n3, int n4) {
        super.mouseReleased(n2, n3, n4);
        this.3().forEach(arg_0 -> 2n_0.c(n2, n3, n4, arg_0));
        for (2C c2 : this.3()) {
            for (2C c3 : this.3()) {
                if (c2 == c3 || c2 instanceof 2A || c2.5() != c3.5() || c2.6() != c3.6()) continue;
                c3.3(c3.5() + 10.0f);
                c3.0(c3.6() + 10.0f);
                if (!(c3 instanceof 2z_0)) continue;
                ((2z_0)c3).2().forEach(arg_0 -> 2n_0.c(c3, arg_0));
            }
        }
    }

    public static void c(boolean bl) {
        0 = bl;
    }

    public void onGuiClosed() {
        this.3().forEach(2n_0::c);
    }

    public ArrayList<2C> 3() {
        return this.c;
    }

    public void keyTyped(char c2, int n2) throws IOException {
        if (!0) {
            super.keyTyped(c2, n2);
        }
        this.3().forEach(arg_0 -> 2n_0.c(c2, n2, arg_0));
    }

    public void mouseClicked(int n2, int n3, int n4) throws IOException {
        super.mouseClicked(n2, n3, n4);
        for (int i2 = this.3().size() - 1; i2 >= 0; --i2) {
            2C c2 = this.3().get(i2);
            if (!c2.0(n2, n3, n4)) continue;
            Collections.swap(this.3(), i2, this.3().size() - 2);
            break;
        }
    }

    public static boolean 1() {
        return 1;
    }

    public void 0() {
        int n2 = new ScaledResolution(Minecraft.getMinecraft()).getScaledWidth() / 2 - 350;
        int n3 = 20;
        for (3D d2 : 3D.values()) {
            this.3().add(new 2z_0(d2, (float)n2, (float)n3, 95.0f, 14.0f));
            n2 += 110;
        }
        this.3().add(new 2D(300.0f, n3, 95.0f, 14.0f));
        for (2E e2 : 8k_0.c.c.c()) {
            this.3().add(new 2A(e2));
        }
        this.3().add(new 2y_0());
        this.3().forEach(2n_0::0);
        this.3().add(new 2B());
        this.3().forEach(2C::0);
        this.c = true;
    }
}

