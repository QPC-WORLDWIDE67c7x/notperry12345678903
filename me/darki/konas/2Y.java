/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.awt.Color;
import me.darki.konas.2E;
import me.darki.konas.2X;
import me.darki.konas.89;
import me.darki.konas.8J;
import me.darki.konas.8h_0;
import me.darki.konas.94;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import org.lwjgl.opengl.GL11;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 2Y
extends 2E {
    public 8h_0<2X> 1 = new 8h_0("Rotate", 2X.c);
    public 8h_0<Boolean> 2 = new 8h_0("Players", true);
    public 8h_0<Boolean> 3 = new 8h_0("Mobs", true);
    public 8h_0<Boolean> 4 = new 8h_0("Animals", true);
    public 8h_0<Boolean> 5 = new 8h_0("Invisibles", true);
    public 8h_0<Double> 6 = new 8h_0("Size", 1.0, 2.0, 0.1, 0.05);

    @Override
    public void 5() {
        block13: {
            if (2Y.c.player == null || 2Y.c.world == null) {
                return;
            }
            if (2Y.c.gameSettings.showDebugInfo) break block13;
            int n2 = (int)this.9();
            int n3 = (int)this.3();
            int n4 = (int)((double)this.c() * 0.425);
            int n5 = (int)((float)n2 + this.c() / 2.0f);
            int n6 = (int)((float)n3 + this.7() / 2.0f);
            94.c(this.9(), this.3(), this.c(), this.7(), ((89)this.c.6()).c());
            94.c(this.9(), this.3(), this.c(), this.7(), 1.0f, ((89)this.0.6()).c());
            GL11.glPushMatrix();
            GL11.glDisable((int)3553);
            GL11.glBlendFunc((int)770, (int)771);
            GL11.glEnable((int)3042);
            Object[][] objectArrayArray = 2Y.c.world.loadedEntityList.iterator();
            while (objectArrayArray.hasNext()) {
                double d2;
                double d3;
                double d4;
                Object[][] objectArrayArray2 = (Object[][])objectArrayArray.next();
                if (!this.c(objectArrayArray2) || !((d4 = Math.sqrt((d3 = 2Y.c.player.posX - objectArrayArray2.posX) * d3 + (d2 = 2Y.c.player.posZ - objectArrayArray2.posZ) * d2)) <= (double)this.c() / 2.0 - (double)this.c() / 50.0)) continue;
                GL11.glPushMatrix();
                double d5 = 2Y.c.player.posX - objectArrayArray2.posX + (double)n2 + (double)(this.c() / 2.0f);
                double d6 = 2Y.c.player.posZ - objectArrayArray2.posZ + (double)n3 + (double)(this.c() / 2.0f);
                GL11.glTranslated((double)n5, (double)n6, (double)0.0);
                GL11.glRotatef((float)(this.1.6() != 2X.c ? -2Y.c.player.rotationYaw : -180.0f), (float)0.0f, (float)0.0f, (float)1.0f);
                GL11.glTranslated((double)(-n5), (double)(-n6), (double)0.0);
                double d7 = 12.0;
                GL11.glTranslated((double)d5, (double)d6, (double)0.0);
                GL11.glRotatef((float)((this.1.6() != 2X.c ? 2Y.c.player.rotationYaw + 180.0f : 0.0f) + 180.0f), (float)0.0f, (float)0.0f, (float)1.0f);
                GL11.glTranslated((double)(-d5), (double)(-d6), (double)0.0);
                if (objectArrayArray2 instanceof EntityPlayer) {
                    if (8J.1(objectArrayArray2.getName())) {
                        GL11.glColor4f((float)0.3f, (float)1.0f, (float)0.3f, (float)1.0f);
                    } else {
                        GL11.glColor4f((float)1.0f, (float)0.3f, (float)0.3f, (float)1.0f);
                    }
                } else if (objectArrayArray2 instanceof EntityMob) {
                    GL11.glColor4f((float)1.0f, (float)0.5f, (float)0.5f, (float)1.0f);
                } else if (objectArrayArray2 instanceof EntityAnimal) {
                    GL11.glColor4f((float)0.5f, (float)1.0f, (float)0.5f, (float)1.0f);
                } else {
                    GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)0.0f);
                }
                GL11.glBegin((int)9);
                GL11.glVertex2d((double)d5, (double)(d6 + (double)((Double)this.6.6()).floatValue()));
                GL11.glVertex2d((double)(d5 + (double)((Double)this.6.6()).floatValue()), (double)d6);
                GL11.glVertex2d((double)d5, (double)(d6 - (double)((Double)this.6.6()).floatValue()));
                GL11.glVertex2d((double)(d5 - (double)((Double)this.6.6()).floatValue()), (double)d6);
                GL11.glEnd();
                GL11.glPopMatrix();
            }
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GL11.glPushMatrix();
            GL11.glTranslatef((float)n5, (float)n6, (float)0.0f);
            GL11.glRotatef((float)(this.1.6() == 2X.c ? 2Y.c.player.rotationYaw : 180.0f), (float)0.0f, (float)0.0f, (float)1.0f);
            GL11.glTranslatef((float)(-n5), (float)(-n6), (float)0.0f);
            GL11.glBegin((int)9);
            GL11.glVertex2d((double)n5, (double)(n6 + 3));
            GL11.glVertex2d((double)((double)n5 + 1.5), (double)(n6 - 3));
            GL11.glVertex2d((double)((double)n5 - 1.5), (double)(n6 - 3));
            GL11.glEnd();
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glEnable((int)3553);
            for (Object[] objectArray : objectArrayArray = new Object[][]{{"N", -90.0}, {"S", 90.0}, {"E", 0.0}, {"W", 180.0}}) {
                if (objectArray.length < 2) {
                    return;
                }
                if (!(objectArray[0] instanceof String) || !(objectArray[1] instanceof Double)) continue;
                String string = (String)objectArray[0];
                Double d8 = (Double)objectArray[1];
                if (this.1.6() != 2X.c) {
                    d8 = d8 - (double)2Y.c.player.rotationYaw;
                    d8 = d8 - 180.0;
                }
                2Y.c.fontRenderer.drawStringWithShadow(string, (float)((double)n5 + (double)n4 * Math.cos(Math.toRadians(d8))) - (float)(2Y.c.fontRenderer.getStringWidth(string) / 2), (float)((double)n6 + (double)n4 * Math.sin(Math.toRadians(d8))) - (float)(2Y.c.fontRenderer.FONT_HEIGHT / 2), -1);
            }
            GL11.glPopMatrix();
            GL11.glDisable((int)3042);
            GL11.glPopMatrix();
        }
    }

    public 2Y() {
        super("Radar", 2.0f, 100.0f, 100.0f, 100.0f);
        ((89)this.c.6()).0(new Color(31, 31, 31, 170).hashCode());
        ((89)this.0.6()).0(new Color(255, 85, 255, 255).hashCode());
    }

    public boolean c(Object object) {
        if (!(object instanceof Entity)) {
            return false;
        }
        Entity entity = (Entity)object;
        if (entity == 2Y.c.player) {
            return false;
        }
        if (entity.isInvisible() && !((Boolean)this.5.6()).booleanValue()) {
            return false;
        }
        if (object instanceof EntityPlayer) {
            if (((Boolean)this.2.6()).booleanValue()) {
                EntityPlayer entityPlayer = (EntityPlayer)object;
                return true;
            }
        } else if (object instanceof EntityMob) {
            if (((Boolean)this.3.6()).booleanValue()) {
                return true;
            }
        } else if (object instanceof EntityAnimal && ((Boolean)this.4.6()).booleanValue()) {
            return true;
        }
        return false;
    }
}

