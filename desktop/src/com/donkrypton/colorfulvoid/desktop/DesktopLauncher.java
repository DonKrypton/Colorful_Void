package com.donkrypton.colorfulvoid.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.donkrypton.colorfulvoid.GameMain;

public class DesktopLauncher {
	public static void main (String[] arg)
    {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Stones";
        config.width = 640;
        config.height = 960;

        new LwjglApplication(new GameMain(), config);
	}
}
