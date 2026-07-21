class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int totalElements = m * n;
        int[][] result = new int[m][n];
        
        k = k % totalElements;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int original1DIndex = i * n + j;
                int new1DIndex = (original1DIndex + k) % totalElements;
                
                int newRow = new1DIndex / n;
                int newCol = new1DIndex % n;
                
                result[newRow][newCol] = grid[i][j];
            }
        }
        
        List<List<Integer>> output = new ArrayList<>();
        for (int[] row : result) {
            List<Integer> listRow = new ArrayList<>();
            for (int val : row) {
                listRow.add(val);
            }
            output.add(listRow);
        }
        
        return output;
    }
}
