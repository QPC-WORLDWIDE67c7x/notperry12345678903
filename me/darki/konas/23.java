/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.0F;
import me.darki.konas.1a_0;
import me.darki.konas.2n_0;
import me.darki.konas.3B;
import me.darki.konas.3C;
import me.darki.konas.3E;
import me.darki.konas.3F;
import me.darki.konas.3P;
import me.darki.konas.8x_0;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import org.lwjgl.input.Keyboard;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 23 {
    public static 23 c = new 23();
    public static boolean c = false;

    @Subscriber
    public void c(1a_0 a_02) {
        if (Minecraft.getMinecraft().currentScreen != null && (Minecraft.getMinecraft().currentScreen instanceof 2n_0 || Minecraft.getMinecraft().currentScreen instanceof GuiChat)) {
            return;
        }
        for (3E e2 : 3F.2()) {
            if (!e2.3()) continue;
            if (8x_0.c(e2.6()) && !e2.f()) {
                e2.d();
                continue;
            }
            if (8x_0.c(e2.6()) || !e2.f()) continue;
            e2.d();
        }
    }

    @Subscriber
    public void c(0F f2) {
        if (f2.c() == 0) {
            return;
        }
        if (Keyboard.isKeyDown((int)61)) {
            return;
        }
        for (3E object : 3F.2()) {
            if (object.3() || object.6() != f2.c()) continue;
            object.d();
        }
        if (3F.c(3P.class).f()) {
            for (3B b2 : 3C.0()) {
                if (b2.c() != f2.c()) continue;
                c = true;
                b2.0();
                c = false;
            }
        }
    }
}

