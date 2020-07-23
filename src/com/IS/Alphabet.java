package com.IS;

public class Alphabet {
    String[] H = {
            "＊　　　＊",
            "＊　　　＊",
            "＊＊＊＊＊",
            "＊＊＊＊＊",
            "＊　　　＊",
            "＊　　　＊"
    };
    String[] O = {
            "　＊＊＊　",
            "＊＊　＊＊",
            "＊　　　＊",
            "＊　　　＊",
            "＊＊　＊＊",
            "　＊＊＊　"
    };
    String[] L = {
            "＊　　　　",
            "＊　　　　",
            "＊　　　　",
            "＊　　　　",
            "＊　　　　",
            "＊＊＊＊＊"
    };
    String[] Y = {
            "＊　　　＊",
            "＊　　　＊",
            "＊＊　＊＊",
            "　＊＊＊　",
            "　　＊　　",
            "　　＊　　"
    } ;
    String[] G = {
            "＊＊＊＊＊",
            "＊　　　＊",
            "＊　　　　",
            "＊　＊＊＊",
            "＊　　　＊",
            "＊＊＊＊＊"
    };
    String[] R = {
            "＊＊＊＊＊",
            "＊　　　＊",
            "＊＊＊＊＊",
            "＊＊　　　",
            "＊　＊＊　",
            "＊　　＊＊"
    };
    String[] A = {
            "　＊＊＊　",
            "＊＊　＊＊",
            "＊　　　＊",
            "＊＊＊＊＊",
            "＊　　　＊",
            "＊　　　＊"
    };
    String[] I = {
            "　＊＊＊　",
            "　　＊　　",
            "　　＊　　",
            "　　＊　　",
            "　　＊　　",
            "　＊＊＊　"
    };
    String[] Q = {
            "　＊＊＊　",
            "＊＊　＊＊",
            "＊　　　＊",
            "＊　＊　＊",
            "＊＊　＊　",
            "　＊＊　＊"
    };
    String[] U = {
            "＊　　　＊",
            "＊　　　＊",
            "＊　　　＊",
            "＊　　　＊",
            "＊＊　＊＊",
            "　＊＊＊　"
    };
    String[] E = {
            "＊＊＊＊＊",
            "＊　　　　",
            "＊＊＊＊　",
            "＊＊＊＊　",
            "＊　　　　",
            "＊＊＊＊＊"
    };
    String[] S = {
            "＊＊＊＊＊",
            "＊　　　＊",
            "＊＊＊　　",
            "　　＊＊＊",
            "＊　　　＊",
            "＊＊＊＊＊"

    };
    String[] T = {
            "＊＊＊＊＊",
            "＊　＊　＊",
            "　　＊　　",
            "　　＊　　",
            "　　＊　　",
            "　　＊　　"
    };

    public void holyGrailQuest(){
        for (int i = 0; i < H.length; i++){
            System.out.print("                    ");
            System.out.println(H[i] + "   " + O[i] + "   " + L[i] + "   " + Y[i] + "   " +
                    G[i] + "   " + R[i] + "   " + A[i] + "   " + I[i] + "   " +L[i]);
        }
        System.out.println();
        for(int i = 0; i < H.length; i++){
            System.out.print("                                        ");
            System.out.println(Q[i] + "   " + U[i] + "   " +
                    E[i] + "   " + S[i] + "   " +T[i]);
        }
        System.out.println();
    }

}
