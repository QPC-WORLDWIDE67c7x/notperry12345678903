/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import me.darki.konas.0T;
import me.darki.konas.0X;
import me.darki.konas.0Y;
import me.darki.konas.0e_0;
import me.darki.konas.1N;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.5l_0;
import me.darki.konas.5m_0;
import me.darki.konas.8h_0;
import me.darki.konas.9m;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.5n
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 5n_0
extends 3E {
    public 8h_0<Boolean> 1;
    public 8h_0<Float> 2;
    public 8h_0<Boolean> 3;
    public 8h_0<Float> 4;
    public 8h_0<Float> 5;
    public 8h_0<Boolean> 6;
    public static ArrayList<String> 0 = new ArrayList();
    public static ArrayList<String> 1;
    public Random c;
    public Random 0;
    public 9m c;
    public 9m 0;
    public 9m 1 = new 8h_0("Welcome", true);
    public LinkedHashMap<5m_0, Integer> c;
    public static double c;
    public static double 0;
    public static double 1;

    public 5n_0() {
        super("Announcer", 3D.3, "Welcomer");
        this.2 = new 8h_0("WelcomeDelay", Float.valueOf(2.0f), Float.valueOf(60.0f), Float.valueOf(0.0f), Float.valueOf(1.0f));
        this.3 = new 8h_0("Announce", false);
        this.4 = new 8h_0("AnnounceDelay", Float.valueOf(20.0f), Float.valueOf(60.0f), Float.valueOf(1.0f), Float.valueOf(1.0f));
        this.5 = new 8h_0("GlobalDelay", Float.valueOf(1.0f), Float.valueOf(60.0f), Float.valueOf(0.0f), Float.valueOf(1.0f));
        this.6 = new 8h_0("Advertisement", true);
        this.c = new Random();
        this.0 = new Random();
        this.c = new 9m();
        this.0 = new 9m();
        this.1 = new 9m();
        this.c = new LinkedHashMap();
        0.add("Welcome <player>!");
        0.add("Hello <player>");
        0.add("Nice weather isn't it, <player>");
        ((ArrayList)((Object)1)).add("Goodbye <player>!");
        ((ArrayList)((Object)1)).add("Have a good day <player>");
    }

    @Subscriber
    public void c(0T t) {
        block1: {
            CPacketPlayerDigging cPacketPlayerDigging;
            block2: {
                block0: {
                    if (!(t.c() instanceof CPacketPlayerTryUseItemOnBlock)) break block0;
                    this.c(5m_0.0);
                    break block1;
                }
                if (!(t.c() instanceof CPacketPlayerDigging)) break block1;
                cPacketPlayerDigging = (CPacketPlayerDigging)t.c();
                if (cPacketPlayerDigging.getAction() != CPacketPlayerDigging.Action.DROP_ALL_ITEMS && cPacketPlayerDigging.getAction() != CPacketPlayerDigging.Action.DROP_ITEM) break block2;
                this.c(5m_0.2);
                break block1;
            }
            if (cPacketPlayerDigging.getAction() != CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK) break block1;
            this.c(5m_0.3);
        }
    }

    public double c(double d2, double d3, double d4) {
        double d5 = d2 - 5n_0.c.player.posX;
        double d6 = d3 - 5n_0.c.player.posY;
        double d7 = d4 - 5n_0.c.player.posZ;
        return Math.sqrt(d5 * d5 + d6 * d6 + d7 * d7);
    }

    public String c(5m_0 m_02, int n2) {
        String string = (Boolean)this.6.6() != false ? " thanks to Konas!" : "!";
        String string2 = n2 > 1 ? "s" : "";
        switch (5l_0.c[m_02.ordinal()]) {
            case 1: {
                return "I just picked up " + n2 + " item" + string2 + string;
            }
            case 2: {
                return "I just crafted " + n2 + " item" + string2 + string;
            }
            case 3: {
                return "I just broke " + n2 + " block" + string2 + string;
            }
            case 4: {
                return "I just placed " + n2 + " block" + string2 + string;
            }
            case 5: {
                return "I just dropped " + n2 + " item" + string2 + string;
            }
            case 6: {
                return "I just ate " + n2 + " item" + string2 + string;
            }
            case 7: {
                return "I just jumped " + n2 + " time" + string2 + string;
            }
            case 8: {
                return "I just walked " + n2 + " block" + string2 + string;
            }
        }
        return "I just did " + (Object)((Object)m_02) + " " + n2 + " time" + string2 + string;
    }

    public void 2(String string) {
        ((Minecraft)5n_0.c).player.sendChatMessage(((String)((ArrayList)((Object)1)).get(this.c.nextInt(((ArrayList)((Object)1)).size()))).replace("<player>", string));
    }

    public void 3(String string) {
        ((Minecraft)5n_0.c).player.sendChatMessage(0.get(this.c.nextInt(0.size())).replace("<player>", string));
    }

    public void c(5m_0 m_02) {
        if (((HashMap)((Object)this.c)).containsKey((Object)m_02)) {
            ((HashMap)((Object)this.c)).put(m_02, (Integer)((LinkedHashMap)((Object)this.c)).get((Object)m_02) + 1);
        } else {
            ((HashMap)((Object)this.c)).put(m_02, 1);
        }
    }

    @Subscriber
    public void c(LivingEvent.LivingJumpEvent livingJumpEvent) {
        block0: {
            if (!livingJumpEvent.getEntityLiving().equals((Object)((Minecraft)5n_0.c).player)) break block0;
            this.c(5m_0.1);
        }
    }

    @Subscriber
    public void c(0e_0 e_02) {
        block0: {
            if (e_02.c() != ((Minecraft)5n_0.c).player) break block0;
            this.c(5m_0.4);
        }
    }

    @Subscriber
    public void c(PlayerEvent.ItemCraftedEvent itemCraftedEvent) {
        block0: {
            if (!itemCraftedEvent.player.equals((Object)((Minecraft)5n_0.c).player)) break block0;
            this.c(5m_0.5);
        }
    }

    @Subscriber
    public void c(PlayerEvent.ItemPickupEvent itemPickupEvent) {
        block0: {
            if (!itemPickupEvent.player.equals((Object)((Minecraft)5n_0.c).player)) break block0;
            this.c(5m_0.6);
        }
    }

    @Subscriber
    public void c(0X x) {
        block1: {
            if (((Minecraft)5n_0.c).player == null || ((Minecraft)5n_0.c).world == null) {
                return;
            }
            if (!((Boolean)this.1.6()).booleanValue() || 5n_0.c.player.ticksExisted <= 100 || x.c() == ((Minecraft)5n_0.c).player.getUniqueID() || !this.c.c(((Float)this.2.6()).floatValue() * 1000.0f) || !this.1.c(((Float)this.5.6()).floatValue() * 1000.0f)) break block1;
            this.3(x.0());
            this.c.c();
            this.1.c();
        }
    }

    @Subscriber
    public void c(0Y y) {
        block1: {
            EntityPlayer entityPlayer;
            if (((Minecraft)5n_0.c).player == null || ((Minecraft)5n_0.c).world == null) {
                return;
            }
            if (!((Boolean)this.1.6()).booleanValue() || 5n_0.c.player.ticksExisted <= 100 || y.c() == ((Minecraft)5n_0.c).player.getUniqueID() || !this.c.c(((Float)this.2.6()).floatValue() * 1000.0f) || !this.1.c(((Float)this.5.6()).floatValue() * 1000.0f) || (entityPlayer = ((Minecraft)5n_0.c).world.getPlayerEntityByUUID(y.c())) == null) break block1;
            this.2(entityPlayer.getName());
            this.c.c();
            this.1.c();
        }
    }

    @Subscriber
    public void c(1N n2) {
        if (((Minecraft)5n_0.c).player == null || ((Minecraft)5n_0.c).world == null) {
            return;
        }
        if (((Boolean)this.3.6()).booleanValue() && this.1.c(((Float)this.5.6()).floatValue() * 1000.0f) && this.0.c(((Float)this.4.6()).floatValue() * 1000.0f)) {
            double d2 = this.c(c, 0, 1);
            if (d2 > 0.0 && d2 < 5000.0 && 5n_0.c.player.ticksExisted > 1000) {
                ((HashMap)((Object)this.c)).put(5m_0.c, (int)d2);
            }
            c = 5n_0.c.player.posX;
            0 = 5n_0.c.player.posY;
            1 = 5n_0.c.player.posZ;
            if (((HashMap)((Object)this.c)).isEmpty()) {
                return;
            }
            int n3 = this.0.nextInt(((LinkedHashMap)((Object)this.c)).entrySet().size());
            for (int i2 = 0; i2 < ((LinkedHashMap)((Object)this.c)).entrySet().size(); ++i2) {
                if (i2 != n3) continue;
                ArrayList arrayList = new ArrayList(((LinkedHashMap)((Object)this.c)).entrySet());
                Map.Entry entry = (Map.Entry)arrayList.get(i2);
                ((Minecraft)5n_0.c).player.sendChatMessage(this.c((5m_0)((Object)entry.getKey()), (int)((Integer)entry.getValue())));
                this.0.c();
                this.1.c();
                ((LinkedHashMap)((Object)this.c)).clear();
            }
        }
    }

    static {
        1 = new ArrayList();
    }
}

