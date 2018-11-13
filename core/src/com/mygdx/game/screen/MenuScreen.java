package com.mygdx.game.screen;


import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Scene.Hud;
import com.mygdx.game.ZombieTrain;
import com.mygdx.game.tool.InputHandler;

import static com.mygdx.game.tool.InputHandler.isTouched;

public class MenuScreen implements Screen {
    private ZombieTrain game;
    private Stage stage;
    private Viewport viewport;

    private final Vector2 SCORE_POS = new Vector2(ZombieTrain.V_WIDTH / 2, ZombieTrain.V_HEIGHT - 200);
    private Label highScoreLabel;

    private final String INSTRUCTION_TEXT = "tap to play\n\nhigh score";
    private final Vector2 TEXT_POS = new Vector2(ZombieTrain.V_WIDTH / 2 - 40, ZombieTrain.V_HEIGHT - 170);
    private Label instructionText;


    public MenuScreen(ZombieTrain game) {
        this.game = game;

        viewport = new FitViewport(ZombieTrain.V_WIDTH, ZombieTrain.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, game.batch);

        highScoreLabel = new Label(String.valueOf(Hud.getHighScore()), new Label.LabelStyle(new BitmapFont(), Color.GOLD));
        highScoreLabel.setPosition(SCORE_POS.x, SCORE_POS.y);
        highScoreLabel.setFontScale(2);

        instructionText = new Label(INSTRUCTION_TEXT, new Label.LabelStyle(new BitmapFont(), Color.GOLD));
        instructionText.setPosition(TEXT_POS.x, TEXT_POS.y);
        instructionText.setAlignment(Align.center);

        stage.addActor(highScoreLabel);
        stage.addActor(instructionText);
    }

    @Override
    public void show() {

    }

    private void update(float dt) {
       if (isTouched()) {
            game.setScreen(new PlayScreen(game));
       }
    }

    @Override
    public void render(float dt) {
        update(dt);

        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
