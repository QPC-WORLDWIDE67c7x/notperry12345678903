/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentBase;
import org.jetbrains.annotations.NotNull;

/*
 * Renamed from me.darki.konas.8o
 */
public class 8o_0
extends TextComponentBase {
    public String c;

    public 8o_0(String string) {
        Pattern pattern = Pattern.compile("&[0123456789abcdefrlosmk]");
        Matcher matcher = pattern.matcher(string);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String string2 = "\u00a7" + matcher.group().substring(1);
            matcher.appendReplacement(stringBuffer, string2);
        }
        matcher.appendTail(stringBuffer);
        this.c = stringBuffer.toString();
    }

    @NotNull
    public ITextComponent createCopy() {
        return new 8o_0(this.c);
    }

    @NotNull
    public String getUnformattedComponentText() {
        return this.c;
    }
}

