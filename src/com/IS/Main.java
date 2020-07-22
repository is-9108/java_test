package com.IS;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Maps map = new Maps();
        Move move = new Move();
        int positionX = 1;
        int positionY = 1;
        String[][] stage = map.map1;
        stage[positionY][positionX] = "P";
        start();
        for(int i = 0; i < 4; i++){
            System.out.println("");
        }
        for(int i = 0; i < stage.length; i++){
            for(int j = 0; j < stage[i].length; j ++){
                System.out.print(stage[i][j]);
            }
            System.out.println("");
        }
        while (true) {
            move.move(stage, positionY, positionX);
        }
    }

    public static void gameIcon(){
        String[] H = {
                "■   ■",
                "■   ■",
                "■■■■■",
                "■■■■■",
                "■   ■", 
                "■   ■"
        };
        String[] O = {
          " ■■■ ",
          "■■ ■■",
          "■   ■",
          "■   ■",
          "■■ ■■",
          " ■■■ "      
        };
        String[] L = {
                "■    ",
                "■    ",
                "■    ",
                "■    ",
                "■    ",
                "■■■■■"
        };
        String[] Y = {
                "■   ■",
                "■   ■",
                "■■ ■■",
                " ■■■ ",
                "  ■  ",
                "  ■  "
        } ;
        String[] G = {
                "■■■■■",
                "■   ■",
                "■    ",
                "■ ■■■",
                "■   ■",
                "■■■■■"
        };
        String[] R = {
                "■■■■■",
                "■   ■",
                "■■■■■",
                "■■   ",
                "■ ■■ ",
                "■  ■■"
        };
        String[] A = {
                " ■■■ ",
                "■■ ■■",
                "■   ■",
                "■■■■■",
                "■   ■",
                "■   ■"
        };
        String[] I = {
                " ■■■ ",
                "  ■  ",
                "  ■  ",
                "  ■  ",
                " ■■■ "
        };
        String[] Q = {
                " ■■■ ",
                "■■ ■■",
                "■   ■",
                "■ ■ ■",
                "■■ ■ ",
                " ■■ ■"
        };
        String[] U = {
                "■   ■",
                "■   ■",
                "■   ■",
                "■■ ■■",
                " ■■■ "
        };
        String[] E = {
                "■■■■■",
                "■    ",
                "■■■■ ",
                "■■■■ ",
                "■    ",
                "■■■■■"
        };
        String[] S = {
                "■■■■■",
                "■   ■",
                "■■■  ",
                "  ■■■",
                "■   ■",
                "■■■■■"
                
        };
        String[] T = {
                "■■■■■",
                "■ ■ ■",
                "  ■  ",
                "  ■  ",
                "  ■  ",
                "  ■  "
        };
    }
    public static void start(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("主「先生、？？は助かるんですか？」");
        scanner.nextLine();
        System.out.println("医者「すみません。私には直せそうにありません。」");
        scanner.nextLine();
        System.out.println("主「そんな！！　何か方法はないんですか？」");
        scanner.nextLine();
        System.out.println("医「たしか村から東へずっと進んだ先の洞窟になんでも治せる聖杯があると聞いた事があります。」");
        System.out.println("医「しかし、洞窟へ行った人は誰も帰ってこないらしいです。」");
        scanner.nextLine();
        System.out.println("主「そうですか・・・。東ですね？」");
        scanner.nextLine();
        System.out.println("医「行くのですか！？」");
        scanner.nextLine();
        System.out.println("主「はい。今まで一緒に旅してきた相棒なので！」");
        scanner.nextLine();
        System.out.println("私が止める権利はありませんね。御武運を");
        scanner.nextLine();
        for(int i = 0; i < 4; i++) {
            System.out.println("・");
        }
        System.out.println("");
        System.out.println("アレックス「お客さん、俺は何人もの人をここへ運んでいますけど本当に行くんですか？」");
        scanner.nextLine();
        System.out.println("主「ああ、行ってくる。」");
        scanner.nextLine();
        System.out.println("アレックス「お気をつけて」");
    }

}