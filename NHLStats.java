import java.util.HashMap;
import java.util.Map;
public class NHLStats {
    private List<PlayerRecord> NHL_stats;
    public NHLStats(){
        NHL_stats = new List<PlayerRecord>();
    }

    //Override methods
    public void add(PlayerRecord player){
        NHL_stats.add(player);
    }
    public boolean isEmpty(){
        return NHL_stats.isEmpty();
    }
    public boolean contains(PlayerRecord player){
        return NHL_stats.contains(player);
    }
    public PlayerRecord first(){
        return NHL_stats.first();
    }
    public PlayerRecord next(){
        return NHL_stats.next();
    }

    //Method to return the player(s) with the most points
    public void mostPoints(){
        PlayerRecord player = NHL_stats.first();//Create a player and initialize it to the first playerRecord in the NHL_stats list
        int mostPoints = 0;//set most points to 0 to start
        List<PlayerRecord> topPlayers = new List<>();//create a new list to hold the top players to be later printed out

        //While there is a still a player in the list
        while(player != null){
            int points = player.getGoalsScored() + player.getAssists();//Initialize the current players variable to hold the total points
            //if players points are greater then the current most points then set the new most points to the current players.
            if(points > mostPoints){
                mostPoints = points;
                topPlayers.clear();//clear whichever player was on the list
                topPlayers.add(player);//add the player with the new most
            //if players points are equal to the current most points then also add that player to the top players list.
            }else if(points == mostPoints){
                topPlayers.add(player);
            }
            player = NHL_stats.next();//move to the next player in the list of stats
        }
        PlayerRecord topPlayer = topPlayers.first();//initialize a new PlayerRecord object to iterate through the list of top scoring players starting with the first.
        //print out players in the topPlayers list.
        while(topPlayer != null){
            System.out.println(topPlayer.getName() + " " + topPlayer.getTeamName());
            topPlayer = topPlayers.next();
        }
    }

    //Logic for this method is nearly identical to that of the mostPoints() method. For more clarification on the codes logic, take a look at mostPoints().
    public void mostAggressive(){
        PlayerRecord player = NHL_stats.first();
        int mostPenaltyMinutes = 0;
        List<PlayerRecord> aggressivePlayers = new List<>();
        while(player != null){
            int penaltyMinutes = player.getPenaltyMinutes();
            if(penaltyMinutes > mostPenaltyMinutes){
                mostPenaltyMinutes = penaltyMinutes;
                aggressivePlayers.clear();
                aggressivePlayers.add(player);
            }else if(penaltyMinutes == mostPenaltyMinutes){
                aggressivePlayers.add(player);
            }
            player = NHL_stats.next();
        }
        PlayerRecord aggressivePlayer = aggressivePlayers.first();
        while(aggressivePlayer != null){
            System.out.println(aggressivePlayer.getName() + " " + aggressivePlayer.getTeamName() + " " + aggressivePlayer.getPosition());
            aggressivePlayer = aggressivePlayers.next();
        }

    }

    //Logic for this method is nearly identical to that of the mostPoints() method. For more clarification on the codes logic, take a look at mostPoints().
    public void mostMVPs(){
        PlayerRecord player = NHL_stats.first();
        int mostMVPs = 0;
        List<PlayerRecord> highestMVPPlayers = new List<>();
        while(player != null){
            int totalMVPs = player.getGameWinningGoals();
            if(totalMVPs > mostMVPs){
                mostMVPs = totalMVPs;
                highestMVPPlayers.clear();
                highestMVPPlayers.add(player);
            }else if(mostMVPs == totalMVPs){
                highestMVPPlayers.add(player);
            }
            player = NHL_stats.next();
        }
        PlayerRecord highMVPPlayer = highestMVPPlayers.first();
        while(highMVPPlayer != null){
            System.out.println(highMVPPlayer.getName() + " " + highMVPPlayer.getTeamName());
            highMVPPlayer = highestMVPPlayers.next();
        }
    }

    //Logic for this method is nearly identical to that of the mostPoints() method. For more clarification on the codes logic, take a look at mostPoints().
    public void mostPromisingPlayer(){
        PlayerRecord player = NHL_stats.first();
        int mostShotsOnGoal = 0;
        List<PlayerRecord> mostPromisingPlayers = new List<>();
        while(player != null){
            int totalShotsOnGoal = player.getShotsOnGoal();
            if(totalShotsOnGoal > mostShotsOnGoal){
                mostShotsOnGoal = totalShotsOnGoal;
                mostPromisingPlayers.clear();
                mostPromisingPlayers.add(player);
            }else if(mostShotsOnGoal == totalShotsOnGoal){
                mostPromisingPlayers.add(player);
            }
            player = NHL_stats.next();
        }
        PlayerRecord promisingPlayer = mostPromisingPlayers.first();
        while(promisingPlayer != null){
            System.out.println(promisingPlayer.getName() + " " + promisingPlayer.getTeamName());
            promisingPlayer = mostPromisingPlayers.next();
        }
    }

    //Struggled to implement this method using Lists similar to the previous methods, so instead opted to use a HashMap to keep track and compare the two variables easier.
    public void teamWithMostPenaltyMinutes(){
        Map<String, Integer> teamPenaltyMinutes = new HashMap<>();
        PlayerRecord player = NHL_stats.first();
        while(player != null){
            // two variables to hold the current players team name and penalty minutes
            String teamName = player.getTeamName();
            int penaltyMinutes = player.getPenaltyMinutes();
            //Insert a new key value pair into the hashmap. the key being teamName and the value being the total penalty minutes for that team.
            teamPenaltyMinutes.put(teamName, teamPenaltyMinutes.getOrDefault(teamName, 0) + penaltyMinutes);
            player = NHL_stats.next();
        }
        /*
        finds the total penalty minutes for each team then converts the values into a stream. It then maps the Stream<Integer> into an IntStream.
        The .max() then finds the maximum value of in the case the team with the most penalty minutes unless the Int returned by max is empty in which case it will return a value of 0.
         */
        int maxPenaltyMinutes = teamPenaltyMinutes.values().stream().mapToInt(Integer::intValue).max().orElse(0);

        /*
        Method .entrySet() will return a Set of all the entries in the HashMap. This is what will be looped through. getValue() within the loop operations will retrieve the total penalty
        minutes of the team. If this value is equal to 0 the maxPenalityMinutes then that mean tht is the team with the highest minutes and will return that key.
         */
        for(Map.Entry<String, Integer> entry : teamPenaltyMinutes.entrySet()){
            if(entry.getValue() == maxPenaltyMinutes){
                System.out.println(entry.getKey());
            }
        }
    }

    //Logic for this method is nearly identical to that of teamWithMostPenaltyMinutes(). Refer to that method for more clarification on the logic.
    public void teamWithMostGameWinningGoals(){
        Map<String, Integer> teamGameWinningGoals = new HashMap<>();
        PlayerRecord player = NHL_stats.first();
        while(player != null){
            String teamName = player.getTeamName();
            int gameWinningGoals = player.getGameWinningGoals();
            teamGameWinningGoals.put(teamName, teamGameWinningGoals.getOrDefault(teamName, 0) + gameWinningGoals);
            player = NHL_stats.next();
        }
        int maxTeamGameWinningGoals = teamGameWinningGoals.values().stream().mapToInt(Integer::intValue).max().orElse(0);
        for(Map.Entry<String, Integer> entry : teamGameWinningGoals.entrySet()){
            if(entry.getValue() == maxTeamGameWinningGoals){
                System.out.println(entry.getKey());
            }
        }
    }

}
