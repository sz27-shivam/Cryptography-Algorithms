import java.io.*;

class AutoKeyCipher
{
	private String key;
	
	public AutoKeyCipher(String key)
	{
		this.key=key;
		System.out.println("Keyword is :"+key);
	}
	
	public char add(char a,char b)
	{
		int n1=a-'a';
		int n2=b-'a';
		int n=(n1+n2)%26;
		System.out.println(a+"|"+n1+" + "+b+"|"+n2+" = "+n);
		int ret=n+'a';
		return (char)ret;
	}
	
	public char sub(char a,char b)
	{
		int n1=a-'a';
		int n2=b-'a';
		int n=n1-n2;
		if(n<0) n+=26;
		n%=26;
		System.out.println(a+"|"+n1+" - "+b+"|"+n2+" = "+n);
		int ret=n+'a';
		return (char)ret;
	}
	
	public String encrypt(String msg)
	{
		System.out.println("Performing Encryption...");
		String msgKey=key+msg,cipher="";
		for(int i=0;i<msg.length();i++)
		{
			cipher=cipher+add(msg.charAt(i),msgKey.charAt(i));
		}
		return cipher;
	}
	
	public String decrypt(String cpr)
	{
		System.out.println("Performing Decryption...");
		String msgKey=key,msg="";
		for(int i=0;i<cpr.length();i++)
		{
			char next=sub(cpr.charAt(i),msgKey.charAt(i));
			msgKey+=next;
			msg+=next;
		}
		return msg;
	}

}

public class AutoKeyDemo
{
	public static void main(String[] args) throws IOException
	{
		//Encryption
		AutoKeyCipher sender=new AutoKeyCipher("king");
		System.out.println("Enter the message :");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String msg=br.readLine();
		String cipherText=sender.encrypt(msg);	
		System.out.println("Cipher text is : "+cipherText);
		
		//Decryption
		AutoKeyCipher reciever=new AutoKeyCipher("king");
		String plainText=reciever.decrypt(cipherText);	
		System.out.println("Plain text is : "+plainText);	
	}
}	
