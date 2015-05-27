package tn.esprit.Blues.EjbTimer;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import tn.esprit.Blues.entities.Company;
import tn.esprit.Blues.entities.Pricehistory;
import tn.esprit.Blues.entities.Share;

@Singleton
@Startup
public class ParserServicesImpl implements ParserServices {

	private List<Float> OpeningPriceF = new ArrayList<Float>();
	private List<Float> ClosingPriceF = new ArrayList<Float>();
	private List<Float> LowestPriceF = new ArrayList<Float>();
	private List<Float> HighestPriceF = new ArrayList<Float>();
	private List<Float> VolumeF = new ArrayList<Float>();

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Company> findCompany() {
		Query query = manager.createQuery("SELECT c FROM Company c");
		return query.getResultList();
	}

	@Override
	public Company findById(int id) {
		return manager.find(Company.class, id);
	}

	@Override
	public void update(Company s, Pricehistory pricehistory) {
		try {
			manager.persist(pricehistory);
			manager.merge(s);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// void setTrustAllCerts() throws Exception {
	// TrustManager[] trustAllCerts = new TrustManager[] { new
	// X509TrustManager() {
	// public java.security.cert.X509Certificate[] getAcceptedIssuers() {
	// return null;
	// }
	//
	// public void checkClientTrusted(
	// java.security.cert.X509Certificate[] certs, String authType) {
	// }
	//
	// public void checkServerTrusted(
	// java.security.cert.X509Certificate[] certs, String authType) {
	// }
	// } };
	//
	// // Install the all-trusting trust manager
	// try {
	// SSLContext sc = SSLContext.getInstance("SSL");
	// sc.init(null, trustAllCerts, new java.security.SecureRandom());
	// HttpsURLConnection
	// .setDefaultSSLSocketFactory(sc.getSocketFactory());
	// HttpsURLConnection
	// .setDefaultHostnameVerifier(new HostnameVerifier() {
	// @Override
	// public boolean verify(String urlHostName,
	// SSLSession session) {
	// return true;
	// }
	//
	// });
	// } catch (Exception e) {
	// // We can not recover from this exception.
	// e.printStackTrace();
	// }
	// }

	@SuppressWarnings("unused")
	public String readhtml() {

		String s = "http://94.23.168.196:8090/LiveMarket/LiveMarket.zul";
		String s2 = "http://www.ilboursa.com/marches/aaz.aspx";
		URL url = null;
		URL url2 = null;
		try {
			try {
				url = new URL(s);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				url2 = new URL(s2);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Document doc = null;
			Document doc2 = null;
			try {
				doc = Jsoup.connect(s).userAgent("Mozilla").get();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				doc2 = Jsoup.connect(s2).userAgent("Mozilla").get();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Element table = doc.select("table").get(1);
			Element table2 = doc2.select("table").get(0);

			String data = table.text();
			String data2 = table2.text();
			data2 = data2.substring(3689);

			List<String> list = new ArrayList<String>();
			List<String> list2 = new ArrayList<String>();

			List<String> CompanyName = new ArrayList<String>();
			List<String> OpeningPrice = new ArrayList<String>();
			List<String> ClosingPrice = new ArrayList<String>();
			List<String> LowestPrice = new ArrayList<String>();
			List<String> HighestPrice = new ArrayList<String>();
			List<String> Volume = new ArrayList<String>();

			Pattern pattern = Pattern.compile("([a-zA-Z](.*?):..)");
			Matcher matcher = pattern.matcher(data);
			Pattern pattern2 = Pattern.compile("((.*?)\\p{Punct}..\\p{Punct})");
			Matcher matcher2 = pattern2.matcher(data2);
			Pattern pattern3 = Pattern
					.compile("([^[0-9]|[\\p{Punct}]](\\d|\\p{Punct})*\\p{Space})");

			Pattern pattern5 = Pattern
					.compile("([^[a-zA-Z]]([a-zA-Z]|\\p{Punct}|\\p{Space})*([a-zA-Z][a-zA-Z]))|(BT)|(BH)");
			int j = 0;
			while (matcher.find()) {
				String i;
				int rows = 10;

				i = matcher.group();

				list.add(i);
				Matcher matcher5 = pattern5.matcher(list.get(j));
				if (matcher5.find())
					CompanyName.add(matcher5.group());
				Matcher matcher3 = pattern3.matcher(i);
				while (matcher3.find()) {
					if (rows == 7)
						OpeningPrice.add(matcher3.group());
					else if (rows == 6)
						ClosingPrice.add(matcher3.group());
					else if (rows == 4)
						Volume.add(matcher3.group());
					else if (rows == 2)
						HighestPrice.add(matcher3.group());
					else if (rows == 1)
						LowestPrice.add(matcher3.group());
					rows--;
				}
				data = data.substring(i.length());
				j++;

			}

			while (matcher2.find()) {
				String i;
				int rows = 6;
				i = matcher2.group();
				Matcher matcher5 = pattern5.matcher(i);
				if (matcher5.find())
					CompanyName.add(matcher5.group());
				list2.add(i);
				j++;
				Matcher matcher3 = pattern3.matcher(i);
				while (matcher3.find()) {
					if (j == 71) {
						if (rows == 5)
							OpeningPrice.add(matcher3.group());
						else if (rows == 0)
							ClosingPrice.add(matcher3.group());

						else if (rows == 4)
							HighestPrice.add(matcher3.group());
						else if (rows == 3)
							LowestPrice.add(matcher3.group());
						else if (rows == 2)
							Volume.add(matcher3.group());
					} else {
						if (rows == 6)
							OpeningPrice.add(matcher3.group());
						else if (rows == 1)
							ClosingPrice.add(matcher3.group());

						else if (rows == 5)
							HighestPrice.add(matcher3.group());
						else if (rows == 4)
							LowestPrice.add(matcher3.group());
						else if (rows == 3)
							Volume.add(matcher3.group());
					}
					rows--;
				}
				data2 = data2.substring(i.length());
			}
			for (int x = 0; x < CompanyName.size(); x++) {

				try {
					Float f = Float.parseFloat(OpeningPrice.get(x));
					OpeningPriceF.add(f);
				} catch (Exception exception) {
					OpeningPriceF.add(0f);
				}
				try {
					Float f = Float.parseFloat(ClosingPrice.get(x));
					ClosingPriceF.add(f);
				} catch (Exception exception) {
					ClosingPriceF.add(0f);
				}
				try {
					Float f = Float.parseFloat(HighestPrice.get(x));
					HighestPriceF.add(f);
				} catch (Exception exception) {
					HighestPriceF.add(0f);
				}
				try {
					Float f = Float.parseFloat(LowestPrice.get(x));
					LowestPriceF.add(f);
				} catch (Exception exception) {
					LowestPriceF.add(0f);
				}
				try {
					Float f = Float.parseFloat(Volume.get(x));
					VolumeF.add(f);
				} catch (Exception exception) {
					VolumeF.add(0f);
				}
			}

//			CompanyName.remove(76);
//			OpeningPrice.remove(76);
//			ClosingPrice.remove(76);
//			LowestPrice.remove(76);
//			HighestPrice.remove(76);
//			OpeningPriceF.remove(76);
//			ClosingPriceF.remove(76);
//			LowestPriceF.remove(76);
//			HighestPriceF.remove(76);
//			VolumeF.remove(76);

			List<Company> companies = findCompany();
			Share share = new Share();
			System.out.println(companies.size());
			Company c = new Company();
			
			for (int i = 0; i < CompanyName.size(); i++) {
					
				
				for (int k = 0; k < companies.size(); k++) {
					if (companies.get(k).getName().equals(CompanyName.get(i))) {
						c = companies.get(k);
						Pricehistory pricehistory=new Pricehistory();
						System.out.println(c.getId()+" =id"+k);
						System.out.println(CompanyName.get(i));
						c.getQuotation().setClosingPrice(ClosingPriceF.get(i));
						c.getQuotation().setOpningPrice(OpeningPriceF.get(i));
						c.getQuotation().setHighestPrice(HighestPriceF.get(i));
						c.getQuotation().setLowestPrice(LowestPriceF.get(i));
						c.getQuotation().setVolume(VolumeF.get(i));
						pricehistory.setQuotation(c.getQuotation());
						pricehistory.setClosingPrice(ClosingPriceF.get(i));
						pricehistory.setOpningPrice(OpeningPriceF.get(i));
						pricehistory.setHighestPrice(HighestPriceF.get(i));
						pricehistory.setLowestPrice(LowestPriceF.get(i));
						pricehistory.setVolume(VolumeF.get(i));
						pricehistory.setTime(new Date());
						//c.setQuotation(share);
						try {
							// update(c,pricehistory);
						} catch (Exception e) {
							e.printStackTrace();
						}
						System.out.println(share.getClosingPrice());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "see you in 15 minutes";

	}

	@PostConstruct
	@Schedule(year = "*", dayOfWeek = "*", hour = "*", minute = "*/20", persistent = false)
	public void init() {

		readhtml();
	}

	public List<Float> getVolumeF() {
		return VolumeF;
	}

	public void setVolumeF(List<Float> volumeF) {
		VolumeF = volumeF;
	}

}
