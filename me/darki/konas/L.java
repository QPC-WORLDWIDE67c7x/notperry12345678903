/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.2;
import me.darki.konas.8p_0;
import me.darki.konas.command.SyntaxChunk;

public class L
extends 2 {
    /*
     * Unable to fully structure code
     */
    @Override
    public void c(String[] var1_1) {
        block81: {
            block82: {
                block80: {
                    if (var1_1.length != 4) ** GOTO lbl82
                    v0 = var1_1[1];
                    v1 = Double.parseDouble(v0);
                    var2_2 = v1;
                    v2 = var1_1[2];
                    v3 = Double.parseDouble(v2);
                    var4_5 = v3;
                    v4 = var1_1[3];
                    v5 = Double.parseDouble(v4);
                    var6_7 = v5;
                    v6 = L.c.player;
                    v7 = v6.getRidingEntity();
                    if (v7 == null) ** GOTO lbl36
                    v8 = L.c.player;
                    v9 = v8.getRidingEntity();
                    v10 = var2_2;
                    v11 = var4_5;
                    v12 = var6_7;
                    v9.setPosition(v10, v11, v12);
                    break block80;
lbl36:
                    // 1 sources

                    v13 = L.c.player;
                    v14 = var2_2;
                    v15 = var4_5;
                    v16 = var6_7;
                    v13.setPosition(v14, v15, v16);
                }
                v17 = v18;
                v19 = v18;
                v17();
                v20 = "Teleported you to (";
                v21 = v19.append(v20);
                v22 = var2_2;
                v23 = v21.append(v22);
                v24 = ", ";
                v25 = v23.append(v24);
                v26 = var4_5;
                v27 = v25.append(v26);
                v28 = ", ";
                v29 = v27.append(v28);
                v30 = var6_7;
                v31 = v29.append(v30);
                v32 = ")";
                v33 = v31.append(v32);
                v34 = v33.toString();
                8p_0.1(v34);
                break block81;
lbl82:
                // 1 sources

                if (var1_1.length != 3) ** GOTO lbl151
                v35 = var1_1[1];
                v36 = Double.parseDouble(v35);
                var2_3 = v36;
                v37 = var1_1[2];
                v38 = Double.parseDouble(v37);
                var4_6 = v38;
                v39 = L.c.player;
                v40 = v39.getRidingEntity();
                if (v40 == null) ** GOTO lbl113
                v41 = L.c.player;
                v42 = v41.getRidingEntity();
                v43 = var2_3;
                v44 = L.c.player;
                v45 = v44.getRidingEntity();
                v46 = v45.posY;
                v47 = var4_6;
                v42.setPosition(v43, v46, v47);
                break block82;
lbl113:
                // 1 sources

                v48 = L.c.player;
                v49 = var2_3;
                v50 = L.c.player.posY;
                v51 = var4_6;
                v48.setPosition(v49, v50, v51);
            }
            v52 = v53;
            v54 = v53;
            v52();
            v55 = "Teleported you to (";
            v56 = v54.append(v55);
            v57 = var2_3;
            v58 = v56.append(v57);
            v59 = ", ";
            v60 = v58.append(v59);
            v61 = var4_6;
            v62 = v60.append(v61);
            v63 = ")";
            v64 = v62.append(v63);
            v65 = v64.toString();
            8p_0.1(v65);
            break block81;
lbl151:
            // 1 sources

            v66 = this;
            v67 = v66.0();
            try {
                8p_0.1(v67);
            }
            catch (NumberFormatException var2_4) {
                8p_0.c("Please enter valid positions!");
            }
        }
    }

    public L() {
        super("Teleport", "Teleports you to an X, Y, Z coordinate.", new String[]{"PosH"}, new SyntaxChunk("<X Pos>"), new SyntaxChunk("<Y Pos>"), new SyntaxChunk("<Z Pos>"));
    }
}

