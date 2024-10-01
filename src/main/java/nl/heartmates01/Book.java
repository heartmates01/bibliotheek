package nl.heartmates01;

// De class Book heeft de volgende members (velden)
// LETOP: Andere classes mogen niet direct bij deze members kunnen:

// id (long)
// title (String)
// author (String)
// pages (int)
// isbn (String)
// borrowed (boolean)

// De class Book heeft de volgende methods:

// long getId()

// boolean hasBeenBorrowed()
// Deze method geeft de waarde van borrowed terug.

// String getTitleWithAuthor()
// Deze method geeft de titel en de auteur van het boek terug als een String.

// String toString()
// Deze method geeft alle informatie van het boek terug als een String
// (tip: gebruik een String template """).'

// void borrowBook()
// Deze method zet de borrowed waarde op true.

// void returnBook()
// Deze method zet de borrowed waarde op false.

// + all under (String) toString()

// (long) id
// |_ (long) getId()

// (String) title
// |_ (String) getTitleWithAuthor()

// (String) author
// |_ (String) getTitleWithAuthor()

// (int) pages

// (String) isbn

// (boolean) borrowed
// |_ (boolean) hasBeenBorrowed()
// |_ (void) borrowBook()
// |_ (void) returnBook()

class Book {

  private final long id;
  private final String title;
  private final String author;
  private final int pages;
  private final String isbn;
  private boolean borrowed;

  Book(long id, String title, String author, int pages, String isbn, boolean borrowed) {

    this.id = id;
    this.title = title;
    this.author = author;
    this.pages = pages;
    this.isbn = isbn;
    this.borrowed = borrowed;
  }

  long getId() {
    return id;
  }

  // Deze method geeft de waarde van borrowed terug.
  public boolean hasBeenBorrowed() {
    return borrowed;
  }

  // Deze method geeft de titel en de auteur van het boek terug als een String.
  public String getTitleWithAuthor() {
    return title + "\n" + author + "\n" + "\n";
  }

  // Deze method geeft alle informatie van het boek terug als een String
// (tip: gebruik een String template """).'
  public String toString() {
    return id + "\n" + title + "\n" + author + "\n" + pages + "\n" + isbn + "\n" + borrowed + "\n"
        + "\n";
  }

  // void borrowBook()
// Deze method zet de borrowed waarde op true.
  void borrowBook() {
    borrowed = true;
  }

  // void returnBook()
// Deze method zet de borrowed waarde op false.
  void returnBook() {
    borrowed = false;
  }
}