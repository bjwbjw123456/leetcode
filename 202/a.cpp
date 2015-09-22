#include <iostream>
using namespace std;

int foo (int n) {
        int sum = 0;
        int r;
        while (true) {
            if (n < 10) {
                sum += n*n;
                break;
            }
            r = n%10;
            n = n/10;
            sum += r*r;
        }
        return sum;
    }


int main(){
	int t = 7;
	while(true) {
		t = foo(t);
		cout<<t<<endl;
		if (t == 1) {
			break;			
		}
	}
	return 0;
}
