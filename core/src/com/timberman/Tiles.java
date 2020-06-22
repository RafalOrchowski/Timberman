package com.timberman;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

public class Tiles {
    Texture t1t, t2t, t3t, t4t;
    int t1x, t2x, t3x, t4x;
    int t1y, t2y, t3y, t4y;
    Random rand = new Random();

    public void createTiles() {
        t1t = new Texture("treeLeft.png");
        t2t = new Texture("treeRight.png");
        t3t = new Texture("treeLeft.png");
        t4t = new Texture("treeRight.png");
        t1y = 104;
        t2y = 282;
        t3y = 460;
        t4y = 460 + 178;

        t1x = 287;
        t2x = 287 + 174;
        t3x = 287;
        t4x = 287 + 174;

    }

    public void cut() {
        t1t = t2t;
        t2t = t3t;
        t3t = t4t;
        t1x = t2x;
        t2x = t3x;
        t3x = t4x;
        boolean r = rand.nextBoolean();
        if (r == true) {
            t4t = new Texture("treeLeft.png");
            t4x = 287;
        } else {
            t4t = new Texture("treeRight.png");
            t4x = 287 + 174;
        }

    }

    public void draw(SpriteBatch batch) {
        batch.draw(t1t, t1x, t1y);
        batch.draw(t2t, t2x, t2y);
        batch.draw(t3t, t3x, t3y);
        batch.draw(t4t, t4x, t4y);
    }

}
