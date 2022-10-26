import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class studymanage extends JFrame {
	private MyPanel panel = new MyPanel();
	
	studymanage() {
		setTitle("��� StudyRoom_�����ڸ��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		createMenu();
		setContentPane(panel);
		Container c = getContentPane();
		c.setLayout(null);

		JButton firstbtn = new JButton("ó������");
		c.add(firstbtn);
		firstbtn.setFont(new Font("a�ÿ�����2", Font.BOLD, 11));
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
		
		JLabel resetCheck = new JLabel("<��� StudyRoom ������ ���>");
		c.add(resetCheck);
		resetCheck.setFont(new Font("a�ÿ�����2", Font.BOLD, 20));
		resetCheck.setSize(400, 30);
		resetCheck.setLocation(85, 50);

		setSize(500, 500);
		setVisible(true);
	}

	private void createMenu() {
		JMenuBar mb = new JMenuBar(); // �޴��� �����
		setJMenuBar(mb);

		JMenu seatMenu = new JMenu("�¼� ����");
		seatMenu.setFont(new Font("a�ÿ�����1", Font.BOLD, 10));
		JMenuItem seatItem1 = new JMenuItem("���� �¼� ���� Ȯ��");
		seatItem1.setFont(new Font("a�ÿ�����1", Font.BOLD, 10));
		seatItem1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new studynow_seat();
				setVisible(false);
			}
		});

		JMenuItem seatItem2 = new JMenuItem("��ü �¼� ����");
		seatItem2.setFont(new Font("a�ÿ�����1", Font.BOLD, 10));
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

		JMenu cusMenu = new JMenu("�մ� ����"); // �޴� �����
		cusMenu.setFont(new Font("a�ÿ�����1", Font.BOLD, 10));
		JMenuItem cusItem = new JMenuItem("�մ���Ȳ Ȯ��");
		cusItem.setFont(new Font("a�ÿ�����1", Font.BOLD, 10));
		cusItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Check_cus();
				setVisible(false);
			}
		});
		cusMenu.add(cusItem);
		mb.add(cusMenu);

		JMenu monMenu = new JMenu("���� ����"); // �޴� �����
		monMenu.setFont(new Font("a�ÿ�����1", Font.BOLD, 10));
		JMenuItem monItem = new JMenuItem("�� ���� Ȯ��");
		monItem.setFont(new Font("a�ÿ�����1", Font.BOLD, 10));
		monItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new monCheck();
				setVisible(false);
			}
		});
		monMenu.add(monItem);
		mb.add(monMenu);

		JMenu exitMenu = new JMenu("����");
		exitMenu.setFont(new Font("a�ÿ�����1", Font.BOLD, 10));
		JMenuItem exitItem = new JMenuItem("����");
		exitItem.setFont(new Font("a�ÿ�����1", Font.BOLD, 10));
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
		private ImageIcon dog = new ImageIcon("img/dog1.png"); // ���Ϸκ��� �̹����� �о����
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
