package WMModel;

import java.awt.Color;

import javax.swing.JTextPane;

public class TextPaneData {

	protected static JTextPane leftPane = new JTextPane();
	protected static JTextPane rightPane = new JTextPane();
			
	public static String getLeftPanelText() {
		return leftPane.getText();
	}
	public static String getRightPanelText() {
		return rightPane.getText();
	}
	public static void setAll(String lr, String s) {
		if (lr == "left"){
			leftPane.setText(s);
		}
		else if (lr == "right"){
			rightPane.setText(s);
		}
	}
	public static void editingStart() {
		leftPane.setEditable(true);
		rightPane.setEditable(true);
		leftPane.setBackground(Color.WHITE);
		rightPane.setBackground(Color.WHITE);
	}
	public static void editingEnd() {
		leftPane.setEditable(false);
		rightPane.setEditable(false);
		leftPane.setBackground(Color.LIGHT_GRAY);
		rightPane.setBackground(Color.LIGHT_GRAY);
	}
	public static JTextPane getPane(String lr) {
		if (lr == "left")
			return leftPane;
		else
			return rightPane;
	}
}
