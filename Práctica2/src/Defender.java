public class Defender extends Players{
    String role = "Defender";

    public Defender(String name, String nationality, int age, int id) {
        super(name, nationality, age, id);
        this.name = name;
        this.age = age;
        this.nationality = nationality;
        this.id = id;
    }
    public void give_data() {
        super.give_data(role);
    }
    public void give_name() {
        super.give_name(name);
    }
    public void give_id() {
        super.give_id(id);
    }
    public void pass_ball() {
        super.pass_ball(name);
    }
    public void hit_ball() {
        super.hit_ball(name);
    }
}