package com.nicklatkovich.engineTester;

import com.nicklatkovich.renderEngine.DisplayManager;
import com.nicklatkovich.renderEngine.Loader;
import com.nicklatkovich.renderEngine.RawModel;
import com.nicklatkovich.renderEngine.Renderer;
import org.lwjgl.opengl.Display;

public class MainGameLoop {

    public static void main(String[] args) {
        DisplayManager.create();
        Loader loader = new Loader();
        Renderer renderer = new Renderer();
        float[] vertices = {
                // left bottom
                -0.5f, 0.5f, 0f,
                -0.5f, -0.5f, 0f,
                0.5f, -0.5f, 0f,
                //right top
                0.5f, -0.5f, 0f,
                0.5f, 0.5f, 0f,
                -0.5f, 0.5f, 0f
        };
        RawModel model = loader.loadToVAO(vertices);
        while (!Display.isCloseRequested()) {
            renderer.prepare();
            renderer.render(model);
            DisplayManager.update();
        }
        loader.cleanUP();
        DisplayManager.destroy();
    }
}
