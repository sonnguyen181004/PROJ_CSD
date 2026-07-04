/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package browser;

/**
 *
 * @author pc
 */
public class WebPage {
    private String url;
    private String title;
    private long visitTime;

    public WebPage(String url, String title) {
        this.url = url;
        this.title = title;
        this.visitTime = System.currentTimeMillis();
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public long getVisitTime() {
        return visitTime;
    }

    public void displayPage() {
        System.out.println("Current Page: " + title + " (" + url + ")");
    }
}