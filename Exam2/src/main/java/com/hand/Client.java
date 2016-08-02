package com.hand;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
  private static Socket socket;

public static  void  main(String [] args){
  try {
	socket = new Socket("127.0.0.1", 12348);
    BufferedInputStream bis1 = new BufferedInputStream(socket.getInputStream());
    BufferedOutputStream bos1= new BufferedOutputStream(new FileOutputStream(new File("target1.pdf")));
    byte[] bt1 = new byte[1024];
    int len1=0;
    while((len1 = bis1.read(bt1))!=-1){
    	bos1.write(bt1,0,len1); 
    	 bos1.flush();
    }
   
    bos1.close();
    bis1.close();
} catch (UnknownHostException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
  }
}
