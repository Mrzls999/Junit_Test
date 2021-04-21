package Test_File;

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class Test_ListFiles {
    @Test
    public void test_ListFiles() {
        File file = new File("d:/normal");
        File[] files = file.listFiles();
        if (files != null) {
            for (File file1 : files) {
                System.out.println(file1.getName());
            }
        }
    }

    @Test
    public void test_ListFiles_FilenameFilter() {
        File file = new File("d:/normal");
        File[] files = file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.contains("s");
            }
        });
        if (files != null) {
            for (File file1 : files) {
                System.out.println(file1.getName());
            }
        }
    }

    @Test
    public void test_ListFiles_FileFilter() {
        File file = new File("d:/normal/Youku/YoukuClient1");
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.length() < 100;
            }
        });
        if (files != null) {
            for (File file1 : files) {
                System.out.println(file1.getName());
            }
        }
    }
}
