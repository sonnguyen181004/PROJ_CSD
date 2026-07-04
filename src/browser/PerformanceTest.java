package browser;

public class PerformanceTest {
    public static void runTest() {
        int[] sizes = {100, 500, 1000, 2000, 5000};
        int iterations = 5;

        System.out.println("\n=====================================================================");
        System.out.println("            PERFORMANCE EXPERIMENT RESULTS (in Nanoseconds)          ");
        System.out.println("=====================================================================");
        System.out.printf("%-12s | %-25s | %-25s\n", "Input Size", "Two-Stack Model (O(1))", "Single-List Model");
        System.out.println("---------------------------------------------------------------------");

        for (int size : sizes) {
            long totalTwoStackTime = 0;
            long totalSingleListTime = 0;

            for (int iter = 0; iter < iterations; iter++) {
                Browser twoStackBrowser = new Browser();
                SingleListBrowser singleListBrowser = new SingleListBrowser();

                // Sinh tập dữ liệu URL giả lập
                String[] urls = new String[size];
                for (int i = 0; i < size; i++) {
                    urls[i] = "https://fpt-edu-simulation-" + i + ".com";
                }

                // 1. Kiểm thử mô hình Hai Stack (Mô hình chính)
                long startStack = System.nanoTime();
                for (int i = 0; i < size; i++) {
                    twoStackBrowser.visitPage(urls[i], "Page " + i);
                }
                for (int i = 0; i < size / 2; i++) {
                    twoStackBrowser.goBack();
                }
                for (int i = 0; i < size / 4; i++) {
                    twoStackBrowser.goForward();
                }
                long endStack = System.nanoTime();
                totalTwoStackTime += (endStack - startStack);

                // 2. Kiểm thử mô hình Danh sách duy nhất (Mô hình đối chứng)
                long startList = System.nanoTime();
                for (int i = 0; i < size; i++) {
                    singleListBrowser.visitPage(urls[i], "Page " + i);
                }
                for (int i = 0; i < size / 2; i++) {
                    singleListBrowser.goBack();
                }
                for (int i = 0; i < size / 4; i++) {
                    singleListBrowser.goForward();
                }
                long endList = System.nanoTime();
                totalSingleListTime += (endList - startList);
            }

            // Tính thời gian trung bình (Average Runtime)
            long avgStack = totalTwoStackTime / iterations;
            long avgList = totalSingleListTime / iterations;

            System.out.printf("%-12d | %-25d | %-25d\n", size, avgStack, avgList);
        }
        System.out.println("=====================================================================\n");
    }
}
