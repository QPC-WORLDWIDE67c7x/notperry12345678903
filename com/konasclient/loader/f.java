/*
 * Decompiled with CFR 0.151.
 */
package com.konasclient.loader;

import com.konasclient.loader.c;
import com.konasclient.loader.p;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class f
extends Enum {
    public static /* enum */ f c;
    public static /* enum */ f 0;
    public static f[] c;

    /*
     * Exception decompiling
     */
    public static f[] values() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl12 : GOTO - null : trying to set 1 previously set to 0
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
     * Exception decompiling
     */
    public static f c(String var0) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl25 : GOTO - null : trying to set 1 previously set to 0
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
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public f() {
        void var2_-1;
        void var1_-1;
    }

    /*
     * Unable to fully structure code
     */
    static {
        block10: {
            v0 = p.0("\u76be\udb57\ud4ff");
            if (com.konasclient.loader.c.c > 0) break block10;
            v1 = -1158657325;
            ** GOTO lbl8
        }
        block8: while (true) {
            v1 = -645950848;
lbl8:
            // 2 sources

            switch (v1 ^ 1400367866) {
                case 2118095563: {
                    continue block8;
                }
                default: {
                    f.c = new f(v0, 0);
                    f.0 = new f(p.0("\u76b5\udb58\ud4f2\u5911\u6d7a\u5c85\uf46e\ub874"), 1);
                    v2 = new f[2];
                    if (com.konasclient.loader.c.0 < 0) ** GOTO lbl18
                    v3 = 879465458;
                    ** GOTO lbl20
lbl18:
                    // 1 sources

                    block9: while (true) {
                        v3 = -1272915632;
lbl20:
                        // 2 sources

                        switch (v3 ^ -570126981) {
                            case 964779506: {
                                continue block9;
                            }
                            default: {
                                v2[0] = f.c;
                                v2[1] = f.0;
                                f.c = v2;
                                return;
                            }
                            case -361816439: {
                                throw null;
                            }
                        }
                        break;
                    }
                }
                case -376987607: 
            }
            break;
        }
        throw null;
    }
}

