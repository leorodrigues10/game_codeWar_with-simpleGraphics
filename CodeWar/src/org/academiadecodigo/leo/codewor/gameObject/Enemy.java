package org.academiadecodigo.leo.codewor.gameObject;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Enemy extends GameObject {

    private Picture picture;

    public Enemy(int col, int row, Color color) {
        super(col, row, color);

        picture = new Picture(col -55 , row -65, "resources/Ship2.png");
        picture.draw();

    }


    public Picture getPicture() {
        return picture;
    }
}
