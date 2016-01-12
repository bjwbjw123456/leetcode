public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas==null || gas.length==0) return 0;
        if (gas.length==1) {
            if (gas[0]>=cost[0]) {
                return 0;
            } else {
                return -1;
            }
        } 
        
        
        int[] data = new int[gas.length];
        for(int i=0;i<gas.length;i++) {
            data[i] = gas[i]-cost[i];
        }
        
        int sum = data[0];
        int max = data[0];
        int min = data[0];
        int mnow = data[0];
        int mstart = 0;
        int start = 0;
        int mmin = data[0];
        int minend = 0;
        for (int i=1;i<data.length;i++) {
            sum+=data[i];
            if(mnow<0) {
                mstart = i;
                mnow = data[i];
                if(mnow>max){
                    max = mnow;
                    start = mstart;                    
                }
            } else {
                mnow = mnow+data[i];
                if(mnow>max){
                    max= mnow;
                    start = mstart;
                }
            }
            
            if(mmin>0) {
                mmin = data[i];
            } else {
                mmin = data[i] + mmin;
            }
            
            if (mmin<min) {
                min = mmin;
                minend = i;
            }
        }
        //System.out.println("sum:"+sum+" mstart:"+mstart+" minend:"+minend);
        
        if (sum<0) {
            return -1;
        } else {
            return (max>sum-min)?mstart:(minend+1)%gas.length;
        }
        
    }
}