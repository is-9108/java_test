package com.IS;

import java.util.Random;
import java.util.Scanner;

public class Move {
    public static void move(String[][] stage,int positonY,int positonX){
        Scanner scanner = new Scanner(System.in);
        int stageNumber = 1;

        Maps map = new Maps();

        Battle battle = new Battle();

        Player player = new Player();


        Ememy slime = new Ememy();
        slime.name = "slime";
        slime.hitPoint = 10;
        slime.exp = 10;
        slime.attack = 10;

        while (true){
            System.out.println("コマンドを入力:");
            String key = scanner.next();
            stage[positonY][positonX] = " ";
            Random random = new Random();
            int ran = random.nextInt(10);
            switch (key){
                case "w":
                    positonY--;
                    if(ran < 3){
                        System.out.println("敵が現れた");
                        battle.battle(slime.hitPoint,slime.attack,slime.name,slime.exp);
                    }else{
                        System.out.println(ran);
                    }
                    if(positonY <= 1){
                        System.out.println("範囲外です");
                        positonY ++;
                    }
                    break;
                case "a":
                    positonX --;
                    if(ran < 3){
                        System.out.println("敵が現れた");
                        battle.battle(slime.hitPoint,slime.attack,slime.name,slime.exp);
                    }else{
                        System.out.println(ran);
                    }
                    if(positonX <= 1){
                        System.out.println("範囲外です");
                        positonX ++;
                    }
                    break;
                case "s":
                    positonY ++;
                    if(ran < 3){
                        System.out.println("敵が現れた");
                        battle.battle(slime.hitPoint,slime.attack,slime.name,slime.exp);
                    }else{
                        System.out.println(ran);
                    }
                    if(positonY >= 6){
                        System.out.println("範囲外です");
                        positonY --;
                    }
                    break;
                case "d":
                    positonX ++;
                    if(ran < 3){
                        System.out.println("敵が現れた");
                        battle.battle(slime.hitPoint,slime.attack,slime.name,slime.exp);
                    }else{
                        System.out.println(ran);
                    }
                    if(positonX >= 11){
                        System.out.println("範囲外です");
                        positonX --;
                    }
                    break;
                case "f":
                    System.exit(0);
                default:
                    System.out.println("easd");
                    System.out.println(player.exp);
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
