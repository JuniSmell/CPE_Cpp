#include<iostream>
#include<string>
using namespace std;
char decode(char);
int main(){
	int n=1;
	int times=1;
	string s;
	string tmp;
	string newS;
	cin>>n;
	cin.ignore();
	newS="";
	while(times<=n){//有多少case 
		while(1){//某一個case 
			tmp="";
			getline(cin,s);
			if(s.length()==0){
				break;
			}else{
				for(int i=0;i<s.length();i++){
					tmp=tmp+decode(s[i]);
				}
				newS=newS+tmp;
				newS=newS+"\n";
			}	
		}
		newS+="\n";	
		times++;		
	}
	cout<<newS;
	system("pause");
	return 0;
} 

char decode(char c){
	switch(c){
		case '0':
			return 'O';
		case '1':
			return 'I';
		case '2':
			return 'Z';
		case '3':
			return 'E';
		case '4':
			return 'A';
		case '5':
			return 'S';
		case '6':
			return 'G';
		case '7':
			return 'T';
		case '8':
			return 'B';
		case '9':
			return 'P';
		default:
			return c;
	}
}
