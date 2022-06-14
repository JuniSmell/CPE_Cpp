#include<iostream>
#include<string>
#include<vector>
using namespace std;

void pda(int);

int main(){
	int casenum;
	int n;
	vector<int>ns;
	
	cin>>casenum;
	for(int i=0;i<casenum;i++){
		cin>>n;
		ns.push_back(n);
	}
	for(int i=0;i<ns.size();i++){
		pda(ns[i]);
	}
	system("pause");
	return 0;
}

void pda(int n){
	int sum=0;
	for(int i=1;i<n;i++){
		if(n%i==0){
			sum+=i;
		}
	}
	if(sum<n){
		cout<<"deficient\n";
	}else if(sum==n){
		cout<<"perfect\n";
	}else{
		cout<<"abundunt\n";
	}
}
