public class Game {
    public static void main(String[] args) {
        Ranks rank = new Ranks();

        final String[] ranks = { "C", "B", "A", "S", "SS" };

        final double time = 123;

        final double MIN_TIME = 0;

        final double MAX_TIME = 100;

        double totalRankTime = rank.calculateMaxRank(time, MIN_TIME, MAX_TIME, true);

        System.out.println(rank.getLetter(totalRankTime, ranks)); //should print SS

        final double points = 90;

        final double MIN_POINTS = 0;

        final double MAX_POINTS = 100;

        double totalRankPoints = rank.calculateMaxRank(points, MIN_POINTS, MAX_POINTS, false);

        System.out.println(rank.getLetter(totalRankPoints, ranks)); //should print SS

        final double damage = 1100;

        final double MIN_DAMAGE = 0;

        final double MAX_DAMAGE = 1200;

        double totalRankDamage = rank.calculateMaxRank(damage, MIN_DAMAGE, MAX_DAMAGE, true);

        System.out.println(rank.getLetter(totalRankDamage, ranks)); //should print C

        final double itemUsed = 9;

        final double MIN_ITEMS_USED = 0;

        final double MAX_ITEMS_USED = 10;

        double totalRankItemUsed = rank.calculateMaxRank(itemUsed, MIN_ITEMS_USED, MAX_ITEMS_USED, true);

        System.out.println(rank.getLetter(totalRankItemUsed, ranks)); //should print C

        double total = rank.getTotalRank(totalRankTime, totalRankPoints, totalRankDamage, totalRankItemUsed);

        System.out.println(rank.getLetter(total, ranks)); // should print A

    }
}
