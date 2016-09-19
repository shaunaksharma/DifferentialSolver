package DifferentialSolver;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Driver
{
	public static void main(String[] args)
	{
		new Driver();
	}

	public Driver()
	{
		//test comment
		JFrame frame = new JFrame("Differential Solver");
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);

		frame.setResizable(false);

		JPanel panel = new JPanel();
		panel.setSize(400, 400);
		frame.add(panel);

		panel.setLayout(new FlowLayout());
		//panel.setBackground(Color.RED);

		JPanel StaticTextPanel = new JPanel();
		panel.add(StaticTextPanel);
		StaticTextPanel.add(new JLabel("Enter Equation Here."));

		JPanel EquationPanel = new JPanel();
		panel.add(EquationPanel);

		JTextField text = new JTextField("", 15);
		EquationPanel.add(text);
		text.setColumns(30);
		text.setSize(100, 30);
		panel.add(text);
		text.setBackground(Color.WHITE);

		JPanel buttonPanel = new JPanel();
		panel.add(buttonPanel);
		JButton submit = new JButton("Submit");
		buttonPanel.add(submit);

		JPanel answerPanel = new JPanel();
		panel.add(answerPanel);
		JTextArea answer = new JTextArea(10, 30);
		answer.setText("Answer Here");
		//answer.setEnabled(false);
		answer.setLineWrap(true);
		answer.setWrapStyleWord(true);
		answerPanel.add(answer);

		text.setVisible(true);
		frame.setVisible(true);
		panel.setVisible(true);

		frame.getRootPane().setDefaultButton(submit);

		submit.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						boolean ex = false;
						try
						{
							TheClass.MasterSolver(text.getText());
							ex = false;
						}

						catch(Exception f)
						{
							ex = true;
							answer.setText("The formatting is wrong. Make sure every 'x' has a coefficient and a power, even if it is 0 or 1, and that all open brackets are closed.");
						}

						if(!ex)
						{
							answer.setText(TheClass.MasterSolver(text.getText()));
						}
					}

				});
	}
}
