import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Random;

public class Homework1_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		System.out.println("Please enter the number of students in the class");
		int NumOfStudents = in.nextInt();
		ArrayList<Integer> Scores = new ArrayList<Integer>();
		for(int i=0;i<NumOfStudents;i++)
		{
			Random generator=new Random();
			Scores.add(generator.nextInt(51)+50);
//			Scores.add((int)(Math.random() * 50 + 50));
		}
		Collections.sort(Scores);
		ArrayList<Integer> A=new ArrayList<Integer>();
		ArrayList<Integer> B=new ArrayList<Integer>();
		ArrayList<Integer> C=new ArrayList<Integer>();
		ArrayList<Integer> D=new ArrayList<Integer>();
		ArrayList<Integer> F=new ArrayList<Integer>();
		for(int score:Scores)
		{
			if(score<=59)
				F.add(score);
			if(score>=60 && score<=69)
				D.add(score);
			if(score>=70 && score<=79)
				C.add(score);
			if(score>=80 && score<=89)
				B.add(score);
			if(score>=90 && score<=100 )
				A.add(score);
		}
		
		System.out.println("Here is the result:");
		if(!A.isEmpty())
		{
			System.out.print("A: ");
			for (int score : A)
			{
				
				System.out.print(""+score+" ");
			}
		}
		if(!B.isEmpty())
		{
			System.out.print("\nB: ");
			for (int score : B)
			{
				
				System.out.print(""+score+" ");
			}
		}
		if(!C.isEmpty())
		{
			System.out.print("\nC: ");
			for (int score : C)
			{
				
				System.out.print(""+score+" ");
			}
		}
		if(!D.isEmpty())
		{
			System.out.print("\nD: ");
			for (int score : D)
			{
				
				System.out.print(""+score+" ");
			}
		}
		if(!F.isEmpty())
		{
			System.out.print("\nF: ");
			for (int score : F)
			{
				System.out.print(""+score+" ");
			}
		}
	}
}
