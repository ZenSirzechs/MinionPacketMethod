// 
// Decompiled by Procyon v0.5.36
// 

package Macro.json;

public class JSON
{
    public String BRANCHLOCK_DOT_NET_DEMO = "Obfuscated using a demo version of branchlock 3.0.10!";
    private static final String[] S;
    
    static double checkDouble(final double d) throws JSONException {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new JSONException("Forbidden numeric value: " + d);
        }
        return d;
    }
    
    static Boolean toBoolean(final Object value) {
        if (value instanceof Boolean) {
            return (Boolean)value;
        }
        if (value instanceof String) {
            return Boolean.valueOf((String)value);
        }
        return null;
    }
    
    static Double toDouble(final Object value) {
        if (value instanceof Double) {
            return (Double)value;
        }
        if (value instanceof Number) {
            return ((Number)value).doubleValue();
        }
        if (value instanceof String) {
            try {
                return Double.valueOf((String)value);
            }
            catch (NumberFormatException ex) {}
        }
        return null;
    }
    
    static Integer toInteger(final Object value) {
        if (value instanceof Integer) {
            return (Integer)value;
        }
        if (value instanceof Number) {
            return ((Number)value).intValue();
        }
        if (value instanceof String) {
            try {
                return (int)Double.parseDouble((String)value);
            }
            catch (NumberFormatException ex) {}
        }
        return null;
    }
    
    static Long toLong(final Object value) {
        if (value instanceof Long) {
            return (Long)value;
        }
        if (value instanceof Number) {
            return ((Number)value).longValue();
        }
        if (value instanceof String) {
            try {
                return (long)Double.parseDouble((String)value);
            }
            catch (NumberFormatException ex) {}
        }
        return null;
    }
    
    static String toString(final Object value) {
        if (value instanceof String) {
            return (String)value;
        }
        if (value != null) {
            return String.valueOf(value);
        }
        return null;
    }
    
    public static JSONException typeMismatch(final Object indexOrName, final Object actual, final String requiredType) throws JSONException {
        if (actual == null) {
            throw new JSONException("Value at " + indexOrName + " is null.");
        }
        throw new JSONException("Value " + actual + " at " + indexOrName + " of type " + actual.getClass().getName() + " cannot be converted to " + requiredType);
    }
    
    public static JSONException typeMismatch(final Object actual, final String requiredType) throws JSONException {
        if (actual == null) {
            throw new JSONException(JSON.S[805306368 >>> 5052]);
        }
        throw new JSONException(JSON.S[106 >>> Integer.parseInt("n87", 24)] + actual + JSON.S[64 >>> 3526] + actual.getClass().getName() + JSON.S[64 >>> 15077] + requiredType);
    }
    
    static {
        final char[] charArray = "\u0e55\u0eb4\u00dbOµ¬¼\u00f9\u0ebb\u00d9¶¿\u00d9\u00ad0\u0089,\u00ad\u0eaa\u00f9º¸··\u0096\u00ad\u00f9\u009b¼i\u009a&\u00e3X¼«\u00ad¼½\u00d9\u00ad¶\u00d9\u0ebc\u001f\u0098%\u00f8K\u00f9°ª\u00f9·\u008cµµ\u00d7".toCharArray();
        int n = 86 << 14335;
        final StackTraceElement stackTraceElement;
        final int n2 = (stackTraceElement = new Throwable().getStackTrace()[61 >>> Integer.parseInt("1a4e", 22)]).getMethodName().hashCode() & 65535 << 6560;
        final char[] charArray2 = stackTraceElement.getClassName().toCharArray();
        final char[] array = charArray;
        final int n3 = 120 << Integer.parseInt("18cc", 21);
        ++n;
        S = new String[array[n3] ^ Integer.parseInt("v00", 32) >>> ("Branchlock.net Demo".hashCode() ^ 0x200B7980) ^ n2];
        int n4 = 49 >>> 7110;
    Label_0107:
        while (true) {
            int n5;
            final char[] value = new char[n5 = (charArray[n++] ^ Integer.parseInt("eq9t", 31) >>> 4014 ^ n2)];
            int n6 = 89 >>> 3495;
        Label_0356_Outer:
            while (true) {
                Label_0313: {
                    if (n5 <= 0) {
                        break Label_0313;
                    }
                    int n7 = charArray[n];
                Label_0356:
                    while (true) {
                    Label_0389:
                        while (true) {
                        Label_0405:
                            while (true) {
                                Label_0420: {
                                    switch (charArray2[n % charArray2.length] ^ ("Branchlock.net Demo".hashCode() ^ 0x200B5980) << Integer.parseInt("1oc", 30)) {
                                        case 100: {
                                            break Label_0356;
                                        }
                                        case 102: {
                                            break Label_0356;
                                        }
                                        case 104: {
                                            break Label_0389;
                                        }
                                        case 72: {
                                            break Label_0389;
                                        }
                                        case 41: {
                                            break Label_0389;
                                        }
                                        case 105: {
                                            break Label_0389;
                                        }
                                        case 73: {
                                            break Label_0405;
                                        }
                                        case 74: {
                                            break Label_0405;
                                        }
                                        case 109: {
                                            break Label_0389;
                                        }
                                        case 77: {
                                            break Label_0420;
                                        }
                                        case 116: {
                                            break Label_0420;
                                        }
                                        case 84: {
                                            break Label_0420;
                                        }
                                        case 117: {
                                            break Label_0420;
                                        }
                                    }
                                    while (true) {
                                        value[n6] = (char)n7;
                                        try {
                                            ++n6;
                                            ++n;
                                            --n5;
                                            // monitorexit(charArray2)
                                            n7 ^= 368 >>> ("Branchlock.net Demo".hashCode() ^ 0x200B67E4);
                                            continue Label_0356_Outer;
                                            JSON.S[n4++] = new String(value).intern();
                                            // iftrue(Label_0107:, n < charArray.length)
                                            return;
                                            n7 ^= 73 << 1760;
                                            continue Label_0356_Outer;
                                            break Label_0420;
                                            n7 ^= 1945942154 - 1945941905;
                                            continue Label_0356_Outer;
                                            continue Label_0389;
                                            break Label_0389;
                                            continue Label_0356;
                                            n7 ^= -307426713 + 307426854;
                                            continue Label_0356_Outer;
                                            n7 ^= -845145279 + 845145496;
                                            continue Label_0356_Outer;
                                            continue Label_0405;
                                        }
                                        catch (Exception ex) {
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
