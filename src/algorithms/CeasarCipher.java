package algorithms;

import algorithms.utility.ArrayRing;

public class CeasarCipher implements EncryptingAlg {

	private static CeasarCipher cipher;

	private static final int size = 26;
	private static ArrayRing<Integer> small;
	private static ArrayRing<Integer> big;

	private CeasarCipher() {
		small = new ArrayRing<Integer>(size);
		big = new ArrayRing<Integer>(size);
		for (int i = 0; i < size; i++) {
			big.add(65 + i);
			small.add(97 + i);
		}
	}

	public static CeasarCipher getCeaserCipher() {
		if (cipher == null) {
			cipher = new CeasarCipher();
		}
		return cipher;
	}

	@Override
	public int decrypt(int c) {
		for (int i = 0; i < size; i++) {
			if (c == small.getCurrentItem()) {
				for (int j = 0; j < 3; j++) {
					small.counterAdvance();
				}
				return small.getCurrentItem();
			} else {
				small.counterAdvance();
			}
		}

		for (int i = 0; i < size; i++) {
			if (c == big.getCurrentItem()) {
				for (int j = 0; j < 3; j++) {
					big.counterAdvance();

				}
				return big.getCurrentItem();
			} else {
				big.counterAdvance();
			}
		}
		return c;
	}

	@Override
	public int encrypt(int c) {
		for (int i = 0; i < size; i++) {
			if (c == small.getCurrentItem()) {
				for (int j = 0; j < 3; j++) {
					small.advance();
				}
				return small.getCurrentItem();
			} else {
				small.advance();
			}
		}

		for (int i = 0; i < size; i++) {
			if (c == big.getCurrentItem()) {
				for (int j = 0; j < 3; j++) {
					big.advance();
				}
				return big.getCurrentItem();
			} else {
				big.advance();
			}
		}
		return c;

	}
}
