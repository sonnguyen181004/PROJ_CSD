package browser;

import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Browser browser = new Browser();

        int choice;

        do {
            System.out.println("\n======================================");
            System.out.println(" Browser History & Cache Simulator");
            System.out.println("======================================");
            System.out.println("1. Visit Webpage");
            System.out.println("2. Go Back");
            System.out.println("3. Go Forward");
            System.out.println("4. View History");
            System.out.println("5. Check Cache");
            System.out.println("6. View Cache");
            System.out.println("7. Clear History");
            System.out.println("8. Clear Cache");
            System.out.println("9. Run Performance Test"); 
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter URL: ");
                    String url = sc.nextLine();

                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    WebPage page = browser.visitPage(url, title);
                    System.out.println("\nSuccessfully visited!");
                    break;

                case 2:
                    WebPage backPage = browser.goBack();
                    if (backPage != null) {
                        backPage.displayPage();
                    }
                    break;

                case 3:
                    WebPage forwardPage = browser.goForward();
                    if (forwardPage != null) {
                        forwardPage.displayPage();
                    }
                    break;

                case 4:
                    HistoryManager.printHistory();
                    break;

                case 5:
                    System.out.print("Enter URL to check: ");
                    String checkUrl = sc.nextLine();
                    
                    WebPage cachePage = browser.checkCache(checkUrl);

                    if (cachePage != null) {
                        System.out.println("Found in Cache");
                        System.out.println("---------------------");
                        System.out.println("Title : " + cachePage.getTitle());
                        System.out.println("URL   : " + cachePage.getUrl());
                    } else {
                        System.out.println("Not found in Cache.");
                    }
                    break;

                case 6:
                    if (CacheManager.getCache().isEmpty()) {
                        System.out.println("Cache is empty.");
                    } else {
                        System.out.println("\n========= CACHE =========");
                        for (Map.Entry<String, WebPage> entry : CacheManager.getCache().entrySet()) {
                            System.out.println(entry.getValue().getTitle()
                                    + " (" + entry.getKey() + ")");
                        }
                    }
                    break;

                case 7:
                    HistoryManager.clearHistory();
                    System.out.println("History cleared.");
                    break;

                case 8:
                    CacheManager.clearCache();
                    System.out.println("Cache cleared.");
                    break;

                case 9: 
                    System.out.println(">>> Đang chạy thực nghiệm đo lường hiệu năng trên RAM...");
                    PerformanceTest.runTest();
                    break;

                case 0:
                    System.out.println("Thank you for using Browser Simulator.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        sc.close();
    }
}