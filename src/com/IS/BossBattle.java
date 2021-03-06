package com.IS;

import java.util.Random;
import java.util.Scanner;

public class BossBattle {
    public static Player bossBattle(Player player,Enemy enemy){
        Items items = new Items();
        System.out.println("ボス戦では30%の確率で敵から「通常の２倍の攻撃」がきます");
        System.out.println("また、10%の確率で敵の攻撃を回避する事ができます");
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
            boolean com = true;
            switch (key){
                case "a":
                    System.out.println("主人公の攻撃");
                    enemy.hitPoint -= player.attack;
                    System.out.println(player.attack + "ダメージを与えた");
                    if(enemy.hitPoint <= 0){
                        System.out.println("敵を倒した");
                        System.out.println(enemy.exp + "ポイント経験値を得た");
                        System.out.println("回復薬を落とした");
                        if(enemy.name == "デュラハン"){
                            System.out.println(enemy.name + "は魔剣を落とした(攻撃力＋" + items.masicSword + ")");
                            System.out.println("魔剣を装備しますか？(y/n)");
                            while(com){
                                String weapon = scanner.next();
                                switch (weapon){
                                    case "y":
                                        System.out.println("魔剣を装備した");
                                        player.weaponPoint = items.masicSword;
                                        com = false;
                                        break;
                                    case "n":
                                        System.out.println("魔剣を捨てた");
                                        com = false;
                                        break;
                                    default:
                                        System.out.println("yかnの入力して下さい");
                                        break;
                                }
                            }
                        }
                        return player;
                    }else if(enemy.hitPoint > 0){
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
