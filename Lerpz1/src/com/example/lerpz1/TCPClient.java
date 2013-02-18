package com.example.lerpz1;

import android.util.Log;

import java.net.InetAddress;
import java.net.Socket;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

/*
 * http://myandroidsolutions.blogspot.com/2012/07/android-tcp-connection-tutorial.html
 * 
 */
public class TCPClient {

	private String serverMessage;
	public static final String SERVERIP = "192.168.1.143";
	public static final int SERVERPORT = 1234;
	private OnMessageReceived mMessageListener = null;
	private boolean mRun = false;
	
	PrintWriter out;
	BufferedReader in;
	
	public TCPClient(OnMessageReceived listener){
		mMessageListener = listener;
	}
	
	public void sendMessage(String message){
		if(out!=null && !out.checkError()){
			out.println(message);
			out.flush();
		}
	}
	
	public void stopClient(){
		mRun = false;
	}
	
	public void run(){
		mRun = true;
		try{
			InetAddress serverAddr = InetAddress.getByName(SERVERIP);
			
			Log.e("TCP Client","Client: Connecting...");
			System.out.println("CONNECTION");
			
			Socket socket = new Socket(serverAddr, SERVERPORT);
			
			try{
				
				out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
				
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
				while(mRun){
					serverMessage = in.readLine();
					if(serverMessage != null && mMessageListener != null){
						mMessageListener.messageReceived(serverMessage);
					}
					serverMessage = null;
				}
			}catch(Exception e){
				Log.e("TCP", "Server: Error",e);
			} finally{
				socket.close();
			}
		} catch(Exception e){
			Log.e("TCP","Client: Error",e);
		}
	}
	
	public interface OnMessageReceived{
		public void messageReceived(String message);
	}
}
