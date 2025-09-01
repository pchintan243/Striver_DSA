package Daily_Problem.2025.09;

public class 01_1792_MaxAvgPassRatio {
    public double maxAverageRatio(int[][] classes, int k) {
        int n = classes.length;
        double sum = 0.0;
        
        // PriorityQueue to store elements in descending order of their increase in ratio
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        
        for (int[] classInfo : classes) {
            int p = classInfo[0];
            int q = classInfo[1];
            sum += (double) p / q;
            double increase = (double) (q - p) / (q * (q + 1.0));
            pq.offer(new double[]{increase, p, q});
        }
        
        for (int i = 0; i < k; i++) {
            if (pq.isEmpty()) {
                break;
            }
            
            double[] top = pq.poll();
            double currentIncrease = top[0];
            int p = (int) top[1];
            int q = (int) top[2];
            
            if (currentIncrease == 0) {
                break;
            }
            
            // Add the best increase to the total sum
            sum += currentIncrease;
            
            // Calculate the next potential increase
            double nextIncrease = (double) (q - p) / ((q + 1.0) * (q + 2.0));
            
            // Offer the updated class info back to the priority queue
            pq.offer(new double[]{nextIncrease, p + 1, q + 1});
        }
        
        return sum / n;
    }
}