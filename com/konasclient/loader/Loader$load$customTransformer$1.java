/*
 * Decompiled with CFR 0.151.
 */
package com.konasclient.loader;

import com.konasclient.loader.1;
import com.konasclient.loader.c;
import net.minecraft.launchwrapper.IClassTransformer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Loader$load$customTransformer$1
implements IClassTransformer {
    public 1 $classes;
    public String $k;

    /*
     * Exception decompiling
     */
    @Nullable
    public byte[] transform(@NotNull String var1, @Nullable String var2, @Nullable byte[] var3) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl219 : GOTO - null : trying to set 1 previously set to 0
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
    public Loader$load$customTransformer$1(1 var1_1, String var2_2) {
        block25: {
            if (c.0 < 0) break block25;
            v0 = 1018308432;
            ** GOTO lbl7
        }
        block20: while (true) {
            v0 = 1992655418;
lbl7:
            // 2 sources

            switch (v0 ^ -1224050273) {
                case -1954842156: {
                    continue block20;
                }
                default: {
                    if (c.1 >= 0) ** GOTO lbl14
                    v1 = -1901997486;
                    ** GOTO lbl16
lbl14:
                    // 1 sources

                    block21: while (true) {
                        v1 = 1727723832;
lbl16:
                        // 2 sources

                        switch (v1 ^ -1247617982) {
                            case 990055952: {
                                continue block21;
                            }
                            case -749197958: {
                                this.$classes = var1_1;
                                if (c.0 < 0) ** GOTO lbl24
                                v2 = -2056105215;
                                ** GOTO lbl26
lbl24:
                                // 1 sources

                                block22: while (true) {
                                    v2 = 1429133540;
lbl26:
                                    // 2 sources

                                    switch (v2 ^ 571249278) {
                                        case 1547346361: {
                                            continue block22;
                                        }
                                        default: {
                                            this.$k = var2_2;
                                            if (c.1 >= 0) ** GOTO lbl34
                                            v3 = 398992050;
                                            ** GOTO lbl36
lbl34:
                                            // 1 sources

                                            block23: while (true) {
                                                v3 = -719561157;
lbl36:
                                                // 2 sources

                                                switch (v3 ^ -1819325408) {
                                                    case -2075693422: {
                                                        continue block23;
                                                    }
                                                    case 1184043547: {
                                                        if (c.1 >= 0) ** GOTO lbl43
                                                        v4 = -421287698;
                                                        ** GOTO lbl45
lbl43:
                                                        // 1 sources

                                                        block24: while (true) {
                                                            v4 = -1314674174;
lbl45:
                                                            // 2 sources

                                                            switch (v4 ^ -1363725512) {
                                                                case 1213504470: {
                                                                    continue block24;
                                                                }
                                                                case 521443642: {
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
                                                    default: {
                                                        throw null;
                                                    }
                                                }
                                                break;
                                            }
                                        }
                                        case -1484865153: {
                                            throw null;
                                        }
                                    }
                                    break;
                                }
                            }
                            default: {
                                throw null;
                            }
                        }
                        break;
                    }
                }
                case -1950851377: 
            }
            break;
        }
        throw null;
    }
}

