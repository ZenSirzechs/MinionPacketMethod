// 
// Decompiled by Procyon v0.5.36
// 

package Macro.json;

import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

public class JSONArray
{
    private final List<Object> values;
    public int BRANCHLOCK_DOT_NET_DEMO;
    private static final String[] d;
    
    public JSONArray() {
        this.values = new ArrayList<Object>();
    }
    
    public JSONArray(final Collection copyFrom) {
        this();
        final Collection<?> copyFromTyped = (Collection<?>)copyFrom;
        this.values.addAll(copyFromTyped);
    }
    
    public JSONArray(final JSONTokener readFrom) throws JSONException {
        final Object object = readFrom.nextValue();
        if (object instanceof JSONArray) {
            this.values = ((JSONArray)object).values;
            return;
        }
        throw JSON.typeMismatch(object, "JSONArray");
    }
    
    public JSONArray(final String json) throws JSONException {
        this(new JSONTokener(json));
    }
    
    public int length() {
        return this.values.size();
    }
    
    public JSONArray put(final boolean value) {
        this.values.add(value);
        return this;
    }
    
    public JSONArray put(final double value) throws JSONException {
        this.values.add(JSON.checkDouble(value));
        return this;
    }
    
    public JSONArray put(final int value) {
        this.values.add(value);
        return this;
    }
    
    public JSONArray put(final long value) {
        this.values.add(value);
        return this;
    }
    
    public JSONArray put(final Object value) {
        this.values.add(value);
        return this;
    }
    
    public JSONArray put(final int index, final boolean value) throws JSONException {
        return this.put(index, (Object)value);
    }
    
    public JSONArray put(final int index, final double value) throws JSONException {
        return this.put(index, (Object)value);
    }
    
    public JSONArray put(final int index, final int value) throws JSONException {
        return this.put(index, (Object)value);
    }
    
    public JSONArray put(final int index, final long value) throws JSONException {
        return this.put(index, (Object)value);
    }
    
    public JSONArray put(final int index, final Object value) throws JSONException {
        if (value instanceof Number) {
            JSON.checkDouble(((Number)value).doubleValue());
        }
        while (this.values.size() <= index) {
            this.values.add(null);
        }
        this.values.set(index, value);
        return this;
    }
    
    public boolean isNull(final int index) {
        final Object value = this.opt(index);
        return value == null || value == JSONObject.NULL;
    }
    
    public Object get(final int index) throws JSONException {
        try {
            final Object value = this.values.get(index);
            if (value == null) {
                throw new JSONException("Value at " + index + " is null.");
            }
            return value;
        }
        catch (IndexOutOfBoundsException e) {
            throw new JSONException("Index " + index + " out of range [0.." + this.values.size() + ")");
        }
    }
    
    public Object opt(final int index) {
        if (index < 0 || index >= this.values.size()) {
            return null;
        }
        return this.values.get(index);
    }
    
    public boolean getBoolean(final int index) throws JSONException {
        final Object object = this.get(index);
        final Boolean result = JSON.toBoolean(object);
        if (result == null) {
            throw JSON.typeMismatch(index, object, "boolean");
        }
        return result;
    }
    
    public boolean optBoolean(final int index) {
        return this.optBoolean(index, false);
    }
    
    public boolean optBoolean(final int index, final boolean fallback) {
        final Object object = this.opt(index);
        final Boolean result = JSON.toBoolean(object);
        return (result != null) ? result : fallback;
    }
    
    public double getDouble(final int index) throws JSONException {
        final Object object = this.get(index);
        final Double result = JSON.toDouble(object);
        if (result == null) {
            throw JSON.typeMismatch(index, object, "double");
        }
        return result;
    }
    
    public double optDouble(final int index) {
        return this.optDouble(index, Double.NaN);
    }
    
    public double optDouble(final int index, final double fallback) {
        final Object object = this.opt(index);
        final Double result = JSON.toDouble(object);
        return (result != null) ? result : fallback;
    }
    
    public int getInt(final int index) throws JSONException {
        final Object object = this.get(index);
        final Integer result = JSON.toInteger(object);
        if (result == null) {
            throw JSON.typeMismatch(index, object, "int");
        }
        return result;
    }
    
    public int optInt(final int index) {
        return this.optInt(index, 0);
    }
    
    public int optInt(final int index, final int fallback) {
        final Object object = this.opt(index);
        final Integer result = JSON.toInteger(object);
        return (result != null) ? result : fallback;
    }
    
    public long getLong(final int index) throws JSONException {
        final Object object = this.get(index);
        final Long result = JSON.toLong(object);
        if (result == null) {
            throw JSON.typeMismatch(index, object, JSONArray.d[2 << 12287]);
        }
        return result;
    }
    
    public long optLong(final int index) {
        return this.optLong(index, 0L);
    }
    
    public long optLong(final int index, final long fallback) {
        final Object object = this.opt(index);
        final Long result = JSON.toLong(object);
        return (result != null) ? result : fallback;
    }
    
    public String getString(final int index) throws JSONException {
        final Object object = this.get(index);
        final String result = JSON.toString(object);
        if (result == null) {
            throw JSON.typeMismatch(index, object, "String");
        }
        return result;
    }
    
    public String optString(final int index) {
        return this.optString(index, "");
    }
    
    public String optString(final int index, final String fallback) {
        final Object object = this.opt(index);
        final String result = JSON.toString(object);
        return (result != null) ? result : fallback;
    }
    
