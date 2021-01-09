/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 9o {
    public static String c = "trnsl.1.1.20200422T075141Z.abcf23ddfa9d3554.07818759534663d66c01378ce744e8da1ef0a04a";

    public static String 0(String string) throws IOException {
        String string2 = 9o.c("https://translate.yandex.net/api/v1.5/tr.json/detect?key=trnsl.1.1.20200422T075141Z.abcf23ddfa9d3554.07818759534663d66c01378ce744e8da1ef0a04a&text=" + string);
        return string2.substring(string2.indexOf("lang") + 7, string2.length() - 2);
    }

    public static String c(String string, String string2, String string3) throws IOException {
        String string4 = 9o.c("https://translate.yandex.net/api/v1.5/tr.json/translate?key=trnsl.1.1.20200422T075141Z.abcf23ddfa9d3554.07818759534663d66c01378ce744e8da1ef0a04a&text=" + string.replaceAll(" ", "%20") + "&lang=" + string2 + "-" + string3);
        return string4.substring(string4.indexOf("text") + 8, string4.length() - 3);
    }

    public static String 0(Map<String, String> map, String string) {
        for (String string2 : map.keySet()) {
            if (!map.get(string2).equalsIgnoreCase(string)) continue;
            return string2;
        }
        return null;
    }

    public static String c(String string) throws IOException {
        URL uRL = new URL(string);
        URLConnection uRLConnection = uRL.openConnection();
        uRLConnection.addRequestProperty("User-Agent", "Mozilla");
        InputStream inputStream = uRLConnection.getInputStream();
        String string2 = new BufferedReader(new InputStreamReader(inputStream)).readLine();
        inputStream.close();
        return string2;
    }

    public static Map<String, String> c() throws IOException {
        String string = 9o.c("https://translate.yandex.net/api/v1.5/tr.json/getLangs?key=trnsl.1.1.20200422T075141Z.abcf23ddfa9d3554.07818759534663d66c01378ce744e8da1ef0a04a&ui=en");
        string = string.substring(string.indexOf("langs") + 7);
        string = string.substring(0, string.length() - 2);
        String[] stringArray = string.split(",");
        HashMap<String, String> hashMap = new HashMap<String, String>();
        for (String string2 : stringArray) {
            String[] stringArray2 = string2.split(":");
            String string3 = stringArray2[0].substring(1, stringArray2[0].length() - 1);
            String string4 = stringArray2[1].substring(1, stringArray2[1].length() - 1);
            hashMap.put(string3, string4);
        }
        return hashMap;
    }

    public static String c(Map<String, String> map, String string) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String string2 = entry.getKey();
            String string3 = map.get(entry.getKey());
            if (string2.equalsIgnoreCase(string)) {
                return string2;
            }
            if (!string3.equalsIgnoreCase(string)) continue;
            return string2;
        }
        return null;
    }
}

