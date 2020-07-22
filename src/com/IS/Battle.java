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
            System.out.println("じぶんのHP：" +player.hitPoint + "/" + player.maxHp);
            System.out.println(enemy.name + "のHP：" + enemy.hitPoint);
            System.out.println("a：攻撃　h：回復");
            System.out.print("コマンドを入力:");
            String key = scanner.next();
            switch (key){
                case "a":
                    System.out.println("主人公の攻撃");
                    enemy.hitPoint -= player.attack + player.weaponPoint;
                    System.out.println(player.attack + player.weaponPoint + "ダメージを与えた");
                    if(enemy.hitPoint <= 0){
                        System.out.println(enemy.name + "を倒した");
                        System.out.println(enemy.exp + "ポイント経験値を得た");
                        if(ran < 5){
                            System.out.println("---------------------");
                            System.out.println("回復薬を落とした");
                            System.out.println("---------------------");
                            player.healCount ++;
                        }else if(ran < 10 && ran >= 8) {
                            System.out.println("---------------------");
                            System.out.println("木の棒を落とした(攻撃力＋" + items.tree + ")");
                            System.out.println("装備しますか?(y/n)");
                            String weapon = scanner.next();
                            switch (weapon) {
                                case "y":
                                    System.out.println("木の棒を装備した");
                                    player.weaponPoint = items.tree;
                                    break;
                                case "n":
                                    System.out.println("木の棒を捨てた");
                                    break;
                                default:
                                    System.out.println("yかnを押して下さい");
                                    break;
                            }
                            System.out.println("---------------------");
                        }else if(ran ==10) {
                            System.out.println("---------------------");
                            System.out.println("剣を落とした(攻撃力＋" + items.sword + ")");
                            System.out.println("装備しますか?(y/n)");
                            String weapon = scanner.next();
                            switch (weapon) {
                                case "y":
                                    System.out.println("剣を装備した");
                                    player.weaponPoint = items.tree;
                                    break;
                                case "n":
                                    System.out.println("剣を捨てた");
                                    break;
                                default:
                                    System.out.println("yかnを押して下さい");
                                    break;
                            }
                            System.out.println("---------------------");
                        }
                        player.exp += enemy.exp;
                        return player;
                    }else if(enemy.hitPoint > 0){
                        System.out.println(enemy.name + "の攻撃");
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
                    System.out.println(enemy.name + "の攻撃");
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
            System.out.println("---------------------");
            System.out.println("回復薬がありません");
            System.out.println("---------------------");
        }else if(player.hitPoint == player.maxHp) {
            System.out.println("---------------------");
            System.out.println("これ以上回復できません");
            System.out.println("---------------------");
        }else{
            System.out.println("---------------------");
            player.healCount --;
            if(player.heal + player.hitPoint > player.maxHp){
                player.hitPoint = player.maxHp;
            }else{
                player.hitPoint += player.heal;
            }
            System.out.println("HPを回復した");
            System.out.println("残り回復薬の数は" + player.healCount + "です");
            System.out.println("---------------------");
        }
        return player;
    }

}
