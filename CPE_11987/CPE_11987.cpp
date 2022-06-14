#include<iostream>
#include<vector>

using namespace std;

int place[100000];
vector<int>sets[100000];

void initialize(int);
void Union(int,int);
void Move(int,int);
void Print(int);

int main(){
	int n,m,command;
	int x,y;
	while(1){
		cin>>n,m;
		initialize(n);
		while(m--){
			cin>>command>>x;
			switch(command){
				case 1:
					cin>>y;
					Union(x,y);
					break;
				case 2:
					cin>>y;
					Move(x,y);
					break;
				case 3:
					Print(x);
					break;
			}
		}
	}
	system("pause");
	return 0;
} 

void initialize(int n){
	for(int i=1;i<=n;i++){
		place[i]=i;
		sets[i].clear();
		sets[i].push_back(i);
	}
}

void Union(int x,int y){
	int temp;
	x=place[x];
	y=place[y];
	if(x==y){
		return;
	}
	if(sets[x].size()>=sets[y].size()){
		for(int i=0;i<sets[y].size();i++){
			temp=sets[y][i];
			sets[x].push_back(temp);
			place[temp]=x;
		}
		sets[y].clear();
	}else{
		for(int i=0;i<sets[x].size();i++){
			temp=sets[x][i];
			sets[y].push_back(temp);
			place[temp]=y;
		}
		sets[x].clear();
	}
}
void Move(int x,int y){
	vector<int>::iterator temp;
	if(place[x]==place[y]){
		return;
	}
	temp=sets[place[x]].begin();
	while(1){
		if(*temp==x){
			break;
		}
		temp++;
	}
	sets[place[x]].erase(temp);
	sets[place[y]].push_back(x);
	place[x]=place[y];
}
void Print(int x){
	int sum=0;
	int temp;
	for(int i=0;i<sets[place[x]].size();i++){
		temp=sets[place[x]][i];
		sum+=temp;
	}
	cout<<sets[place[x]].size()<<" "<<sum<<endl;
}
