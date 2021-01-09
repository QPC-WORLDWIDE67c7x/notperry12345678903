/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.0T;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.mixin.mixins.ICPacketPlayerTryUseItemOnBlock;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.util.EnumFacing;

/*
 * Renamed from me.darki.konas.5j
 */
public class 5j_0
extends 3E {
    public 5j_0() {
        super("WorldBorder", "Bypass World Border, only works on some servers", 3D.4, new String[0]);
    }

    @Subscriber
    public void c(0T t) {
        if (t.c() instanceof CPacketPlayerTryUseItemOnBlock) {
            CPacketPlayerTryUseItemOnBlock cPacketPlayerTryUseItemOnBlock = (CPacketPlayerTryUseItemOnBlock)t.c();
            if (cPacketPlayerTryUseItemOnBlock.getPos().getY() >= 255 && cPacketPlayerTryUseItemOnBlock.getDirection() == EnumFacing.UP) {
                ((ICPacketPlayerTryUseItemOnBlock)cPacketPlayerTryUseItemOnBlock).setPlacedBlockDirection(EnumFacing.DOWN);
            } else if (!5j_0.c.world.getWorldBorder().contains(cPacketPlayerTryUseItemOnBlock.getPos())) {
                switch (cPacketPlayerTryUseItemOnBlock.getDirection()) {
                    case EAST: {
                        ((ICPacketPlayerTryUseItemOnBlock)cPacketPlayerTryUseItemOnBlock).setPlacedBlockDirection(EnumFacing.WEST);
                        break;
                    }
                    case NORTH: {
                        ((ICPacketPlayerTryUseItemOnBlock)cPacketPlayerTryUseItemOnBlock).setPlacedBlockDirection(EnumFacing.SOUTH);
                        break;
                    }
                    case WEST: {
                        ((ICPacketPlayerTryUseItemOnBlock)cPacketPlayerTryUseItemOnBlock).setPlacedBlockDirection(EnumFacing.EAST);
                        break;
                    }
                    case SOUTH: {
                        ((ICPacketPlayerTryUseItemOnBlock)cPacketPlayerTryUseItemOnBlock).setPlacedBlockDirection(EnumFacing.NORTH);
                        break;
                    }
                }
            }
        }
    }
}

