/*Write a console application that takes in a currency value (min value 00, max value 9,99,99,999) and prints out a text
  for ex. If provided "123456.78",It should print out "Rs. One Lakh Twenty Three Thousand Four Hundred and Fifty Six 78/100 ONLY"*/


class NoToWordCon {
	static String ones[] = { "", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ", "Ten ", 
			                "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen"};

	static String tens[] = { "", "", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ","Ninety "};
	
	static String numToWords(int n, String s)
	{
		String str = "";
		if (n > 19) {
			str += tens[n / 10] + ones[n % 10];
		}
		else {
			str += ones[n];
		}
		if (n != 0) {
			str += s;
		}
        return str;
	}
       
	
	// Function to print a given number in words
	static String convertToWords(double n)
	{
		// String str stores word representation of given number n
		String str = "";

		// handles digits at ten millions and hundred millions places
		str += numToWords((int)(n / 10000000), "Crore ");

		// handles digits at hundred thousands and one millions places 
		str += numToWords((int)((n / 100000) % 100), "Lakh ");

		// handles digits at thousands and tens thousands places 
		str += numToWords((int)((n / 1000) % 100), "Thousand ");

		// handles digit at hundreds places 
		str += numToWords((int)((n / 100) % 10), "Hundred ");

		if (n > 100 && n % 100 > 0) {   
			str += "and ";
		}
		
		// handles digits at ones and tens places 
		str += numToWords((int)(n % 100), "");
		
		// handles digits after decimal point
		//String s=String.valueOf(n);
		String s=String.format("%.2f",n);                   //"%.2f" prints 2 decimal places
		str +=s.substring(s.indexOf('.')+1)+ "/100 ONLY ";  //('.') returns index position
                return str;
	}
	
	    
	// Driver code
	public static void main(String[] args)
	{
		double n = 12345678.91;                    //Given input number
        System.out.printf("Rs. "+convertToWords(n));  
	}

}

