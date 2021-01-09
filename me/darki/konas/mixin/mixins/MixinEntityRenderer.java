/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import cookiedragon.eventsystem.EventDispatcher;
import java.util.Objects;
import me.darki.konas.0P;
import me.darki.konas.0Q;
import me.darki.konas.0b_0;
import me.darki.konas.0o_0;
import me.darki.konas.0s_0;
import me.darki.konas.0z_0;
import me.darki.konas.17;
import me.darki.konas.1G;
import me.darki.konas.1J;
import me.darki.konas.1K;
import me.darki.konas.1X;
import me.darki.konas.1Y;
import me.darki.konas.1b_0;
import me.darki.konas.1p_0;
import me.darki.konas.84;
import me.darki.konas.99;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={EntityRenderer.class}, priority=0x7FFFFFFF)
public class MixinEntityRenderer {
    @Inject(method={"setupCameraTransform"}, at={@At(value="HEAD")})
    private void setupCameraTransformPre(float partialTicks, int pass, CallbackInfo ci) {
        1Y event = new 1Y();
        EventDispatcher.Companion.dispatch(event);
    }

    @Inject(method={"setupCameraTransform"}, at={@At(value="TAIL")})
    private void setupCameraTransformPost(float partialTicks, int pass, CallbackInfo ci) {
        1X event = new 1X();
        EventDispatcher.Companion.dispatch(event);
    }

    @Inject(method={"renderWorldPass"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/renderer/GlStateManager;clear(I)V", ordinal=1, shift=At.Shift.BEFORE)})
    private void renderWorldPass(int pass, float partialTicks, long finishTimeNano, CallbackInfo ci) {
        if (Display.isActive() || Display.isVisible()) {
            99.c();
            99.0();
            1b_0 event = 1b_0.c(partialTicks);
            EventDispatcher.Companion.dispatch(event);
            GlStateManager.resetColor();
            GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        }
    }

    @Inject(method={"renderWorldPass"}, at={@At(value="TAIL")})
    private void renderWorldPassPost(int pass, float partialTicks, long finishTimeNano, CallbackInfo ci) {
        if (Display.isActive() || Display.isVisible()) {
            17 pEvent = new 17();
            EventDispatcher.Companion.dispatch(pEvent);
        }
    }

    @Inject(method={"hurtCameraEffect"}, at={@At(value="HEAD")}, cancellable=true)
    public void hurtCameraEffect(float ticks, CallbackInfo info) {
        0z_0 event = new 0z_0();
        EventDispatcher.Companion.dispatch(event);
        if (event.0()) {
            info.cancel();
        }
    }

    @Inject(method={"isDrawBlockOutline"}, at={@At(value="HEAD")}, cancellable=true)
    public void injectIsDrawBlockOutline(CallbackInfoReturnable<Boolean> cir) {
        0b_0 event = 0b_0.c();
        EventDispatcher.Companion.dispatch(event);
        if (event.0()) {
            cir.setReturnValue((Object)false);
        }
    }

    @Inject(method={"getMouseOver"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/multiplayer/WorldClient;getEntitiesInAABBexcluding(Lnet/minecraft/entity/Entity;Lnet/minecraft/util/math/AxisAlignedBB;Lcom/google/common/base/Predicate;)Ljava/util/List;")}, cancellable=true)
    public void injectTraceEvent(float partialTicks, CallbackInfo ci) {
        1G event = new 1G();
        EventDispatcher.Companion.dispatch(event);
        if (event.0()) {
            ci.cancel();
        }
    }

    @ModifyVariable(method={"orientCamera"}, ordinal=3, at=@At(value="STORE", ordinal=0), require=1)
    public double orientCameraDist(double distance) {
        0Q event = new 0Q(distance);
        EventDispatcher.Companion.dispatch(event);
        if (event.0()) {
            return event.c();
        }
        return distance;
    }

    @ModifyVariable(method={"orientCamera"}, ordinal=7, at=@At(value="STORE", ordinal=0), require=1)
    public double orientCamera(double distance) {
        0P event = new 0P(distance);
        EventDispatcher.Companion.dispatch(event);
        if (event.0()) {
            return event.c();
        }
        return distance;
    }

    @ModifyVariable(method={"getMouseOver"}, ordinal=0, index=2, name={"entity"}, at=@At(value="STORE", ordinal=0))
    private Entity injectMouseOver(Entity entity) {
        0s_0 event = new 0s_0(entity);
        EventDispatcher.Companion.dispatch(event);
        return event.c();
    }

    @Inject(method={"renderHand"}, at={@At(value="HEAD")}, cancellable=true)
    private void onRenderHand(CallbackInfo ci) {
        1p_0 event = new 1p_0();
        EventDispatcher.Companion.dispatch(event);
        if (event.0()) {
            ci.cancel();
        }
    }

    @Inject(method={"updateCameraAndRender"}, at={@At(value="HEAD")})
    private void onUpdateCameraAndRenderPre(float partialTicks, long nanoTime, CallbackInfo ci) {
        1K event = new 1K();
        EventDispatcher.Companion.dispatch(event);
    }

    @Inject(method={"updateCameraAndRender"}, at={@At(value="TAIL")})
    private void onUpdateCameraAndRenderPost(float partialTicks, long nanoTime, CallbackInfo ci) {
        1J event = new 1J();
        EventDispatcher.Companion.dispatch(event);
    }

    @Redirect(method={"setupCameraTransform"}, at=@At(value="INVOKE", target="Lorg/lwjgl/util/glu/Project;gluPerspective(FFFF)V"))
    private void projectInject0(float fovy, float aspect, float zNear, float zFar) {
        84.c(fovy, aspect, zNear, zFar);
    }

    @Redirect(method={"renderHand"}, at=@At(value="INVOKE", target="Lorg/lwjgl/util/glu/Project;gluPerspective(FFFF)V"))
    private void projectInject1(float fovy, float aspect, float zNear, float zFar) {
        84.c(fovy, aspect, zNear, zFar, true);
    }

    @Redirect(method={"renderWorldPass"}, at=@At(value="INVOKE", target="Lorg/lwjgl/util/glu/Project;gluPerspective(FFFF)V"))
    private void projectInject2(float fovy, float aspect, float zNear, float zFar) {
        84.c(fovy, aspect, zNear, zFar);
    }

    @Redirect(method={"renderCloudsCheck"}, at=@At(value="INVOKE", target="Lorg/lwjgl/util/glu/Project;gluPerspective(FFFF)V"))
    private void projectInject3(float fovy, float aspect, float zNear, float zFar) {
        84.c(fovy, aspect, zNear, zFar);
    }

    @Redirect(method={"getMouseOver"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/Minecraft;getRenderViewEntity()Lnet/minecraft/entity/Entity;"))
    private Entity redirectMouseOver(Minecraft mc) {
        0o_0 event = new 0o_0();
        EventDispatcher.Companion.dispatch(event);
        if (event.0() && Keyboard.isKeyDown((int)56)) {
            return mc.player;
        }
        return mc.getRenderViewEntity();
    }

    @Redirect(method={"updateCameraAndRender"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/entity/EntityPlayerSP;turn(FF)V"))
    private void redirectTurn(EntityPlayerSP entityPlayerSP, float yaw, float pitch) {
        try {
            Minecraft mc = Minecraft.getMinecraft();
            0o_0 event = new 0o_0();
            EventDispatcher.Companion.dispatch(event);
            if (event.0()) {
                if (Keyboard.isKeyDown((int)56)) {
                    mc.player.turn(yaw, pitch);
                } else {
                    Objects.requireNonNull(mc.getRenderViewEntity(), "Render Entity").turn(yaw, pitch);
                }
                return;
            }
        }
        catch (Exception e2) {
            e2.printStackTrace();
            return;
        }
        entityPlayerSP.turn(yaw, pitch);
    }

    @Redirect(method={"renderWorldPass"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/entity/EntityPlayerSP;isSpectator()Z"))
    public boolean redirectIsSpectator(EntityPlayerSP entityPlayerSP) {
        0o_0 event = new 0o_0();
        EventDispatcher.Companion.dispatch(event);
        if (event.0()) {
            return true;
        }
        if (entityPlayerSP != null) {
            return entityPlayerSP.isSpectator();
        }
        return false;
    }
}

