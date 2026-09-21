// Last updated: 9/21/2026, 9:28:23 PM
1class MedianFinder {
2    // max queue is always larger or equal to min queue
3    PriorityQueue<Integer> min = new PriorityQueue();
4    PriorityQueue<Integer> max = new PriorityQueue(1000, Collections.reverseOrder());
5    // Adds a number into the data structure.
6    public void addNum(int num) {
7        max.offer(num);
8        min.offer(max.poll());
9        if (max.size() < min.size()){
10            max.offer(min.poll());
11        }
12    }
13
14    // Returns the median of current data stream
15    public double findMedian() {
16        if (max.size() == min.size()) return (max.peek() + min.peek()) /  2.0;
17        else return max.peek();
18    }
19};