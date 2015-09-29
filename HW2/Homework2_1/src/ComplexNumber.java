/**
 * @author Yujie
 * 
 * Representing a complex number
 */
public class ComplexNumber {
	/**
	 * these two variables represent the two parts of a complex number.
	 */
	private double real;
	private double imaginary;
	
	/**
	 * constructor #1
	 */
	public ComplexNumber()
	{
		real=1;
		imaginary=1;
	}
	
	/**
	 * constructor #2
	 * @param realPart	real part of a complex number
	 * @param imagPart	imaginary part of a complex number
	 */
	public ComplexNumber(double realPart, double imagPart)
	{
		real=realPart;
		imaginary=imagPart;
	}
	
	/**
	 * constructor #3
	 * @param cn a ComplexNumber object cn
	 */
	public ComplexNumber(ComplexNumber cn)
	{
		this.setReal(cn.getReal());
		this.setImaginary(cn.getImaginary());
	}


	/**
	 * Getter
	 * @return  this.real
	 */
	public double getReal() {
		return real;
	}

	/**
	 * Setter
	 * @param real
	 */
	public void setReal(double real) {
		this.real = real;
	}

	/**
	 * Getter
	 * @return this.imaginary
	 */
	public double getImaginary() {
		return imaginary;
	}

	/**
	 * Setter
	 * @param imaginary
	 */
	public void setImaginary(double imaginary) {
		this.imaginary = imaginary;
	}
	

	/**
	 * Add method performing addition of two complex numbers.
	 * @param cn	a ComplexNumber object
	 * @return		this object after the addition
	 */
	public ComplexNumber add(ComplexNumber cn)
	{
		this.setReal(this.getReal()+cn.getReal());
		this.setImaginary(this.getImaginary()+cn.getImaginary());
		return this;
	}
	
	/**
	 * Subtract method performing subtraction of two complex numbers.
	 * @param cn	a ComplexNumber object
	 * @return		this object after the subtraction
	 */
	public ComplexNumber substract(ComplexNumber cn)
	{
		this.setReal(this.getReal()-cn.getReal());
		this.setImaginary(this.getImaginary()-cn.getImaginary());
		return this;
	}
	
	/**
	 * Static add method
	 * @param n1	a ComplexNumber object
	 * @param n2	a ComplexNumber object
	 * @return 		a new ComplexNumber object after the addition
	 */
	public static ComplexNumber add(ComplexNumber n1, ComplexNumber n2)
	{
		ComplexNumber result = new ComplexNumber();
		result.setReal(n1.getReal()+n2.getReal());
		result.setImaginary(n1.getImaginary()+n2.getImaginary());
		return result;
	}
	
	/**
	 * Static subtract method
	 * @param n1	a ComplexNumber object
	 * @param n2	a ComplexNumber object
	 * @return return a new ComplexNumber object after the subtraction
	 */
	public static ComplexNumber subtract(ComplexNumber n1, ComplexNumber n2)
	{
		ComplexNumber result = new ComplexNumber();
		result.setReal(n1.getReal()-n2.getReal());
		result.setImaginary(n1.getImaginary()-n2.getImaginary());
		return result;
	}

	@Override
	public String toString() {
		return " ("+ real+", "+imaginary+ "i)";
	}
	
}

class Homework2_1
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		//create two ComplexNUmber objects: num1 and num2 and print them using toString() method.
		ComplexNumber num1=new ComplexNumber();
		System.out.println("the first complex number num1 is "+num1);
		
		ComplexNumber num2=new ComplexNumber(2,5);
		System.out.println("the second complex number num2 is "+num2);
		
		//test the add method.
		System.out.println("Add num1 to num2, the result is "+ num2.add(num1));
		
		//create a new ComplexNumber object using num2.
		ComplexNumber num3=new ComplexNumber(num2);
		System.out.println("Creat the third complex number num3 using num2: "+num3);
		
		//test the abstract method.
		System.out.println("Subtract num1 from num3, now num3 is "+num3.substract(num1));
		
		//test the static add and static abstract methods.
		System.out.println("Testing the STATIC add method with num1, num2: "+num1+" + "+num2+" = "+ComplexNumber.add(num1, num2));
		System.out.println("Testing the STATIC subtract method with num1, num3: "+num1+" - "+num3+" = "+ComplexNumber.subtract(num1, num3));
	}
}
