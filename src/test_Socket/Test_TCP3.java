package test_Socket;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 3.从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给客户端。并关闭相应连接。
 */
public class Test_TCP3 {
    /**
     * 客户端
     */
    @Test
    public void client() throws IOException {
        Socket socket = null;
        InputStream inputStream = null;
        BufferedInputStream bufferedInputStream = null;
        OutputStream outputStream = null;
        InputStream inputStream_Socket = null;
        try {
            int len = 0;
            byte[] buff = new byte[1024];
            inputStream = new FileInputStream("E:\\大学\\张良升\\小东西\\1.jpg");
            bufferedInputStream = new BufferedInputStream(inputStream);
//            socket = new Socket("127.0.0.1", 1234);
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 1234);
            outputStream = socket.getOutputStream();
            while ((len = bufferedInputStream.read(buff)) != -1) {
                outputStream.write(buff, 0, len);
            }
            socket.shutdownOutput();
            inputStream_Socket = socket.getInputStream();
            while ((len = inputStream_Socket.read(buff)) != -1) {
                System.out.println(new String(buff, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            inputStream_Socket.close();
            outputStream.close();
            bufferedInputStream.close();
            inputStream.close();
            socket.close();
        }
    }

    /**
     * 服务端
     */
    @Test
    public void server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        //输出流
        OutputStream outputStream = new FileOutputStream("E:\\大学\\张良升\\小东西\\2.jpg");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        int len = 0;
        byte[] buff = new byte[1024];
        while ((len = inputStream.read(buff)) != -1) {
            bufferedOutputStream.write(buff, 0, len);
        }
        OutputStream acceptOutputStream = accept.getOutputStream();
        acceptOutputStream.write("成功保存到服务端本地".getBytes());
        acceptOutputStream.close();
        bufferedOutputStream.close();
        outputStream.close();
        inputStream.close();
        accept.close();
        serverSocket.close();

    }
}
