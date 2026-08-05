class MedianFinder {

    private List<Integer> list;
    public MedianFinder() {
        list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        list.add(num);
        Collections.sort(list);
    }
    
    public double findMedian() {
        int len = list.size();
        if(len%2!=0){
            return (double)list.get(len/2);
        }else{
            return ((double)list.get(len/2) + (double)list.get(len/2-1))/2;
        }
    }
}
