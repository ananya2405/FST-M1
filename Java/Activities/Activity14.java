package activities;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;


public class Activity14 {
    public static void main(String[] args) throws IOException {
        try {
            //Creating a new file
            File file = new File(System.getProperty("user.dir") + "//newfile.txt");
            boolean fStatus = file.createNewFile();
            if (fStatus) {
                System.out.println("File created successfully!");
            } else {
                System.out.println("File already exists at this path.");
            }
            //getting the file Object
            File fileUtil = FileUtils.getFile(System.getProperty("user.dir") + "//newfile.txt");
            //Reading the file
            System.out.println("Data in file: " + FileUtils.readFileToString(fileUtil, "UTF8"));

            //Create a new directory
            File destDir = new File("resources");
            //Copy file to the new directory
            FileUtils.copyFileToDirectory(file, destDir);

            //Get file from the new directory
            File newFile = FileUtils.getFile(destDir, "newfile.txt");
            //Read data from the new file
            System.out.println("Data in new file: " + FileUtils.readFileToString(newFile, "UTF8"));
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
