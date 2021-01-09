/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.datasync.DataParameter;
import org.apache.commons.lang3.NotImplementedException;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={EntityPlayer.class})
public interface IEntityPlayer {
    @Accessor(value="PLAYER_MODEL_FLAG")
    public static DataParameter<Byte> getPlayerModelFlag() {
        throw new NotImplementedException("IEntityPlayer mixin failed to apply");
    }

    @Invoker(value="updateCape")
    public void invokeUpdateCape();
}

