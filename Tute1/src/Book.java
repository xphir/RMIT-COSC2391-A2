public class Book
{

// implement requirements A - D here

// ...



// method which allows the Book to be "returned" if it has been borrowed 
 public boolean returnBook()
 {
  // if borrower ID has been set (ie. book has been borrowed)
  if (this.borrowerID != null)
  {
  
// reset borrowerID to null and return true result 
   this.borrowerID = null;
   return true;
  }
else
  {
  
// otherwise book is not currently borrowed so return false result
   return false;
  }
 }
 
// format Book details to a String (useful for printing!)
public String toString() 
{
 return String.format(
  
"Book ID: %s\nTitle: %s\nAuthor: %s\nBorrowed by: %s\n",
   this.bookID, this.title, this.author,
   this.borrowerID != null ? this.borrowerID : "Available"); 
 }
} 