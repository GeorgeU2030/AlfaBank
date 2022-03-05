package control;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import main.Main;
import model.Money;
import model.MoneyData;
public class FilterDataController implements Initializable{

	private int incomes;
	private int expenses;
	private int balance;
	private ObservableList<Money> datesRange= FXCollections.observableArrayList();

	@FXML
    private TableColumn<Money, Integer> amountColumn;

    @FXML
    private Label balanceLabel;

    @FXML
    private TableColumn<Money, String> dateColumn;

    @FXML
    private DatePicker dateInitDP;

    @FXML
    private TableView<Money> dateTable;

    @FXML
    private Label expensesLabel;

    @FXML
    private DatePicker finalDateDP;

    @FXML
    private Label incomeLabel;

    @FXML
    private TableColumn<Money, String> typeColumn;

    @FXML
    void backMenu(ActionEvent event) {
    	   try {
   			showMenu();
   			Stage stage = (Stage) incomeLabel.getScene().getWindow();
   			stage.close();
   		} catch (Exception e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
    }

    @FXML
    void exitApp(ActionEvent event) {
    	Platform.exit();
        System.exit(0);
    }
    @FXML
    void searchDate(ActionEvent event) {
    	typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
		amountColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
		dateColumn.setCellValueFactory(new PropertyValueFactory<>("dateS"));
		String dateI = String.valueOf(dateInitDP.getValue());
		String dateF = String.valueOf(finalDateDP.getValue());
		try {
			Date dateID = new SimpleDateFormat("yyyy-MM-dd").parse(dateI);
			Date dateFD = new SimpleDateFormat("yyyy-MM-dd").parse(dateF);
			for(int i=0;i<MoneyData.getData().size();i++) {
				Date variableTime=MoneyData.getData().get(i).getDate();
				if(variableTime.getTime()>dateID.getTime()&&variableTime.getTime()<dateFD.getTime()) {
					datesRange.add(MoneyData.getData().get(i));
				}
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dateTable.setItems(datesRange);
		for(int i=0;i<datesRange.size();i++) {
			if(datesRange.get(i).getType().equals("Income")) {
				incomes+=datesRange.get(i).getValue();
			}else {
				expenses+=datesRange.get(i).getValue();
			}
		}
		balance = incomes-expenses;
		String incomeS = String.valueOf(incomes);
		String expensesS = String.valueOf(expenses);
		String balanceS = String.valueOf(balance);
		incomeLabel.setText(incomeS);
	    expensesLabel.setText(expensesS);
		balanceLabel.setText(balanceS);
    }

	public ObservableList<Money> getDatesRange() {
		return datesRange;
	}

	public void setDatesRange(ObservableList<Money> datesRange) {
		this.datesRange = datesRange;
	}
	   public void showMenu()throws Exception {
	    	FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/MenuWindow.fxml"));		
			loader.setController(new MenuController());
			Parent parent = (Parent) loader.load();
			
			Stage stage = new Stage();
			Scene scene = new Scene(parent);
			stage.setScene(scene);
			
			stage.show();
	    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		int money = Money.getIncomesTotal();
		int money2 = Money.getExpensesTotal();
		String moneyI = String.valueOf(money);
		String moneyE = String.valueOf(money2);
		int balance = money-money2;
		String balanceS = String.valueOf(balance);
		incomeLabel.setText(moneyI);
		expensesLabel.setText(moneyE);
		balanceLabel.setText(balanceS);
	}

    
	
}
