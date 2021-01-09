/*
 * Decompiled with CFR 0.151.
 */
package com.konasclient.loader;

import com.konasclient.loader.LoaderMod$Companion;
import com.konasclient.loader.LoaderMod$clientMod$2;
import com.konasclient.loader.c;
import com.konasclient.loader.p;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import me.darki.konas.KonasMod;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.jetbrains.annotations.NotNull;

@Mod(modid="konas", name="Konas", version="b0.9.2-b8")
public class LoaderMod {
    @NotNull
    public Lazy clientMod$delegate;
    @NotNull
    public static String MOD_ID;
    @NotNull
    public static String MOD_NAME;
    @NotNull
    public static String VERSION;
    public static LoaderMod$Companion Companion;

    /*
     * Exception decompiling
     */
    @NotNull
    public KonasMod getClientMod() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl63 : GOTO - null : trying to set 1 previously set to 0
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
    @Mod.EventHandler
    public void preinit(@NotNull FMLPreInitializationEvent var1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl59 : GOTO - null : trying to set 1 previously set to 0
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
    @Mod.EventHandler
    public void init(@NotNull FMLInitializationEvent var1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl59 : GOTO - null : trying to set 1 previously set to 0
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
    @Mod.EventHandler
    public void postinit(@NotNull FMLPostInitializationEvent var1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl11 : GOTO - null : trying to set 1 previously set to 0
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
    public LoaderMod() {
        block5: {
            super();
            v0 = LazyKt.lazy((Function0)LoaderMod$clientMod$2.INSTANCE);
            if (c.c > 0) break block5;
            v1 = -802907191;
            ** GOTO lbl9
        }
        block4: while (true) {
            v1 = -510394760;
lbl9:
            // 2 sources

            switch (v1 ^ -687553198) {
                case 119561883: {
                    continue block4;
                }
                case 915880746: {
                    this.clientMod$delegate = v0;
                    return;
                }
            }
            break;
        }
        throw null;
    }

    /*
     * Unable to fully structure code
     */
    static {
        block15: {
            if (c.1 >= 0) break block15;
            v0 = -613322819;
            ** GOTO lbl7
        }
        block12: while (true) {
            v0 = -45275923;
lbl7:
            // 2 sources

            switch (v0 ^ 940461211) {
                case -1879321366: {
                    continue block12;
                }
                default: {
                    LoaderMod.VERSION = p.0("\u8d31\udb26\u2f08\u5961\uf5e9\ua75d\uf40d\u43d5\u77be");
                    LoaderMod.MOD_NAME = p.0("\u8d18\udb79\u2f48\u5939\uf5b4");
                    v1 = p.0("\u8d38\udb79\u2f48\u5939\uf5b4");
                    if (c.1 >= 0) ** GOTO lbl17
                    v2 = 1135265102;
                    ** GOTO lbl19
lbl17:
                    // 1 sources

                    block13: while (true) {
                        v2 = 1784514006;
lbl19:
                        // 2 sources

                        switch (v2 ^ -7010815) {
                            case 817874530: {
                                continue block13;
                            }
                            default: {
                                LoaderMod.MOD_ID = v1;
                                v3 = new LoaderMod$Companion(null);
                                if (c.1 >= 0) ** GOTO lbl28
                                v4 = 2075077029;
                                ** GOTO lbl30
lbl28:
                                // 1 sources

                                block14: while (true) {
                                    v4 = 1481382306;
lbl30:
                                    // 2 sources

                                    switch (v4 ^ -1837984082) {
                                        case -228025014: {
                                            continue block14;
                                        }
                                        default: {
                                            LoaderMod.Companion = v3;
                                            return;
                                        }
                                        case -371343605: {
                                            throw null;
                                        }
                                    }
                                    break;
                                }
                            }
                            case -1136671921: 
                        }
                        break;
                    }
                    throw null;
                }
                case -478207194: 
            }
            break;
        }
        throw null;
    }
}

