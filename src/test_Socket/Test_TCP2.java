package test_Socket;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 客户端发送内容给服务端，服务端给予反馈
 */
public class Test_TCP2 {
    /**
     * 客户端
     */
    @Test
    public void client(){
        String str = "I love mySelf";
        Socket socket = null;
        InputStream inputStream = null;
        try {
            socket = new Socket("127.0.0.1",1234);
            socket.getOutputStream().write(str.getBytes());
            socket.shutdownOutput();
            byte[] buff = new byte[1024];
            int len = 0;
            inputStream = socket.getInputStream();
            while ( (len = inputStream.read(buff)) != -1){
                System.out.println(new String(buff,0,len));
            }
            socket.shutdownInput();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
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
    /**
     * 服务端
     */
    @Test
    public void server(){
        ServerSocket serverSocket = null;
        Socket accept = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            serverSocket = new ServerSocket(1234);
            accept = serverSocket.accept();
            inputStream = accept.getInputStream();
            int len = 0;
            byte[] buff = new byte[1024];
            while ((len = inputStream.read(buff)) != -1) {
                System.out.println(new String(buff, 0, len));
            }
            outputStream = accept.getOutputStream();
            outputStream.write("成功接收".getBytes());
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
            if (inputStream != null) {
                try {
                    inputStream.close();
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
