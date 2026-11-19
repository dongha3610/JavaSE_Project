package mylab.library.entity;

import java.util.ArrayList;
import java.util.List;

public class Library {
	private List<Book> books; // 도서 목록
	private String name;      // 도서관 이름

	// 도서관 이름을 받고 빈 도서 목록 생성
	public Library(String name) {
		this.name = name;
		this.books = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	// 도서 추가
	public void addBook(Book book) {
		books.add(book);
		System.out.println("도서가 추가되었습니다: " + book.getTitle());
	}

	// 제목으로 검색 (첫 번째로 일치하는 도서, 없으면 null)
	public Book findBookByTitle(String title) {
		for (Book book : books) {
			if (book.getTitle().equals(title)) {
				return book;
			}
		}
		return null;
	}

	// 저자로 검색 (같은 저자의 책이 여러 권일 수 있으므로 List로 반환)
	public List<Book> findBooksByAuthor(String author) {
		List<Book> result = new ArrayList<>();
		for (Book book : books) {
			if (book.getAuthor().equals(author)) {
				result.add(book);
			}
		}
		return result;
	}

	// ISBN으로 검색 (없으면 null)
	public Book findBookByISBN(String isbn) {
		for (Book book : books) {
			if (book.getIsbn().equals(isbn)) {
				return book;
			}
		}
		return null;
	}

	// ISBN으로 대출: 도서가 있고 대출 가능할 때만 true
	public boolean checkOutBook(String isbn) {
		Book book = findBookByISBN(isbn);
		if (book != null) {
			return book.checkOut();
		}
		return false;
	}

	// ISBN으로 반납: 도서가 있고 대출 중일 때만 true
	public boolean returnBook(String isbn) {
		Book book = findBookByISBN(isbn);
		if (book != null && !book.isAvailable()) {
			book.returnBook();
			return true;
		}
		return false;
	}

	// 대출 가능한 도서 목록
	public List<Book> getAvailableBooks() {
		List<Book> result = new ArrayList<>();
		for (Book book : books) {
			if (book.isAvailable()) {
				result.add(book);
			}
		}
		return result;
	}

	// 전체 도서 목록
	public List<Book> getAllBooks() {
		return books;
	}

	public int getTotalBooks() {
		return books.size();
	}

	public int getAvailableBooksCount() {
		return getAvailableBooks().size();
	}

	public int getBorrowedBooksCount() {
		return getTotalBooks() - getAvailableBooksCount();
	}
}
