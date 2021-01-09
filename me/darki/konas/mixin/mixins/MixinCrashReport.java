/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import me.darki.konas.3E;
import me.darki.konas.3F;
import net.minecraft.crash.CrashReport;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={CrashReport.class})
public class MixinCrashReport {
    @Inject(method={"getSectionsInStringBuilder"}, at={@At(value="INVOKE", target="Lnet/minecraft/crash/CrashReportCategory;appendToStringBuilder(Ljava/lang/StringBuilder;)V", ordinal=1)})
    private void injectStringBuilder(StringBuilder builder, CallbackInfo ci) {
        builder.append("Active Modules: \n");
        for (3E module : 3F.3()) {
            builder.append(module.b()).append("\n");
        }
        builder.append("\n");
    }
}

