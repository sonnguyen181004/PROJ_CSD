package browser;

import java.util.ArrayList;
import java.util.List;

public class SingleListBrowser {
    private List<WebPage> pages = new ArrayList<>();
    private int currentIndex = -1;

    public WebPage visitPage(String url, String title) {
        // Cơ chế duyệt: Xóa sạch các trang phía trước currentIndex (Forward cũ bị hủy)
        while (pages.size() > currentIndex + 1) {
            pages.remove(pages.size() - 1);
        }
        WebPage newPage = new WebPage(url, title);
        pages.add(newPage);
        currentIndex++;
        return newPage;
    }

    public WebPage goBack() {
        if (currentIndex <= 0) {
            return null;
        }
        currentIndex--;
        return pages.get(currentIndex);
    }

    public WebPage goForward() {
        if (currentIndex >= pages.size() - 1) {
            return null;
        }
        currentIndex++;
        return pages.get(currentIndex);
    }
}
