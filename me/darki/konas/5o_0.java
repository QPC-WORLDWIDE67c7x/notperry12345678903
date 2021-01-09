/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.util.ArrayList;
import java.util.List;
import me.darki.konas.14;
import me.darki.konas.3D;
import me.darki.konas.3E;
import net.minecraft.client.gui.GuiDownloadTerrain;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.5o
 */
public class 5o_0
extends 3E {
    public static ArrayList<EntityPlayer> 0 = new ArrayList();

    public static boolean 0(Entity entity) {
        return entity instanceof EntityPlayer;
    }

    public static List<EntityPlayer> c() {
        return 0;
    }

    public 5o_0() {
        super("AntiBot", 3D.3, new String[0]);
    }

    public static void 1(Entity entity) {
        if (!0.contains(entity)) {
            0.add((EntityPlayer)entity);
        }
    }

    public boolean c(EntityPlayer entityPlayer) {
        NetworkPlayerInfo networkPlayerInfo = c.getConnection().getPlayerInfo(entityPlayer.getGameProfile().getId());
        return networkPlayerInfo == null || networkPlayerInfo.getResponseTime() <= 0 && !entityPlayer.equals((Object)5o_0.c.player) && networkPlayerInfo.getGameProfile() == null && entityPlayer.hasCustomName();
    }

    public static boolean 2(Entity entity) {
        return entity != 5o_0.c.player && entity != null;
    }

    @Subscriber
    public void c(14 var1_1) {
        block1: {
            this.0(0.size() + "");
            if (5o_0.c.currentScreen instanceof GuiDownloadTerrain && !0.isEmpty()) {
                0.clear();
            }
            if (5o_0.c.world == null) break block1;
            5o_0.c.world.loadedEntityList.stream().filter(5o_0::0).filter(5o_0::2).filter(this::c).forEach(5o_0::1);
        }
    }

    public boolean c(Entity entity) {
        return this.c((EntityPlayer)entity);
    }

    @Override
    public void 7() {
        0.clear();
    }
}

