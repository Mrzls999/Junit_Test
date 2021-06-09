package javaSe.little_case3_IO;

import java.io.FileReader;
import java.io.IOException;

/**
 * 这里是中文，所以用了FileReader
 */
public class TextFile_Pro1_FileReader {
    public static void main(String[] args) {
        FileReader fr = null;
        try {
            fr = new FileReader("./Junit_Test/src/javaSe.little_case3_IO/TextFile_Pro1_FileReader.java");
            int len = fr.read();
            int count = 1;
            System.out.print(1 + "" + (char) len);
            len = fr.read();
            while (len != -1) {
                if (len == 13) {
                    System.out.print("\r\n" + ++count);
                    len = fr.read();
                } else {
                    System.out.print((char) len);
                }
                len = fr.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
