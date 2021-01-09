/*
 * Decompiled with CFR 0.151.
 */
package com.konasclient.client;

import com.konasclient.loader.LoaderMod;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

public class 2
extends Lambda
implements Function0 {
    public static 2 c = new 2();

    public Object invoke() {
        return this.c();
    }

    @NotNull
    public LoaderMod c() {
        return new LoaderMod();
    }

    public 2() {
        super(0);
    }
}

