// 
// Decompiled by Procyon v0.5.36
// 

package Macro.Scripts;

import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;
import javax.net.ssl.HttpsURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Script3
{
    public String BRANCHLOCK_DOT_NET_DEMO = "Obfuscated using a demo version of branchlock 3.0.10!";
    public static ArrayList<String> hahahahbonk;
    private static final String[] c;
    
    public static String getscript() {
        final String pbin = Script3.c[106 << 7967];
        final String ksndad = "";
        final String jsndws = "";
        final String jonkadw = "";
        final String weunjdf = "";
        final String adjnws = "";
        final String utruje = "";
        final String djnee = "";
        if (pbin != "") {
            if (pbin.contains(Script3.c[Integer.parseInt("2", 33) << 12161]) && pbin.contains(Script3.c[83886080 >>> 15352])) {
                try {
                    final String userAgent = Script3.c[("0".hashCode() ^ 0x31) << 6337];
                    final URL url = new URL(pbin);
                    final HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
                    connection.setDoOutput(true);
                    connection.setRequestMethod(Script3.c[7 << Integer.parseInt("11d9", 21)]);
                    final InputStream response = connection.getInputStream();
                    try (final Scanner scanner = new Scanner(response)) {
                        final String responseBody = scanner.useDelimiter(Script3.c[3 << Integer.parseInt("800", 30)]).next();
                        Script3.hahahahbonk.add(responseBody);
                    }
                    catch (Exception ex) {}
                }
                catch (Exception ex2) {}
            }
        }
        else {
            Script3.hahahahbonk.add(Script3.c[1 << 9216] + adjnws + utruje + djnee + Script3.c[3 << 8833] + ksndad + jsndws + jonkadw + weunjdf);
        }
        final Random r = new Random();
        final int picked = r.nextInt(Script3.hahahahbonk.size());
        final String script = Script3.hahahahbonk.get(picked);
        return script;
    }
    
    static {
        final char[] charArray = "\u0e52\u0e9cY\u00f9quv\u000b¢*u³\u00feq`S\u00e4k+±j\u0086\u00fdC\u00ecr*7P\u00d4r\u007f\u0081´0\u0e9cY\u00f9qu¡?\u00c4\u00fdU\u00e4vfjC\u00e9+f½\u00e0*dA\u00e4*r·g\u0083½^\u00e6v*\u0ece|\u00e2\u007fl¾\u00e1d*\u0004£5%\u00faR\u0082¼U\u00e2rv%\u007f\u00d9%4\u00e2£5>\u0011\u00dalk\u00e41\u00d0\u00f2I»1,%p\u00fdui·\u00da`gz\u00e4q*\u00e76\u00dc\u00fc\u0002»%-Ny\u00d9HI\u00fe\u00adilZ\u00e8%B·f\u0080½\u0018\u00adFmw^\u00e0`*\u00e5¹+5\u001f¾27\u00eb+\u00da\u00e4\b\u00adVdcP\u00ffl*\u00e7¾2+\u0002»\u0ebfY\u0093\u0eb5\u009b³B\u00f9`gl_\u0ebewd¥\u0ebc*\u0ebev\u00c8Q".toCharArray();
        int n = 34 << Integer.parseInt("5nv", 32);
        final StackTraceElement stackTraceElement;
        final int n2 = (stackTraceElement = new Throwable().getStackTrace()[Integer.parseInt("6", 28) << 16255]).getMethodName().hashCode() & 120280529 - 120214994;
        final char[] charArray2 = stackTraceElement.getClassName().toCharArray();
        final char[] array = charArray;
        final int n3 = 88 >>> 8295;
        ++n;
        c = new String[array[n3] ^ Integer.parseInt("1irf9pm", 29) - 983494498 ^ n2];
        int n4 = 120 << 1533;
    Label_0101:
        while (true) {
            int n5;
            final char[] value = new char[n5 = (charArray[n++] ^ 335544320 >>> 12280 ^ n2)];
            int n6 = 9 >>> Integer.parseInt("11ie", 23);
        Label_0367_Outer:
            while (true) {
                Label_0288: {
                    if (n5 <= 0) {
                        break Label_0288;
                    }
                    int n7 = charArray[n];
                Label_0367:
                    while (true) {
                        Label_0409: {
                            switch (charArray2[n % charArray2.length] ^ 27 << 5952) {
                                case 114: {
                                    break Label_0367;
                                }
                                case 116: {
                                    break Label_0367;
                                }
                                case 53: {
                                    break Label_0367;
                                }
                                case 86: {
                                    break Label_0367;
                                }
                                case 120: {
                                    break Label_0367;
                                }
                                case 72: {
                                    break Label_0367;
                                }
                                case 104: {
                                    break Label_0367;
                                }
                                case 40: {
                                    break Label_0409;
                                }
                                case 105: {
                                    break Label_0409;
                                }
                                case 122: {
                                    break Label_0409;
                                }
                                case 107: {
                                    break Label_0409;
                                }
                                case 111: {
                                    break Label_0409;
                                }
                            }
                            while (true) {
                                value[n6] = (char)n7;
                                try {
                                    ++n6;
                                    ++n;
                                    --n5;
                                    // monitorexit(charArray)
                                    n7 ^= 5 << 9056;
                                    continue Label_0367_Outer;
                                    n7 ^= -2095332021 + 2095332256;
                                    continue Label_0367_Outer;
                                    n7 ^= 18048 >>> Integer.parseInt("8mt", 35);
                                    continue Label_0367_Outer;
                                    n7 ^= 49 << 13888;
                                    continue Label_0367_Outer;
                                    break Label_0409;
                                    Script3.c[n4++] = new String(value).intern();
                                    // iftrue(Label_0101:, n < charArray.length)
                                    Block_4: {
                                        break Block_4;
                                        continue Label_0367;
                                        n7 ^= 107520 >>> 329;
                                        continue Label_0367_Outer;
                                    }
                                    Script3.hahahahbonk = new ArrayList<String>();
                                }
                                catch (RuntimeException ex) {
                                    break;
                                }
                            }
                        }
                        break;
                    }
                }
            }
        }
    }
}
