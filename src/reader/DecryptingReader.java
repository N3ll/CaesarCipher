package reader;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

import algorithms.EncryptingAlg;

public class DecryptingReader extends FilterReader {
	private EncryptingAlg alg;

	public DecryptingReader(EncryptingAlg alg, Reader in) {
		super(in);
		setEncryptingAlg(alg);
	}

	/**
	 * Original description of the method
	 * 
	 * Reads a single character.
	 * 
	 * @return The character read, as an integer in the range 0 to 65535
	 *         (0x00-0xffff), or -1 if the end of the stream has been reached
	 */
	@Override
	public int read() throws IOException {
		int c = super.read();
		if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
			return alg.decrypt(c);

		} else {
			return c;
		}
	}

	public void setEncryptingAlg(EncryptingAlg alg) {
		this.alg = alg;
	}

}
