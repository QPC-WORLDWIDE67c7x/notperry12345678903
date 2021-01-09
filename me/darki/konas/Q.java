/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.text.DecimalFormat;
import java.util.Map;
import me.darki.konas.2;
import me.darki.konas.3F;
import me.darki.konas.4c_0;
import me.darki.konas.8k_0;
import me.darki.konas.8p_0;
import me.darki.konas.9p;
import me.darki.konas.9q;
import me.darki.konas.9r;
import me.darki.konas.command.SyntaxChunk;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class Q
extends 2 {
    public DecimalFormat c = new DecimalFormat("#.##");

    @Override
    public void c(String[] stringArray) {
        4c_0 c_02 = (4c_0)3F.c(4c_0.class);
        if (stringArray.length == 2) {
            if (stringArray[1].equalsIgnoreCase("list")) {
                StringBuilder stringBuilder = new StringBuilder();
                for (9p p2 : 8k_0.c.c.c()) {
                    stringBuilder.append(" ").append(p2.3());
                }
                for (Map.Entry<EntityPlayer, Long> entry : c_02.c().entrySet()) {
                    EntityPlayer entityPlayer = entry.getKey();
                    if (entityPlayer == ((Minecraft)Q.c).player) continue;
                    stringBuilder.append(" ").append(entityPlayer.getName());
                }
                8p_0.1(stringBuilder.toString());
            } else {
                8p_0.c(this.0());
            }
        } else if (stringArray.length == 3) {
            if (stringArray[1].equalsIgnoreCase("get")) {
                for (9p p2 : 8k_0.c.c.c()) {
                    if (!p2.3().equalsIgnoreCase(stringArray[2])) continue;
                    8p_0.1(p2.toString());
                }
                for (Map.Entry entry : c_02.c().entrySet()) {
                    EntityPlayer entityPlayer = (EntityPlayer)entry.getKey();
                    if (entityPlayer == ((Minecraft)Q.c).player || !entityPlayer.getName().equalsIgnoreCase(stringArray[2])) continue;
                    8p_0.1("Waypoint: {name=" + entityPlayer.getName() + ", x=" + entityPlayer.posX + ", y=" + entityPlayer.posY + ", z=" + entityPlayer.posZ + ", dimension =" + Q.c.player.dimension + '}');
                }
            } else if (stringArray[1].equalsIgnoreCase("del")) {
                for (9p p3 : 8k_0.c.c.c()) {
                    if (!p3.3().equalsIgnoreCase(stringArray[2])) continue;
                    8k_0.c.c.0(stringArray[2]);
                    8p_0.1("Deleted Waypoint &b" + stringArray[2]);
                }
                c_02.c().forEach((arg_0, arg_1) -> Q.c(stringArray, c_02, arg_0, arg_1));
            } else if (stringArray[1].equalsIgnoreCase("add")) {
                if (8k_0.c.c.c(stringArray[2]) != null) {
                    8p_0.c("A Waypoint with this name already exists on this server!");
                    return;
                }
                9p p3 = new 9p(stringArray[2], Double.parseDouble(this.c.format(Q.c.player.posX)), Double.parseDouble(this.c.format(Q.c.player.posY)), Double.parseDouble(this.c.format(Q.c.player.posZ)), Q.c.player.dimension, 9r.0);
                8k_0.c.c.c(p3);
                8p_0.1("Added Waypoint " + p3.3() + " at " + p3.4() + ", " + p3.c() + ", " + p3.5());
            } else {
                8p_0.c(this.0());
            }
        } else if (stringArray.length == 6) {
            if (stringArray[1].equalsIgnoreCase("add")) {
                StringBuilder stringBuilder;
                9p p4;
                block77: {
                    9q q = 8k_0.c.c;
                    String string = stringArray[2];
                    9p p5 = q.c(string);
                    if (p5 == null) break block77;
                    String string2 = "A Waypoint with this name already exists on this server!";
                    8p_0.c(string2);
                    return;
                }
                9p p6 = p4;
                9p p7 = p4;
                String string = stringArray[2];
                String string3 = stringArray[3];
                double d2 = Double.parseDouble(string3);
                String string4 = stringArray[4];
                double d3 = Double.parseDouble(string4);
                String string5 = stringArray[5];
                double d4 = Double.parseDouble(string5);
                int n2 = Q.c.player.dimension;
                9r r = 9r.0;
                p6(string, d2, d3, d4, n2, r);
                9p p8 = p7;
                9q q = 8k_0.c.c;
                9p p9 = p8;
                q.c(p9);
                StringBuilder stringBuilder2 = stringBuilder;
                StringBuilder stringBuilder3 = stringBuilder;
                stringBuilder2();
                String string6 = "Added Waypoint ";
                StringBuilder stringBuilder4 = stringBuilder3.append(string6);
                9p p10 = p8;
                String string7 = p10.3();
                StringBuilder stringBuilder5 = stringBuilder4.append(string7);
                String string8 = " at ";
                StringBuilder stringBuilder6 = stringBuilder5.append(string8);
                9p p11 = p8;
                double d5 = p11.4();
                StringBuilder stringBuilder7 = stringBuilder6.append(d5);
                String string9 = ", ";
                StringBuilder stringBuilder8 = stringBuilder7.append(string9);
                9p p12 = p8;
                double d6 = p12.c();
                StringBuilder stringBuilder9 = stringBuilder8.append(d6);
                String string10 = ", ";
                StringBuilder stringBuilder10 = stringBuilder9.append(string10);
                9p p13 = p8;
                double d7 = p13.5();
                StringBuilder stringBuilder11 = stringBuilder10.append(d7);
                String string11 = stringBuilder11.toString();
                try {
                    8p_0.1(string11);
                }
                catch (Exception exception) {
                    8p_0.1("Please provide a valid coordinate value");
                }
            } else {
                8p_0.c(this.0());
            }
        } else {
            8p_0.c(this.0());
        }
    }

    public static void c(String[] stringArray, 4c_0 c_02, EntityPlayer entityPlayer, Long l2) {
        block0: {
            if (!entityPlayer.getName().equalsIgnoreCase(stringArray[2])) break block0;
            c_02.c().remove(entityPlayer);
            8p_0.1("Deleted Waypoint &b" + stringArray[2]);
        }
    }

    public Q() {
        super("waypoint", "Add, delete, and list waypoints", new SyntaxChunk("<add/del/get/list>"), new SyntaxChunk("<name>"), new SyntaxChunk("[x]"), new SyntaxChunk("[y]"), new SyntaxChunk("[z]"));
    }
}

