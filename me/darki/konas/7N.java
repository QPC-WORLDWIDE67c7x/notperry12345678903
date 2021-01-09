/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import com.google.common.collect.Sets;
import cookiedragon.eventsystem.Subscriber;
import java.util.Set;
import me.darki.konas.00;
import me.darki.konas.0S;
import me.darki.konas.0V;
import me.darki.konas.0r_0;
import me.darki.konas.0z_0;
import me.darki.konas.1N;
import me.darki.konas.1f_0;
import me.darki.konas.1h_0;
import me.darki.konas.1o_0;
import me.darki.konas.1s_0;
import me.darki.konas.1u_0;
import me.darki.konas.1x_0;
import me.darki.konas.1y_0;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.7M;
import me.darki.konas.8e_0;
import me.darki.konas.8h_0;
import me.darki.konas.W;
import me.darki.konas.mixin.mixins.IWorld;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleFirework;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.network.play.server.SPacketExplosion;
import net.minecraft.network.play.server.SPacketMaps;
import net.minecraft.network.play.server.SPacketSoundEffect;
import net.minecraft.network.play.server.SPacketSpawnExperienceOrb;
import net.minecraft.network.play.server.SPacketSpawnGlobalEntity;
import net.minecraft.network.play.server.SPacketSpawnMob;
import net.minecraft.network.play.server.SPacketSpawnObject;
import net.minecraft.util.SoundEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 7N
extends 3E {
    public static Set<SoundEvent> c = Sets.newHashSet((Object[])new SoundEvent[]{SoundEvents.ENTITY_BAT_AMBIENT, SoundEvents.ENTITY_BAT_DEATH, SoundEvents.ENTITY_BAT_HURT, SoundEvents.ENTITY_BAT_LOOP, SoundEvents.ENTITY_BAT_TAKEOFF});
    public 8h_0<Boolean> 1 = new 8h_0("NoHurtCam", true);
    public 8h_0<Boolean> 2 = new 8h_0("NoWeather", true);
    public 8h_0<Boolean> 3 = new 8h_0("NoLightning", true);
    public 8h_0<Boolean> 4 = new 8h_0("NoFire", true);
    public 8h_0<Boolean> 5 = new 8h_0("NoBossBar", false);
    public 8h_0<Boolean> 6 = new 8e_0("NoBats", true, this::c);
    public 8h_0<7M> 7 = new 8h_0("Armor", 7M.c);
    public 8h_0<Boolean> 8 = new 8h_0("Head", true).c(this::c);
    public 8h_0<Boolean> 9 = new 8h_0("Chestplate", false).c(this::7);
    public 8h_0<Boolean> a = new 8h_0("Leggings", false).c(this::0);
    public 8h_0<Boolean> b = new 8h_0("Boots", false).c(this::6);
    public 8h_0<Boolean> d = new 8h_0("OwnShadow", true);
    public 8h_0<Boolean> e = new 8h_0("Mob", false);
    public 8h_0<Boolean> f = new 8h_0("Object", false);
    public 8h_0<Boolean> g = new 8h_0("XP", true);
    public 8h_0<Boolean> h = new 8h_0("Explosions", true);
    public 8h_0<Boolean> i = new 8h_0("Fireworks", false);
    public 8h_0<Boolean> j = new 8h_0("Item", false);
    public 8h_0<Boolean> k = new 8h_0("Water", true);
    public 8h_0<Boolean> l = new 8h_0("Lava", true);
    public 8h_0<Boolean> m = new 8h_0("Blocks", true);
    public 8h_0<Boolean> n = new 8h_0("EnchantmentTable", false);
    public 8h_0<Boolean> o = new 8h_0("Signs", false);
    public 8h_0<Boolean> p = new 8h_0("Maps", false);
    public 8h_0<Boolean> q = new 8h_0("Beacon", false);
    public static 8h_0<Boolean> r = new 8h_0("Toasts", true);
    public 8h_0<Boolean> s = new 8h_0("Chat", false);
    public EntityPlayer.EnumChatVisibility c = null;

    public boolean c() {
        return this.7.6() == 7M.1;
    }

    public 7N() {
        super("NoRender", 3D.2, new String[0]);
    }

    @Subscriber
    public void c(1s_0 s_02) {
        block0: {
            if (!((Boolean)this.p.6()).booleanValue()) break block0;
            s_02.c(true);
        }
    }

    @Subscriber
    public void c(W w) {
        block1: {
            block4: {
                block3: {
                    block2: {
                        block0: {
                            if (this.7.6() != 7M.0) break block0;
                            w.c();
                            break block1;
                        }
                        if (this.7.6() != 7M.1) break block1;
                        if (w.c() != EntityEquipmentSlot.HEAD || !((Boolean)this.8.6()).booleanValue()) break block2;
                        w.c();
                        break block1;
                    }
                    if (w.c() != EntityEquipmentSlot.CHEST || !((Boolean)this.9.6()).booleanValue()) break block3;
                    w.c();
                    break block1;
                }
                if (w.c() != EntityEquipmentSlot.LEGS || !((Boolean)this.a.6()).booleanValue()) break block4;
                w.c();
                break block1;
            }
            if (w.c() != EntityEquipmentSlot.FEET || !((Boolean)this.b.6()).booleanValue()) break block1;
            w.c();
        }
    }

    public static boolean 0(Entity entity) {
        return entity instanceof EntityBat;
    }

    public void c(Boolean bl) {
        block0: {
            if (!bl.booleanValue()) break block0;
            this.1();
        }
    }

    @Subscriber
    public void c(1y_0 y_02) {
        block0: {
            if (!((Boolean)this.o.6()).booleanValue()) break block0;
            y_02.c();
        }
    }

    @Override
    public void c() {
        this.1();
    }

    @Subscriber
    public void c(1f_0 f_02) {
        block0: {
            if (!((Boolean)this.q.6()).booleanValue()) break block0;
            f_02.c();
        }
    }

    public boolean 6() {
        return this.7.6() == 7M.1;
    }

    @Subscriber
    public void c(0z_0 z_02) {
        block0: {
            if (!((Boolean)this.1.6()).booleanValue()) break block0;
            z_02.c();
        }
    }

    @Subscriber
    public void c(1h_0 h_02) {
        block0: {
            if (!((Boolean)this.n.6()).booleanValue()) break block0;
            h_02.c();
        }
    }

    @Subscriber
    public void c(1N n2) {
        if (((Minecraft)7N.c).world == null || ((Minecraft)7N.c).player == null) {
            return;
        }
        if (((Boolean)this.s.6()).booleanValue()) {
            if (this.c == null) {
                this.c = 7N.c.gameSettings.chatVisibility;
            }
            7N.c.gameSettings.chatVisibility = EntityPlayer.EnumChatVisibility.HIDDEN;
        } else if (this.c != null) {
            7N.c.gameSettings.chatVisibility = this.c;
            this.c = null;
        }
        if (((Boolean)this.2.6()).booleanValue()) {
            if ((double)((IWorld)((Minecraft)7N.c).world).getRainingStrength() > 0.9) {
                this.0("Thunder");
            } else if ((double)((IWorld)((Minecraft)7N.c).world).getRainingStrength() > 0.2) {
                this.0("Rain");
            } else {
                this.0("Clear");
            }
        } else {
            this.0("");
        }
    }

    @Subscriber
    public void c(0r_0 r_02) {
        block0: {
            if (!((Boolean)this.2.6()).booleanValue()) break block0;
            r_02.c();
        }
    }

    @Subscriber
    public void c(0S s) {
        block3: {
            if (s.c() instanceof SPacketSpawnGlobalEntity && ((Boolean)this.3.6()).booleanValue() && ((SPacketSpawnGlobalEntity)s.c()).getType() == 1) {
                s.c(true);
            }
            if (s.c() instanceof SPacketMaps && ((Boolean)this.p.6()).booleanValue()) {
                s.c(true);
            }
            if (((Boolean)this.6.6()).booleanValue() && (s.c() instanceof SPacketSpawnMob && ((SPacketSpawnMob)s.c()).getEntityType() == 65 || s.c() instanceof SPacketSoundEffect && c.contains(((SPacketSoundEffect)s.c()).getSound()))) {
                s.c();
            }
            if (!(s.c() instanceof SPacketSpawnMob && (Boolean)this.e.6() != false || s.c() instanceof SPacketSpawnObject && (Boolean)this.f.6() != false || s.c() instanceof SPacketSpawnExperienceOrb && (Boolean)this.g.6() != false || s.c() instanceof SPacketExplosion && (Boolean)this.h.6() != false || s.c() instanceof SPacketSpawnObject && (Boolean)this.j.6() != false && ((SPacketSpawnObject)s.c()).getType() == 2) && (!(s.c() instanceof SPacketSpawnObject) || !((Boolean)this.i.6()).booleanValue() || ((SPacketSpawnObject)s.c()).getType() != 76)) break block3;
            s.c();
        }
    }

    @Subscriber
    public void c(1u_0 u_02) {
        block5: {
            boolean bl = false;
            switch (u_02.c()) {
                case FIRE: {
                    if (!((Boolean)this.4.6()).booleanValue()) break;
                    bl = true;
                    break;
                }
                case WATER: {
                    if (!((Boolean)this.k.6()).booleanValue()) break;
                    bl = true;
                    break;
                }
                case BLOCK: {
                    if (!((Boolean)this.m.6()).booleanValue()) break;
                    bl = true;
                }
            }
            if (!bl) break block5;
            u_02.c();
        }
    }

    public void 1() {
        block0: {
            if (!((Boolean)this.6.6()).booleanValue() || ((Minecraft)7N.c).player == null || ((Minecraft)7N.c).world == null) break block0;
            ((Minecraft)7N.c).world.getLoadedEntityList().stream().filter(7N::0).forEach(7N::c);
        }
    }

    @Subscriber
    public void c(1x_0 x_02) {
        block0: {
            if (!((Boolean)this.d.6()).booleanValue()) break block0;
            x_02.c(true);
        }
    }

    @Subscriber
    public void c(0V v) {
        block0: {
            if (!((Boolean)this.i.6()).booleanValue() || !(v.c() instanceof ParticleFirework.Overlay) && !(v.c() instanceof ParticleFirework.Spark) && !(v.c() instanceof ParticleFirework.Starter)) break block0;
            v.c(true);
        }
    }

    @Subscriber
    public void c(1o_0 o_02) {
        block0: {
            if (!((Boolean)this.l.6()).booleanValue() || !o_02.0().getMaterial().equals(Material.LAVA)) break block0;
            o_02.c();
        }
    }

    @Subscriber
    public void c(00 var1_1) {
        block0: {
            if (!((Boolean)this.5.6()).booleanValue()) break block0;
            var1_1.c();
        }
    }

    public boolean 7() {
        return this.7.6() == 7M.1;
    }

    public boolean 0() {
        return this.7.6() == 7M.1;
    }

    public static void c(Entity entity) {
        ((Minecraft)7N.c).world.removeEntity(entity);
    }
}

