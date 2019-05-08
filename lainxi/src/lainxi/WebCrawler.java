package lainxi;

import java.util.ArrayList;
import java.util.Scanner;

public class WebCrawler {

	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.println("enter a URL");
		String url = input.nextLine();
		crawler(url);

	}
	public static void crawler(String startingURL) {
		ArrayList<String> listofPendingURLs= new ArrayList<>();
		ArrayList<String> listogTraversedURLs= new ArrayList<>();
		
		listofPendingURLs.add(startingURL);
		while(!listofPendingURLs.isEmpty() &&
				listogTraversedURLs.size()<=100) {
			String urlString = listofPendingURLs.remove(0);
			if (listogTraversedURLs.contains(urlString)) {
				listogTraversedURLs.add(urlString);
				System.out.println("crawl"+ urlString);
				
				for (String s:getSubURLs(urlString)) {
					if(!listofPendingURLs.contains(s))
						listofPendingURLs.add(s);
				}
			}
		}
		}
	public static ArrayList<String> getSubURLs(String urlString){
		ArrayList<String> list = new ArrayList<>();
		
		try {
			java.net.URL url = new java.net.URL(urlString);
			Scanner input = new Scanner (url.openStream());
			int current = 0 ;
			while (input.hasNext()) {
				String line = input.nextLine();
				current = line.indexOf("http:",current);
				while (current>0) {
					int endIndex = line.indexOf("\"", current);
					if (endIndex>0) {
						list.add(line.substring(current, endIndex));
						current = line.indexOf("http:"+endIndex);
					}
					else
						current=-1;
					}
				}
			}
		catch(Exception ex) {
			System.out.println("error"+":"+ex.getMessage());
		}
		return list;
	}

}
