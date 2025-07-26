public class PlayerRecord {
    private String name;
    private String position;
    private String teamName;
    private int gamesPlayed;
    private int goalsScored;
    private int assists;
    private int penaltyMinutes;
    private int shotsOnGoal;
    private int gameWinningGoals;

    public PlayerRecord(){
    }
    public PlayerRecord(String name, String position, String teamName, int gamesPlayed, int goalsScored, int assists, int penaltyMinutes, int shotsOnGoal, int gameWinningGoals){
        this.name = name;
        this.position = position;
        this.teamName = teamName;
        this.gamesPlayed = gamesPlayed;
        this.goalsScored = goalsScored;
        this.assists = assists;
        this.penaltyMinutes = penaltyMinutes;
        this.shotsOnGoal = shotsOnGoal;
        this.gameWinningGoals = gameWinningGoals;
    }
    public String toString(){
        return name + " " + position + " " + teamName + " " + gamesPlayed + " " + goalsScored + " " + assists + " " + penaltyMinutes + " " + shotsOnGoal + " " + gameWinningGoals;
    }
    public int getGoalsScored(){
        return this.goalsScored;
    }
    public int getAssists(){
        return this.assists;
    }
    public String getTeamName(){
        return this.teamName;
    }
    public int getPenaltyMinutes(){
        return this.penaltyMinutes;
    }
    public String getName(){
        return this.name;
    }
    public String getPosition() {
        return this.position;
    }
    public int getGamesPlayed(){
        return this.gamesPlayed;
    }
    public int getShotsOnGoal(){
        return this.shotsOnGoal;
    }
    public int getGameWinningGoals(){
        return this.gameWinningGoals;
    }
}
