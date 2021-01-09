/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import cookiedragon.eventsystem.EventDispatcher;
import java.util.List;
import kotlin.collections.CollectionsKt;
import me.darki.konas.1w_0;
import me.darki.konas.7u_0;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiPlayerTabOverlay;
import net.minecraft.client.network.NetworkPlayerInfo;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={GuiPlayerTabOverlay.class}, priority=2147463647)
public class MixinGuiPlayerTabOverlay {
    private List<NetworkPlayerInfo> preSubList = CollectionsKt.emptyList();

    @ModifyVariable(method={"renderPlayerlist"}, at=@At(value="STORE", ordinal=0), ordinal=0)
    public List<NetworkPlayerInfo> renderPlayerlistStorePlayerListPre(List<NetworkPlayerInfo> list) {
        this.preSubList = list;
        return list;
    }

    @ModifyVariable(method={"renderPlayerlist"}, at=@At(value="STORE", ordinal=1), ordinal=0)
    public List<NetworkPlayerInfo> renderPlayerlistStorePlayerListPost(List<NetworkPlayerInfo> list) {
        return 7u_0.c(this.preSubList, list);
    }

    @Redirect(method={"renderPlayerlist"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/gui/FontRenderer;drawStringWithShadow(Ljava/lang/String;FFI)I"))
    public int onRenderPlayerName(FontRenderer fontRenderer, String text, float x, float y, int color) {
        1w_0 event = new 1w_0(text);
        EventDispatcher.Companion.dispatch(event);
        return fontRenderer.drawStringWithShadow(event.c(), x, y, color);
    }
}

