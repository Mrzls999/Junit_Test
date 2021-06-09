package javaSe.little_case3_IO;

import java.io.FileReader;
import java.io.IOException;

/**
 * operation1:读取TextFile.java文本文件，并将文件内容输出到屏幕上
 */
public class TextFile {
    public static void main(String[] args) {
        FileReader fr = null;
        try {
            fr = new FileReader("./Junit_Test/src/javaSe.little_case3_IO/TextFile.java");
            char[] len = new char[10];
            int length = fr.read(len);
            while (length != -1) {
                System.out.print(new String(len,0,length));
                length = fr.read(len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if( fr != null ){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
