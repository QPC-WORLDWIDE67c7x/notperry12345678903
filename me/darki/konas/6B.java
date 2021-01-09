/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.util.List;
import me.darki.konas.1P;
import me.darki.konas.3D;
import me.darki.konas.3E;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;

public class 6B
extends 3E {
    @Subscriber
    public void c(1P p2) {
        if (!6B.c.player.onGround || 6B.c.gameSettings.keyBindJump.isPressed()) {
            return;
        }
        if (6B.c.player.isSneaking() || 6B.c.gameSettings.keyBindSneak.isPressed()) {
            return;
        }
        AxisAlignedBB axisAlignedBB = 6B.c.player.getEntityBoundingBox();
        AxisAlignedBB axisAlignedBB2 = axisAlignedBB.offset(0.0, -0.5, 0.0).expand(-0.001, 0.0, -0.001);
        List list = 6B.c.world.getCollisionBoxes((Entity)6B.c.player, axisAlignedBB2);
        if (!list.isEmpty()) {
            return;
        }
        6B.c.player.jump();
    }

    public 6B() {
        super("Parkour", 3D.0, new String[0]);
    }
}

