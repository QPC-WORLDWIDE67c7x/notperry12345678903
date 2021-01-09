/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas.mixin.mixins;

import java.util.List;
import net.minecraft.client.gui.ChatLine;
import net.minecraft.client.gui.GuiNewChat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={GuiNewChat.class})
public interface IGuiNewChat {
    @Accessor(value="drawnChatLines")
    public List<ChatLine> getDrawnChatLines();

    @Accessor(value="drawnChatLines")
    public void setDrawnChatLines(List<ChatLine> var1);

    @Accessor(value="scrollPos")
    public int getScrollPos();

    @Accessor(value="scrollPos")
    public void setScrollPos(int var1);

    @Accessor(value="isScrolled")
    public boolean getIsScrolled();

    @Accessor(value="isScrolled")
    public void setIsScrolled(boolean var1);
}

