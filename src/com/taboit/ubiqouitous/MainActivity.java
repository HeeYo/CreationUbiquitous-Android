package com.taboit.ubiqouitous;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button but1, but2, but3, but4,but_ip;
	Activity act = this;
	TcpSend tcpThread = null;
	TextView ipView =null;
	NewClient newClient = new NewClient();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		ipView = (TextView)findViewById(R.id.editText1);
		ipView.setHint(newClient.getIp());

		but1 = (Button)findViewById(R.id.button1);
		but1.setOnClickListener(listener);
		but2 = (Button)findViewById(R.id.button2);
		but2.setOnClickListener(listener);
		but3 = (Button)findViewById(R.id.button3);
		but3.setOnClickListener(listener);
		but4 = (Button)findViewById(R.id.button4);
		but4.setOnClickListener(listener);
		but_ip = (Button)findViewById(R.id.button5);
		but_ip.setOnClickListener(listener);
		
	}
	Button.OnClickListener listener = new Button.OnClickListener()
	{
		public void onClick(View v)
		{
			switch(v.getId())
			{
				case R.id.button1 :
					NewClient.protocolSet(new byte [] {0,1,0,0,0});
					tcpThread = (TcpSend) new TcpSend().execute((Void) null);
					break;
				case R.id.button2 :
					NewClient.protocolSet(new byte [] {0,2,0,0,0});
					tcpThread = (TcpSend) new TcpSend().execute((Void) null);
					break;
				case R.id.button3 :
					NewClient.protocolSet(new byte [] {0,3,0,0,0});
					tcpThread = (TcpSend) new TcpSend().execute((Void) null);
					break;
				case R.id.button4 :
					NewClient.protocolSet(new byte [] {0,4,0,0,0});
					tcpThread = (TcpSend) new TcpSend().execute((Void) null);
					break;
				case R.id.button5 :
					Toast.makeText(act.getBaseContext(), ipView.getText(), Toast.LENGTH_SHORT).show();
					newClient.changeIp(ipView.getText().toString());
					//ipView.setText(NewClient.getIp());
					break;
			}
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			tcpThread.cancel(true);	
		}
	};
}

