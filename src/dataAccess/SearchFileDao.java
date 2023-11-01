/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class SearchFileDao {

    private static SearchFileDao instance = null;

    public static SearchFileDao Instance() {
        if (instance == null) {
            synchronized (SearchFileDao.class) {
                if (instance == null) {
                    instance = new SearchFileDao();
                }
            }
        }
        return instance;
    }

    public int countOccurent(String word, File file) {
        int count = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            while (line != null) {
                for (String data : line.split(" ")) {
                    if (word.equalsIgnoreCase(data.replaceAll("\\W", ""))) {
                        count++;
                    }
                }
                line = br.readLine();
            }
            br.close();
        } catch (Exception e) {
            System.out.println("File is not found");
        }
        return count;
    }

    public static void main(String[] args) {
        new SearchFileDao().countOccurent("Hello", new File(""));
    }

    public List<String> findFile(File source, String word) {
        List<String> listFoundFile = new ArrayList<>();
        File[] fileList = source.listFiles();
        for (File f : fileList) {
            File fileItem = new File(f.getPath());
            int temp = countOccurent(word, fileItem);
            if (temp > 0) {
                listFoundFile.add(f.getName());
                System.out.println(f.getPath());
            }
        }
        return listFoundFile;
    }

}
