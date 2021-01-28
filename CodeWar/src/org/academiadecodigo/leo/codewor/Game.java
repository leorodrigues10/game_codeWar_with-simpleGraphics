package org.academiadecodigo.leo.codewor;

import org.academiadecodigo.leo.codewor.gameObject.*;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;
import java.util.List;

public class Game {

    private Grid grid;
    private Sound sound;

    private List<Enemy> enemyList;
    private List<Bullets> bulletsList;

    private Text score;
    private Text textScore;

    private Player player;
    private Controls controls;
    private CollisionDetector collisionDetector;

    public static int points;


    public void init(){

        grid = new Grid();
        controls = new Controls();
        collisionDetector = new CollisionDetector();

        enemyList = new LinkedList<>();
        bulletsList = new LinkedList<>();

        player = GameObjectFactory.createPlayer();

        controls.setPlayer(player);
        controls.init();


        start();

    }

    private void start(){

        int iterator = 0;
        int number = 0;

        drowScore();

        while (true){

            drowPoint();

            if(iterator == number){
                createEnemys();
                number += 30;
            }
            iterator++;


            bulletsList.add(player.createBullets());


            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            moveEnemy();
            moveBullets();
            score.delete();



        }
    }

    private void createEnemys(){

        for(int i = 0; i < 10; i++){
            enemyList.add(GameObjectFactory.createEnemy());
        }

    }

    private void moveEnemy(){

        for (Enemy enemy: enemyList) {

            enemy.getRectangle().translate(0, 20);
            enemy.setRow(enemy.getRow() + 20);
            enemy.getPicture().translate(0,20);

            if(enemy.getRow()  > 730){
                enemy.getRectangle().delete();
                enemy.getPicture().delete();
            }
        }
    }
    private void moveBullets(){

        for(Bullets bullet : bulletsList){

            bullet.getBullet().translate(0, -20);
            bullet.getBulletPic().translate(0,-20);
            bullet.setRow(bullet.getRow() - 20);

            collisionDetector.checkCollision(bullet, enemyList);

            if(bullet.getRow() < 10){
                bullet.getBullet().delete();
                bullet.getBulletPic().delete();

            }
        }
    }

    private void drowScore(){

        textScore = new Text(30, 30, "Score: ");
        textScore.setColor(Color.WHITE);
        textScore.grow(15, 12);
        textScore.draw();
    }

    private void drowPoint(){

        score = new Text(65,35, String.valueOf(points));
        score.setColor(Color.WHITE);
        score.grow(6,5);
        score.draw();

    }



    public static int getPoints() {
        return points;
    }

    public static void setPoints(int points) {
        Game.points = points;
    }
}
