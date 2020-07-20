package com.IS;

import java.util.*;

public class Battle {
    public static Player battle(Player player,Enemy enemy){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int ran = random.nextInt(10);
        System.out.println(enemy.name + "が現れた");
        while (player.hitPoint >= 0){
            System.out.println("--------------------");
            System.out.println(player.hitPoint + "/" + player.maxHp);
            System.out.println("敵のHP：" + enemy.hitPoint);
            System.out.println("a：攻撃　h：回復");
            System.out.print("コマンドを入力:");
            String key = scanner.next();
            switch (key){
                case "a":
                    System.out.println("主人公の攻撃");
                    enemy.hitPoint -= player.attack;
                    System.out.println(player.attack + "ダメージを与えた");
                    if(enemy.hitPoint <= 0){
                        System.out.println("敵を倒した");
                        System.out.println(enemy.exp + "ポイント経験値を得た");
                        System.out.println("回復薬を落とした");
                        player.healCount ++;
                        player.exp += enemy.exp;
                        return player;
                    }else if(enemy.hitPoint > 0){
                        System.out.println("敵の攻撃");
                        if(ran < 2){
                            System.out.println("敵の快進の攻撃");
                            player.hitPoint -= enemy.attack * 2;
                        }else if(ran == 10){
                            System.out.println("敵の攻撃を回避した");
                        }else{
                            System.out.println(enemy.attack + "ダメージ受けた");
                            player.hitPoint -= enemy.attack;
                        }
                        if(player.hitPoint <= 0){
                            System.out.println("Game over");
                            System.exit(0);
                        }
                    }
                    break;
                case "h":
                    player = heal(player);
                    System.out.println("敵の攻撃");
                    System.out.println(enemy.attack + "ダメージ受けた");
                    player.hitPoint -= enemy.attack;
                    if(player.hitPoint <= 0){
                        System.out.println("Game over");
                        System.exit(0);
                    }
                    break;
            }
            System.out.println("--------------------");
        }
        return player;
    }


    public static Player heal(Player player){
        if(player.healCount == 0){
            System.out.println("回復薬がありません");
        }else if(player.hitPoint == player.maxHp) {
            System.out.println("これ以上回復できません");
        }else{
            player.healCount --;
            if(player.heal + player.hitPoint > player.maxHp){
                player.hitPoint = player.maxHp;
            }else{
                player.hitPoint += player.heal;
            }
            System.out.println("HPを回復した");
        }
        return player;
    }

}
