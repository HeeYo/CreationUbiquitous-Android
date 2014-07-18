package com.taboit.ubiqouitous;

import java.io.IOException;

import android.os.AsyncTask;

public class TcpSend extends AsyncTask<Void, Void, Void> {
	@Override
	protected Void doInBackground(Void... params) {
		try {
			NewClient.setSocket();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
