import java.io.*;
import java.util.*;

public class Substitute
{
	private static HashMap<Character,Character> hm=new HashMap<Character,Character>();  ;	
	private static String key="QWERTYUIOPASDFGHJKLZXCVBNM";	
	
	private static void init()
	{
		System.out.println("Key : ");
		for(int i=0;i<key.length();i++)
		{
			System.out.println((char)(i+'a')+ "->" + key.charAt(i));
			hm.put((Character)key.charAt(i),(Character)(char)(i+'a'));
		}
	}	

	private static String Encryption(String plainText)
	{
		String ret="";			
		for(int i=0;i<plainText.length();i++)
		{
			int n=(plainText.charAt(i)-'a');		
			char c=(char)(key.charAt(n));
			System.out.println(plainText.charAt(i)+" -> "+ c);				
			ret+=c;
		}
		return ret;		
	}

	private static String Decryption(String cipherText)
	{
		String ret="";			
		for(int i=0;i<cipherText.length();i++)
		{		
			char c=(char)(hm.get(cipherText.charAt(i)));			
			System.out.println(cipherText.charAt(i)+" -> "+ c);			
			ret+=c;
		}
		return ret;		
	}
	
	public static void main(String[] arg) throws IOException
	{
		init();		
		String plainText,cipherText,msg;
		System.out.println("Enter the plaintext :");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		plainText=br.readLine();	
		System.out.println("Performing Encryption...");
		cipherText=Encryption(plainText);		
		System.out.println("Ciphertext is : "+cipherText);
		System.out.println("Performing Decryption...");
		msg=Decryption(cipherText);
		System.out.println("Recieved message is : "+msg);	
	}
}
