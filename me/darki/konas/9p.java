/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.util.Objects;
import me.darki.konas.9r;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.storage.WorldInfo;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 9p {
    public String c;
    public double c;
    public double 0;
    public double 1;
    public int c;
    public String 0;
    public 9r c;

    public int hashCode() {
        return Objects.hash(this.c, this.0, this.1, this.c, this.0);
    }

    public 9p(String string, double d2, double d3, double d4, int n2, 9r r) {
        this.c = string;
        this.c = d2;
        this.0 = d3;
        this.1 = d4;
        this.c = n2;
        this.0 = "";
        try {
            if (Minecraft.getMinecraft().isSingleplayer()) {
                this.0 = Minecraft.getMinecraft().player.getEntityWorld().getWorldInfo().getWorldName();
            } else if (Minecraft.getMinecraft().getCurrentServerData() != null) {
                this.0 = Minecraft.getMinecraft().getCurrentServerData().serverIP.replaceAll(":", "_");
            }
        }
        catch (NullPointerException nullPointerException) {
            this.0 = "";
        }
        this.c = r;
    }

    public 9p(String string, double d2, double d3, double d4, int n2, String string2, 9r r) {
        this.c = string;
        this.c = d2;
        this.0 = d3;
        this.1 = d4;
        this.c = n2;
        this.0 = string2;
        this.c = r;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        9p p2 = (9p)object;
        if ((double)Double.compare(p2.c, this.c) != 0.0) return false;
        if ((double)Double.compare(p2.0, this.0) != 0.0) return false;
        if ((double)Double.compare(p2.1, this.1) != 0.0) return false;
        if (this.c != p2.c) return false;
        if (this.c != p2.c) return false;
        if (!this.0.equalsIgnoreCase(p2.6())) return false;
        return true;
    }

    public String toString() {
        return "Waypoint: {name=" + this.c + ", x=" + this.c + ", y=" + this.0 + ", z=" + this.1 + ", dimension=" + this.c + '}';
    }

    public String 6() {
        return this.0;
    }

    public int 2() {
        return this.c;
    }

    public 9r 1() {
        return this.c;
    }

    public boolean 0() {
        block28: {
            block27: {
                Minecraft minecraft = Minecraft.getMinecraft();
                boolean bl = minecraft.isSingleplayer();
                if (!bl) break block27;
                String string = this.0;
                Minecraft minecraft2 = Minecraft.getMinecraft();
                EntityPlayerSP entityPlayerSP = minecraft2.player;
                World world = entityPlayerSP.getEntityWorld();
                WorldInfo worldInfo = world.getWorldInfo();
                String string2 = worldInfo.getWorldName();
                return string.equalsIgnoreCase(string2);
            }
            Minecraft minecraft = Minecraft.getMinecraft();
            ServerData serverData = minecraft.getCurrentServerData();
            if (serverData == null) break block28;
            String string = this.0;
            Minecraft minecraft3 = Minecraft.getMinecraft();
            ServerData serverData2 = minecraft3.getCurrentServerData();
            String string3 = serverData2.serverIP;
            String string4 = ":";
            String string5 = "_";
            String string6 = string3.replaceAll(string4, string5);
            try {
                return string.equalsIgnoreCase(string6);
            }
            catch (NullPointerException nullPointerException) {
                this.0 = "";
            }
        }
        return false;
    }

    public double c(9p p2) {
        double d2 = 1.0;
        if (this.c == -1 && p2.2() != -1) {
            d2 = 8.0;
        }
        double d3 = p2.4() - this.c * d2;
        double d4 = p2.c() - this.0 * d2;
        double d5 = p2.5() - this.1 * d2;
        return MathHelper.sqrt((double)(d3 * d3 + d4 * d4 + d5 * d5));
    }

    public double 5() {
        return this.1;
    }

    public String 3() {
        return this.c;
    }

    public double c() {
        return this.0;
    }

    public double 4() {
        return this.c;
    }
}

