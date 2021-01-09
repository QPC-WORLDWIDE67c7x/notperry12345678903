/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import net.minecraft.network.play.client.CPacketUpdateSign;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={CPacketUpdateSign.class})
public interface ICPacketUpdateSign {
    @Accessor(value="lines")
    public void setLines(String[] var1);

    @Accessor(value="lines")
    public String[] getLines();
}

