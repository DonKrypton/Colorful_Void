package com.donkrypton.colorfulvoid.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.donkrypton.colorfulvoid.GameMain;
import helpers.Constants;

public class DesktopLauncher {
	public static void main (String[] arg)
    {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Colorful Void";
        config.width = Constants.WORLD_WIDTH;
        config.height = Constants.WORLD_HEIGHT;

        new LwjglApplication(new GameMain(), config);
	}
}
