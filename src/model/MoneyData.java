package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MoneyData {

	private static ObservableList<Money> data= FXCollections.observableArrayList();

	public static ObservableList<Money> getData() {
		return data;
	}

	public static void setData(ObservableList<Money> data) {
		MoneyData.data = data;
	}
	
}
