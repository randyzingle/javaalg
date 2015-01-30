/*
 * Created on Jun 9, 2006
 * 
 * @author jbergin
 *
 */
package books; 

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
* Provides a dialog box prompt for user input of long and double values.  The dialog
* is modal and does not return (unless specifically cancelled) until the user enters a 
* valid value of the right type. <p>
* 
* To use a Prompter, create one, passing it a Frame (NOT null).  
* You then just call getLong, getDouble... supplying a prompt string that informs
* the user what is required.  A dialog box will be put up with a button labeled
* with the type of data required.  The user pushes this button when data have been
* added to the Reply field.  The dialog will not accept illegal values. 
* The cancel button will cancel the function and will return default values (zero). 
* <p> Sources: <a href = Prompter.java> Prompter.java </a> 
*/

public class Prompter 
{	/** Create a new Prompter.
	* @param parent The Prompter's parent frame.  Must not be null.
	*/

    /** Prompt for and return a long value.
	* @param prompt A string to be shown in the dialog box to help the user.
	* @return the long entered by the user. 
	*/
	public long getLong(String prompt)
	{
		InputDialog longDialog = new InputDialog(prompt, "Long");
		longDialog.requestFocus();
		longDialog.setVisible(true);
		long value = longValue;
		longValue = 0;
		return value;
	}
	
	/** Prompt for and return a double value.
	* @param prompt A string to be shown in the dialog box to help the user.
	* @return the double entered by the user. 
	*/	
	public double getDouble(String prompt)
	{
		InputDialog doubleDialog = new InputDialog(prompt, "Double");
		doubleDialog.requestFocus();
		doubleDialog.setVisible(true);
		double value = doubleValue;
		doubleValue = 0.0;
		return value;
	}
	
	private void resetValues(long v, double fv)
	{
		longValue = v;
		doubleValue = fv;
	} 

	private long longValue = 0;
	private double doubleValue = 0.0;
	private boolean wantlong = true;
	private JTextField response;	
	
	
	// inner
	private class InputDialog extends JDialog
	{
		public InputDialog(String prompt, String typeTag)
		{
			super(new JFrame(), "Input Required", true);
			setLayout(new BorderLayout());
			
			JPanel centralPanel = new JPanel();
			centralPanel.setLayout(new GridLayout(2,2));
			centralPanel.add(new JLabel(""));
			JTextField promptField = new JTextField(prompt, prompt.length());
			promptField.setEnabled(false);
			centralPanel.add(promptField);
			centralPanel.add(new JLabel("    Reply"));
			response = new JTextField("");
			centralPanel.add(response);
			
			add(centralPanel, BorderLayout.CENTER);
			
			JPanel buttonPanel = new JPanel();			
			JButton aButton = new JButton(typeTag);
			buttonPanel.add(aButton);
			ActionListener itsListener  = new GotItListener();
			aButton.addActionListener(itsListener);
			response.addActionListener(itsListener);
			
			aButton = new JButton("Cancel");
			buttonPanel.add(aButton);
			aButton.addActionListener(new CancelListener());
			
			add(buttonPanel, BorderLayout.SOUTH);
			setSize(300, 100);
			setLocation(100,100);
			if( typeTag.equalsIgnoreCase("double"))wantlong = false;
			setResizable(false);
		}
		
		public void requestFocus()
		{
			response.requestFocus();
		}
		
		private class GotItListener implements ActionListener
		{
//			GotItListener(Prompter prompter)
//			{
//				this.prompter = prompter;
//			}
			
			public void actionPerformed(ActionEvent e)
			{
				boolean done = false;
				String raw = response.getText().trim();
				if(wantlong)
				{
					try
						{
							Prompter.this.resetValues(Long.parseLong(raw), 0.0);
							InputDialog.this.setVisible(false);
							InputDialog.this.dispose();
						}
						catch(NumberFormatException ex)
						{
							return;
						}
				}
				else
				{
					try
						{
					        Prompter.this.resetValues(0, Double.valueOf(raw).doubleValue());
							InputDialog.this.setVisible(false);
							InputDialog.this.dispose();
						}
						catch(NumberFormatException ex)
						{
							return;
						}
				}
			}
			
//			private Prompter prompter;			
		}

		private class CancelListener implements ActionListener
		{
//			CancelListener(Prompter prompter)
//			{
//				this.prompter = prompter;
//			}
			
			public void actionPerformed(ActionEvent e)
			{
				InputDialog.this.setVisible(false);
				InputDialog.this.dispose();
				Prompter.this.resetValues(0, 0.0);
			}
			
//			private Prompter prompter;
		}
		
	}

}

