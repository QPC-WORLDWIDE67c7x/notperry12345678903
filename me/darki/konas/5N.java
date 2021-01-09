/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.util.Objects;
import me.darki.konas.0S;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.8p_0;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.network.play.server.SPacketBlockBreakAnim;
import net.minecraft.util.math.BlockPos;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 5N
extends 3E {
    public static String c(BlockPos blockPos) {
        double d2 = Math.floor(5N.c.player.posX);
        double d3 = Math.floor(5N.c.player.posZ);
        double d4 = d2 - (double)blockPos.getX();
        double d5 = d3 - (double)blockPos.getZ();
        switch (5N.c.player.getHorizontalFacing()) {
            case SOUTH: {
                if (d4 == 1.0) {
                    return "right";
                }
                if (d4 == -1.0) {
                    return "left";
                }
                if (d5 == 1.0) {
                    return "back";
                }
                if (d5 != -1.0) break;
                return "front";
            }
            case WEST: {
                if (d4 == 1.0) {
                    return "front";
                }
                if (d4 == -1.0) {
                    return "back";
                }
                if (d5 == 1.0) {
                    return "right";
                }
                if (d5 != -1.0) break;
                return "left";
            }
            case NORTH: {
                if (d4 == 1.0) {
                    return "left";
                }
                if (d4 == -1.0) {
                    return "right";
                }
                if (d5 == 1.0) {
                    return "front";
                }
                if (d5 != -1.0) break;
                return "back";
            }
            case EAST: {
                if (d4 == 1.0) {
                    return "back";
                }
                if (d4 == -1.0) {
                    return "front";
                }
                if (d5 == 1.0) {
                    return "left";
                }
                if (d5 != -1.0) break;
                return "right";
            }
            default: {
                return "undetermined";
            }
        }
        return null;
    }

    public 5N() {
        super("HoleBreakAlert", 3D.3, "HoleBreakNotifier");
    }

    @Subscriber
    public void c(0S s) {
        block0: {
            SPacketBlockBreakAnim sPacketBlockBreakAnim;
            if (!(s.c() instanceof SPacketBlockBreakAnim) || !this.0((sPacketBlockBreakAnim = (SPacketBlockBreakAnim)s.c()).getPosition())) break block0;
            8p_0.c("The hole block to your " + 5N.c(sPacketBlockBreakAnim.getPosition()) + " is being broken by " + Objects.requireNonNull(5N.c.world.getEntityByID(sPacketBlockBreakAnim.getBreakerId())).getName(), 44420);
        }
    }

    public boolean 0(BlockPos blockPos) {
        double d2 = Math.floor(5N.c.player.posX);
        double d3 = Math.floor(5N.c.player.posZ);
        Block block = 5N.c.world.getBlockState(blockPos).getBlock();
        if (block == Blocks.BEDROCK || block == Blocks.OBSIDIAN) {
            if ((double)blockPos.getX() == d2 + 1.0 && blockPos.getY() == 5N.c.player.getPosition().getY()) {
                return true;
            }
            if ((double)blockPos.getX() == d2 - 1.0 && blockPos.getY() == 5N.c.player.getPosition().getY()) {
                return true;
            }
            if ((double)blockPos.getZ() == d3 + 1.0 && blockPos.getY() == 5N.c.player.getPosition().getY()) {
                return true;
            }
            return (double)blockPos.getZ() == d3 - 1.0 && blockPos.getY() == 5N.c.player.getPosition().getY();
        }
        return false;
    }
}

