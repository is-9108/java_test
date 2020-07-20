package com.IS;

import java.util.*;

public class Battle {
    public static Player battle(Player player,Enemy enemy){
        Items items = new Items();
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
                    enemy.hitPoint -= player.attack + player.weaponPoint;
                    System.out.println(player.attack + player.weaponPoint + "ダメージを与えた");
                    if(enemy.hitPoint <= 0){
                        System.out.println("敵を倒した");
                        System.out.println(enemy.exp + "ポイント経験値を得た");
                        if(enemy.name == "スライムLv."){
                            if(ran < 5){
                                System.out.println("回復薬を落とした");
                                player.healCount ++;
                            }else if(ran == 10) {
                                System.out.println("木の棒を落とした(攻撃力＋" + items.tree + ")");
                                System.out.println("装備しますか?(y/n)");
                                String weapon = scanner.next();
                                if (weapon == "y") {
                                    player.weaponPoint = items.tree;
                                } else if (weapon == "n") {
                                    System.out.println("木の棒を捨てた");
                                } else {
                                    System.out.println("yかnを押して下さい");
                                }
                            }
                        }else if(enemy.name == "ナイトLv."){
                            if(ran < 5){
                                System.out.println("回復薬を落とした");
                                player.healCount ++;
                            }else if(ran == 10) {
                                System.out.println("剣を落とした(攻撃力＋" + items.sword + ")");
                                System.out.println("装備しますか?(y/n)");
                                String weapon = scanner.next();
                                if (weapon == "y") {
                                    player.weaponPoint = items.sword;
                                } else if (weapon == "n") {
                                    System.out.println("剣を捨てた");
                                } else {
                                    System.out.println("yかnを入力して下さい");
                                }
                            }
                        }
                        player.exp += enemy.exp;
                        return player;
                    }else if(enemy.hitPoint > 0){
                        System.out.println("敵の攻撃");
                        System.out.println(enemy.attack + "ダメージ受けた");
                        player.hitPoint -= enemy.attack;
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
