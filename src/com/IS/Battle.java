package com.IS;

import java.util.Scanner;

public class Battle {
    public static Player battle(int enemyHP,int enemyAttack,String enemyName,int enemyExp){
        Player player = new Player();
        Scanner scanner = new Scanner(System.in);
        System.out.println(enemyName + "が現れた");
        while (player.hitPoint >= 0){
            System.out.println("--------------------");
            System.out.println(player.hitPoint + "/" + player.maxHp);
            System.out.println("コマンドを入力:");
            String key = scanner.next();
            switch (key){
                case "a":
                    System.out.println("主人公の攻撃");
                    enemyHP -= player.attack;
                    if(enemyHP <= 0){
                        System.out.println("敵を倒した");
                        System.out.println(enemyExp + "ポイント経験値を得た");
                        player.exp += enemyExp;
                        return player;
                    }else if(enemyHP > 0){
                        System.out.println("敵の攻撃");
                        System.out.println(enemyAttack + "ダメージ受けた");
                        player.hitPoint -= enemyAttack;
                        if(player.hitPoint <= 0){
                            System.out.println("Game over");
                            System.exit(0);
                        }
                    }
                    break;
                case "h":
                    for(int i = 0;i < player.items.length; i++){
                        System.out.println(i + ":" + player.items[i]);
                    }
                    int command = scanner.nextInt();
                    System.out.println("番号を入力して下さい");
                    switch (command){
                        case 1:
                            player.items[0] = "";
                            break;
                        case 2:
                            player.items[1] = "";
                            break;
                        case 3:
                            player.items[2] = "";
                            break;
                        case 4:
                            player.items[3] = "";
                            break;
                        case 5:
                            player.items[4] = "";
                            break;
                        default:
                            break;
                    }
            }
            System.out.println("--------------------");
        }
        return player;
    }
}
