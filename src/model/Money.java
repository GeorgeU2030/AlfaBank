package model;

import java.util.Date;


public class Money {

	private static int incomesTotal;
	private static int expensesTotal;
	private int value;
	private String description;
	private String type;
	private String dateS;
	private Date date;
	public Money(int value, String description, String type,String dateS,Date date) {
		this.value = value;
		this.description = description;
		this.type=type;
		this.date=date;
		this.dateS=dateS;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public static int getIncomesTotal() {
		return incomesTotal;
	}
	public static void setIncomesTotal(int incomesTotal) {
		Money.incomesTotal = incomesTotal;
	}
	public static int getExpensesTotal() {
		return expensesTotal;
	}
	public static void setExpensesTotal(int expensesTotal) {
		Money.expensesTotal = expensesTotal;
	}
	public String getDateS() {
		return dateS;
	}
	public void setDateS(String dateS) {
		this.dateS = dateS;
	}
	
	
	
}
