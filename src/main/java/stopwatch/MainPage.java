/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package stopwatch;

import ej.bon.Timer;
import ej.bon.TimerTask;
import ej.widget.basic.Button;
import ej.widget.basic.Label;
import ej.widget.container.SimpleDock;
import ej.widget.listener.OnClickListener;

/**
 *
 */
public class MainPage extends SimpleDock {
	private Label countdownLabel;
	private Button startPauseButton;
	private Button resetButton;
	private SimpleDock footer;
	private Timer timer;

	private int timeMs = 0;
	private boolean timerPaused = true;

	public MainPage() {
		buildWidgets();

		this.setCenter(this.countdownLabel);
		this.setHorizontal(false);

		this.footer.setFirst(this.startPauseButton);
		this.footer.setLast(this.resetButton);
		this.setLast(this.footer);
	}

	private void buildWidgets() {
		this.countdownLabel = new Label("00:00:00.00");
		this.countdownLabel.setClassSelectors("countdownLabel");

		this.startPauseButton = new Button("Start/Pause");
		this.startPauseButton.addOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				MainPage.this.timerPaused = !MainPage.this.timerPaused;
				setState();
			}
		});

		this.resetButton = new Button("Reset");
		this.resetButton.addOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				MainPage.this.timerPaused = true;
				MainPage.this.timeMs = 0;
				setState();
				updateTime();
			}
		});

		this.footer = new SimpleDock();
		this.footer.setHorizontal(true);
	}

	private void setState() {
		if (this.timer == null) {
			this.timer = new Timer();
		}

		if (this.timerPaused) {
			this.timer.cancel();
			this.timer = null;
			return;
		}

		this.timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				MainPage.this.timeMs += 20;
				updateTime();
			}
		}, 0, 20);
	}

	private void updateTime() {
		int time = this.timeMs;
		int h = time / 3_600_000;
		time %= 3_600_000;
		int m = time / 60_000;
		time %= 60_000;
		int s = time / 1000;
		time %= 1000;
		time /= 10;

		String timeString = formatTime(h, m, s, time);
		this.countdownLabel.setText(timeString.toString());
	}

	private String formatTime(int h, int m, int s, int ms) {
		StringBuilder timeString = new StringBuilder();
		timeString.append(pad(h, 2));
		timeString.append(':');
		timeString.append(pad(m, 2));
		timeString.append(':');
		timeString.append(pad(s, 2));
		timeString.append('.');
		timeString.append(pad(ms, 3));
		return timeString.toString();
	}

	private String pad(int n, int length) {
		String padding = ""; //$NON-NLS-1$
		for (int i = 0; i < length; i++) {
			padding += "0"; //$NON-NLS-1$
		}

		String result = padding + String.valueOf(n);
		return result.substring(result.length() - 2);
	}
}
