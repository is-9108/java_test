package com.IS;

public class Main {

    public static void main(String[] args) {
        Maps map = new Maps();
        Move move = new Move();
        int positionX = 1;
        int positionY = 1;
        String[][] stage = map.map1;
        stage[positionY][positionX] = "P";
        for(int i = 0; i < stage.length; i++){
            for(int j = 0; j < stage[i].length; j ++){
                System.out.print(stage[i][j]);
            }
            System.out.println("");
        }
        while (true) {
            move.move(stage, positionY, positionX);
        }
    }

}