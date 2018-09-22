import library.*;

public class LibraryTest
{

	private static void bookTest1()
	{
		Library<GenericMedia> myMedias = new Library<GenericMedia>();
		Library<Book> myBooks = new Library<Book>();
		// GenericMedia is not a subtype of Book
		myBooks.add(new GenericMedia());
		myBooks.add(new Book());
		myMedias.add(new GenericMedia());
		myMedias.add(new Book());
	}

	private static void bookTest2()
	{
		Library<Media> myMedias = new Library<Media>();
		Library<Book> myBooks = new Library<Book>();
		// Media is not a subtype of Book
		// Media is an interface and cannot be constructed
		myBooks.add(new Media());
		myBooks.add(new Book());
		// Media is an interface and cannot be constructed
		myMedias.add(new Media());
		myMedias.add(new Book());
	}

	private static void bookTest3()
	{
		// Library<E extends Media>, Object is not a subtype of Media
		Library<Object> myObjects = new Library<Object>();
		Library<Media> myMedias = new Library<Media>();
		Library<Book> myBooks = new Library<Book>();

		// Parameterised types can't be cast (except when they can :P)
		// https://docs.oracle.com/javase/tutorial/java/generics/restrictions.html#cannotCast
		// Type erasure means that at runtime all of these are type Library
		Library<Object> my1 = (Library<Object>) myMedias;
		Library<Book> my2 = (Library<Book>) myObjects;
		Library<Media> my3 = (Library<Media>) myBooks;

		
		// Extra
		// Wildcards loosen restrictions on type but be careful
		Library<? extends Media> my4 = myBooks;
		Library<? super Book> my5 = myMedias;
		
		// my4 can contain only one (but any) subtype of Media so we can't add to it
		my4.add(new Book());
		Media test4 = my4.retrieveLast();
		
		// my5 can contain anything of any supertype of Book so we can't be sure what objects we'll get out
		// they could be anything which has Media as it's supertype because of Library<E extends Media>
		my5.add(new Book());
		// remember that myMedias is my5
		myMedias.add(new DigitalVersatileDisc());
		Book test5 = my5.retrieveLast();
		Media test5a = my5.retrieveLast();
		// prints: Library: { \n a book \n a really versatile disc of the digital type \n }
		my5.print();
		

	}
}
