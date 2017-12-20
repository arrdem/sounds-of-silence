package me.arrdem.silence;

import java.io.IOException;
import java.io.Writer;

public class ErrorWriter extends Writer {
    public ErrorWriter() {

    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        throw new IOException("ErrorWriters don't actually write!");
    }

    @Override
    public void flush() throws IOException {

    }

    @Override
    public void close() throws IOException {

    }
}
