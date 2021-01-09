/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import cookiedragon.eventsystem.EventDispatcher;
import me.darki.konas.1T;
import me.darki.konas.3F;
import net.minecraft.client.multiplayer.WorldClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={WorldClient.class})
public class MixinWorldClient {
    @Inject(method={"<init>"}, at={@At(value="RETURN")})
    private void onWorldClientInit(CallbackInfo callbackInfo) {
        3F.0();
        1T event = new 1T();
        EventDispatcher.Companion.dispatch(event);
    }
}

