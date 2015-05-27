//package tn.esprit.Blues.EjbTimer;
//
//import java.io.IOException;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import javax.annotation.PostConstruct;
//import javax.ejb.Schedule;
//import javax.ejb.Singleton;
//import javax.ejb.Startup;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//
//import tn.esprit.Blues.entities.Bank;
//import tn.esprit.Blues.entities.Currency;
//import tn.esprit.Blues.entities.Currencybank;
//
//@Singleton
//@Startup
//public class CurrencyParser {
//
//	@PersistenceContext(name = "Blues")
//	EntityManager manager;
//
//	private List<String> Labels = new ArrayList<String>();
//	private List<Integer> Unities = new ArrayList<Integer>();
//	private List<Float> Buy = new ArrayList<Float>();
//	private List<Float> Sell = new ArrayList<Float>();
//	private List<Bank> banks;
//	private List<Currency> currencies;
//	private List<Currencybank> currencybanks= new ArrayList<Currencybank>();
//
//	public List<Currency> findAllCurr() {
//		Query query = manager.createQuery("SELECT c FROM Currency c ORDER BY c.name");
//		return query.getResultList();
//	}
//
//	public List<Bank> findAllBanks() {
//		Query query = manager.createQuery("SELECT u FROM Bank u");
//		return query.getResultList();
//	}
//
//	public void fillTables() {
//		String s = "http://www.bt.com.tn/change";
//		@SuppressWarnings("unused")
//		URL url = null;
//
//		try {
//			url = new URL(s);
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		Document doc = null;
//		try {
//			doc = Jsoup.connect(s).userAgent("Mozilla").get();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Element table = doc.select("table").first();
//		Iterator<Element> ite = table.select("tr").iterator();
//		while (ite.hasNext()) {
//			Element element = ite.next();
//			Pattern pattern = Pattern.compile("(-?\\D+)");
//			Matcher matcher = pattern.matcher(element.text());
//			if (matcher.find()) {
//				String text = matcher.group().substring(
//						matcher.group().length() - 4);
//				String numbers = element.text().substring(
//						(matcher.group().length()));
//				// System.out.println(text);
//				// System.out.println(numbers.length());
//				numbers += " ";
//				//System.out.println(text);
//				Labels.add(text);
//
//				if (numbers != "") {
//					Pattern pattern2 = Pattern
//							.compile("((\\d|\\p{Punct})*\\p{Space})");
//					Matcher matcher2 = pattern2.matcher(numbers);
//					int row = 3;
//					while (matcher2.find()) {
//
//						if (row == 3) {
//							try {
//								Unities.add(Integer.parseInt(matcher2.group()
//										.replace(" ", "")));
//							} catch (Exception exception) {
//
//							}
//
//						} else if (row == 2) {
//							try {
//								Buy.add(Float.parseFloat(matcher2.group()));
//							} catch (Exception exception) {
//								exception.printStackTrace();
//							}
//
//						} else if (row == 1) {
//							try {
//								Sell.add(Float.parseFloat(matcher2.group()));
//							} catch (Exception exception) {
//								exception.printStackTrace();
//							}
//						}
//						row--;
//					}
//				}
//			} else {
//				System.out.println("did not find");
//
//			}}
//
//			// System.out.println(element.text());
//			// Pattern pattern =
//			// Pattern.compile("(([A-Z]){3}+(\\p{Space}([0-9]+[A-Z])))");
//			
//			Labels.remove(0);
//			System.out.println(Labels);
//			System.out.println(Unities);
//			System.out.println(Buy);
//			System.out.println(Sell);
//
//			setBanks(findAllBanks());
//			setCurrencies(findAllCurr());
//			
//			for (int x = 0; x < banks.size(); x++) {
//				//System.out.println("first looooooooooop");
//				for (int r = 0; r < Labels.size(); r++) {
//					//System.out.println("second looooooooooop");
//					Bank bank=new Bank();
//					bank=banks.get(x);
//					int i = currencies.size()-1;
//					while (i>0) {
//						
//						
//						
//							Currencybank currencybank = new Currencybank();
//							currencybank.setBank(bank);
//							currencybank.setCurrency(currencies.get(r));
//							currencybank.setBuyPrice(Buy.get(r));
//							currencybank.setSellPrice(Sell.get(r));
//							currencybanks.add(currencybank);
//							
//							
//						
//						i--;
//
//					}
//						bank.setCurrencybanks(currencybanks);
//					try{
//						System.out.println("ena houni");
//						manager.merge(bank);
//					}
//					catch(Exception exception){
//						System.out.println("ena lenna");
//						exception.printStackTrace();
//					}
//				}
//			}
//
//		}
//	@PostConstruct
//	@Schedule(year = "*", dayOfWeek = "*", hour = "*", minute = "*/5", persistent = false)
//	public void init() {
//
//		fillTables();
//	}
//
//	public List<String> getLabels() {
//		return Labels;
//	}
//
//	public void setLabels(List<String> labels) {
//		Labels = labels;
//	}
//
//	public List<Integer> getUnities() {
//		return Unities;
//	}
//
//	public void setUnities(List<Integer> unities) {
//		Unities = unities;
//	}
//
//	public List<Float> getBuy() {
//		return Buy;
//	}
//
//	public void setBuy(List<Float> buy) {
//		Buy = buy;
//	}
//
//	public List<Float> getSell() {
//		return Sell;
//	}
//
//	public void setSell(List<Float> sell) {
//		Sell = sell;
//	}
//
//	public List<Bank> getBanks() {
//		return banks;
//	}
//
//	public void setBanks(List<Bank> banks) {
//		this.banks = banks;
//	}
//
//	public List<Currency> getCurrencies() {
//		return currencies;
//	}
//
//	public void setCurrencies(List<Currency> currencies) {
//		this.currencies = currencies;
//	}
//
//	public List<Currencybank> getCurrencybanks() {
//		return currencybanks;
//	}
//
//	public void setCurrencybanks(List<Currencybank> currencybanks) {
//		this.currencybanks = currencybanks;
//	}
//
//}
