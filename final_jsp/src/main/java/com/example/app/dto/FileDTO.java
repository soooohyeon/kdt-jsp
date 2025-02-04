package com.example.app.dto;

public class FileDTO {
//	CREATE TABLE tbl_file(
//		file_system_name VARCHAR2(300),
//		file_original_name VARCHAR2(300),
//		board_number NUMBER,
//		CONSTRAINT pk_file PRIMARY KEY(file_system_name),
//		CONSTRAINT fk_file FOREIGN KEY (board_number) REFERENCES tbl_board (board_number)
//	);
	
	private String fileSystemName;
	private String fileOriginalName;
	private int boardNumber;
	
	public String getFileSystemName() {
		return fileSystemName;
	}
	public void setFileSystemName(String fileSystemName) {
		this.fileSystemName = fileSystemName;
	}
	public String getFileOriginalName() {
		return fileOriginalName;
	}
	public void setFileOriginalName(String fileOriginalName) {
		this.fileOriginalName = fileOriginalName;
	}
	public int getBoardNumber() {
		return boardNumber;
	}
	public void setBoardNumber(int boardNumber) {
		this.boardNumber = boardNumber;
	}
	
	@Override
	public String toString() {
		return "FileDTO [boardNumber=" + boardNumber + ", fileOriginalName=" + fileOriginalName + ", fileSystemName="
				+ fileSystemName + "]";
	}
	
}
