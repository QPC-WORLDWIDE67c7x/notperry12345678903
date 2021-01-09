/*
 * Decompiled with CFR 0.151.
 */
package com.konasclient.client;

import com.konasclient.client.1;
import com.konasclient.client.2;
import com.konasclient.loader.LoaderMod;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.jetbrains.annotations.NotNull;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Mod(modid="konas", name="Konas", version="0.10")
public class 3 {
    public Lazy c = LazyKt.lazy((Function0)2.c);
    @NotNull
    public static String c;
    @NotNull
    public static String 0;
    @NotNull
    public static String 1;
    public static 1 c;

    public LoaderMod c() {
        Lazy lazy = this.c;
        3 var2_2 = this;
        Object var3_3 = null;
        boolean bl = false;
        return (LoaderMod)lazy.getValue();
    }

    @Mod.EventHandler
    public void c(@NotNull FMLPreInitializationEvent fMLPreInitializationEvent) {
        this.c().preinit(fMLPreInitializationEvent);
    }

    @Mod.EventHandler
    public void c(@NotNull FMLInitializationEvent fMLInitializationEvent) {
        this.c().init(fMLInitializationEvent);
    }

    @Mod.EventHandler
    public void c(@NotNull FMLPostInitializationEvent fMLPostInitializationEvent) {
        this.c().postinit(fMLPostInitializationEvent);
    }

    static {
        1 = "0.10";
        0 = "Konas";
        c = "konas";
        c = new 1(null);
    }
}

