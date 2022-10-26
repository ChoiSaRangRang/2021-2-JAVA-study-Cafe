import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

public class byeStudy extends JFrame {
	private JLabel name = new JLabel("이름 : ");
	private JTextField textname = new JTextField(10);
	public static cus_info cus = new cus_info();
	private JButton namebtn = new JButton("확인");
	private static String getName;
	private Calendar cal;
	private int money;
	public static int Out_time;

	byeStudy() {
		setTitle("비숑 StudyRoom_퇴장");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(null);

		c.add(name);
		name.setFont(new Font("a시월구일2", Font.BOLD, 20));
		name.setLocation(100, 30);
		name.setSize(100, 100);

		c.add(textname);
		textname.setFont(new Font("a시월구일2", Font.BOLD, 20));
		textname.setLocation(165, 55);
		textname.setSize(150, 50);

		c.add(namebtn);
		namebtn.setFont(new Font("a시월구일2", Font.BOLD, 20));
		namebtn.setLocation(320, 55);
		namebtn.setSize(80, 50);
		namebtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getName = textname.getText();
				if (!(db.isName(getName)))
					JOptionPane.showMessageDialog(null, "존재하지 않는 이름입니다.", "이름 확인 중", JOptionPane.PLAIN_MESSAGE);
				else {
					cus=db.ret_cus_info(getName);
					cal=Calendar.getInstance();
					JLabel seatNo = new JLabel("이용한 좌석 번호 : " + cus.getSeat_no() + "번");
					JLabel seatTime = new JLabel("입장 시간 : " + cus.getIn_time() / 60 + "시 "
							+ cus.getIn_time() % 60 + "분");
					JLabel byeTime = new JLabel("퇴장 시간 : "+cal.get(Calendar.HOUR_OF_DAY)+"시 "+cal.get(Calendar.MINUTE)+"분");
					Out_time=(cal.get(Calendar.HOUR_OF_DAY)*60+cal.get(Calendar.MINUTE));
					
					c.add(seatNo);
					seatNo.setFont(new Font("a시월구일2", Font.BOLD, 18));
					seatNo.setLocation(150, 150);
					seatNo.setSize(400, 50);

					c.add(seatTime);
					seatTime.setFont(new Font("a시월구일2", Font.BOLD, 18));
					seatTime.setLocation(150, 200);
					seatTime.setSize(400, 50);

					c.add(byeTime);
					byeTime.setFont(new Font("a시월구일2", Font.BOLD, 18));
					byeTime.setLocation(150, 250);
					byeTime.setSize(400, 50);

					int result = JOptionPane.showConfirmDialog(null, "정보가 맞는지 확인해주세요.", "퇴장 확인 중",
							JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION) {
						money=(Out_time-cus.getIn_time());
						JLabel lastMon = new JLabel("지불해야할 금액은 "+money*100+"원입니다.");
						c.add(lastMon);
						lastMon.setFont(new Font("a시월구일2", Font.BOLD, 18));
						lastMon.setLocation(120, 300);
						lastMon.setSize(400, 50);

						JButton Okbtn = new JButton("퇴장하기");
						c.add(Okbtn);
						Okbtn.setFont(new Font("a시월구일2", Font.BOLD, 18));
						Okbtn.setLocation(170, 360);
						Okbtn.setSize(150, 35);
						Okbtn.setBackground(new Color(206, 247, 110));
						Okbtn.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								setVisible(false);
								new custolastStudy();
							}
						});
					} else {
						new studyroomall();
						setVisible(false);
					}

				}

			}
		});

		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new byeStudy();
	}
}
