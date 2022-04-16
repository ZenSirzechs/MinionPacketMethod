// 
// Decompiled by Procyon v0.5.36
// 

package Macro.json;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class JSONStringer
{
    public int BRANCHLOCK_DOT_NET_DEMO;
    final StringBuilder out;
    private final List<Scope> stack;
    private final String indent;
    
    public JSONStringer() {
        this.out = new StringBuilder();
        this.stack = new ArrayList<Scope>();
        this.indent = null;
    }
    
    JSONStringer(final int indentSpaces) {
        this.out = new StringBuilder();
        this.stack = new ArrayList<Scope>();
        final char[] indentChars = new char[indentSpaces];
        Arrays.fill(indentChars, ' ');
        this.indent = new String(indentChars);
    }
    
    public JSONStringer array() throws JSONException {
        return this.open(Scope.EMPTY_ARRAY, "[");
    }
    
    public JSONStringer endArray() throws JSONException {
        return this.close(Scope.EMPTY_ARRAY, Scope.NONEMPTY_ARRAY, "]");
    }
    
    public JSONStringer object() throws JSONException {
        return this.open(Scope.EMPTY_OBJECT, "{");
    }
    
    public JSONStringer endObject() throws JSONException {
        return this.close(Scope.EMPTY_OBJECT, Scope.NONEMPTY_OBJECT, "}");
    }
    
    JSONStringer open(final Scope empty, final String openBracket) throws JSONException {
        if (this.stack.isEmpty() && this.out.length() > 0) {
            throw new JSONException("Nesting problem: multiple top-level roots");
        }
        this.beforeValue();
        this.stack.add(empty);
        this.out.append(openBracket);
        return this;
    }
    
    JSONStringer close(final Scope empty, final Scope nonempty, final String closeBracket) throws JSONException {
        final Scope context = this.peek();
        if (context != nonempty && context != empty) {
            throw new JSONException("Nesting problem");
        }
        this.stack.remove(this.stack.size() - 1);
        if (context == nonempty) {
            this.newline();
        }
        this.out.append(closeBracket);
        return this;
    }
    
    private Scope peek() throws JSONException {
        if (this.stack.isEmpty()) {
            throw new JSONException("Nesting problem");
        }
        return this.stack.get(this.stack.size() - 1);
    }
    
    private void replaceTop(final Scope topOfStack) {
        this.stack.set(this.stack.size() - 1, topOfStack);
    }
    
    public JSONStringer value(final Object value) throws JSONException {
        if (this.stack.isEmpty()) {
            throw new JSONException("Nesting problem");
        }
        if (value instanceof JSONArray) {
            ((JSONArray)value).writeTo(this);
            return this;
        }
        if (value instanceof JSONObject) {
            ((JSONObject)value).writeTo(this);
            return this;
        }
        this.beforeValue();
        if (value == null || value instanceof Boolean || value == JSONObject.NULL) {
            this.out.append(value);
        }
        else if (value instanceof Number) {
            this.out.append(JSONObject.numberToString((Number)value));
        }
        else {
            this.string(value.toString());
        }
        return this;
    }
    
    public JSONStringer value(final boolean value) throws JSONException {
        if (this.stack.isEmpty()) {
            throw new JSONException("Nesting problem");
        }
        this.beforeValue();
        this.out.append(value);
        return this;
    }
    
    public JSONStringer value(final double value) throws JSONException {
        if (this.stack.isEmpty()) {
            throw new JSONException("Nesting problem");
        }
        this.beforeValue();
        this.out.append(JSONObject.numberToString(value));
        return this;
    }
    
    public JSONStringer value(final long value) throws JSONException {
        if (this.stack.isEmpty()) {
            throw new JSONException("Nesting problem");
        }
        this.beforeValue();
        this.out.append(value);
        return this;
    }
    
    private void string(final String value) {
        this.out.append("\"");
        for (int i = 0, length = value.length(); i < length; ++i) {
            final char c = value.charAt(i);
            switch (c) {
                case '\"':
                case '/':
                case '\\': {
                    this.out.append('\\').append(c);
                    break;
                }
                case '\t': {
                    this.out.append("\\t");
                    break;
                }
                case '\b': {
                    this.out.append("\\b");
                    break;
                }
                case '\n': {
                    this.out.append("\\n");
                    break;
                }
                case '\r': {
                    this.out.append("\\r");
                    break;
                }
                case '\f': {
                    this.out.append("\\f");
                    break;
                }
                default: {
                    if (c <= '\u001f') {
                        this.out.append(String.format("\\u%04x", (int)c));
                        break;
                    }
                    this.out.append(c);
                    break;
                }
            }
        }
        this.out.append("\"");
    }
    
    private void newline() {
        if (this.indent == null) {
            return;
        }
        this.out.append("\n");
        for (int i = 0; i < this.stack.size(); ++i) {
            this.out.append(this.indent);
        }
    }
    
    public JSONStringer key(final String name) throws JSONException {
        if (name == null) {
            throw new JSONException("Names must be non-null");
        }
        this.beforeKey();
        this.string(name);
        return this;
    }
    
    private void beforeKey() throws JSONException {
        final Scope context = this.peek();
        if (context == Scope.NONEMPTY_OBJECT) {
            this.out.append(',');
        }
        else if (context != Scope.EMPTY_OBJECT) {
            throw new JSONException("Nesting problem");
        }
        this.newline();
        this.replaceTop(Scope.DANGLING_KEY);
    }
    
    private void beforeValue() throws JSONException {
        if (this.stack.isEmpty()) {
            return;
        }
        final Scope context = this.peek();
        if (context == Scope.EMPTY_ARRAY) {
            this.replaceTop(Scope.NONEMPTY_ARRAY);
            this.newline();
        }
        else if (context == Scope.NONEMPTY_ARRAY) {
            this.out.append(',');
            this.newline();
        }
        else if (context == Scope.DANGLING_KEY) {
            this.out.append((this.indent == null) ? ":" : ": ");
            this.replaceTop(Scope.NONEMPTY_OBJECT);
        }
        else if (context != Scope.NULL) {
            throw new JSONException("Nesting problem");
        }
    }
    
    @Override
    public String toString() {
        return (this.out.length() == 0) ? null : this.out.toString();
    }
    
    enum Scope
    {
        EMPTY_ARRAY, 
        NONEMPTY_ARRAY, 
        EMPTY_OBJECT, 
        DANGLING_KEY, 
        NONEMPTY_OBJECT, 
        NULL;
    }
}
