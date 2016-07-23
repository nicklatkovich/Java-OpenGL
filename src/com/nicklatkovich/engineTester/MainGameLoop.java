package com.nicklatkovich.engineTester;

import com.nicklatkovich.renderEngine.DisplayManager;
import org.lwjgl.opengl.Display;

public class MainGameLoop {

    public static void main(String[] args) {
        DisplayManager.create();
        while (!Display.isCloseRequested()) {
            DisplayManager.update();
        }
        DisplayManager.destroy();
    }
}
