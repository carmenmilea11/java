package json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;

public class JsonMain {

    public static void writeJson(String fileName) throws IOException {
        JSONObject student = new JSONObject();

        student.put("name", "Andrei Popescu");
        student.put("age", 20);

        JSONObject address = new JSONObject();
        address.put("city", "Bucuresti");
        address.put("street", "Bulevardul Unirii");

        student.put("address", address);

        JSONArray courses = new JSONArray();
        courses.put("JAVA");
        courses.put("C++");
        courses.put("Algoritmi");

        student.put("courses", courses);

        System.out.println(student.toString());

        FileWriter fileWriter = new FileWriter(fileName);
        fileWriter.write(student.toString());
        fileWriter.close();

    }

    public static void readJson(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

        String line = null;
        StringBuilder stringBuilder = new StringBuilder();

        while((line = bufferedReader.readLine()) != null){
            stringBuilder.append(line);
        }

        bufferedReader.close();

        JSONObject myJson = new JSONObject(stringBuilder.toString());
        System.out.println(myJson);

        System.out.println("Student name: " + myJson.get("name"));
        System.out.println("City: " + ((JSONObject)myJson.get("address")).get("city"));
        System.out.println("First course: " + ((JSONArray)myJson.get("courses")).get(0));
    }

    public static void main(){
        try {
            writeJson("myJson.json");
            readJson("myJson.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
