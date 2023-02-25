class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> lowers;
    PriorityQueue<Integer> highers;
    public MedianFinder() {
        lowers = new PriorityQueue<>(Collections.reverseOrder());
        highers = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(lowers.isEmpty() || lowers.peek() > num) {
            lowers.add(num);
        } else {
            highers.add(num);
        }
        rebalance();
    }
    
    public void rebalance() {
        PriorityQueue<Integer> bigger = (lowers.size() > highers.size()) ? lowers : highers;
        PriorityQueue<Integer> smaller = (lowers.size() > highers.size()) ? highers : lowers;
        if(Math.abs(bigger.size() - smaller.size()) > 1) {
            smaller.add(bigger.poll());
        }
    }
    
    public double findMedian() {
        PriorityQueue<Integer> bigger = (lowers.size() > highers.size()) ? lowers : highers;
        PriorityQueue<Integer> smaller = (lowers.size() > highers.size()) ? highers : lowers;
        if(bigger.size() > smaller.size()) return bigger.peek();
        double val = (bigger.peek() + (double)smaller.peek())/2.0;
        return val;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */