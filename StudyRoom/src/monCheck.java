import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class monCheck extends JFrame {
	private JLabel title = new JLabel("총 금액을 확인해보숑:)");
	private MyPanel panel = new MyPanel();
	
	public monCheck() {
		setTitle("비숑 StudyRoom_");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setContentPane(panel);
		Container c = getContentPane();
		c.setLayout(null);
		
		c.add(title);
		title.setFont(new Font("a시월구일2", Font.BOLD, 20));
		title.setLocation(130, 70);
		title.setSize(400, 30);
		
		JLabel mon = new JLabel("오늘의 수입은 " +db.total_income()+"원 입니다:)");
		c.add(mon);
		mon.setFont(new Font("a시월구일2", Font.BOLD, 20));
		mon.setLocation(110, 250);
		mon.setSize(400, 30);
		
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
			g.drawImage(img, 60, 60, 120, 110, 0, 0, 299, 261, this);
			g.drawImage(img1, 350, 60, 410, 110, 0, 0, 600, 609, this);
		}
	}
	
	public static void main(String[] args) {
		new monCheck();
	}
}
