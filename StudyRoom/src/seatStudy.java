import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

public class seatStudy extends JFrame {
	private JLabel label = new JLabel("�¼��� �������ּ��� (�ʷϻ� : ���ڸ�)");
	private Color background = new Color(255, 217, 236);
	private Calendar cal;

	seatStudy() {
		setTitle("��� StudyRoom_����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(null);

		c.add(label, BorderLayout.NORTH);
		label.setFont(new Font("a�ÿ�����2", Font.BOLD, 20));
		label.setLocation(65, 30);
		label.setSize(400, 30);

		JPanel centerPanel = new JPanel();
		GridLayout grid = new GridLayout(2, 5, 5, 5);
		centerPanel.setLayout(grid);

		c.add(centerPanel);
		centerPanel.setLocation(60, 70);
		centerPanel.setSize(350, 200);

		for (int i = 1; i <= 10; i++) { // 1���� 10������ for�� ��� - ������ ���� & ������
			JButton b = new JButton(Integer.toString(i));
			if (db.state_seat(i)) { // �̹� �����
				b.setBackground(new Color(255, 217, 236));
			} else { // ���ڸ�
				b.setBackground(new Color(183, 240, 177)); // ���� ����
			}

			b.setFont(new Font("a�ÿ�����2", Font.BOLD, 25));
			centerPanel.add(b); // ��ư �߰�
			b.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (b.getBackground().equals(background)) {
						JOptionPane.showMessageDialog(null, "��� ���� �¼��Դϴ�.", "�¼� Ȯ�� ��", JOptionPane.PLAIN_MESSAGE);
					} else {
						cal=Calendar.getInstance();
						JLabel lastCheck = new JLabel(
								readyStudy.cus.getName() + " / �¼���ȣ : " + b.getText() + " / ����ð� : "+cal.get(Calendar.HOUR_OF_DAY)+"�� "+cal.get(Calendar.MINUTE)+"��");
						readyStudy.cus.setSeat_no(Integer.parseInt(b.getText()));
						readyStudy.cus.setIn_time(cal.get(Calendar.HOUR_OF_DAY)*60+cal.get(Calendar.MINUTE));
						
						db.save_cus_info(readyStudy.cus);
						
						c.add(lastCheck);
						lastCheck.setFont(new Font("a�ÿ�����2", Font.BOLD, 18));
						lastCheck.setLocation(65, 350);
						lastCheck.setSize(400, 50);
						int result = JOptionPane.showConfirmDialog(null, "������ �´��� Ȯ�����ּ���.", "���� Ȯ�� ��",
								JOptionPane.YES_NO_OPTION);
						if (result == JOptionPane.YES_OPTION) {
							JOptionPane.showMessageDialog(null, "�����Ͽ����ϴ�.", "�ݰ���! �����ϼ�!",
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
