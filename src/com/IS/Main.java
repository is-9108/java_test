package com.IS;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        //maps
        Maps map = new Maps();
        String[][] stage = map.map1;

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
                "#   #  #  #",
                " #   ##  # ",
                "   #####   "
        };

        //playerPosition
        int positonX = 0;
        int positonY = 0;

        Scanner scanner = new Scanner(System.in);



        stage[positonY][positonX] = "P";

        for(int i = 0; i < stage.length; i++) {
            for (int j = 0; j < stage[i].length; j++) {
                System.out.print(stage[i][j]);
            }
            System.out.println("");
        }

//

        while (true){
            System.out.println("コマンドを入力:");
            String key = scanner.next();
            switch (key){
                case "w":
                    positonY--;
                    break;
                case "a":
                    positonX --;
                    break;
                case "s":
                    positonY ++;
                    break;
                case "d":
                    positonX ++;
                    break;
                default:
                    return;
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