package mylab.student.exception;

/*
 * 학년(grade)이 허용 범위(1~4)를 벗어났을 때 사용하는 사용자정의 Exception 클래스
 */
public class InvalidGradeException extends Exception {

	public InvalidGradeException(String message) {
		// 부모 클래스(Exception)의 생성자를 호출해서 메시지를 저장한다.
		super(message);
	}
}
