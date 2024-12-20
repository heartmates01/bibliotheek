package nl.heartmates01;

// We gaan een simpel Bibliotheek Systeem maken. We hebben nodig:

// Een package system met daarin de classes Library en Book.
// Een package main met daarin de class Main waarin we de applicatie starten met de main method.

// Zorg er met access-modifiers voor dat de class Main niet direct kan bij de class Book,
// maar dat de class Library daar nog wel bij kan en diens methods kan gebruiken.

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

// Laat in de class Main zien dat je:

// Boeken kunt toevoegen
// Boeken kunt verwijderen
// Boeken kunt tonen
// Een lijst van boeken kunt tonen
// Een boek kunt lenen
// Een boek kunt terugbrengen
// Een lijst van geleende boeken kunt tonen
// Een lijst van beschikbare boeken kunt tonen

// Als dat lukt, mag je hier zoals in voorgaande opdrachten een menu voor maken,
// waarbij een gebruiker dit zelf allemaal via de console kan doen.

// Het belangrijkste is dat je kunt laten zien dat je weet hoe je met packages en encapsulation kan werken.

import java.util.Scanner;
import java.util.regex.Pattern;

class Bibliotheek {

  public static class Main {

    static Library library = new Library();

    public static void main(String[] args) {

      while (true) {
        System.out.println("""
             \s
             Library Management System
             \s
             1. Manage Singular Book
             2. Manage Multiple Books
             3. Exit
            """);

        String userChoice = userInput("Choose an option from the list:", Pattern.compile("[0-3]"),
            "Choose a valid option");

        switch (userChoice) {

          case "3":
            System.out.println("Exiting.");
            return;

          case "1":
            manageSingular();
            break;

          case "2":
            manageMultiple();
        }
      }
    }

    static void manageSingular() {
      while (true) {
        System.out.println("""
             \s
             Library Management System
             \s
             1. Add
             2. Remove
             3. Show
             4. Borrow or Return
             5. Exit
            """);

        String userChoice = userInput("Choose an option from the list:", Pattern.compile("[0-5]"),
            "Choose a valid option");

        switch (userChoice) {
          case "5":
            return;
          case "1":
            addBook();
            break;
          case "2":
            removeBook();
            break;
          case "3":
            showBook();
            break;
          case "4":
            int ID = Integer.parseInt(
                userInput("Book ID:", Pattern.compile("\\d+"), "Invalid ID."));
            Book book = Library.findID(ID);
            borrowOrReturn(book);
            break;
        }
      }
    }

    static void manageMultiple() {
      while (true) {
        System.out.println("""
             \s
             Library Management System
             \s
             1. Show All
             2. Show All Available
             3. Show All Borrowed
             4. Exit
            """);

        String userChoice = userInput("Choose an option from the list:", Pattern.compile("[0-4]"),
            "Choose a valid option");
        switch (userChoice) {
          case "4":
            return;
          case "1":
            showBooks();
            break;
          case "2":
            showAvailable();
            break;
          case "3":
            showBorrowed();
            break;
        }
      }
    }

    static void addBook() {
      long id = Long.parseLong(
          userInput("Book ID (10 int): ", Pattern.compile("\\d{10}"), "Invalid ID."));
      String title = userInput("Book Title: ", null, null);
      String author = userInput("Book Author: ", null, null);
      int pages = Integer.parseInt(
          userInput("Number of Pages: ", Pattern.compile("\\d+"),
              "Invalid number of pages"));
      String isbn = userInput("Book ISBN (13 int)", Pattern.compile("\\d{13}"),
          "Invalid ISBN");
      boolean borrowed = Boolean.parseBoolean(
          userInput("Currently being borrowed(T/F): ", Pattern.compile("true|True|false|False"),
              "Invalid input."));
      library.addBook(id, title, author, pages, isbn, borrowed);
    }

    static void removeBook() {
      long id = Long.parseLong(userInput("The ID of the book?", Pattern.compile("\\d{10}"),
          "Invalid ID, or not in list."));
      library.removeBook(id);
    }

    static void showBook() {
      long id = Long.parseLong(userInput("The ID of the book?", Pattern.compile("\\d{10}"),
          "Invalid ID, or not in list."));
      System.out.println(library.showBook(id));
    }

    static void borrowOrReturn(Book book) {
      System.out.println("""
          \s
          Library Management System
          \s
          1. Borrow
          2. Return
          3. Exit to previous menu.""");

      int borrowOrReturn = Integer.parseInt(
          userInput("Choose an option from the list.", Pattern.compile("[0-3]"),
              "Choose a valid option."));

      if (borrowOrReturn == 3) {
        System.out.println("Exiting to magazine menu.");
        return;

      } else if (borrowOrReturn == 1) {
        Book.borrowBook(book);
        System.out.println("Book has been borrowed.");

      } else if (borrowOrReturn == 2) {
        Book.returnBook(book);
        System.out.println("Book has been returned.");
      }
    }

    static void showBooks() {
      System.out.println(library.showBooks());
    }

    static void showBorrowed() {
      System.out.println(library.showBorrowedBooks());
    }

    static void showAvailable() {
      System.out.println(library.showAvailableBooks());
    }
  }

  static Scanner scanner = new Scanner(System.in);

  static String userInput(String question, Pattern pattern, String errorMessage) {
    System.out.println(question);

    if (pattern != null) {
      while (!scanner.hasNext(pattern)) {
        System.out.println(errorMessage);
        scanner.next();
      }
    }
    return scanner.nextLine();
  }
}
