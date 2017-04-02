import java.io.*;

class PlayfairCipher
{
	private String userKey,key;
	private char keyMatrix[][] = new char[5][5];
	
	private boolean isPresent(char a, String s)
	{
		for(int i=0;i<s.length();i++)
			if(s.charAt(i)==a)
				return true;
		return false;		
	}
	
	public PlayfairCipher(String key)
	{
		userKey="";
		for(int i=0;i<key.length();i++)
		{
			if(isPresent(key.charAt(i),userKey) || key.charAt(i)=='j')
				continue;
			else
				userKey+=key.charAt(i);	
		}
		generateKey();
	}
	
	private void generateKey()
	{
		key=userKey;
		for(int i = 0; i < 26; i++)
		{
			char curr=(char)(i+'a');
			if(isPresent(curr,userKey) || curr=='j')
				continue;
			else
				key+=curr;	
		}
		//System.out.println(key);
		formMatrix();
	}
	
	private void formMatrix()
	{
	        int counter = 0;
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 5; j++)
			{
				keyMatrix[i][j] = key.charAt(counter);
				System.out.print(keyMatrix[i][j] + " ");
				counter++;
			}
		System.out.println();
		}
	}
	
	private String format(String msg)
	{
		String ret="";
		char curr;
		for(int i=0;i<msg.length();i++)
		{
			curr=msg.charAt(i);
			if(curr=='j')
				ret+='i';
			else
				ret+=curr;
			if(i<msg.length()-1 && msg.charAt(i+1)==msg.charAt(i) && i%2==0)
				ret+='x';		
		}
		if(ret.length()%2!=0)
			ret+='x';
		return ret;	
	}
	
	private String[] divide(String msg)
	{
		int n=msg.length();
		String[] ret=new String[n/2];
		for(int i=0;i<n/2;i++)
		{
			ret[i]=""+msg.charAt(2*i)+msg.charAt(2*i+1);
			//System.out.println(ret[i]);
		}
		return ret;
	}
	
	private int[] getIdx(char a)
	{
		if(a=='j')
			a='i';
		int idx[]=new int[2];
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				if(keyMatrix[i][j]==a)
				{
					idx[0]=i;
					idx[1]=j;
					break;		
				}			
			}
		}		
		return idx;
	}
	
	public String encrypt(String msg)
	{
		String msg2=format(msg);
		System.out.println("Performing Encryption on "+ msg2);
		String pairs[]=divide(msg2);
		String cipher="";
		int idx1[]=new int[2];
		int idx2[]=new int[2];
		
		for(int i=0;i<pairs.length;i++)
		{
			char first=pairs[i].charAt(0);
			char second=pairs[i].charAt(1);
			idx1=getIdx(first);
			idx2=getIdx(second);
			
			if(idx1[0] == idx2[0])
			{
				idx1[1]=(idx1[1]+1)%5;
				idx2[1]=(idx2[1]+1)%5;
			}
			else if (idx1[1] == idx2[1])
			{
				idx1[0]=(idx1[0]+1)%5;
				idx2[0]=(idx2[0]+1)%5;
			}
			else
			{
				int temp = idx1[1];
				idx1[1] = idx2[1];
				idx2[1] = temp;
			}
			System.out.println(pairs[i]+" -> "+keyMatrix[idx1[0]][idx1[1]]+keyMatrix[idx2[0]][idx2[1]]);
			cipher=cipher+keyMatrix[idx1[0]][idx1[1]]+keyMatrix[idx2[0]][idx2[1]];
		}
		return cipher;
	}
	
	public String decrypt(String msg)
	{
		System.out.println("Performing Decryption...");
		String pairs[]=divide(msg);
		String cipher="";
		int idx1[]=new int[2];
		int idx2[]=new int[2];
		
		for(int i=0;i<pairs.length;i++)
		{
			char first=pairs[i].charAt(0);
			char second=pairs[i].charAt(1);
			idx1=getIdx(first);
			idx2=getIdx(second);
			
			if(idx1[0] == idx2[0])
			{
				idx1[1]=idx1[1]-1;
				if(idx1[1]<0) idx1[1]=4;
				idx2[1]=idx2[1]-1;
				if(idx2[1]<0) idx2[1]=4;
			}
			else if (idx1[1] == idx2[1])
			{
				idx1[0]=idx1[0]-1;
				if(idx1[0]<0) idx1[0]=4;
				idx2[0]=idx2[0]-1;
				if(idx2[0]<0) idx2[0]=4;
			}
			else
			{
				int temp = idx1[1];
				idx1[1] = idx2[1];
				idx2[1] = temp;
			}
			cipher=cipher+keyMatrix[idx1[0]][idx1[1]]+keyMatrix[idx2[0]][idx2[1]];
			System.out.println(pairs[i]+" -> "+keyMatrix[idx1[0]][idx1[1]]+keyMatrix[idx2[0]][idx2[1]]);
		}
		return cipher;
	}

}

public class PlayfairDemo
{
	public static void main(String[] args) throws IOException
	{
		//Encryption
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the key :");
		String key=br.readLine();
		System.out.println("Enter the message :");
		String msg=br.readLine();
		PlayfairCipher sender=new PlayfairCipher(key);
		String cipherText=sender.encrypt(msg);	
		System.out.println("Cipher text is : "+cipherText+"\n\n");
		
		//Decryption
		PlayfairCipher reciever=new PlayfairCipher(key);
		String plainText=reciever.decrypt(cipherText);	
		System.out.println("Plain text is : "+plainText);
		
	}
}	
