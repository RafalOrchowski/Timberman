package com.timberman;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;

public class Player extends Rectangle {
    public Texture pTexture;
    public int posx;
    public int posy;

    public void charachter(){
        pTexture = new Texture("charLeft.png");
        posx = 350;
        posy = 30;
    }
    public void draw(SpriteBatch batch) {
        batch.draw(pTexture, posx, posy);
    }
}
