/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import cookiedragon.eventsystem.EventDispatcher;
import javax.annotation.Nullable;
import me.darki.konas.0J;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={AbstractClientPlayer.class})
public abstract class MixinAbstractClientPlayer {
    @Shadow
    @Nullable
    protected abstract NetworkPlayerInfo getPlayerInfo();

    @Inject(method={"getLocationCape"}, at={@At(value="HEAD")}, cancellable=true)
    public void preGetLocationCape(CallbackInfoReturnable<ResourceLocation> callbackInfoReturnable) {
        NetworkPlayerInfo info = this.getPlayerInfo();
        if (info != null) {
            0J event = new 0J(info.getGameProfile().getName());
            EventDispatcher.Companion.dispatch(event);
            if (event.0()) {
                callbackInfoReturnable.setReturnValue((Object)event.c());
            }
        }
    }
}

