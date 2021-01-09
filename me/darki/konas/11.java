/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.01;
import net.minecraft.entity.MoverType;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 11
extends 01 {
    public static 11 c = new 11();
    public MoverType c;
    public double c;
    public double 0;
    public double 1;

    public static 11 c(MoverType moverType, double d2, double d3, double d4) {
        c.c(false);
        11.c.c = moverType;
        11.c.c = d2;
        11.c.0 = d3;
        11.c.1 = d4;
        return c;
    }

    public double 0() {
        return this.0;
    }

    public void c(double d2) {
        this.1 = d2;
    }

    public double 1() {
        return this.1;
    }

    public double 2() {
        return this.c;
    }

    public void c(MoverType moverType) {
        this.c = moverType;
    }

    public MoverType c() {
        return this.c;
    }

    public void 1(double d2) {
        this.c = d2;
    }

    public void 0(double d2) {
        this.0 = d2;
    }
}

