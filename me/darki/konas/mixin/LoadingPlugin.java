/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin;

import java.util.Map;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.Mixins;

@IFMLLoadingPlugin.MCVersion(value="1.12.2")
public class LoadingPlugin
implements IFMLLoadingPlugin {
    public LoadingPlugin() {
        System.out.println("Konas Coremod initialising");
        MixinBootstrap.init();
        Mixins.addConfiguration((String)"mixins.konas.json");
        MixinEnvironment.getDefaultEnvironment().setSide(MixinEnvironment.Side.CLIENT);
    }

    public String[] getASMTransformerClass() {
        return new String[0];
    }

    public String getModContainerClass() {
        return null;
    }

    public String getSetupClass() {
        return null;
    }

    public void injectData(Map<String, Object> data) {
    }

    public String getAccessTransformerClass() {
        return null;
    }
}

