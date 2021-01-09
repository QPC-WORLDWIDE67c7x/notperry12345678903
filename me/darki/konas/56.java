/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.awt.Color;
import java.lang.invoke.LambdaMetafactory;
import java.util.LinkedList;
import me.darki.konas.08;
import me.darki.konas.1O;
import me.darki.konas.1P;
import me.darki.konas.1b_0;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.55;
import me.darki.konas.6S;
import me.darki.konas.89;
import me.darki.konas.8L;
import me.darki.konas.8h_0;
import me.darki.konas.8k_0;
import me.darki.konas.99;
import me.darki.konas.9m;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 56
extends 3E {
    public static 8h_0<Float> 1 = new 8h_0("Delay", Float.valueOf(0.1f), Float.valueOf(5.0f), Float.valueOf(0.0f), Float.valueOf(0.1f));
    public static 8h_0<Float> 2 = new 8h_0("Reach", Float.valueOf(4.2f), Float.valueOf(6.0f), Float.valueOf(1.0f), Float.valueOf(0.1f));
    public static 8h_0<Boolean> 3 = new 8h_0("Rotate", false);
    public static 8h_0<Boolean> 4 = new 8h_0("AutoSwap", false);
    public static 8h_0<Boolean> 5 = new 8h_0("Queue", false);
    public static 8h_0<Boolean> 6 = new 8h_0("Render", false);
    public 8h_0<89> 7 = new 8h_0("Queue", new 89(0x550000FF)).c(6::6);
    public 8h_0<89> 8 = new 8h_0("QueueOutline", new 89(Color.BLUE.hashCode())).c(6::6);
    public 8h_0<89> 9 = new 8h_0("Mining", new 89(0x55FF0000)).c(6::6);
    public 8h_0<89> a = new 8h_0("MiningOutline", new 89(Color.RED.hashCode())).c(6::6);
    public 8h_0<89> b = new 8h_0("Ready", new 89(0x5500FF00)).c(6::6);
    public 8h_0<89> d = new 8h_0("ReadyOutline", new 89(Color.GREEN.hashCode())).c(6::6);
    public 8h_0<Float> e = new 8h_0("Width", Float.valueOf(1.5f), Float.valueOf(10.0f), Float.valueOf(0.0f), Float.valueOf(0.1f)).c(6::6);
    public float c;
    public int 1;
    public 55 c;
    public 9m c;
    public Runnable c;
    public LinkedList<55> c = (float)new LinkedList();

    @Override
    public void c() {
        this.c.clear();
        this.c = null;
        this.c = 0.0f;
        this.c = null;
        this.1 = -1;
    }

    public 89 c(55 var1_1) {
        if (var1_1.equals(this.c)) {
            if (this.c >= 1.0f) {
                return (89)this.d.6();
            }
            return (89)this.a.6();
        }
        return (89)this.8.6();
    }

    public 56() {
        super("PacketMine", 3D.4, "ServerSideMine");
    }

    @Subscriber
    public void c(08 var1_1) {
        var1_1.c();
        if (var1_1.2() == null || !this.c(var1_1.2())) {
            return;
        }
        55 var2_2 = new 55(var1_1.2(), var1_1.0());
        if (!this.c.contains(var2_2) && (((Boolean)5.6()).booleanValue() || this.c.isEmpty() && this.c == null)) {
            this.c.add(var2_2);
        }
    }

    public void 0() {
        block0: {
            if (this.c == null) break block0;
            56.c.player.swingArm(EnumHand.MAIN_HAND);
            56.c.player.connection.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, this.c.1(), this.c.c()));
            56.c.player.connection.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, this.c.1(), this.c.c()));
        }
    }

    @Subscriber
    public void c(1O o2) {
        if (this.c != null && this.c.c(((Float)1.6()).floatValue() * 50.0f)) {
            this.c.run();
            this.c = null;
        }
    }

    public boolean c(BlockPos blockPos) {
        IBlockState iBlockState;
        BlockPos blockPos2;
        WorldClient worldClient;
        try {
            worldClient = 56.c.world;
            blockPos2 = blockPos;
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
        IBlockState iBlockState2 = worldClient.getBlockState(blockPos2);
        IBlockState iBlockState3 = iBlockState = iBlockState2;
        WorldClient worldClient2 = 56.c.world;
        BlockPos blockPos3 = blockPos;
        float f2 = iBlockState3.getBlockHardness((World)worldClient2, blockPos3);
        return f2 != -1.0f;
    }

    @Subscriber
    public void c(1b_0 b_02) {
        LinkedList linkedList = (LinkedList)this.c.clone();
        if (this.c != null) {
            linkedList.add(this.c);
        }
        while (!linkedList.isEmpty()) {
            55 var3_3 = (55)linkedList.poll();
            AxisAlignedBB axisAlignedBB = 56.c.world.getBlockState(var3_3.1()).getBoundingBox((IBlockAccess)56.c.world, var3_3.1()).offset(var3_3.1());
            if (axisAlignedBB == null) continue;
            99.c();
            99.c(axisAlignedBB, true, 1.0, this.0(var3_3), 63);
            99.c(axisAlignedBB, ((Float)this.e.6()).floatValue(), this.c(var3_3));
            99.0();
        }
    }

    public void 1() {
        if (this.c >= 1.0f) {
            return;
        }
        IBlockState iBlockState = this.c.0();
        int n2 = 6S.c(this.c.1());
        if (n2 == -1) {
            n2 = 56.c.player.inventory.currentItem;
        }
        int n3 = 56.c.player.inventory.currentItem;
        56.c.player.inventory.currentItem = n2;
        this.c += iBlockState.getPlayerRelativeBlockHardness((EntityPlayer)56.c.player, (World)56.c.world, this.c.1());
        56.c.player.inventory.currentItem = n3;
    }

    /*
     * Unable to fully structure code
     */
    @Subscriber
    public void c(1P var1_1) {
        block9: {
            block8: {
                block7: {
                    if (!8L.c((Boolean)56.3.6())) {
                        return;
                    }
                    if (this.c == null) break block7;
                    if (!56.c.world.getBlockState(this.c.1()).getBlock().equals(this.c.0().getBlock())) ** GOTO lbl-1000
                    v0 = new Vec3d((Vec3i)this.c.1());
                    v1 = new Vec3d(this.c.c().getDirectionVec());
                    if (56.c.player.getPositionEyes(1.0f).distanceTo(v0.add(v1.scale(0.5))) <= (double)((Float)56.2.6()).floatValue()) {
                        this.1();
                        if (((Boolean)56.4.6()).booleanValue() && this.c >= 1.0f && this.1 == -1 && (var2_2 = 6S.c(this.c.1())) != -1 && var2_2 != 56.c.player.inventory.currentItem) {
                            56.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(var2_2));
                            this.1 = var2_2;
                        }
                    } else lbl-1000:
                    // 2 sources

                    {
                        this.c = null;
                        if (this.1 != -1) {
                            56.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(this.1));
                            this.1 = -1;
                        }
                    }
                    break block8;
                }
                if (this.c.isEmpty()) break block8;
                var2_3 = (55)this.c.peek();
                if (!56.c.world.getBlockState(var2_3.1()).getBlock().equals(var2_3.0().getBlock())) ** GOTO lbl-1000
                v2 = new Vec3d((Vec3i)var2_3.1());
                v3 = new Vec3d(var2_3.c().getDirectionVec());
                if (56.c.player.getPositionEyes(1.0f).distanceTo(v2.add(v3.scale(0.5))) <= (double)((Float)56.2.6()).floatValue()) {
                    this.c.poll();
                    this.c = var2_3;
                    this.c = 0.0f;
                    this.c.c();
                    this.c = (Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, 0(), ()V)((56)this);
                    this.1();
                } else lbl-1000:
                // 2 sources

                {
                    this.c.poll();
                }
            }
            if (!((Boolean)56.3.6()).booleanValue() || this.c == null) break block9;
            8k_0.c.c.c(new Vec3d((Vec3i)this.c.1()).add(new Vec3d(this.c.c().getDirectionVec()).scale(0.5)));
        }
    }

    public 89 0(55 var1_1) {
        if (var1_1.equals(this.c)) {
            if (this.c >= 1.0f) {
                return (89)this.b.6();
            }
            return (89)this.9.6();
        }
        return (89)this.7.6();
    }
}

