/*
 * Decompiled with CFR 0.151.
 */
package com.konasclient.loader;

import com.konasclient.loader.Loader$load$1;
import com.konasclient.loader.c;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Loader$load$1$2
implements ActionListener {
    public Loader$load$1 this$0;
    public JTextField $userNameText;
    public JPasswordField $passwordText;
    public JLabel $message;
    public JFrame $loginFrame;

    /*
     * Exception decompiling
     */
    @Override
    public void actionPerformed(ActionEvent var1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl512 : GOTO - null : trying to set 1 previously set to 0
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.populateStackInfo(Op02WithProcessedDataAndRefs.java:207)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.populateStackInfo(Op02WithProcessedDataAndRefs.java:1565)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:433)
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
     * Unable to fully structure code
     */
    public Loader$load$1$2(Loader$load$1 var1_1, JTextField var2_2, JPasswordField var3_3, JLabel var4_4, JFrame var5_5) {
        block20: {
            if (c.0 < 0) break block20;
            v0 = -1918361421;
            ** GOTO lbl7
        }
        block16: while (true) {
            v0 = 63640037;
lbl7:
            // 2 sources

            switch (v0 ^ -1462493093) {
                case 628883688: {
                    continue block16;
                }
                case -1424019010: {
                    this.this$0 = var1_1;
                    this.$userNameText = var2_2;
                    if (c.c > 0) ** GOTO lbl16
                    v1 = 828083869;
                    ** GOTO lbl18
lbl16:
                    // 1 sources

                    block17: while (true) {
                        v1 = -1994187498;
lbl18:
                        // 2 sources

                        switch (v1 ^ -1218139520) {
                            case -1097589181: {
                                continue block17;
                            }
                            default: {
                                this.$passwordText = var3_3;
                                if (c.1 >= 0) ** GOTO lbl26
                                v2 = 321787565;
                                ** GOTO lbl28
lbl26:
                                // 1 sources

                                block18: while (true) {
                                    v2 = -131213897;
lbl28:
                                    // 2 sources

                                    switch (v2 ^ -75859233) {
                                        case 959335684: {
                                            continue block18;
                                        }
                                        default: {
                                            if (c.0 < 0) ** GOTO lbl35
                                            v3 = -924913599;
                                            ** GOTO lbl37
lbl35:
                                            // 1 sources

                                            block19: while (true) {
                                                v3 = 528357969;
lbl37:
                                                // 2 sources

                                                switch (v3 ^ -406199759) {
                                                    case 790041200: {
                                                        continue block19;
                                                    }
                                                    case -122161056: {
                                                        this.$message = var4_4;
                                                        this.$loginFrame = var5_5;
                                                        super();
                                                        return;
                                                    }
                                                    default: {
                                                        throw null;
                                                    }
                                                }
                                                break;
                                            }
                                        }
                                        case -397120398: {
                                            throw null;
                                        }
                                    }
                                    break;
                                }
                            }
                            case -2042682339: 
                        }
                        break;
                    }
                    throw null;
                }
            }
            break;
        }
        throw null;
    }
}

