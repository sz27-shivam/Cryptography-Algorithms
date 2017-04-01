#include<bits/stdc++.h>
using namespace std; 
char mat[5][5]={'L','G','D','B','A','Q','M','H','E','C','U','R','N','I','F','X','V','S','O','K','Z','Y','W','T','P'};
int findrow(char a)
{
int i,j;
for(i=0;i<5;i++)
{
for(j=0;j<5;j++)
{
if(mat[i][j]==a)
{
return i;
}

}
}


}

int findcol(char a)
{
int i,j;
for(i=0;i<5;i++)
{
for(j=0;j<5;j++)
{
if(mat[i][j]==a)
{
return j;
}

}
}


}
int main()
{
char str[1000],en[1000],de[1000],key[1000],org[1000];

int i,j,k,l,r1,c1,r2,c2,len;
//scanf("%[^\n]s",key);



printf("enter message\n");
gets(str);
//scanf("%[^\n]s",str);

//k=strlen(key);
l=strlen(str);
for(i=0;i<l;i++)
org[i]=str[i];

len=l;
printf("\n");

for(i=0;i<len-1;i+=2)
{
if(str[i]==str[i+1])
{
for(j=len;j>i+1;j--)
str[j]=str[j-1];
str[i+1]='X';
len++;
}
}
if(len%2)
str[len]='X';
len++;
for(i=0;i<len;i++)
printf("%c",str[i]);
printf("\n");

for(i=0;i<len-1;i+=2)
{
r1=findrow(str[i]);
c1=findcol(str[i]);

r2=findrow(str[i+1]);
c2=findcol(str[i+1]);

if(r1==r2)
{
en[i]=mat[r1][(c1+1)%5];
en[i+1]=mat[r2][(c2+1)%5];
}
else if(c1==c2)
{
en[i]=mat[(r1+1)%5][(c1)%5];
en[i+1]=mat[(r2+1)%5][(c2)%5];

}
else
{
en[i]=mat[r1][c2];
en[i+1]=mat[r2][c1];

}
}

printf("encrypted message is \n");
for(i=0;i<len;i++)
printf("%c",en[i]);
printf("\n");

printf("decrypted message is \n");
for(i=0;i<l;i++)
printf("%c",org[i]);
printf("\n");


}
