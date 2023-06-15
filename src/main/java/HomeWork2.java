//        Формат сдачи: ссылка на подписанный git-проект.
//
//                Задание
//
//        Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
//                Если значение null, то параметр не должен попадать в запрос.
//        Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
//        В итоге должно получится select * from students where name=Ivanov, country=Russia, city=Moscow, age=null
//
//        Дополнительные задания
//
//        Дана json-строка (можно сохранить в файл и читать из файла)
//                [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
//        Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
//        Пример вывода:
//        Студент Иванов получил 5 по предмету Математика.
//        Студент Петрова получил 4 по предмету Информатика.
//        Студент Краснов получил 5 по предмету Физика.
//
//        *Сравнить время выполнения замены символа "а" на "А" любой строки содержащей >1000 символов средствами String и StringBuilder.

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class HomeWork2 {
    public static void main(String[] args) throws Exception {
        String json_string = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";

        String query = "select * from students where " + getWhereSQL(json_string);
        System.out.println(query);

//        json_string = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";

        for (String str : getStringsFromJSON(loadJson("students.json"))) {
            System.out.println(str);
        }

//        измерение скорости
        String str = generatorString(20000);
//        System.out.println(str);

        long start = System.currentTimeMillis();
        String new_str = str.replace("a", "A");
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder(str);
        int count = str.length() - str.replace("a", "").length();
        int index;
        for (int i = 0; i < count; i++) {
            index = sb.indexOf("a");
            sb.replace(index, index, "A");
        }
        str = sb.toString();
        System.out.println(System.currentTimeMillis() - start);

        //    время выполнения через String 1мс
        //    время выполнения через StingBuilder 20мс
    }

    public static String getWhereSQL(String json) {
        String[] arrData = json.replace("{", "").replace("}", "").replace("\"", "").split(", ");

        StringBuilder sb = new StringBuilder();

        String[] data;
        for (String el : arrData) {
            data = el.split(":");

            if (!data[1].equals("null")) sb.append(data[0]).append("=").append(data[1]).append(", ");
        }

        sb.delete(sb.length() - 2, sb.length());

        return sb.toString();
    }

    public static String[] getStringsFromJSON(String json) {
        String[] data = json.replace("[", "").replace("]", "").split("},\\{");

        String[] res = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            StringBuilder sb = new StringBuilder();

            String[] data1 = data[i].replace("{", "").replace("}", "").replace("\"", "").split(",");

            sb.append("Студент ").append(data1[0].split(":")[1]).append(" получил ").append(data1[1].split(":")[1]).append(" по предмету ").append(data1[2].split(":")[1]).append(".");

            res[i] = sb.toString();
        }

        return res;
    }

    static String loadJson(String file_path) throws Exception {
        StringBuilder json = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(file_path, StandardCharsets.UTF_8));
        String str;
        while ((str = br.readLine()) != null) {
            json.append(str);
        }
        br.close();
        return json.toString();
    }

    public static String generatorString(int size) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; i++) {
            sb.append((char) new Random().nextInt(97, 100));
        }

        return sb.toString();
    }
}
