package ss16_ioflie.bai_tap.copyfile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CopyFileText {
    public static List<String> readFile(String filePath) {
        List<String> listFile = new ArrayList<>();
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                listFile.add(line);
            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("file not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(listFile);
        return listFile;
    }
    public static void writeFile(String filePath, List<String> listFile){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))){
            for (String str: listFile ) {
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }
            System.out.println("Copy file"+ listFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static String file_name = "D:\\cody\\A0222I1-NguyenKhai\\Module2\\src\\ss16_ioflie\\bai_tap\\copyfile\\temp.txt";

    static String file_name1 = "D:\\cody\\A0222I1-NguyenKhai\\Module2\\src\\ss16_ioflie\\bai_tap\\copyfile\\temp1.txt";

    public static void main(String[] args) {
        List <String> temp = readFile(file_name);
        writeFile(file_name1,temp);
    }
}

