package nl.heartmates01;

// De class Library heeft de volgende members (velden)
// LETOP: andere classes mogen niet direct by deze members kunnen:

// books (List)

// De class Library heeft de volgende methods:

// void addBook(String title, String author, int pages, String isbn)
// deze method maakt een nieuw Book object aan en voegt deze toe aan de books List.

// void removeBook(long id)
// Deze method zoekt het boek op in de books List en verwijderd deze uit de List.

// String showBook(long id)
// Deze method zoekt het boek op in de books List en geeft de informatie van het boek terug als een String.

// void borrowBook(long id)
// Deze method zoekt het boek op in de books List en zet de borrowed waarde op true.

// void returnBook(long id)
// Deze method zoekt het boek op in de books List en zet de borrowed waarde op false.

// String showBooks()
// Deze method geeft alle boeken in de books List terug als een String, per book de Titel en de Auteur.

// String showBorrowedBooks()
// Deze method geeft alle geleende boeken in de books List terug als een String,
// per book de Titel en de Auteur.

// String showAvailableBooks()
// Deze method geeft alle beschikbare boeken in de books List terug als een String,
// per book de Titel en de Auteur.


import java.util.ArrayList;
import java.util.List;

class Library {

  // deze method maakt een nieuw Book object aan en voegt deze toe aan de books List.

  List<Book> allBooks = new ArrayList<>();

  void addBook(long id, String title, String author, int pages, String isbn, boolean borrowed) {
    allBooks.add(new Book(id, title, author, pages, isbn, borrowed));
  }

  // zoekt id van book
  Book findID(long id) {
    for (Book book : allBooks) {
      if (id == book.getId()) {
        return book;
      }
    }
    return null;
  }


  // Deze method zoekt het boek op in de books List en verwijderd deze uit de List.
  void removeBook(long id) {
    Book foundBook = findID(id);
    if (foundBook != null) {
      allBooks.remove(foundBook);
    }
  }

  // Deze method zoekt het boek op in de books List
  // en geeft de informatie van het boek terug als een String.
  String showBook(long id) {
    Book book = findID(id);
    if (book != null) {
      return book.toString();
    }
    return "Book not in list.";
  }

  // Deze method zoekt het boek op in de books List en zet de borrowed waarde op true.
  void borrowBook(long id) {
    Book trueBorrowedBook = findID(id);
    if (trueBorrowedBook != null) {
      trueBorrowedBook.borrowBook();
    }
  }

  // Deze method zoekt het boek op in de books List en zet de borrowed waarde op false.
  void returnBook(long id) {
    Book falseBorrowedBook = findID(id);
    if (falseBorrowedBook != null) {
      falseBorrowedBook.returnBook();
    }
  }

  // Deze method geeft alle boeken in de books List terug als een String,
  // per book de Titel en de Auteur.
  String showBooks() {
    String showAllBooks = "";
    for (Book book : allBooks) {
      showAllBooks += book.getTitleWithAuthor();
    }
    return showAllBooks;
  }
  
  // Deze method geeft alle geleende boeken in de books List terug als een String,
  // per book de Titel en de Auteur.
  String showBorrowedBooks() {
    String showAllBorrowedBooks = "";
    for (Book book : allBooks) {
      if (book.hasBeenBorrowed()) {
        showAllBorrowedBooks += book.getTitleWithAuthor();
        return showAllBorrowedBooks;
      }
    }
    return showAllBorrowedBooks;
  }

  // Deze method geeft alle beschikbare boeken in de books List terug als een String,
  // per book de Titel en de Auteur.
  String showAvailableBooks() {
    String showAllAvailableBooks = "";
    for (Book book : allBooks) {
      if (!book.hasBeenBorrowed()) {
        showAllAvailableBooks += book.getTitleWithAuthor();
        return showAllAvailableBooks;
      }
    }
    return showAllAvailableBooks;
  }
}

