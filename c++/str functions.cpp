 #include<iostream>
using namespace std;
char s[10];
int i;
class str
{
	public:
		void len()
		{
			int c=0;
			for(i=0;s[i] != '\0';i++)
			{
				c++;	
			}
			cout<<"length of string \n"<<c;	
		}
		void cpy()
		{
			char s2[10];
			for(i=0;s[i]!='\0';i++)
			s2[i]=s[i];
			cout<<"\ncopied string "<<s2;
		}
		void cmd()
		{
			int j;
			char s2[10],s3[10];
			cout<<"\nEnter another string";
			gets(s2);
			for(i=0;s[i]!='\0';i++)
			s3[i]=s[i];
			for(i,j=0;s2[j]!='\0';i++,j++)
			s3[i]=s2[j];
			s3[i]='\0';
			cout<<"\nCombined string is "<<s3;
		}
		void cmp()
		{
			char s2[10];
			int c=0;
			cout<<"\nEnter another string for compare :";
			gets(s2);
			for(i=0;s[i]!='\0'||s2[i]!='\0';i++)
			{
				if(s[i]!=s2[i])
				{
					c=1;
				}
			}
			if(c==0)
			cout<<"\nBoth string are same";
			else
			cout<<"\nBoth string are not same";
		}
};
int main()
{
	cout<<"Enter a string:\n ";
	gets(s);
	str a;
	a.len();
	a.cpy();
	a.cmd();
	a.cmp();
}

