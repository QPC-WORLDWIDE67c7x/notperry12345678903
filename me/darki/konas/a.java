/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import com.google.common.io.Files;
import java.io.File;
import me.darki.konas.2;
import me.darki.konas.8t_0;
import me.darki.konas.T;
import me.darki.konas.command.SyntaxChunk;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class a
extends 2 {
    public static File c = new File(T.c, "breadcrums");

    public static void 0(File file) {
        8t_0.0("%s", Files.getNameWithoutExtension((String)file.getName()));
    }

    /*
     * Exception decompiling
     */
    @Override
    public void c(String[] var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [18[TRYBLOCK]], but top level block is 99[UNCONDITIONALDOLOOP]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
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

    public static boolean c(File file) {
        return file.getName().endsWith(".csv");
    }

    public a() {
        super("Breadcrums", "Load and save breadcrums", new SyntaxChunk("<save/load/list/clear>"), new SyntaxChunk("<name>"));
    }
}

