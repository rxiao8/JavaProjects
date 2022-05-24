package ATM;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

public class ATMGUI {

	// exprimenting with GUI. Static login page and no functionaility has been added

	public ATMGUI() {
		Frame f = new Frame();
		f.setBackground(Color.gray);
		Label lFirst = new Label("First name:");
		Label lLast = new Label("Last name:");
		Label lPin = new Label("Pin:");

		Button b = new Button("Submit");
		TextField tFirst = new TextField();
		TextField tLast = new TextField();
		TextField tPin = new TextField();

		lFirst.setBounds(20, 80, 80, 30);
		tFirst.setBounds(20, 120, 150, 30);

		lLast.setBounds(20, 160, 80, 30);
		tLast.setBounds(20, 200, 150, 30);

		lPin.setBounds(20, 240, 80, 30);
		tPin.setBounds(20, 280, 80, 30);

		b.setBounds(20, 350, 80, 30);
		b.setBackground(Color.green);

		f.add(b);
		f.add(lFirst);
		f.add(lLast);
		f.add(lPin);
		f.add(tFirst);
		f.add(tLast);
		f.add(tPin);

		f.setSize(500, 600);

		f.setTitle("ATM");
		f.setLayout(null);
		f.setVisible(true);
	}

	public static void main(String args[]) {
		ATMGUI atm = new ATMGUI();
	}

}
