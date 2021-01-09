/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.1A;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.8h_0;
import me.darki.konas.9m;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EnumPlayerModelParts;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 76
extends 3E {
    public static 8h_0<Float> 1 = new 8h_0("Delay", Float.valueOf(0.0f), Float.valueOf(20.0f), Float.valueOf(0.0f), Float.valueOf(0.1f));
    public static 8h_0<Boolean> 2 = new 8h_0("Random", true);
    public 9m c = new 9m();

    @Subscriber
    public void c(1A a2) {
        block1: {
            if (!this.c.c(((Float)1.6()).floatValue() * 1000.0f)) break block1;
            EnumPlayerModelParts[] enumPlayerModelPartsArray = EnumPlayerModelParts.values();
            for (int i2 = 0; i2 < enumPlayerModelPartsArray.length; ++i2) {
                EnumPlayerModelParts enumPlayerModelParts = enumPlayerModelPartsArray[i2];
                ((Minecraft)76.c).gameSettings.setModelPartEnabled(enumPlayerModelParts, ((Boolean)2.6()).booleanValue() ? Math.random() < 0.5 : !((Minecraft)76.c).gameSettings.getModelParts().contains(enumPlayerModelParts));
            }
            this.c.c();
        }
    }

    public 76() {
        super("SkinBlinker", "Flashes your skin parts", 3D.1, new String[0]);
    }
}

