// Last updated: 7/20/2026, 8:06:56 PM
1class Solution {
2    public List<Integer> findSubstring(String s, String[] words) {
3        List<Integer> ans = new ArrayList<>();
4
5        if (words.length == 0 || s.length() == 0) {
6            return ans;
7        }
8
9        int wordSize = words[0].length();
10        int wordCount = words.length;
11        int N = s.length();
12
13        HashMap<String,Integer> originalCount = new HashMap<>();
14        for(int i = 0; i<words.length; i++){
15            originalCount.put(words[i], originalCount.getOrDefault(words[i],0)+1);
16        }
17
18        for(int offset = 0; offset<wordSize; offset++){
19            HashMap<String,Integer> currentCount = new HashMap<>();
20            int start = offset;
21            int count = 0;
22            for(int end = offset; end + wordSize <= N; end += wordSize){
23                String currWord = s.substring(end, end + wordSize);
24                if(originalCount.containsKey(currWord)){
25                    currentCount.put(currWord, currentCount.getOrDefault(currWord,0)+1);
26                    count++;
27
28                    while(currentCount.get(currWord)>originalCount.get(currWord)){
29                        String startWord = s.substring(start,start+wordSize);
30                        currentCount.put(startWord, currentCount.get(startWord)-1);
31                        start+=wordSize;
32                        count--;                        
33                    }
34
35                    if(count == wordCount){
36                        ans.add(start);
37                    }
38                    
39                }
40                else{
41                    count = 0;
42                    start = end + wordSize;
43                    currentCount.clear();
44                }
45            }
46
47        }
48        return ans;
49    }
50}