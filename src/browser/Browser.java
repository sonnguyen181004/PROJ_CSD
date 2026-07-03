/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package browser;

/**
 *
 * @author pc
 */
import java.util.Stack;

public class Browser {
    private WebPage currentPage = null;
    private Stack<WebPage> backStack = new Stack<>();
    private Stack<WebPage> forwardStack = new Stack<>();

    public WebPage visitPage(String url, String title) {
        // Nếu đang có trang hiện tại, đẩy nó vào Back Stack
        if (currentPage != null) {
            backStack.push(currentPage);
        }
        
        // Tạo trang mới và đặt làm trang hiện tại
        WebPage newPage = new WebPage(url, title);
        currentPage = newPage;
        
        // Xóa sạch Forward Stack khi có hướng đi mới
        forwardStack.clear();
        
        // Chuyển giao dữ liệu cho các class xử lý
        HistoryManager.addPage(currentPage);
        CacheManager.addCache(currentPage);
        
        return currentPage;
    }

    public WebPage goBack() {
        if (backStack.isEmpty()) {
            System.out.println("No previous page available");
            return null;
        }
        // Đẩy trang hiện tại sang Forward Stack và lấy trang cuối từ Back Stack ra
        forwardStack.push(currentPage);
        currentPage = backStack.pop();
        return currentPage;
    }

    public WebPage goForward() {
        if (forwardStack.isEmpty()) {
            System.out.println("No next page available");
            return null;
        }
        // Đẩy trang hiện tại về lại Back Stack và lấy trang từ Forward Stack ra
        backStack.push(currentPage);
        currentPage = forwardStack.pop();
        return currentPage;
    }

    public WebPage checkCache(String url) {
        // Kiểm tra nhanh với HashMap 
        if (CacheManager.contains(url)) {
            return CacheManager.getCachePage(url);
        }
        return null;
    }
}
