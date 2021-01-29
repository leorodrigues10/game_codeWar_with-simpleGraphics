package org.academiadecodigo.leo.codewor;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Start implements KeyboardHandler{

    private Picture picture;
    private Picture start;
    private Keyboard keyboard;
    private boolean started = false;
    private boolean show = false;

    private Sound sound;



    public Start(){

        picture = new Picture(10,10, "resources/start.jpg");
        picture.draw();

        start = new Picture(170, 600,"resources/press.png");

        sound = new Sound("/resources/audio/mission2.wav");
        sound.play(true);

        init();

    }

    private void init(){

        keyboard = new Keyboard(this);

        KeyboardEvent pressSpace = new KeyboardEvent();
        pressSpace.setKey(KeyboardEvent.KEY_SPACE);
        pressSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(pressSpace);

        while (!started){

            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(show){
                start.draw();
                show = false;
            }else{
                start.delete();
                show = true;
            }


        }
        picture.delete();
        sound.stop();

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_SPACE:
              started = true;
              break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
