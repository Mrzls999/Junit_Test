package test_Socket;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 利用Socket套接字进行网络信息传输
 */
public class Test_TCP {
    //客户端
   @Test
    public void client(){
       String data = "I love baby";
       Socket socket = null;
       OutputStream outputStream = null;
       try {
           socket = new Socket("127.0.0.1",1234);
           outputStream = socket.getOutputStream();
           outputStream.write(data.getBytes());
       } catch (IOException e) {
           e.printStackTrace();
       } finally {
           if (outputStream != null) {
               try {
                   outputStream.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
           if (socket != null) {
               try {
                   socket.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
       }
   }
   //服务端
    @Test
    public void server(){
        ServerSocket serverSocket = null;
        Socket accept = null;
        InputStream acceptInputStream = null;
        try {
            serverSocket = new ServerSocket(1234);
            //用于获取当前连接的Socket
            accept = serverSocket.accept();
            acceptInputStream = accept.getInputStream();
            byte[] buff = new byte[1024];
            int len = 0;
            while((len = acceptInputStream.read(buff)) != -1){
                System.out.println(new String(buff,0,len));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (acceptInputStream != null) {
                try {
                    acceptInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (accept != null) {
                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
