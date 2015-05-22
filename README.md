Exercise description 

1)
The example on page 100-103 is about classes that read bytes (the base class is InputStream and it reads bytes). The Unicode character set used in Java contains characters. Characters are build from 2 (or more) bytes.
Change the example so that characters (not bytes) are read (the base class for this is Reader; it knows how to read characters).
Hint: Use the Java API Specification (JavaDoc) to find out how to use the Reader class and its sub classes (many sub classes but organized according to the Decorator pattern).

2)
Supply decorator classes EncryptingWriter and DecryptingReader that encrypt and decrypt the characters of the underlying writer/reader. Make sure that these classes are again readers and writers so that you can apply additional decorations.
For the encryption, simply use the Caesar cipher, which shifts the alphabet by three characters. (i.e. A becomes D, B becomes E and so on).

3)
Improve the classes so that it is possible to vary the encryption algorithm. (Which design pattern will you employ for this?)
