/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import com.viaversion.viafabric.ViaFabric;
import net.minecraft.client.multiplayer.GuiConnecting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={GuiConnecting.class})
public abstract class MixinGuiConnecting {
    @Inject(method={"connect"}, at={@At(value="HEAD")})
    public void injectConnect(String ip, int port, CallbackInfo ci) {
        ViaFabric.getInstance().setLastServer(ip + ":" + port);
    }
}

