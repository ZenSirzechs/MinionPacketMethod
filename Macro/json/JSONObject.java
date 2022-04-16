// 
// Decompiled by Procyon v0.5.36
// 

package Macro.json;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;

public class JSONObject
{
    private static final Double NEGATIVE_ZERO;
    public static final Object NULL;
    public int BRANCHLOCK_DOT_NET_DEMO;
    private final Map<String, Object> nameValuePairs;
    
    public JSONObject() {
        this.nameValuePairs = new HashMap<String, Object>();
    }
    
    public JSONObject(final Map copyFrom) {
        this();
        final Map<?, ?> contentsTyped = (Map<?, ?>)copyFrom;
        for (final Map.Entry<?, ?> entry : contentsTyped.entrySet()) {
            final String key = (String)entry.getKey();
            if (key == null) {
                throw new NullPointerException();
            }
            this.nameValuePairs.put(key, entry.getValue());
        }
    }
    
    public JSONObject(final JSONTokener readFrom) throws JSONException {
        final Object object = readFrom.nextValue();
        if (object instanceof JSONObject) {
            this.nameValuePairs = ((JSONObject)object).nameValuePairs;
            return;
        }
        throw JSON.typeMismatch(object, "JSONObject");
    }
    
    public JSONObject(final String json) throws JSONException {
        this(new JSONTokener(json));
    }
    
    public JSONObject(final JSONObject copyFrom, final String[] names) throws JSONException {
        this();
        for (final String name : names) {
            final Object value = copyFrom.opt(name);
            if (value != null) {
                this.nameValuePairs.put(name, value);
            }
        }
    }
    
    public int length() {
        return this.nameValuePairs.size();
    }
    
    public JSONObject put(final String name, final boolean value) throws JSONException {
        this.nameValuePairs.put(this.checkName(name), value);
        return this;
    }
    
    public JSONObject put(final String name, final double value) throws JSONException {
        this.nameValuePairs.put(this.checkName(name), JSON.checkDouble(value));
        return this;
    }
    
    public JSONObject put(final String name, final int value) throws JSONException {
        this.nameValuePairs.put(this.checkName(name), value);
        return this;
    }
    
    public JSONObject put(final String name, final long value) throws JSONException {
        this.nameValuePairs.put(this.checkName(name), value);
        return this;
    }
    
    public JSONObject put(final String name, final Object value) throws JSONException {
        if (value == null) {
            this.nameValuePairs.remove(name);
            return this;
        }
        if (value instanceof Number) {
            JSON.checkDouble(((Number)value).doubleValue());
        }
        this.nameValuePairs.put(this.checkName(name), value);
        return this;
    }
    
    public JSONObject putOpt(final String name, final Object value) throws JSONException {
        if (name == null || value == null) {
            return this;
        }
        return this.put(name, value);
    }
    
    public JSONObject accumulate(final String name, final Object value) throws JSONException {
        final Object current = this.nameValuePairs.get(this.checkName(name));
        if (current == null) {
            return this.put(name, value);
        }
        if (value instanceof Number) {
            JSON.checkDouble(((Number)value).doubleValue());
        }
        if (current instanceof JSONArray) {
            final JSONArray array = (JSONArray)current;
            array.put(value);
        }
        else {
            final JSONArray array = new JSONArray();
            array.put(current);
            array.put(value);
            this.nameValuePairs.put(name, array);
        }
        return this;
    }
    
    String checkName(final String name) throws JSONException {
        if (name == null) {
            throw new JSONException("Names must be non-null");
        }
        return name;
    }
    
    public Object remove(final String name) {
        return this.nameValuePairs.remove(name);
    }
    
    public boolean isNull(final String name) {
        final Object value = this.nameValuePairs.get(name);
        return value == null || value == JSONObject.NULL;
    }
    
    public boolean has(final String name) {
        return this.nameValuePairs.containsKey(name);
    }
    
    public Object get(final String name) throws JSONException {
        final Object result = this.nameValuePairs.get(name);
        if (result == null) {
            throw new JSONException("No value for " + name);
        }
        return result;
    }
    
