package control;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.Main;
import model.Money;
import model.MoneyData;
public class RegisterController implements Initializable {

	private String type;
	@FXML
    private Label balanceLabel;

    @FXML
    private DatePicker dateDP;

    @FXML
    private TextArea descriptionTA;

    @FXML
    private Label expensesLabel;

    @FXML
    private Label incomeLabel;

    @FXML
    private TextField valueTF;

    @FXML
    void addAction(ActionEvent event) {
    int value = Integer.parseInt(valueTF.getText());
    if(type.equals("Income")) {
     int money = Money.getIncomesTotal();
     money += value;
     Money.setIncomesTotal(money);
    }else {
    	int money = Money.getExpensesTotal();
        money += value;
        Money.setExpensesTotal(money);
    }
    String description = descriptionTA.getText();
    String dates = String.valueOf(dateDP.getValue());
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dates);
			MoneyData.getData().add(new Money(value,description,type,dates,date));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			showMenu();
			Stage stage = (Stage) valueTF.getScene().getWindow();
			stage.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
    

    @FXML
    void backMenu(ActionEvent event) {
        try {
			showMenu();
			Stage stage = (Stage) valueTF.getScene().getWindow();
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
    void expenseClick(ActionEvent event) {
    type="Expense";
    }

    @FXML
    void incomeClick(ActionEvent event) {
    type="Income";
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
