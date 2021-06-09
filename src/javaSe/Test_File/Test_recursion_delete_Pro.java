package javaSe.Test_File;

import java.io.File;

public class Test_recursion_delete_Pro {
    public static void main(String[] args) {
        String path = "E:\\pro\\IDEAJavaProject\\tt\\t2";
        delDir(path);
    }


    /**
     * 删除路径下所有文件 及 文件夹
     *
     * @param path 要删除的路径
     */
    public static void delDir(String path) {
        File dir = new File(path);
        if (dir.exists()) {//1 如果此路径表示的文件或文件夹存在
            File[] listFiles = dir.listFiles();//2 得到目录下文件及文件夹的列表
            for (File file : listFiles) {//3 对当前列表进行循环
                if (file.isDirectory()) {//4.1 如果是文件夹 则递归删除
                    delDir(file.getPath());
                } else {//4.2   如果是文件，则直接删除
                    file.delete();
                }
            }
            //end 此时循环到某个目录层次的最后，目录层次最后的文件都已删除，此时删除该目录的层次（删除该目录最后层次下的第一个文件夹）
            dir.delete();
        }
    }
}
