/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import com.google.common.base.Charsets;
import com.mojang.authlib.Agent;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.exceptions.AuthenticationException;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import com.mojang.authlib.yggdrasil.YggdrasilMinecraftSessionService;
import com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication;
import com.mojang.util.UUIDTypeAdapter;
import java.net.InetAddress;
import java.util.UUID;
import me.darki.konas.29;
import me.darki.konas.8R;
import me.darki.konas.8S;
import me.darki.konas.mixin.mixins.IMinecraft;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Session;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.8w
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 8w_0 {
    public static YggdrasilAuthenticationService c = new YggdrasilAuthenticationService(Minecraft.getMinecraft().getProxy(), UUID.randomUUID().toString());
    public static YggdrasilUserAuthentication c = (YggdrasilUserAuthentication)c.createUserAuthentication(Agent.MINECRAFT);
    public static YggdrasilMinecraftSessionService c = (YggdrasilMinecraftSessionService)c.createMinecraftSessionService();

    public static boolean 1() {
        return Minecraft.getMinecraft().getSession().getProfile().getId().equals(UUID.nameUUIDFromBytes(("OfflinePlayer:" + Minecraft.getMinecraft().getSession().getUsername()).getBytes(Charsets.UTF_8)));
    }

    public static boolean 0(29 var0, String string, String string2) {
        8R r = 8S.c(string, string2);
        if (r == null) {
            return false;
        }
        var0.c(r.1());
        var0.1(r.c());
        var0.0(r.0());
        ((IMinecraft)Minecraft.getMinecraft()).setSession(new Session(r.c(), r.0(), r.1(), "mojang"));
        return true;
    }

    public static boolean c(String string) throws IllegalArgumentException {
        UUID uUID = UUID.nameUUIDFromBytes(("OfflinePlayer:" + string).getBytes(Charsets.UTF_8));
        ((IMinecraft)Minecraft.getMinecraft()).setSession(new Session(string, uUID.toString(), "invalid", "legacy"));
        return true;
    }

    public static boolean 0() {
        return c.getClientToken() != null;
    }

    public static boolean c() {
        Minecraft minecraft;
        try {
            minecraft = Minecraft.getMinecraft();
        }
        catch (Exception exception) {
            return false;
        }
        Session session = minecraft.getSession();
        GameProfile gameProfile = session.getProfile();
        GameProfile gameProfile2 = gameProfile;
        Minecraft minecraft2 = Minecraft.getMinecraft();
        Session session2 = minecraft2.getSession();
        String string = session2.getToken();
        String string2 = string;
        UUID uUID = UUID.randomUUID();
        String string3 = uUID.toString();
        String string4 = string3;
        YggdrasilMinecraftSessionService yggdrasilMinecraftSessionService = c;
        GameProfile gameProfile3 = gameProfile2;
        String string5 = string2;
        String string6 = string4;
        yggdrasilMinecraftSessionService.joinServer(gameProfile3, string5, string6);
        YggdrasilMinecraftSessionService yggdrasilMinecraftSessionService2 = c;
        GameProfile gameProfile4 = gameProfile2;
        String string7 = string4;
        InetAddress inetAddress = null;
        GameProfile gameProfile5 = yggdrasilMinecraftSessionService2.hasJoinedServer(gameProfile4, string7, inetAddress);
        boolean bl = gameProfile5.isComplete();
        if (bl) {
            return true;
        }
        return false;
    }

    public static boolean c(29 var0, String string, String string2) {
        YggdrasilUserAuthentication yggdrasilUserAuthentication;
        c.setUsername(string);
        c.setPassword(string2);
        try {
            yggdrasilUserAuthentication = c;
        }
        catch (AuthenticationException authenticationException) {
            return false;
        }
        yggdrasilUserAuthentication.logIn();
        String string3 = c.getSelectedProfile().getName();
        String string4 = UUIDTypeAdapter.fromUUID((UUID)c.getSelectedProfile().getId());
        String string5 = c.getAuthenticatedToken();
        String string6 = c.getUserType().getName();
        var0.0(string4);
        var0.c(string5);
        var0.1(string3);
        ((IMinecraft)Minecraft.getMinecraft()).setSession(new Session(string3, string4, string5, string6));
        c.logOut();
        return true;
    }
}

