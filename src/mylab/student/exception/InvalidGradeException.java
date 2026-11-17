package mylab.student.exception;

//학년(grade)이 허용 범위(1~4)를 벗어났을 때 사용하는 사용자정의 Exception 클래스
 
public class InvalidGradeException extends Exception {

	public InvalidGradeException(String message) {
		super(message);
	}
}
