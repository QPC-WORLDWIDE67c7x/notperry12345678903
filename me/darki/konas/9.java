/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import io.netty.buffer.Unpooled;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import me.darki.konas.2;
import me.darki.konas.8t_0;
import me.darki.konas.T;
import me.darki.konas.command.SyntaxChunk;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.client.CPacketCustomPayload;
import net.minecraft.util.EnumHand;

public class 9
extends 2 {
    public static File c = new File(T.c, "books");

    public String[] c(String string, int n2) {
        String[] stringArray = new String[(int)Math.ceil((double)string.length() / (double)n2)];
        int n3 = 0;
        int n4 = stringArray.length - 1;
        for (int i2 = 0; i2 < n4; ++i2) {
            stringArray[i2] = string.substring(n3, n3 + n2);
            n3 += n2;
        }
        stringArray[n4] = string.substring(n3);
        return stringArray;
    }

    public 9() {
        super("book", "Lets you sign a book with the text in a file", new SyntaxChunk("<file>"));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void c(String[] stringArray) {
        String string;
        BufferedReader bufferedReader;
        File file;
        if (stringArray.length != this.2().size() + 1) {
            8t_0.1(this.0(), new Object[0]);
            return;
        }
        if (!c.exists()) {
            c.mkdir();
        }
        if (!(file = new File(c, stringArray[1].replaceAll(".txt", "") + ".txt")).exists()) {
            8t_0.1("File (h)%s(r) does not exist.", stringArray[1]);
            return;
        }
        String string2 = "";
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            while ((string = bufferedReader.readLine()) != null) {
                string2 = string2.concat(string);
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        if (((Minecraft)9.c).player.getHeldItemMainhand().getItem() != Items.WRITABLE_BOOK) {
            8t_0.1("You need to be holding a book and quill.", new Object[0]);
            return;
        }
        bufferedReader = ((Minecraft)9.c).player.getHeldItemMainhand();
        ((Minecraft)9.c).player.openBook((ItemStack)bufferedReader, EnumHand.MAIN_HAND);
        string = new NBTTagList();
        for (String string3 : this.c(string2, 254)) {
            string.appendTag((NBTBase)new NBTTagString(string3));
        }
        if (bufferedReader.hasTagCompound()) {
            bufferedReader.getTagCompound().setTag("pages", (NBTBase)string);
        } else {
            bufferedReader.setTagInfo("pages", (NBTBase)string);
        }
        bufferedReader.setTagInfo("author", (NBTBase)new NBTTagString(((Minecraft)9.c).player.getName()));
        bufferedReader.setTagInfo("title", (NBTBase)new NBTTagString(stringArray[1].trim()));
        PacketBuffer packetBuffer = new PacketBuffer(Unpooled.buffer());
        packetBuffer.writeItemStack((ItemStack)bufferedReader);
        c.getConnection().sendPacket((Packet)new CPacketCustomPayload("MC|BSign", packetBuffer));
        c.displayGuiScreen(null);
        8t_0.0("Signed book with name (h)%s(r)!", stringArray[1]);
    }
}

