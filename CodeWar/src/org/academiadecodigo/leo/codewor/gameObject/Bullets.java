package org.academiadecodigo.leo.codewor.gameObject;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Bullets {

    private Ellipse bullet;
    private Picture bulletPic;
    private int col;
    private int row;

    public Bullets(int col, int row){

        this.col = col;
        this.row = row;

        bullet = new Ellipse(col, row, 5,5);
        bullet.setColor(Color.MAGENTA);
        bullet.draw();

        createPic();

    }

    private void createPic(){
        bulletPic = new Picture(col -58, row -65, "resources/shot1/shot.png");
        bulletPic.draw();
    }

    public Ellipse getBullet() {
        return bullet;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public Picture getBulletPic() {
        return bulletPic;
    }
}
