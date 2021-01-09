/*
 * Decompiled with CFR 0.151.
 */
package com.konasclient.loader;

import com.konasclient.loader.c;
import com.konasclient.loader.k;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class j {
    public String c;
    public k c;
    public String 0;
    public boolean c;

    /*
     * Unable to fully structure code
     */
    public j(String var1_1, k var2_2, String var3_3, boolean var4_4) {
        block15: {
            super();
            this.c = var1_1;
            if (com.konasclient.loader.c.1 >= 0) break block15;
            v0 = 456701475;
            ** GOTO lbl9
        }
        block12: while (true) {
            v0 = 533174292;
lbl9:
            // 2 sources

            switch (v0 ^ -1342829322) {
                case -1774767685: {
                    continue block12;
                }
                default: {
                    this.c = var2_2;
                    if (com.konasclient.loader.c.0 < 0) ** GOTO lbl17
                    v1 = 1163612856;
                    ** GOTO lbl19
lbl17:
                    // 1 sources

                    block13: while (true) {
                        v1 = 304661324;
lbl19:
                        // 2 sources

                        switch (v1 ^ -1777738512) {
                            case 937654852: {
                                continue block13;
                            }
                            default: {
                                this.0 = var3_3;
                                if (com.konasclient.loader.c.0 < 0) ** GOTO lbl27
                                v2 = -1195455704;
                                ** GOTO lbl29
lbl27:
                                // 1 sources

                                block14: while (true) {
                                    v2 = 5671283;
lbl29:
                                    // 2 sources

                                    switch (v2 ^ 1421399092) {
                                        case -335143140: {
                                            continue block14;
                                        }
                                        case 1424907591: {
                                            this.c = var4_4;
                                            return;
                                        }
                                        default: {
                                            throw null;
                                        }
                                    }
                                    break;
                                }
                            }
                            case -749564344: {
                                throw null;
                            }
                        }
                        break;
                    }
                }
                case -1261520171: 
            }
            break;
        }
        throw null;
    }

    public boolean c() {
        throw new UnsupportedOperationException("Please report this to the binscure obfuscator developers");
    }
}

