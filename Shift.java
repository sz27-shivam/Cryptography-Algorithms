import java.io.*;

public class Shift
{
	private static int key;	
	
	private static String Encryption(String plainText,boolean enc)
	{
		String ret="";		
		int shift=key;
		if(!enc) shift*=(-1);	
		for(int i=0;i<plainText.length();i++)
		{
			int n=(plainText.charAt(i)-'a'+shift);
			if(!enc) n=n+'a'-'A';			
			n%=26;
			if(n<0) n+=26;
			System.out.println(plainText.charAt(i)+" -> "+ n);			
			if(!enc) n=n+'a'-'A';			
			ret+=(char)(n+'A');
		}
		return ret;		
	}
	
	public static void main(String[] arg) throws IOException
	{
		String plainText,cipherText="",msg;
		System.out.println("Enter the plaintext :");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		plainText=br.readLine();
		System.out.println("Enter the key: ");
		key=Integer.parseInt(br.readLine());	
		System.out.println("Performing Encryption...");
		cipherText=Encryption(plainText,true);		
		System.out.println("Ciphertext is : "+cipherText);
		System.out.println("Performing Decryption...");
		msg=Encryption(cipherText,false);
		System.out.println("Recieved message is : "+msg);	
	}
}
