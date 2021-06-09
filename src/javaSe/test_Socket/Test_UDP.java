package javaSe.test_Socket;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

/**
 * 测试UDP的通信
 */
public class Test_UDP {
    /**
     * 发送端
     */
    @Test
    public void Sender(){
        DatagramSocket datagramSocket = null;
        DatagramPacket datagramPacket = null;
        try {
            String str = "My favorite is basketball";
            byte[] buff = str.getBytes();
            datagramSocket = new DatagramSocket();//可以不用指定，通过DatagramPacket指定
            //buff.length就是实际要发送的数据长度(多少字节)
            datagramPacket = new DatagramPacket(buff, 0, buff.length, InetAddress.getByName("127.0.0.1"), 1234);
            System.out.println(buff.length);
            datagramSocket.send(datagramPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            datagramSocket.close();
        }
    }
    /**
     * 接收端
     */
    @Test
    public void receive(){
        try {
            DatagramSocket datagramSocket = new DatagramSocket(1234);
            byte[] buff = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(buff,buff.length);
            datagramSocket.receive(datagramPacket);
            //实际接收多少(datagramPacket.getLength())就输出多少
            System.out.println(new String(datagramPacket.getData(),0,datagramPacket.getLength()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
