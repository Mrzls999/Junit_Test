package zlsUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author zls
 * @date 2022/8/2 15:20:52
 * @description XXX
 */
public class ZipCompressor1 {

    /**
     * 传入文件数组，压缩文件，在指定路径下生成指定文件名的压缩文件
     *
     * @param files
     * 文件数组
     * @param strZipName
     * 压缩文件路径及文件名
     * @throws IOException
     */
    public static void zipFiles(List<File> files, String strZipName) {
        if (files == null || files.size() == 0) {
            return;
        }
        byte[] buffer = new byte[2048];
        FileInputStream fis=null;
        ZipOutputStream zipOps=null;
        try{
            zipOps = new ZipOutputStream(new FileOutputStream(strZipName));
            for (File src : files) {
                fis = new FileInputStream(src);
                zipOps.putNextEntry(new ZipEntry(src.getName()));
                int len;
// 读入需要下载的文件的内容，打包到zip文件
                while ((len = fis.read(buffer)) > 0) {
                    zipOps.write(buffer, 0, len);
                }
                zipOps.closeEntry();
                fis.close();
            }
            zipOps.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
