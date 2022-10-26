import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class custolastStudy extends JFrame {
	private JLabel title = new JLabel("비숑 StudyRoom을 이용해주셔서 감사합니다:)");
	private JLabel subTitle = new JLabel("비숑 StudyRoom 다음에 또 이용해주숑!");
	private MyPanel panel = new MyPanel();

	public custolastStudy() {
		setTitle("비숑 StudyRoom_마지막 인사");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setContentPane(panel);
		Container c = getContentPane();
		c.setLayout(null);

		c.add(title);
		title.setFont(new Font("a시월구일2", Font.BOLD, 20));
		title.setLocation(20, 0);
		title.setSize(450, 150);
		
		c.add(subTitle);
		subTitle.setFont(new Font("a시월구일2", Font.BOLD, 20));
		subTitle.setLocation(40, 35);
		subTitle.setSize(450, 150);
		
		JButton byebtn = new JButton("정말 나가겠숑");
		c.add(byebtn);
		byebtn.setFont(new Font("a시월구일2", Font.BOLD, 11));
		byebtn.setLocation(70,365);
		byebtn.setSize(130, 35);
		byebtn.setBackground(new Color(255, 178, 217));
		byebtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				db.delete_cus(byeStudy.cus.getName(), byeStudy.Out_time);
				new studyroomall();
				setVisible(false);
			}
		});
		
		JButton firstbtn = new JButton("처음으로 가겠숑");
		c.add(firstbtn);
		firstbtn.setFont(new Font("a시월구일2", Font.BOLD, 11));
		firstbtn.setLocation(280,365);
		firstbtn.setSize(130,35);
		firstbtn.setBackground(new Color(228, 247, 186));
		firstbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new studyroomall();
				setVisible(false);
			}
		});
		
		setSize(500,500);
		setVisible(true);

	}

	class MyPanel extends JPanel {
		private ImageIcon dog = new ImageIcon("img/dog1.png"); // 파일로부터 이미지를 읽어들임
		private Image img = dog.getImage();

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 120, 130, 350, 350, 0, 0, 394, 393, this);
		}
	}

	public static void main(String[] args) {
		new custolastStudy();
	}
}
