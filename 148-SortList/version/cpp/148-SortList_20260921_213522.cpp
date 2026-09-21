// Last updated: 9/21/2026, 9:35:22 PM
1class Solution {
2public:
3    vector<int> findMinHeightTrees(int n, vector<vector<int>>& edges) {
4        if(n==0)
5            return {};
6        if(n==1)
7            return {0};
8        vector<int>res;
9        vector<int>degrees(n,0);
10        vector<vector<int>>adj(n);
11        for(int i=0;i<edges.size();i++)
12        {
13            adj[edges[i][0]].push_back(edges[i][1]);//creating adjacent list
14            adj[edges[i][1]].push_back(edges[i][0]);
15            degrees[edges[i][1]]++;//updating how many edges each node has
16            degrees[edges[i][0]]++;
17        }
18        queue<int>queue;
19        for(int i=0;i<n;i++)
20        {
21            if(degrees[i]==1)//adding all the leave nodes
22                queue.push(i);
23        }
24        while(!queue.empty())
25        {
26            res.clear();// clear vector before we start traversing level by level.
27            int size=queue.size();
28            for(int i=0;i<size;i++)
29            {
30                int cur=queue.front();
31                queue.pop();
32                res.push_back(cur);//adding nodes to vector.Goal is to get a vector of  just 1 or 2 nodes available.
33                for(auto &neighbor:adj[cur])
34                {
35                    degrees[neighbor]--;//removing current leave nodes
36                    if(degrees[neighbor]==1)//adding current leave nodes
37                        queue.push(neighbor);
38                }
39            }
40        }
41        return res;
42    }
43};
44
45