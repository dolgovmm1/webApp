package ru.dolgov.vfs;

import java.io.IOException;
import java.util.Iterator;

/**
 * M.Dolgov
 * 10.01.2017.
 */
public interface Vfs {

    boolean isExist(String path);

    boolean isDirectory(String path);

    String getAbsolutePath(String path);

    byte[] getBytes(String path) throws IOException;

    String getUtf8Text(String path) throws IOException;

    Iterator<String> getIterator(String startDir);
}
