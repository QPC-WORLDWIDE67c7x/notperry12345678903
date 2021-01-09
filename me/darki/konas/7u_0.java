/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import me.darki.konas.1w_0;
import me.darki.konas.2;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.3F;
import me.darki.konas.7t_0;
import me.darki.konas.8J;
import me.darki.konas.8h_0;
import net.minecraft.client.network.NetworkPlayerInfo;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.7u
 */
public class 7u_0
extends 3E {
    public static 8h_0<Integer> 1 = new 8h_0("MaxSize", 200, 400, 10, 10);
    public static 8h_0<7t_0> 2 = new 8h_0("SortMode", 7t_0.c);
    public static 8h_0<Boolean> 3 = new 8h_0("OnlyFriends", false);

    @Subscriber
    public void c(1w_0 w_02) {
        block0: {
            if (!8J.1(w_02.c())) break block0;
            w_02.c(me.darki.konas.2.c + "b" + w_02.c());
        }
    }

    public static boolean 1(NetworkPlayerInfo networkPlayerInfo) {
        return (Boolean)3.6() == false || 8J.2(networkPlayerInfo.getGameProfile().getId().toString());
    }

    public static boolean 0(NetworkPlayerInfo networkPlayerInfo) {
        return (Boolean)3.6() == false || 8J.2(networkPlayerInfo.getGameProfile().getId().toString());
    }

    public 7u_0() {
        super("ExtraTab", 3D.2, "TabPlus", "MoreTab");
    }

    public static Integer c(NetworkPlayerInfo networkPlayerInfo) {
        return networkPlayerInfo.getGameProfile().getName().length();
    }

    public static List<NetworkPlayerInfo> c(List<NetworkPlayerInfo> list, List<NetworkPlayerInfo> list2) {
        if (3F.c(7u_0.class).f()) {
            if (2.6() == 7t_0.c) {
                return list.stream().filter(7u_0::0).limit(((Integer)1.6()).intValue()).collect(Collectors.toList());
            }
            if (2.6() == 7t_0.0) {
                return list.stream().filter(7u_0::2).sorted(Comparator.comparing(NetworkPlayerInfo::func_178853_c)).limit(((Integer)1.6()).intValue()).collect(Collectors.toList());
            }
            return list.stream().filter(7u_0::1).sorted(Comparator.comparing(7u_0::c)).limit(((Integer)1.6()).intValue()).collect(Collectors.toList());
        }
        return list2;
    }

    public static boolean 2(NetworkPlayerInfo networkPlayerInfo) {
        return (Boolean)3.6() == false || 8J.2(networkPlayerInfo.getGameProfile().getId().toString());
    }
}

