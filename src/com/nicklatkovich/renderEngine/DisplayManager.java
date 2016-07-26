package com.nicklatkovich.renderEngine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;

public class DisplayManager {

    private static final int WIDTH = 640;
    private static final int HEIGHT = 480;
    private static final int FRAME_RATE = 60;

    public static void create() {
        ContextAttribs attribs = new ContextAttribs(3, 2)
                .withForwardCompatible(true)
                .withProfileCore(true);
        try {
            Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
            Display.create(new PixelFormat(), attribs);
        } catch (LWJGLException e) {
            e.printStackTrace();
        }
        GL11.glViewport(0, 0, WIDTH, HEIGHT);
    }

    public static void update() {
        Display.sync(FRAME_RATE);
        Display.update();
    }

    public static void destroy() {
        Display.destroy();
    }
}
