package zlsUtils;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author zls
 * @date 2022/8/1 20:43:28
 * @description 对于文件的第二行替换成文件的字节数
 */
public class ReplaceLine2 {
    public static void main(String[] args) throws Exception {
        String dirPath = "D:\\pkg\\pkg1";//压缩文件夹路径
        String destPath = "D:\\pkg\\unpkg";//解压路径
        //unPkgFiles(dirPath,destPath);//解压文件
        modify_LogName_And_Bytes(destPath);
    }

    /**
     * 解压文件
     *
     * @param dirPath
     * @param destPath
     * @throws Exception
     */
    public static void unPkgFiles(String dirPath, String destPath) throws Exception {
        List<File> fileList = new ArrayList<>();
        //1、获取此文件夹下的所有文件
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        assert files != null;
        for (File file : files) {
            UnZipUtils.decompress(file, destPath);
        }
    }


    /**
     * 获取log文件名和字节数
     */
    public static void modify_LogName_And_Bytes(String dir) throws IOException {
        File file = new File(dir);
        File[] files = file.listFiles();
        assert files != null;
        for (File file1 : files) {
            String fileName = file1.getName();//获取文件名字
            if (fileName.endsWith(".log")) {//如果是以log结尾
                long log_Byte = file1.length();//获取log文件的大小
                //获取相同的text的文件
                File file2 = new File(dir + "\\" + fileName.substring(0, fileName.lastIndexOf(".")) + ".txt");
                //读取文件的第二行内容
                BufferedReader sb = new BufferedReader(new FileReader(file2));
                String line = null;
                int lineNo = 0;
                CharArrayWriter stream = new CharArrayWriter();//获取输入
                FileWriter out = null;
                while ((line = sb.readLine()) != null) {
                    lineNo++;
                    if (lineNo == 2) {
                        line = String.valueOf(log_Byte);
                    }
                    stream.write(line);
                    stream.append(System.getProperty("line.separator"));//写入换行符
                }
                out = new FileWriter(file2.getAbsolutePath());
                stream.writeTo(out);
            }
        }
    }
}
