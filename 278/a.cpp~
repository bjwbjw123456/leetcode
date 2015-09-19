#include <iostream>
using namespace std;

bool isBadVersion(int version) {
  if (version >= 1702766719) {
    return true;
  } else {
    return false;
  }
}

int find(int s, int e) {
        if (s==e) {
            return s;
        }
        int half = (e-s)/2 + s;
        cout<<half<<" "<<isBadVersion(half)<<endl;
        if (isBadVersion(half) == true) { //bad
            if (isBadVersion(half-1) == false) {
                return (half);
            } else {
                return find(s, half-1);
            }
        } else { //good
            return find(half+1, e);
        }
}


int firstBadVersion(int n) {
        if (n == 1 || isBadVersion(1) == true){
            return 1; 
        }
        return find(1,n);
}

int main () {
   int v = firstBadVersion(2126753390);
   cout<<v<<endl;
   return 0;
}
