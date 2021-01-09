/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import cookiedragon.eventsystem.EventDispatcher;
import me.darki.konas.0r_0;
import me.darki.konas.0t_0;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={World.class})
public class MixinWorld {
    @Inject(method={"getWorldTime"}, at={@At(value="HEAD")}, cancellable=true)
    public void onGetWorldTime(CallbackInfoReturnable<Long> cir) {
        0t_0 event = EventDispatcher.Companion.dispatch(new 0t_0());
        if (event.0()) {
            cir.setReturnValue((Object)event.c());
        }
    }

    @Inject(method={"getRainStrength"}, at={@At(value="HEAD")}, cancellable=true)
    public void getRainStrength(float delta, CallbackInfoReturnable<Float> ci) {
        0r_0 event = 0r_0.c();
        EventDispatcher.Companion.dispatch(event);
        if (event.0()) {
            ci.cancel();
            ci.setReturnValue((Object)Float.valueOf(0.0f));
        }
    }
}

