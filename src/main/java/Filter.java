import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Filter {

    public static void main(String[] args) {


        Set<String> set = new HashSet<>();
        File file = new File("C:\\Users\\peter\\IdeaProjects\\java8\\src\\main\\java\\filter");
        File fileSave = new File("C:\\Users\\peter\\IdeaProjects\\java8\\src\\main\\java\\filter2");
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileSave), "utf-8"));
            String line;
            while ((line = reader.readLine()) != null) {
                if (set.contains(line)){
                    continue;
                }
                set.add(line);
                writer.write(line);
                writer.newLine();
            }
            writer.flush();
            writer.close();
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
