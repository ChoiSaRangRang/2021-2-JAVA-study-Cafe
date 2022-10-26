import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class studycusto extends JFrame {
	private JLabel menu = new JLabel("<비숑 StudyRoom 이용요금>");
	private JLabel menumoney = new JLabel("분당 100원");
	private MyPanel panel = new MyPanel();
	
	studycusto() {
		setTitle("비숑 StudyRoom_사용자모드");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setContentPane(panel);
		Container c = getContentPane();
		c.setLayout(null);
		
		
		c.add(menu);
		menu.setFont(new Font("a시월구일2", Font.BOLD, 25));
		menu.setLocation(75, 0);
		menu.setSize(350, 100);
		
		c.add(menumoney);
		menumoney.setFont(new Font("a시월구일2", Font.BOLD, 25));
		menumoney.setLocation(170, 40);
		menumoney.setSize(350, 100);
		
		JButton seatInbtn = new JButton("입장하숑");
		c.add(seatInbtn);
		seatInbtn.setFont(new Font("a시월구일2", Font.BOLD, 11));
		seatInbtn.setLocation(80, 350);
		seatInbtn.setSize(150, 35);
		seatInbtn.setBackground(new Color(196, 222, 255));
		seatInbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new readyStudy();
				setVisible(false);
			}
		});
		
		JButton seatoutbtn = new JButton("퇴장하숑");
		c.add(seatoutbtn);
		seatoutbtn.setFont(new Font("a시월구일2", Font.BOLD, 11));
		seatoutbtn.setLocation(260, 350);
		seatoutbtn.setSize(150, 35);
		seatoutbtn.setBackground(new Color(196, 222, 255));
		seatoutbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new byeStudy();
				setVisible(false);
			}
		});
		
//		JButton exitbtn = new JButton("종료하숑");
//		c.add(exitbtn);
//		exitbtn.setFont(new Font("a시월구일2", Font.BOLD, 11));
//		exitbtn.setLocation(300, 350);
//		exitbtn.setSize(100, 35);
//		exitbtn.setBackground(new Color(196, 222, 255));
//		exitbtn.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				setVisible(false);
//				new custolastStudy();
//			}
//		});


		JButton firstbtn = new JButton("처음으로");
		c.add(firstbtn);
		firstbtn.setFont(new Font("a시월구일2", Font.BOLD, 11));
		firstbtn.setLocation(385, 425);
		firstbtn.setSize(100, 35);
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
		private ImageIcon dog = new ImageIcon("img/dog1.png"); // 파일로부터 이미지를 읽어들임
		private Image img = dog.getImage();

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 120, 110, 350, 330, 0, 0, 394, 393, this);
		}
	}

	public static void main(String[] args) {
		new studycusto();
	}

}
