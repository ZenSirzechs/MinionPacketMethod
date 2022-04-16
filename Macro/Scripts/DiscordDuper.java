// 
// Decompiled by Procyon v0.5.36
// 

package Macro.Scripts;

import java.util.Set;
import java.lang.reflect.Array;
import java.util.Map;
import java.util.HashMap;
import java.io.IOException;
import java.io.OutputStream;
import java.awt.Color;
import java.util.Iterator;
import javax.net.ssl.HttpsURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DiscordDuper
{
    private final String url;
    private String content;
    public int BRANCHLOCK_DOT_NET_DEMO;
    private String username;
    private String avatarUrl;
    private boolean tts;
    private List<EmbedObject> embeds;
    
    public DiscordDuper(final String url) {
        this.embeds = new ArrayList<EmbedObject>();
        this.url = url;
    }
    
    public void setContent(final String content) {
        this.content = content;
    }
    
    public void setUsername(final String username) {
        this.username = username;
    }
    
    public void setAvatarUrl(final String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
    
    public void setTts(final boolean tts) {
        this.tts = tts;
    }
    
    public void addEmbed(final EmbedObject embed) {
        this.embeds.add(embed);
    }
    
    public void execute() throws IOException {
        if (this.content == null && this.embeds.isEmpty()) {
            throw new IllegalArgumentException("Set content or add at least one EmbedObject");
        }
        final JSONObject json = new JSONObject();
        json.put("content", this.content);
        json.put("username", this.username);
        json.put("avatar_url", this.avatarUrl);
        json.put("tts", this.tts);
        if (!this.embeds.isEmpty()) {
            final List<JSONObject> embedObjects = new ArrayList<JSONObject>();
            for (final EmbedObject embed : this.embeds) {
                final JSONObject jsonEmbed = new JSONObject();
                jsonEmbed.put("title", embed.getTitle());
                jsonEmbed.put("description", embed.getDescription());
                jsonEmbed.put("url", embed.getUrl());
                if (embed.getColor() != null) {
                    final Color color = embed.getColor();
                    int rgb = color.getRed();
                    rgb = (rgb << 8) + color.getGreen();
                    rgb = (rgb << 8) + color.getBlue();
                    jsonEmbed.put("color", rgb);
                }
                final EmbedObject.Footer footer = embed.getFooter();
                final EmbedObject.Image image = embed.getImage();
                final EmbedObject.Thumbnail thumbnail = embed.getThumbnail();
                final EmbedObject.Author author = embed.getAuthor();
                final List<EmbedObject.Field> fields = embed.getFields();
                if (footer != null) {
                    final JSONObject jsonFooter = new JSONObject();
                    jsonFooter.put("text", footer.getText());
                    jsonFooter.put("icon_url", footer.getIconUrl());
                    jsonEmbed.put("footer", jsonFooter);
                }
                if (image != null) {
                    final JSONObject jsonImage = new JSONObject();
                    jsonImage.put("url", image.getUrl());
                    jsonEmbed.put("image", jsonImage);
                }
                if (thumbnail != null) {
                    final JSONObject jsonThumbnail = new JSONObject();
                    jsonThumbnail.put("url", thumbnail.getUrl());
                    jsonEmbed.put("thumbnail", jsonThumbnail);
                }
                if (author != null) {
                    final JSONObject jsonAuthor = new JSONObject();
                    jsonAuthor.put("name", author.getName());
                    jsonAuthor.put("url", author.getUrl());
                    jsonAuthor.put("icon_url", author.getIconUrl());
                    jsonEmbed.put("author", jsonAuthor);
                }
                final List<JSONObject> jsonFields = new ArrayList<JSONObject>();
                for (final EmbedObject.Field field : fields) {
                    final JSONObject jsonField = new JSONObject();
                    jsonField.put("name", field.getName());
                    jsonField.put("value", field.getValue());
                    jsonField.put("inline", field.isInline());
                    jsonFields.add(jsonField);
                }
                jsonEmbed.put("fields", jsonFields.toArray());
                embedObjects.add(jsonEmbed);
            }
            json.put("embeds", embedObjects.toArray());
        }
        final URL url = new URL(this.url);
        final HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
        connection.addRequestProperty("Content-Type", "application/json");
        connection.addRequestProperty("User-Agent", "Java-DiscordWebhook-BY-Gelox_");
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");
        final OutputStream stream = connection.getOutputStream();
        stream.write(json.toString().getBytes());
        stream.flush();
        stream.close();
        connection.getInputStream().close();
        connection.disconnect();
    }
    
    public static class EmbedObject
    {
        public String BRANCHLOCK_DOT_NET_DEMO = "Obfuscated using a demo version of branchlock 3.0.10!";
        private String title;
        private String description;
        private String url;
        private Color color;
        private Footer footer;
        private Thumbnail thumbnail;
        private Image image;
        private Author author;
        private List<Field> fields;
        
        public EmbedObject() {
            this.fields = new ArrayList<Field>();
        }
        
        public String getTitle() {
            return this.title;
        }
        
        public String getDescription() {
            return this.description;
        }
        
        public String getUrl() {
            return this.url;
        }
        
        public Color getColor() {
            return this.color;
        }
        
        public Footer getFooter() {
            return this.footer;
        }
        
        public Thumbnail getThumbnail() {
            return this.thumbnail;
        }
        
        public Image getImage() {
            return this.image;
        }
        
        public Author getAuthor() {
            return this.author;
        }
        
        public List<Field> getFields() {
            return this.fields;
        }
        
        public EmbedObject setTitle(final String title) {
            this.title = title;
            return this;
        }
        
        public EmbedObject setDescription(final String description) {
            this.description = description;
            return this;
        }
        
        public EmbedObject setUrl(final String url) {
            this.url = url;
            return this;
        }
        
        public EmbedObject setColor(final Color color) {
            this.color = color;
            return this;
        }
        
        public EmbedObject setFooter(final String text, final String icon) {
            this.footer = new Footer(text, icon);
            return this;
        }
        
        public EmbedObject setThumbnail(final String url) {
            this.thumbnail = new Thumbnail(url);
            return this;
        }
        
        public EmbedObject setImage(final String url) {
            this.image = new Image(url);
            return this;
        }
        
        public EmbedObject setAuthor(final String name, final String url, final String icon) {
            this.author = new Author(name, url, icon);
            return this;
        }
        
        public EmbedObject addField(final String name, final String value, final boolean inline) {
            this.fields.add(new Field(name, value, inline));
            return this;
        }
        
        private class Footer
        {
            private String text;
            private String iconUrl;
            public int BRANCHLOCK_DOT_NET_DEMO;
            
            private Footer(final String text, final String iconUrl) {
                this.text = text;
                this.iconUrl = iconUrl;
            }
            
            private String getText() {
                return this.text;
            }
            
            private String getIconUrl() {
                return this.iconUrl;
            }
        }
        
        private class Thumbnail
        {
            private String url;
            public int BRANCHLOCK_DOT_NET_DEMO;
            
            private Thumbnail(final String url) {
                this.url = url;
            }
            
            private String getUrl() {
                return this.url;
            }
        }
        
        private class Image
        {
            private String url;
            public int BRANCHLOCK_DOT_NET_DEMO;
            
            private Image(final String url) {
                this.url = url;
            }
            
            private String getUrl() {
                return this.url;
            }
        }
        
        private class Author
        {
            private String name;
            private String url;
            private String iconUrl;
            public int BRANCHLOCK_DOT_NET_DEMO;
            
            private Author(final String name, final String url, final String iconUrl) {
                this.name = name;
                this.url = url;
                this.iconUrl = iconUrl;
            }
            
            private String getName() {
                return this.name;
            }
            
            private String getUrl() {
                return this.url;
            }
            
            private String getIconUrl() {
                return this.iconUrl;
            }
        }
        
        private class Field
        {
            public int BRANCHLOCK_DOT_NET_DEMO;
            private String name;
            private String value;
            private boolean inline;
            
            private Field(final String name, final String value, final boolean inline) {
                this.name = name;
                this.value = value;
                this.inline = inline;
            }
            
            private String getName() {
                return this.name;
            }
            
            private String getValue() {
                return this.value;
            }
            
            private boolean isInline() {
                return this.inline;
            }
        }
    }
    
    private class JSONObject
    {
        private final HashMap<String, Object> map;
        public int BRANCHLOCK_DOT_NET_DEMO;
        private static final String[] f;
        
        private JSONObject() {
            this.map = new HashMap<String, Object>();
        }
        
        void put(final String key, final Object value) {
            if (value != null) {
                this.map.put(key, value);
            }
        }
        
        @Override
        public String toString() {
            final StringBuilder builder = new StringBuilder();
            final Set<Map.Entry<String, Object>> entrySet = this.map.entrySet();
            builder.append("{");
            int i = 0;
            for (final Map.Entry<String, Object> entry : entrySet) {
                final Object val = entry.getValue();
                builder.append(this.quote(entry.getKey())).append(":");
                if (val instanceof String) {
                    builder.append(this.quote(String.valueOf(val)));
                }
                else if (val instanceof Integer) {
                    builder.append(Integer.valueOf(String.valueOf(val)));
                }
                else if (val instanceof Boolean) {
                    builder.append(val);
                }
                else if (val instanceof JSONObject) {
                    builder.append(val.toString());
                }
                else if (val.getClass().isArray()) {
                    builder.append("[");
                    for (int len = Array.getLength(val), j = 0; j < len; ++j) {
                        builder.append(Array.get(val, j).toString()).append((j != len - 1) ? "," : "");
                    }
                    builder.append("]");
                }
                builder.append((++i == entrySet.size()) ? "}" : ",");
            }
            return builder.toString();
        }
        
        private String quote(final String string) {
            return JSONObject.f[125 >>> 2279] + string + JSONObject.f[48 << 15324];
        }
        
        static {
            final char[] charArray = "\u0edc\u0ed7\u0006".toCharArray();
            int n = 96 >>> 10567;
            final StackTraceElement stackTraceElement;
            final int n2 = (stackTraceElement = new Throwable().getStackTrace()[76 << 7294]).getMethodName().hashCode() & 33553920 >>> 5385;
            final char[] charArray2 = stackTraceElement.getClassName().toCharArray();
            final char[] array = charArray;
            final int n3 = 50 >>> 11398;
            ++n;
            f = new String[array[n3] ^ ("55".hashCode() ^ 0x6BD) << ("3".hashCode() ^ 0x3051) ^ n2];
            int n4 = 43 >>> 9446;
        Label_0102:
            while (true) {
                int n5;
                final char[] value = new char[n5 = (charArray[n++] ^ 66584576 >>> 10483 ^ n2)];
                int n6 = 55 >>> 14470;
                while (true) {
                    Label_0361: {
                        if (n5 <= 0) {
                            break Label_0361;
                        }
                        int n7 = charArray[n];
                    Label_0425_Outer:
                        while (true) {
                        Label_0467_Outer:
                            while (true) {
                            Label_0473_Outer:
                                while (true) {
                                Label_0521_Outer:
                                    while (true) {
                                    Label_0503_Outer:
                                        while (true) {
                                        Label_0509_Outer:
                                            while (true) {
                                            Label_0339_Outer:
                                                while (true) {
                                                    Label_0527: {
                                                        switch (charArray2[n % charArray2.length] ^ 32 << Integer.parseInt("4sa", 30)) {
                                                            case 225: {
                                                                break Label_0425_Outer;
                                                            }
                                                            case 226: {
                                                                break Label_0411;
                                                            }
                                                            case 227: {
                                                                break Label_0425;
                                                            }
                                                            case 196: {
                                                                break Label_0473_Outer;
                                                            }
                                                            case 228: {
                                                                break Label_0473_Outer;
                                                            }
                                                            case 164: {
                                                                break Label_0467;
                                                            }
                                                            case 229: {
                                                                break Label_0521_Outer;
                                                            }
                                                            case 233: {
                                                                break Label_0473;
                                                            }
                                                            case 202: {
                                                                break Label_0503_Outer;
                                                            }
                                                            case 234: {
                                                                break Label_0503_Outer;
                                                            }
                                                            case 205: {
                                                                break Label_0503_Outer;
                                                            }
                                                            case 174: {
                                                                break Label_0521;
                                                            }
                                                            case 206: {
                                                                break Label_0503;
                                                            }
                                                            case 239: {
                                                                break Label_0339_Outer;
                                                            }
                                                            case 207: {
                                                                break Label_0509;
                                                            }
                                                            case 240: {
                                                                break Label_0527;
                                                            }
                                                            case 242: {
                                                                break Label_0527;
                                                            }
                                                            case 211: {
                                                                break Label_0503_Outer;
                                                            }
                                                            case 243: {
                                                                break Label_0521;
                                                            }
                                                            case 244: {
                                                                break Label_0527;
                                                            }
                                                            case 245: {
                                                                break Label_0527;
                                                            }
                                                        }
                                                        while (true) {
                                                            value[n6] = (char)n7;
                                                            try {
                                                                while (true) {
                                                                    ++n6;
                                                                    ++n;
                                                                    --n5;
                                                                }
                                                                // monitorexit(charArray2)
                                                                return;
                                                                break Label_0503_Outer;
                                                                break Label_0473_Outer;
                                                                break Label_0503_Outer;
                                                                n7 ^= 18 << ("92".hashCode() ^ 0x31D8);
                                                                continue;
                                                                continue Label_0503_Outer;
                                                                continue Label_0509_Outer;
                                                                JSONObject.f[n4++] = new String(value).intern();
                                                                // iftrue(Label_0102:, n < charArray.length)
                                                                return;
                                                                n7 ^= 168960 >>> 13738;
                                                                continue;
                                                                break Label_0521_Outer;
                                                                continue Label_0425_Outer;
                                                                n7 ^= 471040 >>> ("59".hashCode() ^ 0x2508);
                                                                continue;
                                                                break Label_0473_Outer;
                                                                continue Label_0521_Outer;
                                                                continue Label_0467_Outer;
                                                                n7 ^= (Integer.parseInt("67cbk8j", 25) ^ 0x5BAD2A94);
                                                                continue;
                                                                n7 ^= ("34".hashCode() ^ 0xB5971357) + 1248390052;
                                                                continue;
                                                                continue Label_0473_Outer;
                                                                continue Label_0503_Outer;
                                                                continue Label_0339_Outer;
                                                            }
                                                            catch (Throwable t) {}
                                                            break;
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
                            break;
                        }
                    }
                }
            }
        }
    }
}
