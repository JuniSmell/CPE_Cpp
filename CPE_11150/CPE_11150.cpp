#include<iostream> 
using namespace std;
int main(){
	int myC;
	int newC;
	while(1){
		myC=0;		//my cola
		newC=0;		//new cola
		cin>>myC;
		newC=myC/2;
		cout<<(myC+newC)<<endl;
	}
	
	system("pause");
	return 0;
}
