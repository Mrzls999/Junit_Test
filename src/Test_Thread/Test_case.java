package Test_Thread;

import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 创建两个线程
 * 线程①：统计指定目录下文件的个数及所占空间数
 * 线程②：打印此目录下每个文件的名称和大小
 */
public class Test_case {
    public static void main(String[] args) {
        Case1 case1 = new Case1();
        case1.start();
        Case2 case2 = new Case2();
        case2.start();
    }
}

/**
 * 线程①：统计指定目录下文件的个数及所占空间数
 */
class Case1 extends Thread {
    int count = 0;//记录文件个数
    Long size = 0L;//记录所占空间数
    String path = "E:\\pro\\IDEAJavaProject\\tt\\t2";

    public void run() {
        get_Count_Size(path);
        System.out.println(count + "===" + size);
    }

    public void get_Count_Size(String path) {
        File file = new File(path);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File listFile : listFiles) {
                    if (listFile.isFile()) {
                        count++;
                        size += listFile.length();
                    } else {
                        get_Count_Size(listFile.getPath());
                    }
                }
            }
        }
    }
}

/**
 * 线程②：打印此目录下每个文件的名称和大小
 */
class Case2 extends Thread {
    Map<String, Long> fileMap = new HashMap<>();//记录所占空间数
    String path = "E:\\pro\\IDEAJavaProject\\tt\\t2";
    Long size = 0L;

    public void run() {
        get_Name_Size(path);
        System.out.println(fileMap);
    }

    /**
     * 得到 文件(或文件夹)名:文件大小
     * @param path
     */
    public void get_Name_Size(String path) {
        File file = new File(path);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File listFile : listFiles) {
                    size = 0L;
                    fileMap.put(listFile.getName(), get_Size(listFile.getPath()));//名称大小
                }
            }else {
                size = 0L;
                fileMap.put(file.getName(), get_Size(file.getPath()));//名称大小
            }
        }
    }

    /**
     * 得到某个目录的大小
     * @param path 目标路径
     * @return  目录的大小
     */
    public Long get_Size(String path) {
        File file = new File(path);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File listFile : listFiles) {
                    if (listFile.isFile()) {
                        size += listFile.length();
                    } else {
                        get_Size(listFile.getPath());
                    }
                }
            }else {
                size += file.length();
            }
        }
        return size;
    }
}