// Last updated: 9/21/2026, 9:06:04 PM
1class Solution {
2    Map<Node, Node> map;
3
4    public void dfs(Node node, Node cloneNode, Map<Node, Node> map) {
5        for (Node neighbor : node.neighbors) {
6
7            // If neighbor is not cloned yet
8            if (!map.containsKey(neighbor)) {
9                Node cloneNeighbor = new Node(neighbor.val);
10                map.put(neighbor, cloneNeighbor);
11
12                cloneNode.neighbors.add(cloneNeighbor);
13                dfs(neighbor, cloneNeighbor, map);
14            } 
15            // If already cloned, reuse it
16            else {
17                cloneNode.neighbors.add(map.get(neighbor));
18            }
19        }
20    }
21
22    public Node cloneGraph(Node node) {
23        if (node == null) return null;
24
25        map = new HashMap<>();
26
27        Node cloneNode = new Node(node.val);
28        map.put(node, cloneNode);
29
30        dfs(node, cloneNode, map);
31        return cloneNode;
32    }
33}