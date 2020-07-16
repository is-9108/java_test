package com.IS;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        //maps
        Maps map = new Maps();
        //map1
        String[][] stage = map.map1;

        int stageNumber = 1;

        //player
        Player player = new Player();
        player.hitPoint = 10;
        player.attack = 10;
        player.heal = 5;
        player.items = new String[]{
                "1:",
                "2:",
                "3:",
                "4:",
                "5:",
                "6:",
                "7:",
                "8:",
                "9:",
                "10:"
        };
        player.weapon = "なし";

        //weapon
        if (player.weapon == "なし") {
            player.attack += 0;
        } else if (player.weapon == "剣") {
            player.attack += 10;
        } else if (player.weapon == "大剣") {
            player.attack += 20;
            player.hitPoint -= 10;
        }


        //enemy
        //slime
        Ememy slime = new Ememy();
        slime.name = "slime";
        slime.hitPoint = 10;
        slime.exp = 10;
        slime.art = new String[]{
                "     #     ",
                "   #   #   ",
                " ##     ## ",
                "#   # #   #",
                " #   #   # ",
                "   #####   "
        };

        //playerPosition
        int positonX = 1;
        int positonY = 1;

        Scanner scanner = new Scanner(System.in);



        stage[positonY][positonX] = "P";

        for(int i = 0; i < stage.length; i++) {
            for (int j = 0; j < stage[i].length; j++) {
                System.out.print(stage[i][j]);
            }
            System.out.println("");
        }

        while (true){
            System.out.println("コマンドを入力:");
            String key = scanner.next();
            stage[positonY][positonX] = " ";
            switch (key){
                case "w":
                    positonY--;
                    if(positonY <= 1){
                        System.out.println("範囲外です");
                        positonY ++;
                    }
                    break;
                case "a":
                    positonX --;
                    if(positonX <= 1){
                        System.out.println("範囲外です");
                        positonX ++;
                    }
                    break;
                case "s":
                    positonY ++;
                    if(positonY >= 6){
                        System.out.println("範囲外です");
                        positonY --;
                    }
                    break;
                case "d":
                    positonX ++;
                    if(positonX >= 11){
                        System.out.println("範囲外です");
                        positonX --;
                    }
                    break;
                case "f":
                    return;
                default:
                    System.out.println("easd");
                    break;
            }
            if(stage[positonY][positonX] == "G"){
                stageNumber ++;
                switch (stageNumber){
                    case 2:
                        stage = map.map2;
                        break;
                    case 3:
                        stage = map.map3;
                        break;
                    case 4:
                        stage = map.map4;
                        break;
                    case 5:
                        stage = map.map5;
                        break;
                    case 6:
                        stage = map.map6;
                    case 7:
                        stage = map.map7;
                        break;
                    case 8:
                        stage = map.map8;
                        break;
                    case 9:
                        stage = map.map9;
                        break;
                    case 10:
                        System.out.println("FIN");
                        return;
                    default:
                        System.out.println("ERROR");
                        return;
                }

                positonX = 1;
                positonY = 1;
            }
            creatMap(stage,positonY,positonX);
        }

    }

    public static void creatMap(String[][] map, int positionY, int positionX) {
        String[][] stage = map;
        stage[positionY][positionX] = "P";
        for (int i = 0; i < stage.length; i++) {
            for (int j = 0; j < stage[i].length; j++) {
                System.out.print(stage[i][j]);
            }
            System.out.println("");
        }
    }
}