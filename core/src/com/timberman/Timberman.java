package com.timberman;

import com.badlogic.gdx.*;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Timberman extends Game {
    private SpriteBatch batch;
    private  Texture background, charLeft, gameOver;
    private  Player p = new Player();
    private  Tiles tiles = new Tiles();
    private BitmapFont font;
    Sound chop;
    private int score = 0;
    private double timeHelper;
    private int count = 20;
    boolean hold = false; // if gameover screen is being shown


    @Override
    public void create() {
        batch = new SpriteBatch();
        background = new Texture("background.png");
        charLeft = new Texture("charLeft.png");
        tiles.createTiles();
        p.charachter();

        font = new BitmapFont();
        font.getData().setScale(2);
        chop = Gdx.audio.newSound(Gdx.files.internal("chop.mp3"));
        chop.setVolume(1, 0.5f);
    }

    @Override
    public void render() {
        update();
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(background, 0, 0);
        tiles.draw(batch);
        p.draw(batch);
        if (gameOver != null) {
            batch.draw(gameOver, -86, 10);
        }
        font.draw(batch, "SCORE: " + score, 100, 700);
        font.draw(batch, "TIME: " + count, 800, 700);
        batch.end();
    }

    private void update() {
        countdown();
        if (count == 0) {
            over();
        }
        if ((Gdx.input.isKeyJustPressed(Input.Keys.D) || Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) && hold == false) {
            p.posx = 600;
            p.posy = 40;
            p.pTexture = new Texture("charRight.png");
            chop.play();
            if (tiles.t1x != 287) {
                over();
            }
            tiles.cut();
            score++;


        }
        if ((Gdx.input.isKeyJustPressed(Input.Keys.A) || Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) && hold == false) {
            p.posx = 350;
            p.posy = 40;
            p.pTexture = new Texture("charLeft.png");
            chop.play();
            if (tiles.t1x == 287) {
                over();
            }
            tiles.cut();
            score++;

        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            gameOver = null;
            hold = false;
            score = 0;
            count = 30;
            p.charachter();
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            System.exit(0);
        }
    }


    public void countdown() {
        timeHelper += Gdx.graphics.getDeltaTime();
        if ((timeHelper > 1) && count > 0) {
            count--;
            timeHelper = 0;
        }
    }

    public void over() {
        gameOver = new Texture("gameOver.png");
        hold = true;
        count = 0;
    }


    @Override
    public void dispose() {
        batch.dispose();
        background.dispose();
    }


}
