/*
 * Decompiled with CFR 0.151.
 */
package com.konasclient.loader;

import com.konasclient.loader.c;
import com.konasclient.loader.j;
import com.konasclient.loader.k;

public class m
extends j {
    /*
     * Unable to fully structure code
     */
    public m(String var1_1, k var2_2, String var3_3, boolean var4_4) {
        block15: {
            if (com.konasclient.loader.c.1 >= 0) break block15;
            v0 = -1110079138;
            ** GOTO lbl7
        }
        block12: while (true) {
            v0 = 1890383860;
lbl7:
            // 2 sources

            switch (v0 ^ -141466272) {
                case 1246030910: {
                    continue block12;
                }
                case -2026007916: {
                    if (com.konasclient.loader.c.c > 0) ** GOTO lbl14
                    v1 = 1709603864;
                    ** GOTO lbl16
lbl14:
                    // 1 sources

                    block13: while (true) {
                        v1 = 291057243;
lbl16:
                        // 2 sources

                        switch (v1 ^ -703225855) {
                            case -1275864039: {
                                continue block13;
                            }
                            case -951284134: {
                                if (com.konasclient.loader.c.c > 0) ** GOTO lbl23
                                v2 = 1680157158;
                                ** GOTO lbl25
lbl23:
                                // 1 sources

                                block14: while (true) {
                                    v2 = 549765968;
lbl25:
                                    // 2 sources

                                    switch (v2 ^ 1419674299) {
                                        case 2037083590: {
                                            continue block14;
                                        }
                                        default: {
                                            super(var1_1, var2_2, var3_3, var4_4);
                                            return;
                                        }
                                        case 817605469: {
                                            throw null;
                                        }
                                    }
                                    break;
                                }
                            }
                        }
                        break;
                    }
                    throw null;
                }
            }
            break;
        }
        throw null;
    }

    /*
     * Exception decompiling
     */
    @Override
    public boolean c() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl151 : GOTO - null : trying to set 1 previously set to 0
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.populateStackInfo(Op02WithProcessedDataAndRefs.java:207)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.populateStackInfo(Op02WithProcessedDataAndRefs.java:1565)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:433)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }
}

