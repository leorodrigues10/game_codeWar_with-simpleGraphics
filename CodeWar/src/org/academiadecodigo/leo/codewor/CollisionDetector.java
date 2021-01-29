package org.academiadecodigo.leo.codewor;

import org.academiadecodigo.leo.codewor.gameObject.Bullets;
import org.academiadecodigo.leo.codewor.gameObject.Enemy;
import org.academiadecodigo.leo.codewor.gameObject.Player;

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

    public void checkCollision2(List<Enemy> list, Player player){

        for(Enemy enemy : list){

            if(player.getCol() == enemy.getCol() && player.getRow() == enemy.getRow()){

                player.suffer();
                enemy.getRectangle().delete();
                enemy.getPicture().delete();

            }

        }



    }
}
