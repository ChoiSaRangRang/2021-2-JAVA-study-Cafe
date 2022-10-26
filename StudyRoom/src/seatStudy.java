import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

public class seatStudy extends JFrame {
	private JLabel label = new JLabel("좌석을 선택해주세요 (초록색 : 빈자리)");
	private Color background = new Color(255, 217, 236);
	private Calendar cal;

	seatStudy() {
		setTitle("비숑 StudyRoom_입장");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(null);

		c.add(label, BorderLayout.NORTH);
		label.setFont(new Font("a시월구일2", Font.BOLD, 20));
		label.setLocation(65, 30);
		label.setSize(400, 30);

		JPanel centerPanel = new JPanel();
		GridLayout grid = new GridLayout(2, 5, 5, 5);
		centerPanel.setLayout(grid);

		c.add(centerPanel);
		centerPanel.setLocation(60, 70);
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
			b.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (b.getBackground().equals(background)) {
						JOptionPane.showMessageDialog(null, "사용 중인 좌석입니다.", "좌석 확인 중", JOptionPane.PLAIN_MESSAGE);
					} else {
						cal=Calendar.getInstance();
						JLabel lastCheck = new JLabel(
								readyStudy.cus.getName() + " / 좌석번호 : " + b.getText() + " / 입장시간 : "+cal.get(Calendar.HOUR_OF_DAY)+"시 "+cal.get(Calendar.MINUTE)+"분");
						readyStudy.cus.setSeat_no(Integer.parseInt(b.getText()));
						readyStudy.cus.setIn_time(cal.get(Calendar.HOUR_OF_DAY)*60+cal.get(Calendar.MINUTE));
						
						db.save_cus_info(readyStudy.cus);
						
						c.add(lastCheck);
						lastCheck.setFont(new Font("a시월구일2", Font.BOLD, 18));
						lastCheck.setLocation(65, 350);
						lastCheck.setSize(400, 50);
						int result = JOptionPane.showConfirmDialog(null, "정보가 맞는지 확인해주세요.", "입장 확인 중",
								JOptionPane.YES_NO_OPTION);
						if (result == JOptionPane.YES_OPTION) {
							JOptionPane.showMessageDialog(null, "입장하였습니다.", "반갑숑! 열공하숑!",
									JOptionPane.INFORMATION_MESSAGE);
							new studyroomall();
							setVisible(false);
						} else {
							new studyroomall();
							setVisible(false);
						}
					}
				}
			});
		}

		setSize(500, 500);
		setVisible(true);
	}
	

	public static void main(String[] args) {
		new seatStudy();
	}
}
