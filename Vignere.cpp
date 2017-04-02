//Question )     Encryption Using Vignere Cipher

#include<stdio.h>
#include<string.h>
int main()
{
  char plaintext[100],ciphertext[100];
	printf("Enter the plaintext\n");
	gets(plaintext);
	int plen = strlen(plaintext);
	char key[100];
	printf("Enter the key\n");
	gets(key);
	int i;
	int klen = strlen(key);
	for(i=0;i<plen;i++)
	{
	   if(plaintext[i]==' ')
	   {
	   	ciphertext[i]  = ' ';
	   	continue; 
	   }
		ciphertext[i] = 'a'+(plaintext[i]-'a' + key[i%klen] - 'a')%26 ;
	}
	ciphertext[i] = '\0';
	printf("The CipherText Is %s\n",ciphertext);
	char ptext[100];
	for(i=0;i<plen;i++)
	{
		if(ciphertext[i]==' ')
		{
			ptext[i] = ' ';
			continue;
		}
		ptext[i] = 'a' + (ciphertext[i] - 'a' - key[i%klen] + 'a' + 26)%26;
	}
	ptext[i] = '\0';
	printf("The plaintext is %s\n",ptext);
	return 0;
}
