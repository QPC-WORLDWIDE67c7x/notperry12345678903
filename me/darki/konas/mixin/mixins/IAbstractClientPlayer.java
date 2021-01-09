/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.network.NetworkPlayerInfo;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={AbstractClientPlayer.class})
public interface IAbstractClientPlayer {
    @Accessor(value="playerInfo")
    public void setPlayerInfo(NetworkPlayerInfo var1);
}

