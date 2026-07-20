// Last updated: 7/20/2026, 8:11:26 PM
1class Solution {
2    public List<List<Integer>> permute(int[] letters) {
3        List<List<Integer>> res = new ArrayList<>();
4        dfs(new ArrayList<>(), new boolean[letters.length], res, letters);
5        return res;
6    }
7
8    private static void dfs(List<Integer> path, boolean[] used, List<List<Integer>> res, int[] letters) {
9        if (path.size() == used.length) {
10            // make a deep copy since otherwise we'd be append the same list over and over
11            res.add(new ArrayList<Integer>(path));
12            return;
13        }
14
15        for (int i = 0; i < used.length; i++) {
16            // skip used letters
17            if (used[i]) continue;
18            // add letter to permutation, mark letter as used
19            path.add(letters[i]);
20            used[i] = true;
21            dfs(path, used, res, letters);
22            // remove letter from permutation, mark letter as unused
23            path.remove(path.size() - 1);
24            used[i] = false;
25        }
26    }    
27}