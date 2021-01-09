/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.8k_0;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid="konas", name="Konas", version="0.10.2")
public class KonasMod {
    public static String ID;
    public static String NAME;
    public static String VERSION;
    public static String WATERMARK;
    public static Logger LOGGER;

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent fMLPreInitializationEvent) {
        8k_0.c.c();
    }

    static {
        VERSION = "0.10.2";
        NAME = "Konas";
        ID = "konas";
        WATERMARK = "Konas";
        LOGGER = LogManager.getLogger((String)"Konas");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent fMLInitializationEvent) {
        8k_0.c.0();
    }
}

