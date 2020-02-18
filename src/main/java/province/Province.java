package province;

import com.google.gson.Gson;

import java.io.*;
import java.util.*;

public class Province {

    public static void main(String[] args) {

        List<ProvinceVO> list = new ArrayList<>();

        Map<String, String> province = new HashMap<>();
        Map<String, List<ProvinceVO.CityVO>> city = new HashMap<>();

        File file1 = new File("C:\\Users\\peter\\IdeaProjects\\java8\\src\\main\\java\\province\\provinces.csv");
        File file2 = new File("C:\\Users\\peter\\IdeaProjects\\java8\\src\\main\\java\\province\\regencies.csv");

        try {
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(new FileInputStream(file1), "utf-8"));

            String line;
            while ((line = reader1.readLine()) != null) {
                System.out.println(line);
                String[] pStr = line.split(",");
                province.put(pStr[0], pStr[1]);
            }
            reader1.close();


            BufferedReader reader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file2), "utf-8"));

            String line2;
            while ((line2 = reader2.readLine()) != null) {
                System.out.println(line2);
                String[] pStr = line2.split(",");
                String code = pStr[1];
                String cityStr = pStr[2];

                if (!city.containsKey(code)) {
                    city.put(code, new ArrayList<>());
                }

                city.get(code).add(new ProvinceVO.CityVO(cityStr));
            }
            reader2.close();


            Iterator<String> iterator = province.keySet().iterator();
            while (iterator.hasNext()) {

                String next = iterator.next();
                ProvinceVO vo = new ProvinceVO();
                vo.setProvince(province.get(next));
                vo.setCityList(city.get(next));
                list.add(vo);
            }


            System.out.println("------");
            System.out.println(new Gson().toJson(list));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
