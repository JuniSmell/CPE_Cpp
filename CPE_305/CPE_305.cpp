#include<iostream>
#include<vector>
using namespace std;

bool whoDead(int,int);

int main(){
	int solve[14];				//�s�@���A��ɭԬd��Ϊ��C 
	for(int i=1;i<14;i++){		//�n�H�ƶq�C 
		for(int j=i;;j++){		//���H�����Ʀ�m�C 
			if(whoDead(j,i)){	//�p�G��즨�\���A 
				solve[i]=j;		//�N�O���U�ӡA
				break;			//�����o�Ӱj��C 
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
		dead=(dead+murde-1)%(2*kind-i);//��i�������H����m�Ai�q0�}�l�� 
		if(dead<kind){	//�p�G�����H����m�bkind�H�e�A�]�N�O�n�H���F�C 
			return 0;	//�^�ǥ��ѡC 
		}
	}
	return 1;
}
