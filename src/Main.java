import com.google.gson.Gson;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Select an action. To add a user -- \"a\", to delete -- \"d\", to update -- \"u\"");
        Scanner in = new Scanner(System.in);
        String choose = in.next();

        Functionality functionality=new Functionality();
        User user;

        switch (choose) {
            case "a":
                user=functionality.createUser();
                WriteAndReadJSONFile json=new WriteAndReadJSONFile();
                Gson gson=new Gson();
                String str=gson.toJson(user);
                json.writeToJson(str);
                break;
            case "d":
                functionality.deleteUser();
                break;
            case "u":
                functionality.updateUser();
                break;
        }
    }
}
