package org.academiadecodigo.leo.codewor;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Grid {

    private Picture grid;

    public static int CELL_SIZE = 20;
    public static int PADDING = 10;

    public Grid(){

        grid = new Picture(PADDING, PADDING, "resources/back.png");
        grid.draw();

    }

}
