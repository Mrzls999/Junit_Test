package little_case3_IO;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * operation2:
 * because there do not have chinese world,so I use FileInputStream to read the .java file;
 * when read the \r(the ascii is 13),I would print \n and ++count else I print the something of read;
 */
public class TextFile_Pro1 {
    public static void main(String[] args) {
        FileInputStream fr = null;
        try {
            fr = new FileInputStream("./Junit_Test/src/little_case3_IO/TextFile_Pro1.java");
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
