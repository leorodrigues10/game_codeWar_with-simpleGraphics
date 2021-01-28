package org.academiadecodigo.leo.codewor;

import org.academiadecodigo.leo.codewor.gameObject.Bullets;
import org.academiadecodigo.leo.codewor.gameObject.Enemy;

import java.util.List;

public class CollisionDetector {


    public void checkCollision(Bullets bullets, List<Enemy> enemyList){


        for (Enemy enemy : enemyList){

            if(bullets.getCol() == enemy.getCol() && bullets.getRow() == enemy.getRow()){

                bullets.getBullet().delete();
                bullets.getBulletPic().delete();
                enemy.getRectangle().delete();
                enemy.getPicture().delete();
                Game.setPoints(Game.getPoints() + 1);
            }
        }



    }
}
