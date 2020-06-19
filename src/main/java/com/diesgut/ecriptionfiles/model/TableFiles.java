package com.diesgut.ecriptionfiles.model;

public class TableFiles {

	private Long idTable;
	private String fileName;
	private byte[] file;

	public TableFiles() {
		super();
	}

	public Long getIdTable() {
		return idTable;
	}

	public void setIdTable(Long idTable) {
		this.idTable = idTable;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

}
