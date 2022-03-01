import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    //Bước 1: Tạo phương thức readFile với đối số truyền vào là đường dẫn file mà người dùng nhập vào và trả về một List<Integer>

    public List<Integer> readFile(String filePath){
        List<Integer> number = new ArrayList<>();

        try {
            File file = new File(filePath);

            if(!file.exists()){
                throw new FileNotFoundException();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line= br.readLine()) != null){
                number.add(Integer.parseInt(line));
            }
            br.close();
        }catch (Exception e){
            System.out.println("File ko tồn tại or nội dung có lỗi!");
        }
        return number;
    }

    //Bước 2: Tạo phương thức writeFile trong lớp ReadAndWriteFile để ghi giá trị lớn nhất cần tìm vào trong File

    public void writeFile(String filePath, int max){
        try {
            FileWriter writer = new FileWriter(filePath,true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("Giá trị lớn nhất là: " + max);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int findMax(List<Integer> number){
        int max = number.get(0);
        for (int i = 0; i < number.size() ; i++) {
            if(max<number.get(i)){
                max= number.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> number = readAndWriteFile.readFile("number.txt");
        int maxValue = findMax(number);
        readAndWriteFile.writeFile("result.txt", maxValue);
    }
}
