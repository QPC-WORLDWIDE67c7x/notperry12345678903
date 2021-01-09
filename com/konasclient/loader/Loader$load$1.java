/*
 * Decompiled with CFR 0.151.
 */
package com.konasclient.loader;

import com.konasclient.loader.c;

public class Loader$load$1
implements Runnable {
    public Object $lock;

    /*
     * Exception decompiling
     */
    @Override
    public void run() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl579 : GOTO - null : trying to set 1 previously set to 0
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

    /*
     * Unable to fully structure code
     */
    public Loader$load$1(Object var1_1) {
        block15: {
            if (c.c > 0) break block15;
            v0 = 1331557264;
            ** GOTO lbl7
        }
        block12: while (true) {
            v0 = 1328925969;
lbl7:
            // 2 sources

            switch (v0 ^ 1953602082) {
                case 992766386: {
                    continue block12;
                }
                case 994334515: {
                    this.$lock = var1_1;
                    if (c.1 >= 0) ** GOTO lbl15
                    v1 = 128372354;
                    ** GOTO lbl17
lbl15:
                    // 1 sources

                    block13: while (true) {
                        v1 = -160930737;
lbl17:
                        // 2 sources

                        switch (v1 ^ -1880971233) {
                            case -2008783203: {
                                continue block13;
                            }
                            case 2039139408: {
                                if (c.c > 0) ** GOTO lbl24
                                v2 = -761391078;
                                ** GOTO lbl26
lbl24:
                                // 1 sources

                                block14: while (true) {
                                    v2 = 1930444732;
lbl26:
                                    // 2 sources

                                    switch (v2 ^ -1955700110) {
                                        case 1508932200: {
                                            continue block14;
                                        }
                                        case -125936178: {
                                            super();
                                            return;
                                        }
                                        default: {
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
}

