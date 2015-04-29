package tn.esprit.Blues.EjbTimer;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import tn.esprit.Blues.entities.Company;
import tn.esprit.Blues.entities.Share;


@Stateless
public class ParserServicesImpl implements ParserServices {
	
	
	private List<Float> OpeningPriceF = new ArrayList<Float>();
	private List<Float> ClosingPriceF = new ArrayList<Float>();
	private List<Float> LowestPriceF = new ArrayList<Float>();
	private List<Float> HighestPriceF = new ArrayList<Float>();
	
	public List<Float> getOpeningPriceF() {
		return OpeningPriceF;
	}

	public void setOpeningPriceF(List<Float> openingPriceF) {
		OpeningPriceF = openingPriceF;
	}

	public List<Float> getClosingPriceF() {
		return ClosingPriceF;
	}

	public void setClosingPriceF(List<Float> closingPriceF) {
		ClosingPriceF = closingPriceF;
	}

	public List<Float> getLowestPriceF() {
		return LowestPriceF;
	}

	public void setLowestPriceF(List<Float> lowestPriceF) {
		LowestPriceF = lowestPriceF;
	}

	public List<Float> getHighestPriceF() {
		return HighestPriceF;
	}

	public void setHighestPriceF(List<Float> highestPriceF) {
		HighestPriceF = highestPriceF;
	}

	@PersistenceContext(name = "Blues")
	EntityManager manager;

	@Override
	public Company findCompanyByName(String name) {
		Query query = manager
				.createQuery("SELECT c FROM Company c WHERE c.name = '" + name
						+ "'");
		return (Company) query.getSingleResult();
	}

	@Override
	public Company findById(int id) {
		return manager.find(Company.class, id);
	}

	@Override
	public void update(Share s) {
		manager.merge(s);

	}
	
