#include<iostream>
#include<vector>
using namespace std;

bool whoDead(int,int);

int main(){
	int solve[14];				//製作表格，到時候查表用的。 
	for(int i=1;i<14;i++){		//好人數量。 
		for(int j=i;;j++){		//殺人的報數位置。 
			if(whoDead(j,i)){	//如果找到成功的， 
				solve[i]=j;		//就記錄下來，
				break;			//結束這個迴圈。 
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

bool whoDead(int murde, int kind){
	int dead=0;
	for(int i=0;i<kind;i++){
		dead=(dead+murde-1)%(2*kind-i);//第i次死的人的位置，i從0開始數 
		if(dead<kind){	//如果有死人的位置在kind以前，也就是好人死了。 
			return 0;	//回傳失敗。 
		}
	}
	return 1;
}
