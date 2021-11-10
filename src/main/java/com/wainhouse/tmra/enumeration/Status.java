package com.wainhouse.tmra.enumeration;

public enum Status {
	TASK_NOT_COMPLETED("Not-Completed");
	TASK_COMPLETED("Completed");
	
	
	private final String status;
	
	Status(String string) {
		this.status = string;
	}
	
	public String getStatus() {
		return this.status;
	}
}
