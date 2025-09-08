package Java_Graphs.ShortestPathAlgorithm;

public class FloydWarshallAlgo {
    public void shortestDistance(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j || matrix[j][i] == -1) {
                    continue;
                }
                for(int k = 0; k < m; k++) {
                    if(i == k || k == j || matrix[i][k] == -1) {
                        continue;
                    }
                    if(matrix[j][k] == -1)
                        matrix[j][k] = matrix[j][i] + matrix[i][k];
                    else 
                        matrix[j][k] = Math.min(matrix[j][k], matrix[j][i] + matrix[i][k]);
                }
            }
        }
    }
}

// Time Complexity:The time complexity is O(n^3) due to the three nested loops, where n is the dimension of the square matrix.
// Space Complexity:The space complexity is O(1) as the algorithm operates in-place without using additional data structures that scale with the input size.