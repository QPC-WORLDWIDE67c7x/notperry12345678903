/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import me.darki.konas.G;
import net.minecraft.client.renderer.GlStateManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(value={GlStateManager.class})
public class MixinGlStateManager {
    @ModifyArgs(method={"color(FFFF)V"}, at=@At(value="INVOKE", target="Lorg/lwjgl/opengl/GL11;glColor4f(FFFF)V"))
    private static void modifyColor4fArgs(Args args) {
        if (G.c) {
            args.set(0, (Object)Float.valueOf((float)Math.random()));
            args.set(1, (Object)Float.valueOf((float)Math.random()));
            args.set(2, (Object)Float.valueOf((float)Math.random()));
        }
    }

    @ModifyArgs(method={"glTexCoord2f"}, at=@At(value="INVOKE", target="Lorg/lwjgl/opengl/GL11;glTexCoord2f(FF)V"))
    private static void modifyTexCoord2fArgs(Args args) {
        if (G.c) {
            double rand = 0.04;
            args.set(0, (Object)Float.valueOf(((Float)args.get(0)).floatValue() + (float)(Math.random() * rand - rand / 2.0)));
            args.set(1, (Object)Float.valueOf(((Float)args.get(1)).floatValue() + (float)(Math.random() * rand - rand / 2.0)));
        }
    }

    @ModifyArgs(method={"glVertex3f"}, at=@At(value="INVOKE", target="Lorg/lwjgl/opengl/GL11;glVertex3f(FFF)V"))
    private static void modifyVectex3fArgs(Args args) {
        if (G.c) {
            double rand = 0.01;
            args.set(0, (Object)Float.valueOf(((Float)args.get(0)).floatValue() + (float)(Math.random() * rand - rand / 2.0)));
            args.set(1, (Object)Float.valueOf(((Float)args.get(1)).floatValue() + (float)(Math.random() * rand - rand / 2.0)));
            args.set(2, (Object)Float.valueOf(((Float)args.get(1)).floatValue() + (float)(Math.random() * rand - rand / 2.0)));
        }
    }
}

