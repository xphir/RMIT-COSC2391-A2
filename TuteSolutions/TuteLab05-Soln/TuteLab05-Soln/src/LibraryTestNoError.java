import library.*;

public class LibraryTestNoError
{

	public static void main(String[] args)
	{
		
			Library<Media> myMedias = new Library<Media>();
			Library<? super Book> my5 = myMedias;
			
			my5.add(new Book());
			myMedias.add(new DigitalVersatileDisc());
			// prints: Library: { \n a book \n a really versatile disc of the digital type \n }
			my5.print();
			
		
	}

}
