package day08;

public class 연2 {private int id;
private String name;
private int korean;
private int english;
private int math;
private final int SUBJECT_SIZE = 3;

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
return "id: "+id+
		", name: "+name+
		",korean: "+korean+
		",english: "+english+
        ", math: "+math;

}

}
