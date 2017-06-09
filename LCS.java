package WMController;

import java.util.ArrayList;

public class LCS {

	private int[][] calTable;
	private int[][] route;
	private int totalSameLineNum = 0;
	private ArrayList<Integer> leftLCS = new ArrayList<Integer>();
	private ArrayList<Integer> rightLCS = new ArrayList<Integer>();

	public int getTotal() {
		return totalSameLineNum;
	}

	public void findLcs(WMController.LineToken tokens) {

		calTable = new int[tokens.getNumLeftLine() + 1][tokens.getNumRightLine() + 1];
		route = new int[tokens.getNumLeftLine() + 1][tokens.getNumRightLine() + 1];
		

		int i = 0;
		int j = 0;
		int k = 0;

		for (i = 1; i <= tokens.getNumLeftLine(); i++) {
			for (j = 1; j <= tokens.getNumRightLine(); j++) {
				if (tokens.getLeftStr(i).equals("\n") || tokens.getLeftStr(i).equals("\t\n")) {
					if (calTable[i - 1][j] >= calTable[i][j - 1]) {
						calTable[i][j] = calTable[i - 1][j]; // 위를 받음
						route[i][j] = 2;
					} else {
						calTable[i][j] = calTable[i][j - 1]; // 왼쪽을 받음
						route[i][j] = 1;
					}
				} else {
					if (tokens.getLeftStr(i).equals(tokens.getRightStr(j))) {
						calTable[i][j] = calTable[i - 1][j - 1] + 1; // 대각선 + 1
						route[i][j] = 0;
					} else if (calTable[i - 1][j] >= calTable[i][j - 1]) {
						calTable[i][j] = calTable[i - 1][j]; // 위를 받음
						route[i][j] = 2;
					} else {
						calTable[i][j] = calTable[i][j - 1]; // 왼쪽을 받음
						route[i][j] = 1;
					}
				}
			}
		}

		i--;
		j--;
		int n = 0;
		int m = 0;
		for (n = 0; n <= i; n++) {
			for (m = 0; m <= j; m++) {
				System.out.print(calTable[n][m]);

			}
			System.out.println("");
		}
		totalSameLineNum = calTable[i][j];
		int trackingLeft[] = new int[totalSameLineNum + 1];
		int trackingRight[] = new int[totalSameLineNum + 1];

		while (i != 0 && j != 0) {
			if (route[i][j] == 0) {
				trackingLeft[calTable[i][j]] = i;
				trackingRight[calTable[i][j]] = j;
				i--;
				j--;
			} else if (route[i][j] == 1) {
				j--;
			} else if (route[i][j] == 2) {
				i--;
			}
		}

		leftLCS.add(0);
		rightLCS.add(0);
		
		for (k = 1; k <= totalSameLineNum; k++) {
			leftLCS.add(trackingLeft[k]);
			rightLCS.add(trackingRight[k]);
		}
	}
	
	public int getLeftLCS(int n) {
		return leftLCS.get(n);
	}

	public int getRightLCS(int n) {
		return rightLCS.get(n);
	}

	public void setLeftLCS(int n, int s) {
		leftLCS.set(n, s);
	}

	public void setRightLCS(int n, int s) {
		rightLCS.set(n, s);
	}
}