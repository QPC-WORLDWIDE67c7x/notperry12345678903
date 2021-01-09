/*
 * Decompiled with CFR 0.151.
 */
package com.konasclient.client;

import com.konasclient.client.g;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import sun.misc.Unsafe;

public class h {
    @NotNull
    public static Lazy c = LazyKt.lazy((Function0)g.c);

    @NotNull
    public static Unsafe c() {
        Lazy lazy = c;
        Object var1_1 = null;
        Object var2_2 = null;
        boolean bl = false;
        return (Unsafe)lazy.getValue();
    }
}

