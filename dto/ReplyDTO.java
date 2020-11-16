package dto;

import java.util.Calendar;

public class ReplyDTO {
private int id;
private int BoardId;
private int writerdId;
public int getWriterdId() {
	return writerdId;
}
public void setWriterdId(int writerdId) {
	this.writerdId = writerdId;
}
private String content;
private Calendar writtenDate;
private Calendar updateDate;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getBoardId() {
	return BoardId;
}
public void setBoardId(int boardId) {
	BoardId = boardId;
}
public int getSritedrId() {
	return writerdId;
}
public void setSritedrId(int sritedrId) {
	this.writerdId = sritedrId;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
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
public boolean equals(Object o) {
	if(o instanceof ReplyDTO) {
		ReplyDTO r =(ReplyDTO)o;
		if(id == r.id) {
			return true;
		}
	}
	
	return false;
}


}
