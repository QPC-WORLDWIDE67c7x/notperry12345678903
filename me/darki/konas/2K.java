/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.awt.Color;
import java.text.DecimalFormat;
import me.darki.konas.2;
import me.darki.konas.2E;
import me.darki.konas.89;
import me.darki.konas.8h_0;
import me.darki.konas.9f;
import net.minecraft.util.EnumFacing;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 2K
extends 2E {
    public 8h_0<Boolean> 1 = new 8h_0("FreecamCoords", true);
    public 8h_0<89> 2 = new 8h_0("TextColor", new 89(new Color(255, 85, 255, 255).hashCode(), false));

    public String c(EnumFacing enumFacing) {
        if (enumFacing == EnumFacing.SOUTH) {
            return "+Z";
        }
        if (enumFacing == EnumFacing.WEST) {
            return "-X";
        }
        if (enumFacing == EnumFacing.NORTH) {
            return "-Z";
        }
        if (enumFacing == EnumFacing.EAST) {
            return "+X";
        }
        return null;
    }

    public 2K() {
        super("Coords", 0.0f, 350.0f, 5.0f, 10.0f);
    }

    @Override
    public void 5() {
        super.5();
        String string = 2K.c.player.getHorizontalFacing().getName().substring(0, 1).toUpperCase() + 2K.c.player.getHorizontalFacing().getName().substring(1) + me.darki.konas.2.c + "7 [" + me.darki.konas.2.c + "r" + this.c(2K.c.player.getHorizontalFacing()) + me.darki.konas.2.c + "7]";
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        double d2 = Double.parseDouble(decimalFormat.format((Boolean)this.1.6() != false ? 2K.c.getRenderViewEntity().posX : 2K.c.player.posX));
        double d3 = Double.parseDouble(decimalFormat.format((Boolean)this.1.6() != false ? 2K.c.getRenderViewEntity().posY : 2K.c.player.posY));
        double d4 = Double.parseDouble(decimalFormat.format((Boolean)this.1.6() != false ? 2K.c.getRenderViewEntity().posZ : 2K.c.player.posZ));
        double d5 = Double.parseDouble(decimalFormat.format(this.c(2K.c.player.posX)));
        double d6 = Double.parseDouble(decimalFormat.format(this.c(2K.c.player.posZ)));
        String string2 = me.darki.konas.2.c + "7XYZ" + me.darki.konas.2.c + "r " + d2 + ", " + d3 + ", " + d4 + me.darki.konas.2.c + "7 [" + me.darki.konas.2.c + "r" + d5 + ", " + d6 + me.darki.konas.2.c + "7]";
        float f2 = Math.max(9f.0(string2), 9f.0(string));
        this.c(f2 + 1.0f);
        this.0(9f.c(string) + 9f.c(string2) + 1.0f);
        9f.0(string, (int)this.9(), (int)this.3(), ((89)this.2.6()).c());
        9f.0(string2, (int)this.9(), (float)((int)this.3()) + 9f.c(string), ((89)this.2.6()).c());
    }

    public double c(double d2) {
        boolean bl = 2K.c.world.getBiome(2K.c.player.getPosition()).getBiomeName().equals("Hell");
        return bl ? d2 * 8.0 : d2 / 8.0;
    }
}

