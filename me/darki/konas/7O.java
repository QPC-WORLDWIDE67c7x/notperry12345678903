/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.util.Objects;
import me.darki.konas.1M;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.8h_0;
import me.darki.konas.mixin.mixins.IItemRenderer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.ForgeHooksClient;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 7O
extends 3E {
    public 8h_0<Boolean> 1 = new 8h_0("ShowSwapping", true);

    public 7O() {
        super("OldAnimations", "1.8 Hit Animations", 3D.2, new String[0]);
    }

    @Subscriber
    public void c(1M m2) {
        block5: {
            m2.c(true);
            ((IItemRenderer)7O.c.entityRenderer.itemRenderer).settPrevEquippedProgressMainHand(((IItemRenderer)7O.c.entityRenderer.itemRenderer).gettEquippedProgressMainHand());
            ((IItemRenderer)7O.c.entityRenderer.itemRenderer).settPrevEquippedProgressOffHand(((IItemRenderer)7O.c.entityRenderer.itemRenderer).gettEquippedProgressOffHand());
            EntityPlayerSP entityPlayerSP = 7O.c.player;
            ItemStack itemStack = entityPlayerSP.getHeldItemMainhand();
            ItemStack itemStack2 = entityPlayerSP.getHeldItemOffhand();
            if (entityPlayerSP.isRowingBoat()) {
                ((IItemRenderer)7O.c.entityRenderer.itemRenderer).settEquippedProgressMainHand(MathHelper.clamp((float)(((IItemRenderer)7O.c.entityRenderer.itemRenderer).gettEquippedProgressMainHand() - 0.4f), (float)0.0f, (float)1.0f));
                ((IItemRenderer)7O.c.entityRenderer.itemRenderer).settEquippedProgressOffHand(MathHelper.clamp((float)(((IItemRenderer)7O.c.entityRenderer.itemRenderer).gettEquippedProgressOffHand() - 0.4f), (float)0.0f, (float)1.0f));
            } else {
                boolean bl;
                boolean bl2 = (Boolean)this.1.6() != false && ForgeHooksClient.shouldCauseReequipAnimation((ItemStack)((IItemRenderer)7O.c.entityRenderer.itemRenderer).gettItemStackMainHand(), (ItemStack)itemStack, (int)entityPlayerSP.inventory.currentItem);
                boolean bl3 = bl = (Boolean)this.1.6() != false && ForgeHooksClient.shouldCauseReequipAnimation((ItemStack)((IItemRenderer)7O.c.entityRenderer.itemRenderer).gettItemStackOffHand(), (ItemStack)itemStack2, (int)-1);
                if (!bl2 && !Objects.equals(Float.valueOf(((IItemRenderer)7O.c.entityRenderer.itemRenderer).gettEquippedProgressMainHand()), itemStack)) {
                    ((IItemRenderer)7O.c.entityRenderer.itemRenderer).settItemStackMainHand(itemStack);
                }
                if (!bl2 && !Objects.equals(Float.valueOf(((IItemRenderer)7O.c.entityRenderer.itemRenderer).gettEquippedProgressOffHand()), itemStack2)) {
                    ((IItemRenderer)7O.c.entityRenderer.itemRenderer).settItemStackOffHand(itemStack2);
                }
                ((IItemRenderer)7O.c.entityRenderer.itemRenderer).settEquippedProgressMainHand(((IItemRenderer)7O.c.entityRenderer.itemRenderer).gettEquippedProgressMainHand() + MathHelper.clamp((float)((!bl2 ? 1.0f : 0.0f) - ((IItemRenderer)7O.c.entityRenderer.itemRenderer).gettEquippedProgressMainHand()), (float)-0.4f, (float)0.4f));
                ((IItemRenderer)7O.c.entityRenderer.itemRenderer).settEquippedProgressOffHand(((IItemRenderer)7O.c.entityRenderer.itemRenderer).gettEquippedProgressOffHand() + MathHelper.clamp((float)((float)(!bl ? 1 : 0) - ((IItemRenderer)7O.c.entityRenderer.itemRenderer).gettEquippedProgressOffHand()), (float)-0.4f, (float)0.4f));
            }
            if (((IItemRenderer)7O.c.entityRenderer.itemRenderer).gettEquippedProgressMainHand() < 0.1f) {
                ((IItemRenderer)7O.c.entityRenderer.itemRenderer).settItemStackMainHand(itemStack);
            }
            if (!(((IItemRenderer)7O.c.entityRenderer.itemRenderer).gettEquippedProgressOffHand() < 0.1f)) break block5;
            ((IItemRenderer)7O.c.entityRenderer.itemRenderer).settItemStackOffHand(itemStack2);
        }
    }
}

