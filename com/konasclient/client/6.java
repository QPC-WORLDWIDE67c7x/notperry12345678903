/*
 * Decompiled with CFR 0.151.
 */
package com.konasclient.client;

import com.konasclient.client.RotationManager;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.text.StringsKt;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.launchwrapper.LaunchClassLoader;
import net.minecraftforge.fml.relauncher.FMLLaunchHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.lib.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 6
implements IMixinConfigPlugin {
    @NotNull
    public File c;
    @NotNull
    public List<String> c = new File(System.getProperty("user.home") + "/Konas/mixin.refmap.json");

    @NotNull
    public File c() {
        return this.c;
    }

    public void c(@NotNull File file) {
        this.c = file;
    }

    @NotNull
    public List c() {
        return this.c;
    }

    public void onLoad(@Nullable String string) {
        Launch.classLoader.addURL(this.c.toURI().toURL());
        Object object2 = this.c;
        boolean bl = false;
        new FileOutputStream((File)object2).write(RotationManager.INSTANCE.getRefmap());
        this.c.deleteOnExit();
        for (Object object2 : RotationManager.INSTANCE.getMixinCache()) {
            this.c.add(StringsKt.substringAfterLast$default((String)object2, (String)".", null, (int)2, null));
            if (!FMLLaunchHandler.isDeobfuscatedEnvironment()) continue;
            LaunchClassLoader launchClassLoader = Launch.classLoader;
            Object object3 = object2;
            launchClassLoader.loadClass((String)object3);
            try {
            }
            catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
        }
    }

    public void preApply(@Nullable String string, @Nullable ClassNode classNode, @Nullable String string2, @Nullable IMixinInfo iMixinInfo) {
    }

    public void postApply(@Nullable String string, @Nullable ClassNode classNode, @Nullable String string2, @Nullable IMixinInfo iMixinInfo) {
    }

    @NotNull
    public String getRefMapperConfig() {
        String string = StringsKt.replace$default((String)this.c.getAbsolutePath(), (char)File.separatorChar, (char)'/', (boolean)false, (int)4, null);
        return (StringsKt.startsWith$default((String)string, (String)"/", (boolean)false, (int)2, null) ? "file:" : "file:/") + string;
    }

    @NotNull
    public List getMixins() {
        return this.c;
    }

    public void acceptTargets(@Nullable Set set, @Nullable Set set2) {
    }

    public boolean shouldApplyMixin(@Nullable String string, @Nullable String string2) {
        return true;
    }

    public 6() {
        6 var1_1 = this;
        boolean bl = false;
        List list = new ArrayList();
        var1_1.c = list;
    }
}

