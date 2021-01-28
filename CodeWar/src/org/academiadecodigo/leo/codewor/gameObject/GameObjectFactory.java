package org.academiadecodigo.leo.codewor.gameObject;

import org.academiadecodigo.simplegraphics.graphics.Color;

import java.util.LinkedList;
import java.util.List;

public class GameObjectFactory {

    private static List<Integer> cols;
    private static List<Integer> rows;

    private static int col;
    private static int row;



    public static Player createPlayer(){
        return new Player(250, 750, Color.BLUE);
    }

    public static Enemy createEnemy(){

        checkCols();
        checkRows();

        return new Enemy(col, row, Color.RED);
    }

    private static void createCols(){

        cols = new LinkedList<>();
        for(int i = 70; i <= 430; i += 40){
            cols.add(i);
        }
    }
    private static void checkCols(){

        createCols();
        for(Integer colChecked : cols){
            if(colChecked == randomRange(70, 510)){
                col = colChecked;
                return;
            }
        }
        checkCols();
    }

    private static void createRows(){

        rows = new LinkedList<>();
        for(int i = -610; i <= -10; i += 60){
            rows.add(i);
        }
    }

    private static void checkRows(){

        createRows();
        for(Integer chekedRow : rows){
            if(chekedRow == randomRange(-610, -10)){
                row = chekedRow;
                return;
            }
        }
        checkRows();
    }




    private static int randomRange(int min, int max){
        return (int) (Math.random() * (max - min + 1) + min);
    }
}
