package little_case3_IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * operation2_Pro:
 * TextFile_Pro2.java文本文件，并将文件内容输出到屏幕上，并在每一行的开始位置加上 行号
 * 直接使用BufferedReader来读取一行
 */
public class TextFile_Pro2 {
    public static void main(String[] args) {
        BufferedReader sb = null;
        try {
            sb = new BufferedReader(new FileReader("./Junit_Test/src/little_case3_IO/TextFile_Pro2.java"), 1024);
            long count = 0;
            String strLine = sb.readLine();
            System.out.print(++count);
            System.out.print(strLine);
            strLine = sb.readLine();
            while (strLine != null) {
                System.out.print("\n" + ++count + strLine);
                strLine = sb.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sb != null) {
                try {
                    sb.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
