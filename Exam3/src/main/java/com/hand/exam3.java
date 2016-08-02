package com.hand;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.gson.JsonObject;
import com.sun.imageio.spi.OutputStreamImageOutputStreamSpi;

public class exam3  extends Thread{
	public static void main(String [] args){
		new  exam3().start();
		}
	
	public void run(){
		try {
			URL url = new URL("HTTP://hq.sinajs.cn/list=sz300170");
			URLConnection connection = url.openConnection();
			InputStream is = connection.getInputStream();
			InputStreamReader isr = new InputStreamReader(is,"GBK");
			BufferedReader br = new BufferedReader(isr);
			String line;
			StringBuilder builder = new StringBuilder();
			while((line=br.readLine())!=null){
				builder.append(line);
			}
			br.close();
			isr.close();
			is.close();
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder ad = factory.newDocumentBuilder();
			Document document = ad.newDocument();
			Element stock = document.createElement("stock");
			Element root= document.createElement("name");
			root.setTextContent(builder.substring(21, 25));
			Element open  = document.createElement("open");
			open.setTextContent(builder.substring(26, 32));
			Element close  = document.createElement("close");
			close.setTextContent(builder.substring(33, 39));
			Element current  = document.createElement("current");
			current.setTextContent(builder.substring(40, 46));
			Element high  = document.createElement("high");
			high.setTextContent(builder.substring(47, 53));
			Element low  = document.createElement("low");
			low.setTextContent(builder.substring(54, 60));
			stock.appendChild(root);
			stock.appendChild(open);
			stock.appendChild(close);
			stock.appendChild(current);
			stock.appendChild(high);
			stock.appendChild(low);
			document.appendChild(stock);
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			StringWriter writer = new StringWriter();
			transformer.transform(new DOMSource(document), new StreamResult(writer));
			System.out.println(writer.toString());
			transformer.transform(new DOMSource(document), new StreamResult("newxml.xml"));
			JsonObject object = new JsonObject();
			object.addProperty("name", builder.substring(21, 25));
			object.addProperty("open", builder.substring(26, 32));
			object.addProperty("close", builder.substring(33, 39));
			object.addProperty("current", builder.substring(40, 46));
			object.addProperty("high", builder.substring(47, 53));
			object.addProperty("low", builder.substring(54, 60));
			
			File jsonfile = new File("new_json.json");
			FileOutputStream fos = new FileOutputStream(jsonfile);
			OutputStreamWriter osw =  new OutputStreamWriter(fos,"UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			bw.write(object.toString());
			bw.flush();
			bw.close();
			osw.close();
			fos.close();
			System.out.println(object.toString());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}
