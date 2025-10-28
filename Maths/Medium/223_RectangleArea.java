package Medium;

public class 223_RectangleArea {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int first = (ax2 - ax1) * (ay2 - ay1);
        int sec = (bx2 - bx1) * (by2 - by1);
        int area = 0;
        int width = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        int height = Math.min(ay2, by2) - Math.max(ay1, by1);
        if(width > 0 && height > 0) {
            area = width * height;
        }
        return first + sec - area;
    }
}
