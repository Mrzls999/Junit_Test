package javaSe.Test_Serializable;

import org.junit.Test;

import java.io.*;

public class Test_Serializable {
    /**
     * 反序列化
     */
    @Test
    public void test_Deserializable(){
        BufferedInputStream bi = null;
        ObjectInputStream ois = null;
        try {
            bi = new BufferedInputStream(new FileInputStream("./person.bat"));
            ois = new ObjectInputStream(bi);
            Person object = (Person)ois.readObject();
            System.out.println(object);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (bi != null) {
                try {
                    bi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    /**
     * 序列化
     */
    @Test
    public void test_Serializable(){
        Person p1 = new Person("zls",20,"中国");
        BufferedOutputStream bw = null;
        ObjectOutputStream oos = null;
        try {
            bw = new BufferedOutputStream(new FileOutputStream("./person.bat"));
            oos = new ObjectOutputStream(bw);
            oos.writeObject(p1);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
