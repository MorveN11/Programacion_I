public class Main {
    public static void main(String[] args) {

        Striker striker = new Striker("Roberto", "Mexican", 18, 7040680);
        Midfielder midfielder = new Midfielder("Jorge", "Bolivian", 20, 7521963);
        Defender defender = new Defender("Carlos", "Peruvian", 21, 6578963);
        Goalkeeper goalkeeper = new Goalkeeper("Fernando", "Aleman", 22, 9654721);

        striker.give_data();
        striker.give_name();
        striker.give_id();
        striker.pass_ball();
        striker.hit_ball();
        midfielder.give_data();
        midfielder.give_name();
        midfielder.give_id();
        midfielder.pass_ball();
        midfielder.hit_ball();
        defender.give_data();
        defender.give_name();
        defender.give_id();
        defender.pass_ball();
        defender.hit_ball();
        goalkeeper.give_data();
        goalkeeper.give_name();
        goalkeeper.give_id();
        goalkeeper.pass_ball();
        goalkeeper.hit_ball();
    }
}
