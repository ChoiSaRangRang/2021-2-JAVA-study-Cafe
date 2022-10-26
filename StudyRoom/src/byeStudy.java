import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

public class byeStudy extends JFrame {
	private JLabel name = new JLabel("�̸� : ");
	private JTextField textname = new JTextField(10);
	public static cus_info cus = new cus_info();
	private JButton namebtn = new JButton("Ȯ��");
	private static String getName;
	private Calendar cal;
	private int money;
	public static int Out_time;

	byeStudy() {
		setTitle("��� StudyRoom_����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(null);

		c.add(name);
		name.setFont(new Font("a�ÿ�����2", Font.BOLD, 20));
		name.setLocation(100, 30);
		name.setSize(100, 100);

		c.add(textname);
		textname.setFont(new Font("a�ÿ�����2", Font.BOLD, 20));
		textname.setLocation(165, 55);
		textname.setSize(150, 50);

		c.add(namebtn);
		namebtn.setFont(new Font("a�ÿ�����2", Font.BOLD, 20));
		namebtn.setLocation(320, 55);
		namebtn.setSize(80, 50);
		namebtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getName = textname.getText();
				if (!(db.isName(getName)))
					JOptionPane.showMessageDialog(null, "�������� �ʴ� �̸��Դϴ�.", "�̸� Ȯ�� ��", JOptionPane.PLAIN_MESSAGE);
				else {
					cus=db.ret_cus_info(getName);
					cal=Calendar.getInstance();
					JLabel seatNo = new JLabel("�̿��� �¼� ��ȣ : " + cus.getSeat_no() + "��");
					JLabel seatTime = new JLabel("���� �ð� : " + cus.getIn_time() / 60 + "�� "
							+ cus.getIn_time() % 60 + "��");
					JLabel byeTime = new JLabel("���� �ð� : "+cal.get(Calendar.HOUR_OF_DAY)+"�� "+cal.get(Calendar.MINUTE)+"��");
					Out_time=(cal.get(Calendar.HOUR_OF_DAY)*60+cal.get(Calendar.MINUTE));
					
					c.add(seatNo);
					seatNo.setFont(new Font("a�ÿ�����2", Font.BOLD, 18));
					seatNo.setLocation(150, 150);
					seatNo.setSize(400, 50);

					c.add(seatTime);
					seatTime.setFont(new Font("a�ÿ�����2", Font.BOLD, 18));
					seatTime.setLocation(150, 200);
					seatTime.setSize(400, 50);

					c.add(byeTime);
					byeTime.setFont(new Font("a�ÿ�����2", Font.BOLD, 18));
					byeTime.setLocation(150, 250);
					byeTime.setSize(400, 50);

					int result = JOptionPane.showConfirmDialog(null, "������ �´��� Ȯ�����ּ���.", "���� Ȯ�� ��",
							JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION) {
						money=(Out_time-cus.getIn_time());
						JLabel lastMon = new JLabel("�����ؾ��� �ݾ��� "+money*100+"���Դϴ�.");
						c.add(lastMon);
						lastMon.setFont(new Font("a�ÿ�����2", Font.BOLD, 18));
						lastMon.setLocation(120, 300);
						lastMon.setSize(400, 50);

						JButton Okbtn = new JButton("�����ϱ�");
						c.add(Okbtn);
						Okbtn.setFont(new Font("a�ÿ�����2", Font.BOLD, 18));
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
