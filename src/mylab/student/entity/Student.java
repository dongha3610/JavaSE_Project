package mylab.student.entity;

import mylab.student.exception.InvalidGradeException;

public class Student {
	// 캡슐화: 모든 필드는 private
	private String studentId; // 학번
	private String name;      // 이름
	private String major;     // 전공
	private int grade;        // 학년

	public Student(String studentId, String name, String major, int grade) throws InvalidGradeException {
		setStudentId(studentId);
		setName(name);
		setMajor(major);
		// 생성할 때도 학년 검사를 하기 위해 setter를 호출한다.
		setGrade(grade);
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getGrade() {
		return grade;
	}

	// 학년은 1~4 까지만 허용, 범위를 벗어나면 예외를 발생시킨다.
	public void setGrade(int grade) throws InvalidGradeException {
		if (grade < 1 || grade > 4) {
			throw new InvalidGradeException("학년은 1~4 사이의 값이어야 합니다.");
		}
		this.grade = grade;
	}
}
