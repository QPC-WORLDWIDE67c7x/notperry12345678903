/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.1C;
import me.darki.konas.1P;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.8L;
import me.darki.konas.8h_0;
import me.darki.konas.9m;
import me.darki.konas.mixin.mixins.IEntityPlayerSP;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 4F
extends 3E {
    public static 8h_0<Boolean> 1 = new 8h_0("Swiftness", false);
    public static 8h_0<Boolean> 2 = new 8h_0("Strength", false);
    public static 8h_0<Boolean> 3 = new 8h_0("Toggelable", false);
    public static 8h_0<Boolean> 4 = new 8h_0("AutoSwitch", false);
    public static 8h_0<Boolean> 5 = new 8h_0("Rearrange", false);
    public static 8h_0<Boolean> 6 = new 8h_0("NoGapSwitch", false);
    public static 8h_0<Integer> 7 = new 8h_0("MinHealth", 20, 36, 0, 1);
    public 9m c = new 9m();
    public boolean 1 = false;

    @Subscriber(priority=98)
    public void 0(1P p2) {
        block9: {
            block10: {
                if (((Minecraft)4F.c).player == null || ((Minecraft)4F.c).world == null) {
                    return;
                }
                if (p2.0() || !8L.c()) {
                    return;
                }
                if (!this.c.c(2500.0)) {
                    return;
                }
                if (((Minecraft)4F.c).player.getHealth() + ((Minecraft)4F.c).player.getAbsorptionAmount() < (float)((Integer)7.6()).intValue()) {
                    return;
                }
                if (((Boolean)6.6()).booleanValue() && ((Minecraft)4F.c).player.getActiveItemStack().getItem() instanceof ItemFood) {
                    return;
                }
                if (((Boolean)2.6()).booleanValue() && !((Minecraft)4F.c).player.isPotionActive(MobEffects.STRENGTH)) {
                    if (this.c("Arrow of Strength")) {
                        this.c(p2);
                    } else if (((Boolean)3.6()).booleanValue()) {
                        this.d();
                    }
                }
                if (!((Boolean)1.6()).booleanValue() || ((Minecraft)4F.c).player.isPotionActive(MobEffects.SPEED)) break block9;
                if (!this.c("Arrow of Swiftness")) break block10;
                this.c(p2);
                break block9;
            }
            if (!((Boolean)3.6()).booleanValue()) break block9;
            this.d();
        }
    }

    public void c(1P p2) {
        block3: {
            int n2;
            block1: {
                block2: {
                    if (4F.c.player.inventory.getCurrentItem().getItem() != Items.BOW) break block1;
                    4F.c.player.connection.sendPacket((Packet)new CPacketPlayer.Rotation(0.0f, -90.0f, 4F.c.player.onGround));
                    ((IEntityPlayerSP)((Minecraft)4F.c).player).setLastReportedYaw(0.0f);
                    ((IEntityPlayerSP)((Minecraft)4F.c).player).setLastReportedPitch(-90.0f);
                    if (((Minecraft)4F.c).player.getItemInUseMaxCount() < 3) break block2;
                    this.1 = false;
                    ((Minecraft)4F.c).playerController.onStoppedUsingItem((EntityPlayer)((Minecraft)4F.c).player);
                    if (((Boolean)3.6()).booleanValue()) {
                        this.d();
                    }
                    this.c.c();
                    break block3;
                }
                if (((Minecraft)4F.c).player.getItemInUseMaxCount() != 0) break block3;
                ((Minecraft)4F.c).playerController.processRightClick((EntityPlayer)((Minecraft)4F.c).player, (World)((Minecraft)4F.c).world, EnumHand.MAIN_HAND);
                this.1 = true;
                break block3;
            }
            if (!((Boolean)4.6()).booleanValue() || (n2 = this.c()) == -1 || n2 == 4F.c.player.inventory.currentItem) break block3;
            4F.c.player.inventory.currentItem = n2;
            ((Minecraft)4F.c).playerController.updateController();
        }
    }

    public boolean c(int n2, String string) {
        for (int i2 = 0; i2 < 36; ++i2) {
            ItemStack itemStack = 4F.c.player.inventory.getStackInSlot(i2);
            if (itemStack.getItem() != Items.TIPPED_ARROW || !itemStack.getDisplayName().equalsIgnoreCase(string)) continue;
            ((Minecraft)4F.c).playerController.windowClick(0, n2, 0, ClickType.PICKUP, (EntityPlayer)((Minecraft)4F.c).player);
            ((Minecraft)4F.c).playerController.windowClick(0, i2, 0, ClickType.PICKUP, (EntityPlayer)((Minecraft)4F.c).player);
            ((Minecraft)4F.c).playerController.windowClick(0, n2, 0, ClickType.PICKUP, (EntityPlayer)((Minecraft)4F.c).player);
            return true;
        }
        return false;
    }

    public boolean c(String string) {
        for (int i2 = 0; i2 < 36; ++i2) {
            ItemStack itemStack = 4F.c.player.inventory.getStackInSlot(i2);
            if (itemStack.getItem() != Items.TIPPED_ARROW) continue;
            boolean bl = itemStack.getDisplayName().equalsIgnoreCase(string);
            if (bl) {
                return true;
            }
            if (((Boolean)5.6()).booleanValue()) {
                return this.c(i2, string);
            }
            return false;
        }
        return false;
    }

    @Subscriber
    public void c(1C c2) {
        block0: {
            if (!this.1) break block0;
            c2.c(true);
        }
    }

    @Override
    public void c() {
        this.1 = false;
    }

    public int c() {
        int n2 = -1;
        if (((Minecraft)4F.c).player.getHeldItemMainhand().getItem() == Items.BOW) {
            n2 = 3E.c.player.inventory.currentItem;
        }
        if (n2 == -1) {
            for (int i2 = 0; i2 < 9; ++i2) {
                if (4F.c.player.inventory.getStackInSlot(i2).getItem() != Items.BOW) continue;
                n2 = i2;
                break;
            }
        }
        return n2;
    }

    public 4F() {
        super("SelfBow", "Shoots yourself", 3D.c, new String[0]);
    }
}

