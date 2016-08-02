package com.hand;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Service {

	private static ServerSocket socketserv;

	public static void main(String[] args) {
		try {
			socketserv = new ServerSocket(12348);
			while(true){
			Socket socket = socketserv.accept();
			JOptionPane.showMessageDialog(null, "Á¬½Óµ½12348");
			System.out.println(123);
			 File file = new File("../Exam1/target.pdf");
			 BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));				
		     BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
		     byte[] bt = new byte[1024];
		     int len=0;
		     while((len = bis.read(bt))!=-1){
		      	bos.write(bt,0,len);
		        //System.out.println(bt.toString());	    bos.flush();
		      
		      }
		     bos.flush();	
		     bis.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
