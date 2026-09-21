// Last updated: 9/21/2026, 9:01:08 PM
1class Solution {
2    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
3        Set<String> set = new HashSet<>(wordList);
4        if(!set.contains(endWord)) return 0;
5        
6        Queue<String> queue = new LinkedList<>();
7        queue.add(beginWord);
8        
9        Set<String> visited = new HashSet<>();
10        queue.add(beginWord);
11        
12        int changes = 1;
13        
14        while(!queue.isEmpty()){
15            int size = queue.size();
16            for(int i = 0; i < size; i++){
17                String word = queue.poll();
18                if(word.equals(endWord)) return changes;
19                
20                for(int j = 0; j < word.length(); j++){
21                    for(int k = 'a'; k <= 'z'; k++){
22                        char arr[] = word.toCharArray();
23                        arr[j] = (char) k;
24                        
25                        String str = new String(arr);
26                        if(set.contains(str) && !visited.contains(str)){
27                            queue.add(str);
28                            visited.add(str);
29                        }
30                    }
31                }
32            }
33            ++changes;
34        }
35        return 0;
36    }
37}