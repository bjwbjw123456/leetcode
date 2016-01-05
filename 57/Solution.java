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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals.size()==0) {
            intervals.add(newInterval);
            return intervals;
        }
        
        List<Interval> r = new ArrayList<Interval>();
        
        int i=0;
        for(;i<intervals.size();i++){
            Interval tmp = intervals.get(i);
            if (tmp.end<newInterval.start) {
                r.add(tmp);
                continue;
            }else {
                break;
            }
        }
        
        if(i==intervals.size()){
            r.add(newInterval);
            return r;
        }
        
        if(intervals.get(i).start>newInterval.end){
            r.add(newInterval);
            for(int j=i;j<intervals.size();j++) {
                r.add(intervals.get(j));
            }
            return r;
        }
        
        int curstart = Math.min(newInterval.start,intervals.get(i).start);
        int curend = Math.max(newInterval.end,intervals.get(i).end);
        for(i=i+1;i<intervals.size();i++) {
            Interval tmp = intervals.get(i);
            if (tmp.start>curend) {
                r.add(new Interval(curstart,curend));
                curstart = tmp.start;
                curend = tmp.end;
            } else {
                curend = Math.max(tmp.end,curend);
            }
        }
        r.add(new Interval(curstart,curend));
        return r;
    }
}