package ru.dolgov.vfs;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * M.Dolgov
 * 10.01.2017.
 */
public class FileIterator implements Iterator<String> {
    private Queue<File> files = new LinkedList<File>();

    public FileIterator(String path) {
        this.files.add(new File(path));
    }

    @Override
    public boolean hasNext() {
        return !files.isEmpty();
    }

    @Override
    public String next() {
        File file = files.peek();
        if (file.isDirectory()){
            for (File subFile: file.listFiles()) {
                files.add(subFile);
            }
        }
        return files.poll().getAbsolutePath();
    }
}
