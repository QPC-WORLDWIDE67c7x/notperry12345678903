/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.EventDispatcher;
import me.darki.konas.0I;
import me.darki.konas.0N;
import me.darki.konas.0d_0;
import me.darki.konas.0g_0;
import me.darki.konas.0k_0;
import me.darki.konas.0l_0;
import me.darki.konas.15;
import me.darki.konas.1B;
import me.darki.konas.1N;
import me.darki.konas.1U;
import me.darki.konas.1a_0;
import me.darki.konas.1o_0;
import me.darki.konas.1u_0;
import me.darki.konas.1z_0;
import me.darki.konas.8x_0;
import me.darki.konas.X;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.client.event.PlayerSPPushOutOfBlocksEvent;
import net.minecraftforge.client.event.RenderBlockOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.2c
 */
public class 2c_0 {
    public static 2c_0 c = new 2c_0();

    @SubscribeEvent
    public void c(WorldEvent.Unload unload) {
        EventDispatcher.Companion.dispatch(unload);
    }

    @SubscribeEvent
    public void c(PlayerSPPushOutOfBlocksEvent playerSPPushOutOfBlocksEvent) {
        X x = X.c(playerSPPushOutOfBlocksEvent.getEntityPlayer());
        EventDispatcher.Companion.dispatch(x);
        playerSPPushOutOfBlocksEvent.setCanceled(x.0());
    }

    @SubscribeEvent
    public void c(EntityViewRenderEvent.FOVModifier fOVModifier) {
        EventDispatcher.Companion.dispatch(fOVModifier);
    }

    @SubscribeEvent
    public void c(PlayerEvent.ItemCraftedEvent itemCraftedEvent) {
        EventDispatcher.Companion.dispatch(itemCraftedEvent);
    }

    @SubscribeEvent
    public void 0(InputUpdateEvent inputUpdateEvent) {
        0N n2 = new 0N(inputUpdateEvent.getEntityPlayer(), inputUpdateEvent.getMovementInput());
        EventDispatcher.Companion.dispatch(n2);
        if (inputUpdateEvent.getEntityPlayer() == Minecraft.getMinecraft().player) {
            1B b2 = new 1B(n2.c());
            EventDispatcher.Companion.dispatch(b2);
        }
    }

    @SubscribeEvent
    public void c(ItemTooltipEvent itemTooltipEvent) {
        EventDispatcher.Companion.dispatch(itemTooltipEvent);
    }

    @SubscribeEvent
    public void c(ClientChatReceivedEvent clientChatReceivedEvent) {
        EventDispatcher.Companion.dispatch(clientChatReceivedEvent);
    }

    @SubscribeEvent
    public void c(EntityViewRenderEvent.CameraSetup cameraSetup) {
        EventDispatcher.Companion.dispatch(cameraSetup);
    }

    @SubscribeEvent
    public void c(ClientChatEvent clientChatEvent) {
        EventDispatcher.Companion.dispatch(clientChatEvent);
    }

    @SubscribeEvent
    public void c(LivingEvent.LivingJumpEvent livingJumpEvent) {
        EventDispatcher.Companion.dispatch(livingJumpEvent);
    }

    @SubscribeEvent
    public void c(WorldEvent worldEvent) {
        EventDispatcher.Companion.dispatch(worldEvent);
    }

    @SubscribeEvent
    public void c(RenderGameOverlayEvent.Post post) {
        if (post.getType() == RenderGameOverlayEvent.ElementType.HOTBAR) {
            EventDispatcher.Companion.dispatch(new 1a_0());
        }
        EventDispatcher.Companion.dispatch(post);
    }

    @SubscribeEvent
    public void c(InputUpdateEvent inputUpdateEvent) {
        EventDispatcher.Companion.dispatch(inputUpdateEvent);
    }

