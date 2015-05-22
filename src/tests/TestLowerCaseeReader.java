package tests;

import java.io.CharArrayReader;
import java.io.FilterReader;
import java.io.IOException;
import java.io.StringReader;

import reader.LowerCaseInputStream;

public class TestLowerCaseeReader {

	public static void main(String[] args) throws IOException {
		int c;
		String s = "Hello There!";
		FilterReader fr = new LowerCaseInputStream(new StringReader(s));

		while ((c = fr.read()) >= 0) {
			System.out.print((char) c);
		}

		System.out.println("\n");

		char[] charArr = { 'A', 'b', 'C' };

		fr = new LowerCaseInputStream(new CharArrayReader(charArr));
		char[] temp = new char[11];
		fr.read(temp, 0, 11);
		System.out.print(temp);

		fr.close();

	}
}
