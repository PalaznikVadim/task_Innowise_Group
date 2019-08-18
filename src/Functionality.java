import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Functionality {

    public User createUser(){

        Scanner in = new Scanner(System.in);

        System.out.print("Input a name: ");
        String name = in.next();

        System.out.println("Input a surname:");
        String surname=in.next();

        System.out.println("Input a email:");

        String email=in.next();

        while(true) {
            if (Validatity.validateEmail(email)) {
                break;
            } else {
                System.out.println("Uncorrect email. Repeat enter:");
                email = in.next();
            }
        }

        in.nextLine();

        int i=0;
        List<String> roles=new ArrayList<>();
        String role;
        while(i<3){
            System.out.println("Enter role "+(i+1)+":");
            role=in.nextLine();
            if(role.equals("")&&roles.size()==0){
                System.out.println("Invalid number of entries. Repeat:");
            }
            else if(role.equals("")&&roles.size()>0){
                break;
            }
            else {
                roles.add(role);
                i++;
            }
        }

        i=0;
        List<String> phones=new ArrayList<>();
        String phone;
        while(i<3){
            System.out.println("Enter phone number "+(i+1)+":");
            phone=in.nextLine();
            if (phone.equals("") && phones.size() == 0) {
                System.out.println("Invalid number of entries. Repeat:");
            } else if (phone.equals("") && phones.size() > 0) {
               break;
            } else {
               if(Validatity.validateMobile(phone)) {
                   phones.add(phone);
                   i++;
               }
               else{
                   System.out.println("Invalid phone number. Repeat enter!");
                   continue;
               }
            }
        }
        return new User(name,surname,email,roles,phones);
    }

    public void updateUser() {
        Scanner in = new Scanner(System.in);

        System.out.println("Input a email:");
        String email = in.next();

        while (true) {

            if (Validatity.validateEmail(email)) {
                WriteAndReadJSONFile json = new WriteAndReadJSONFile();
                List<String> list = json.readFromJson();
                User userJson;
                for (int i=0;i<list.size();i++) {

                    if (list.get(i).contains(email)) {

                        Gson gson = new Gson();
                        userJson = gson.fromJson(list.get(i), User.class);

                        System.out.println("User editing... To skip editing the field, press \"-\"");
                        System.out.println("Old info about user:\n");
                        userJson.display();

                        System.out.print("Input a new name: ");
                        String name = in.next();
                        if (!name.equals("-")) {
                            userJson.setName(name);
                        }

                        System.out.println("Input a new surname:");
                        String surname = in.next();
                        if (!surname.equals("-")) {
                            userJson.setSurname(surname);
                        }

                        System.out.println("Input a new email:");
                        String newEmail = in.next();
                        while (true) {
                            if (newEmail.equals("-")) {
                                break;
                            } else if (Validatity.validateEmail(newEmail)) {
                                userJson.setEmail(newEmail);
                                break;
                            } else {
                                System.out.println("Uncorrect email. Repeat enter:");
                                email = in.next();
                            }
                        }

                        in.nextLine();

                        System.out.println("Want to change roles. Yes-\"y\", no-\"n\"");
                        String choose = in.nextLine();
                        switch (choose) {
                            case "n":
                                break;
                            case "y":
                                int j = 0;
                                List<String> roles = new ArrayList<>();
                                String role;
                                while (j < 3) {
                                    System.out.println("Enter new role " + (j + 1) + ":");
                                    role = in.nextLine();
                                    if (role.equals("") && roles.size() == 0) {
                                        System.out.println("Invalid number of entries. Repeat:");
                                    } else if (role.equals("") && roles.size() > 0) {
                                        break;
                                    } else {
                                        roles.add(role);
                                        j++;
                                    }
                                }
                                userJson.setRoles(roles);
                                break;
                        }

                        System.out.println("Want to change mobiles. Yes-\"y\", no-\"n\"");
                        choose = in.nextLine();
                        switch (choose) {
                            case "n":
                                break;
                            case "y":
                                int j = 0;
                                List<String> phones = new ArrayList<>();
                                String phone;
                                while (j < 3) {
                                    System.out.println("Enter new phone number " + (j + 1) + ":");

                                    phone = in.nextLine();
                                    if (phone.equals("") && phones.size() == 0) {
                                        System.out.println("Invalid number of entries. Repeat:");
                                    } else if (phone.equals("") && phones.size() > 0) {
                                        break;
                                    } else {
                                        if (Validatity.validateMobile(phone)) {
                                            phones.add(phone);
                                            j++;
                                        } else {
                                            System.out.println("Invalid phone number. Repeat enter!");
                                            continue;
                                        }
                                    }
                                }
                                userJson.setMobiles(phones);
                                break;
                        }
                        list.set(i,gson.toJson(userJson));
                    }
                }
                for(String str: list){
                    json.writeToJson(str);
                }
                break;
            } else{
                System.out.println("Uncorrect email. Repeat enter:");
                email = in.next();
            }
        }
    }

    public void deleteUser(){
        Scanner in = new Scanner(System.in);

        System.out.println("Input a email:");
        String email=in.next();

        while(true) {
            if (Validatity.validateEmail(email)) {
                WriteAndReadJSONFile json=new WriteAndReadJSONFile();
                List<String> list=json.readFromJson();

                for (Iterator i = list.iterator(); i.hasNext(); ) {
                    Object str = i.next();

                    if ((((String)str).contains(email))) {
                        i.remove();
                    }
                }

                for(String str:list)
                    json.writeToJson(str);

                break;
            } else {
                System.out.println("Uncorrect email. Repeat enter:");
                email = in.next();
            }
        }
    }
}
