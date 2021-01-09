/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import com.google.common.collect.Maps;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.AbstractMap;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import kotlin.Pair;
import me.darki.konas.8R;
import me.darki.konas.util.network.Requester;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.util.text.TextFormatting;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 8S {
    public static JsonParser c = new JsonParser();
    public static Map<String, String> c;
    public static AbstractMap.SimpleEntry<Integer, Long> c;
    public static HashMap<String, InputStream> c;
    public static HashMap<String, Boolean> 0;

    public static String 2() {
        Thread thread;
        Thread thread2;
        AtomicReference atomicReference = new AtomicReference();
        Thread thread3 = thread2;
        Thread thread4 = thread2;
        Runnable runnable = () -> 8S.c(atomicReference);
        thread3(runnable);
        Thread thread5 = thread = thread4;
        thread5.start();
        Thread thread6 = thread;
        try {
            thread6.join();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return (String)atomicReference.get();
    }

    public static int 0() {
        block28: {
            AbstractMap.SimpleEntry<Integer, Long> simpleEntry;
            JsonPrimitive jsonPrimitive;
            URL uRL;
            if ((Integer)c.getKey() != 0 && System.currentTimeMillis() - (Long)c.getValue() <= 30000L) {
                return (Integer)c.getKey();
            }
            String string = "https://api.2b2t.dev/prioq";
            URL uRL2 = uRL;
            URL uRL3 = uRL;
            String string2 = "https://api.2b2t.dev/prioq";
            uRL2(string2);
            String string3 = Requester.toString((URL)uRL3);
            String string4 = string3;
            if (string4 == null) break block28;
            String string5 = string4;
            int n2 = string5.length();
            if (n2 <= 0) break block28;
            JsonParser jsonParser = c;
            String string6 = string4;
            JsonElement jsonElement = jsonParser.parse(string6);
            JsonArray jsonArray = (JsonArray)jsonElement;
            if (jsonArray == null) break block28;
            JsonArray jsonArray2 = jsonArray;
            int n3 = 1;
            JsonElement jsonElement2 = jsonArray2.get(n3);
            JsonPrimitive jsonPrimitive2 = jsonElement2.getAsJsonPrimitive();
            JsonPrimitive jsonPrimitive3 = jsonPrimitive = jsonPrimitive2;
            int n4 = jsonPrimitive3.getAsInt();
            int n5 = n4;
            AbstractMap.SimpleEntry<Integer, Long> simpleEntry2 = simpleEntry;
            AbstractMap.SimpleEntry<Integer, Long> simpleEntry3 = simpleEntry;
            int n6 = n5;
            Integer n7 = n6;
            long l2 = System.currentTimeMillis();
            Long l3 = l2;
            simpleEntry2(n7, l3);
            try {
                c = simpleEntry3;
                return n5;
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
        return 0;
    }

    public static HashMap<String, String> 3() {
        Thread thread;
        Thread thread2;
        HashMap<String, String> hashMap = new HashMap<String, String>();
        Thread thread3 = thread2;
        Thread thread4 = thread2;
        Runnable runnable = () -> 8S.c(hashMap);
        thread3(runnable);
        Thread thread5 = thread = thread4;
        thread5.start();
        Thread thread6 = thread;
        try {
            thread6.join();
        }
        catch (Exception exception) {
            System.err.println("Error fetching capes");
        }
        return hashMap;
    }

    public static InputStream 3(String string) {
        URL uRL;
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2;
        URL uRL2;
        URL uRL3;
        if (c.containsKey(string)) {
            return (InputStream)c.get(string);
        }
        try {
            StringBuilder stringBuilder3;
            URL uRL4;
            uRL3 = uRL4;
            uRL2 = uRL4;
            stringBuilder2 = stringBuilder3;
            stringBuilder = stringBuilder3;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return null;
        }
        stringBuilder2();
        String string2 = "https://crafatar.com/skins/";
        StringBuilder stringBuilder4 = stringBuilder.append(string2);
        String string3 = string;
        String string4 = "-";
        String string5 = "";
        String string6 = string3.replaceAll(string4, string5);
        StringBuilder stringBuilder5 = stringBuilder4.append(string6);
        String string7 = "?default=MHF_Steve";
        StringBuilder stringBuilder6 = stringBuilder5.append(string7);
        String string8 = stringBuilder6.toString();
        uRL3(string8);
        URL uRL5 = uRL = uRL2;
        InputStream inputStream = uRL5.openStream();
        InputStream inputStream2 = inputStream;
        JsonParser jsonParser = c;
        String string9 = string;
        InputStream inputStream3 = inputStream2;
        jsonParser.put(string9, inputStream3);
        return inputStream2;
    }

    /*
     * Unable to fully structure code
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String[] 1() {
        var0 = new String[3];
        var1_1 = "https://status.mojang.com/check";
        v0 = v1;
        v2 = v1;
        v3 = "https://status.mojang.com/check";
        v0(v3);
        v4 = Requester.toString((URL)v2);
        var2_2 = v4;
        if (var2_2 == null) return var0;
        v5 = var2_2;
        v6 = v5.length();
        if (v6 <= 0) return var0;
        v7 = 8S.c;
        v8 = var2_2;
        v9 = v7.parse(v8);
        v10 = var3_4 = (JsonArray)v9;
        v11 = v10.iterator();
        try {
            var4_5 = v11;
            while (true) {
                v12 = var4_5;
                break;
            }
        }
        catch (IOException var2_3) {
            var2_3.printStackTrace();
            return var0;
        }
        {
            v13 = v12.hasNext();
            if (!v13) return var0;
            v14 = var4_5;
            v15 = v14.next();
            v16 = var5_6 = (JsonElement)v15;
            v17 = v16.getAsJsonObject();
            v18 = var6_7 = v17;
            v19 = "account.mojang.com";
            v20 = v18.get(v19);
            if (v20 == null) ** GOTO lbl66
            v21 = var0;
            v22 = 0;
            v23 = var6_7;
            v24 = "account.mojang.com";
            v25 = v23.get(v24);
            v26 = v25.getAsString();
            v21[v22] = v26;
lbl66:
            // 2 sources

            v27 = var6_7;
            v28 = "authserver.mojang.com";
            v29 = v27.get(v28);
            if (v29 == null) ** GOTO lbl84
            v30 = var0;
            v31 = 1;
            v32 = var6_7;
            v33 = "authserver.mojang.com";
            v34 = v32.get(v33);
            v35 = v34.getAsString();
            v30[v31] = v35;
lbl84:
            // 2 sources

            v36 = var6_7;
            v37 = "sessionserver.mojang.com";
            v38 = v36.get(v37);
            if (v38 == null) continue;
            v39 = var0;
            v40 = 2;
            v41 = var6_7;
            v42 = "sessionserver.mojang.com";
            v43 = v41.get(v42);
            v44 = v43.getAsString();
            v39[v40] = v44;
            continue;
        }
    }

    public void c() {
        c.clear();
    }

    public static void c(HashMap hashMap, JsonElement jsonElement) {
        hashMap.put(jsonElement.getAsJsonObject().getAsJsonPrimitive("Name").getAsString().toUpperCase(), jsonElement.getAsJsonObject().getAsJsonPrimitive("Type").getAsString());
    }

    public static void c(HashMap hashMap) {
        AbstractMap.SimpleEntry<String, String> simpleEntry;
        URL uRL;
        JsonParser jsonParser;
        JsonParser jsonParser2 = jsonParser;
        JsonParser jsonParser3 = jsonParser;
        jsonParser2();
        URL uRL2 = uRL;
        URL uRL3 = uRL;
        String string = "https://capes.konasclient.com";
        uRL2(string);
        AbstractMap.SimpleEntry[] simpleEntryArray = new AbstractMap.SimpleEntry[1];
        AbstractMap.SimpleEntry[] simpleEntryArray2 = simpleEntryArray;
        AbstractMap.SimpleEntry[] simpleEntryArray3 = simpleEntryArray;
        int n2 = 0;
        AbstractMap.SimpleEntry<String, String> simpleEntry2 = simpleEntry;
        AbstractMap.SimpleEntry<String, String> simpleEntry3 = simpleEntry;
        String string2 = "KONAS";
        String string3 = 8S.2();
        simpleEntry2(string2, string3);
        simpleEntryArray2[n2] = simpleEntry3;
        String string4 = Requester.toStringWithHeader((URL)uRL3, (AbstractMap.SimpleEntry[])simpleEntryArray3);
        JsonElement jsonElement = jsonParser3.parse(string4);
        JsonArray jsonArray = jsonElement.getAsJsonArray();
        Consumer<JsonElement> consumer = arg_0 -> 8S.c(hashMap, arg_0);
        try {
            jsonArray.forEach(consumer);
        }
        catch (IOException iOException) {
            System.err.println("Error fetching capes");
        }
    }

    public static InputStream 2(String string) {
        URL uRL;
        StringBuilder stringBuilder;
        URL uRL2;
        InputStream inputStream = null;
        URL uRL3 = uRL2;
        URL uRL4 = uRL2;
        StringBuilder stringBuilder2 = stringBuilder;
        StringBuilder stringBuilder3 = stringBuilder;
        stringBuilder2();
        String string2 = "https://crafatar.com/avatars/";
        StringBuilder stringBuilder4 = stringBuilder3.append(string2);
        String string3 = string;
        String string4 = "-";
        String string5 = "";
        String string6 = string3.replaceAll(string4, string5);
        StringBuilder stringBuilder5 = stringBuilder4.append(string6);
        String string7 = "?size=64&default=MHF_Steve&overlay";
        StringBuilder stringBuilder6 = stringBuilder5.append(string7);
        String string8 = stringBuilder6.toString();
        uRL3(string8);
        URL uRL5 = uRL = uRL4;
        InputStream inputStream2 = uRL5.openStream();
        try {
            inputStream = inputStream2;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        return inputStream;
    }

    public static String 4(String string) {
        String string2 = string.replaceAll(String.valueOf(Pattern.compile("[^a-zA-Z0-9_]{1,16}")), "");
        if (c.containsValue(string2)) {
            return (String)c.get(string2);
        }
        String[] stringArray = new String[]{null};
        CountDownLatch countDownLatch = new CountDownLatch(1);
        String string3 = string2;
        new Thread(() -> 8S.c(string3, stringArray, countDownLatch)).start();
        CountDownLatch countDownLatch2 = countDownLatch;
        try {
            countDownLatch2.await();
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        return stringArray[0];
    }

    /*
     * Unable to fully structure code
     */
    public static void c(String var0, String[] var1_1, CountDownLatch var2_2) {
        block19: {
            var3_3 = "https://api.mojang.com/users/profiles/minecraft/" + var0;
            v0 = v1;
            v2 = v1;
            v3 = var3_3;
            v0(v3);
            v4 = Requester.toString((URL)v2);
            var4_4 = v4;
            if (var4_4 == null) ** GOTO lbl44
            v5 = var4_4;
            v6 = v5.length();
            if (v6 <= 0) ** GOTO lbl44
            v7 = 8S.c;
            v8 = var4_4;
            v9 = v7.parse(v8);
            var5_6 = (JsonObject)v9;
            v10 = var1_1;
            v11 = 0;
            v12 = var5_6;
            v13 = "id";
            v14 = v12.get(v13);
            v15 = v14.getAsString();
            v10[v11] = v15;
            v16 = 8S.c;
            v17 = var0;
            v18 = var1_1[0];
            v16.put(v17, v18);
            break block19;
lbl44:
            // 2 sources

            var1_1[0] = null;
        }
        v19 = var2_2;
        try {
            v19.countDown();
        }
        catch (IOException var4_5) {
            var4_5.printStackTrace();
        }
    }

    public static String c(String string) {
        block26: {
            URL uRL;
            String string2 = string.replace("-", "");
            if (c.containsKey(string2)) {
                return (String)c.get(string2);
            }
            String string3 = "https://api.mojang.com/user/profiles/" + string2 + "/names";
            URL uRL2 = uRL;
            URL uRL3 = uRL;
            String string4 = string3;
            uRL2(string4);
            String string5 = Requester.toString((URL)uRL3);
            Object object4 = string5;
            if (object4 == null) break block26;
            Object object2 = object4;
            int n2 = ((String)object2).length();
            if (n2 <= 0) break block26;
            JsonParser jsonParser = c;
            Object object3 = object4;
            JsonElement jsonElement = jsonParser.parse((String)object3);
            JsonArray jsonArray = (JsonArray)jsonElement;
            if (jsonArray == null) break block26;
            JsonArray jsonArray2 = jsonArray;
            JsonArray jsonArray3 = jsonArray;
            int n3 = jsonArray3.size();
            int n4 = n3 - 1;
            JsonElement jsonElement2 = jsonArray2.get(n4);
            JsonObject jsonObject = (JsonObject)jsonElement2;
            if (jsonObject == null) break block26;
            JsonObject jsonObject2 = jsonObject;
            String string6 = "name";
            JsonElement jsonElement3 = jsonObject2.get(string6);
            String string7 = jsonElement3.toString();
            String string8 = string7;
            JsonParser jsonParser2 = c;
            String string9 = string8;
            String string10 = string2;
            jsonParser2.put(string9, string10);
            String string11 = string8;
            int n5 = 1;
            String string12 = string8;
            int n6 = string12.length();
            int n7 = n6 - 1;
            try {
                return string11.substring(n5, n7);
            }
            catch (IOException object4) {
                ((Throwable)object4).printStackTrace();
            }
        }
        return null;
    }

    public static Pair<String, TextFormatting> 5(String string) {
        TextFormatting textFormatting;
        String string2;
        if (string == null) {
            return new Pair((Object)"Error", (Object)TextFormatting.RED);
        }
        switch (string) {
            case "green": {
                string2 = "Good";
                textFormatting = TextFormatting.GREEN;
                break;
            }
            case "yellow": {
                string2 = "Ok";
                textFormatting = TextFormatting.YELLOW;
                break;
            }
            default: {
                string2 = "Offline";
                textFormatting = TextFormatting.RED;
            }
        }
        return new Pair((Object)string2, (Object)textFormatting);
    }

    public static DynamicTexture 1(String string) {
        DynamicTexture dynamicTexture;
        URL uRL;
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2;
        URL uRL2;
        URL uRL3;
        try {
            StringBuilder stringBuilder3;
            URL uRL4;
            uRL3 = uRL4;
            uRL2 = uRL4;
            stringBuilder2 = stringBuilder3;
            stringBuilder = stringBuilder3;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return null;
        }
        stringBuilder2();
        String string2 = "https://capes.konasclient.com/capes/";
        StringBuilder stringBuilder4 = stringBuilder.append(string2);
        String string3 = string;
        StringBuilder stringBuilder5 = stringBuilder4.append(string3);
        String string4 = ".png";
        StringBuilder stringBuilder6 = stringBuilder5.append(string4);
        String string5 = stringBuilder6.toString();
        uRL3(string5);
        URL uRL5 = uRL = uRL2;
        InputStream inputStream = Requester.toInputStream((URL)uRL5);
        InputStream inputStream2 = inputStream;
        DynamicTexture dynamicTexture2 = dynamicTexture;
        DynamicTexture dynamicTexture3 = dynamicTexture;
        InputStream inputStream3 = inputStream2;
        BufferedImage bufferedImage = ImageIO.read(inputStream3);
        dynamicTexture2(bufferedImage);
        return dynamicTexture3;
    }

    public static AbstractMap.SimpleEntry<String, String> 6(String string) {
        AbstractMap.SimpleEntry<String, String> simpleEntry;
        JsonParser jsonParser;
        StringBuilder stringBuilder;
        AbstractMap.SimpleEntry<String, String> simpleEntry2;
        URL uRL;
        URL uRL2;
        URL uRL3;
        try {
            URL uRL4;
            uRL3 = uRL4;
            uRL2 = uRL4;
        }
        catch (Exception exception) {
            return null;
        }
        String string2 = "https://api.minecraftservices.com/minecraft/profile";
        uRL3(string2);
        URL uRL5 = uRL = uRL2;
        AbstractMap.SimpleEntry[] simpleEntryArray = new AbstractMap.SimpleEntry[1];
        AbstractMap.SimpleEntry[] simpleEntryArray2 = simpleEntryArray;
        AbstractMap.SimpleEntry[] simpleEntryArray3 = simpleEntryArray;
        int n2 = 0;
        AbstractMap.SimpleEntry<String, String> simpleEntry3 = simpleEntry2;
        AbstractMap.SimpleEntry<String, String> simpleEntry4 = simpleEntry2;
        String string3 = "Authorization";
        StringBuilder stringBuilder2 = stringBuilder;
        StringBuilder stringBuilder3 = stringBuilder;
        stringBuilder2();
        String string4 = "Bearer ";
        StringBuilder stringBuilder4 = stringBuilder3.append(string4);
        String string5 = string;
        StringBuilder stringBuilder5 = stringBuilder4.append(string5);
        String string6 = stringBuilder5.toString();
        simpleEntry3(string3, string6);
        simpleEntryArray2[n2] = simpleEntry4;
        String string7 = Requester.toStringWithHeader((URL)uRL5, (AbstractMap.SimpleEntry[])simpleEntryArray3);
        String string8 = string7;
        JsonParser jsonParser2 = jsonParser;
        JsonParser jsonParser3 = jsonParser;
        jsonParser2();
        String string9 = string8;
        JsonElement jsonElement = jsonParser3.parse(string9);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        JsonObject jsonObject2 = jsonObject;
        AbstractMap.SimpleEntry<String, String> simpleEntry5 = simpleEntry;
        AbstractMap.SimpleEntry<String, String> simpleEntry6 = simpleEntry;
        JsonObject jsonObject3 = jsonObject2;
        String string10 = "name";
        JsonPrimitive jsonPrimitive = jsonObject3.getAsJsonPrimitive(string10);
        String string11 = jsonPrimitive.getAsString();
        JsonObject jsonObject4 = jsonObject2;
        String string12 = "id";
        JsonPrimitive jsonPrimitive2 = jsonObject4.getAsJsonPrimitive(string12);
        String string13 = jsonPrimitive2.getAsString();
        simpleEntry5(string11, string13);
        return simpleEntry6;
    }

    public static void c(AtomicReference atomicReference) {
        AbstractMap.SimpleEntry<String, String> simpleEntry;
        URL uRL;
        JsonParser jsonParser;
        AtomicReference atomicReference2 = atomicReference;
        JsonParser jsonParser2 = jsonParser;
        JsonParser jsonParser3 = jsonParser;
        jsonParser2();
        URL uRL2 = uRL;
        URL uRL3 = uRL;
        String string = "https://truth.konasclient.com";
        uRL2(string);
        AbstractMap.SimpleEntry[] simpleEntryArray = new AbstractMap.SimpleEntry[1];
        AbstractMap.SimpleEntry[] simpleEntryArray2 = simpleEntryArray;
        AbstractMap.SimpleEntry[] simpleEntryArray3 = simpleEntryArray;
        int n2 = 0;
        AbstractMap.SimpleEntry<String, String> simpleEntry2 = simpleEntry;
        AbstractMap.SimpleEntry<String, String> simpleEntry3 = simpleEntry;
        String string2 = "KONAS";
        String string3 = "0c5c77308be49e7cc4f86d2aff08e7cd9c3e1cf6195761c1b27ae472decc1d23bd4a518339a91c04";
        simpleEntry2(string2, string3);
        simpleEntryArray2[n2] = simpleEntry3;
        String string4 = Requester.toStringWithHeader((URL)uRL3, (AbstractMap.SimpleEntry[])simpleEntryArray3);
        JsonElement jsonElement = jsonParser3.parse(string4);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        String string5 = "key";
        JsonPrimitive jsonPrimitive = jsonObject.getAsJsonPrimitive(string5);
        String string6 = jsonPrimitive.getAsString();
        try {
            atomicReference2.set(string6);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    static {
        c = Maps.newConcurrentMap();
        c = new AbstractMap.SimpleEntry<Integer, Long>(0, System.currentTimeMillis());
        c = new HashMap();
        0 = new HashMap();
    }

    public static 8R c(String string, String string2) {
        8R r;
        JsonParser jsonParser;
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2;
        URL uRL;
        URL uRL2;
        try {
            StringBuilder stringBuilder3;
            URL uRL3;
            uRL2 = uRL3;
            uRL = uRL3;
            stringBuilder2 = stringBuilder3;
            stringBuilder = stringBuilder3;
        }
        catch (IOException iOException) {
            System.err.println("Microsoft returned invalid credentials");
            return null;
        }
        stringBuilder2();
        String string3 = "https://konasclient.com/billgates?username=";
        StringBuilder stringBuilder4 = stringBuilder.append(string3);
        String string4 = string;
        StringBuilder stringBuilder5 = stringBuilder4.append(string4);
        String string5 = "&password=";
        StringBuilder stringBuilder6 = stringBuilder5.append(string5);
        String string6 = string2;
        StringBuilder stringBuilder7 = stringBuilder6.append(string6);
        String string7 = stringBuilder7.toString();
        uRL2(string7);
        URL uRL4 = uRL;
        JsonParser jsonParser2 = jsonParser;
        JsonParser jsonParser3 = jsonParser;
        jsonParser2();
        URL uRL5 = uRL4;
        String string8 = Requester.toString((URL)uRL5);
        JsonElement jsonElement = jsonParser3.parse(string8);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        JsonObject jsonObject2 = jsonObject;
        8R r2 = r;
        8R r3 = r;
        JsonObject jsonObject3 = jsonObject2;
        String string9 = "token";
        JsonElement jsonElement2 = jsonObject3.get(string9);
        String string10 = jsonElement2.getAsString();
        JsonObject jsonObject4 = jsonObject2;
        String string11 = "name";
        JsonElement jsonElement3 = jsonObject4.get(string11);
        String string12 = jsonElement3.getAsString();
        JsonObject jsonObject5 = jsonObject2;
        String string13 = "uuid";
        JsonElement jsonElement4 = jsonObject5.get(string13);
        String string14 = jsonElement4.getAsString();
        r2(string10, string12, string14);
        return r3;
    }

    /*
     * Unable to fully structure code
     */
    public static boolean 0(String var0) {
        block65: {
            if (8S.0.containsKey(var0)) {
                return 8S.0.get(var0);
            }
            try {
                v0 = v1;
                v2 = v1;
                v3 = v4;
                v5 = v4;
            }
            catch (Exception var1_2) {
                var1_2.printStackTrace();
                8S.0.put(var0, false);
                return false;
            }
            v3();
            v6 = "https://sessionserver.mojang.com/session/minecraft/profile/";
            v7 = v5.append(v6);
            v8 = var0;
            v9 = v7.append(v8);
            v10 = v9.toString();
            v0(v10);
            v11 = Requester.toString((URL)v2);
            var1_1 = v11;
            v12 = v13;
            v14 = v13;
            v12();
            var2_3 = v14;
            if (var1_1 == null) break block65;
            v15 = var1_1;
            v16 = v15.length();
            if (v16 <= 0) break block65;
            v17 = var2_3;
            v18 = var1_1;
            v19 = v17.parse(v18);
            v20 = var3_4 = (JsonObject)v19;
            v21 = "properties";
            v22 = v20.getAsJsonArray(v21);
            v23 = var4_5 = v22;
            v24 = 0;
            v25 = v23.get(v24);
            v26 = v25.getAsJsonObject();
            v27 = "value";
            v28 = v26.getAsJsonPrimitive(v27);
            v29 = v28.getAsString();
            var5_6 = v29;
            v30 = v31;
            v32 = v31;
            v33 = Base64.getDecoder();
            v34 = var5_6;
            v35 = v33.decode(v34);
            v30(v35);
            var6_7 = v32;
            v36 = var2_3;
            v37 = var6_7;
            v38 = v36.parse(v37);
            v39 = var7_8 = (JsonObject)v38;
            v40 = "textures";
            v41 = v39.getAsJsonObject(v40);
            v42 = "SKIN";
            v43 = v41.getAsJsonObject(v42);
            v44 = var8_9 = v43;
            v45 = "metadata";
            v46 = v44.getAsJsonObject(v45);
            if (v46 == null) ** GOTO lbl113
            v47 = 8S.0;
            v48 = var0;
            v49 = true;
            v50 = v49;
            v47.put(v48, v50);
            return true;
lbl113:
            // 1 sources

            v51 = 8S.0;
            v52 = var0;
            v53 = false;
            v54 = v53;
            v51.put(v52, v54);
            return false;
        }
        8S.0.put(var0, false);
        return false;
    }
}

