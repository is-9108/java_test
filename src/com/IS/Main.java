package com.IS;

import java.util.Random;
import java.util.Scanner;

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
//        //maps
//        Maps map = new Maps();
//        String[][] stage = map.map1;
//        int stageNumber = 1;
//        //maps
//
//        //player
//        Player player = new Player();
//        player.hitPoint = 10;
//        player.maxHp = 10;
//        player.attack = 10;
//        player.heal = 5;
//        player.exp = 0;
//        player.items = new String[]{
//
//        };
//        player.weapon = "なし";
//        if (player.weapon == "なし") {
//            player.attack += 0;
//        } else if (player.weapon == "剣") {
//            player.attack += 10;
//        } else if (player.weapon == "大剣") {
//            player.attack += 20;
//            player.hitPoint -= 10;
//        }
//        //player
//
//
//        //enemy
//        //slime
//        Ememy slime = new Ememy();
//        slime.name = "slime";
//        slime.hitPoint = 10;
//        slime.exp = 10;
//        slime.attack = 10;
//        //enemy
//
//        //command
//        int positonX = 1;
//        int positonY = 1;
//        Scanner scanner = new Scanner(System.in);
//        stage[positonY][positonX] = "P";
//        //command
//
//        for(int i = 0; i < stage.length; i++) {
//            for (int j = 0; j < stage[i].length; j++) {
//                System.out.print(stage[i][j]);
//            }
//            System.out.println("");
//        }
//
//        while (true){
//            System.out.println("コマンドを入力:");
//            String key = scanner.next();
//            stage[positonY][positonX] = " ";
//            Random random = new Random();
//            int ran = random.nextInt(10);
//            switch (key){
//                case "w":
//                    positonY--;
//                    if(ran < 3){
//                        System.out.println("敵が現れた");
//                        player.exp = battle(player.hitPoint,player.maxHp,player.attack,player.heal,player.items,
//                                player.exp,slime.hitPoint,slime.attack,slime.name,slime.exp);
//                    }else{
//                        System.out.println(ran);
//                    }
//                    if(positonY <= 1){
//                        System.out.println("範囲外です");
//                        positonY ++;
//                    }
//                    break;
//                case "a":
//                    positonX --;
//                    if(ran < 3){
//                        System.out.println("敵が現れた");
//                        player.exp = battle(player.hitPoint,player.maxHp,player.attack,player.heal,player.items,
//                                player.exp,slime.hitPoint,slime.attack,slime.name,slime.exp);
//                    }else{
//                        System.out.println(ran);
//                    }
//                    if(positonX <= 1){
//                        System.out.println("範囲外です");
//                        positonX ++;
//                    }
//                    break;
//                case "s":
//                    positonY ++;
//                    if(ran < 3){
//                        System.out.println("敵が現れた");
//                        player.exp = battle(player.hitPoint,player.maxHp,player.attack,player.heal,player.items,
//                                player.exp,slime.hitPoint,slime.attack,slime.name,slime.exp);
//                    }else{
//                        System.out.println(ran);
//                    }
//                    if(positonY >= 6){
//                        System.out.println("範囲外です");
//                        positonY --;
//                    }
//                    break;
//                case "d":
//                    positonX ++;
//                    if(ran < 3){
//                        System.out.println("敵が現れた");
//                        player.exp = battle(player.hitPoint,player.maxHp,player.attack,player.heal,player.items,
//                                player.exp,slime.hitPoint,slime.attack,slime.name,slime.exp);
//                    }else{
//                        System.out.println(ran);
//                    }
//                    if(positonX >= 11){
//                        System.out.println("範囲外です");
//                        positonX --;
//                    }
//                    break;
//                case "f":
//                    return;
//                default:
//                    System.out.println("easd");
//                    System.out.println(player.exp);
//                    break;
//            }
//            if(stage[positonY][positonX] == "G"){
//                stageNumber ++;
//                switch (stageNumber){
//                    case 2:
//                        stage = map.map2;
//                        break;
//                    case 3:
//                        stage = map.map3;
//                        break;
//                    case 4:
//                        stage = map.map4;
//                        break;
//                    case 5:
//                        stage = map.map5;
//                        break;
//                    case 6:
//                        stage = map.map6;
//                    case 7:
//                        stage = map.map7;
//                        break;
//                    case 8:
//                        stage = map.map8;
//                        break;
//                    case 9:
//                        stage = map.map9;
//                        break;
//                    case 10:
//                        System.out.println("FIN");
//                        return;
//                    default:
//                        System.out.println("ERROR");
//                        return;
//                }
//
//                positonX = 1;
//                positonY = 1;
//            }
//            creatMap(stage,positonY,positonX);
//        }
//
//    }
//
//    public static void creatMap(String[][] map, int positionY, int positionX) {
//        String[][] stage = map;
//        stage[positionY][positionX] = "P";
//        for (int i = 0; i < stage.length; i++) {
//            for (int j = 0; j < stage[i].length; j++) {
//                System.out.print(stage[i][j]);
//            }
//            System.out.println("");
//        }
//    }
//
//    public static int battle(int heroHP,int heroMaxHp,int heroAttack,int heroHeal,String[] heroItems,
//                             int heroExp,int enemyHP,int enemyAttack,String enemyName,int enemyExp){
//        Scanner scanner = new Scanner(System.in);
//        System.out.println(enemyName + "が現れた");
//        while (heroHP >= 0){
//            System.out.println("--------------------");
//            System.out.println(heroHP + "/" + heroMaxHp);
//            System.out.println("コマンドを入力:");
//            String key = scanner.next();
//            switch (key){
//                case "a":
//                    System.out.println("主人公の攻撃");
//                    enemyHP -= heroAttack;
//                    if(enemyHP <= 0){
//                        System.out.println("敵を倒した");
//                        System.out.println(enemyExp + "ポイント経験値を得た");
//                        heroExp += enemyExp;
//                        return heroExp;
//                    }else if(enemyHP > 0){
//                        System.out.println("敵の攻撃");
//                        System.out.println(enemyAttack + "ダメージ受けた");
//                        heroHP -= enemyAttack;
//                        if(heroHP <= 0){
//                            System.out.println("Game over");
//                        }
//                    }
//                    break;
//                case "h":
//                    for(int i = 0;i < heroItems.length; i++){
//                        System.out.println(i + ":" + heroItems[i]);
//                    }
//                    int command = scanner.nextInt();
//                    System.out.println("番号を入力して下さい");
//                    switch (command){
//                        case 1:
//                            heroItems[0] = "";
//                            break;
//                        case 2:
//                            heroItems[1] = "";
//                            break;
//                        case 3:
//                            heroItems[2] = "";
//                            break;
//                        case 4:
//                            heroItems[3] = "";
//                            break;
//                        case 5:
//                            heroItems[4] = "";
//                            break;
//                        default:
//                            break;
//                    }
//            }
//            System.out.println("--------------------");
//        }
//        return heroExp;
    }

}