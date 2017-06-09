package WMController;

public class AutoLineUp {
	
	public LineToken tokens = new LineToken();
	public LCS lcs = new LCS();
	private int diff = 0;

	public void LineArrange() {
		
		tokens = new LineToken();
		tokens.Linetokenize();
		lcs = new LCS();
		lcs.findLcs(tokens);
		System.out.println("Auto");

		for (int i = 1; i <= lcs.getTotal(); i++) {
			if (lcs.getLeftLCS(i) == lcs.getRightLCS(i)) {
				continue;
			} else if (lcs.getLeftLCS(i) > lcs.getRightLCS(i)) {
				diff = lcs.getLeftLCS(i) - lcs.getRightLCS(i);
				tokens.Num_right_line += diff;
				for (int j = tokens.getNumRightLine(); j >= lcs.getLeftLCS(i); j--) {
					for (int k = 0; k < diff; k++) {
						tokens.right.add("\t\n");
					}
					tokens.right.set(j, tokens.right.get(j - diff));
				}
				for (int j = lcs.getRightLCS(i); j < lcs.getLeftLCS(i); j++) {
					tokens.right.set(j, "\t\n");
				}
				for (int j = i; j <= lcs.getTotal(); j++) {
					lcs.setRightLCS(j, lcs.getRightLCS(j) + diff);
				}
			} else {
				diff = lcs.getRightLCS(i) - lcs.getLeftLCS(i);
				tokens.Num_left_line += diff;
				for (int j = tokens.getNumLeftLine(); j >= lcs.getRightLCS(i); j--) {
					for (int k = 0; k < diff; k++) {
						tokens.left.add("\t\n");
					}
					tokens.left.set(j, tokens.left.get(j - diff));
				}
				for (int j = lcs.getLeftLCS(i); j < lcs.getRightLCS(i); j++) {
					tokens.left.set(j, "\t\n");
				}
				for (int j = i; j <= lcs.getTotal(); j++) {
					lcs.setLeftLCS(j, lcs.getLeftLCS(j) + diff);
				}
			}
		}
		if (tokens.getNumLeftLine() > tokens.getNumRightLine()) {
			for (int k = 0; k < tokens.getNumLeftLine() - tokens.getNumRightLine(); k++) {
				tokens.right.add("\t\n");
				tokens.Num_right_line++;
			}
		}
		else if (tokens.getNumLeftLine() < tokens.getNumRightLine()) {
			for (int k = 0; k < tokens.getNumRightLine() - tokens.getNumLeftLine(); k++) {
				tokens.left.add("\t\n");
				tokens.Num_left_line++;
			}
		}
	}
}
