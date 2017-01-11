package ru.dolgov.vfs;

import java.io.*;
import java.util.Iterator;


/**
 * M.Dolgov
 * 10.01.2017.
 */
public class VfsImpl implements Vfs{
    private String root;
    private static VfsImpl vfs = null;

    public VfsImpl(String root) {
        this.root = root;
    }

    @Override
    public boolean isExist(String path) {
        return new File(path).exists();
    }

    @Override
    public boolean isDirectory(String path) {
        return new File(path).isDirectory();
    }

    @Override
    public String getAbsolutePath(String path) {
        return new File(path).getAbsolutePath();
    }

    @Override
    public byte[] getBytes(String path) throws IOException, FileNotFoundException{
        byte[] bytes = new byte[128];
        FileInputStream fis = new FileInputStream(path);
        fis.read(bytes);
        fis.close();
        return bytes;
    }

    @Override
    public String getUtf8Text(String path) throws IOException{
        FileInputStream fis = new FileInputStream(path);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        StringBuilder sb = new StringBuilder();
        int symbol;
        do {
            symbol = isr.read();
            if (symbol != -1) {
                sb.append((char) symbol);
            }
        } while (symbol != -1);
        isr.close();
        return sb.toString();
    }

    @Override
    public Iterator<String> getIterator(String startDir) {
        return new FileIterator(startDir);
    }
}
