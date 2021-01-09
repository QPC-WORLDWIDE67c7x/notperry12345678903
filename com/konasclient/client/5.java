/*
 * Decompiled with CFR 0.151.
 */
package com.konasclient.client;

import com.konasclient.client.4;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.MethodNode;

public class 5 {
    public static Lazy c = LazyKt.lazy((Function0)4.c);

    public static InsnList c() {
        Lazy lazy = c;
        Object var1_1 = null;
        Object var2_2 = null;
        boolean bl = false;
        return (InsnList)lazy.getValue();
    }

    @NotNull
    public static byte[] c(@NotNull String string) {
        MethodNode methodNode;
        Object[] objectArray;
        ClassNode classNode = new ClassNode();
        boolean bl = false;
        boolean bl2 = false;
        ClassNode classNode2 = classNode;
        boolean bl3 = false;
        classNode2.name = StringsKt.replace$default((String)string, (char)'.', (char)'/', (boolean)false, (int)4, null);
        classNode2.access = 1;
        classNode2.version = 52;
        classNode2.superName = "java/lang/Object";
        MethodNode methodNode2 = new MethodNode(9, "<clinit>", "()V", null, null);
        int n2 = 0;
        Object[] objectArray2 = objectArray = new MethodNode[1];
        ClassNode classNode3 = classNode2;
        boolean bl4 = false;
        boolean bl5 = false;
        MethodNode methodNode3 = methodNode2;
        boolean bl6 = false;
        methodNode3.instructions = 5.c();
        objectArray[n2] = methodNode = methodNode2;
        classNode3.methods = CollectionsKt.arrayListOf((Object[])objectArray2);
        ClassNode classNode4 = classNode;
        classNode = new ClassWriter(2);
        bl = false;
        bl2 = false;
        classNode2 = classNode;
        bl3 = false;
        classNode4.accept((ClassVisitor)classNode2);
        return classNode.toByteArray();
    }
}

