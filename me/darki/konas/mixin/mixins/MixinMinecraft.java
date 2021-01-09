/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import com.viaversion.viafabric.ViaFabric;
import cookiedragon.eventsystem.EventDispatcher;
import me.darki.konas.0A;
import me.darki.konas.0F;
import me.darki.konas.0c_0;
import me.darki.konas.1A;
import me.darki.konas.3F;
import me.darki.konas.7N;
import me.darki.konas.KonasMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.toasts.GuiToast;
import net.minecraft.client.main.GameConfiguration;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={Minecraft.class}, priority=2147483547)
public class MixinMinecraft {
    @Redirect(method={"sendClickBlockToController"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/entity/EntityPlayerSP;isHandActive()Z"))
    public boolean handActiveRedirect(EntityPlayerSP entityPlayerSP) {
        0A event = new 0A(entityPlayerSP.isHandActive());
        EventDispatcher.Companion.dispatch(event);
        return event.c();
    }

    @Inject(method={"runGameLoop"}, at={@At(value="HEAD")})
    private void onRunGameLoop(CallbackInfo callbackInfo) {
        1A event = new 1A();
        EventDispatcher.Companion.dispatch(event);
    }

    @Redirect(method={"runGameLoop"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/gui/toasts/GuiToast;drawToast(Lnet/minecraft/client/gui/ScaledResolution;)V"))
    public void onRenderToast(GuiToast guiToast, ScaledResolution resolution) {
        if (3F.c(7N.class).f() && ((Boolean)7N.r.6()).booleanValue()) {
            return;
        }
        guiToast.drawToast(resolution);
    }

    @Inject(method={"runTickKeyboard"}, at={@At(value="INVOKE", target="Lnet/minecraftforge/fml/common/FMLCommonHandler;fireKeyInput()V")})
    public void keyInject(CallbackInfo ci) {
        if (Keyboard.getEventKeyState()) {
            0F event = new 0F(Keyboard.getEventKey() == 0 ? Keyboard.getEventCharacter() + 256 : Keyboard.getEventKey());
            EventDispatcher.Companion.dispatch(event);
        }
    }

    @Inject(method={"runTickMouse"}, at={@At(value="INVOKE", target="Lnet/minecraftforge/fml/common/FMLCommonHandler;fireMouseInput()V")})
    public void mouseInject(CallbackInfo ci) {
        if (Mouse.getEventButtonState()) {
            0F event = new 0F(Mouse.getEventButton() - 100);
            EventDispatcher.Companion.dispatch(event);
        }
    }

    @Redirect(method={"rightClickMouse"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/multiplayer/PlayerControllerMP;getIsHittingBlock()Z", ordinal=0), require=1)
    public boolean rightClickRedirect(PlayerControllerMP playerControllerMP) {
        0A event = new 0A(playerControllerMP.getIsHittingBlock());
        EventDispatcher.Companion.dispatch(event);
        return event.c();
    }

    @Redirect(method={"sendClickBlockToController"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/multiplayer/PlayerControllerMP;resetBlockRemoving()V"))
    public void resetRedirect(PlayerControllerMP playerControllerMP) {
        0c_0 event = 0c_0.c();
        EventDispatcher.Companion.dispatch(event);
        if (event.0()) {
            return;
        }
        playerControllerMP.resetBlockRemoving();
    }

    @Inject(method={"<init>"}, at={@At(value="RETURN")})
    public void injectConstructor(GameConfiguration p_i45547_1_, CallbackInfo ci) {
        try {
            ViaFabric.getInstance().start();
        }
        catch (Exception e2) {
            KonasMod.LOGGER.error("Error starting ViaVersion");
        }
    }
}

