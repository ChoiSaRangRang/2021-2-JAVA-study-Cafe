import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class studyroomall extends JFrame {
	private JLabel title = new JLabel("��� StudyRoom�� ���� �� ȯ���մϴ�!");
	private MyPanel panel = new MyPanel();

	public studyroomall() {
		setTitle("��� StudyRoom");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setContentPane(panel);
		Container c = getContentPane();
		c.setLayout(null);

		JButton exitbtn = new JButton("�����ϼ�");
		c.add(exitbtn);
		exitbtn.setLocation(180, 420);
		exitbtn.setSize(130, 35);
		exitbtn.setBackground(new Color(183, 240, 177));
		exitbtn.setFont(new Font("a�ÿ�����2", Font.BOLD, 11));

		exitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new manalastStudy();
				setVisible(false);
			}
		});

		c.add(title);
		title.setFont(new Font("a�ÿ�����2", Font.BOLD, 20));
		title.setForeground(new Color(54, 138, 255));
		title.setLocation(60, 60);
		title.setSize(450, 100);

		JButton manabtn = new JButton("������ ���");
		c.add(manabtn);
		manabtn.setLocation(60, 270);
		manabtn.setSize(130, 35);
		manabtn.setBackground(new Color(209, 178, 255));
		manabtn.setFont(new Font("a�ÿ�����2", Font.BOLD, 11));
		manabtn.setForeground(Color.WHITE);
		manabtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int num = Integer.parseInt(JOptionPane.showInputDialog(null, "������ ��� ��й�ȣ�� �Է��ϼ���.", "������ ��� Ȯ��",
						JOptionPane.INFORMATION_MESSAGE));
				if (num == 1234) {
					new studymanage();
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "��й�ȣ�� �߸��Ǿ����ϴ�", "��й�ȣ ����", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		JButton visibtn = new JButton("����� ���");
		c.add(visibtn);
		visibtn.setLocation(300, 270);
		visibtn.setSize(130, 35);
		visibtn.setBackground(Color.pink);
		visibtn.setFont(new Font("a�ÿ�����2", Font.BOLD, 11));
		visibtn.setForeground(Color.WHITE);

		visibtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new studycusto();
				setVisible(false);
			}
		});

		setSize(500, 500);
		setVisible(true);
	}

	class MyPanel extends JPanel {
		private ImageIcon dog = new ImageIcon("img/dog1.png"); // ���Ϸκ��� �̹����� �о����
		private Image img = dog.getImage();
		private ImageIcon dog2 = new ImageIcon("img/dog2.jpg");
		private Image img2 = dog2.getImage();

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 300, 150, 430, 270, 0, 0, 394, 393, this);
			g.drawImage(img2, 60, 150, 190, 270, 0, 0, 394, 393, this);
		}
	}

	public static void main(String[] args) {
		new studyroomall();
	}
}
