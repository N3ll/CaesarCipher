package reader;
import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class LowerCaseInputStream extends FilterReader {

	public LowerCaseInputStream(Reader in) {
		super(in);
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
		return c == -1 ? c : Character.toLowerCase((char) c);
	}

	/**
	 * 
	 * Original description of the method
	 * 
	 * Reads characters into a portion of an array.
	 * 
	 * @param cbuf
	 *            - Destination buffer
	 * @param off
	 *            - Offset at which to start storing characters
	 * @param len
	 *            - Maximum number of characters to read
	 * 
	 * 
	 * @return The number of characters read, or -1 if the end of the stream has
	 *         been reached
	 */

	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {

		int result = super.read(cbuf, off, len);

		for (int i = off; i < off + result; i++) {
			// System.out.println(cbuf[i]);
			cbuf[i] = Character.toLowerCase(cbuf[i]);
		}
		return result;
	}

}
