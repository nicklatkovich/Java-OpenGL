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
                -0.5f, 0.5f, 0f,
                -0.5f, -0.5f, 0f,
                0.5f, -0.5f, 0f,
                0.5f, 0.5f, 0f
        };
        int[] indices = {
                0, 1, 3,
                3, 1, 2
        };
        RawModel model = loader.loadToVAO(vertices, indices);
        while (!Display.isCloseRequested()) {
            renderer.prepare();
            renderer.render(model);
            DisplayManager.update();
        }
        loader.cleanUP();
        DisplayManager.destroy();
    }
}
