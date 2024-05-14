package com.day02p02;

public class Tester {
    public static void main(String[] args) throws NotEligibleException {
        CricketRating player1 = new CricketRating("John  ", 9.3f, 9.67f, 8.7f);
		player1.display();

        CricketRating player2 = new CricketRating("Henry  ", 1.5f, 0);
		player2.display();
    }
}