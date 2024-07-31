
public class Test {
	public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp1 = new MobileApp("App1");
        Observer mobileApp2 = new MobileApp("App2");
        Observer webApp1 = new WebApp("Web1");

        stockMarket.registerObserver(mobileApp1);
        stockMarket.registerObserver(mobileApp2);
        stockMarket.registerObserver(webApp1);

        System.out.println("Setting stock price to 500.00");
        stockMarket.setStockPrice(500.00);

        System.out.println("\nDeregistering MobileApp2");
        stockMarket.deregisterObserver(mobileApp2);

        System.out.println("Setting stock price to 200.00");
        stockMarket.setStockPrice(200.00);
    }
}
