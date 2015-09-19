#include<iostream>
#include <string>
#include <sstream>
using namespace std;

#include <stdlib.h>
#include <stdio.h>

int fo (string s) {
	int index = s.find_first_of("+-",1);
        if (s[index] == '+') {
            return atoi(s.substr(0,index-0).c_str())+atoi(s.substr(index+1,s.length()-index-1).c_str());
        }
        if (s[index] == '-') {
            return atoi(s.substr(0,index-0).c_str())-atoi(s.substr(index+1,s.length()-index-1).c_str());
        }
        
    }
    
    int foo(string s) {
        int index1 = s.find_first_of("+-",1);
        if (index1 == string::npos) {
            return atoi(s.c_str());
        }
        int index2 = s.find_first_of("+-",index1+2);
        if (index2 == string::npos) {
            return fo(s);
        }
        //cout<<"index1:"<<index1<<endl<<"index2:"<<index2<<endl;
        stringstream ss;
        ss<<fo(s.substr(0,index2));
        string temp = ss.str();
	//cout<<temp<<endl;
	s.replace(0,index2,temp);
        //cout<<s<<endl;
        
        return foo(s);
    }
    
    int fuct(string s) {
        if (s.length() == 1) {
            return atoi(s.c_str());
        }
        int i1 = s.find_last_of("(");
        if (i1 == string::npos) {
            return foo(s);
        }
        int i2 = s.find_first_of(")",i1);
        stringstream ss;
        ss<<foo(s.substr(i1+1,i2-i1-1));
        string temp = ss.str();
s.replace(i1,i2-i1+1,temp);
cout<<s<<endl;
        return fuct(s);
    }

    int main() {
        cout<<fuct("2-(5-6)")<<endl;
	return 0;
        
        
    }
