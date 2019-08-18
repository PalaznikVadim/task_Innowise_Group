import java.util.List;

public class User {
    private String name;
    private String surname;
    private String email;
    private List<String> roles;
    private List<String> mobiles;

    public User(String name, String surname, String email, List<String> roles, List<String> mobiles) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.roles = roles;
        this.mobiles = mobiles;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public void setMobiles(List<String> mobiles) {
        this.mobiles = mobiles;
    }

    public void  display(){
        System.out.println("name: " + name+"\n"+
                "surname: "+ surname+"\n"+
                "email: "+ email
                );
        System.out.println("Roles:");
        for(String str:roles){
            System.out.println("\t" +
                    str);
        }
        System.out.println("Mobiles :");
        for(String str:mobiles){
            System.out.println("\t"+
                    str);
        }
    }
}
