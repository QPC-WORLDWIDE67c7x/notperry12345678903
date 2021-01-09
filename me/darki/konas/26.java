/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.EventDispatcher;
import cookiedragon.eventsystem.Subscriber;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import me.darki.konas.0S;
import me.darki.konas.0T;
import me.darki.konas.14;
import me.darki.konas.1E;
import me.darki.konas.1F;
import me.darki.konas.1N;
import me.darki.konas.8u_0;
import me.darki.konas.9m;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.network.play.server.SPacketEntityStatus;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.gameevent.TickEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 26 {
    public Map<Entity, Long> c;
    public static HashMap<String, Integer> c;
    public 9m c = new 9m();
    public static boolean c;

    public void c(Entity entity, Long l2) {
        if (System.currentTimeMillis() - l2 > TimeUnit.SECONDS.toMillis(30L)) {
            this.c.remove(entity);
        }
    }

    static {
        c = !26.class.desiredAssertionStatus();
        c = new HashMap<Entity, Long>();
    }

    public Entity 2() {
        if (!this.c.isEmpty()) {
            return (Entity)Collections.max(this.c.entrySet(), Map.Entry.comparingByValue()).getKey();
        }
        return null;
    }

    @Subscriber
    public void c(1N n2) {
        if (Minecraft.getMinecraft().world == null || Minecraft.getMinecraft().player == null || n2.c() == TickEvent.Phase.START) {
            return;
        }
        for (EntityPlayer entityPlayer : Minecraft.getMinecraft().world.playerEntities) {
            if (8u_0.c((Entity)entityPlayer) || !(entityPlayer.getHealth() <= 0.0f) || !((HashMap)c).containsKey(entityPlayer.getName())) continue;
            ((HashMap)c).remove(entityPlayer.getName(), ((HashMap)c).get(entityPlayer.getName()));
        }
        this.0().forEach(this::0);
    }

    public boolean c(Entity entity) {
        return this.c.containsKey(entity);
    }

    @Subscriber
    public void c(0T t) {
        block2: {
            CPacketUseEntity cPacketUseEntity;
            if (Minecraft.getMinecraft().world == null || Minecraft.getMinecraft().player == null) {
                return;
            }
            if (!(t.c() instanceof CPacketUseEntity) || !(cPacketUseEntity = (CPacketUseEntity)t.c()).getAction().equals((Object)CPacketUseEntity.Action.ATTACK) || !(cPacketUseEntity.getEntityFromWorld((World)Minecraft.getMinecraft().world) instanceof EntityPlayer)) break block2;
            EntityPlayer entityPlayer = (EntityPlayer)cPacketUseEntity.getEntityFromWorld((World)Minecraft.getMinecraft().world);
            if (!c && entityPlayer == null) {
                throw new AssertionError();
            }
            this.1((Entity)entityPlayer);
        }
    }

    public void c() {
        this.c.forEach(this::c);
    }

    public void 3(Entity entity) {
        this.c.remove(entity);
    }

    public void 0(Entity entity) {
        block0: {
            EntityPlayer entityPlayer;
            if (!(entity instanceof EntityPlayer) || !((entityPlayer = (EntityPlayer)entity).getHealth() <= 0.0f)) break block0;
            1E e2 = new 1E(entityPlayer);
            EventDispatcher.Companion.dispatch(e2);
            this.3((Entity)entityPlayer);
        }
    }

    public int 2(Entity entity) {
        int n2;
        block11: {
            Entity entity2;
            Map<Entity, Long> map;
            try {
                map = this.c;
                entity2 = entity;
            }
            catch (NullPointerException nullPointerException) {
                return 255;
            }
            boolean bl = map.containsKey(entity2);
            if (bl) break block11;
            return 255;
        }
        long l2 = System.currentTimeMillis();
        Map<Entity, Long> map = this.c;
        Entity entity3 = entity;
        Long l3 = map.get(entity3);
        Long l4 = l3;
        long l5 = l4;
        int n3 = n2 = (int)(l2 - l5) / 118;
        int n4 = 255;
        return Math.min(n3, n4);
    }

    public Set<Entity> 0() {
        return this.c.keySet();
    }

    public void 1(Entity entity) {
        this.c.put(entity, System.currentTimeMillis());
    }

    @Subscriber
    public void c(14 var1_1) {
        block0: {
            if (!this.c.c(10000.0)) break block0;
            this.c();
            this.c.c();
        }
    }

    @Subscriber
    public void c(0S s) {
        SPacketEntityStatus sPacketEntityStatus;
        if (Minecraft.getMinecraft().world == null || Minecraft.getMinecraft().player == null) {
            return;
        }
        if (s.c() instanceof SPacketEntityStatus && (sPacketEntityStatus = (SPacketEntityStatus)s.c()).getOpCode() == 35) {
            Entity entity = sPacketEntityStatus.getEntity((World)Minecraft.getMinecraft().world);
            if (c == null) {
                c = new HashMap<Entity, Long>();
            }
            if (((HashMap)c).get(entity.getName()) == null) {
                ((HashMap)c).put((Entity)entity.getName(), (Long)1);
            } else if (((HashMap)c).get(entity.getName()) != null) {
                ((HashMap)c).put((Entity)entity.getName(), (Long)((Integer)((HashMap)c).get(entity.getName()) + 1));
            }
            1F f2 = new 1F(entity, (Integer)((HashMap)c).get(entity.getName()));
            EventDispatcher.Companion.dispatch(f2);
        }
    }

    public void 1() {
        this.c.clear();
    }
}

