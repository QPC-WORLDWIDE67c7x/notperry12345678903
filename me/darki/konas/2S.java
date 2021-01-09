/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.awt.Color;
import java.text.DecimalFormat;
import java.util.Comparator;
import me.darki.konas.2E;
import me.darki.konas.89;
import me.darki.konas.8f_0;
import me.darki.konas.8h_0;
import me.darki.konas.9f;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.passive.EntityDonkey;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityParrot;
import net.minecraft.entity.passive.EntityWolf;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 2S
extends 2E {
    public 8h_0<89> 1 = new 8h_0("TextColor", new 89(new Color(255, 85, 255, 255).hashCode(), false));
    public static 8h_0<Boolean> 2 = new 8h_0("Ghasts", true);
    public static 8h_0<Boolean> 3 = new 8h_0("Slimes", true);
    public static 8h_0<Boolean> 4 = new 8h_0("Donkeys", true);
    public static 8h_0<Boolean> 5 = new 8h_0("Llamas", true);
    public static 8h_0<Boolean> 6 = new 8h_0("Cats", true);
    public static 8h_0<Boolean> 7 = new 8h_0("Dogs", true);
    public static 8h_0<Boolean> 8 = new 8h_0("Parrots", true);
    public static 8h_0<8f_0> 9 = new 8h_0("Display", new 8f_0(false));
    public static 8h_0<Boolean> a = new 8h_0("Health", true).c(9);
    public static 8h_0<Boolean> b = new 8h_0("EntityID", true).c(9);
    public static 8h_0<Boolean> d = new 8h_0("Distance", true).c(9);
    public static 8h_0<Boolean> e = new 8h_0("Coordinates", true).c(9);

    public 2S() {
        super("MobRadar", 500.0f, 400.0f, 10.0f, 10.0f);
    }

    @Override
    public void 5() {
        block0: {
            super.5();
            float[] fArray = new float[]{0.0f};
            float[] fArray2 = new float[]{0.0f};
            2S.c.world.loadedEntityList.stream().filter(2S::0).sorted(Comparator.comparing(2S::c)).forEach(arg_0 -> this.c(fArray, fArray2, arg_0));
            this.0(fArray[0]);
            this.c(fArray2[0]);
            if (fArray[0] != 0.0f && fArray2[0] != 0.0f) break block0;
            this.0(50.0f);
            this.c(100.0f);
        }
    }

    public static Float c(Entity entity) {
        return Float.valueOf(2S.c.player.getDistance(entity));
    }

    public void c(float[] fArray, float[] fArray2, Entity entity) {
        9f.0(this.c((EntityLivingBase)entity), this.9(), this.3() + fArray[0], ((89)this.1.6()).c());
        fArray[0] = fArray[0] + 9f.c(this.c((EntityLivingBase)entity));
        if (9f.0(this.c((EntityLivingBase)entity)) > fArray2[0]) {
            fArray2[0] = 9f.0(this.c((EntityLivingBase)entity));
        }
    }

    public String c(EntityLivingBase entityLivingBase) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String string = " (" + (entityLivingBase.getHealth() + entityLivingBase.getAbsorptionAmount()) + ")";
        String string2 = " [" + entityLivingBase.getEntityId() + "]";
        String string3 = " \u00c2\u00a7c" + decimalFormat.format(2S.c.player.getDistance((Entity)entityLivingBase));
        String string4 = " \u00c2\u00a7rXYZ " + entityLivingBase.getPosition().getX() + " " + entityLivingBase.getPosition().getY() + " " + entityLivingBase.getPosition().getZ();
        return entityLivingBase.getName() + ((Boolean)a.6() != false ? string : "") + ((Boolean)b.6() != false ? string2 : "") + ((Boolean)d.6() != false ? string3 : "") + (((Boolean)e.6()).booleanValue() ? string4 : "");
    }

    public static boolean 0(Entity entity) {
        return (Boolean)2.6() != false && entity instanceof EntityGhast || (Boolean)3.6() != false && entity instanceof EntitySlime || (Boolean)4.6() != false && entity instanceof EntityDonkey || (Boolean)5.6() != false && entity instanceof EntityLlama || (Boolean)6.6() != false && entity instanceof EntityOcelot || (Boolean)7.6() != false && entity instanceof EntityWolf || (Boolean)8.6() != false && entity instanceof EntityParrot;
    }
}

