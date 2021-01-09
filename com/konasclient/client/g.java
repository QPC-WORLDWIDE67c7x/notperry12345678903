/*
 * Decompiled with CFR 0.151.
 */
package com.konasclient.client;

import java.lang.reflect.Field;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import sun.misc.Unsafe;

public class g
extends Lambda
implements Function0 {
    public static g c = new g();

    public Object invoke() {
        return this.c();
    }

    @NotNull
    public Unsafe c() {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        boolean bl = false;
        boolean bl2 = false;
        Field field2 = field;
        boolean bl3 = false;
        field2.setAccessible(true);
        Object object = field2.get(null);
        if (object == null) {
            throw new TypeCastException("null cannot be cast to non-null type sun.misc.Unsafe");
        }
        return (Unsafe)object;
    }

    public g() {
        super(0);
    }
}

