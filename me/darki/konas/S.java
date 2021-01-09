/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.2;
import me.darki.konas.8p_0;
import me.darki.konas.command.SyntaxChunk;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.math.MathHelper;

public class S
extends 2 {
    public S() {
        super("yaw", "Set Player's Yaw", new String[]{"setyaw"}, new SyntaxChunk("<x/yaw>"), new SyntaxChunk("[z]"));
    }

    @Override
    public void c(String[] stringArray) {
        block18: {
            block19: {
                if (stringArray.length != 2) break block19;
                if (S.c.player == null) break block18;
                EntityPlayerSP entityPlayerSP = S.c.player;
                String string = stringArray[1];
                double d2 = Double.parseDouble(string);
                double d3 = MathHelper.wrapDegrees((double)d2);
                try {
                    entityPlayerSP.rotationYaw = (float)d3;
                }
                catch (NumberFormatException numberFormatException) {
                    8p_0.c("Please enter a valid yaw!");
                }
                break block18;
            }
            if (stringArray.length != 3) break block18;
            if (S.c.player == null) break block18;
            EntityPlayerSP entityPlayerSP = S.c.player;
            double d4 = S.c.player.posZ;
            String string = stringArray[2];
            double d5 = Double.parseDouble(string);
            double d6 = d4 - d5;
            double d7 = S.c.player.posX;
            String string2 = stringArray[1];
            double d8 = Double.parseDouble(string2);
            double d9 = d7 - d8;
            double d10 = Math.atan2(d6, d9);
            double d11 = Math.toDegrees(d10);
            double d12 = d11 + 90.0;
            double d13 = MathHelper.wrapDegrees((double)d12);
            try {
                entityPlayerSP.rotationYaw = (float)d13;
            }
            catch (NumberFormatException numberFormatException) {
                8p_0.c("Please enter a valid yaw!");
            }
        }
    }
}

