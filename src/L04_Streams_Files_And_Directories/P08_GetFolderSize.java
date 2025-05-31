package L04_Streams_Files_And_Directories;

import java.io.File;

public class P08_GetFolderSize {
    public static void main(String[] args) {

        String path = "src/L04_Streams_Files_And_Directories/resourses/Exercises Resources";

        File folder = new File(path);

        File[] allFiles = folder.listFiles();

        int folderSize = 0;

        for (File file : allFiles){
            int currentSize = (int) file.length();
            folderSize += currentSize;
        }

        System.out.println("Folder size: " + folderSize);





    }
}