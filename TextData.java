package WMModel;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


import javax.swing.JOptionPane;
import javax.swing.JTextPane;

public class TextData {

	public static JTextPane leftPane = new JTextPane();
	public static JTextPane rightPane = new JTextPane();
	
	public static void readTextFile(String tmpdir, String lr) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(tmpdir));
			if (lr == "left")
				leftPane.setText("");
			else if (lr == "right")
				rightPane.setText("");
			do {
				if (lr == "left")
					leftPane.read(reader, null);
				else if (lr == "right")
					rightPane.read(reader, null);
			} while (reader.readLine() != null);
			reader.close();

		} catch (Exception e2) {
			WMView.GUI.failtoLoadFile();
		}
	}
			
	public static String getLeftPanelText() {
		return leftPane.getText();
	}
	public static String getRightPanelText() {
		return rightPane.getText();
	}
}