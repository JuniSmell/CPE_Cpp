#include<iostream>
#include<string>
#include<vector>
using namespace std;
int main(){
	string dividend;	//砆埃计 
	int temp;
	int caseNum;		//case矪瞶Ω计 
	int divisor;		//埃计 
	int numSet;			//栋ず计秖 
	int remainder;		//緇计 
	bool wonderful;		//琌俱埃 
	vector<string>dividends;
	vector<bool>ans;
	cin>>caseNum;
	while(caseNum--){
		wonderful=1;
		cin>>dividend;
		dividends.push_back(dividend);
		cin>>numSet;
		for(int i=0;i<numSet;i++){
			cin>>divisor;
			remainder=0;
			for(int j=0;j<dividend.length();j++){
				remainder*=10;
				temp=dividend[j]-48;
				remainder+=temp;
				remainder%=divisor;
			}
			if(remainder!=0){
				wonderful=0;
			}
		}
		ans.push_back(wonderful);
	}	
	for(int i=0;i<ans.size();i++){
		if(ans[i]){
			cout<<dividends[i]<<" - Wonderful.\n";
		}else{
			cout<<dividends[i]<<" - Simple.\n";
		}
	}
	system("pause");
	return 0;
} 
