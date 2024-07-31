import java.util.Arrays;
public class Library {
	private Book[] books;
    private int count;

    public Library(int capacity) {
        books = new Book[capacity];
        count = 0;
    }

    // Add a book to the library
    public void addBook(Book book) {
        if (count == books.length) {
            books = java.util.Arrays.copyOf(books, books.length * 2);
        }
        books[count++] = book;
    }

    // Linear search to find a book by title
    public Book linearSearchByTitle(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }
 // Binary search to find a book by title (assuming books are sorted by title)
    public Book binarySearchByTitle(String title) {
        int left = 0;
        int right = count - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = books[mid].getTitle().compareToIgnoreCase(title);
            if (cmp == 0) {
                return books[mid];
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        Library library = new Library(5);

        Book book1 = new Book("B001", "Yellowface", "R.F. Kuang");
        Book book2 = new Book("B002", "1984", "George Orwell");
        Book book3 = new Book("B003", "To Kill a Mockingbird", "Harper Lee");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        
        System.out.println("Search for '1984' (Linear Search):");
        System.out.println(library.linearSearchByTitle("1984"));
        System.out.println("Search for '1984' (Binary Search):");
        System.out.println(library.binarySearchByTitle("1984"));
    }

}
