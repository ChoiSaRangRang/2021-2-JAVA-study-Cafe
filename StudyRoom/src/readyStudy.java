import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class readyStudy extends JFrame {
	private JLabel name = new JLabel("�̸� : ");
	private JTextField textname = new JTextField(10);
	private JButton namebtn = new JButton("Ȯ��");
	public static cus_info cus = new cus_info();
	private String getName;

	readyStudy() {
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
				if (db.isName(getName))
					JOptionPane.showMessageDialog(null, "�̹� �����ϴ� �̸��Դϴ�.", "�̸� Ȯ�� ��", JOptionPane.PLAIN_MESSAGE);
				else {
					cus.setName(getName);
					new seatStudy();
					setVisible(false);
				}

			}
		});

		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new readyStudy();
	}
}
