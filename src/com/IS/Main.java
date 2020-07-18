package com.IS;

public class Main {

    public static void main(String[] args) {
        Maps map = new Maps();
        Move move = new Move();
        Battle battle = new Battle();
        int positionX = 1;
        int positionY = 1;
        String[][] stage = map.map1;
        while (true) {
            move.move(stage, positionY, positionX);
        }
    }

}