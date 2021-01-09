/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.awt.Color;
import java.text.DecimalFormat;
import me.darki.konas.2E;
import me.darki.konas.89;
import me.darki.konas.8A;
import me.darki.konas.8h_0;
import me.darki.konas.9f;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 30
extends 2E {
    public 8h_0<89> 1 = new 8h_0("TextColor", new 89(new Color(255, 85, 255, 255).hashCode(), false));

    public 30() {
        super("TPS", 0.0f, 200.0f, 5.0f, 10.0f);
    }

    @Override
    public void 5() {
        StringBuilder stringBuilder;
        DecimalFormat decimalFormat;
        super.5();
        DecimalFormat decimalFormat2 = decimalFormat;
        DecimalFormat decimalFormat3 = decimalFormat;
        String string = "#.##";
        decimalFormat2(string);
        DecimalFormat decimalFormat4 = decimalFormat3;
        StringBuilder stringBuilder2 = stringBuilder;
        StringBuilder stringBuilder3 = stringBuilder;
        stringBuilder2();
        String string2 = "TPS: ";
        StringBuilder stringBuilder4 = stringBuilder3.append(string2);
        DecimalFormat decimalFormat5 = decimalFormat4;
        8A a2 = 8A.c;
        float f2 = a2.c();
        double d2 = f2;
        String string3 = decimalFormat5.format(d2);
        StringBuilder stringBuilder5 = stringBuilder4.append(string3);
        String string4 = stringBuilder5.toString();
        String string5 = string4;
        float f3 = 5.0f;
        String string6 = string5;
        float f4 = 9f.0(string6);
        float f5 = Math.max(f3, f4);
        float f6 = f5;
        30 v20 = this;
        float f7 = f6 + 1.0f;
        v20.c(f7);
        30 v22 = this;
        String string7 = string5;
        float f8 = 9f.c(string7);
        float f9 = f8 + 1.0f;
        v22.0(f9);
        String string8 = string5;
        30 v27 = this;
        float f10 = v27.9();
        float f11 = (int)f10;
        30 v30 = this;
        float f12 = v30.3();
        float f13 = (int)f12;
        8h_0<89> h_02 = this.1;
        Object t = h_02.6();
        89 v35 = (89)t;
        int n2 = v35.c();
        try {
            9f.0(string8, f11, f13, n2);
        }
        catch (NullPointerException nullPointerException) {
            // empty catch block
        }
    }
}

