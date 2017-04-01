#include<bits/stdc++.h>
using namespace std;
int main()
{
char str[1000],en[1000],de[1000],key[1000];
int i,j,k,l;
printf("enter key : ");
//gets(key);
scanf("%[^\n]s",key);
getchar();

printf("enter message : ");
//gets(str);
scanf("%[^\n]s",str);

k=strlen(key);
l=strlen(str);

if(k<l)
{
for(i=k;i<l;i++)
key[i]=str[i];

key[i]='\0';

}

for(i=0;i<l;i++)
{
if(str[i]==' ')
en[i]='*';
else
en[i]=((str[i]-'a')+(key[i]-'a'))%26+'a';
}
printf("Encrypted message is\n\n");
for(i=0;i<l;i++)
printf("%c",en[i]);
printf("\n");


for(i=0;i<l;i++)
{
if(en[i]!='*')
de[i]=(en[i]-key[i]+26)%26 +'a';
else
de[i]=' ';
}


printf("Decrypted message is\n\n");
for(i=0;i<l;i++)
printf("%c",de[i]);
printf("\n");







}
