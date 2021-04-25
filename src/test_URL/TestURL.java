package test_URL;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

/**
 * 同一资源定位符
 */
public class TestURL {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://www.cnblogs.com/zlshtml?name=zls");
        InetAddress Name = InetAddress.getByName("www.cnblogs.com");
        System.out.println(Name.getHostAddress());
        System.out.println(url.getProtocol());//获取协议名
        System.out.println(url.getHost());//获取主机名
        System.out.println(url.getPort());//获取该URL的端口号
        System.out.println(url.getPath());//获取该URL的文件路径
        System.out.println(url.getFile());//获取该URL的文件名
        System.out.println(url.getRef());//获取该URL在文件中的相对位置
        System.out.println(url.getQuery());//获取该URL的查询名类似于name=zls
    }
}
