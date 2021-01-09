/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.util.Comparator;
import me.darki.konas.1O;
import me.darki.konas.1P;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.8L;
import me.darki.konas.8h_0;
import me.darki.konas.8k_0;
import me.darki.konas.8x_0;
import me.darki.konas.9m;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemNameTag;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.util.EnumHand;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.5z
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 5z_0
extends 3E {
    public static 8h_0<Float> 1 = new 8h_0("Range", Float.valueOf(4.3f), Float.valueOf(6.0f), Float.valueOf(0.5f), Float.valueOf(0.1f));
    public static 8h_0<Boolean> 2 = new 8h_0("Rotate", true);
    public static 8h_0<Boolean> 3 = new 8h_0("IgnoreNamed", true);
    public static 8h_0<Boolean> 4 = new 8h_0("AutoSwitch", true);
    public static 8h_0<Boolean> 5 = new 8h_0("Withers", true);
    public static 8h_0<Boolean> 6 = new 8h_0("Mobs", false);
    public static 8h_0<Boolean> 7 = new 8h_0("Animals", false);
    public 9m c;
    public float c;
    public float 0;
    public EntityLivingBase c = null;
    public int 1;

    public static Float c(EntityLivingBase entityLivingBase) {
        return Float.valueOf(((Minecraft)5z_0.c).player.getDistance((Entity)entityLivingBase));
    }

    public boolean c() {
        return ((Minecraft)5z_0.c).player.getHeldItemOffhand().getItem() == Items.NAME_TAG;
    }

    public boolean 0(Entity entity) {
        if (!entity.getCustomNameTag().isEmpty() && ((Boolean)3.6()).booleanValue()) {
            return false;
        }
        if (((Boolean)7.6()).booleanValue() && entity instanceof EntityAnimal) {
            return true;
        }
        if (((Boolean)6.6()).booleanValue() && entity instanceof IMob) {
            return true;
        }
        return (Boolean)5.6() != false && entity instanceof EntityWither;
    }

    @Subscriber
    public void c(1O o2) {
        block1: {
            if (this.c != null) {
                5z_0.c.player.connection.sendPacket((Packet)new CPacketUseEntity((Entity)this.c, this.c() ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND));
            }
            if (this.1 == 5z_0.c.player.inventory.currentItem) break block1;
            5z_0.c.player.inventory.currentItem = this.1;
            ((Minecraft)5z_0.c).playerController.updateController();
        }
    }

    public static EntityLivingBase c(Entity entity) {
        return (EntityLivingBase)entity;
    }

    public 5z_0() {
        super("AutoNametag", "Automatically right clicks entities to name them", 3D.3, new String[0]);
    }

    @Subscriber(priority=3)
    public void c(1P p2) {
        block7: {
            ItemStack itemStack;
            this.c = null;
            if (p2.0() || !8L.c()) {
                return;
            }
            this.1 = 5z_0.c.player.inventory.currentItem;
            if (!(((Minecraft)5z_0.c).player.getHeldItemMainhand().getItem() instanceof ItemNameTag) && !this.c()) {
                int n2 = -1;
                if (((Boolean)4.6()).booleanValue()) {
                    for (int i2 = 0; i2 < 9; ++i2) {
                        ItemStack itemStack2 = 5z_0.c.player.inventory.getStackInSlot(i2);
                        if (itemStack2.isEmpty() || !(itemStack2.getItem() instanceof ItemNameTag) || !itemStack2.hasDisplayName()) continue;
                        5z_0.c.player.inventory.currentItem = n2 = i2;
                        ((Minecraft)5z_0.c).playerController.updateController();
                        break;
                    }
                }
                if (n2 == -1) {
                    return;
                }
            }
            ItemStack itemStack3 = itemStack = this.c() ? ((Minecraft)5z_0.c).player.getHeldItemOffhand() : ((Minecraft)5z_0.c).player.getHeldItemMainhand();
            if (!itemStack.hasDisplayName()) {
                return;
            }
            this.c = 5z_0.c.world.loadedEntityList.stream().filter(this::0).map(5z_0::c).min(Comparator.comparing(5z_0::c)).orElse(null);
            if (this.c != null && ((Boolean)2.6()).booleanValue()) {
                double[] dArray = 8x_0.c(this.c.posX, this.c.posY, this.c.posZ, (EntityPlayer)((Minecraft)5z_0.c).player);
                this.c = (float)dArray[0];
                this.0 = (float)dArray[1];
                this.c.c();
            }
            if (!((Boolean)2.6()).booleanValue() || this.c.c(350.0)) break block7;
            8k_0.c.c.c(this.c, this.0);
        }
    }
}

