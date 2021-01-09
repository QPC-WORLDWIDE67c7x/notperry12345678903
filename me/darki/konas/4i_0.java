/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.awt.TrayIcon;
import java.util.List;
import java.util.stream.Collectors;
import me.darki.konas.1N;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.3F;
import me.darki.konas.4h_0;
import me.darki.konas.5B;
import me.darki.konas.8E;
import me.darki.konas.8J;
import me.darki.konas.8h_0;
import me.darki.konas.8u_0;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.4i
 */
public class 4i_0
extends 3E {
    public static 8h_0<4h_0> 1 = new 8h_0("Mode", 4h_0.c);
    public static 8h_0<Float> 2 = new 8h_0("Health", Float.valueOf(10.0f), Float.valueOf(22.0f), Float.valueOf(0.0f), Float.valueOf(0.1f)).c(4i_0::0);
    public 8h_0<Float> 3 = new 8h_0("CrystalRange", Float.valueOf(10.0f), Float.valueOf(15.0f), Float.valueOf(1.0f), Float.valueOf(1.0f)).c(4i_0::c);
    public static 8h_0<Boolean> 4 = new 8h_0("IgnoreTotem", true).c(4i_0::7);
    public 8h_0<Boolean> 5 = new 8h_0("Notify", false).c(this::4);

    public boolean 6() {
        for (int i2 = 0; i2 < 36; ++i2) {
            if (4i_0.c.player.inventory.getStackInSlot(i2).getItem() != Items.TOTEM_OF_UNDYING) continue;
            return true;
        }
        return false;
    }

    public static boolean 0(Entity entity) {
        return entity instanceof EntityEnderCrystal;
    }

    @Subscriber
    public void c(1N n2) {
        block4: {
            block7: {
                block5: {
                    block6: {
                        if (4i_0.c.world == null || 4i_0.c.player == null) {
                            return;
                        }
                        if (1.6() != 4h_0.c) break block5;
                        if (!(4i_0.c.player.getHealth() <= ((Float)2.6()).floatValue())) break block4;
                        if (!((Boolean)4.6()).booleanValue()) break block6;
                        this.1();
                        break block4;
                    }
                    if (this.6()) break block4;
                    this.1();
                    break block4;
                }
                if (1.6() != 4h_0.0) break block7;
                for (EntityPlayer entityPlayer : 4i_0.c.world.playerEntities) {
                    if (entityPlayer == 4i_0.c.player || 8J.1(entityPlayer.getName()) || 8u_0.c((Entity)entityPlayer)) continue;
                    this.1();
                    break block4;
                }
                break block4;
            }
            if (!((Boolean)4.6()).booleanValue() && this.6()) {
                return;
            }
            float f2 = 0.0f;
            List list = 4i_0.c.world.loadedEntityList.stream().filter(4i_0::0).filter(this::c).collect(Collectors.toList());
            for (Entity entity : list) {
                f2 += 8E.c((EntityEnderCrystal)entity, (Entity)4i_0.c.player);
            }
            if (!(4i_0.c.player.getHealth() + 4i_0.c.player.getAbsorptionAmount() <= f2)) break block4;
            this.1();
        }
    }

    public void 1() {
        5B b2 = (5B)3F.c(5B.class);
        if (b2 != null) {
            if (b2.f()) {
                b2.d();
            }
        }
        this.d();
        if (((Boolean)this.5.6()).booleanValue()) {
            this.c("You have AutoLogged!", TrayIcon.MessageType.ERROR);
        }
        4i_0.c.player.inventory.currentItem = 1000;
    }

    public 4i_0() {
        super("AutoLog", 3D.c, "AutoDisconnect");
    }

    public static boolean 0() {
        return 1.6() == 4h_0.c;
    }

    public static boolean 7() {
        return 1.6() != 4h_0.0;
    }

    public static boolean c() {
        return 1.6() == 4h_0.1;
    }

    public boolean c(Entity entity) {
        return 4i_0.c.player.getDistance(entity) <= ((Float)this.3.6()).floatValue();
    }
}

