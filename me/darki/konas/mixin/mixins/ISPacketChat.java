/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import net.minecraft.network.play.server.SPacketChat;
import net.minecraft.util.text.ITextComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={SPacketChat.class})
public interface ISPacketChat {
    @Accessor(value="chatComponent")
    public void setChatComponent(ITextComponent var1);
}

