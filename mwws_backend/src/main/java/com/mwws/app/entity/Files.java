package com.mwws.app.entity;

public class Files {

	private String fileName;
	private String fileDescription;
	private String path;
	public Files(String fileName, String fileDescription, String path) {
		super();
		this.fileName = fileName;
		this.fileDescription = fileDescription;
		this.path = path;
	}
	public Files() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileDescription() {
		return fileDescription;
	}
	public void setFileDescription(String fileDescription) {
		this.fileDescription = fileDescription;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}
