/*
 * Decompiled with CFR 0.151.
 */
package com.konasclient.client;

import com.konasclient.client.RotationManager;
import java.util.Map;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 0
implements IFMLLoadingPlugin {
    @Nullable
    public String c() {
        return null;
    }

    @NotNull
    public String[] c() {
        return new String[0];
    }

    @Nullable
    public String 0() {
        return null;
    }

    public void c(@Nullable Map map) {
    }

    @Nullable
    public String 1() {
        return null;
    }

    public 0() {
        RotationManager.INSTANCE.load();
    }
}

