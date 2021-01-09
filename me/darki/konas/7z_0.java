/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import com.google.common.io.ByteStreams;
import cookiedragon.eventsystem.Subscriber;
import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Control;
import javax.sound.sampled.FloatControl;
import me.darki.konas.0T;
import me.darki.konas.1a_0;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.7y_0;
import me.darki.konas.89;
import me.darki.konas.8h_0;
import me.darki.konas.90;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraftforge.client.event.MouseEvent;
import org.lwjgl.opengl.GL11;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.7z
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 7z_0
extends 3E {
    public static 8h_0<7y_0> 1 = new 8h_0("Mode", 7y_0.0);
    public static 8h_0<Boolean> 2 = new 8h_0("SFX", false);
    public static 8h_0<Float> 3 = new 8h_0("Volume", Float.valueOf(2.5f), Float.valueOf(5.0f), Float.valueOf(0.0f), Float.valueOf(0.1f)).c(2::6);
    public static 8h_0<Integer> 4 = new 8h_0("Time", 5, 20, 1, 1);
    public static 8h_0<Integer> 5 = new 8h_0("Offset", 5, 20, 1, 1);
    public static 8h_0<Integer> 6 = new 8h_0("Length", 10, 50, 1, 1);
    public static 8h_0<Float> 7 = new 8h_0("Thickness", Float.valueOf(1.0f), Float.valueOf(5.0f), Float.valueOf(0.1f), Float.valueOf(0.1f));
    public static 8h_0<89> 8 = new 8h_0("Color", new 89(-1));
    public int 1 = 0;
    public File c;

    public void 0() {
        FloatControl floatControl;
        Clip clip;
        if (!this.c.exists()) {
            return;
        }
        File file = this.c;
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        AudioInputStream audioInputStream2 = audioInputStream;
        Clip clip2 = AudioSystem.getClip();
        Clip clip3 = clip = clip2;
        AudioInputStream audioInputStream3 = audioInputStream2;
        clip3.open(audioInputStream3);
        Clip clip4 = clip;
        FloatControl.Type type = FloatControl.Type.MASTER_GAIN;
        Control control = clip4.getControl(type);
        FloatControl floatControl2 = floatControl = (FloatControl)control;
        float f2 = -50.0f;
        8h_0<Float> h_02 = 3;
        Object t = h_02.6();
        Float f3 = (Float)t;
        float f4 = f3.floatValue();
        float f5 = f2 + f4 * 10.0f;
        floatControl2.setValue(f5);
        Clip clip5 = clip;
        try {
            clip5.start();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public void 0(int n2, int n3) {
        GL11.glPushMatrix();
        float f2 = n2;
        float f3 = n3;
        float f4 = 0.0f;
        GL11.glTranslatef((float)f2, (float)f3, (float)f4);
        float f5 = 45.0f;
        float f6 = n2;
        float f7 = n3;
        float f8 = 8000.0f;
        GL11.glRotatef((float)f5, (float)f6, (float)f7, (float)f8);
        float f9 = -n2;
        float f10 = -n3;
        float f11 = 0.0f;
        GL11.glTranslatef((float)f9, (float)f10, (float)f11);
        7z_0 z_02 = this;
        int n4 = n2;
        int n5 = n3;
        8h_0<89> h_02 = 8;
        Object t = h_02.6();
        89 v15 = (89)t;
        Color color = v15.4();
        z_02.c(n4, n5, color);
        try {
            GL11.glPopMatrix();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public 7z_0() {
        super("HitMarkers", 3D.2, new String[0]);
        this.c = new File(((Minecraft)7z_0.c).gameDir + File.separator + "Konas" + File.separator + "hitmarker.wav");
        try {
            if (!this.c.exists()) {
                InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("assets/sounds/hitmarker.wav");
                FileOutputStream fileOutputStream = new FileOutputStream(this.c);
                ByteStreams.copy((InputStream)inputStream, (OutputStream)fileOutputStream);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public void c(int n2, int n3, Color color) {
        8h_0<Float> h_02 = 7;
        Object t = h_02.6();
        Float f2 = (Float)t;
        float f3 = f2.floatValue();
        float f4 = f3;
        float f5 = (float)n2 - f4;
        int n4 = n3;
        8h_0<Integer> h_03 = 5;
        Object t2 = h_03.6();
        Integer n5 = (Integer)t2;
        int n6 = n5;
        int n7 = n4 - n6;
        8h_0<Integer> h_04 = 6;
        Object t3 = h_04.6();
        Integer n8 = (Integer)t3;
        int n9 = n8;
        float f6 = n7 - n9;
        float f7 = (float)n2 + f4;
        int n10 = n3;
        8h_0<Integer> h_05 = 5;
        Object t4 = h_05.6();
        Integer n11 = (Integer)t4;
        int n12 = n11;
        float f8 = n10 - n12;
        Color color2 = color;
        boolean bl = true;
        90.c(f5, f6, f7, f8, color2, bl);
        float f9 = (float)n2 - f4;
        int n13 = n3;
        8h_0<Integer> h_06 = 5;
        Object t5 = h_06.6();
        Integer n14 = (Integer)t5;
        int n15 = n14;
        float f10 = n13 + n15;
        float f11 = (float)n2 + f4;
        int n16 = n3;
        8h_0<Integer> h_07 = 5;
        Object t6 = h_07.6();
        Integer n17 = (Integer)t6;
        int n18 = n17;
        int n19 = n16 + n18;
        8h_0<Integer> h_08 = 6;
        Object t7 = h_08.6();
        Integer n20 = (Integer)t7;
        int n21 = n20;
        float f12 = n19 + n21;
        Color color3 = color;
        boolean bl2 = true;
        90.c(f9, f10, f11, f12, color3, bl2);
        int n22 = n2;
        8h_0<Integer> h_09 = 5;
        Object t8 = h_09.6();
        Integer n23 = (Integer)t8;
        int n24 = n23;
        int n25 = n22 - n24;
        8h_0<Integer> h_010 = 6;
        Object t9 = h_010.6();
        Integer n26 = (Integer)t9;
        int n27 = n26;
        float f13 = n25 - n27;
        float f14 = (float)n3 - f4;
        int n28 = n2;
        8h_0<Integer> h_011 = 5;
        Object t10 = h_011.6();
        Integer n29 = (Integer)t10;
        int n30 = n29;
        float f15 = n28 - n30;
        float f16 = (float)n3 + f4;
        Color color4 = color;
        boolean bl3 = true;
        90.c(f13, f14, f15, f16, color4, bl3);
        int n31 = n2;
        8h_0<Integer> h_012 = 5;
        Object t11 = h_012.6();
        Integer n32 = (Integer)t11;
        int n33 = n32;
        float f17 = n31 + n33;
        float f18 = (float)n3 - f4;
        int n34 = n2;
        8h_0<Integer> h_013 = 5;
        Object t12 = h_013.6();
        Integer n35 = (Integer)t12;
        int n36 = n35;
        int n37 = n34 + n36;
        8h_0<Integer> h_014 = 6;
        Object t13 = h_014.6();
        Integer n38 = (Integer)t13;
        int n39 = n38;
        float f19 = n37 + n39;
        float f20 = (float)n3 + f4;
        Color color5 = color;
        boolean bl4 = true;
        try {
            90.c(f17, f18, f19, f20, color5, bl4);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Subscriber
    public void c(0T t) {
        block19: {
            if (((Minecraft)7z_0.c).player == null) {
                return;
            }
            if (1.6() == 7y_0.c) {
                return;
            }
            0T t2 = t;
            Packet packet = t2.c();
            if (!(packet instanceof CPacketUseEntity)) break block19;
            0T t3 = t;
            Packet packet2 = t3.c();
            CPacketUseEntity cPacketUseEntity = (CPacketUseEntity)packet2;
            CPacketUseEntity.Action action = cPacketUseEntity.getAction();
            if (action != CPacketUseEntity.Action.ATTACK) break block19;
            7z_0 z_02 = this;
            8h_0<Integer> h_02 = 4;
            Object t4 = h_02.6();
            Integer n2 = (Integer)t4;
            int n3 = n2;
            z_02.1 = n3;
            8h_0<Boolean> h_03 = 2;
            Object t5 = h_03.6();
            Boolean bl = (Boolean)t5;
            boolean bl2 = bl;
            if (!bl2) break block19;
            7z_0 z_03 = this;
            try {
                z_03.0();
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Subscriber
    public void c(1a_0 a_02) {
        block10: {
            ScaledResolution scaledResolution;
            if (this.1 <= 0) break block10;
            ScaledResolution scaledResolution2 = scaledResolution;
            ScaledResolution scaledResolution3 = scaledResolution;
            File file = c;
            scaledResolution2((Minecraft)file);
            ScaledResolution scaledResolution4 = scaledResolution3;
            7z_0 z_02 = this;
            ScaledResolution scaledResolution5 = scaledResolution4;
            int n2 = scaledResolution5.getScaledWidth();
            int n3 = n2 / 2;
            ScaledResolution scaledResolution6 = scaledResolution4;
            int n4 = scaledResolution6.getScaledHeight();
            int n5 = n4 / 2;
            z_02.0(n3, n5);
            try {
                --this.1;
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    @Subscriber
    public void c(MouseEvent mouseEvent) {
        block15: {
            if (((Minecraft)7z_0.c).player == null) {
                return;
            }
            if (1.6() == 7y_0.0) {
                return;
            }
            MouseEvent mouseEvent2 = mouseEvent;
            int n2 = mouseEvent2.getButton();
            if (!(n2 == 0 & 7z_0.c.objectMouseOver.entityHit != null)) break block15;
            7z_0 z_02 = this;
            8h_0<Integer> h_02 = 4;
            Object t = h_02.6();
            Integer n3 = (Integer)t;
            int n4 = n3;
            z_02.1 = n4;
            8h_0<Boolean> h_03 = 2;
            Object t2 = h_03.6();
            Boolean bl = (Boolean)t2;
            boolean bl2 = bl;
            if (!bl2) break block15;
            7z_0 z_03 = this;
            try {
                z_03.0();
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}

