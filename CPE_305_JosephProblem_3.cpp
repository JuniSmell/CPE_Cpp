/************************************
**   CPE:305 Joseph's problem      **
**   找出遞迴關係，然後將結果      **
**   做成表格。                    ** 
************************************/ 
#include<iostream>
#include<vector>
using namespace std;

bool whoDead(int murde, int kind){
	int dead=0;
	for(int i=0;i<kind;i++){
		dead=(dead+murde-1)%(2*kind-i);//第i次死的人的位置，i從0開始數 
		if(dead<kind){
			return 0;
		}
	}
	return 1;
}

int main(){
	int solve[14];
	for(int i=1;i<14;i++){//好人數量 
		for(int j=i;;j++){//殺人的報數位置 
			if(whoDead(j,i)){
				solve[i]=j;
				break;
			}
		}
	}
	int k;
	vector<int> ans;
	while(1){
		cin>>k;
		if(k==0){
			for(int it=0;it<ans.size();it++){
				cout<<ans[it]<<endl;
			}
			break;
		}
		ans.push_back(solve[k]);	
	}
	system("pause");
	return 0;
}
