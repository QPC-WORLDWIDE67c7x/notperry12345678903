/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import cookiedragon.eventsystem.EventDispatcher;
import me.darki.konas.0e_0;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={ItemFood.class})
public class MixinItemFood {
    @Inject(method={"onItemUseFinish"}, at={@At(value="INVOKE", target="Lnet/minecraft/entity/player/EntityPlayer;addStat(Lnet/minecraft/stats/StatBase;)V")})
    public void onFoodEaten(ItemStack stack, World worldIn, EntityLivingBase entityLiving, CallbackInfoReturnable<ItemStack> cir) {
        0e_0 event = new 0e_0(stack, (EntityPlayer)entityLiving);
        EventDispatcher.Companion.dispatch(event);
    }
}

