/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import net.minecraft.network.play.client.CPacketVehicleMove;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={CPacketVehicleMove.class})
public interface ICPacketVehicleMove {
    @Accessor(value="y")
    public void setY(double var1);

    @Accessor(value="y")
    public double getY();
}

