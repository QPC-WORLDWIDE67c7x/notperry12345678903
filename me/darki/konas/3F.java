/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.EventDispatcher;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.stream.Collectors;
import me.darki.konas.1;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.8e_0;
import me.darki.konas.8h_0;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 3F {
    public static ArrayList<3E> c = new ArrayList();
    public static String c;
    public static 1 c;

    /*
     * Exception decompiling
     */
    public static void c(String var0, byte[] var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [10[TRYBLOCK]], but top level block is 18[FORLOOP]
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

    public static void 0() {
        for (3E e2 : c) {
            if (e2.2()) continue;
            if (e2.f()) {
                e2.d();
            }
            EventDispatcher.Companion.unsubscribe(e2);
        }
    }

    public static void c(ArrayList arrayList, 3E e2) {
        if (e2.f()) {
            arrayList.add(e2);
        }
    }

    public static 3E c(Class<? extends 3E> clazz) {
        for (3E e2 : c) {
            if (e2.getClass() != clazz) continue;
            return e2;
        }
        return null;
    }

    public static ArrayList<3E> 3() {
        ArrayList<3E> arrayList = new ArrayList<3E>();
        c.forEach(arg_0 -> 3F.c(arrayList, arg_0));
        return arrayList;
    }

    public static 3E c(String string) {
        for (3E e2 : c) {
            if (e2.b().equalsIgnoreCase(string)) {
                return e2;
            }
            for (String string2 : e2.1()) {
                if (!string2.toLowerCase().startsWith(string.toLowerCase())) continue;
                return e2;
            }
        }
        return null;
    }

    public static ArrayList<3E> 1() {
        return (ArrayList)c.stream().filter(3F::c).filter(3F::0).collect(Collectors.toList());
    }

    public static boolean 0(3E e2) {
        return e2.a();
    }

    /*
     * Unable to fully structure code
     */
    public static ArrayList<8h_0> 1(3E var0) {
        var1_1 = (3E)var0.getClass().getSuperclass().cast(var0);
        var2_2 = new ArrayList<8h_0>();
        for (Field var6_6 : var1_1.getClass().getDeclaredFields()) {
            if (!8h_0.class.isAssignableFrom(var6_6.getType())) continue;
            var6_6.setAccessible(true);
            v0 = 8e_0.class;
            v1 = var6_6;
            v2 = v1.getType();
            v3 = v0.isAssignableFrom(v2);
            if (!v3) ** GOTO lbl28
            v4 = var2_2;
            v5 = var6_6;
            v6 = var1_1;
            v7 = v5.get(v6);
            v8 = (8e_0)v7;
            v4.add(v8);
            continue;
lbl28:
            // 1 sources

            v9 = var2_2;
            v10 = var6_6;
            v11 = var1_1;
            v12 = v10.get(v11);
            v13 = (8h_0)v12;
            v9.add(v13);
            try {
            }
            catch (IllegalAccessException var7_7) {
                var7_7.printStackTrace();
            }
        }
        for (Field var6_6 : var1_1.getClass().getSuperclass().getDeclaredFields()) {
            if (!8h_0.class.isAssignableFrom(var6_6.getType())) continue;
            var6_6.setAccessible(true);
            v14 = var2_2;
            v15 = var6_6;
            v16 = var1_1;
            v17 = v15.get(v16);
            v18 = (8h_0)v17;
            v14.add(v18);
            try {
            }
            catch (IllegalAccessException var7_9) {
                var7_9.printStackTrace();
            }
        }
        return var2_2;
    }

    public static ArrayList<3E> c(3D d2) {
        ArrayList<3E> arrayList = new ArrayList<3E>();
        c.forEach(arg_0 -> 3F.c(d2, arrayList, arg_0));
        return arrayList;
    }

    public static 8h_0 c(String string, String string2) {
        if (3F.c(string) != null) {
            for (8h_0 h_02 : 3F.1(3F.c(string))) {
                if (!h_02.c().equalsIgnoreCase(string2)) continue;
                return h_02;
            }
        }
        return null;
    }

    public static void c(3D d2, ArrayList arrayList, 3E e2) {
        if (e2.e() == d2) {
            arrayList.add(e2);
        }
    }

    public static ArrayList<3E> 2() {
        return c;
    }

    /*
     * Exception decompiling
     */
    public static void c() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [6[TRYBLOCK]], but top level block is 22[UNCONDITIONALDOLOOP]
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

    static {
        c = new 1();
    }

    public static boolean c(3E e2) {
        return e2.f();
    }
}

