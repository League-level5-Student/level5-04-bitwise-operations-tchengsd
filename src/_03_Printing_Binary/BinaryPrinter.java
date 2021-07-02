package _03_Printing_Binary;

public class BinaryPrinter {
	/*
	 * Complete the methods below so they print the passed in parameter in binary.
	 * Do not use the Integer.toBinaryString method!
	 * Use the main method to test your methods.
	 */

	
	public void printByteBinary(byte b) {
		// We first want to print the bit in the one's place
		
		// Shift b seven bits to the right
		System.out.print((b & 0b10000000) >> 7);
		System.out.print((b & 0b01000000) >> 6);
		System.out.print((b & 0b00100000) >> 5);
		System.out.print((b & 0b00010000) >> 4);
		System.out.print((b & 0b00001000) >> 3);
		System.out.print((b & 0b00000100) >> 2);
		System.out.print((b & 0b00000010) >> 1);
		System.out.print(b & 0b00000001);
		// Use the & operator to "mask" the bit in the one's place
		// This can be done by "anding" (&) it with the value of 1
		
		// Print the result using System.out.print (NOT System.out.println)
		
		//Use this method to print the remaining 7 bits of b
	}
	
	public void printShortBinary(short s) {
		// Create 2 byte variables
		byte b1;
		byte b2;
		// Use bit shifting and masking (&) to save the first
		// 8 bits of s in one byte, and the second 8 bits of
		// s in the other byte
		b1 = (byte)((s & 0xFF00) >> 8);
		b2 = (byte)(s & 0x00FF);
		// Call printByteBinary twice using the two bytes
		// Make sure they are in the correct order
		printByteBinary(b1);
		System.out.print(" ");
		printByteBinary(b2);
	}
	
	public void printIntBinary(int i) {
		// Create 2 short variables
		short s1;
		short s2;
		// Use bit shifting and masking (&) to save the first
		// 16 bits of i in one short, and the second 16 bits of
		// i in the other short
		s1 = (short)((i & 0xFFFF0000) >> 16);
		s2 = (short)(i & 0x0000FFFF);
		// Call printShortBinary twice using the two short variables
		// Make sure they are in the correct order
		printShortBinary(s1);
		System.out.print(" ");
		printShortBinary(s2);
	}
	
	public void printLongBinary(long l) {
		// Use the same method as before to complete this method
		int i1;
		int i2;
		i1 = (int)(l >> 32);
		i2 = (int)(l & 0x00000000FFFFFFFF);
		printIntBinary(i1);
		System.out.print(" ");
		printIntBinary(i2);
	}
	
	public static void main(String[] args) {
		// Test your methods here
		new BinaryPrinter().printLongBinary(100_000_000_000_000_000L);
	}
}
