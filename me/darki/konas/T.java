/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.invoke.LambdaMetafactory;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import me.darki.konas.2;
import me.darki.konas.29;
import me.darki.konas.2A;
import me.darki.konas.2C;
import me.darki.konas.2D;
import me.darki.konas.2E;
import me.darki.konas.2F;
import me.darki.konas.2g_0;
import me.darki.konas.2q_0;
import me.darki.konas.2r_0;
import me.darki.konas.2s_0;
import me.darki.konas.2u_0;
import me.darki.konas.2z_0;
import me.darki.konas.3B;
import me.darki.konas.3C;
import me.darki.konas.3E;
import me.darki.konas.3F;
import me.darki.konas.3I;
import me.darki.konas.68;
import me.darki.konas.88;
import me.darki.konas.89;
import me.darki.konas.8H;
import me.darki.konas.8J;
import me.darki.konas.8Q;
import me.darki.konas.8d_0;
import me.darki.konas.8f_0;
import me.darki.konas.8h_0;
import me.darki.konas.8i_0;
import me.darki.konas.8j_0;
import me.darki.konas.8k_0;
import me.darki.konas.9p;
import me.darki.konas.9r;
import me.darki.konas.KonasMod;
import me.darki.konas.i_0;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.GameSettings;
import org.lwjgl.input.Keyboard;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class T {
    public static Minecraft c = Minecraft.getMinecraft();
    public static File c = new File(T.c.gameDir, "Konas");
    public static File 0 = new File(c, "config.json");
    public static File 1 = new File(c, "configs");
    public static File 2 = new File(c, "accounts.json");
    public static File 3 = null;
    @Deprecated
    public static File 4 = new File(T.c.gameDir + File.separator + "KonasConfig.json");
    @Deprecated
    public static File 5 = new File(T.c.gameDir + File.separator + "accounts.json");

    public static JsonArray 6() {
        JsonArray jsonArray = new JsonArray();
        for (3E e2 : 3F.2()) {
            jsonArray.add((JsonElement)T.c(e2));
        }
        return jsonArray;
    }

    public static JsonArray 9() {
        JsonArray jsonArray = new JsonArray();
        for (2C c2 : 8k_0.c.c.3()) {
            if (c2 instanceof 2A) continue;
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("X", (Number)Float.valueOf(c2.5()));
            jsonObject.addProperty("Y", (Number)Float.valueOf(c2.6()));
            jsonObject.addProperty("Extended", Boolean.valueOf(c2.c()));
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.add(c2.8(), (JsonElement)jsonObject);
            jsonArray.add((JsonElement)jsonObject2);
        }
        return jsonArray;
    }

    public static void 0(File file) {
        Gson gson;
        JsonObject jsonObject;
        JsonObject jsonObject2;
        JsonObject jsonObject3;
        JsonObject jsonObject4;
        JsonObject jsonObject5;
        JsonObject jsonObject6;
        JsonArray jsonArray;
        if (!file.exists()) {
            file.createNewFile();
        }
        JsonArray jsonArray2 = jsonArray;
        JsonArray jsonArray3 = jsonArray;
        jsonArray2();
        JsonArray jsonArray4 = jsonArray3;
        JsonObject jsonObject7 = jsonObject6 = new JsonObject();
        jsonObject7.add("Modules", (JsonElement)T.6());
        JsonArray jsonArray5 = jsonArray4;
        JsonObject jsonObject8 = jsonObject6;
        jsonArray5.add((JsonElement)jsonObject8);
        JsonObject jsonObject9 = jsonObject5 = new JsonObject();
        String string = "Containers";
        JsonArray jsonArray6 = T.e();
        jsonObject9.add(string, (JsonElement)jsonArray6);
        jsonArray4.add((JsonElement)jsonObject5);
        JsonObject jsonObject10 = jsonObject4;
        JsonObject jsonObject11 = jsonObject4;
        jsonObject10();
        JsonObject jsonObject12 = jsonObject11;
        jsonObject12.add("Panels", (JsonElement)T.9());
        JsonArray jsonArray7 = jsonArray4;
        JsonObject jsonObject13 = jsonObject12;
        jsonArray7.add((JsonElement)jsonObject13);
        JsonObject jsonObject14 = new JsonObject();
        jsonObject14.add("Friends", (JsonElement)T.5());
        jsonArray4.add((JsonElement)jsonObject14);
        JsonObject jsonObject15 = jsonObject3 = new JsonObject();
        String string2 = "Prefix";
        String string3 = me.darki.konas.2.1();
        jsonObject15.addProperty(string2, string3);
        jsonArray4.add((JsonElement)jsonObject3);
        JsonObject jsonObject16 = jsonObject2;
        JsonObject jsonObject17 = jsonObject2;
        jsonObject16();
        JsonObject jsonObject18 = jsonObject17;
        jsonObject18.addProperty("Language", 68.2);
        jsonArray4.add((JsonElement)jsonObject18);
        JsonObject jsonObject19 = new JsonObject();
        jsonObject19.add("Macros", (JsonElement)T.2());
        jsonArray4.add((JsonElement)jsonObject19);
        JsonObject jsonObject20 = jsonObject = new JsonObject();
        jsonObject20.add("Waypoints", (JsonElement)T.f());
        jsonArray4.add((JsonElement)jsonObject);
        JsonArray jsonArray8 = jsonArray4;
        String string4 = i_0.2;
        jsonArray8.add(string4);
        JsonObject jsonObject21 = new JsonObject();
        jsonObject21.add("Muted", (JsonElement)T.d());
        jsonArray4.add((JsonElement)jsonObject21);
        JsonObject jsonObject22 = new JsonObject();
        jsonObject22.addProperty("Watermark", KonasMod.WATERMARK);
        jsonArray4.add((JsonElement)jsonObject22);
        FileWriter fileWriter = new FileWriter(file);
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson2 = gson = gsonBuilder.setPrettyPrinting().create();
        JsonArray jsonArray9 = jsonArray4;
        FileWriter fileWriter2 = fileWriter;
        try {
            gson2.toJson((JsonElement)jsonArray9, (Appendable)fileWriter2);
            fileWriter.close();
        }
        catch (IOException iOException) {
            System.err.println("Cant write to config file!");
        }
        T.1();
    }

    public static List<File> c() {
        if (!c.exists() || c.listFiles() == null) {
            return null;
        }
        if (1.listFiles() != null) {
            return Arrays.stream(1.listFiles()).filter(T::3).collect(Collectors.toList());
        }
        return null;
    }

    /*
     * Exception decompiling
     */
    public static void b() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[TRYBLOCK]], but top level block is 9[WHILELOOP]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public static void c(JsonElement jsonElement) {
        try {
            T.1(jsonElement.getAsJsonObject());
        }
        catch (NullPointerException nullPointerException) {
            System.err.println(nullPointerException.getMessage());
        }
    }

    public static File 0() {
        if (!c.exists() || c.listFiles() == null) {
            c.mkdir();
            return 0;
        }
        if (1.listFiles() != null) {
            List list = Arrays.stream(1.listFiles()).filter(T::5).collect(Collectors.toList());
            list.add(0);
            return list.stream().max(Comparator.comparingLong(File::lastModified)).orElse(0);
        }
        return 0;
    }

    public static void c(2r_0 r_02) {
        block0: {
            if (!(r_02 instanceof 2q_0)) break block0;
            ((2q_0)r_02).0();
        }
    }

    public static void 5(JsonObject jsonObject) {
        block0: {
            if (jsonObject.get("Name") == null || jsonObject.get("UUID") == null) break block0;
            8J.c(jsonObject.get("Name").getAsString(), jsonObject.get("UUID").getAsString());
        }
    }

    public static JsonObject c(3E e2) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("Bind", GameSettings.getKeyDisplayString((int)e2.6()));
        jsonObject.addProperty("Enabled", Boolean.valueOf(e2.f()));
        jsonObject.addProperty("Visible", Boolean.valueOf(e2.a()));
        if (3F.1(e2) != null) {
            for (8h_0 h_02 : 3F.1(e2)) {
                JsonArray jsonArray;
                if (h_02.6() instanceof Number) {
                    jsonObject.addProperty(h_02.c(), (Number)h_02.6());
                    continue;
                }
                if (h_02.6() instanceof Boolean) {
                    jsonObject.addProperty(h_02.c(), (Boolean)h_02.6());
                    continue;
                }
                if (h_02.6() instanceof 8f_0) {
                    jsonObject.addProperty(h_02.c(), Boolean.valueOf(((8f_0)h_02.6()).c()));
                    continue;
                }
                if (h_02.6() instanceof 8j_0) {
                    jsonObject.addProperty(h_02.c(), (Number)((8j_0)h_02.6()).c());
                    continue;
                }
                if (h_02.6() instanceof Enum || h_02.6() instanceof String) {
                    jsonObject.addProperty(h_02.c(), String.valueOf(h_02.6()));
                    continue;
                }
                if (h_02.6() instanceof 89) {
                    jsonArray = new JsonArray();
                    jsonArray.add((Number)((89)h_02.6()).0());
                    jsonArray.add(Boolean.valueOf(((89)h_02.6()).7()));
                    jsonArray.add((Number)((89)h_02.6()).8());
                    jsonObject.add(h_02.c(), (JsonElement)jsonArray);
                    continue;
                }
                if (h_02.6() instanceof 88) {
                    jsonArray = new JsonArray();
                    for (String string : ((88)h_02.6()).c()) {
                        jsonArray.add(string);
                    }
                    jsonObject.add(h_02.c(), (JsonElement)jsonArray);
                    continue;
                }
                if (h_02.6() instanceof 8d_0) {
                    jsonArray = new JsonArray();
                    for (String string : ((8d_0)h_02.6()).c()) {
                        jsonArray.add(string);
                    }
                    jsonObject.add(h_02.c(), (JsonElement)jsonArray);
                    continue;
                }
                if (!(h_02.6() instanceof 8i_0)) continue;
                jsonArray = new JsonArray();
                for (String string : ((8i_0)h_02.6()).c()) {
                    jsonArray.add(string);
                }
                jsonObject.add(h_02.c(), (JsonElement)jsonArray);
            }
        }
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.add(e2.b(), (JsonElement)jsonObject);
        return jsonObject2;
    }

    public static void 2(JsonElement jsonElement) {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        try {
            T.6(jsonObject);
        }
        catch (NullPointerException nullPointerException) {
            System.err.println(nullPointerException.getMessage());
        }
    }

    public static JsonObject c(8H h2) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("Name", h2.0());
        jsonObject.addProperty("UUID", h2.c());
        return jsonObject;
    }

    public static void 5(JsonElement jsonElement) {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        try {
            T.8(jsonObject);
        }
        catch (NullPointerException nullPointerException) {
            System.err.println(nullPointerException.getMessage());
        }
    }

    /*
     * Exception decompiling
     */
    public static void 8() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [6[TRYBLOCK]], but top level block is 17[UNCONDITIONALDOLOOP]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public static void 7(JsonObject jsonObject) {
        9r r = null;
        for (9r r2 : (9r[])9r.class.getEnumConstants()) {
            if (!r2.name().equalsIgnoreCase(jsonObject.get("Type").getAsString())) continue;
            r = r2;
        }
        8k_0.c.c.c(new 9p(jsonObject.get("Name").getAsString(), jsonObject.get("X").getAsDouble(), jsonObject.get("Y").getAsDouble(), jsonObject.get("Z").getAsDouble(), jsonObject.get("Dimension").getAsInt(), jsonObject.get("Server").getAsString(), r));
    }

    /*
     * Exception decompiling
     */
    public static void 1() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 10[UNCONDITIONALDOLOOP]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public static void 1(JsonElement jsonElement) {
        T.5(jsonElement.getAsJsonObject());
    }

    public static void c(8h_0 h_02, JsonElement jsonElement) {
        String string = jsonElement.getAsString();
        ((88)h_02.6()).0(string);
    }

    public static boolean 3(File file) {
        return file.getName().endsWith(".json");
    }

    public static void 2(JsonObject jsonObject) {
        JsonObject jsonObject2 = jsonObject;
        String string = "Language";
        try {
            68.2 = jsonObject2.get(string).getAsString();
        }
        catch (NullPointerException nullPointerException) {
            // empty catch block
        }
    }

    public static boolean c(JsonObject jsonObject, 2C c2) {
        return jsonObject.getAsJsonObject(c2.8()) != null;
    }

    public static void 0(2r_0 r_02) {
        block0: {
            if (!(r_02 instanceof 2s_0)) break block0;
            ((2s_0)r_02).c().forEach(T::2);
        }
    }

    public static void 0(JsonElement jsonElement) {
        try {
            T.7(jsonElement.getAsJsonObject());
        }
        catch (NullPointerException nullPointerException) {
            System.err.println(nullPointerException.getMessage());
        }
    }

    public static void 1(8h_0 h_02, JsonElement jsonElement) {
        String string = jsonElement.getAsString();
        ((88)h_02.6()).0(string);
    }

    public static void c(3E e2, File file) {
        block4: {
            int n2;
            JsonArray jsonArray;
            JsonArray jsonArray2 = T.1(file);
            JsonArray jsonArray3 = null;
            try {
                jsonArray = jsonArray2;
                n2 = 0;
            }
            catch (Exception exception) {
                exception.printStackTrace();
                System.err.println("Module Array not found!");
                return;
            }
            JsonObject jsonObject = (JsonObject)jsonArray.get(n2);
            jsonArray3 = jsonObject.getAsJsonArray("Modules");
            int n3 = -1;
            for (int i2 = 0; i2 < jsonArray3.size(); ++i2) {
                JsonObject jsonObject2 = jsonArray3.get(i2).getAsJsonObject();
                if (jsonObject2.getAsJsonObject(e2.b()) == null) continue;
                n3 = i2;
            }
            if (n3 == -1) break block4;
            jsonArray3.set(n3, (JsonElement)T.c(e2));
            JsonObject jsonObject3 = new JsonObject();
            jsonObject3.add("Modules", (JsonElement)jsonArray3);
            jsonArray2.set(0, (JsonElement)jsonObject3);
            T.c(jsonArray2, file);
        }
    }

    public static void c(JsonObject jsonObject) {
        JsonObject jsonObject2 = jsonObject;
        String string = "Prefix";
        try {
            me.darki.konas.2.3(jsonObject2.get(string).getAsString());
        }
        catch (NullPointerException nullPointerException) {
            // empty catch block
        }
    }

    public static void 0(JsonObject jsonObject) {
        try {
            KonasMod.WATERMARK = jsonObject.get("Watermark").getAsString();
        }
        catch (NullPointerException nullPointerException) {
            // empty catch block
        }
    }

    public static boolean 2(File file) {
        return file.delete();
    }

    public static JsonArray 5() {
        JsonArray jsonArray = new JsonArray();
        for (8H h2 : 8J.c()) {
            jsonArray.add((JsonElement)T.c(h2));
        }
        return jsonArray;
    }

    public static boolean 5(File file) {
        return file.getName().endsWith(".json");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void 4(File file) {
        try {
            JsonArray jsonArray;
            Object object;
            JsonArray jsonArray2 = T.1(file);
            try {
                object = (JsonObject)jsonArray2.get(3);
                jsonArray = object.getAsJsonArray("Friends");
            }
            catch (Exception exception) {
                exception.printStackTrace();
                System.err.println("Friends Array not found!");
                return;
            }
            if (((Boolean)3I.1.6()).booleanValue()) {
                8J.0();
            }
            object = jsonArray.iterator();
            while (object.hasNext()) {
                JsonElement jsonElement = (JsonElement)object.next();
                T.5(jsonElement.getAsJsonObject());
            }
            return;
        }
        catch (Exception exception) {
            System.err.println("Error while loading friends");
            return;
        }
    }

    public static boolean c(JsonObject jsonObject, 3E e2) {
        return jsonObject.getAsJsonObject(e2.b()) != null;
    }

    public static JsonArray 2() {
        JsonArray jsonArray = new JsonArray();
        for (3B b2 : 3C.0()) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("Name", b2.2());
            jsonObject.addProperty("Bind", GameSettings.getKeyDisplayString((int)b2.c()));
            jsonObject.addProperty("Text", b2.1());
            jsonArray.add((JsonElement)jsonObject);
        }
        return jsonArray;
    }

    /*
     * Unable to fully structure code
     */
    public static void 8(JsonObject var0) throws NullPointerException {
        block19: {
            block20: {
                var1_1 = 8k_0.c.c.c().stream().filter((Predicate<2E>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Z, c(com.google.gson.JsonObject me.darki.konas.2E ), (Lme/darki/konas/2E;)Z)((JsonObject)var0)).findFirst().orElse(null);
                if (var1_1 == null) break block20;
                var2_2 = var0.getAsJsonObject(var1_1.0());
                var3_3 = var2_2.getAsJsonPrimitive("Enabled").getAsBoolean();
                var1_1.c(var3_3);
                var4_5 = var2_2.getAsJsonPrimitive("A").getAsInt();
                var5_6 = var2_2.getAsJsonPrimitive("X").getAsFloat();
                v0 = var2_2;
                v1 = "Y";
                var6_7 = v0.getAsJsonPrimitive(v1).getAsFloat();
                var1_1.0(var4_5);
                var1_1.2(var5_6);
                var1_1.3(var6_7);
                v2 = 2F.c(var1_1);
                if (v2.isEmpty()) break block19;
                var7_8 = 2F.c(var1_1).iterator();
                while (var7_8.hasNext()) {
                    v3 = var8_9 = var7_8.next();
                }
                break block19;
                {
                    if (v3.6() instanceof Float) {
                        var8_9.2(Float.valueOf(var2_2.getAsJsonPrimitive(var8_9.c()).getAsFloat()));
                        continue;
                    }
                    if (!(var8_9.6() instanceof Double)) ** GOTO lbl35
                    v4 = var8_9;
                    v5 = var2_2;
                    v6 = var8_9;
                    v4.2(v5.getAsJsonPrimitive(v6.c()).getAsDouble());
                    continue;
lbl35:
                    // 1 sources

                    if (var8_9.6() instanceof Integer) {
                        var8_9.2(var2_2.getAsJsonPrimitive(var8_9.c()).getAsInt());
                        continue;
                    }
                    if (!(var8_9.6() instanceof Boolean)) ** GOTO lbl46
                    v7 = var8_9;
                    v8 = var2_2.getAsJsonPrimitive(var8_9.c());
                    v9 = v8.getAsBoolean();
                    v7.2(v9);
                    continue;
lbl46:
                    // 1 sources

                    if (var8_9.6() instanceof Enum) {
                        var8_9.2(var2_2.getAsJsonPrimitive(var8_9.c()).getAsString());
                        continue;
                    }
                    v10 = var8_9;
                    if (!(v10.6() instanceof String)) ** GOTO lbl60
                    v11 = var8_9;
                    v12 = var2_2;
                    v13 = var8_9.c();
                    v14 = v12.getAsJsonPrimitive(v13).getAsString();
                    v11.2(v14);
                    continue;
lbl60:
                    // 1 sources

                    if (!(var8_9.6() instanceof 89)) ** GOTO lbl73
                    var9_10 = var2_2.getAsJsonArray(var8_9.c());
                    v15 = (89)var8_9.6();
                    v16 = var9_10.get(0);
                    v15.0(v16.getAsInt());
                    v17 = var8_9;
                    v18 = (89)v17.6();
                    v19 = var9_10.get(1).getAsBoolean();
                    v18.c(v19);
                    continue;
lbl73:
                    // 1 sources

                    if (!(var8_9.6() instanceof 88)) ** GOTO lbl80
                    var9_10 = var2_2.getAsJsonArray(var8_9.c());
                    var9_10.forEach((Consumer<JsonElement>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)V, 1(me.darki.konas.8h_0 com.google.gson.JsonElement ), (Lcom/google/gson/JsonElement;)V)((8h_0)var8_9));
                    v20 = (88)var8_9.6();
                    try {
                        v20.1();
                        continue;
lbl80:
                        // 1 sources

                        if (!(var8_9.6() instanceof 8d_0)) continue;
                        var9_10 = var2_2.getAsJsonArray(var8_9.c());
                        var9_10.forEach((Consumer<JsonElement>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)V, 3(me.darki.konas.8h_0 com.google.gson.JsonElement ), (Lcom/google/gson/JsonElement;)V)((8h_0)var8_9));
                        continue;
                    }
                    catch (Exception var3_4) {
                        var3_4.printStackTrace();
                        throw new NullPointerException("Error loading container: " + var1_1.0());
                        break;
                    }
                }
            }
            throw new NullPointerException("Couldn't find container");
        }
    }

    /*
     * Exception decompiling
     */
    public static void a() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK]], but top level block is 8[WHILELOOP]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public static void c(File file, File file2) {
        block5: {
            if (!file.exists()) break block5;
            if (file2.exists()) {
                file.delete();
            } else {
                File file3 = file;
                try {
                    Files.move(file3.toPath(), file2.toPath(), new CopyOption[0]);
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            }
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void 4(JsonObject var0) throws NullPointerException {
        block30: {
            var1_1 = 3F.2().stream().filter((Predicate<3E>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Z, c(com.google.gson.JsonObject me.darki.konas.3E ), (Lme/darki/konas/3E;)Z)((JsonObject)var0)).findFirst().orElse(null);
            if (var1_1 == null) {
                throw new NullPointerException("Couldn't find module");
            }
            var2_2 = var0.getAsJsonObject(var1_1.b());
            var3_3 = var2_2.getAsJsonPrimitive("Bind").getAsString();
            var1_1.c(T.c(var3_3));
            var4_5 = var2_2.getAsJsonPrimitive("Enabled").getAsBoolean();
            if (var1_1.f() != var4_5) {
                var1_1.d();
            }
            var5_6 = var2_2.getAsJsonPrimitive("Visible").getAsBoolean();
            v0 = var1_1;
            v1 = var5_6;
            v0.c(v1);
            if (3F.1(var1_1).isEmpty()) break block30;
            v2 = var1_1;
            try {
                var6_7 = 3F.1(v2).iterator();
                while (true) {
                    if (!var6_7.hasNext()) break;
                    var7_8 = var6_7.next();
                    if (!(var7_8.6() instanceof Float)) ** GOTO lbl32
                    v3 = var7_8;
                    v4 = var2_2.getAsJsonPrimitive(var7_8.c());
                    {
                        catch (Exception var8_10) {}
                    }
                    v3.2(Float.valueOf(v4.getAsFloat()));
                    continue;
lbl32:
                    // 1 sources

                    v5 = var7_8;
                    if (!(v5.6() instanceof Double)) ** GOTO lbl41
                    v6 = var7_8;
                    v7 = var2_2;
                    v8 = var7_8.c();
                    v6.2(v7.getAsJsonPrimitive(v8).getAsDouble());
                    continue;
lbl41:
                    // 1 sources

                    if (var7_8.6() instanceof Integer) {
                        var7_8.2(var2_2.getAsJsonPrimitive(var7_8.c()).getAsInt());
                        continue;
                    }
                    if (!(var7_8.6() instanceof Boolean)) ** GOTO lbl52
                    v9 = var7_8;
                    v10 = var2_2.getAsJsonPrimitive(var7_8.c());
                    v11 = v10.getAsBoolean();
                    v9.2(v11);
                    continue;
lbl52:
                    // 1 sources

                    if (!(var7_8.6() instanceof 8f_0)) ** GOTO lbl58
                    v12 = (8f_0)var7_8.6();
                    v13 = var2_2.getAsJsonPrimitive(var7_8.c());
                    v12.c(v13.getAsBoolean());
                    continue;
lbl58:
                    // 1 sources

                    if (var7_8.6() instanceof Enum) {
                        var7_8.2(var2_2.getAsJsonPrimitive(var7_8.c()).getAsString());
                        continue;
                    }
                    if (!(var7_8.6() instanceof 8j_0)) ** GOTO lbl70
                    v14 = var7_8;
                    v15 = v16;
                    v17 = v16;
                    v18 = var2_2.getAsJsonPrimitive(var7_8.c()).getAsInt();
                    v15(v18);
                    v14.2(v17);
                    continue;
lbl70:
                    // 1 sources

                    if (var7_8.6() instanceof String) {
                        var7_8.2(var2_2.getAsJsonPrimitive(var7_8.c()).getAsString());
                        continue;
                    }
                    if (!(var7_8.6() instanceof 89)) ** GOTO lbl86
                    var8_9 = var2_2.getAsJsonArray(var7_8.c());
                    ((89)var7_8.6()).0(var8_9.get(0).getAsInt());
                    v19 = (89)var7_8.6();
                    v20 = var8_9.get(1);
                    v19.c(v20.getAsBoolean());
                    v21 = (89)var7_8.6();
                    v22 = var8_9;
                    v23 = 2;
                    v21.c(v22.get(v23).getAsInt());
                    continue;
lbl86:
                    // 1 sources

                    if (!(var7_8.6() instanceof 88)) ** GOTO lbl93
                    var8_9 = var2_2.getAsJsonArray(var7_8.c());
                    var8_9.forEach((Consumer<JsonElement>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)V, c(me.darki.konas.8h_0 com.google.gson.JsonElement ), (Lcom/google/gson/JsonElement;)V)((8h_0)var7_8));
                    v24 = var7_8;
                    ((88)v24.6()).1();
                    continue;
lbl93:
                    // 1 sources

                    v25 = var7_8;
                    if (v25.6() instanceof 8d_0) {
                        var8_9 = var2_2.getAsJsonArray(var7_8.c());
                        var8_9.forEach((Consumer<JsonElement>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)V, 2(me.darki.konas.8h_0 com.google.gson.JsonElement ), (Lcom/google/gson/JsonElement;)V)((8h_0)var7_8));
                        continue;
                    }
                    v26 = var7_8;
                    if (!(v26.6() instanceof 8i_0)) continue;
                    var8_9 = var2_2.getAsJsonArray(var7_8.c());
                    var8_9.forEach((Consumer<JsonElement>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)V, 0(me.darki.konas.8h_0 com.google.gson.JsonElement ), (Lcom/google/gson/JsonElement;)V)((8h_0)var7_8));
                    continue;
                    break;
                }
            }
            catch (Exception var3_4) {
                throw new NullPointerException("Error loading module: " + var1_1.b());
            }
        }
    }

    public static void 2(8h_0 h_02, JsonElement jsonElement) {
        String string = jsonElement.getAsString();
        ((8d_0)h_02.6()).c(string);
    }

    public static void 2(2r_0 r_02) {
        block0: {
            if (!(r_02 instanceof 2q_0)) break block0;
            ((2q_0)r_02).0();
        }
    }

    public static JsonArray 1(File file) {
        try {
            FileReader fileReader = new FileReader(file);
            JsonParser jsonParser = new JsonParser();
            JsonArray jsonArray = (JsonArray)jsonParser.parse((Reader)fileReader);
            fileReader.close();
            return jsonArray;
        }
        catch (Exception exception) {
            System.err.println("Couldn't load config");
            return null;
        }
    }

    public static JsonArray f() {
        JsonArray jsonArray = new JsonArray();
        for (9p p2 : 8k_0.c.c.2()) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("Name", p2.3());
            jsonObject.addProperty("X", (Number)p2.4());
            jsonObject.addProperty("Y", (Number)p2.c());
            jsonObject.addProperty("Z", (Number)p2.5());
            jsonObject.addProperty("Dimension", (Number)p2.2());
            jsonObject.addProperty("Server", p2.6());
            jsonObject.addProperty("Type", p2.1().toString());
            jsonArray.add((JsonElement)jsonObject);
        }
        return jsonArray;
    }

    public static void 1(JsonObject jsonObject) {
        3C.0(new 3B(jsonObject.get("Name").getAsString(), jsonObject.get("Text").getAsString(), Keyboard.getKeyIndex((String)jsonObject.get("Bind").getAsString())));
    }

    public static void 6(JsonObject jsonObject) throws NullPointerException {
        2C c2 = 8k_0.c.c.3().stream().filter(arg_0 -> T.c(jsonObject, arg_0)).findFirst().orElse(null);
        if (c2 instanceof 2A) {
            return;
        }
        if (c2 != null) {
            JsonPrimitive jsonPrimitive;
            JsonObject jsonObject2 = jsonObject.getAsJsonObject(c2.8());
            try {
                int n2 = jsonObject2.getAsJsonPrimitive("X").getAsInt();
                c2.3(n2);
                jsonPrimitive = jsonObject2.getAsJsonPrimitive("Y");
            }
            catch (Exception exception) {
                throw new NullPointerException("Error parsing frame: " + c2.8());
            }
            int n3 = jsonPrimitive.getAsInt();
            c2.0(n3);
            boolean bl = jsonObject2.getAsJsonPrimitive("Extended").getAsBoolean();
            2C c3 = c2;
            boolean bl2 = bl;
            c3.0(bl2);
        } else {
            throw new NullPointerException("Frame not found");
        }
    }

    public static void 0(8h_0 h_02, JsonElement jsonElement) {
        String string = jsonElement.getAsString();
        ((8i_0)h_02.6()).c(string);
    }

    public static void c(JsonArray jsonArray, File file) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            new GsonBuilder().setPrettyPrinting().create().toJson((JsonElement)jsonArray, (Appendable)fileWriter);
            fileWriter.close();
        }
        catch (Exception exception) {
            System.err.println("Cant write to config file!");
        }
    }

    public static int c(String string) {
        String string2 = I18n.format((String)"key.mouse.left", (Object[])new Object[0]);
        String string3 = I18n.format((String)"key.mouse.right", (Object[])new Object[0]);
        String string4 = I18n.format((String)"key.mouse.middle", (Object[])new Object[0]);
        if (string.equalsIgnoreCase(string2)) {
            return -100;
        }
        if (string.equalsIgnoreCase(string3)) {
            return -99;
        }
        if (string.equalsIgnoreCase(string4)) {
            return -98;
        }
        for (int i2 = 0; i2 < 15; ++i2) {
            if (!string.equalsIgnoreCase(I18n.format((String)"key.mouseButton", (Object[])new Object[]{i2 + 4}))) continue;
            return i2 + 4 - 101;
        }
        return Keyboard.getKeyIndex((String)string);
    }

    public static void 3(JsonObject jsonObject) {
        8Q.0(jsonObject.get("Name").getAsString());
    }

    /*
     * Exception decompiling
     */
    public static void c(File var0, String var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK]], but top level block is 9[UNCONDITIONALDOLOOP]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Exception decompiling
     */
    public static void 0(3E var0, File var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[TRYBLOCK]], but top level block is 10[WHILELOOP]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void 7() {
        try {
            if (!2.exists()) {
                T.1();
                return;
            }
            FileReader fileReader = new FileReader(2);
            JsonParser jsonParser = new JsonParser();
            JsonArray jsonArray = null;
            try {
                jsonArray = (JsonArray)jsonParser.parse((Reader)fileReader);
            }
            catch (ClassCastException classCastException) {
                T.1();
            }
            if (jsonArray == null) return;
            if (jsonArray.isJsonNull()) return;
            Iterator iterator = jsonArray.iterator();
            while (iterator.hasNext()) {
                JsonElement jsonElement = (JsonElement)iterator.next();
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                String string = jsonObject.getAsJsonPrimitive("Name").getAsString();
                String string2 = jsonObject.getAsJsonPrimitive("E-Mail").getAsString();
                String string3 = jsonObject.getAsJsonPrimitive("Password").getAsString();
                String string4 = jsonObject.getAsJsonPrimitive("UUID").getAsString();
                String string5 = jsonObject.getAsJsonPrimitive("Token").getAsString();
                JsonObject jsonObject2 = jsonObject;
                try {
                    boolean bl = jsonObject2.getAsJsonPrimitive("Microsoft").getAsBoolean();
                    long l2 = jsonObject.getAsJsonPrimitive("Last-Login").getAsLong();
                    29 var14_16 = new 29(string2, string3, string3.equals(""), bl);
                    var14_16.1(string);
                    var14_16.c(l2);
                    var14_16.0(string4);
                    var14_16.c(string5);
                    2g_0 g_02 = new 2g_0(var14_16);
                    8k_0.c.c.c.add(g_02);
                }
                catch (NullPointerException nullPointerException) {
                    System.err.println("Failed to load account");
                }
            }
            return;
        }
        catch (IOException iOException) {
            System.err.println("Error loading accounts");
            return;
        }
    }

    public static void 4(JsonElement jsonElement) {
        T.3(jsonElement.getAsJsonObject());
    }

    public static void 1(2r_0 r_02) {
        block0: {
            if (!(r_02 instanceof 2u_0)) break block0;
            ((2u_0)r_02).1().forEach(T::c);
        }
    }

    public static boolean c(JsonObject jsonObject, 2E e2) {
        return jsonObject.getAsJsonObject(e2.0()) != null;
    }

    public static void 4() {
        T.0(0);
    }

    public static void 3(8h_0 h_02, JsonElement jsonElement) {
        String string = jsonElement.getAsString();
        ((8d_0)h_02.6()).c(string);
    }

    public static void 3(JsonElement jsonElement) {
        try {
            T.4(jsonElement.getAsJsonObject());
        }
        catch (NullPointerException nullPointerException) {
            System.err.println(nullPointerException.getMessage());
        }
    }

    public static JsonArray e() {
        JsonArray jsonArray = new JsonArray();
        for (2E e2 : 8k_0.c.c.c()) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("A", (Number)e2.1());
            jsonObject.addProperty("X", (Number)Float.valueOf(e2.e()));
            jsonObject.addProperty("Y", (Number)Float.valueOf(e2.2()));
            jsonObject.addProperty("Enabled", Boolean.valueOf(e2.6()));
            jsonObject.addProperty("Visible", Boolean.valueOf(e2.6()));
            if (!2F.c(e2).isEmpty()) {
                for (8h_0 h_02 : 2F.c(e2)) {
                    JsonArray jsonArray2;
                    if (h_02.6() instanceof Number) {
                        jsonObject.addProperty(h_02.c(), (Number)h_02.6());
                        continue;
                    }
                    if (h_02.6() instanceof Boolean) {
                        jsonObject.addProperty(h_02.c(), (Boolean)h_02.6());
                        continue;
                    }
                    if (h_02.6() instanceof Enum || h_02.6() instanceof String) {
                        jsonObject.addProperty(h_02.c(), String.valueOf(h_02.6()));
                        continue;
                    }
                    if (h_02.6() instanceof 89) {
                        jsonArray2 = new JsonArray();
                        jsonArray2.add((Number)((89)h_02.6()).0());
                        jsonArray2.add(Boolean.valueOf(((89)h_02.6()).7()));
                        jsonObject.add(h_02.c(), (JsonElement)jsonArray2);
                        continue;
                    }
                    if (h_02.6() instanceof 88) {
                        jsonArray2 = new JsonArray();
                        for (String string : ((88)h_02.6()).c()) {
                            jsonArray2.add(string);
                        }
                        jsonObject.add(h_02.c(), (JsonElement)jsonArray2);
                        continue;
                    }
                    if (!(h_02.6() instanceof 8d_0)) continue;
                    jsonArray2 = new JsonArray();
                    for (String string : ((8d_0)h_02.6()).c()) {
                        jsonArray2.add(string);
                    }
                    jsonObject.add(h_02.c(), (JsonElement)jsonArray2);
                }
            }
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.add(e2.0(), (JsonElement)jsonObject);
            jsonArray.add((JsonElement)jsonObject2);
        }
        return jsonArray;
    }

    /*
     * Exception decompiling
     */
    public static void c(File var0, boolean var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 6 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:412)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public static JsonArray d() {
        JsonArray jsonArray = new JsonArray();
        for (String string : 8Q.c()) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("Name", string);
            jsonArray.add((JsonElement)jsonObject);
        }
        return jsonArray;
    }

    /*
     * Exception decompiling
     */
    public static void 3() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [7[TRYBLOCK]], but top level block is 30[UNCONDITIONALDOLOOP]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public static void c(String string, boolean bl) {
        File file;
        File file2 = file;
        File file3 = file;
        File file4 = c;
        try {
            file2(file4, "spammer");
            File file5 = file3;
            if (!file5.exists()) {
                file5.mkdirs();
            }
            File file6 = new File(file5, string);
            if (bl && !file6.exists()) {
                file6.createNewFile();
            }
            new Thread(() -> T.c(file6, string)).start();
        }
        catch (IOException iOException) {
            System.err.println("Could not load spammer file " + string);
        }
    }

    public static void c(2C c2) {
        block1: {
            block0: {
                if (!(c2 instanceof 2z_0)) break block0;
                ((2z_0)c2).0().forEach(T::1);
                break block1;
            }
            if (!(c2 instanceof 2D)) break block1;
            ((2D)c2).1().forEach(T::0);
        }
    }

    /*
     * Exception decompiling
     */
    public static void c(File var0) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [4[TRYBLOCK]], but top level block is 10[WHILELOOP]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }
}

