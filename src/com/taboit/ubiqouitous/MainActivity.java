package com.taboit.ubiqouitous;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button but1, but2, but3, but4;
	Activity act = this;
	TcpSend tcpThread = null;
<<<<<<< HEAD
	TextView ipView =null;
=======
>>>>>>> parent of 527b82e... Added IP change feature
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
<<<<<<< HEAD
		
		
		ipView = (TextView)findViewById(R.id.editText1);
		ipView.setHint(NewClient.getIp());
=======
>>>>>>> parent of 527b82e... Added IP change feature

		but1 = (Button)findViewById(R.id.button1);
		but1.setOnClickListener(listener);
		but2 = (Button)findViewById(R.id.button2);
		but2.setOnClickListener(listener);
		but3 = (Button)findViewById(R.id.button3);
		but3.setOnClickListener(listener);
		but4 = (Button)findViewById(R.id.button4);
		but4.setOnClickListener(listener);
<<<<<<< HEAD
		but_ip = (Button)findViewById(R.id.button5);
		but_ip.setOnClickListener(listener);
		NewClient.protocolSet(new byte [] {0,0,0,0,0});
		tcpThread = (TcpSend) new TcpSend().execute((Void) null);
=======
>>>>>>> parent of 527b82e... Added IP change feature
		
	}
	Button.OnClickListener listener = new Button.OnClickListener()
	{
		public void onClick(View v)
		{
			Toast.makeText(act.getBaseContext(), "Connecting", Toast.LENGTH_SHORT).show();
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
<<<<<<< HEAD
				case R.id.button5 :
					Toast.makeText(act.getBaseContext(), ipView.getText(), Toast.LENGTH_SHORT).show();			//버그 존재. 이유는 잘 모르곘는데 처음 바로 실행하면 크래시뜸
					NewClient.changeIp(ipView.getText().toString());
					break;
=======
			
>>>>>>> parent of 527b82e... Added IP change feature
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			tcpThread.cancel(true);	
		}
	};
}

