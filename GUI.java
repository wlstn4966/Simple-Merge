package WMView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class GUI extends JFrame implements ActionListener {

	private MenuBar mb = new MenuBar();
	private Menu file = new Menu("File");
	private Menu medit = new Menu("Edit");
	private Menu help = new Menu("Help");
	private MenuItem lbrowse = new MenuItem("좌측 파일 불러오기");
	private MenuItem rbrowse = new MenuItem("우측 파일 불러오기");
	private MenuItem lsave = new MenuItem("좌측 파일 다른이름 저장");
	private MenuItem rsave = new MenuItem("우측 파일 다름이름 저장");
	private MenuItem exit = new MenuItem("종료");
	private MenuItem edit = new MenuItem("편집 사용");
	private MenuItem x_edit = new MenuItem("편집 불가");
	private MenuItem m_lineup = new MenuItem("Auto Line up");
	private MenuItem lisense = new MenuItem("라이센스");

	private JLabel lfName = new JLabel();
	private JLabel rfName = new JLabel();
	private JLabel b_exp = new JLabel();
	private JButton blload = new JButton(new ImageIcon("C:\\Users\\CAUCSE\\Desktop\\HTTP\\ict\\src\\GUI\\load.jpg"));
	private JButton brload = new JButton(new ImageIcon("C:\\Users\\CAUCSE\\Desktop\\HTTP\\ict\\src\\GUI\\load.jpg"));
	private JButton blsave = new JButton(new ImageIcon("C:\\Users\\CAUCSE\\Desktop\\HTTP\\ict\\src\\GUI\\save.jpg"));
	private JButton brsave = new JButton(new ImageIcon("C:\\Users\\CAUCSE\\Desktop\\HTTP\\ict\\src\\GUI\\save.jpg"));
	private JButton bedit = new JButton(new ImageIcon("C:\\Users\\CAUCSE\\Desktop\\HTTP\\ict\\src\\GUI\\edit.jpg"));
	private JButton bxedit = new JButton(new ImageIcon("C:\\Users\\CAUCSE\\Desktop\\HTTP\\ict\\src\\GUI\\bxedit.png"));
	private JButton b_lineup = new JButton(
			new ImageIcon("C:\\Users\\CAUCSE\\Desktop\\HTTP\\ict\\src\\GUI\\AutoLineUp.jpg"));
	private JButton lmerge = new JButton(new ImageIcon("C:\\Users\\CAUCSE\\Desktop\\HTTP\\ict\\src\\GUI\\lmerge.png"));
	private JButton rmerge = new JButton(new ImageIcon("C:\\Users\\CAUCSE\\Desktop\\HTTP\\ict\\src\\GUI\\rmerge.jpg"));

	private JPanel rightText = new JPanel();
	private JPanel leftText = new JPanel();

	private Dimension frameSize, screenSize;
	private JScrollPane rightScroll;
	private JScrollPane leftScroll;

	public GUI() {
		setTitle("SimpleMerge");
		InitLayout();

		setSize(1310, 750);
		setVisible(true);
		setResizable(false);

		centerScreenSet();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void centerScreenSet() {
		frameSize = getSize();
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
	}

	public void InitLayout() {

		getContentPane().setLayout(null);
		// textpane 배치
		WMModel.TextPaneData.editingEnd();

		leftText.setLayout(new BorderLayout());
		leftText.add(WMModel.TextPaneData.getPane("left"));
		leftText.setSize(10000, 10000);

		rightText.setLayout(new BorderLayout());
		rightText.add(WMModel.TextPaneData.getPane("right"));
		rightText.setSize(100000, 100000);

		// 아이콘 배치
		blload.setBounds(1, 5, 20, 20);
		blsave.setBounds(23, 5, 20, 20);
		bedit.setBounds(46, 5, 20, 20);
		bxedit.setBounds(69, 5, 20, 20);
		b_lineup.setBounds(92, 5, 20, 20);
		lmerge.setBounds(115, 5, 20, 20);
		rmerge.setBounds(138, 5, 20, 20);
		brload.setBounds(658, 5, 20, 20);
		brsave.setBounds(681, 5, 20, 20);

		lfName.setBounds(500, 5, 130, 20);
		lfName.setFont(new Font("Serif", Font.BOLD, 15));
		rfName.setBounds(1180, 5, 130, 20);
		rfName.setFont(new Font("Serif", Font.BOLD, 15));

		b_exp.setBounds(1200, 0, 50, 20);
		// lfName.setc
		// 패널에 추가

		mb.add(file);
		mb.add(medit);
		mb.add(help);
		file.add(lbrowse);
		file.add(rbrowse);
		file.addSeparator();
		file.add(lsave);
		file.add(rsave);
		file.addSeparator();
		file.add(exit);
		medit.add(edit);
		medit.add(x_edit);
		medit.addSeparator();
		medit.add(m_lineup);
		help.add(lisense);

		rightScroll = new JScrollPane(rightText, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		leftScroll = new JScrollPane(leftText, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		rightScroll.setBounds(650, 30, 650, 650);
		leftScroll.setBounds(0, 30, 650, 650);

		this.add(lmerge);
		this.add(rmerge);
		this.add(blload);
		this.add(brload);
		this.add(blsave);
		this.add(brsave);
		this.add(b_lineup);
		this.add(bedit);
		this.add(bxedit);
		this.add(rightScroll);
		this.add(leftScroll);
		this.setMenuBar(mb);
		this.add(lfName);
		this.add(rfName);
		this.add(b_exp);

		// action Listener
		exit.addActionListener(this);
		blload.addActionListener(this);
		lbrowse.addActionListener(this);
		brload.addActionListener(this);
		blsave.addActionListener(this);
		brsave.addActionListener(this);
		bedit.addActionListener(this);
		bxedit.addActionListener(this);
		b_lineup.addActionListener(this);
		lmerge.addActionListener(this);
		rmerge.addActionListener(this);
		rbrowse.addActionListener(this);
		lsave.addActionListener(this);
		rsave.addActionListener(this);
		help.addActionListener(this);
		edit.addActionListener(this);
		x_edit.addActionListener(this);
		m_lineup.addActionListener(this);

		// 버튼 설명
		blload.setToolTipText("좌측 파일 불러오기");
		brload.setToolTipText("우측 파일 불러오기");
		blsave.setToolTipText("좌측 파일 저장");
		brsave.setToolTipText("우측 파일 저장");
		bedit.setToolTipText("편집 사용 가능");
		bxedit.setToolTipText("편집 사용 불가");
		b_lineup.setToolTipText("라인 정렬 (양쪽 텍스트 비교)");
		lmerge.setToolTipText("<-- Merge");
		rmerge.setToolTipText("--> Merge");

		WMModel.TextPaneData.getPane("left").addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) { // select different part
				WMController.SelectbyMouse.textPaneSelection("left", e);
			}
		});
		WMModel.TextPaneData.getPane("right").addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) { // select different part
				WMController.SelectbyMouse.textPaneSelection("right", e);
			}
		});
	}

	public void actionPerformed(ActionEvent e) { // 액션 추가
		if (e.getSource() == exit) {
			System.exit(0);
		} else if (e.getSource() == lbrowse || e.getSource() == blload) {
			WMModel.LoadText.readTextFile("left");
		} else if (e.getSource() == rbrowse || e.getSource() == brload) {
			WMModel.LoadText.readTextFile("right");
		} else if (e.getSource() == lsave || e.getSource() == blsave) {
			WMModel.SaveText.saveTextFile("left");
		} else if (e.getSource() == rsave || e.getSource() == brsave) {
			WMModel.SaveText.saveTextFile("right");
		} else if (e.getSource() == help) {
			JOptionPane.showMessageDialog(null, "14팀  SimpleMerge" + '\n' + "버전 정보 1.02", "Lisense", JOptionPane.INFORMATION_MESSAGE);
		} else if (e.getSource() == edit || e.getSource() == bedit) {
			WMModel.TextPaneData.editingStart();
		} else if (e.getSource() == x_edit || e.getSource() == bxedit) {
			WMModel.TextPaneData.editingEnd();
		} else if (e.getSource() == b_lineup || e.getSource() == m_lineup) {
			WMController.LineUpTrigger.reNewLineUp();
		} else if (e.getSource() == lmerge) {
			WMController.CopyToLeft.copyToLeft();
		} else if (e.getSource() == rmerge) {
			WMController.CopyToRight.copyToRight();
		}
	}
}