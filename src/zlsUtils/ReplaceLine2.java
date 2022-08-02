package zlsUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author zls
 * @date 2022/8/1 20:43:28
 * @description 对于文件的第二行替换成文件的字节数
 */
public class ReplaceLine2 {

    /**
     * 程序入口
     */
    public static void main(String[] args) throws Exception {
        //String dirPath = "D:\\pkg\\xx";//压缩文件夹路径
        String dirPath = System.getProperty("user.dir");//获取当前路径
        //1、解压文件，修改第二行数据
        unPkgFiles(dirPath);
        modify_LogName_And_Bytes(dirPath);
        //2、删除class和zip文件
        List<String> del_file = new ArrayList<>();
        del_file.add("class");
        del_file.add("zip");
        delete_File(dirPath, del_file);
        //3、压缩.log文件为.log.zip文件
        zipFile(dirPath);
        //4、删除.log文件
        del_file.clear();
        del_file.add("log");
        delete_File(dirPath, del_file);
    }

    /**
     * 解压文件
     */
    public static void unPkgFiles(String dirPath) throws Exception {
        List<File> fileList = new ArrayList<>();
        //1、获取此文件夹下的所有文件
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        assert files != null;
        for (File file : files) {
            if(file.getName().endsWith(".zip")){
                UnzipUtils.decompress(file, dirPath);
            }
        }
    }

    /**
     * 获取修改文件的第二行内容为字节数
     */
    public static void modify_LogName_And_Bytes(String dir) throws IOException {
        File file = new File(dir);
        File[] files = file.listFiles();
        assert files != null;
        for (File file1 : files) {
            String fileName = file1.getName();//获取文件名字
            if (fileName.endsWith(".txt")) {//如果是以text结尾
                long log_Byte = file1.length();//获取text文件的大小
                //获取相同的log的文件
                File file2 = new File(dir + "\\" + fileName.substring(0, fileName.lastIndexOf(".")) + ".log");
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

                stream.close();
                out.close();
                sb.close();
            }
        }
    }

    /**
     * 压缩log文件
     */
    public static void zipFile(String dir) throws FileNotFoundException {
        File file_zip = new File(dir);
        File[] files = file_zip.listFiles();
        assert files != null;
        for (File file1 : files) {
            String fileName = file1.getName();//获取文件名字
            if (fileName.endsWith(".log")) {//如果是以log结尾，则压缩
                String path = file1.getAbsolutePath();
                zipFile(file1, path+".zip");
            }
        }
    }

    /**
     * 传入文件，压缩文件，在指定路径下生成指定文件名的压缩文件
     *
     * @param file      文件
     * @param strZipName 压缩文件路径及文件名
     */
    public static void zipFile(File file, String strZipName) {
        byte[] buffer = new byte[2048];
        FileInputStream fis = null;
        ZipOutputStream zipOps = null;
        try {
            zipOps = new ZipOutputStream(new FileOutputStream(strZipName));
            fis = new FileInputStream(file);
            zipOps.putNextEntry(new ZipEntry(file.getName()));
            int len;
            // 读入需要下载的文件的内容，打包到zip文件
            while ((len = fis.read(buffer)) > 0) {
                zipOps.write(buffer, 0, len);
            }
            zipOps.closeEntry();
            fis.close();
            zipOps.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除某路径下以xx结尾的文件
     */
    public static void delete_File(String dirPath, List<String> suffix) throws InterruptedException {
        File file_d = new File(dirPath);
        File[] files = file_d.listFiles();
        assert files != null;
        for (File file1 : files) {
            String fileName = file1.getName();//获取文件名字
            for (String s : suffix) {
                if (fileName.endsWith(s)) {//如果是以zip或class结尾，则删掉
                    file1.delete();
                }
            }
        }
    }

}