    public Object opt(final String name) {
        return this.nameValuePairs.get(name);
    }
    
    public boolean getBoolean(final String name) throws JSONException {
        final Object object = this.get(name);
        final Boolean result = JSON.toBoolean(object);
        if (result == null) {
            throw JSON.typeMismatch(name, object, "boolean");
        }
        return result;
    }
    
    public boolean optBoolean(final String name) {
        return this.optBoolean(name, false);
    }
    
    public boolean optBoolean(final String name, final boolean fallback) {
        final Object object = this.opt(name);
        final Boolean result = JSON.toBoolean(object);
        return (result != null) ? result : fallback;
    }
    
    public double getDouble(final String name) throws JSONException {
        final Object object = this.get(name);
        final Double result = JSON.toDouble(object);
        if (result == null) {
            throw JSON.typeMismatch(name, object, "double");
        }
        return result;
    }
    
    public double optDouble(final String name) {
        return this.optDouble(name, Double.NaN);
    }
    
    public double optDouble(final String name, final double fallback) {
        final Object object = this.opt(name);
        final Double result = JSON.toDouble(object);
        return (result != null) ? result : fallback;
    }
    
    public int getInt(final String name) throws JSONException {
        final Object object = this.get(name);
        final Integer result = JSON.toInteger(object);
        if (result == null) {
            throw JSON.typeMismatch(name, object, "int");
        }
        return result;
    }
    
    public int optInt(final String name) {
        return this.optInt(name, 0);
    }
    
    public int optInt(final String name, final int fallback) {
        final Object object = this.opt(name);
        final Integer result = JSON.toInteger(object);
        return (result != null) ? result : fallback;
    }
    
    public long getLong(final String name) throws JSONException {
        final Object object = this.get(name);
        final Long result = JSON.toLong(object);
        if (result == null) {
            throw JSON.typeMismatch(name, object, "long");
        }
        return result;
    }
    
    public long optLong(final String name) {
        return this.optLong(name, 0L);
    }
    
    public long optLong(final String name, final long fallback) {
        final Object object = this.opt(name);
        final Long result = JSON.toLong(object);
        return (result != null) ? result : fallback;
    }
    
    public String getString(final String name) throws JSONException {
        final Object object = this.get(name);
        final String result = JSON.toString(object);
        if (result == null) {
            throw JSON.typeMismatch(name, object, "String");
        }
        return result;
    }
    
    public String optString(final String name) {
        return this.optString(name, "");
    }
    
    public String optString(final String name, final String fallback) {
        final Object object = this.opt(name);
        final String result = JSON.toString(object);
        return (result != null) ? result : fallback;
    }
    
    public JSONArray getJSONArray(final String name) throws JSONException {
        final Object object = this.get(name);
        if (object instanceof JSONArray) {
            return (JSONArray)object;
        }
        throw JSON.typeMismatch(name, object, "JSONArray");
    }
    
    public JSONArray optJSONArray(final String name) {
        final Object object = this.opt(name);
        return (object instanceof JSONArray) ? ((JSONArray)object) : null;
    }
    
    public JSONObject getJSONObject(final String name) throws JSONException {
        final Object object = this.get(name);
        if (object instanceof JSONObject) {
            return (JSONObject)object;
        }
        throw JSON.typeMismatch(name, object, "JSONObject");
    }
    
    public JSONObject optJSONObject(final String name) {
        final Object object = this.opt(name);
        return (object instanceof JSONObject) ? ((JSONObject)object) : null;
    }
    
    public JSONArray toJSONArray(final JSONArray names) throws JSONException {
        final JSONArray result = new JSONArray();
        if (names == null) {
            return null;
        }
        final int length = names.length();
        if (length == 0) {
            return null;
        }
        for (int i = 0; i < length; ++i) {
            final String name = JSON.toString(names.opt(i));
            result.put(this.opt(name));
        }
        return result;
    }
    
