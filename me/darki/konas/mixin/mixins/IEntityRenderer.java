/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.texture.DynamicTexture;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={EntityRenderer.class})
public interface IEntityRenderer {
    @Invoker(value="setupCameraTransform")
    public void iSetupCameraTransform(float var1, int var2);

    @Invoker(value="orientCamera")
    public void iOrientCamera(float var1);

    @Invoker(value="getFOVModifier")
    public float iGetFOVModifier(float var1, boolean var2);

    @Invoker(value="updateFogColor")
    public void iUpdateFogColor(float var1);

    @Accessor(value="lightmapColors")
    public int[] getLightmapColors();

    @Accessor(value="lightmapTexture")
    public DynamicTexture getLightmapTexture();

    @Accessor(value="torchFlickerX")
    public float getTorchFlickerX();

    @Accessor(value="renderEndNanoTime")
    public long getRenderEndNanoTime();

    @Accessor(value="cameraZoom")
    public double getCameraZoom();

    @Accessor(value="cameraZoom")
    public void setCameraZoom(double var1);
}

