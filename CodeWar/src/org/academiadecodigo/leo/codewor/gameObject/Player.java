package org.academiadecodigo.leo.codewor.gameObject;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player extends GameObject{

    private Picture picture;
    private Picture[] lives;
    private int health = 10;
    private boolean dead;


    public Player(int col, int row, Color color) {
        super(col, row, color);

        picture = new Picture(col - 23, row -10, "resources/Ship6.png");
        picture.draw();

        createHealth();


    }

    private void createHealth(){

        lives = new Picture[5];
        int marging = 0;

        for(int i = 0; i < lives.length; i++){
            lives[i] = new Picture(400 + marging, 30,"resources/health.png");
            marging += 20;
        }
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

    public void suffer(){
        this.health -= 5;
    }


    public Picture[] getLives() {
        return lives;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public boolean isDead() {
        return dead;
    }

    public void setLives(Picture[] lives) {
        this.lives = lives;
    }

    public Picture getPicture() {
        return picture;
    }
}
