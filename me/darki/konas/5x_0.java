/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.util.Comparator;
import me.darki.konas.1P;
import me.darki.konas.1Q;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.8D;
import me.darki.konas.8L;
import me.darki.konas.8h_0;
import me.darki.konas.8k_0;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemExpBottle;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 * Renamed from me.darki.konas.5x
 */
public class 5x_0
extends 3E {
    public 8h_0<Boolean> 1;
    public 8h_0<Boolean> 2;
    public 8h_0<Boolean> 3;
    public 8h_0<Boolean> 4;
    public 8h_0<Integer> 5;
    public 8h_0<Boolean> 6;
    public 8h_0<Float> 7;
    public boolean 1 = false;
    public static boolean 2 = false;
    public float c = 0.0f;

    public static EntityEnderCrystal c(Entity entity) {
        return (EntityEnderCrystal)entity;
    }

    @Override
    public void 7() {
        2 = false;
    }

    public 5x_0() {
        super("AutoMend", 3D.3, new String[0]);
        this.2 = new 8h_0("AutoXP", false);
        this.3 = new 8h_0("AutoSwitch", false);
        this.4 = new 8h_0("Armor", false);
        this.5 = new 8h_0("Threshold", 60, 100, 0, 1);
        this.6 = new 8h_0("AttackCheck", true);
        this.7 = new 8h_0("CrystalRange", Float.valueOf(6.0f), Float.valueOf(10.0f), Float.valueOf(0.0f), Float.valueOf(0.1f)).c(this.6::6);
    }

    @Override
    public void c() {
        this.c = 0.0f;
    }

    public int c() {
        ItemStack itemStack = 5x_0.c.player.getHeldItemMainhand();
        if (!itemStack.isEmpty() && itemStack.getItem() instanceof ItemExpBottle) {
            return 5x_0.c.player.inventory.currentItem;
        }
        for (int i2 = 0; i2 < 9; ++i2) {
            itemStack = 5x_0.c.player.inventory.getStackInSlot(i2);
            if (itemStack.isEmpty() || !(itemStack.getItem() instanceof ItemExpBottle)) continue;
            return i2;
        }
        return -1;
    }

    @Subscriber(priority=10)
    public void c(1Q q) {
        block11: {
            block12: {
                ItemStack itemStack;
                int n2;
                if (5x_0.c.player == null || 5x_0.c.world == null) {
                    return;
                }
                EntityEnderCrystal entityEnderCrystal = 5x_0.c.world.loadedEntityList.stream().filter(this::0).map(5x_0::c).min(Comparator.comparing(5x_0::c)).orElse(null);
                if ((entityEnderCrystal != null || 5x_0.c.player.getHealth() + 5x_0.c.player.getAbsorptionAmount() < this.c) && ((Boolean)this.6.6()).booleanValue()) {
                    2 = false;
                    this.1 = false;
                    this.d();
                    return;
                }
                this.c = 5x_0.c.player.getHealth() + 5x_0.c.player.getAbsorptionAmount();
                if (5x_0.c.player.getHeldItem(EnumHand.MAIN_HAND).getItem() != Items.EXPERIENCE_BOTTLE && (!((Boolean)this.3.6()).booleanValue() || this.c() == -1)) break block11;
                if (!(q instanceof 1P)) break block12;
                if (q.0() || !8L.c()) {
                    return;
                }
                this.1 = false;
                if (((Boolean)this.1.6()).booleanValue()) {
                    8k_0.c.c.c(5x_0.c.player.rotationYaw, 90.0f);
                }
                if (!((Boolean)this.4.6()).booleanValue()) break block11;
                ItemStack[] itemStackArray = new ItemStack[]{5x_0.c.player.inventory.getStackInSlot(39), 5x_0.c.player.inventory.getStackInSlot(38), 5x_0.c.player.inventory.getStackInSlot(37), 5x_0.c.player.inventory.getStackInSlot(36)};
                for (n2 = 0; n2 < 4; ++n2) {
                    itemStack = itemStackArray[n2];
                    if (!(itemStack.getItem() instanceof ItemArmor) || 8D.c(itemStack) < (float)((Integer)this.5.6()).intValue()) continue;
                    for (int i2 = 0; i2 < 36; ++i2) {
                        ItemStack itemStack2 = 5x_0.c.player.inventory.getStackInSlot(i2);
                        if (!itemStack2.isEmpty() || itemStack2.getItem() != Items.AIR) continue;
                        2 = true;
                        5x_0.c.playerController.windowClick(5x_0.c.player.inventoryContainer.windowId, n2 + 5, 0, ClickType.PICKUP, (EntityPlayer)5x_0.c.player);
                        5x_0.c.playerController.windowClick(5x_0.c.player.inventoryContainer.windowId, i2 < 9 ? i2 + 36 : i2, 0, ClickType.PICKUP, (EntityPlayer)5x_0.c.player);
                        5x_0.c.playerController.windowClick(5x_0.c.player.inventoryContainer.windowId, n2 + 5, 0, ClickType.PICKUP, (EntityPlayer)5x_0.c.player);
                        5x_0.c.playerController.updateController();
                        return;
                    }
                }
                for (n2 = 0; n2 < 4; ++n2) {
                    itemStack = itemStackArray[n2];
                    if (!(itemStack.getItem() instanceof ItemArmor) || 8D.c(itemStack) >= (float)((Integer)this.5.6()).intValue()) continue;
                    this.1 = true;
                }
                if (!this.1) {
                    2 = false;
                    this.d();
                }
                break block11;
            }
            if (!((Boolean)this.2.6()).booleanValue() || ((Boolean)this.4.6()).booleanValue() && !this.1) break block11;
            int n3 = this.c();
            boolean bl = ((Boolean)this.3.6()).booleanValue() && 5x_0.c.player.inventory.currentItem != n3 && n3 != -1;
            int n4 = 5x_0.c.player.inventory.currentItem;
            if (bl) {
                5x_0.c.player.inventory.currentItem = n3;
                5x_0.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(n3));
            }
            if (5x_0.c.player.getHeldItem(EnumHand.MAIN_HAND).getItem() instanceof ItemExpBottle) {
                5x_0.c.playerController.processRightClick((EntityPlayer)5x_0.c.player, (World)5x_0.c.world, EnumHand.MAIN_HAND);
            }
            if (bl) {
                5x_0.c.player.inventory.currentItem = n4;
                5x_0.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(n4));
            }
        }
    }

    public boolean 0(Entity entity) {
        return entity instanceof EntityEnderCrystal && 5x_0.c.player.getDistance(entity) <= ((Float)this.7.6()).floatValue();
    }

    public static Float c(EntityEnderCrystal entityEnderCrystal) {
        return Float.valueOf(5x_0.c.player.getDistance((Entity)entityEnderCrystal));
    }
}

