
import browser.Browser;
import browser.CacheManager;
import browser.HistoryManager;
import browser.WebPage;

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

                    System.out.println("\nCurrent Page");
                    System.out.println("---------------------");
                    System.out.println("Title : " + page.getTitle());
                    System.out.println("URL   : " + page.getUrl());

                    break;

                case 2:

                    WebPage back = browser.goBack();

                    if (back != null) {
                        System.out.println("\nCurrent Page");
                        System.out.println("---------------------");
                        System.out.println("Title : " + back.getTitle());
                        System.out.println("URL   : " + back.getUrl());
                    }

                    break;

                case 3:

                    WebPage forward = browser.goForward();

                    if (forward != null) {
                        System.out.println("\nCurrent Page");
                        System.out.println("---------------------");
                        System.out.println("Title : " + forward.getTitle());
                        System.out.println("URL   : " + forward.getUrl());
                    }

                    break;

                case 4:

                    HistoryManager.printHistory();

                    break;

                case 5:

                    System.out.print("Enter URL to search in cache: ");
                    String search = sc.nextLine();

                    WebPage cachePage = browser.checkCache(search);

                    if (cachePage == null) {

                        System.out.println("Page not found in cache.");

                    } else {

                        System.out.println("\nFound in Cache");
                        System.out.println("---------------------");
                        System.out.println("Title : " + cachePage.getTitle());
                        System.out.println("URL   : " + cachePage.getUrl());

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
                   
                    System.out.println("Đang chạy thực nghiệm đo lường hiệu năng...");
                  
                    browser.PerformanceTest.runTest();
                   
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
