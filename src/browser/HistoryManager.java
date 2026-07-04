package browser;

import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HistoryManager {
    private static final List<WebPage> history = new ArrayList<>();
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void addPage(WebPage page) {
        if (page != null) {
            history.add(page);
        }
    }

    public static void printHistory() {
        if (history.isEmpty()) {
            System.out.println("History is empty.");
            return;
        }
        System.out.println("\n=== Full Browsing History (Chronological Order) ===");
        for (int i = 0; i < history.size(); i++) {
            WebPage page = history.get(i);
            String formattedTime = dateFormat.format(new Date(page.getVisitTime()));
            System.out.printf("%d. %s (%s) - Visited at: %s\n", (i + 1), page.getTitle(), page.getUrl(), formattedTime);
        }
        System.out.println("===================================================\n");
    }

    public static List<WebPage> getHistory() {
        return history;
    }

    public static void clearHistory() {
        history.clear();
    }
}
