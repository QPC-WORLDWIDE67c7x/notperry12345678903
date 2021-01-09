/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.08;
import me.darki.konas.0G;
import me.darki.konas.0g_0;
import me.darki.konas.16;
import me.darki.konas.1N;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.6R;
import me.darki.konas.8h_0;
import me.darki.konas.9m;
import me.darki.konas.mixin.mixins.IItemTool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.util.math.BlockPos;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 6S
extends 3E {
    public 8h_0<Boolean> 1;
    public 8h_0<6R> 2;
    public 8h_0<Boolean> 3;
    public 9m c;
    public boolean 1;
    public int 1 = -1;

    @Subscriber
    public void c(0G g2) {
        if (((Minecraft)6S.c).player == null || ((Minecraft)6S.c).world == null || g2.c() != ((Minecraft)6S.c).player) {
            return;
        }
        if (this.2.6() == 6R.c || this.2.6() == 6R.1) {
            return;
        }
        if (this.2.6() == 6R.2 && this.1) {
            return;
        }
        this.c(6S.c(g2.2()), false);
    }

    @Subscriber
    public void c(1N n2) {
        block5: {
            block4: {
                block3: {
                    block2: {
                        if (((Minecraft)6S.c).player == null || ((Minecraft)6S.c).world == null) break block2;
                        if (this.2.6() == 6R.2) break block3;
                    }
                    return;
                }
                if (((Minecraft)6S.c).playerController.getIsHittingBlock() || !this.1 || ((Boolean)this.3.6()).booleanValue() && !this.c.c(100.0)) break block4;
                this.c(this.1, true);
                break block5;
            }
            if (!this.1 || this.2.6() != 6R.1) break block5;
            this.c(this.1, true);
        }
    }

    @Subscriber
    public void c(08 var1_1) {
        if (((Minecraft)6S.c).player == null || ((Minecraft)6S.c).world == null) {
            return;
        }
        if (this.2.6() != 6R.1) {
            return;
        }
        if (this.1) {
            this.c(this.1, true);
        }
        this.c(6S.c(var1_1.2()), false);
    }

    public 6S() {
        super("AutoTool", "Swap to the best tool when mining and attacking", 3D.1, new String[0]);
        this.2 = new 8h_0("Mining", 6R.0);
        this.3 = new 8h_0("Strict", true);
        this.c = new 9m();
    }

    @Subscriber
    public void c(0g_0 g_02) {
        if (((Minecraft)6S.c).player == null || ((Minecraft)6S.c).world == null || !((Boolean)this.1.6()).booleanValue()) {
            return;
        }
        this.c(this.c(g_02.c()), false);
    }

    public int c(Entity entity) {
        int n2 = -1;
        float f2 = 0.0f;
        for (int i2 = 0; i2 < 9; ++i2) {
            float f3;
            ItemStack itemStack = 6S.c.player.inventory.getStackInSlot(i2);
            if (itemStack.isEmpty() || itemStack.getItem() == Items.AIR) continue;
            if (itemStack.getItem() instanceof ItemSword) {
                f3 = ((ItemSword)itemStack.getItem()).getAttackDamage() + EnchantmentHelper.getModifierForCreature((ItemStack)itemStack, (EnumCreatureAttribute)(entity instanceof EntityLivingBase ? ((EntityLivingBase)entity).getCreatureAttribute() : EnumCreatureAttribute.UNDEFINED));
                if (!(f3 > f2)) continue;
                f2 = f3;
                n2 = i2;
                continue;
            }
            if (!(itemStack.getItem() instanceof ItemTool) || !((f3 = ((IItemTool)itemStack.getItem()).getAttackDamage() + EnchantmentHelper.getModifierForCreature((ItemStack)itemStack, (EnumCreatureAttribute)(entity instanceof EntityLivingBase ? ((EntityLivingBase)entity).getCreatureAttribute() : EnumCreatureAttribute.UNDEFINED))) > f2)) continue;
            f2 = f3;
            n2 = i2;
        }
        return n2;
    }

    @Subscriber
    public void c(16 var1_1) {
        block0: {
            if (!this.1 || this.2.6() != 6R.1) break block0;
            this.c(this.1, true);
        }
    }

    public static int c(BlockPos blockPos) {
        IBlockState iBlockState = ((Minecraft)6S.c).world.getBlockState(blockPos);
        int n2 = -1;
        double d2 = 0.0;
        for (int i2 = 0; i2 < 9; ++i2) {
            int n3;
            float f2;
            ItemStack itemStack = 6S.c.player.inventory.getStackInSlot(i2);
            if (itemStack.isEmpty() || itemStack.getItem() == Items.AIR || !((f2 = itemStack.getDestroySpeed(iBlockState)) > 1.0f) || !((double)(f2 = (float)((double)f2 + ((n3 = EnchantmentHelper.getEnchantmentLevel((Enchantment)Enchantments.EFFICIENCY, (ItemStack)itemStack)) > 0 ? Math.pow(n3, 2.0) + 1.0 : 0.0))) > d2)) continue;
            d2 = f2;
            n2 = i2;
        }
        return n2;
    }

    public void c(int n2, boolean bl) {
        if (n2 != -1) {
            if (!bl) {
                this.1 = true;
                this.1 = 6S.c.player.inventory.currentItem;
            } else {
                this.1 = false;
                this.1 = -1;
            }
            6S.c.player.inventory.currentItem = n2;
            6S.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(6S.c.player.inventory.currentItem));
        }
        this.c.c();
    }
}

