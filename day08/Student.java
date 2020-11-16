package day08;

import java.util.Calendar;
import java.util.Scanner;

public class Student {
	private int id;
	private int idd;
	private Calendar writtenDate;
	private Calendar updateDate;
	private String name;
	private int korean;
	private int english;
	private int math;
	private final int SUBJECT_SIZE = 3;
	
	

	public Calendar getWrittenDate() {
		return writtenDate;
	}

	public void setWrittenDate(Calendar writtenDate) {
		this.writtenDate = writtenDate;
	}

	public Calendar getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Calendar updateDate) {
		this.updateDate = updateDate;
	}

	public int getIdd() {
		return idd;
	}

	public void setIdd(int idd) {
		this.idd = idd;
	}

	public int caluclateSum() {

		return korean + english + math;
	}

	public double calculateAverage() {
		return caluclateSum() / (double) SUBJECT_SIZE;
	}

	public void setId(int id) {
		this.id = id;

	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;

	}

	public String getName() {
		return name;
	}

	public void setKorean(int korean) {
		this.korean = korean;
	}

	public int getKorean() {
		return korean;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getEnglish() {
		return english;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getMath() {
		return math;
	}

	public String toString() {
		return "id: " + id + ", name: " + name + ",korean: " + korean + ",english: " + english + ", math: " + math;

	}
	
	
	public void printInfo() {
		System.out.printf("번호: %d번 이름: %s\n ",id,name);
		System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n",korean,english,math);
		System.out.printf("총점: %03d점 평균: %.2f점\n",caluclateSum(),calculateAverage());
	}
}
