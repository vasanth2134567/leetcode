// Last updated: 9/21/2026, 9:31:02 PM
1class NumArray {
2    int[] tree ;
3    int[] nums;
4
5    public void buildTree(int st,int end, int idx, int[] nums){
6        if(st == end){
7            tree[idx] = nums[st];
8            return;
9        }
10        int mid = (st+end)/2;
11        buildTree(st,mid,2*idx+1,nums);
12        buildTree(mid+1,end,2*idx+2,nums);
13
14        tree[idx] = tree[2*idx+1] + tree[2*idx+2];
15    }
16    public NumArray(int[] nums) {
17        this.nums = nums;
18        tree = new int[4*nums.length];
19        buildTree(0,nums.length-1,0,nums);
20    }
21    
22    public int query(int qi,int qj,int si,int sj,int idx){
23        if(qj < si || qi > sj){
24            return 0;
25        } else if(si >= qi && sj <=qj){
26            return tree[idx];
27        }else{
28            int mid = (si+sj)/2;
29            return query(qi,qj,si,mid,2*idx+1) + query(qi,qj,mid+1,sj,2*idx+2);
30        }
31
32    }
33    public int sumRange(int left, int right) {
34        return query(left,right,0,this.nums.length-1,0);    
35    }
36
37    public void updateUtil(int i,int val,int st,int end,int idx){
38        if(st == end){
39            if(i == st) tree[idx] = val;
40            return;
41        }
42
43        int mid = (st+end)/2;
44        if(i <= mid){
45            updateUtil(i,val,st,mid,2*idx+1);
46            tree[idx] = tree[2*idx+1] + tree[2*idx+2];
47            
48        }else{
49            updateUtil(i,val,mid+1,end,2*idx+2);
50            tree[idx] = tree[2*idx+1] + tree[2*idx+2];
51        }
52    }
53    
54    public void update(int index, int val) {
55        nums[index] = val;
56        updateUtil(index,val,0,nums.length-1,0);
57    }
58}
59
60
61/**
62 * Your NumArray object will be instantiated and called as such:
63 * NumArray obj = new NumArray(nums);
64 * obj.update(index,val);
65 * int param_2 = obj.sumRange(left,right);
66 */