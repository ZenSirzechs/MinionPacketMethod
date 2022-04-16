// 
// Decompiled by Procyon v0.5.36
// 

package Macro.json;

public class JSONTokener
{
    public int BRANCHLOCK_DOT_NET_DEMO;
    private final String in;
    private int pos;
    
    public JSONTokener(final String in) {
        this.in = in;
    }
    
    public Object nextValue() throws JSONException {
        final int c = this.nextCleanInternal();
        switch (c) {
            case -1: {
                throw this.syntaxError("End of input");
            }
            case 123: {
                return this.readObject();
            }
            case 91: {
                return this.readArray();
            }
            case 34:
            case 39: {
                return this.nextString((char)c);
            }
            default: {
                --this.pos;
                return this.readLiteral();
            }
        }
    }
    
    private int nextCleanInternal() throws JSONException {
        while (this.pos < this.in.length()) {
            final int c = this.in.charAt(this.pos++);
            switch (c) {
                case 9:
                case 10:
                case 13:
                case 32: {
                    continue;
                }
                case 47: {
                    if (this.pos == this.in.length()) {
                        return c;
                    }
                    final char peek = this.in.charAt(this.pos);
                    if (peek != '*' && peek != '/') {
                        return c;
                    }
                    this.skipComment();
                    continue;
                }
                default: {
                    return c;
                }
            }
        }
        return -1;
    }
    
    private void skipComment() throws JSONException {
        if (this.in.charAt(this.pos++) == '*') {
            final int commentEnd = this.in.indexOf("*/", this.pos);
            if (commentEnd == -1) {
                throw this.syntaxError("Unterminated comment");
            }
            this.pos = commentEnd + 2;
        }
        else {
            while (this.pos < this.in.length()) {
                final char c = this.in.charAt(this.pos);
                if (c == '\r' || c == '\n') {
                    ++this.pos;
                    break;
                }
                ++this.pos;
            }
        }
    }
    
    public String nextString(final char quote) throws JSONException {
        StringBuilder builder = null;
        int start = this.pos;
        while (this.pos < this.in.length()) {
            final int c = this.in.charAt(this.pos++);
            if (c == quote) {
                if (builder == null) {
                    return new String(this.in.substring(start, this.pos - 1));
                }
                builder.append(this.in, start, this.pos - 1);
                return builder.toString();
            }
            else {
                if (c != 92) {
                    continue;
                }
                if (this.pos == this.in.length()) {
                    throw this.syntaxError("Unterminated escape sequence");
                }
                if (builder == null) {
                    builder = new StringBuilder();
                }
                builder.append(this.in, start, this.pos - 1);
                builder.append(this.readEscapeCharacter());
                start = this.pos;
            }
        }
        throw this.syntaxError("Unterminated string");
    }
    
    private char readEscapeCharacter() throws JSONException {
        final char escaped = this.in.charAt(this.pos++);
        switch (escaped) {
            case 'u': {
                if (this.pos + 4 > this.in.length()) {
                    throw this.syntaxError("Unterminated escape sequence");
                }
                final String hex = this.in.substring(this.pos, this.pos + 4);
                this.pos += 4;
                return (char)Integer.parseInt(hex, 16);
            }
            case 't': {
                return '\t';
            }
            case 'b': {
                return '\b';
            }
            case 'n': {
                return '\n';
            }
            case 'r': {
                return '\r';
            }
            case 'f': {
                return '\f';
            }
            default: {
                return escaped;
            }
        }
    }
    
    private Object readLiteral() throws JSONException {
        final String literal = this.nextToInternal("{}[]/\\:,=;# \t\f");
        if (literal.length() == 0) {
            throw this.syntaxError("Expected literal value");
        }
        if ("null".equalsIgnoreCase(literal)) {
            return JSONObject.NULL;
        }
        if ("true".equalsIgnoreCase(literal)) {
            return Boolean.TRUE;
        }
        if ("false".equalsIgnoreCase(literal)) {
            return Boolean.FALSE;
        }
        if (literal.indexOf(46) == -1) {
            int base = 10;
            String number = literal;
            if (number.startsWith("0x") || number.startsWith("0X")) {
                number = number.substring(2);
                base = 16;
            }
            else if (number.startsWith("0") && number.length() > 1) {
                number = number.substring(1);
                base = 8;
            }
            try {
                final long longValue = Long.parseLong(number, base);
                if (longValue <= 2147483647L && longValue >= -2147483648L) {
                    return (int)longValue;
                }
                return longValue;
            }
            catch (NumberFormatException ex) {}
        }
        try {
            return Double.valueOf(literal);
        }
        catch (NumberFormatException ex2) {
            return new String(literal);
        }
    }
    
