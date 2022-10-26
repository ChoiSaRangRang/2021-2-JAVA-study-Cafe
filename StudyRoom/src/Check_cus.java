import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Check_cus extends JFrame {
	private JLabel title = new JLabel("�մ� ��Ȳ Ȯ���غ���:)");
	private MyPanel panel = new MyPanel();

	public Check_cus() {
		setTitle("��� StudyRoom_�մ� ��Ȳ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setContentPane(panel);
		Container c = getContentPane();
		c.setLayout(null);

		c.add(title);
		title.setFont(new Font("a�ÿ�����2", Font.BOLD, 20));
		title.setLocation(130, 50);
		title.setSize(400, 30);

		Object record[] = new Object[3];
		String[] field = { "�̸�", "�¼� ��ȣ", "����ð�" };
		DefaultTableModel tableModel = new DefaultTableModel(field, 0);
		JTable table = new JTable(tableModel);
		JScrollPane sp = new JScrollPane(table);
		c.add(sp);
		sp.setFont(new Font("a�ÿ�����2", Font.BOLD, 10));
		sp.setLocation(20, 120);
		sp.setSize(450, 200);

		ArrayList<cus_info> list = db.exist_cus_info();
		for (int i = 0; i < list.size(); i++) {
			cus_info cus = list.get(i);
			record[0] = cus.getName();
			record[1] = cus.getSeat_no();
			record[2] = (cus.getIn_time()/60+":"+cus.getIn_time()%60);
			tableModel.addRow(record);
		}

		JButton firstbtn = new JButton("�ڷΰ���");
		c.add(firstbtn);
		firstbtn.setFont(new Font("a�ÿ�����2", Font.BOLD, 11));
		firstbtn.setLocation(385, 425);
		firstbtn.setSize(100, 35);
		firstbtn.setBackground(new Color(228, 247, 186));
		firstbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new studymanage();
				setVisible(false);
			}
		});

		setSize(500, 500);
		setVisible(true);
	}

	class MyPanel extends JPanel {
		private ImageIcon dog = new ImageIcon("img/dogfull.png"); // ���Ϸκ��� �̹����� �о����
		private ImageIcon dog2 = new ImageIcon("img/dogfoot.jpg");
		private Image img = dog.getImage();
		private Image img1 = dog2.getImage();

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 50, 25, 125, 100, 0, 0, 299, 261, this);
			g.drawImage(img1, 350, 25, 425, 100, 0, 0, 600, 609, this);
		}
	}

	public static void main(String[] args) {
		new Check_cus();
	}
}
