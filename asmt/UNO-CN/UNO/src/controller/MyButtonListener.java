package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyButtonListener implements ActionListener {

	JudgeController myServer;

	public void setServer(JudgeController server) {
		myServer = server;
	}

	public void drawCard() {
		if (myServer.canPlay) {
			myServer.requestCard();
		}
	}

	public void sayUno() {
		if (myServer.canPlay) {
			myServer.submitSaidUno();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

}