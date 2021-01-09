/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.0C;
import me.darki.konas.0D;
import me.darki.konas.1H;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.8h_0;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemPotion;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumHandSide;
import net.minecraftforge.client.event.EntityViewRenderEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 83
extends 3E {
    public static 8h_0<Boolean> 1 = new 8h_0("CancelEating", false);
    public static 8h_0<Boolean> 2 = new 8h_0("SnapEat", false).c(83::c);
    public static 8h_0<Boolean> 3 = new 8h_0("CustomEating", false).c(83::0);
    public static 8h_0<Float> 4 = new 8h_0("MainHandX", Float.valueOf(0.0f), Float.valueOf(100.0f), Float.valueOf(-100.0f), Float.valueOf(1.0f));
    public static 8h_0<Float> 5 = new 8h_0("MainHandY", Float.valueOf(0.0f), Float.valueOf(100.0f), Float.valueOf(-100.0f), Float.valueOf(1.0f));
    public static 8h_0<Float> 6 = new 8h_0("MainHandZ", Float.valueOf(0.0f), Float.valueOf(100.0f), Float.valueOf(-100.0f), Float.valueOf(1.0f));
    public static 8h_0<Float> 7 = new 8h_0("MainHandXS", Float.valueOf(0.0f), Float.valueOf(100.0f), Float.valueOf(-100.0f), Float.valueOf(1.0f));
    public static 8h_0<Float> 8 = new 8h_0("MainHandYS", Float.valueOf(0.0f), Float.valueOf(100.0f), Float.valueOf(-100.0f), Float.valueOf(1.0f));
    public static 8h_0<Float> 9 = new 8h_0("MainHandZS", Float.valueOf(0.0f), Float.valueOf(100.0f), Float.valueOf(-100.0f), Float.valueOf(1.0f));
    public static 8h_0<Float> a = new 8h_0("MainHandYaw", Float.valueOf(0.0f), Float.valueOf(180.0f), Float.valueOf(-180.0f), Float.valueOf(1.0f));
    public static 8h_0<Float> b = new 8h_0("MainHandPitch", Float.valueOf(0.0f), Float.valueOf(180.0f), Float.valueOf(-180.0f), Float.valueOf(1.0f));
    public static 8h_0<Float> d = new 8h_0("MainHandRoll", Float.valueOf(0.0f), Float.valueOf(180.0f), Float.valueOf(-180.0f), Float.valueOf(1.0f));
    public static 8h_0<Float> e = new 8h_0("OffHandX", Float.valueOf(0.0f), Float.valueOf(100.0f), Float.valueOf(-100.0f), Float.valueOf(1.0f));
    public static 8h_0<Float> f = new 8h_0("OffHandY", Float.valueOf(0.0f), Float.valueOf(100.0f), Float.valueOf(-100.0f), Float.valueOf(1.0f));
    public static 8h_0<Float> g = new 8h_0("OffHandZ", Float.valueOf(0.0f), Float.valueOf(100.0f), Float.valueOf(-100.0f), Float.valueOf(1.0f));
    public static 8h_0<Float> h = new 8h_0("OffHandXS", Float.valueOf(0.0f), Float.valueOf(100.0f), Float.valueOf(-100.0f), Float.valueOf(1.0f));
    public static 8h_0<Float> i = new 8h_0("OffHandYS", Float.valueOf(0.0f), Float.valueOf(100.0f), Float.valueOf(-100.0f), Float.valueOf(1.0f));
    public static 8h_0<Float> j = new 8h_0("OffHandZS", Float.valueOf(0.0f), Float.valueOf(100.0f), Float.valueOf(-100.0f), Float.valueOf(1.0f));
    public static 8h_0<Float> k = new 8h_0("OffHandYaw", Float.valueOf(0.0f), Float.valueOf(180.0f), Float.valueOf(-180.0f), Float.valueOf(1.0f));
    public static 8h_0<Float> l = new 8h_0("OffHandPitch", Float.valueOf(0.0f), Float.valueOf(180.0f), Float.valueOf(-180.0f), Float.valueOf(1.0f));
    public static 8h_0<Float> m = new 8h_0("OffHandRoll", Float.valueOf(0.0f), Float.valueOf(180.0f), Float.valueOf(-180.0f), Float.valueOf(1.0f));
    public static 8h_0<Boolean> n = new 8h_0("ItemFov", false);
    public static 8h_0<Float> o = new 8h_0("ItemFovValue", Float.valueOf(110.0f), Float.valueOf(170.0f), Float.valueOf(90.0f), Float.valueOf(1.0f));

    @Subscriber
    public void c(0D d2) {
        block8: {
            boolean bl;
            block7: {
                if (83.c.player == null) {
                    return;
                }
                d2.c();
                boolean bl2 = true;
                bl = true;
                if (((Boolean)2.6()).booleanValue() && (83.c.player.getActiveItemStack().getItem() instanceof ItemFood || 83.c.player.getActiveItemStack().getItem() instanceof ItemPotion)) {
                    if (83.c.player.getActiveHand() == EnumHand.MAIN_HAND) {
                        bl2 = false;
                    } else if (83.c.player.getActiveHand() == EnumHand.OFF_HAND) {
                        bl = false;
                    }
                }
                if (d2.c() != 0C.c) break block7;
                if (bl2) {
                    d2.3(d2.8() + ((Float)4.6()).floatValue() / 100.0f);
                    d2.0(d2.3() + ((Float)5.6()).floatValue() / 100.0f);
                    d2.4(d2.1() + ((Float)6.6()).floatValue() / 100.0f);
                }
                d2.5(d2.2() + ((Float)7.6()).floatValue() / 50.0f);
                d2.c(d2.0() + ((Float)8.6()).floatValue() / 50.0f);
                d2.7(d2.7() + ((Float)9.6()).floatValue() / 50.0f);
                d2.1(((Float)a.6()).floatValue());
                d2.2(((Float)b.6()).floatValue());
                d2.6(((Float)d.6()).floatValue());
                break block8;
            }
            if (d2.c() != 0C.0) break block8;
            if (bl) {
                d2.3(d2.8() + ((Float)e.6()).floatValue() / 100.0f);
                d2.0(d2.3() + ((Float)f.6()).floatValue() / 100.0f);
                d2.4(d2.1() + ((Float)g.6()).floatValue() / 100.0f);
            }
            d2.5(d2.2() + ((Float)h.6()).floatValue() / 50.0f);
            d2.c(d2.0() + ((Float)i.6()).floatValue() / 50.0f);
            d2.7(d2.7() + ((Float)j.6()).floatValue() / 50.0f);
            d2.1(((Float)k.6()).floatValue());
            d2.2(((Float)l.6()).floatValue());
            d2.6(((Float)m.6()).floatValue());
        }
    }

    @Subscriber
    public void c(EntityViewRenderEvent.FOVModifier fOVModifier) {
        block0: {
            if (!((Boolean)n.6()).booleanValue()) break block0;
            fOVModifier.setFOV(((Float)o.6()).floatValue());
        }
    }

    public static boolean c() {
        return (Boolean)1.6() == false;
    }

    @Subscriber
    public void c(1H h2) {
        block1: {
            if (((Boolean)1.6()).booleanValue()) {
                h2.c();
            }
            if (!((Boolean)3.6()).booleanValue()) break block1;
            float f2 = (float)83.c.player.getItemInUseCount() - h2.c() + 1.0f;
            float f3 = f2 / (float)h2.1().getMaxItemUseDuration();
            GlStateManager.translate((float)0.0f, (float)0.0f, (float)(f3 * (h2.0() == EnumHandSide.RIGHT ? -((Float)6.6()).floatValue() / 100.0f : -((Float)g.6()).floatValue() / 100.0f)));
        }
    }

    public static boolean 0() {
        return (Boolean)1.6() == false;
    }

    public 83() {
        super("ViewModel", "Lowers your hands", 3D.2, "SmallShield");
    }
}

