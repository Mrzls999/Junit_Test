package zlsUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * @author zls
 * @date 2022/3/18 15:35:17
 * @description XXX
 */
public class TestSocket {
    public static void main(String[] args) throws IOException {

        Process p = Runtime.getRuntime().exec("ping " + "www.baidu.com");
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), Charset.forName("GBK")));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            if (line.length() != 0)
//                sb.append(line + "\r\n");
                sb.append(line).append("\r\n");
        }
        System.out.println("本次指令返回的消息是：");
        System.out.println(sb.toString());
    }

}
