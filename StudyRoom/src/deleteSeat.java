import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class deleteSeat extends JFrame {
	public JLabel label = new JLabel("현재 좌석 상태(초록색 : 빈자리)");
	private MyPanel panel = new MyPanel();

	deleteSeat() {
		setTitle("비숑 StudyRoom_전체 좌석 리셋");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setContentPane(panel);
		Container c = getContentPane();
		c.setLayout(null);

		JButton resetbtn = new JButton("전체 좌석 리셋");
		c.add(resetbtn);
		resetbtn.setFont(new Font("a시월구일2", Font.BOLD, 11));
		resetbtn.setLocation(170, 400);
		resetbtn.setSize(150, 35);
		resetbtn.setBackground(new Color(255, 178, 217));

		JLabel resetCheck = new JLabel("모든 좌석이 해제되었습니다.");
		c.add(resetCheck);
		resetCheck.setFont(new Font("a시월구일2", Font.BOLD, 20));
		resetCheck.setSize(400, 30);
		resetCheck.setLocation(120, 130);

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

		c.add(label, BorderLayout.NORTH);
		label.setFont(new Font("a시월구일2", Font.BOLD, 20));
		label.setLocation(95, 70);
		label.setSize(400, 30);

		JPanel centerPanel = new JPanel();
		GridLayout grid = new GridLayout(2, 5, 5, 5);
		centerPanel.setLayout(grid);

		c.add(centerPanel);
		centerPanel.setLocation(70, 180);
		centerPanel.setSize(350, 200);

		for (int i = 1; i <= 10; i++) { // 1부터 10까지는 for문 사용 - 동일한 색상 & 사이즈
			JButton b = new JButton(Integer.toString(i));
			if (db.state_seat(i)) { // 이미 사용중
				b.setBackground(new Color(255, 217, 236));
			} else { // 빈자리
				b.setBackground(new Color(183, 240, 177)); // 배경색 설정
			}

			b.setFont(new Font("a시월구일2", Font.BOLD, 25));
			centerPanel.add(b); // 버튼 추가
		}

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
			g.drawImage(img, 30, 50, 95, 115, 0, 0, 299, 261, this);
			g.drawImage(img1, 390, 50, 455, 115, 0, 0, 600, 609, this);
		}
	}

	public static void main(String[] args) {
		new studyseat_reset();
	}
}
