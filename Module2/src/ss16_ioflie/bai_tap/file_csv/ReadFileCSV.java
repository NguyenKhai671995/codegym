package ss16_ioflie.bai_tap.file_csv;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFileCSV {
    public static class Nation{
        public String id;
        public String code;
        public String name;

        public Nation() {
        }

        public Nation(String id, String code, String name) {
            this.id = id;
            this.code = code;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Nation{" +
                    "id='" + id + '\'' +
                    ", code='" + code + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static List<Nation> readFile(String filePath) {
        List<Nation> listFile = new ArrayList<>();
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] temp = line.split(",");
                listFile.add(new Nation(temp[0],temp[1],temp[2]));
            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("file not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listFile;
    }

    static String file_name ="D:\\cody\\A0222I1-NguyenKhai\\Module2\\src\\ss16_ioflie\\bai_tap\\file_csv\\fileCSV.csv";

    public static void main(String[] args) {
        List<Nation> temp = readFile(file_name);
        for (Nation nation:temp){
            System.out.println(nation);
        }
    }

}
