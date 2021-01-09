/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import io.netty.util.internal.ConcurrentSet;
import java.awt.Color;
import java.util.Set;
import me.darki.konas.0S;
import me.darki.konas.1b_0;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.89;
import me.darki.konas.8h_0;
import me.darki.konas.96;
import me.darki.konas.97;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.network.play.server.SPacketChunkData;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.ChunkPos;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 7K
extends 3E {
    public ICamera c;
    public Set<ChunkPos> c = new ConcurrentSet();
    public 8h_0<89> 1 = new 8h_0("Color", new 89(new Color(0.8392157f, 0.3372549f, 0.5764706f, 0.39215687f).hashCode(), false));

    @Subscriber
    public void c(0S s) {
        if (s.c() instanceof SPacketChunkData) {
            SPacketChunkData sPacketChunkData = (SPacketChunkData)s.c();
            if (sPacketChunkData.isFullChunk()) {
                return;
            }
            ChunkPos chunkPos = new ChunkPos(sPacketChunkData.getChunkX(), sPacketChunkData.getChunkZ());
            this.c.add(chunkPos);
        }
    }

    @Subscriber
    public void c(1b_0 b_02) {
        if (c.getRenderViewEntity() == null) {
            return;
        }
        this.c.setPosition(7K.c.getRenderViewEntity().posX, 7K.c.getRenderViewEntity().posY, 7K.c.getRenderViewEntity().posZ);
        GlStateManager.pushMatrix();
        96.1();
        GlStateManager.disableTexture2D();
        GlStateManager.disableAlpha();
        GlStateManager.disableDepth();
        GlStateManager.depthMask((boolean)false);
        GlStateManager.glLineWidth((float)2.0f);
        for (ChunkPos chunkPos : this.c) {
            AxisAlignedBB axisAlignedBB = new AxisAlignedBB((double)chunkPos.getXStart(), 0.0, (double)chunkPos.getZStart(), (double)chunkPos.getXEnd(), 0.0, (double)chunkPos.getZEnd());
            GlStateManager.pushMatrix();
            if (this.c.isBoundingBoxInFrustum(axisAlignedBB)) {
                double d2 = 7K.c.player.lastTickPosX + (7K.c.player.posX - 7K.c.player.lastTickPosX) * (double)b_02.c();
                double d3 = 7K.c.player.lastTickPosY + (7K.c.player.posY - 7K.c.player.lastTickPosY) * (double)b_02.c();
                double d4 = 7K.c.player.lastTickPosZ + (7K.c.player.posZ - 7K.c.player.lastTickPosZ) * (double)b_02.c();
                97.c(axisAlignedBB.offset(-d2, -d3, -d4), 3, ((89)this.1.6()).c());
            }
            GlStateManager.popMatrix();
        }
        GlStateManager.glLineWidth((float)1.0f);
        GlStateManager.enableTexture2D();
        GlStateManager.enableDepth();
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableAlpha();
        96.c();
        GlStateManager.popMatrix();
    }

    @Override
    public void c() {
        this.c.clear();
    }

    public 7K() {
        super("NewChunks", 3D.2, new String[0]);
    }
}

