/*
 * Decompiled with CFR 0.151.
 */
package com.konasclient.loader;

import com.konasclient.loader.c;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import me.darki.konas.KonasMod;
import org.jetbrains.annotations.NotNull;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class LoaderMod$clientMod$2
extends Lambda
implements Function0 {
    public static LoaderMod$clientMod$2 INSTANCE;

    /*
     * Exception decompiling
     */
    public Object invoke() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl23 : GOTO - null : trying to set 1 previously set to 0
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
    @NotNull
    public KonasMod invoke() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl24 : GOTO - null : trying to set 1 previously set to 0
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

    public LoaderMod$clientMod$2() {
        super(0);
    }

    /*
     * Unable to fully structure code
     */
    static {
        block10: {
            if (c.1 >= 0) break block10;
            v0 = 1110315180;
            ** GOTO lbl7
        }
        block8: while (true) {
            v0 = 1910042516;
lbl7:
            // 2 sources

            switch (v0 ^ -668874570) {
                case -589383716: {
                    continue block8;
                }
                default: {
                    v1 = new LoaderMod$clientMod$2();
                    if (c.c > 0) ** GOTO lbl15
                    v2 = 1595548608;
                    ** GOTO lbl17
lbl15:
                    // 1 sources

                    block9: while (true) {
                        v2 = -1690891899;
lbl17:
                        // 2 sources

                        switch (v2 ^ 1120653282) {
                            case 1614702955: {
                                continue block9;
                            }
                            default: {
                                LoaderMod$clientMod$2.INSTANCE = v1;
                                return;
                            }
                            case 500296738: 
                        }
                        break;
                    }
                    throw null;
                }
                case -1710237670: 
            }
            break;
        }
        throw null;
    }
}

