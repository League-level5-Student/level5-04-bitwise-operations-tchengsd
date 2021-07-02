package _01_Bit_Shifting;

public class BitShifter {
	public static void main(String[] args) {
		// 1. Jot down the value of num in binary.
		// num in binary is 100
		int num = 4;
		int numShifted = num << 1;
		
		// 2. Print the value of numShifted, and convert that value to binary.
		System.out.println(numShifted);
		String binaryStr = "";
		int temp = numShifted;
        do {
            int quotient = temp >> 1;
            if( temp % 2 != 0 ){
                binaryStr = '1' + binaryStr;
            } else {
                binaryStr = '0' + binaryStr;
            }
            temp = quotient;   
        } while( temp != 0 );
        System.out.println(binaryStr);
		// 3. Compare the two binary values. Can you figure out what the << operator is for?
		// The << operator multiplies values by 2^n, in which n is the value after the operator. It does this by shifting each bit one place to the left, adding a 0 bit in the units place.
		// 4. Try shifting num 3 places.
		System.out.println(num << 3);
		// FYI: Binary values can be shifted to the right as well using the >> operator.	
	}
}
