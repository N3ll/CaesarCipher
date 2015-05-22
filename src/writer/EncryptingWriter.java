package writer;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

import algorithms.EncryptingAlg;

public class EncryptingWriter extends FilterWriter {
	private EncryptingAlg alg;

	public EncryptingWriter(EncryptingAlg alg, Writer out) {
		super(out);
		setEncryptingAlg(alg);
	}

	@Override
	public void write(int c) throws IOException {
		int temp = alg.encrypt(c);
		super.write(temp);
	}

	public void setEncryptingAlg(EncryptingAlg alg) {
		this.alg = alg;
	}

}
