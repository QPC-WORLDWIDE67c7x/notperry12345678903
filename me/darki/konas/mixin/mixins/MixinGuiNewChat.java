/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import cookiedragon.eventsystem.EventDispatcher;
import me.darki.konas.03;
import me.darki.konas.0p_0;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={GuiNewChat.class}, priority=100005)
public class MixinGuiNewChat {
    @Redirect(method={"drawChat"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/gui/GuiNewChat;drawRect(IIIII)V"))
    private void drawRectBackgroundClean(int left, int top, int right, int bottom, int color) {
        03 event = new 03();
        EventDispatcher.Companion.dispatch(event);
        if (!event.0()) {
            Gui.drawRect((int)left, (int)top, (int)right, (int)bottom, (int)color);
        }
    }

    @Inject(method={"calculateChatboxHeight"}, at={@At(value="HEAD")}, cancellable=true)
    private static void onGetChatHeight(float scale, CallbackInfoReturnable<Integer> cir) {
        0p_0 event = new 0p_0(MathHelper.floor((float)(scale * 160.0f + 20.0f)));
        EventDispatcher.Companion.dispatch(event);
        cir.setReturnValue((Object)event.c());
    }
}

