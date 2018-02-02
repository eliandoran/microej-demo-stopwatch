/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package stopwatch;

import ej.microui.MicroUI;
import ej.mwt.Desktop;
import ej.mwt.Panel;
import ej.wadapps.app.Activity;

/**
 *
 */
public class MainActivity implements Activity {

	@Override
	public String getID() {
		return "Stopwatch";
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRestart() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart() {
		MicroUI.start();
		StylesheetBuilder.initialize();

		Desktop desktop = new Desktop();

		Panel panel = new Panel();
		panel.setWidget(new MainPage());
		panel.showFullScreen(desktop);

		desktop.show();
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStop() {
		// Do nothing.
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub

	}
}
