package org.academiadecodigo.leo.codewor.gameObject;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.List;

public class Player extends GameObject{

    private Picture picture;
    private Picture bullet;

    public Player(int col, int row, Color color) {
        super(col, row, color);

        picture = new Picture(col - 23, row -10, "resources/Ship6.png");
        picture.draw();


    }

    public Bullets createBullets(){
       return new Bullets(getCol(), getRow());
    }


    public void moveUp(){
        if(getRectangle().getY() > 310){
            getRectangle().translate(0, -20);
            setRow(getRow() - 20);
            picture.translate(0,-20);
        }
    }
    public void moveDown(){
        if(getRectangle().getY() + getRectangle().getHeight() < 750){
            getRectangle().translate(0, 20);
            setRow(getRow() + 20);
            picture.translate(0,20);
        }
    }
    public void moveLeft(){
        if(getRectangle().getX() > 30){
            getRectangle().translate(-20, 0);
            setCol(getCol() - 20);
            picture.translate(-20, 0);
        }

    }
    public void moveRight(){
        if(getRectangle().getX() + getRectangle().getWidth() < 450){
            getRectangle().translate(20, 0);
            setCol(getCol() + 20);
            picture.translate(20, 0);
        }
    }


}
