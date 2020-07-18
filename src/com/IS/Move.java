package com.IS;

import java.util.Random;
import java.util.Scanner;

public class Move {
    public static void move(String[][] stage,int positonY,int positonX){
        Scanner scanner = new Scanner(System.in);
        int stageNumber = 1;

        Maps map = new Maps();
        Player player = new Player();
        Battle battle = new Battle();

        Ememy slime = new Ememy();
        slime.name = "slime";
        slime.hitPoint = 10;
        slime.exp = 10;
        slime.attack = 1;

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
                        player = battle.battle(player,slime.hitPoint,slime.attack,slime.name,slime.exp);
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
                        player = battle.battle(player,slime.hitPoint,slime.attack,slime.name,slime.exp);
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
                        player = battle.battle(player,slime.hitPoint,slime.attack,slime.name,slime.exp);
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
                        player = battle.battle(player,slime.hitPoint,slime.attack,slime.name,slime.exp);
                    }else{
                        System.out.println(ran);
                    }
                    if(positonX >= 11){
                        System.out.println("範囲外です");
                        positonX --;
                    }
                    break;
                case "u":
                    System.out.println(player.healCount);
                    break;
                case "y":
                    player = levelUP(player);
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

    public static Player levelUP(Player player){
        boolean a = true;
        while (a){
            System.out.println("現在の経験値：" + player.exp);
            System.out.println("--------------------");
            System.out.println("現在の攻撃力：" + player.attack);
            System.out.println("現在の体力：" + player.hitPoint);
            System.out.println("現在の回復力：" + player.heal);
            System.out.println("--------------------");
            System.out.println("1:攻撃力を上げる(必要経験値：５)");
            System.out.println("2:HPを上げる(必要経験値：５)");
            System.out.println("3:回復力を上げる(必要経験値：５)");
            System.out.println("4:終了");
            Scanner scanner = new Scanner(System.in);
            int command = scanner.nextInt();
            switch (command){
                case 1:
                    if(player.exp < 5){
                        System.out.println("経験値が足りません");
                    }else {
                        player.attack += 5;
                        player.exp -= 5;
                    }
                    break;
                case 2:
                    if(player.exp < 5){
                        System.out.println("経験値が足りません");
                    }else{
                        player.hitPoint += 5;
                        player.maxHp += 5;
                        player.exp -= 5;
                    }
                    break;
                case 3:
                    if(player.exp < 5){
                        System.out.println("経験値が足りません");
                    }else {
                        player.heal += 5;
                        player.exp -= 5;
                    }
                    break;
                case 4:
                    a = false;
                    break;
                default:
                    System.out.println("1~４を押して下さい");
                    break;
            }
        }
        return player;
    }
}
