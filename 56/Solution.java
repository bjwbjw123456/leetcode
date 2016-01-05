/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size()<=1) return intervals;
        Collections.sort(intervals, new Comparator(){
            @Override
            public int compare(Object o1, Object o2){
                Interval i1= (Interval)o1;
                Interval i2= (Interval)o2;
                return i1.start - i2.start;
            }
        });
        
        List<Interval> r = new ArrayList<Interval>();
        
        int curstart = intervals.get(0).start;
        int curend = intervals.get(0).end;
        
        //r.add(intervals.get(0));
        //boolean insert = false;
        
        for(int i=0;i<intervals.size();i++) {
            Interval tmp = intervals.get(i);
            if(tmp.start>curend) {
                r.add(new Interval(curstart,curend));
                curstart = tmp.start;
                curend = tmp.end;
            } else if(tmp.end>curend) {
                curend = tmp.end;
            }
        }
        
        r.add(new Interval(curstart,curend));
        
        return r;
    }
}