    public JSONArray getJSONArray(final int index) throws JSONException {
        final Object object = this.get(index);
        if (object instanceof JSONArray) {
            return (JSONArray)object;
        }
        throw JSON.typeMismatch(index, object, "JSONArray");
    }
    
    public JSONArray optJSONArray(final int index) {
        final Object object = this.opt(index);
        return (object instanceof JSONArray) ? ((JSONArray)object) : null;
    }
    
    public JSONObject getJSONObject(final int index) throws JSONException {
        final Object object = this.get(index);
        if (object instanceof JSONObject) {
            return (JSONObject)object;
        }
        throw JSON.typeMismatch(index, object, "JSONObject");
    }
    
    public JSONObject optJSONObject(final int index) {
        final Object object = this.opt(index);
        return (object instanceof JSONObject) ? ((JSONObject)object) : null;
    }
    
    public JSONObject toJSONObject(final JSONArray names) throws JSONException {
        final JSONObject result = new JSONObject();
        final int length = Math.min(names.length(), this.values.size());
        if (length == 0) {
            return null;
        }
        for (int i = 0; i < length; ++i) {
            final String name = JSON.toString(names.opt(i));
            result.put(name, this.opt(i));
        }
        return result;
    }
    
    public String join(final String separator) throws JSONException {
        final JSONStringer stringer = new JSONStringer();
        stringer.open(JSONStringer.Scope.NULL, "");
        for (int i = 0, size = this.values.size(); i < size; ++i) {
            if (i > 0) {
                stringer.out.append(separator);
            }
            stringer.value(this.values.get(i));
        }
        stringer.close(JSONStringer.Scope.NULL, JSONStringer.Scope.NULL, "");
        return stringer.out.toString();
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
        stringer.array();
        for (final Object value : this.values) {
            stringer.value(value);
        }
        stringer.endArray();
    }
    
    @Override
    public boolean equals(final Object o) {
        return o instanceof JSONArray && ((JSONArray)o).values.equals(this.values);
    }
    
    @Override
    public int hashCode() {
        return this.values.hashCode();
    }
    
    static {
        final char[] charArray = "\u0ec2\u0e2fq^T(".toCharArray();
        int n = 15 >>> Integer.parseInt("h6k", 24);
        final StackTraceElement stackTraceElement;
        final int n2 = (stackTraceElement = new Throwable().getStackTrace()[37 >>> 1766]).getMethodName().hashCode() & ("Branchlock.net Demo".hashCode() ^ 0x200BA678) << Integer.parseInt("c0k", 25);
        final char[] charArray2 = stackTraceElement.getClassName().toCharArray();
        final char[] array = charArray;
        final int n3 = 20 << 4926;
        ++n;
        d = new String[array[n3] ^ 53 << 3649 ^ n2];
        int n4 = ("66".hashCode() ^ 0x69A) >>> 7623;
    Label_0116:
        while (true) {
            int n5;
            final char[] value = new char[n5 = (charArray[n++] ^ -373974905 + 373975035 ^ n2)];
            int n6 = 18 << 511;
        Label_0376_Outer:
            while (true) {
                Label_0332: {
                    if (n5 <= 0) {
                        break Label_0332;
                    }
                    int n7 = charArray[n];
                Label_0376:
                    while (true) {
                    Label_0396:
                        while (true) {
                        Label_0413:
                            while (true) {
                            Label_0431:
                                while (true) {
                                Label_0463:
                                    while (true) {
                                        Label_0466: {
                                            switch (charArray2[n % charArray2.length] ^ Integer.parseInt("1s", 31) << 14337) {
                                                case 4: {
                                                    break Label_0376;
                                                }
                                                case 5: {
                                                    break Label_0376;
                                                }
                                                case 37: {
                                                    break Label_0396;
                                                }
                                                case 15: {
                                                    break Label_0413;
                                                }
                                                case 21: {
                                                    break Label_0413;
                                                }
                                                case 23: {
                                                    break Label_0431;
                                                }
                                                case 55: {
                                                    break Label_0431;
                                                }
                                                case 88: {
                                                    break Label_0463;
                                                }
                                                case 24: {
                                                    break Label_0463;
                                                }
                                                case 56: {
                                                    break Label_0466;
                                                }
                                                case 25: {
                                                    break Label_0466;
                                                }
                                                case 57: {
                                                    break Label_0466;
                                                }
                                                case 59: {
                                                    break Label_0463;
                                                }
                                                case 28: {
                                                    break Label_0463;
                                                }
                                                case 60: {
                                                    break Label_0466;
                                                }
                                            }
                                            while (true) {
                                                value[n6] = (char)n7;
                                                try {
                                                    ++n6;
                                                    ++n;
                                                    --n5;
                                                    // monitorexit(charArray)
                                                    n7 ^= 29 << 7840;
                                                    continue Label_0376_Outer;
                                                    break Label_0463;
                                                    break Label_0466;
                                                    JSONArray.d[n4++] = new String(value).intern();
                                                    // iftrue(Label_0116:, n < charArray.length)
                                                    return;
                                                    n7 ^= Integer.parseInt("4u00", 32) >>> 4587;
                                                    continue Label_0376_Outer;
                                                    break Label_0413;
                                                    continue Label_0396;
                                                    continue Label_0463;
                                                    n7 ^= (0x4306A689 ^ 0x4306A604);
                                                    continue Label_0376_Outer;
                                                    continue Label_0376;
                                                    continue Label_0413;
                                                    continue Label_0431;
                                                    n7 ^= 49 << 4736;
                                                    continue Label_0376_Outer;
                                                    n7 ^= 29 << 8737;
                                                    continue Label_0376_Outer;
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
