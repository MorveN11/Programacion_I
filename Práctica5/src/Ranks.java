public class Ranks {
    public Ranks() {
    }

    public double calculateMaxRank(double score, double min_score, double max_score, boolean inverse) {
        score = score - min_score;
        max_score = max_score - min_score;
        if(!inverse){
            return (score/max_score)*100;
        }else{
            return 100 - ((score / max_score) * 100);
        }
    }

    public String getLetter(double totalRank, String[] ranks) {
        String result = ranks[0];
        for (int i = 1; i < 5; i++){
            if ((totalRank / 20) > i){
                result = ranks[i];
            }
        }
        return result;
    }

    public double getTotalRank(double totalRankT, double  totalRankP, double totalRankD, double totalRankIU){
        return (totalRankT+totalRankP+totalRankD+totalRankIU) / 4;
}
}
