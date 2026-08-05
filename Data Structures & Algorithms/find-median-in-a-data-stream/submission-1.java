class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        minHeap = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty()){
            maxHeap.add(num);
            return;
        }
        if(maxHeap.peek() < num){
            minHeap.add(num);
        }else{
            maxHeap.add(num);
        }

        if(maxHeap.size() - minHeap.size() > 1){
            minHeap.add(maxHeap.poll());
        }else if(minHeap.size() - maxHeap.size() > 0){
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(maxHeap.size() > minHeap.size()){
            return (double)maxHeap.peek();
        }else{
            return ((double)maxHeap.peek() + (double)minHeap.peek())/2;
        }
    }
}