    @SubscribeEvent
    public void c(PlayerEvent.ItemPickupEvent itemPickupEvent) {
        EventDispatcher.Companion.dispatch(itemPickupEvent);
    }

    @SubscribeEvent
    public void 0(EntityViewRenderEvent.FogDensity fogDensity) {
        block0: {
            1o_0 o_02 = new 1o_0(fogDensity.getRenderer(), fogDensity.getEntity(), fogDensity.getState(), fogDensity.getRenderPartialTicks());
            EventDispatcher.Companion.dispatch(o_02);
            if (!o_02.0()) break block0;
            fogDensity.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void c(GuiScreenEvent.DrawScreenEvent.Post post) {
        0d_0 d_02 = 0d_0.c(post.getGui());
        EventDispatcher.Companion.dispatch(d_02);
    }

    @SubscribeEvent
    public void c(LivingEntityUseItemEvent livingEntityUseItemEvent) {
        if (livingEntityUseItemEvent.getEntity() instanceof EntityPlayerSP) {
            EventDispatcher.Companion.dispatch(new 15());
        }
    }

    @SubscribeEvent
    public void c(RenderWorldLastEvent renderWorldLastEvent) {
        if (renderWorldLastEvent.isCanceled()) {
            return;
        }
        Minecraft.getMinecraft().profiler.startSection("konas");
        1U u = new 1U(renderWorldLastEvent.getPartialTicks());
        EventDispatcher.Companion.dispatch(u);
        Minecraft.getMinecraft().profiler.endSection();
    }

    @SubscribeEvent
    public void c(GuiOpenEvent guiOpenEvent) {
        0I i2 = new 0I(guiOpenEvent.getGui());
        EventDispatcher.Companion.dispatch(i2);
        guiOpenEvent.setGui(i2.c());
        guiOpenEvent.setCanceled(i2.0());
    }

    @SubscribeEvent
    public void c(TickEvent.ClientTickEvent clientTickEvent) {
        8x_0.c = null;
        1N n2 = 1N.c(clientTickEvent.phase);
        EventDispatcher.Companion.dispatch(n2);
    }

    @SubscribeEvent
    public void c(PlayerInteractEvent.RightClickItem rightClickItem) {
        EventDispatcher.Companion.dispatch(rightClickItem);
    }

    @SubscribeEvent
    public void c(RenderBlockOverlayEvent renderBlockOverlayEvent) {
        1u_0 u_02 = new 1u_0(renderBlockOverlayEvent.getOverlayType());
        EventDispatcher.Companion.dispatch(u_02);
        renderBlockOverlayEvent.setCanceled(u_02.0());
    }

    @SubscribeEvent
    public void c(EntityViewRenderEvent.FogColors fogColors) {
        0k_0 k_02 = new 0k_0(fogColors.getRed(), fogColors.getGreen(), fogColors.getBlue());
        EventDispatcher.Companion.dispatch(k_02);
        fogColors.setRed(k_02.1());
        fogColors.setGreen(k_02.0());
        fogColors.setBlue(k_02.c());
    }

    @SubscribeEvent
    public void c(EntityViewRenderEvent.FogDensity fogDensity) {
        0l_0 l_02 = new 0l_0(fogDensity.getDensity());
        EventDispatcher.Companion.dispatch(l_02);
        fogDensity.setDensity(l_02.c());
        fogDensity.setCanceled(l_02.0());
    }

    @SubscribeEvent
    public void c(AttackEntityEvent attackEntityEvent) {
        0g_0 g_02 = 0g_0.c(attackEntityEvent.getEntityPlayer(), attackEntityEvent.getTarget());
        EventDispatcher.Companion.dispatch(g_02);
    }

    @SubscribeEvent
    public void c(RenderTooltipEvent.PostBackground postBackground) {
        1z_0 z_02 = new 1z_0(postBackground.getStack(), postBackground.getX(), postBackground.getY());
        EventDispatcher.Companion.dispatch(z_02);
    }
}

