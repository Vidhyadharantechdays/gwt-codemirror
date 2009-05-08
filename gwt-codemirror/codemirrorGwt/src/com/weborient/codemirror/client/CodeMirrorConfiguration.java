package com.weborient.codemirror.client;

public class CodeMirrorConfiguration {
	
	private String height;
	private String width;
	private boolean readOnly = false;
	private int continuousScanning;
	private boolean lineNumbers = true;
	private boolean textWrapping;
	private String styleUrl;
	private String[] listBoxPreInsert;
	
	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public boolean isReadOnly() {
		return readOnly;
	}

	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}

	public int getContinuousScanning() {
		return continuousScanning;
	}

	public void setContinuousScanning(int continuousScanning) {
		this.continuousScanning = continuousScanning;
	}

	public boolean isLineNumbers() {
		return lineNumbers;
	}

	public void setLineNumbers(boolean lineNumbers) {
		this.lineNumbers = lineNumbers;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public boolean isTextWrapping() {
		return textWrapping;
	}

	public void setTextWrapping(boolean textWrapping) {
		this.textWrapping = textWrapping;
	}

	public String getStyleUrl() {
		return styleUrl;
	}

	public void setStyleUrl(String styleUrl) {
		this.styleUrl = styleUrl;
	}

	public String[] getListBoxPreInsert() {
		return listBoxPreInsert;
	}

	public void setListBoxPreInsert(String[] listBoxPreInsert, String... o) {
		this.listBoxPreInsert = listBoxPreInsert;
	}
	
	public void setListBoxPreInsert(String... listBoxPreInsert) {
		this.listBoxPreInsert = listBoxPreInsert;
	}
}
