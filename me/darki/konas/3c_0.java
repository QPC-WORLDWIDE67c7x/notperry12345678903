/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.awt.Color;
import java.math.BigDecimal;
import java.math.RoundingMode;
import me.darki.konas.2E;
import me.darki.konas.89;
import me.darki.konas.8h_0;
import me.darki.konas.9f;
import me.darki.konas.mixin.mixins.IMinecraft;
import me.darki.konas.mixin.mixins.ITimer;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.MathHelper;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.3c
 */
public class 3c_0
extends 2E {
    public 8h_0<89> 1 = new 8h_0("TextColor", new 89(new Color(255, 85, 255, 255).hashCode(), false));
    public 8h_0<Boolean> 2 = new 8h_0("Kilometers", true);
    public 8h_0<Integer> 3 = new 8h_0("Places", 2, 5, 0, 1);
    public 8h_0<Boolean> 4 = new 8h_0("Vertical", true);
    public double[] c = new double[20];
    public int 0 = 0;

    public double c(double d2, int n2) {
        if (n2 < 0) {
            return d2;
        }
        return new BigDecimal(d2).setScale(n2, RoundingMode.HALF_UP).doubleValue();
    }

    public static double c(char c2, Minecraft minecraft) {
        switch (c2) {
            case 'x': {
                return minecraft.player.posX - minecraft.player.prevPosX;
            }
            case 'y': {
                return minecraft.player.posY - minecraft.player.prevPosY;
            }
            case 'z': {
                return minecraft.player.posZ - minecraft.player.prevPosZ;
            }
        }
        return 0.0;
    }

    public 3c_0() {
        super("Speed", 100.0f, 200.0f, 5.0f, 10.0f);
    }

    @Override
    public void 5() {
        super.5();
        String string = ((Boolean)this.2.6() != false ? "KPH: " : "BPS: ") + this.c();
        float f2 = Math.max(5.0f, 9f.0(string));
        this.c(f2 + 1.0f);
        this.0(9f.c(string) + 1.0f);
        9f.0(string, (int)this.9(), (int)this.3(), ((89)this.1.6()).c());
    }

    public String c() {
        double d2;
        float f2 = ((ITimer)((IMinecraft)c).getTimer()).getTickLength() / 1000.0f;
        double d3 = 1.0;
        if (((Boolean)this.2.6()).booleanValue()) {
            d3 = 3.6;
        }
        this.c[this.0 % this.c.length] = d2 = (double)(MathHelper.sqrt((double)(Math.pow(3c_0.c('x', (Minecraft)c), 2.0) + ((Boolean)this.4.6() != false ? Math.pow(3c_0.c('y', (Minecraft)c), 2.0) : 0.0) + Math.pow(3c_0.c('z', (Minecraft)c), 2.0))) / f2) * d3;
        ++this.0;
        int n2 = 1;
        double d4 = 0.0;
        for (double d5 : this.c) {
            d4 += d5;
            ++n2;
        }
        return "" + this.c(d4 / (double)n2, (Integer)this.3.6());
    }
}