    private String nextToInternal(final String excluded) {
        final int start = this.pos;
        while (this.pos < this.in.length()) {
            final char c = this.in.charAt(this.pos);
            if (c == '\r' || c == '\n' || excluded.indexOf(c) != -1) {
                return this.in.substring(start, this.pos);
            }
            ++this.pos;
        }
        return this.in.substring(start);
    }
    
    private JSONObject readObject() throws JSONException {
        final JSONObject result = new JSONObject();
        final int first = this.nextCleanInternal();
        if (first == 125) {
            return result;
        }
        if (first != -1) {
            --this.pos;
        }
        while (true) {
            final Object name = this.nextValue();
            if (!(name instanceof String)) {
                if (name == null) {
                    throw this.syntaxError("Names cannot be null");
                }
                throw this.syntaxError("Names must be strings, but " + name + " is of type " + name.getClass().getName());
            }
            else {
                final int separator = this.nextCleanInternal();
                if (separator != 58 && separator != 61) {
                    throw this.syntaxError("Expected ':' after " + name);
                }
                if (this.pos < this.in.length() && this.in.charAt(this.pos) == '>') {
                    ++this.pos;
                }
                result.put((String)name, this.nextValue());
                switch (this.nextCleanInternal()) {
                    case 125: {
                        return result;
                    }
                    case 44:
                    case 59: {
                        continue;
                    }
                    default: {
                        throw this.syntaxError("Unterminated object");
                    }
                }
            }
        }
    }
    
    private JSONArray readArray() throws JSONException {
        final JSONArray result = new JSONArray();
        boolean hasTrailingSeparator = false;
        while (true) {
            switch (this.nextCleanInternal()) {
                case -1: {
                    throw this.syntaxError("Unterminated array");
                }
                case 93: {
                    if (hasTrailingSeparator) {
                        result.put(null);
                    }
                    return result;
                }
                case 44:
                case 59: {
                    result.put(null);
                    hasTrailingSeparator = true;
                    continue;
                }
                default: {
                    --this.pos;
                    result.put(this.nextValue());
                    switch (this.nextCleanInternal()) {
                        case 93: {
                            return result;
                        }
                        case 44:
                        case 59: {
                            hasTrailingSeparator = true;
                            continue;
                        }
                        default: {
                            throw this.syntaxError("Unterminated array");
                        }
                    }
                    break;
                }
            }
        }
    }
    
    public JSONException syntaxError(final String message) {
        return new JSONException(message + this);
    }
    
    @Override
    public String toString() {
        return " at character " + this.pos + " of " + this.in;
    }
    
    public boolean more() {
        return this.pos < this.in.length();
    }
    
    public char next() {
        return (this.pos < this.in.length()) ? this.in.charAt(this.pos++) : '\0';
    }
    
    public char next(final char c) throws JSONException {
        final char result = this.next();
        if (result != c) {
            throw this.syntaxError("Expected " + c + " but was " + result);
        }
        return result;
    }
    
    public char nextClean() throws JSONException {
        final int nextCleanInt = this.nextCleanInternal();
        return (nextCleanInt == -1) ? '\0' : ((char)nextCleanInt);
    }
    
    public String next(final int length) throws JSONException {
        if (this.pos + length > this.in.length()) {
            throw this.syntaxError(length + " is out of bounds");
        }
        final String result = this.in.substring(this.pos, this.pos + length);
        this.pos += length;
        return result;
    }
    
    public String nextTo(final String excluded) {
        if (excluded == null) {
            throw new NullPointerException();
        }
        return this.nextToInternal(excluded).trim();
    }
    
    public String nextTo(final char excluded) {
        return this.nextToInternal(String.valueOf(excluded)).trim();
    }
    
    public void skipPast(final String thru) {
        final int thruStart = this.in.indexOf(thru, this.pos);
        this.pos = ((thruStart == -1) ? this.in.length() : (thruStart + thru.length()));
    }
    
    public char skipTo(final char to) {
        final int index = this.in.indexOf(to, this.pos);
        if (index != -1) {
            this.pos = index;
            return to;
        }
        return '\0';
    }
    
    public void back() {
        final int pos = this.pos - 1;
        this.pos = pos;
        if (pos == -1) {
            this.pos = 0;
        }
    }
    
    public static int dehexchar(final char hex) {
        if (hex >= '0' && hex <= '9') {
            return hex - '0';
        }
        if (hex >= 'A' && hex <= 'F') {
            return hex - 'A' + 10;
        }
        if (hex >= 'a' && hex <= 'f') {
            return hex - 'a' + 10;
        }
        return -1;
    }
}
