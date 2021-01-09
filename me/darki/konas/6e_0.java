/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.0N;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.8V;
import me.darki.konas.8W;
import me.darki.konas.8h_0;
import me.darki.konas.8p_0;
import me.darki.konas.8x_0;
import me.darki.konas.9m;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;

/*
 * Renamed from me.darki.konas.6e
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 6e_0
extends 3E {
    public 8h_0<Boolean> 1;
    public 8h_0<Boolean> 2;
    public 8h_0<Boolean> 3;
    public 8V c;
    public int 1;
    public boolean 1 = false;
    public 9m c;
    public 9m 0;
    public BlockPos c = null;

    public 6e_0() {
        super("AutoWalk", "Walk forward", 0, 3D.0, new String[0]);
        this.2 = new 8h_0("Jump", true);
        this.3 = new 8h_0("Timeout", true);
        this.c = new 9m();
        this.0 = new 9m();
    }

    /*
     * Enabled aggressive block sorting
     */
    @Subscriber
    public void c(0N n2) {
        float f2;
        if (((Minecraft)6e_0.c).world == null) return;
        if (((Minecraft)6e_0.c).player == null) {
            return;
        }
        float f3 = f2 = n2.c().sneak ? 0.3f : 1.0f;
        if (((Minecraft)6e_0.c).player.getPosition() != this.c) {
            this.0.c();
        }
        if (this.0.c(5000.0)) {
            8p_0.1("Can't find path!");
            this.d();
            return;
        }
        if (!((Boolean)this.1.6()).booleanValue()) {
            n2.c().moveForward = f2;
            if ((Boolean)this.2.6() == false) return;
            if (!6e_0.c.player.collidedHorizontally) return;
            if (!6e_0.c.player.onGround) return;
            n2.c().jump = true;
            return;
        }
        if (this.c == null) {
            8p_0.1("Please use the .goto command!");
            this.d();
            return;
        }
        if (this.1) {
            if (this.c.0().isEmpty()) {
                8p_0.1("Done!");
                this.d();
                return;
            }
            this.1 = false;
        }
        BlockPos blockPos = new BlockPos(6e_0.c.player.posX, 6e_0.c.player.onGround ? 6e_0.c.player.posY + 0.5 : 6e_0.c.player.posY, 6e_0.c.player.posZ);
        if (this.c.c().equals((Object)blockPos)) {
            8p_0.1("Done!");
            this.d();
            return;
        }
        if (!this.c.c(150.0)) {
            n2.c().moveForward = f2;
        }
        8W w = this.c.0().get(this.1);
        int n3 = this.c.0().indexOf(blockPos);
        if (blockPos.equals((Object)w)) {
            ++this.1;
            if (this.1 >= this.c.0().size()) {
                this.1 = true;
                this.1 = 0;
                this.c.2();
            }
        } else if (n3 > this.1) {
            this.1 = n3 + 1;
            if (this.1 >= this.c.0().size()) {
                this.1 = true;
                this.1 = 0;
                this.c.2();
            }
        }
        if (this.1) {
            if (this.c.0().isEmpty()) {
                this.1.2(Boolean.valueOf(false));
                this.d();
                return;
            }
            this.1 = false;
        }
        if (blockPos.getX() != w.getX() || blockPos.getZ() != w.getZ()) {
            n2.c().moveForward = f2;
            this.c.c();
            double[] dArray = 8x_0.c((float)w.getX() + 0.5f, w.getY(), (float)w.getZ() + 0.5f, (EntityPlayer)((Minecraft)6e_0.c).player);
            6e_0.c.player.rotationYaw = (float)dArray[0];
            if (this.1 <= 0 || !this.c.0().get(this.1 - 1).c()) {
                if (blockPos.getY() >= w.getY()) return;
            }
            n2.c().jump = true;
            return;
        }
        if (blockPos.getY() == w.getY()) return;
        if (blockPos.getY() < w.getY()) {
            if (this.1 < this.c.0().size() - 1 && !w.up().equals((Object)this.c.0().get(this.1 + 1))) {
                ++this.1;
            }
            n2.c().jump = true;
            return;
        }
        while (this.1 < this.c.0().size() - 1 && this.c.0().get(this.1).down().equals((Object)this.c.0().get(this.1 + 1))) {
            ++this.1;
        }
        n2.c().moveForward = f2;
        this.c.c();
    }
}

