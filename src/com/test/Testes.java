package com.test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Testes extends JFrame {

	private JPanel contentPane;
	private JTextField UrlContent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Testes frame = new Testes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Testes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5730\u5740\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 12));
		lblNewLabel.setBounds(53, 14, 36, 15);
		contentPane.add(lblNewLabel);
		
		UrlContent = new JTextField();
		UrlContent.setBounds(90, 11, 244, 21);
		contentPane.add(UrlContent);
		UrlContent.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(90, 45, 244, 254);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("\u6293\u53D6");
		btnNewButton.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {
				String FirUrl=UrlContent.getText();
				try {
					CrawUrl(FirUrl, textArea);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(339, 10, 63, 23);
		contentPane.add(btnNewButton);
		

	}
	
	public void CrawUrl(String FirUrl,JTextArea Area) 
		throws Exception{
		ConcurrentLinkedQueue<String> urls = new ConcurrentLinkedQueue<>();
		urls.add(FirUrl);
		int cnt=0;
		while(!urls.isEmpty()) {
			String url=urls.poll();
			Area.append(url+"\r\n");
			//System.out.println(url);
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

	private List<String> parse(String content) {
		// TODO Auto-generated method stub
		String patternString = "\\s*href\\s*=\\s*(\"([^\"]*\")|(\'[^\']*\')|([^\'\">\\s]+))\\s*";
		//Pattern Matcher是啥
		Pattern pattern = Pattern.compile(patternString,Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(content);
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

	private String download(URL url, String charset) 
			throws Exception{
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
