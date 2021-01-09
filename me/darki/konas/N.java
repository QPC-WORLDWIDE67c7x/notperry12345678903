/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.2;
import me.darki.konas.8p_0;
import me.darki.konas.command.SyntaxChunk;

public class N
extends 2 {
    /*
     * Unable to fully structure code
     */
    @Override
    public void c(String[] var1_1) {
        block51: {
            block50: {
                block49: {
                    block48: {
                        block47: {
                            if (var1_1.length != 2) break block50;
                            v0 = N.c.player;
                            v1 = v0.getRidingEntity();
                            if (v1 == null) ** GOTO lbl37
                            v2 = N.c.player;
                            v3 = v2.getRidingEntity();
                            v4 = N.c.player;
                            v5 = v4.getRidingEntity();
                            v6 = v5.posX;
                            v7 = N.c.player;
                            v8 = v7.getRidingEntity();
                            v9 = v8.posY;
                            v10 = var1_1[1];
                            v11 = Double.parseDouble(v10);
                            v12 = v9 + v11;
                            v13 = N.c.player;
                            v14 = v13.getRidingEntity();
                            v15 = v14.posZ;
                            v3.setPosition(v6, v12, v15);
                            break block47;
lbl37:
                            // 1 sources

                            v16 = N.c.player;
                            v17 = N.c.player.posX;
                            v18 = N.c.player.posY;
                            v19 = var1_1[1];
                            v20 = Double.parseDouble(v19);
                            v21 = v18 + v20;
                            v22 = N.c.player.posZ;
                            v16.setPosition(v17, v21, v22);
                        }
                        v23 = v24;
                        v25 = v24;
                        v23();
                        v26 = "Teleported you ";
                        v27 = v25.append(v26);
                        v28 = var1_1[1];
                        v29 = Double.parseDouble(v28);
                        if (!(v29 > 0.0)) break block48;
                        v30 = "up ";
                        break block49;
                    }
                    v30 = "down ";
                }
                v31 = v27.append(v30);
                v32 = var1_1[1];
                v33 = Double.parseDouble(v32);
                v34 = Math.abs(v33);
                v35 = v31.append(v34);
                v36 = " blocks.";
                v37 = v35.append(v36);
                v38 = v37.toString();
                try {
                    8p_0.1(v38);
                }
                catch (NumberFormatException var2_2) {
                    8p_0.c("Please enter a valid distance!");
                }
                break block51;
            }
            8p_0.1(this.0());
        }
    }

    public N() {
        super("VClip", "Teleport you vertically", new String[]{"PosV"}, new SyntaxChunk("<Distance>"));
    }
}

