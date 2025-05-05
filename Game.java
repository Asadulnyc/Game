import java.util.Scanner;

public class Game {
    private Level levelOne;
    private Level levelTwo;
    private Level levelThree;
    private boolean bonus;

    /** Postcondition: All instance variables have been initialized. */
    public Game() {
        levelOne = new Level();
        levelTwo = new Level();
        levelThree = new Level();
    }
    /** Returns true if this game is a bonus game and returns false otherwise */
    public boolean isBonus() {
        return bonus;
    }

    public void makeBonus() {
        bonus = true;
    }

    public Level getLevel(int i) {
        if (i ==1) return levelOne;
        if (i ==2) return levelTwo;
        if (i == 3) return levelThree;
        return null;
    }

    /**
     * Simulates the play of this Game (consisting of three levels) and updates all
     * relevant
     * game data
     */
    public void play() {
        System.out.println("Enter Points: ");
        Scanner s = new Scanner(System.in);
        levelOne.setPoints(s.nextInt());
        levelOne.reachGoal();
     }

    /**
     * Returns the score earned in the most recently played game, as described in
     * part (a)
     */
    public int getScore() {
        int score = 0;
        if (levelOne.goalReached()) {
            score += levelOne.getPoints();
            if (levelTwo.goalReached()) {
                score += levelTwo.getPoints();
                if (levelThree.goalReached()) {
                    score += levelThree.getPoints();
                }
            }
        }
        if (isBonus())
            score = score * 3;
        return score;
    }

    /**
     * Simulates the play of num games and returns the highest score earned, as
     * described in part (b)
     * Precondition: num > 0
     */
    public int playManyTimes(int num) {
        int highest = 0;
        for (int i = 0; i < num; i++) {
            play();
            if (getScore()>highest) highest = getScore();
        }
        return highest;
    }
    // There may be instance variables, constructors, and methods that are not
    // shown.
}