/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import cookiedragon.eventsystem.EventDispatcher;
import java.util.Random;
import me.darki.konas.1h_0;
import net.minecraft.block.BlockEnchantmentTable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={BlockEnchantmentTable.class})
public class MixinBlockEnchantmentTable {
    @Inject(method={"randomDisplayTick"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/World;spawnParticle(Lnet/minecraft/util/EnumParticleTypes;DDDDDD[I)V")}, cancellable=true)
    public void enchantmentParticle(IBlockState stateIn, World worldIn, BlockPos pos, Random rand, CallbackInfo ci) {
        1h_0 event = new 1h_0();
        EventDispatcher.Companion.dispatch(event);
        if (event.0()) {
            ci.cancel();
        }
    }
}

