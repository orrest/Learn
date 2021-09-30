package ds.tree;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class DFSFile {
    public static List<File> recurseDirs(String start, String regex){
        return recurseDirs(new File(start), regex);
    }

    public static List<File> recureseDirs(String start){
        return recurseDirs(new File(start), ".*");
    }

    public static List<File> recurseDirs(File startDir){
        return recurseDirs(startDir, ".*");
    }

    public static List<File> recurseDirs(File startDir, String regex){
        List<File> result = new ArrayList<>();
        if (startDir.listFiles() == null){
            System.out.println("Not valid directory.");
            return result;
        }

        for (File item : startDir.listFiles()){
            if (item.isDirectory()){
                result.add(item);
                result.addAll(recurseDirs(item));
            }else{
                if (item.getName().matches(regex)){
                    result.add(item);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        List<File> files = recureseDirs("");
//
//        for (File i : files){
//            System.out.println(i);
//        }
        String[] ss = {"a", "|__b", "\t|__c"};
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("runoob.txt"));

            for (String s : ss) {
                out.write(s+'\n');
            }
            out.close();
            System.out.println("文件创建成功！");
        }catch (IOException e) {
        }
    }
}
