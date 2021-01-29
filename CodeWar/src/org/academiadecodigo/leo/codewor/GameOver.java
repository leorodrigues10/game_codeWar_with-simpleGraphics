package org.academiadecodigo.leo.codewor;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameOver implements KeyboardHandler {


    private Picture gameOver;
    private Keyboard keyboard;

    private Text score;
    private Text point;


    public GameOver(){

        gameOver = new Picture(10,10,"resources/over.png");
        gameOver.draw();

        score = new Text(250,350, "Score");
        score.draw();
        score.setColor(Color.GREEN);
        score.grow(20,20);

        point = new Text(260,380, String.valueOf(Game.getPoints()));
        point.draw();
        point.setColor(Color.GREEN);
        point.grow(17,17);



        init();

    }

    private void init(){

        keyboard = new Keyboard(this);


        KeyboardEvent pressP = new KeyboardEvent();
        pressP.setKey(KeyboardEvent.KEY_P);
        pressP.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent pressE = new KeyboardEvent();
        pressE.setKey(KeyboardEvent.KEY_E);
        pressE.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);



        keyboard.addEventListener(pressP);
        keyboard.addEventListener(pressE);

    }



    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()){


            case KeyboardEvent.KEY_P:

                Game game = new Game();
                game.start();
                break;
            case KeyboardEvent.KEY_E:
                System.exit(1);
                break;
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