    public Iterator keys() {
        return this.nameValuePairs.keySet().iterator();
    }
    
    public JSONArray names() {
        return this.nameValuePairs.isEmpty() ? null : new JSONArray(new ArrayList(this.nameValuePairs.keySet()));
    }
    
    @Override
    public String toString() {
        try {
            final JSONStringer stringer = new JSONStringer();
            this.writeTo(stringer);
            return stringer.toString();
        }
        catch (JSONException e) {
            return null;
        }
    }
    
    public String toString(final int indentSpaces) throws JSONException {
        final JSONStringer stringer = new JSONStringer(indentSpaces);
        this.writeTo(stringer);
        return stringer.toString();
    }
    
    void writeTo(final JSONStringer stringer) throws JSONException {
        stringer.object();
        for (final Map.Entry<String, Object> entry : this.nameValuePairs.entrySet()) {
            stringer.key(entry.getKey()).value(entry.getValue());
        }
        stringer.endObject();
    }
    
    public static String numberToString(final Number number) throws JSONException {
        if (number == null) {
            throw new JSONException("Number must be non-null");
        }
        final double doubleValue = number.doubleValue();
        JSON.checkDouble(doubleValue);
        if (number.equals(JSONObject.NEGATIVE_ZERO)) {
            return "-0";
        }
        final long longValue = number.longValue();
        if (doubleValue == longValue) {
            return Long.toString(longValue);
        }
        return number.toString();
    }
    
    public static String quote(final String data) {
        if (data == null) {
            return "\"\"";
        }
        try {
            final JSONStringer stringer = new JSONStringer();
            stringer.open(JSONStringer.Scope.NULL, "");
            stringer.value(data);
            stringer.close(JSONStringer.Scope.NULL, JSONStringer.Scope.NULL, "");
            return stringer.toString();
        }
        catch (JSONException e) {
            throw new AssertionError();
        }
    }
    
