package tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FilterReader;
import java.io.IOException;

import reader.DecryptingReader;
import reader.LowerCaseInputStream;
import algorithms.CeasarCipher;
import algorithms.EncryptingAlg;

public class TestCeaserCipherReader {

	public static void main(String[] args) throws IOException {

		int c;
		EncryptingAlg alg = CeasarCipher.getCeaserCipher();

		FilterReader fr = new DecryptingReader(alg, new BufferedReader(
				new FileReader("text.txt")));

		FilterReader lc = new LowerCaseInputStream(new BufferedReader(
				new FileReader("text.txt")));

		System.out.println("What is written in the file: ");
		while ((c = lc.read()) >= 0) {
			System.out.print((char) c);
		}

		System.out.println();
		System.out.println("After encrypting it: ");

		while ((c = fr.read()) >= 0) {
			System.out.print((char) c);
		}

		lc.close();
		fr.close();
	}
}
