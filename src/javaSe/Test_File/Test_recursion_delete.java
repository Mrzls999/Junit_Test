package javaSe.Test_File;

import java.io.File;
import java.util.Objects;

/**
 * 测试递归删除 一个文件夹下的所有东西
 */
public class Test_recursion_delete {
    public static void main(String[] args) {
        String deletePath = "XXXXXXXXXXXXXX";//你要删除的路径
        boolean isDelete = delete(deletePath, false);
        System.out.println(deletePath + "是否被删除: " + isDelete);
    }

    /**
     * 删除 所有文件 及 文件夹
     * @param path  你要删除的文件目录
     * @param isDelete 初始值
     * @return 是否删除成功
     */
    public static boolean delete(String path, boolean isDelete) {
        if (deleteFile(path, isDelete)){//如果路径 下 所有文件或文件夹成功删除，则删除根路径
            File file = new File(path);
            return file.delete();
        }
        return false;
    }

    /**
     * 删除传入路径 下边 的所有文件及文件夹
     *
     * @param path     你要删除的目录
     * @param isDelete 本文件是否删除完毕
     * @return 返回文件或文件夹是否删除完毕，如果有不能删除的，则直接返回 删除失败
     */
    public static boolean deleteFile(String path, boolean isDelete) {
        File file = new File(path);
        File[] listFiles = file.listFiles();
        try {
            if (listFiles != null) {
                for (File listFile : listFiles) {
                    if (listFile.isFile()) {//如果是文件，则直接删除
                        isDelete = listFile.delete();
                        if (!isDelete) return false;
                    } else if (listFile.isDirectory() && Objects.requireNonNull(listFile.listFiles()).length == 0) {//如果是文件夹，且下边没有文件或文件夹，则直接删除
                        isDelete = listFile.delete();
                        if (!isDelete) return false;
                    } else {//如果是文件夹，且下边有文件或文件夹
                        isDelete = deleteFile(listFile.getPath(), isDelete);//这样会删除掉所有的文件和空文件夹
                        if (!isDelete) return false;
                        isDelete = deleteFile(listFile.getParent(), isDelete);//删除上级目录，此时最多删到你传进来的路径，传进来的路径不会被删掉
                        if (!isDelete) return false;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isDelete;
    }

}