/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.io.File;
import me.darki.konas.0I;
import me.darki.konas.8u_0;
import me.darki.konas.T;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.GuiConnecting;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 25 {
    public static 25 c = new 25();
    public static Minecraft c = Minecraft.getMinecraft();

    public static void c(File file) {
        T.0(T.3);
        T.c(file, false);
        System.out.println("Loaded Config for " + 25.c.getCurrentServerData().serverIP);
    }

    @Subscriber
    public void c(0I i2) {
        block1: {
            if (!(i2.c() instanceof GuiConnecting) || c.getCurrentServerData() == null) break block1;
            8u_0.c();
            File file = new File(T.1, "@" + 25.c.getCurrentServerData().serverIP + ".json");
            if (file.exists()) {
                new Thread(() -> 25.c(file)).start();
            }
        }
    }
}

