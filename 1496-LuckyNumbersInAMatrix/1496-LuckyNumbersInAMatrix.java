// Last updated: 7/17/2026, 2:56:13 PM
class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> minRow = new ArrayList<>();
        List<Integer> maxCol = new ArrayList<>();
        for(int a=0;a<m;a++) {
            int min = Integer.MAX_VALUE;
            for(int b = 0;b<n;b++) {
                min=Math.min(min,matrix[a][b]);
            }
            minRow.add(min);
        }
        for(int c=0;c<n;c++) {
            int max = Integer.MIN_VALUE;
            for(int d = 0;d<m;d++) {
                max = Math.max(matrix[d][c],max);
            }
            maxCol.add(max);
        }
        List<Integer> R = new ArrayList<>();
        for(int e = 0; e<m;e++) {
            for(int f=0;f<n;f++)
                {
                    if(matrix[e][f] == minRow.get(e) && matrix[e][f]==maxCol.get(f)){
                        R.add(matrix[e][f]);
                    }
                }
        }
        return R;
    }
}