// Last updated: 9/21/2026, 8:58:23 PM
1class Solution {
2    public List<Integer> getRow(int rowIndex) {
3        List<Integer> row = new ArrayList<>();
4        row.add(1);
5
6        for (int i = 0; i < rowIndex; i++) {
7            List<Integer> newRow = new ArrayList<>();
8            newRow.add(1);
9            for (int j = 1; j < row.size(); j++) {
10                newRow.add(row.get(j - 1) + row.get(j));
11            }
12            newRow.add(1);
13            row = newRow;
14        }
15
16        return row;        
17    }
18}