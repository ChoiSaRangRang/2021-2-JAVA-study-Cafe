import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Check_cus extends JFrame {
	private JLabel title = new JLabel("손님 현황 확인해보숑:)");
	private MyPanel panel = new MyPanel();

	public Check_cus() {
		setTitle("비숑 StudyRoom_손님 현황");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setContentPane(panel);
		Container c = getContentPane();
		c.setLayout(null);

		c.add(title);
		title.setFont(new Font("a시월구일2", Font.BOLD, 20));
		title.setLocation(130, 50);
		title.setSize(400, 30);

		Object record[] = new Object[3];
		String[] field = { "이름", "좌석 번호", "입장시간" };
		DefaultTableModel tableModel = new DefaultTableModel(field, 0);
		JTable table = new JTable(tableModel);
		JScrollPane sp = new JScrollPane(table);
		c.add(sp);
		sp.setFont(new Font("a시월구일2", Font.BOLD, 10));
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

		JButton firstbtn = new JButton("뒤로가기");
		c.add(firstbtn);
		firstbtn.setFont(new Font("a시월구일2", Font.BOLD, 11));
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
		private ImageIcon dog = new ImageIcon("img/dogfull.png"); // 파일로부터 이미지를 읽어들임
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
