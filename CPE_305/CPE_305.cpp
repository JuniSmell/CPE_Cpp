/************************************
**   CPE:305 Joseph's problem      **
**   ��X���j���Y�A�M��N���G      **
**   �������C                    ** 
************************************/ 
#include<iostream>
#include<vector>
using namespace std;

bool whoDead(int murde, int kind){
	int dead=0;
	for(int i=0;i<kind;i++){
		dead=(dead+murde-1)%(2*kind-i);//��i�������H����m�Ai�q0�}�l�� 
		if(dead<kind){
			return 0;
		}
	}
	return 1;
}

int main(){
	int solve[14];
	for(int i=1;i<14;i++){//�n�H�ƶq 
		for(int j=i;;j++){//���H�����Ʀ�m 
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
