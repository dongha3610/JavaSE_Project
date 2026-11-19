package mylab.library.entity;

public class Book {
	// 캡슐화: 모든 필드는 private
	private String title;       // 제목
	private String author;      // 저자
	private String isbn;        // ISBN
	private int publishYear;    // 출판년도
	private boolean isAvailable; // 대출 가능 여부

	// 기본 생성자: 처음 생성된 도서는 대출 가능 상태
	public Book() {
		this.isAvailable = true;
	}

	public Book(String title, String author, String isbn, int publishYear) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.publishYear = publishYear;
		this.isAvailable = true;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}

	// boolean 타입의 getter는 관례상 is로 시작
	// 대출 상태는 setter 대신 checkOut()/returnBook()으로만 변경
	public boolean isAvailable() {
		return isAvailable;
	}

	// 대출 가능하면 대출 처리 후 true, 이미 대출 중이면 false
	public boolean checkOut() {
		if (isAvailable) {
			isAvailable = false;
			return true;
		}
		return false;
	}

	// 반납 처리
	public void returnBook() {
		isAvailable = true;
	}

	@Override
	public String toString() {
		String status;
		if (isAvailable) {
			status = "가능";
		} else {
			status = "대출 중";
		}

		return "책 제목: " + title
				+ "\t저자: " + author
				+ "\tISBN: " + isbn
				+ "\t출판년도: " + publishYear
				+ "\t대출 가능 여부: " + status;
	}
}
