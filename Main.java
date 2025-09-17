package assn02;

import java.util.Scanner;

class Book {
    String _title;
    String _author;
    boolean _checkedOut = false;
    boolean checkOut() {
        if (_checkedOut == false) {
            _checkedOut = true;
            return true;
        } else {
            System.out.println("Invalid book number!");
            return false;
        }
    }
    boolean returnBook() {
        if (_checkedOut == true) {
            _checkedOut = false;
            return true;
        } else {
            System.out.println("Invalid book number!");
            return false;
        }
    }

    void printBooks(Book[] list) {
        System.out.println("Books in Library:");
        for (int x=0; x<list.length; x++) {
            if (list[x] != null) {
                System.out.print((x + 1) + ". Title: " + list[x]._title + ", Author: " + list[x]._author + ", Checked Out: ");
                if (list[x]._checkedOut == true) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
    }

}

public class Main {
    public static void main(String[] args) {
        int choice = 10;
        int books = -1;
        Book[] list = new Book[5];
        while (choice>0) {
            System.out.println("Library Menu: \n0. Exit \n1. Add a Book \n2. Display All Books \n3. Check Out a Book \n4. Return a Book \nEnter your choice:");
            Scanner input = new Scanner(System.in);
            choice = Integer.valueOf(input.nextLine());
            if (choice == 0) {
                System.out.println("Bye for now!");
                System.exit(0);
            } else if (choice == 1) {
                books++;
                if (books<5) {
                    System.out.println("Enter book title:");
                    Book book = new Book();
                    book._title = input.nextLine();
                    System.out.println("Enter book author:");
                    book._author = input.nextLine();
                    System.out.println("Book added to library!");
                    list[books] = book;
                } else {
                    System.out.println("Book not added. Library is full!");
                }
            } else if (choice == 3) {
                System.out.println("Enter book number to check out:");
                int check = Integer.valueOf(input.nextLine());
                if (check > 0 && check < 6 && check <= books+1 && list[check-1]._checkedOut==false) {
                    list[check-1].checkOut();
                    System.out.println("Book checked out successfully!");
                } else {
                    System.out.println("Invalid book number!");
                }
            } else if (choice == 4) {
                System.out.println("Enter book number to return:");
                int check = Integer.valueOf(input.nextLine());
                if (check > 0 && check < 6 && check <= books+1 && list[check-1]._checkedOut==true) {
                    list[check-1].returnBook();
                    System.out.println("Book returned!");
                } else {
                    System.out.println("Invalid book number!");
                }

            } else if (choice == 2) {
                Book test = new Book();
                test.printBooks(list);
            }

            else {
                System.out.println("Invalid choice. Try again");
            }
        }
    }
}