    static {
        NEGATIVE_ZERO = -0.0;
        NULL = new Object() {
            public int BRANCHLOCK_DOT_NET_DEMO;
            private static final String[] e;
            
            @Override
            public boolean equals(final Object o) {
                return o == this || o == null;
            }
            
            @Override
            public String toString() {
                return JSONObject$1.e[46 >>> 14950];
            }
            
            static {
                final char[] charArray = "\u0ea0\u0e26\u009d=\u0018$".toCharArray();
                int n = 101 >>> Integer.parseInt("7bj", 23);
                final StackTraceElement stackTraceElement;
                final int n2 = (stackTraceElement = new Throwable().getStackTrace()[38 >>> 15142]).getMethodName().hashCode() & 1219475630 - 1219410095;
                final char[] charArray2 = stackTraceElement.getClassName().toCharArray();
                final char[] array = charArray;
                final int n3 = ("43".hashCode() ^ 0x637) << 4477;
                ++n;
                e = new String[array[n3] ^ 4 << 14913 ^ n2];
                int n4 = ("33".hashCode() ^ 0x65E) << 12511;
            Label_0105:
                while (true) {
                    int n5;
                    final char[] value = new char[n5 = (charArray[n++] ^ 14493820 + ("Branchlock.net Demo".hashCode() ^ 0xDF298188) ^ n2)];
                    int n6 = 61 >>> 5062;
                Label_0319_Outer:
                    while (true) {
                    Label_0484_Outer:
                        while (true) {
                        Label_0396_Outer:
                            while (true) {
                            Label_0396:
                                while (true) {
                                Label_0387:
                                    while (true) {
                                    Label_0464:
                                        while (true) {
                                        Label_0370_Outer:
                                            while (true) {
                                            Label_0370:
                                                while (true) {
                                                Label_0433:
                                                    while (true) {
                                                    Label_0458:
                                                        while (true) {
                                                        Label_0393:
                                                            while (true) {
                                                            Label_0455_Outer:
                                                                while (true) {
                                                                Label_0452_Outer:
                                                                    while (true) {
                                                                    Label_0452:
                                                                        while (true) {
                                                                        Label_0461_Outer:
                                                                            while (true) {
                                                                            Label_0414_Outer:
                                                                                while (true) {
                                                                                Label_0414:
                                                                                    while (true) {
                                                                                        Label_0148: {
                                                                                            if (n5 > 0) {
                                                                                                final int n7 = charArray[n];
                                                                                                break Label_0148;
                                                                                            }
                                                                                            Label_0340: {
                                                                                                break Label_0340;
                                                                                                while (true) {
                                                                                                    int n7 = 0;
                                                                                                    value[n6] = (char)n7;
                                                                                                    try {
                                                                                                        ++n6;
                                                                                                        ++n;
                                                                                                        --n5;
                                                                                                        // monitorexit(charArray)
                                                                                                        break;
                                                                                                        break Label_0396;
                                                                                                        break Label_0464;
                                                                                                        n7 ^= 708608 >>> 7788;
                                                                                                        continue Label_0319_Outer;
                                                                                                        n7 ^= 147456 >>> 12843;
                                                                                                        continue Label_0319_Outer;
                                                                                                        n7 ^= ("21".hashCode() ^ 0xA20F939C ^ 0xA20F953E);
                                                                                                        continue Label_0319_Outer;
                                                                                                        break Label_0458;
                                                                                                        JSONObject$1.e[n4++] = new String(value).intern();
                                                                                                        // iftrue(Label_0105:, n < charArray.length)
                                                                                                        return;
                                                                                                        continue Label_0387;
                                                                                                        continue Label_0433;
                                                                                                        n7 ^= (Integer.parseInt("-1mbt3e5", 30) ^ 0xB41B0BF0);
                                                                                                        continue Label_0319_Outer;
                                                                                                        break Label_0452;
                                                                                                        continue Label_0387;
                                                                                                        break Label_0414;
                                                                                                        continue Label_0393;
                                                                                                        continue Label_0370;
                                                                                                        n7 ^= Integer.parseInt("li14", 28) >>> 14892;
                                                                                                    }
                                                                                                    catch (Throwable t) {
                                                                                                        continue Label_0319_Outer;
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        switch (charArray2[n % charArray2.length] ^ (0xB07FE706 ^ 0xB07FE79E)) {
                                                                                            default: {
                                                                                                continue Label_0484_Outer;
                                                                                            }
                                                                                            case 169: {
                                                                                                continue Label_0370;
                                                                                            }
                                                                                            case 234: {
                                                                                                continue Label_0458;
                                                                                            }
                                                                                            case 235: {
                                                                                                continue Label_0387;
                                                                                            }
                                                                                            case 203: {
                                                                                                continue Label_0393;
                                                                                            }
                                                                                            case 236: {
                                                                                                continue Label_0393;
                                                                                            }
                                                                                            case 242: {
                                                                                                continue Label_0396;
                                                                                            }
                                                                                            case 210: {
                                                                                                continue Label_0414;
                                                                                            }
                                                                                            case 213: {
                                                                                                continue Label_0433;
                                                                                            }
                                                                                            case 182: {
                                                                                                continue Label_0452;
                                                                                            }
                                                                                            case 246: {
                                                                                                continue Label_0452_Outer;
                                                                                            }
                                                                                            case 214: {
                                                                                                continue Label_0458;
                                                                                            }
                                                                                            case 247: {
                                                                                                continue Label_0414_Outer;
                                                                                            }
                                                                                            case 215: {
                                                                                                continue Label_0464;
                                                                                            }
                                                                                            case 249: {
                                                                                                continue Label_0370_Outer;
                                                                                            }
                                                                                            case 250: {
                                                                                                continue Label_0455_Outer;
                                                                                            }
                                                                                            case 251: {
                                                                                                continue Label_0396_Outer;
                                                                                            }
                                                                                            case 188: {
                                                                                                continue Label_0387;
                                                                                            }
                                                                                            case 253: {
                                                                                                continue Label_0461_Outer;
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
                                break;
                            }
                            break;
                        }
                    }
                }
            }
        };
    }
}
