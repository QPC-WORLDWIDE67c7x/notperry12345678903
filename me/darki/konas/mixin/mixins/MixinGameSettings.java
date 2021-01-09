/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import net.minecraft.client.settings.GameSettings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={GameSettings.class})
public class MixinGameSettings {
    @Inject(method={"setOptionValue"}, at={@At(value="HEAD")}, cancellable=true)
    public void setOptionValue(GameSettings.Options settingsOption, int value, CallbackInfo callbackInfo) {
        if (settingsOption == GameSettings.Options.NARRATOR) {
            callbackInfo.cancel();
        }
    }
}

