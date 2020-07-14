package com.IS;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //maps
        Maps map = new Maps();
        String[][] stage = map.map1;

        //enemy
        //slime
        Ememy slime = new Ememy();
        slime.name = "slime";
        slime.hitPoint = 10;
        slime.exp = 10;
        slime.art = new String[]{
                "     #     ",
                "   #   #   ",
                " ##     ## ",
                "#   #  #  #",
                " #   ##  # ",
                "   #####   "
        };


        for(int i = 0; i < stage.length; i++) {
            for (int j = 0; j < stage[i].length; j++) {
                System.out.print(stage[i][j]);
            }
            System.out.println("");
        }

        int positonX = 0;
        int positonY = 0;

    }

    public void keyPressed(KeyEvent e){
       switch (e.getKeyChar()){
           case 'a':
               System.out.println('a');
               break;
       }
    }
}
