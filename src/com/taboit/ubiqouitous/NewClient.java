package com.taboit.ubiqouitous;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class NewClient {	 
	    static Socket socket;										//기본 설정
	    static OutputStream os;
	    static DataOutputStream out;
	    public static String ip = "192.168.90.1"; // IP
	    private static int port = 9999; // PORT번호
	    private static byte protocol [] = {0x02,0x0A,0x01,0,0,0,0,0,0,0x03};
	    
<<<<<<< HEAD
	    public static void changeIp(String in)
	    {
	    	ip = (String)in;
	    }
	    public static String getIp()
	    {
	    	return (String)ip;
	    }
=======
>>>>>>> parent of 527b82e... Added IP change feature
	    public static void setSocket() throws IOException {
	        try {
	        	init();
	            send();
	        }
	        finally{
	        	out.close();
	        	socket.close();
	        }
	    }
	    public static void send() throws IOException
	    {
	    	for(int i = 0; i < 10; i++){
            	out.writeByte(protocol[i]);  
	            out.flush();
            }
	    }
	    public static void init() throws UnknownHostException, IOException
	    {
	    	socket = new Socket(ip, port);
           	os = socket.getOutputStream();
            out = new DataOutputStream(os);
	    }
	    //STX	OPCODE	ADDR	DNUM	DATA0~DATA3	CHKSUM	EXT
	    public static void protocolSet(byte [] data)		//전달받는 데이터는 5개 0~4
	    {	
	    	int j = 0;
	    	byte CHKSUM = 0;
	    	for(int i = 3; i <= 7; i++)
	    	{
	    		protocol[i] = data[j];
	    		j += 1;
	    	}
	    	for(int i = 1; i <= 7; i++)
	    	{
	    		CHKSUM += protocol[i];
	    	}
	    	protocol[8] = (byte) ~CHKSUM;
	    }
}
/*
 *			protocolSet(new byte [] {0,1,2,3,4});			//인자 전달 후 소켓 열후 데이터 구성한 뒤, 전송한다.
 *   		setSocket();
*/
