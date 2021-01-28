package org.academiadecodigo.leo.codewor.gameObject;

import org.academiadecodigo.leo.codewor.Grid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class GameObject {

    private int col;
    private int row;
    private Rectangle rectangle;


    public GameObject(int col, int row, Color color){

        this.col = col;
        this.row = row;

        rectangle = new Rectangle(col, row, Grid.CELL_SIZE, Grid.CELL_SIZE);
        rectangle.setColor(color);
        rectangle.fill();

    }


    public int getCol() {
        return col;
    }


    public int getRow() {
        return row;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
