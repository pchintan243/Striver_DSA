package Daily_Problem.2025.09;

public class 04_3516_FindClosetPerson {
    public int findClosest(int x, int y, int z) {
        int stepA = Math.abs(x - z);
        int stepB = Math.abs(y - z);

        if(stepA == stepB) {
            return 0;
        } else if(stepA < stepB) {
            return 1;
        } else {
            return 2;
        }
        
    }
}