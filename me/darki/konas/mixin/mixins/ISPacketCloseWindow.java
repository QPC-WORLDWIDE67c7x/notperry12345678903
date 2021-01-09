/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import net.minecraft.network.play.server.SPacketCloseWindow;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={SPacketCloseWindow.class})
public interface ISPacketCloseWindow {
    @Accessor(value="windowId")
    public int getWindowId();
}

