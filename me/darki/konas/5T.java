/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.EventDispatcher;
import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.09;
import me.darki.konas.0F;
import me.darki.konas.1N;
import me.darki.konas.1O;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.3F;
import me.darki.konas.3y_0;
import me.darki.konas.5J;
import me.darki.konas.5S;
import me.darki.konas.8J;
import me.darki.konas.8h_0;
import me.darki.konas.8p_0;
import me.darki.konas.8r_0;
import me.darki.konas.9m;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.gameevent.TickEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 5T
extends 3E {
    public static 8h_0<5S> 1 = new 8h_0("Action", 5S.c);
    public static 8h_0<Integer> 2 = new 8h_0("Range", 40, 250, 10, 10).c(5T::6);
    public static 8h_0<Boolean> 3 = new 8h_0("ThroughWalls", true).c(5T::c);
    public 8h_0<Boolean> 4 = new 8h_0("Rocket", false);
    public 8h_0<Boolean> 5 = new 8h_0("EP", false);
    public 8h_0<Boolean> 6 = new 8h_0("XP", false);
    public 8h_0<Boolean> 7 = new 8h_0("XPInHoles", false).c(this.6::6);
    public 9m c = new 9m();
    public int 1;
    public boolean 1 = true;

    public static EntityPlayer c(int n2) {
        Entity entity = c.getRenderViewEntity();
        if (entity != null) {
            Vec3d vec3d = ((Minecraft)5T.c).player.getPositionEyes(1.0f);
            for (float f2 = 0.0f; f2 < (float)n2; f2 += 0.5f) {
                vec3d = vec3d.add(((Minecraft)5T.c).player.getLookVec().scale(0.5));
                if (!((Boolean)3.6()).booleanValue() && ((Minecraft)5T.c).world.getBlockState(new BlockPos(vec3d.x, vec3d.y, vec3d.z)).getBlock() != Blocks.AIR) {
                    return null;
                }
                for (EntityPlayer entityPlayer : 5T.c.world.playerEntities) {
                    AxisAlignedBB axisAlignedBB;
                    if (entityPlayer == ((Minecraft)5T.c).player || (axisAlignedBB = entityPlayer.getEntityBoundingBox()) == null) continue;
                    if (entityPlayer.getDistance((Entity)((Minecraft)5T.c).player) > 6.0f) {
                        axisAlignedBB = axisAlignedBB.grow(0.5);
                    }
                    if (!axisAlignedBB.contains(vec3d)) continue;
                    return entityPlayer;
                }
            }
        }
        return null;
    }

    public int 7() {
        int n2 = -1;
        if (((Minecraft)5T.c).player.getHeldItemMainhand().getItem() == Items.FIREWORKS) {
            n2 = 5T.c.player.inventory.currentItem;
        }
        if (n2 == -1) {
            for (int i2 = 0; i2 < 9; ++i2) {
                if (5T.c.player.inventory.getStackInSlot(i2).getItem() != Items.FIREWORKS) continue;
                n2 = i2;
                break;
            }
        }
        return n2;
    }

    @Subscriber
    public void c(1O o2) {
        if (GameSettings.isKeyDown((KeyBinding)5T.c.gameSettings.keyBindPickBlock) && this.c.c(350.0)) {
            if (((Boolean)this.6.6()).booleanValue() && (!((Boolean)this.7.6()).booleanValue() || 8r_0.1(new BlockPos((Entity)((Minecraft)5T.c).player)))) {
                int n2 = this.0();
                if (this.1) {
                    this.1 = 5T.c.player.inventory.currentItem;
                    this.1 = false;
                }
                if (n2 != -1) {
                    5T.c.player.inventory.currentItem = n2;
                    5T.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(n2));
                    ((Minecraft)5T.c).playerController.processRightClick((EntityPlayer)((Minecraft)5T.c).player, (World)((Minecraft)5T.c).world, EnumHand.MAIN_HAND);
                }
            }
        } else if (this.1 != -1) {
            5T.c.player.inventory.currentItem = this.1;
            5T.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(this.1));
            this.1 = -1;
            this.1 = true;
        }
    }

    public static Vec3d c(float f2, float f3) {
        float f4 = MathHelper.cos((float)(-f3 * ((float)Math.PI / 180) - (float)Math.PI));
        float f5 = MathHelper.sin((float)(-f3 * ((float)Math.PI / 180) - (float)Math.PI));
        float f6 = -MathHelper.cos((float)(-f2 * ((float)Math.PI / 180)));
        float f7 = MathHelper.sin((float)(-f2 * ((float)Math.PI / 180)));
        return new Vec3d((double)(f5 * f6), (double)f7, (double)(f4 * f6));
    }

    public 5T() {
        super("MiddleClick", 3D.3, "MiddleClickPearl", "MiddleClickEP", "MCF", "MCP", "MiddleClickFriends");
    }

    public static boolean c() {
        return 1.6() == 5S.c;
    }

    @Subscriber
    public void c(0F f2) {
        int n2;
        if (((Minecraft)5T.c).player == null || ((Minecraft)5T.c).world == null) {
            return;
        }
        if (f2.c() != 5T.c.gameSettings.keyBindPickBlock.getKeyCode()) {
            return;
        }
        if (1.6() == 5S.0 && 5T.c.objectMouseOver.entityHit != null) {
            Entity entity = 5T.c.objectMouseOver.entityHit;
            if (entity instanceof EntityPlayer) {
                if (8J.1(entity.getName())) {
                    8J.0(entity.getName());
                    8p_0.1("Removed \u00c2\u00a7b" + entity.getName() + "\u00c2\u00a7r as a friend!");
                } else {
                    8J.c(entity.getName(), entity.getUniqueID().toString());
                    if (3F.c(5J.class).f() && ((Boolean)5J.e.6()).booleanValue()) {
                        EventDispatcher.Companion.dispatch(new 09(entity.getName(), "I just friended you on Konas!"));
                    }
                    8p_0.1("Added \u00c2\u00a7b" + entity.getName() + "\u00c2\u00a7r as a friend!");
                }
                this.c.c();
                return;
            }
        }
        if (((Boolean)this.4.6()).booleanValue() && this.7() != -1) {
            this.c.c();
            int n3 = this.7();
            n2 = 5T.c.player.inventory.currentItem;
            if (n3 != -1) {
                5T.c.player.inventory.currentItem = n3;
                5T.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(n3));
                ((Minecraft)5T.c).playerController.processRightClick((EntityPlayer)((Minecraft)5T.c).player, (World)((Minecraft)5T.c).world, EnumHand.MAIN_HAND);
                5T.c.player.inventory.currentItem = n2;
                5T.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(n2));
                return;
            }
        }
        if (((Boolean)this.5.6()).booleanValue() && (!((Boolean)this.6.6()).booleanValue() || ((Boolean)this.7.6()).booleanValue() && !8r_0.1(new BlockPos((Entity)((Minecraft)5T.c).player)))) {
            int n4 = this.1();
            n2 = 5T.c.player.inventory.currentItem;
            if (n4 != -1) {
                5T.c.player.inventory.currentItem = n4;
                5T.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(n4));
                ((Minecraft)5T.c).playerController.processRightClick((EntityPlayer)((Minecraft)5T.c).player, (World)((Minecraft)5T.c).world, EnumHand.MAIN_HAND);
                5T.c.player.inventory.currentItem = n2;
                5T.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(n2));
                return;
            }
        }
    }

    public int 1() {
        int n2 = -1;
        if (((Minecraft)5T.c).player.getHeldItemMainhand().getItem() == Items.ENDER_PEARL) {
            n2 = 5T.c.player.inventory.currentItem;
        }
        if (n2 == -1) {
            for (int i2 = 0; i2 < 9; ++i2) {
                if (5T.c.player.inventory.getStackInSlot(i2).getItem() != Items.ENDER_PEARL) continue;
                n2 = i2;
                break;
            }
        }
        return n2;
    }

    public int 0() {
        int n2 = -1;
        if (((Minecraft)5T.c).player.getHeldItemMainhand().getItem() == Items.EXPERIENCE_BOTTLE) {
            n2 = 5T.c.player.inventory.currentItem;
        }
        if (n2 == -1) {
            for (int i2 = 0; i2 < 9; ++i2) {
                if (5T.c.player.inventory.getStackInSlot(i2).getItem() != Items.EXPERIENCE_BOTTLE) continue;
                n2 = i2;
                break;
            }
        }
        return n2;
    }

    public static boolean 6() {
        return 1.6() == 5S.c;
    }

    @Subscriber
    public void c(1N n2) {
        block5: {
            if (((Minecraft)5T.c).player == null || ((Minecraft)5T.c).world == null) {
                return;
            }
            if (n2.c() == TickEvent.Phase.END) {
                return;
            }
            if (1.6() != 5S.c) {
                return;
            }
            if (!GameSettings.isKeyDown((KeyBinding)5T.c.gameSettings.keyBindPickBlock)) {
                return;
            }
            EntityPlayer entityPlayer = 5T.c((Integer)2.6());
            if (entityPlayer == null) break block5;
            this.c.c();
            if (((Minecraft)5T.c).currentScreen == null) {
                c.displayGuiScreen(new 3y_0(entityPlayer));
            }
        }
    }
}

