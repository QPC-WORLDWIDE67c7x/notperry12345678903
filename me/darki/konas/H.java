/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.io.PrintStream;
import me.darki.konas.2;
import me.darki.konas.3E;
import me.darki.konas.3F;
import me.darki.konas.5;
import me.darki.konas.89;
import me.darki.konas.8h_0;
import me.darki.konas.8p_0;
import me.darki.konas.command.SyntaxChunk;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class H
extends 2 {
    public Object c;

    public void 6(8h_0<Enum> h_02, String string) {
        if (h_02.3(string) != -1) {
            H h2 = this;
            8h_0<Enum> h_03 = h_02;
            Object t = h_03.6();
            Enum enum_ = (Enum)t;
            Class<?> clazz = enum_.getClass();
            ?[] objArray = clazz.getEnumConstants();
            Enum[] enumArray = (Enum[])objArray;
            8h_0<Enum> h_04 = h_02;
            String string2 = string;
            int n2 = h_04.3(string2);
            Enum enum_2 = enumArray[n2];
            String string3 = enum_2.name();
            h2.c = string3;
            PrintStream printStream = System.out;
            Object object = this.c;
            try {
                printStream.println(object);
            }
            catch (Exception exception) {
                Enum enum_3 = ((Enum[])((Enum)h_02.6()).getClass().getEnumConstants())[h_02.3(string)];
                8p_0.1("Something went wrong lol");
                8p_0.1(enum_3.name());
                8p_0.1("" + h_02.3(string));
            }
        } else {
            8p_0.1("Please provide a String as the value!");
        }
    }

    /*
     * Unable to fully structure code
     */
    public void 1(8h_0<Long> var1_1, String var2_2) {
        block57: {
            v0 = var2_2;
            v1 = Long.parseLong(v0);
            v2 = var1_1;
            v3 = v2.8();
            v4 = (Long)v3;
            v5 = v4;
            if (v1 < v5) ** GOTO lbl38
            v6 = var2_2;
            v7 = Long.parseLong(v6);
            v8 = var1_1;
            v9 = v8.7();
            v10 = (Long)v9;
            v11 = v10;
            if (v7 > v11) ** GOTO lbl38
            v12 = this;
            v13 = var2_2;
            v14 = Long.parseLong(v13);
            v15 = v14;
            v12.c = v15;
            break block57;
lbl38:
            // 2 sources

            v16 = var2_2;
            v17 = Long.parseLong(v16);
            v18 = var1_1;
            v19 = v18.8();
            v20 = (Long)v19;
            v21 = v20;
            if (v17 >= v21) ** GOTO lbl71
            v22 = v23;
            v24 = v23;
            v22();
            v25 = "The minimum amount is ";
            v26 = v24.append(v25);
            v27 = var1_1;
            v28 = v27.8();
            v29 = v26.append(v28);
            v30 = v29.toString();
            8p_0.c(v30);
            break block57;
lbl71:
            // 1 sources

            v31 = var2_2;
            v32 = Long.parseLong(v31);
            v33 = var1_1;
            v34 = v33.7();
            v35 = (Long)v34;
            v36 = v35;
            if (v32 <= v36) break block57;
            v37 = v38;
            v39 = v38;
            v37();
            v40 = "The maximum amount is ";
            v41 = v39.append(v40);
            v42 = var1_1;
            v43 = v42.7();
            v44 = v41.append(v43);
            v45 = v44.toString();
            try {
                8p_0.c(v45);
            }
            catch (Exception var3_3) {
                8p_0.c("Please provide a Long as the value!");
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    public void 2(8h_0<Boolean> var1_1, String var2_2) {
        block16: {
            v0 = var2_2;
            v1 = "toggle";
            v2 = v0.equalsIgnoreCase(v1);
            if (!v2) ** GOTO lbl25
            v3 = this;
            v4 = var1_1;
            v5 = v4.6();
            v6 = (Boolean)v5;
            v7 = v6;
            v8 = v7 == false;
            v9 = v8;
            v3.c = v9;
            break block16;
lbl25:
            // 1 sources

            v10 = this;
            v11 = var2_2;
            v12 = Boolean.parseBoolean(v11);
            v13 = v12;
            try {
                v10.c = v13;
            }
            catch (Exception var3_3) {
                8p_0.c("Please provide a Boolean as the value!");
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    public void 4(8h_0<Integer> var1_1, String var2_2) {
        block57: {
            v0 = var2_2;
            v1 = Integer.parseInt(v0);
            v2 = var1_1;
            v3 = v2.8();
            v4 = (Integer)v3;
            v5 = v4;
            if (v1 < v5) ** GOTO lbl38
            v6 = var2_2;
            v7 = Integer.parseInt(v6);
            v8 = var1_1;
            v9 = v8.7();
            v10 = (Integer)v9;
            v11 = v10;
            if (v7 > v11) ** GOTO lbl38
            v12 = this;
            v13 = var2_2;
            v14 = Integer.parseInt(v13);
            v15 = v14;
            v12.c = v15;
            break block57;
lbl38:
            // 2 sources

            v16 = var2_2;
            v17 = Integer.parseInt(v16);
            v18 = var1_1;
            v19 = v18.8();
            v20 = (Integer)v19;
            v21 = v20;
            if (v17 >= v21) ** GOTO lbl71
            v22 = v23;
            v24 = v23;
            v22();
            v25 = "The minimum amount is ";
            v26 = v24.append(v25);
            v27 = var1_1;
            v28 = v27.8();
            v29 = v26.append(v28);
            v30 = v29.toString();
            8p_0.c(v30);
            break block57;
lbl71:
            // 1 sources

            v31 = var2_2;
            v32 = Integer.parseInt(v31);
            v33 = var1_1;
            v34 = v33.7();
            v35 = (Integer)v34;
            v36 = v35;
            if (v32 <= v36) break block57;
            v37 = v38;
            v39 = v38;
            v37();
            v40 = "The maximum amount is ";
            v41 = v39.append(v40);
            v42 = var1_1;
            v43 = v42.7();
            v44 = v41.append(v43);
            v45 = v44.toString();
            try {
                8p_0.c(v45);
            }
            catch (Exception var3_3) {
                8p_0.c("Please provide an Integer as the value!");
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    public void c(8h_0<Float> var1_1, String var2_2) {
        block69: {
            v0 = var2_2;
            v1 = Float.parseFloat(v0);
            v2 = var1_1;
            v3 = v2.8();
            v4 = (Float)v3;
            v5 = v4.floatValue();
            if (!(v1 >= v5)) ** GOTO lbl56
            v6 = var2_2;
            v7 = Float.parseFloat(v6);
            v8 = var1_1;
            v9 = v8.7();
            v10 = (Float)v9;
            v11 = v10.floatValue();
            if (!(v7 <= v11)) ** GOTO lbl56
            v12 = this;
            v13 = var2_2;
            v14 = Float.parseFloat(v13);
            v15 = Float.valueOf(v14);
            v12.c = v15;
            v16 = System.out;
            v17 = v18;
            v19 = v18;
            v17();
            v20 = "Value set to ";
            v21 = v19.append(v20);
            v22 = this.c;
            v23 = v21.append(v22);
            v24 = v23.toString();
            v16.println(v24);
            break block69;
lbl56:
            // 2 sources

            v25 = var2_2;
            v26 = Float.parseFloat(v25);
            v27 = var1_1;
            v28 = v27.8();
            v29 = (Float)v28;
            v30 = v29.floatValue();
            if (!(v26 < v30)) ** GOTO lbl89
            v31 = v32;
            v33 = v32;
            v31();
            v34 = "The minimum amount is ";
            v35 = v33.append(v34);
            v36 = var1_1;
            v37 = v36.8();
            v38 = v35.append(v37);
            v39 = v38.toString();
            8p_0.c(v39);
            break block69;
lbl89:
            // 1 sources

            v40 = var2_2;
            v41 = Float.parseFloat(v40);
            v42 = var1_1;
            v43 = v42.7();
            v44 = (Float)v43;
            v45 = v44.floatValue();
            if (!(v41 > v45)) break block69;
            v46 = v47;
            v48 = v47;
            v46();
            v49 = "The maximum amount is ";
            v50 = v48.append(v49);
            v51 = var1_1;
            v52 = v51.7();
            v53 = v50.append(v52);
            v54 = v53.toString();
            try {
                8p_0.c(v54);
            }
            catch (Exception var3_3) {
                8p_0.c("Please provide a Float as the value!");
            }
        }
    }

    public 8h_0 c(3E e2, String string) {
        if (3F.c(e2.b(), string) != null) {
            return 3F.c(e2.b(), string);
        }
        8p_0.c("Setting not found");
        return null;
    }

    public void 0(8h_0<89> h_02, String string) {
        89 v2;
        H h2 = this;
        89 v1 = v2;
        89 v3 = v2;
        String string2 = string;
        int n2 = 89.c(string2);
        8h_0<89> h_03 = h_02;
        Object t = h_03.6();
        89 v8 = (89)t;
        boolean bl = v8.7();
        v1(n2, bl);
        try {
            h2.c = v3;
        }
        catch (Exception exception) {
            8p_0.c("Please provide an integer as the value!");
        }
    }

    public H() {
        super("set", "Change the values of settings", new 5("<module>"), new SyntaxChunk("<setting>"), new SyntaxChunk("<value>"));
    }

    @Override
    public void c(String[] stringArray) {
        if (stringArray.length < this.2().size() + 1) {
            8p_0.1(this.0());
            return;
        }
        3E e2 = this.c(stringArray[1]);
        if (e2 == null) {
            8p_0.c("Module not found!");
            return;
        }
        8h_0 h_02 = this.c(e2, stringArray[2]);
        if (h_02 == null) {
            8p_0.c("Setting not found!");
            return;
        }
        if (h_02.6() instanceof Integer) {
            this.4(h_02, stringArray[3]);
        }
        if (h_02.6() instanceof Long) {
            this.1(h_02, stringArray[3]);
        }
        if (h_02.6() instanceof Float) {
            this.c(h_02, stringArray[3]);
        }
        if (h_02.6() instanceof Double) {
            this.3(h_02, stringArray[3]);
        }
        if (h_02.6() instanceof Boolean) {
            this.2(h_02, stringArray[3]);
        }
        if (h_02.6() instanceof Enum) {
            this.6(h_02, stringArray[3]);
        }
        if (h_02.6() instanceof 89) {
            if (stringArray[3].equalsIgnoreCase("offset")) {
                if (stringArray.length < 5) {
                    8p_0.c("Please provide an offset value!");
                    return;
                }
                this.5(h_02, stringArray[4]);
            } else {
                this.0(h_02, stringArray[3]);
            }
        }
        if (this.c != null) {
            if (this.c instanceof String) {
                h_02.2((String)this.c);
            } else {
                h_02.2(this.c);
            }
            String string = h_02.c();
            if (this.c instanceof 89) {
                if (stringArray[3].equalsIgnoreCase("offset")) {
                    this.c = ((89)this.c).8();
                    string = "Offset";
                } else {
                    this.c = ((89)this.c).c();
                }
            }
            8p_0.1("Set " + string + " to " + this.c);
            this.c = null;
        } else {
            8p_0.c("Value is null!");
        }
    }

    public 3E c(String string) {
        if (3F.c(string) != null) {
            return 3F.c(string);
        }
        return null;
    }

    public void 5(8h_0<89> h_02, String string) {
        89 v2;
        H h2 = this;
        89 v1 = v2;
        89 v3 = v2;
        8h_0<89> h_03 = h_02;
        Object t = h_03.6();
        89 v6 = (89)t;
        int n2 = v6.c();
        8h_0<89> h_04 = h_02;
        Object t2 = h_04.6();
        89 v10 = (89)t2;
        boolean bl = v10.7();
        String string2 = string;
        int n3 = Integer.parseInt(string2);
        v1(n2, bl, n3);
        try {
            h2.c = v3;
        }
        catch (Exception exception) {
            8p_0.c("Please provide an integer as the offset!");
        }
    }

    /*
     * Unable to fully structure code
     */
    public void 3(8h_0<Double> var1_1, String var2_2) {
        block57: {
            v0 = var2_2;
            v1 = Double.parseDouble(v0);
            v2 = var1_1;
            v3 = v2.8();
            v4 = (Double)v3;
            v5 = v4;
            if (!(v1 >= v5)) ** GOTO lbl38
            v6 = var2_2;
            v7 = Double.parseDouble(v6);
            v8 = var1_1;
            v9 = v8.7();
            v10 = (Double)v9;
            v11 = v10;
            if (!(v7 <= v11)) ** GOTO lbl38
            v12 = this;
            v13 = var2_2;
            v14 = Double.parseDouble(v13);
            v15 = v14;
            v12.c = v15;
            break block57;
lbl38:
            // 2 sources

            v16 = var2_2;
            v17 = Double.parseDouble(v16);
            v18 = var1_1;
            v19 = v18.8();
            v20 = (Double)v19;
            v21 = v20;
            if (!(v17 < v21)) ** GOTO lbl71
            v22 = v23;
            v24 = v23;
            v22();
            v25 = "The minimum amount is ";
            v26 = v24.append(v25);
            v27 = var1_1;
            v28 = v27.8();
            v29 = v26.append(v28);
            v30 = v29.toString();
            8p_0.c(v30);
            break block57;
lbl71:
            // 1 sources

            v31 = var2_2;
            v32 = Double.parseDouble(v31);
            v33 = var1_1;
            v34 = v33.7();
            v35 = (Double)v34;
            v36 = v35;
            if (!(v32 > v36)) break block57;
            v37 = v38;
            v39 = v38;
            v37();
            v40 = "The maximum amount is ";
            v41 = v39.append(v40);
            v42 = var1_1;
            v43 = v42.7();
            v44 = v41.append(v43);
            v45 = v44.toString();
            try {
                8p_0.c(v45);
            }
            catch (Exception var3_3) {
                8p_0.c("Please provide a Double as the value!");
            }
        }
    }
}

