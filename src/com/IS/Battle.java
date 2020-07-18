package com.IS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Battle {
    public static Player battle(Player player,int enemyHP,int enemyAttack,String enemyName,int enemyExp){
        Scanner scanner = new Scanner(System.in);
        String[] items = {};
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
                        System.out.println("回復薬を落とした");
                        player.healCount ++;
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
                    player = heal(player);
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
