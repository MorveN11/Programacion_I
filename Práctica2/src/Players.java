public class Players {
    String name;
    String nationality;
    int age;
    int id;
    public Players(String name, String nationality, int age, int id) {
        this.name = name;
        this.nationality = nationality;
        this.age = age;
        this.id = id;
    }
    public void give_data(String role) {
        System.out.println("The name is: " + name);
        System.out.println("The age is: " + age);
        System.out.println("The nationality is: " + nationality);
        System.out.println("The id is: " + id);
        System.out.println("The role is: " + role);
    }
    public void give_name(String name) {
        System.out.println("The name is: " + name);
    }
    public void give_id(int id) {
        System.out.println("The id is: " + id);
    }
    public void pass_ball(String name) {
        System.out.println(name + " has made a pass");
    }
    public void hit_ball(String name) {
        System.out.println(name + " has kicked");
    }
}
