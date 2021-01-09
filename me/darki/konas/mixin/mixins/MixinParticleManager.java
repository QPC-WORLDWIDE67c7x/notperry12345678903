/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import cookiedragon.eventsystem.EventDispatcher;
import me.darki.konas.0V;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={ParticleManager.class})
public class MixinParticleManager {
    @Inject(method={"addEffect"}, at={@At(value="HEAD")}, cancellable=true)
    public void addEffect(Particle effect, CallbackInfo ci) {
        0V event = new 0V(effect);
        EventDispatcher.Companion.dispatch(event);
        if (event.0()) {
            ci.cancel();
        }
    }
}

