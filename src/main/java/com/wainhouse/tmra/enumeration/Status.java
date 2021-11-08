package com.wainhouse.tmra.enumeration;

public enum Status {
	TASK_COMPLETED("Completed");
	TASK_NOT_COMPLETED("Not Completed");
	
	private final String status;
	
	Status(String string) {
		this.status = string;
	}
	
	public String getStatus() {
		return this.status;
	}
}
