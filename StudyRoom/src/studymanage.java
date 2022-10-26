import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class studymanage extends JFrame {
	private MyPanel panel = new MyPanel();
	
	studymanage() {
		setTitle("비숑 StudyRoom_관리자모드");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		createMenu();
		setContentPane(panel);
		Container c = getContentPane();
		c.setLayout(null);

		JButton firstbtn = new JButton("처음으로");
		c.add(firstbtn);
		firstbtn.setFont(new Font("a시월구일2", Font.BOLD, 11));
		firstbtn.setLocation(385, 400);
		firstbtn.setSize(100, 35);
		firstbtn.setBackground(new Color(228, 247, 186));
		firstbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new studyroomall();
				setVisible(false);
			}
		});
		
		JLabel resetCheck = new JLabel("<비숑 StudyRoom 관리자 모드>");
		c.add(resetCheck);
		resetCheck.setFont(new Font("a시월구일2", Font.BOLD, 20));
		resetCheck.setSize(400, 30);
		resetCheck.setLocation(85, 50);

		setSize(500, 500);
		setVisible(true);
	}

	private void createMenu() {
		JMenuBar mb = new JMenuBar(); // 메뉴바 만들고
		setJMenuBar(mb);

		JMenu seatMenu = new JMenu("좌석 관리");
		seatMenu.setFont(new Font("a시월구일1", Font.BOLD, 10));
		JMenuItem seatItem1 = new JMenuItem("현재 좌석 상태 확인");
		seatItem1.setFont(new Font("a시월구일1", Font.BOLD, 10));
		seatItem1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new studynow_seat();
				setVisible(false);
			}
		});

		JMenuItem seatItem2 = new JMenuItem("전체 좌석 리셋");
		seatItem2.setFont(new Font("a시월구일1", Font.BOLD, 10));
		seatItem2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new studyseat_reset();
				setVisible(false);
			}
		});
		
		seatMenu.add(seatItem1);
		seatMenu.add(seatItem2);
		mb.add(seatMenu);

		JMenu cusMenu = new JMenu("손님 관리"); // 메뉴 만들고
		cusMenu.setFont(new Font("a시월구일1", Font.BOLD, 10));
		JMenuItem cusItem = new JMenuItem("손님현황 확인");
		cusItem.setFont(new Font("a시월구일1", Font.BOLD, 10));
		cusItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Check_cus();
				setVisible(false);
			}
		});
		cusMenu.add(cusItem);
		mb.add(cusMenu);

		JMenu monMenu = new JMenu("수입 관리"); // 메뉴 만들고
		monMenu.setFont(new Font("a시월구일1", Font.BOLD, 10));
		JMenuItem monItem = new JMenuItem("총 수입 확인");
		monItem.setFont(new Font("a시월구일1", Font.BOLD, 10));
		monItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new monCheck();
				setVisible(false);
			}
		});
		monMenu.add(monItem);
		mb.add(monMenu);

		JMenu exitMenu = new JMenu("종료");
		exitMenu.setFont(new Font("a시월구일1", Font.BOLD, 10));
		JMenuItem exitItem = new JMenuItem("종료");
		exitItem.setFont(new Font("a시월구일1", Font.BOLD, 10));
		exitMenu.add(exitItem);
		mb.add(exitMenu);
		exitItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new manalastStudy();
				setVisible(false);
			}
		});
	}
	
	class MyPanel extends JPanel {
		private ImageIcon dog = new ImageIcon("img/dog1.png"); // 파일로부터 이미지를 읽어들임
		private Image img = dog.getImage();

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 120, 110, 360, 340, 0, 0, 394, 393, this);
		}
	}

	public static void main(String[] args) {
		new studymanage();
	}
}
