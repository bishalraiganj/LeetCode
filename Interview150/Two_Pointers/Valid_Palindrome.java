package Interview150.Two_Pointers;

public class Valid_Palindrome {


	// a!befsba
	public boolean isPalindrome(String s) {

		if (s == null || s.length() == 0) {
			return true;
		}

		int i = 0;
		int j = s.length() - 1;

		while (i < j) {

			int charVal1 = s.charAt(i);
			int charVal2 = s.charAt(j);
			while ((i<j) && !(65 <= charVal1 && charVal1 <= 90 || charVal1 >= 97 && charVal1 <= 122 || charVal1>=48 && charVal1<=57)) {
				i++;
				charVal1 = s.charAt(i);
			}
			while((i<j) && !(65 <= charVal2 && charVal2 <= 90 || charVal2 >= 97 && charVal2 <= 122 || charVal2>=48 && charVal2<=57)) {
				j--;
				charVal2 = s.charAt(j);
			}
			if (i < j) {

				int char1 = s.charAt(i);
				int char2 = s.charAt(j);
				if((char1>=48 && char1<=57) || (char2>=48 && char2<=57))
				{
					if(char1!=char2) {
						return false;
					}
				}
				 else if (  (char1 != char2) &&  Math.abs(char1-char2)!=32)
				{
					return false;
				}
			}
			i++;
			j--;
		}
		return true;
	}


}
