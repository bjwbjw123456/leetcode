#include <iostream>
#include <vector>
using namespace std;

#include<stdlib.h>

    int foo(vector<int>& nums,int* data){
        int n = nums.size();
	cout<<"nums:"<<n<<endl;
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return nums[0];
        }
        if (n = 2) {
            return (nums[0]>nums[1])?nums[0]:nums[1];
        }
        if (data[n]>0) {
            return data[n];
        }
        vector<int> a =nums;
        a.pop_back();
        vector<int> b = a;
        b.pop_back();
cout<< "a:" << a.size()<<endl;
cout<< "b:" << b.size()<<endl;
        
        int r = max(nums[n-1]+foo(b,data),foo(a,data));
        data[n] = r;
        return r;
        
    }

    int rob(vector<int>& nums) {
        int s = nums.size();
        int* data = (int*)malloc((s+2)*sizeof(int));
        for (int i = 0;i<s+2;i++) {
            data[i] = -1;
        }
        int r = foo(nums,data);
        free(data);
        return r;
        
        
    }

int main(){
	vector<int> t;
	t.push_back(1);
	t.push_back(1);
	t.push_back(1);
	cout<<rob(t)<<endl;
	return 0;
}
