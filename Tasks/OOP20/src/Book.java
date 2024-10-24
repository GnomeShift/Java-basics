class Book {
    String title;
    String author;
    int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }
}

class Library {
    Book[] books;

    Library(Book[] books) {
        this.books = books;
    }

    void addBook(Book book) {
        Book[] newBooks = new Book[books.length + 1];
        System.arraycopy(books, 0, newBooks, 0, books.length);
        newBooks[books.length] = book;
        books = newBooks;
    }

    Book[] byAuthor(String author) {
        int count = 0;
        for (Book book : books) {
            if (book.author.equals(author)) {
                count++;
            }
        }

        Book[] found = new Book[count];
        int index = 0;
        for (Book book : books) {
            if (book.author.equals(author)) {
                System.out.println(book.title);
                found[index++] = book;
            }
        }

        return found;
    }

    Book[] byYear(int year) {
        int count = 0;
        for (Book book : books) {
            if (book.year == year) {
                count++;
            }
        }

        Book[] found = new Book[count];
        int index = 0;
        for (Book book : books) {
            if (book.year == year) {
                System.out.println(book.title);
                found[index++] = book;
            }
        }

        return found;
    }
}

class Main {
    public static void main(String[] args) {
        Book[] books = {
                new Book("Книга 1", "Автор 1", 2020),
                new Book("Книга 2", "Автор 2", 2021),
                new Book("Книга 3", "Автор 3", 2022)
        };

        Library library = new Library(books);

        Book[] found = library.byAuthor("Автор 1");
        Book[] found2 = library.byYear(2021);
    }
}