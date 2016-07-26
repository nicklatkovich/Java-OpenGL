package com.nicklatkovich.engineTester;

import com.nicklatkovich.models.TexturedModel;
import com.nicklatkovich.renderEngine.DisplayManager;
import com.nicklatkovich.renderEngine.Loader;
import com.nicklatkovich.models.RawModel;
import com.nicklatkovich.renderEngine.Renderer;
import com.nicklatkovich.shaders.StaticShader;
import com.nicklatkovich.textures.ModelTexture;
import org.lwjgl.opengl.Display;

public class MainGameLoop {

    public static void main(String[] args) {
        DisplayManager.create();
        Loader loader = new Loader();
        Renderer renderer = new Renderer();
        StaticShader shader = new StaticShader();
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
        float[] textureCoords = {
                0, 0,
                0, 1,
                1, 1,
                1, 0,
        };
        RawModel model = loader.loadToVAO(vertices, textureCoords, indices);
        ModelTexture texture = new ModelTexture(loader.loadTexture("image"));
        TexturedModel texturedModel = new TexturedModel(model, texture);
        while (!Display.isCloseRequested()) {
            renderer.prepare();
            shader.start();
            renderer.render(texturedModel);
            shader.stop();
            DisplayManager.update();
        }
        shader.cleanUp();
        loader.cleanUP();
        DisplayManager.destroy();
    }
}
