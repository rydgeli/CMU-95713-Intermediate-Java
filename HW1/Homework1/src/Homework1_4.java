import java.util.Random;

public class Homework1_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//If the number of command- line arguments is not two, the main function should return immediately
		if(args.length!=2)
			return;
		
		System.out.println("2 Command line arguments are: "+args[0]+" | "+args[1]);
		stringTest(args);
		stringBufferTest(args);
	}
	
	private static void stringTest(String[] args)
	{
		System.out.println("----------Start of String test------------------");
		Random ran=new Random();
		String s1=new String(args[0]), s2=new String(args[1]);
		System.out.println("s1.length(): "
				+s1.length());
		
		System.out.println("s1.charAt(i) for all i for String s1:");
		for(int i=0;i<s1.length();i++)
			System.out.println(s1.charAt(i));
		
		System.out.println("s1.equals(s2): "
				+s1.equals(s2));
		
		System.out.println("s1.equalsIgnoreCase(s2): "
				+s1.equalsIgnoreCase(s2));
		
		System.out.println("s1.compareTo(s2): "
				+s1.compareTo(s2));
		
		//first, get the shorter length from s1 and s2.
		int shorterLen=(s1.length()<s2.length()?s1.length():s2.length());
		
		//using random.nextInt() for the last parameter to make sure the number of characters <= s1 or s2's length.
		//case 1:
		System.out.println("s1.regionMatches(0, s2, 0, ran.nextInt(shorterLen+1): "
				+s1.regionMatches(0, s2, 0, ran.nextInt(shorterLen)+1));
		//case 2:
		if(shorterLen>1)
			System.out.println("s1.regionMatches(0, s2, 1, ran.nextInt(shorterLen+1): "
					+s1.regionMatches(0, s2, 1, ran.nextInt(shorterLen)+1));
		
		//testing reginMatches with Boolean parameter.
		//case 1:
		System.out.println("s1.regionMatches(false, 0, s2, 0, ran.nextInt(shorterLen+1)): "
				+s1.regionMatches(false, 0, s2, 0, ran.nextInt(shorterLen)+1));
		//case 2:
		if(shorterLen>1)
			System.out.println("s1.regionMatches(true, 0, s2, 1, ran.nextInt(shorterLen+1)): "
					+s1.regionMatches(true, 0, s2, 1, ran.nextInt(shorterLen)+1));
		
		System.out.println("s1.indexOf('x', 0): "
				+s1.indexOf('x', 0));
		
		System.out.println("s1.concat(s2): "
				+s1.concat(s2));
		
		//randomly choose a char in s1 to be replaced with 'X'.
		System.out.println("s1.replace(s1.charAt(ran.nextInt(s1.length())), 'X'): "
				+s1.replace(s1.charAt(ran.nextInt(s1.length())), 'X'));
		
		System.out.println("s1.toUpperCase(): "
				+s1.toUpperCase());
		
		System.out.println("s1.toLowerCase(): "
				+s1.toLowerCase());
		
		System.out.println("----------End of String test------------------");
	}
	
	private static void stringBufferTest(String[] args)
	{
		Random ran=new Random();
		System.out.println("----------Start of StringBuffer test------------------");
		StringBuffer sbuf1=new StringBuffer(args[0]),sbuf2=new StringBuffer(args[1]);
		
		System.out.println("sbuf1.length(): "
				+sbuf1.length());
		
		System.out.println("sbuf1.delete(0, ran.nextInt(sbuf1.length())+1)): "
				+sbuf1.delete(0,ran.nextInt(sbuf1.length())+1));
		
//		System.out.println("now sbuf1 is: "+sbuf1);
		
		if(sbuf1.length()>0)
			System.out.println("sbuf1.deleteCharAt(int index): "
					+sbuf1.deleteCharAt(ran.nextInt(sbuf1.length())));
		
//		System.out.println("now sbuf1 is: "+sbuf1);
		
		if(sbuf1.length()>0)
			System.out.println("sbuf1.reverse(): "
					+sbuf1.reverse());
		
		if(sbuf1.length()>0)
			System.out.println("sbuf1.replace(): "
					+sbuf1.replace(0, ran.nextInt(sbuf1.length())+1, "Java"));
		
		System.out.println("sbuf1.append().append(): "
				+sbuf1.append(1).append(sbuf2));
		
		MyClass mine=new MyClass();
		System.out.println("sbuf1.append() with MyClass: "
				+sbuf1.append(mine));
		
		//Randomly choose a index to insert.
		if(sbuf1.length()>0)
			System.out.println("sbuf1.insert(): "
					+sbuf1.insert(ran.nextInt(sbuf1.length()), mine));
		System.out.println("----------End of StringBuffer test------------------");
	}

}

class MyClass
{
	public String toString()
	{
		return "This is my object";
	}
}
