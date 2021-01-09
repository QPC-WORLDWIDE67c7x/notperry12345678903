/*
 * Decompiled with CFR 0.151.
 */
package com.konasclient.client;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.TypeInsnNode;

public class 4
extends Lambda
implements Function0 {
    public static 4 c = new 4();

    public Object invoke() {
        return this.c();
    }

    @NotNull
    public InsnList c() {
        InsnList insnList = new InsnList();
        boolean bl = false;
        boolean bl2 = false;
        InsnList insnList2 = insnList;
        boolean bl3 = false;
        insnList2.add((AbstractInsnNode)new FieldInsnNode(178, "java/lang/System", "out", "Ljava/io/PrintStream;"));
        insnList2.add((AbstractInsnNode)new LdcInsnNode((Object)"Nice try"));
        insnList2.add((AbstractInsnNode)new MethodInsnNode(182, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false));
        insnList2.add((AbstractInsnNode)new TypeInsnNode(187, "java/lang/Throwable"));
        insnList2.add((AbstractInsnNode)new InsnNode(89));
        insnList2.add((AbstractInsnNode)new LdcInsnNode((Object)"owned"));
        insnList2.add((AbstractInsnNode)new MethodInsnNode(183, "java/lang/Throwable", "<init>", "(Ljava/lang/String;)V", false));
        insnList2.add((AbstractInsnNode)new InsnNode(191));
        return insnList;
    }

    public 4() {
        super(0);
    }
}

