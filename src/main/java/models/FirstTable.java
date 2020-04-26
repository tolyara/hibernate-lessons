package main.java.models;

public class FirstTable {
	
	private int id;
	
	private String column;
	
	public FirstTable() {
		
	}

	public FirstTable(String column) {
		this.column = column;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

}
