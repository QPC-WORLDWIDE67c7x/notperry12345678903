/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import me.darki.konas.3F;
import me.darki.konas.6N;
import net.minecraft.network.NettyCompressionDecoder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value={NettyCompressionDecoder.class})
public class MixinNettyCompressionDecoder {
    @ModifyConstant(method={"decode"}, constant={@Constant(intValue=0x200000)})
    private int onCompressionCheck(int n2) {
        if (3F.c(6N.class).f()) {
            return Integer.MAX_VALUE;
        }
        return n2;
    }
}

