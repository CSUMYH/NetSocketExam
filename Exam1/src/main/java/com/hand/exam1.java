package com.hand;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;

public class exam1 {
	  public static void main(String[] args) {
          // TODO Auto-generated method stub

          try {
         URL url = new URL("http://files.saas.hand-china.com/java/target.pdf");
         URLConnection connection = url.openConnection();
         InputStream is = connection.getInputStream();
         BufferedInputStream bis = new BufferedInputStream(is);
         FileOutputStream fos = new FileOutputStream("target.pdf");
         BufferedOutputStream bos = new BufferedOutputStream(fos);
          byte []  list = new byte[1024]; 
          int len =0;
          while ((len =bis.read(list))!=-1){
        	  bos.write(list,0,len);
        	  bos.flush();
         }
      
          bos.close();
          fos.close();
          bis.close();
    
          is.close();
         } catch (FileNotFoundException e ) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
         } catch (UnsupportedEncodingException e ) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
         } catch (IOException e ) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
         }

   }

}
