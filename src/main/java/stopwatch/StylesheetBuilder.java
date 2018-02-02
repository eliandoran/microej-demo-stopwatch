/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package stopwatch;

import ej.microui.display.Colors;
import ej.microui.display.Font;
import ej.microui.display.GraphicsContext;
import ej.style.Stylesheet;
import ej.style.font.FontProfile;
import ej.style.outline.ComplexOutline;
import ej.style.outline.SimpleOutline;
import ej.style.selector.ClassSelector;
import ej.style.selector.TypeSelector;
import ej.style.util.EditableStyle;
import ej.style.util.StyleHelper;
import ej.widget.basic.Button;

/**
 *
 */
public class StylesheetBuilder {
	private StylesheetBuilder() {
		// Prevent instantiation.
	}

	public static void initialize() {
		Stylesheet stylesheet = StyleHelper.getStylesheet();

		setDefaultStyle(stylesheet);
		setCountdownLabelStyle(stylesheet);
		setButtonStyle(stylesheet);
	}

	private static void setDefaultStyle(Stylesheet stylesheet) {
		EditableStyle style = new EditableStyle();

		style.setBackgroundColor(Colors.BLACK);
		style.setForegroundColor(Colors.WHITE);
		style.setFontProfile(new FontProfile("SegoeUI", 30, Font.STYLE_PLAIN));

		stylesheet.setDefaultStyle(style);
	}

	private static void setCountdownLabelStyle(Stylesheet stylesheet) {
		EditableStyle style = new EditableStyle();

		style.setFontProfile(new FontProfile("SegoeUI_Light", 96, Font.STYLE_PLAIN));
		style.setAlignment(GraphicsContext.HCENTER | GraphicsContext.VCENTER);

		stylesheet.addRule(new ClassSelector("countdownLabel"), style);
	}

	private static void setButtonStyle(Stylesheet stylesheet) {
		EditableStyle style = new EditableStyle();

		style.setBackgroundColor(Colors.WHITE);
		style.setForegroundColor(Colors.BLACK);
		style.setPadding(new ComplexOutline(5, 20, 5, 20));
		style.setMargin(new SimpleOutline(10));
		style.setAlignment(GraphicsContext.HCENTER | GraphicsContext.VCENTER);

		stylesheet.addRule(new TypeSelector(Button.class), style);
	}
}
