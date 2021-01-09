/*
 * Decompiled with CFR 0.151.
 */
package com.konasclient.client;

import com.konasclient.client.9;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.lang.reflect.Field;
import java.net.Socket;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Base64;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sun.misc.Unsafe;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class a
extends Thread {
    public Socket c;
    public DataInputStream c;
    public DataOutputStream c;
    @NotNull
    public String c = "";
    @NotNull
    public static a c;
    public static 9 c;

    @NotNull
    public String c() {
        return this.c;
    }

    public void c(@NotNull String string) {
        this.c = string;
    }

    /*
     * Exception decompiling
     */
    @Override
    public void run() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [100[TRYBLOCK]], but top level block is 137[DOLOOP]
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

    public Unsafe c() {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Object object = field.get(null);
        if (object == null) {
            throw new TypeCastException("null cannot be cast to non-null type sun.misc.Unsafe");
        }
        return (Unsafe)object;
    }

    public void c() {
        DataOutputStream dataOutputStream = this.c;
        if (dataOutputStream == null) {
            Intrinsics.throwNpe();
        }
        dataOutputStream.writeUTF(this.c("downloadLoader", this.c));
        DataOutputStream dataOutputStream2 = this.c;
        if (dataOutputStream2 == null) {
            Intrinsics.throwNpe();
        }
        dataOutputStream2.flush();
    }

    /*
     * Exception decompiling
     */
    @Nullable
    public byte[] c() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [17[FORLOOP]], but top level block is 10[TRYBLOCK]
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

    public String c(String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = ((CharSequence)string).length();
        for (int i2 = 0; i2 < n2; ++i2) {
            stringBuilder.append((char)(string.charAt(i2) ^ string2.charAt(i2 % string2.length())));
        }
        return stringBuilder.toString();
    }

    public byte[] c(byte[] byArray, String string) {
        byte[] byArray2 = new byte[byArray.length];
        int n2 = 0;
        int n3 = byArray.length;
        while (n2 < n3) {
            byte by;
            byte by2 = byArray[n2];
            byte by3 = (byte)string.charAt(n2 % string.length());
            int n4 = n2++;
            byte[] byArray3 = byArray2;
            boolean bl = false;
            byArray3[n4] = by = (byte)(by2 ^ by3);
        }
        return byArray2;
    }

    @NotNull
    public String c(@NotNull String string) {
        String string2 = string;
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        Base64.Encoder encoder = Base64.getEncoder();
        Charset charset = Charsets.UTF_8;
        boolean bl = false;
        byte[] byArray = string2.getBytes(charset);
        return encoder.encodeToString(messageDigest.digest(byArray));
    }

    static {
        c = new 9(null);
        c = new a();
    }

    public static a c() {
        return c;
    }

    public static void c(a a2) {
        c = a2;
    }
}