	void setTrustAllCerts() throws Exception {
		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			public void checkClientTrusted(
					java.security.cert.X509Certificate[] certs, String authType) {
			}

			public void checkServerTrusted(
					java.security.cert.X509Certificate[] certs, String authType) {
			}
		} };

		// Install the all-trusting trust manager
		try {
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection
					.setDefaultSSLSocketFactory(sc.getSocketFactory());
			HttpsURLConnection
					.setDefaultHostnameVerifier(new HostnameVerifier() {
						@Override
						public boolean verify(String urlHostName,
								SSLSession session) {
							return true;
						}

					});
		} catch (Exception e) {
			// We can not recover from this exception.
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	//@Schedule(second="*", minute="*/5", hour="*")
	public String readhtml() {
//
//		String s = "http://94.23.168.196:8090/LiveMarket/LiveMarket.zul";
//		String s2 = "http://www.ilboursa.com/marches/aaz.aspx";
//		URL url = null;
//		URL url2 = null;
//		try {
//			url = new URL(s);
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			url2 = new URL(s2);
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		Document doc = null;
//		Document doc2 = null;
//		try {
//			doc = Jsoup.connect(s).userAgent("Mozilla").get();
//			// System.out.println(doc);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			doc2 = Jsoup.connect(s2).userAgent("Mozilla").get();
//			// System.out.println(doc);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Element table = doc.select("table").get(1);
//		Element table2 = doc2.select("table").get(0);
//
//		String data = table.text();
//		String data2 = table2.text();
//		data2 = data2.substring(3689);
//
//		List<String> list = new ArrayList<String>();
//		List<String> list2 = new ArrayList<String>();
//
//		List<String> CompanyName = new ArrayList<String>();
//		List<String> OpeningPrice = new ArrayList<String>();
//		List<String> ClosingPrice = new ArrayList<String>();
//		List<String> LowestPrice = new ArrayList<String>();
//		List<String> HighestPrice = new ArrayList<String>();
//
//
//		Pattern pattern = Pattern.compile("([a-zA-Z](.*?):..)");
//		Matcher matcher = pattern.matcher(data);
//		Pattern pattern2 = Pattern.compile("((.*?)\\p{Punct}..\\p{Punct})");
//		Matcher matcher2 = pattern2.matcher(data2);
//		Pattern pattern3 = Pattern
//				.compile("([^[0-9]|[\\p{Punct}]](\\d|\\p{Punct})*\\p{Space})");
//
//		// Matcher matcher4 = pattern3.matcher(list2.get(0));
//		Pattern pattern5 = Pattern
//				.compile("([^[a-zA-Z]]([a-zA-Z]|\\p{Punct}|\\p{Space})*([a-zA-Z][a-zA-Z]))|(BT)|(BH)");
//		int j = 0;
//		while (matcher.find()) {
//			String i;
//			int rows = 10;
//
//			i = matcher.group();
//
//			list.add(i);
//			Matcher matcher5 = pattern5.matcher(list.get(j));
//			if (matcher5.find())
//				CompanyName.add(matcher5.group());
//			Matcher matcher3 = pattern3.matcher(i);
//			while (matcher3.find()) {
//				if (rows == 7)
//					OpeningPrice.add(matcher3.group());
//				else if (rows == 6)
//					ClosingPrice.add(matcher3.group());
//
//				else if (rows == 2)
//					HighestPrice.add(matcher3.group());
//				else if (rows == 1)
//					LowestPrice.add(matcher3.group());
//				rows--;
//			}
//			data = data.substring(i.length());
//			j++;
//
//		}
//
//		System.out.println(j);
//		while (matcher2.find()) {
//			String i;
//			int rows = 6;
//			i = matcher2.group();
//			Matcher matcher5 = pattern5.matcher(i);
//			if (matcher5.find())
//				CompanyName.add(matcher5.group());
//			list2.add(i);
//			j++;
//			Matcher matcher3 = pattern3.matcher(i);
//			while (matcher3.find()) {
//				if (j == 71) {
//					if (rows == 5)
//						OpeningPrice.add(matcher3.group());
//					else if (rows == 0)
//						ClosingPrice.add(matcher3.group());
//
//					else if (rows == 4)
//						HighestPrice.add(matcher3.group());
//					else if (rows == 3)
//						LowestPrice.add(matcher3.group());
//				} else {
//					if (rows == 6)
//						OpeningPrice.add(matcher3.group());
//					else if (rows == 1)
//						ClosingPrice.add(matcher3.group());
//
//					else if (rows == 5)
//						HighestPrice.add(matcher3.group());
//					else if (rows == 4)
//						LowestPrice.add(matcher3.group());
//				}
//				rows--;
//			}
//			data2 = data2.substring(i.length());
//		}
//		for (int x = 0; x < CompanyName.size(); x++) {
//
//			try {
//				Float f = Float.parseFloat(OpeningPrice.get(x));
//				OpeningPriceF.add(f);
//			} catch (Exception exception) {
//				OpeningPriceF.add(0f);
//			}
//			try {
//				Float f = Float.parseFloat(ClosingPrice.get(x));
//				ClosingPriceF.add(f);
//			} catch (Exception exception) {
//				ClosingPriceF.add(0f);
//			}
//			try {
//				Float f = Float.parseFloat(HighestPrice.get(x));
//				HighestPriceF.add(f);
//			} catch (Exception exception) {
//				HighestPriceF.add(0f);
//			}
//			try {
//				Float f = Float.parseFloat(LowestPrice.get(x));
//				LowestPriceF.add(f);
//			} catch (Exception exception) {
//				LowestPriceF.add(0f);
//			}
//		}
//
//		CompanyName.remove(76);
//		OpeningPrice.remove(76);
//		ClosingPrice.remove(76);
//		LowestPrice.remove(76);
//		HighestPrice.remove(76);
//		OpeningPriceF.remove(76);
//		ClosingPriceF.remove(76);
//		LowestPriceF.remove(76);
//		HighestPriceF.remove(76);
//
//		 System.out.println(CompanyName);
//		// System.out.println(OpeningPriceF);
//		// System.out.println(OpeningPriceF);
//		// System.out.println(OpeningPrice);
//		// System.out.println(ClosingPriceF);
//		// System.out.println(LowestPriceF);
//		// System.out.println(HighestPriceF);
//		// System.out.println(j);
//		Share share= new Share();
//		for(int i=0;i<CompanyName.size();i++){
//			Company c=new Company();
//			try{
//				c=findCompanyByName(CompanyName.get(i));
//			}
//			catch(Exception exception){
//				findById(1);
//			}
//			share.setClosingPrice(ClosingPriceF.get(i));
//			share.setOpningPrice(OpeningPriceF.get(i));
//			share.setHighestPrice(HighestPriceF.get(i));
//			share.setLowestPrice(LowestPriceF.get(i));
//			share.setCompany(c);
//			c.setQuotation(share);
//			System.out.println(c);
//			//manager.merge(c);
//		}

		return "see you in 15 minutes";

	}

}
