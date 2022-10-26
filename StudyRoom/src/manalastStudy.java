import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class manalastStudy extends JFrame {
	private JLabel title = new JLabel("���õ� ������ �� �����!");
	private MyPanel panel = new MyPanel();

	public manalastStudy() {
		setTitle("��� StudyRoom_������ �λ�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setContentPane(panel);
		Container c = getContentPane();
		c.setLayout(null);

		c.add(title);
		title.setFont(new Font("a�ÿ�����2", Font.BOLD, 25));
		title.setLocation(85, 0);
		title.setSize(450, 150);

		JButton byebtn = new JButton("���� ����");
		c.add(byebtn);
		byebtn.setFont(new Font("a�ÿ�����2", Font.BOLD, 11));
		byebtn.setLocation(70, 350);
		byebtn.setSize(130, 35);
		byebtn.setBackground(new Color(255, 178, 217));
		byebtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				db.delete_cus_all();
				db.delete_history();
				System.exit(0);
			}
		});

		JButton firstbtn = new JButton("ó������");
		c.add(firstbtn);
		firstbtn.setFont(new Font("a�ÿ�����2", Font.BOLD, 11));
		firstbtn.setLocation(280, 350);
		firstbtn.setSize(130, 35);
		firstbtn.setBackground(new Color(228, 247, 186));
		firstbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new studyroomall();
				setVisible(false);
			}
		});

		setSize(500, 500);
		setVisible(true);

	}

	class MyPanel extends JPanel {
		private ImageIcon dog = new ImageIcon("img/dog1.png"); // ���Ϸκ��� �̹����� �о����
		private Image img = dog.getImage();

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 120, 110, 350, 330, 0, 0, 394, 393, this);
		}
	}

	public static void main(String[] args) {
		new manalastStudy();
	}

}
