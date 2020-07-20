package com.IS;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Move {
    public static void move(String[][] stage,int positonY,int positonX){
        Scanner scanner = new Scanner(System.in);
        int stageNumber = 1;
        boolean seihai = false;
        Maps map = new Maps();
        Player player = new Player();
        Battle battle = new Battle();
        BossBattle bossBattle = new BossBattle();

        Enemy enemy = new Enemy();
        Slime slime = new Slime();
        Knight knight = new Knight();

        FirstBoss firstBoss = new FirstBoss();
        LastBoss lastBoss = new LastBoss();

        while (true){
            System.out.println("w：上へ移動　a：左へ移動　s：下へ移動　d：右へ移動　h：回復　y：ステータスを上げる　f：終了");
            System.out.print("コマンドを入力:");
            String key = scanner.next();
            stage[positonY][positonX] = " ";
            Random random = new Random();
            int ran = random.nextInt(10);
            switch (key){
                case "w":
                    positonY--;
                    System.out.println("x:" + positonX);
                    System.out.println("y:" + positonY);
                    if(ran < 2){
                        System.out.println("敵が現れた");
                        if(ran == 0){
                            enemy = init(enemy,stageNumber,knight.hitPoint,knight.name,knight.attack,knight.exp);
                        }else{
                            enemy = init(enemy,stageNumber,slime.hitPoint,slime.name,slime.attack,slime.exp);;
                        }
                        player = battle.battle(player,enemy);
                    }else{
                        System.out.println(ran);
                    }
                    if(positonY < 1){
                        System.out.println("範囲外です");
                        positonY ++;
                    }
                    if(stage[positonY][positonX] == "|" || stage[positonY][positonX] == "-"){
                        System.out.println("行き止まりです");
                        positonY ++;
                    }
                    break;
                case "a":
                    positonX --;
                    System.out.println("x:" + positonX);
                    System.out.println("y:" + positonY);
                    if(ran < 2){
                        System.out.println("敵が現れた");
                        if(ran == 0){
                            enemy = init(enemy,stageNumber,knight.hitPoint,knight.name,knight.attack,knight.exp);;
                        }else{
                            enemy = init(enemy,stageNumber,slime.hitPoint,slime.name,slime.attack,slime.exp);;
                        }
                        player = battle.battle(player,enemy);
                    }else{
                        System.out.println(ran);
                    }
                    if(positonX < 1){
                        System.out.println("範囲外です");
                        positonX ++;
                    }
                    if(stage[positonY][positonX] == "|" || stage[positonY][positonX] == "-"){
                        System.out.println("行き止まりです");
                        positonX ++;
                    }
                    break;
                case "s":
                    positonY ++;
                    System.out.println("x:" + positonX);
                    System.out.println("y:" + positonY);
                    if(ran < 2){
                        System.out.println("敵が現れた");
                        if(ran == 0){
                            enemy = init(enemy,stageNumber,knight.hitPoint,knight.name,knight.attack,knight.exp);;
                        }else{
                            enemy = init(enemy,stageNumber,slime.hitPoint,slime.name,slime.attack,slime.exp);;
                        }
                        player = battle.battle(player,enemy);
                    }else{
                        System.out.println(ran);
                    }
                    if(positonY >= 6){
                        System.out.println("範囲外です");
                        positonY --;
                    }
                    if(stage[positonY][positonX] == "|" || stage[positonY][positonX] == "-"){
                        System.out.println("行き止まりです");
                        positonY --;
                    }
                    break;
                case "d":
                    positonX ++;
                    System.out.println("x:" + positonX);
                    System.out.println("y:" + positonY);
                    if(ran < 2){
                        System.out.println("敵が現れた");
                        if(ran == 0){
                            enemy = init(enemy,stageNumber,knight.hitPoint,knight.name,knight.attack,knight.exp);

                        }else{
                            enemy = init(enemy,stageNumber,slime.hitPoint,slime.name,slime.attack,slime.exp);;
                        }
                        player = battle.battle(player,enemy);
                    }else{
                        System.out.println(ran);
                    }
                    if(positonX >= 11){
                        System.out.println("範囲外です");
                        positonX --;
                    }
                    if(stage[positonY][positonX] == "|" || stage[positonY][positonX] == "-"){
                        System.out.println("行き止まりです");
                        positonX --;
                    }
                    break;
                case "y":
                    player = levelUP(player);
                    break;
                case "k":
                    System.out.println("HP:" + player.hitPoint + "/" + player.maxHp);
                    System.out.println("attack:" + player.attack);
                    System.out.println("exp:" + player.exp);
                    break;
                case "h":
                    player = battle.heal(player);
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
                        break;
                    default:
                        System.out.println("ERROR");
                        return;
                }

                positonX = 1;
                positonY = 2;
            }else if(stage[positonY][positonX] == "B"){
                stageNumber --;
                switch (stageNumber){
                    case 1:
                        if(seihai){
                            stage = map.map6;
                            positonX = 10;
                            positonY = 4;
                        }else{
                            System.out.println("聖杯を入手して下さい");
                            stageNumber ++;
                            positonX = 1;
                            positonY = 2;
                        }
                        break;
                    case 2:
                        stage = map.map2;
                        positonX = 10;
                        positonY = 4;
                        break;
                    case 3:
                        stage = map.map3;
                        positonX = 10;
                        positonY = 4;
                        break;
                    case 4:
                        stage = map.map4;
                        positonX = 10;
                        positonY = 4;
                        break;
                    case 5:
                        stage = map.map5;
                        positonX = 10;
                        positonY = 4;
                        break;
                    case 6:
                        stage = map.map6;
                        positonX = 10;
                        positonY = 4;
                        break;
                    default:
                        System.out.println("ERROR");
                        return;
                }
            }else if(stage[positonY][positonX] == "S"){
                System.out.println("聖杯を入手しました");
                seihai = true;
            }else if(stage[positonY][positonX] == "C"){
                System.out.println("Game Clear");
                System.exit(0);
            }else if(stage[positonY][positonX] == "E"){
                if(stageNumber == 5){
                    enemy = bossInit(enemy,firstBoss.hitPoint,firstBoss.name,firstBoss.attack);
                }else if(stageNumber == 6){
                    enemy = bossInit(enemy,lastBoss.hitPoint,lastBoss.name,lastBoss.attack);
                }
                player = bossBattle.bossBattle(player,enemy);
            }
            creatMap(stage,positonY,positonX);
        }
    }
    public static void creatMap(String[][] map, int positionY, int positionX) {
        String[][] stage = map;
        stage[positionY][positionX] = "P";
        System.out.println("\033[2J");
        for (int i = 0; i < stage.length; i++) {
            for (int j = 0; j < stage[i].length; j++) {
                System.out.print(stage[i][j]);
            }
            System.out.println("");
        }
        System.out.println("-：行き止まり　|：行き止まり　B：前の部屋に戻る　P：プレイヤー　" +
                "G：次の部屋へ進む　S：聖杯（入手しなければクリアできません）");
    }
    
    public static Enemy init(Enemy enemy,int stage,int hitPoint,String name,int attack,int exp){
        enemy.name = name + String.valueOf(stage);
        enemy.hitPoint = hitPoint * stage;
        enemy.attack = attack * stage;
        enemy.exp = exp + stage;
        return enemy;
    }

    public static Enemy bossInit(Enemy enemy,int hitPoint,String name,int attack){
        enemy.name = name;
        enemy.hitPoint = hitPoint;
        enemy.attack = attack;
        return enemy;
    }

    public static Player levelUP(Player player){
        boolean a = true;
        while (a){
            System.out.println("現在の経験値：" + player.exp);
            System.out.println("--------------------");
            System.out.println("現在の攻撃力 (装備の攻撃力補正)：" + player.attack + "(+" + player.weaponPoint + ")");
            System.out.println("現在の体力：" + player.hitPoint + "/" + player.maxHp);
            System.out.println("現在の回復力：" + player.heal);
            System.out.println("--------------------");
            System.out.println("1:攻撃力を上げる +5 (必要経験値：５)");
            System.out.println("2:HPを上げる +5 (必要経験値：５)");
            System.out.println("3:回復力を上げる +5 (必要経験値：５)");
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
