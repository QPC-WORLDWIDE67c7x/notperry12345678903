/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import cookiedragon.eventsystem.EventDispatcher;
import me.darki.konas.0j_0;
import me.darki.konas.0y_0;
import net.minecraft.entity.passive.AbstractHorse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={AbstractHorse.class})
public class MixinAbstractHorse {
    @Inject(method={"canBeSteered"}, at={@At(value="HEAD")}, cancellable=true)
    public void canBeSteered(CallbackInfoReturnable<Boolean> ci) {
        0j_0 entitySteerEvent = 0j_0.c((AbstractHorse)this);
        EventDispatcher.Companion.dispatch(entitySteerEvent);
        if (entitySteerEvent.0()) {
            ci.setReturnValue((Object)true);
        }
    }

    @Inject(method={"isHorseSaddled"}, at={@At(value="HEAD")}, cancellable=true)
    public void isHorseSaddled(CallbackInfoReturnable<Boolean> ci) {
        0y_0 horseSaddledEvent = new 0y_0((AbstractHorse)this);
        EventDispatcher.Companion.dispatch(horseSaddledEvent);
        if (horseSaddledEvent.0()) {
            ci.setReturnValue((Object)true);
        }
    }
}

