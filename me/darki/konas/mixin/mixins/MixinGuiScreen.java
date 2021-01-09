/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import cookiedragon.eventsystem.EventDispatcher;
import me.darki.konas.1r_0;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={GuiScreen.class})
public class MixinGuiScreen {
    @Inject(method={"renderToolTip"}, at={@At(value="HEAD")}, cancellable=true)
    private void toolTipHook(ItemStack itemStack, int x, int y, CallbackInfo ci) {
        1r_0 event = new 1r_0(itemStack, x, y);
        EventDispatcher.Companion.dispatch(event);
        if (event.0()) {
            ci.cancel();
        }
    }
}

