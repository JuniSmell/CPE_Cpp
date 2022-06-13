#include<iostream>
#include<string>
#include<vector>
using namespace std;
int main(){
	int x;
	int ans;
	string s;
	string temp;
	vector<int> as;
	vector<int> totalAns;	
	while(cin>>x){
		getline(cin,s);
		getline(cin,s);	
		ans=0;
		for(int i=0;i<s.length();i++){
			if(s[i]!=' '){
				temp=temp+s[i];
			}else{
				as.push_back(stoi(s));
				temp="";
			}
		}
		int n=as.size();
		ans=as[0]*n;
		for(int i=1;i<n;i++){
			ans=ans*x+as[i]*(n-i);
		}
		for(int i=0;i<n;i++){
			as.pop_back();
		}
		totalAns.push_back(ans);
	}
	for(int i=0;i<totalAns.size();i++){
		cout<<totalAns[i]<<endl;
	}	
	system("pause");
	return 0;
}
