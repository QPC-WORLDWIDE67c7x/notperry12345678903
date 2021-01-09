/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Comparator;
import me.darki.konas.2;
import me.darki.konas.2E;
import me.darki.konas.2G;
import me.darki.konas.3E;
import me.darki.konas.3F;
import me.darki.konas.89;
import me.darki.konas.8h_0;
import me.darki.konas.94;
import me.darki.konas.9c;
import me.darki.konas.9f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 2H
extends 2E {
    public 8h_0<Boolean> 1 = new 8h_0("Lines", true);
    public 8h_0<Boolean> 2 = new 8h_0("Cute", false);
    public 8h_0<89> 3;
    public 8h_0<Boolean> 4;
    public 8h_0<Float> 5;
    public 8h_0<Float> 6;
    public 8h_0<Float> 7;
    public float 3 = 0.0f;
    public 2G c;

    public String c(3E e2) {
        if (e2.0() != null) {
            return e2.b() + me.darki.konas.2.c + "7 " + e2.0();
        }
        return e2.b();
    }

    public void c(boolean bl, int[] nArray, int[] nArray2, 3E e2) {
        float f2 = 9f.0(e2.0() != null ? e2.b() + " " + e2.0() : e2.b());
        String string = this.c(e2);
        94.c(this.9() + (bl ? this.c() - f2 - 2.0f : 0.0f), this.3() + (float)nArray[0], f2 + 2.0f, (float)((int)(9f.c(string) + 1.5f)), new Color(20, 20, 20, 60).hashCode());
        int n2 = this.0(nArray2[0]);
        if (((Boolean)this.1.6()).booleanValue()) {
            94.c(this.9() + (bl ? this.c() - f2 - 2.0f : f2 + 2.0f), this.3() + (float)nArray[0], 1.0f, (float)((int)(9f.c(string) + 1.5f)), n2);
        }
        9f.0(string, (int)((float)((int)this.9()) + (bl ? this.c() - f2 : 0.0f)), (int)(this.3() + (float)nArray[0] + 0.5f), e2.a() ? n2 : Color.GRAY.getRGB());
        nArray[0] = nArray[0] + (int)(9f.c(string) + 1.5f);
        nArray2[0] = nArray2[0] + 1;
    }

    @Override
    public void 5() {
        super.5();
        this.3();
        int[] nArray = new int[]{0};
        int[] nArray2 = new int[]{1};
        boolean bl = this.c == 2G.0 || this.c == 2G.c;
        boolean bl2 = this.c == 2G.1 || this.c == 2G.c;
        ArrayList<3E> arrayList = 3F.1();
        this.3 = (float)arrayList.stream().mapToDouble(2H::0).max().orElse(0.0);
        this.c(this.3);
        arrayList.stream().sorted(Comparator.comparingInt(arg_0 -> 2H.c(bl, arg_0))).forEach(arg_0 -> this.c(bl2, nArray, nArray2, arg_0));
        this.0((float)nArray[0]);
    }

    public int c(int n2) {
        int n3 = 3F.3().size();
        int n4 = new Color(91, 206, 250).getRGB();
        int n5 = Color.WHITE.getRGB();
        int n6 = new Color(245, 169, 184).getRGB();
        int n7 = n3 / 5;
        if (n2 < n7) {
            return n4;
        }
        if (n2 < n7 * 2) {
            return n6;
        }
        if (n2 < n7 * 3) {
            return n5;
        }
        if (n2 < n7 * 4) {
            return n6;
        }
        if (n2 < n7 * 5) {
            return n4;
        }
        return n4;
    }

    public static double 0(3E e2) {
        return 9f.0(e2.0() != null ? e2.b() + " " + e2.0() : e2.b());
    }

    public static int c(boolean bl, 3E e2) {
        return bl ? -((int)9f.0(e2.0() != null ? e2.b() + " " + e2.0() : e2.b())) : (int)9f.0(e2.0() != null ? e2.b() + " " + e2.0() : e2.b());
    }

    public void 3() {
        ScaledResolution scaledResolution;
        float f2 = this.9() + this.c() / 2.0f;
        float f3 = this.3() + this.7() / 2.0f;
        if (f3 >= (float)(scaledResolution = new ScaledResolution(Minecraft.getMinecraft())).getScaledHeight() / 2.0f && f2 >= (float)scaledResolution.getScaledWidth() / 2.0f) {
            this.c = 2G.1;
        } else if (f3 >= (float)scaledResolution.getScaledHeight() / 2.0f && f2 <= (float)scaledResolution.getScaledWidth() / 2.0f) {
            this.c = 2G.2;
        } else if (f3 <= (float)scaledResolution.getScaledHeight() / 2.0f && f2 >= (float)scaledResolution.getScaledWidth() / 2.0f) {
            this.c = 2G.c;
        } else if (f3 <= (float)scaledResolution.getScaledHeight() / 2.0f && f2 <= (float)scaledResolution.getScaledWidth() / 2.0f) {
            this.c = 2G.0;
        }
    }

    public boolean 2() {
        return (Boolean)this.4.6() != false && !((89)this.3.6()).7();
    }

    public 2H() {
        super("ArrayList", 100.0f, 100.0f, 100.0f, 100.0f);
        this.4 = new 8h_0("Pulse", true);
        this.5 = new 8h_0("Range", Float.valueOf(1.0f), Float.valueOf(1.0f), Float.valueOf(0.1f), Float.valueOf(0.1f)).c(this::1);
        this.6 = new 8h_0("Spread", Float.valueOf(1.0f), Float.valueOf(2.0f), Float.valueOf(0.1f), Float.valueOf(0.1f)).c(this::2);
        this.7 = new 8h_0("Speed", Float.valueOf(1.0f), Float.valueOf(10.0f), Float.valueOf(1.0f), Float.valueOf(1.0f)).c(this::0);
        this.c = 2G.c;
    }

    public boolean c() {
        return (Boolean)this.2.6() == false;
    }

    public int 0(int n2) {
        float[] fArray = Color.RGBtoHSB(((89)this.3.6()).0() >> 16 & 0xFF, ((89)this.3.6()).0() >> 8 & 0xFF, ((89)this.3.6()).0() & 0xFF, null);
        if (((Boolean)this.2.6()).booleanValue()) {
            return this.c(n2 - 1);
        }
        if (((Boolean)this.4.6()).booleanValue()) {
            if (((89)this.3.6()).7()) {
                return 9c.c(300 * n2, fArray);
            }
            return 9c.c(n2, fArray, ((Float)this.6.6()).floatValue(), ((Float)this.7.6()).floatValue(), ((Float)this.5.6()).floatValue());
        }
        return ((89)this.3.6()).c();
    }

    public boolean 1() {
        return (Boolean)this.4.6() != false && !((89)this.3.6()).7();
    }

    public boolean 0() {
        return (Boolean)this.4.6() != false && !((89)this.3.6()).7();
    }
}

