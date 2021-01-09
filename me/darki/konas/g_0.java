/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.2;
import me.darki.konas.8p_0;
import me.darki.konas.command.SyntaxChunk;

/*
 * Renamed from me.darki.konas.g
 */
public class g_0
extends 2 {
    /*
     * Unable to fully structure code
     */
    @Override
    public void c(String[] var1_1) {
        block25: {
            block26: {
                if (var1_1.length != 2) break block26;
                v0 = var1_1[1];
                v1 = "ergeisacoolgamer";
                v2 = v0.equalsIgnoreCase(v1);
                if (!v2) ** GOTO lbl17
                v3 = "epicjbug is cooler!";
                8p_0.1(v3);
                break block25;
lbl17:
                // 1 sources

                v4 = g_0.c.gameSettings;
                v5 = var1_1[1];
                v6 = Float.parseFloat(v5);
                v4.fovSetting = v6;
                v7 = v8;
                v9 = v8;
                v7();
                v10 = "Set FOV to ";
                v11 = v9.append(v10);
                v12 = var1_1[1];
                v13 = Float.parseFloat(v12);
                v14 = v11.append(v13);
                v15 = v14.toString();
                try {
                    8p_0.1(v15);
                }
                catch (NumberFormatException var2_2) {
                    8p_0.c("Please enter a valid FOV!");
                }
                break block25;
            }
            8p_0.1(this.0());
        }
    }

    public g_0() {
        super("FOV", "Sets your FOV to the value entered.", new String[]{"SetFOV", "FieldOfView"}, new SyntaxChunk("<FOV>"));
    }
}

