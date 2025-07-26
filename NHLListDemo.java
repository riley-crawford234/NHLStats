import java.util.Scanner;
import java.io.*;
import java.util.StringTokenizer;
public class NHLListDemo {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the filename to read from: ");
        String fileName = keyboard.nextLine();

        try {
            File file = new File(fileName);//create a new file with the file name that was inputted
            Scanner inputFile = new Scanner(file);

            NHLStats NHL_stats = new NHLStats();

            while (inputFile.hasNext()) {
                String player = inputFile.nextLine().trim();
                StringTokenizer token = new StringTokenizer(player, "\t");
                String name = token.nextToken();
                String position = token.nextToken();
                String teamName = token.nextToken();
                int gamesPlayed = Integer.parseInt(token.nextToken());
                int goalsScored = Integer.parseInt(token.nextToken());
                int assists = Integer.parseInt(token.nextToken());
                int penaltyMinutes = Integer.parseInt(token.nextToken());
                int shotsOnGoal = Integer.parseInt(token.nextToken());
                int gameWinningGoals = Integer.parseInt(token.nextToken());
                PlayerRecord record = new PlayerRecord(name, position, teamName, gamesPlayed, goalsScored, assists, penaltyMinutes, shotsOnGoal, gameWinningGoals);
                NHL_stats.add(record);
            }
            inputFile.close();
            System.out.println("Players with highest points and their teams:");
            NHL_stats.mostPoints();
            System.out.println("Most aggressive players, their teams and their positions:");
            NHL_stats.mostAggressive();
            System.out.println("Most valuable players and their teams");
            NHL_stats.mostMVPs();
            System.out.println("Most promising players and their teams");
            NHL_stats.mostPromisingPlayer();
            System.out.println("Teams with the most penalty minutes");
            NHL_stats.teamWithMostPenaltyMinutes();
            System.out.println("Team with most game winning goals");
            NHL_stats.teamWithMostGameWinningGoals();
        }catch(FileNotFoundException e){//Makes sure that the file was found
            System.out.println("Error: The file was not found.");
        }




    }
}
