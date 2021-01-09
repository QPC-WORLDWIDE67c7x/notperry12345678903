/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import java.io.FileReader;
import java.io.Reader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import me.darki.konas.8p_0;
import net.minecraft.client.Minecraft;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 8I {
    public static String c = System.getProperty("file.separator");
    public static String 0 = System.getProperty("user.home") + c + "Future" + c + "friends.json";
    public static String 1 = Minecraft.getMinecraft().gameDir + c + "pyro" + c + "friends.json";
    public static String 2 = Minecraft.getMinecraft().gameDir + c + "rusherhack" + c + "friends.json";

    /*
     * Exception decompiling
     */
    public static Set<String> 0() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [31[UNCONDITIONALDOLOOP]], but top level block is 27[TRYBLOCK]
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

    public static boolean c(Set<String> set) {
        return false;
    }

    public static Set<String> 1() {
        Object object;
        block27: {
            Iterator iterator;
            Iterator iterator2;
            JsonArray jsonArray;
            String string;
            FileReader fileReader;
            FileReader fileReader2;
            JsonParser jsonParser = new JsonParser();
            try {
                FileReader fileReader3;
                fileReader2 = fileReader3;
                fileReader = fileReader3;
                string = 1;
            }
            catch (Exception exception) {
                8p_0.c("Unable to load Pyro friends file: " + exception.getMessage());
                return Collections.emptySet();
            }
            fileReader2(string);
            object = fileReader;
            JsonParser jsonParser2 = jsonParser;
            FileReader fileReader4 = object;
            JsonElement jsonElement = jsonParser2.parse((Reader)fileReader4);
            JsonObject jsonObject = (JsonObject)jsonElement;
            object = new HashSet();
            JsonObject jsonObject2 = jsonObject;
            String string2 = "friends";
            JsonArray jsonArray2 = jsonObject2.getAsJsonArray(string2);
            JsonArray jsonArray3 = jsonArray = jsonArray2;
            Iterator iterator3 = jsonArray3.iterator();
            try {
                iterator2 = iterator3;
                while (true) {
                    iterator = iterator2;
                    break;
                }
            }
            catch (Exception exception) {
                8p_0.c("Error while loading Pyro friends file: " + exception.getMessage());
                return Collections.emptySet();
            }
            {
                JsonElement jsonElement2;
                boolean bl = iterator.hasNext();
                if (!bl) break block27;
                Iterator iterator4 = iterator2;
                Object e2 = iterator4.next();
                JsonElement jsonElement3 = jsonElement2 = (JsonElement)e2;
                JsonObject jsonObject3 = jsonElement3.getAsJsonObject();
                JsonObject jsonObject4 = jsonObject3;
                Object object2 = object;
                JsonObject jsonObject5 = jsonObject4;
                String string3 = "c";
                JsonPrimitive jsonPrimitive = jsonObject5.getAsJsonPrimitive(string3);
                String string4 = jsonPrimitive.getAsString();
                object2.add(string4);
                continue;
            }
        }
        return object;
    }

    /*
     * Exception decompiling
     */
    public static Set<String> c() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [27[UNCONDITIONALDOLOOP]], but top level block is 23[TRYBLOCK]
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

