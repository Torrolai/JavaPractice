package com.test;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

import javax.swing.*;


/*
 * “网络爬虫”：界面可以做成图形化界面；下载时可以判断是不是网页（其中有HTML标记）；
 * 可以猜测网页的编码（charset）；可以避免循环下载（将已下载过的网页记下来）；
 * 可以处理相对地址；
 * 可以记录下来网页中得到的email地址等等。Review criteria
 */
public class URLCrawler {
	public void init() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		JFrame CrawlerF =new JFrame("CrawlerF");
		CrawlerF.setSize(300, 400);
		CrawlerF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lable = new JLabel("");
		
		
	}	
	
	public static void main(String[] args) 
		throws Exception{
		// TODO Auto-generated method stub
		//ConcurrentLinkedQueue 是网址的一个集合	
		ConcurrentLinkedQueue<String> urls = new ConcurrentLinkedQueue<>();
		urls.add("http://www.dstang.com");
		int cnt=0;
		while(!urls.isEmpty()) {
			String url=urls.poll();
			System.out.println(url);
			new Thread(()-> {
				try {
					String content= download(new URL(url),"utf-8");
					List<String> moreUrl=parse(content);					
					urls.addAll(moreUrl);
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}).start();
			if (cnt++ > 5) break;
			try {Thread.sleep(4000);}catch(InterruptedException ex) {};
		}
	}

	private static List<String> parse(String text) {
		// TODO Auto-generated method stub
		String patternString = "\\s*href\\s*=\\s*(\"([^\"]*\")|(\'[^\']*\')|([^\'\">\\s]+))\\s*";
		//Pattern Matcher是啥
		Pattern pattern = Pattern.compile(patternString,Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(text);
		List<String> list=new ArrayList<>();
		while(matcher.find()) {
			String href=matcher.group(1);
			//研究一下
			href = href.replaceAll("\'","").replaceAll("\"","");
			if(href.startsWith("http:"))
				list.add(href);
		}
		return list;
	}

	private static String download(URL url, String charset)
		throws Exception
	{
		try(InputStream input = url.openStream(); 
			ByteArrayOutputStream output=new ByteArrayOutputStream())
		{
			byte[] data = new byte[1024];
			int length;
			while((length=input.read(data))!=-1) {
				output.write(data,0,length);
			}
			byte[] content = output.toByteArray();
			return new String(content,Charset.forName(charset));					
		}

	}

}


