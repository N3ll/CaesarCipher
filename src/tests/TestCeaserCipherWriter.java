package tests;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;
import java.io.PrintWriter;

import writer.EncryptingWriter;
import algorithms.CeasarCipher;
import algorithms.EncryptingAlg;

public class TestCeaserCipherWriter {
	public static void main(String[] args) throws IOException {

		EncryptingAlg alg = CeasarCipher.getCeaserCipher();

		FilterWriter fwr = new EncryptingWriter(alg, new PrintWriter(
				new BufferedWriter(new FileWriter("text.txt"))));

		String a = "Hello I am Coraline!";
		for (int i = 0; i < a.length(); i++) {
			int c = a.charAt(i);
			fwr.write(c);
		}

		// How to print it on the console?
		// System.out.println(fwr.toString());
		fwr.close();
	}
}
