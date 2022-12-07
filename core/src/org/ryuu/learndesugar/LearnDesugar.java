package org.ryuu.learndesugar;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import lombok.Getter;
import org.ryuu.functional.Action;

import java.util.ArrayList;
import java.util.Arrays;

public class LearnDesugar extends ApplicationAdapter {
    @Getter
    private final Action afterCreate = new Action();

    @Override
    public void create() {
        afterCreate.invoke();
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0, 1);
    }

    @Override
    public void dispose() {
    }
}