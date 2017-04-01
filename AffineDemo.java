import java.io.*;
import java.util.*;

class Affine
{
	private static int a;
	private static int b;	
	private static int inv;	
	
	private static int findInverse()
	{
		for(int i=1;i<=26;i++)
		{
			if( (a*i)%26==1 )
				return i;
		}
		return 1;
	}
	
	public Affine(int a,int b)
	{
		this.a=a;
		this.b=b;
		inv=findInverse();
		System.out.println("Multiplicative inverse is : "+inv);
	}

	public String Encryption(String plainText)
	{
		String ret="";			
		for(int i=0;i<plainText.length();i++)
		{
			int n1=(plainText.charAt(i)-'a');
			int n2=a*n1+b;		
			n2%=26;			
			char c=(char)(n2+'A');
			System.out.println(plainText.charAt(i)+" -> "+ c);				
			ret+=c;
		}
		return ret;		
	}

	public String Decryption(String plainText)
	{
		String ret="";			
		for(int i=0;i<plainText.length();i++)
		{
			int n1=(plainText.charAt(i)-'A');
			int n2=(n1-b)*inv;
			n2%=26;
			if(n2<0) n2+=26;
			char c=(char)(n2+'a');
			System.out.println(plainText.charAt(i)+" -> "+ c);				
			ret+=c;
		}
		return ret;		
	}


}

public class AffineDemo
{	
	public static void main(String[] arg) throws IOException
	{	
		String in,plainText,cipherText,msg;		

		System.out.println("Enter the plaintext :");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		plainText=br.readLine();
		
		System.out.println("Enter the multiplicative key :");	
		in=br.readLine();
		int a=Integer.parseInt(in);
		System.out.println("Enter the additive key :");		
		in=br.readLine();
		int b=Integer.parseInt(in);
		
		Affine af=new Affine(a,b);		
	
		System.out.println("Performing Encryption...");
		cipherText=af.Encryption(plainText);		
		System.out.println("Ciphertext is : "+cipherText);
		System.out.println("Performing Decryption...");
		msg=af.Decryption(cipherText);
		System.out.println("Recieved message is : "+msg);	
	}
}
