package DecoratorDesignPattern.IODecorator;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class UpperCaseInputStream extends FilterInputStream {

    protected UpperCaseInputStream(InputStream in) {
        super(in);
    }

    public int read() throws IOException {
        int c = in.read();
        return (c == -1) ? c : Character.toUpperCase(c);
    }

    public int read(byte [] b, int offset, int len) throws IOException {
        int result = in.read(b, offset, len);
        for(int i = offset; i < offset + result; i++) {
            b[i] = (byte) Character.toUpperCase((char) b[i]);
        }
        return result;
    }
    
}
