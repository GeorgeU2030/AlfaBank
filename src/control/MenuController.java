package control;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import main.Main;
import model.Money;
import model.MoneyData;
public class MenuController implements Initializable{

	private Money tempMoney;
	@FXML
    private Label balanceLabel;

    @FXML
    private TableView<Money> dateTable;

    @FXML
    private TableColumn<Money, Integer> amountColumn;

    @FXML
    private Label expensesLabel;

    @FXML
    private TableColumn<Money, String> typeColumn;

    @FXML
    private Label incomeLabel;

    @FXML
    void filterData(ActionEvent event) throws Exception{
    	FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/FilterData.fxml"));		
		loader.setController(new FilterDataController());
		Parent parent = (Parent) loader.load();
		
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		
		stage.show();
		Stage stage2 = (Stage) incomeLabel.getScene().getWindow();
		stage2.close();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
		amountColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
		dateTable.setItems(MoneyData.getData());
		int money = Money.getIncomesTotal();
		int money2 = Money.getExpensesTotal();
		String moneyI = String.valueOf(money);
		String moneyE = String.valueOf(money2);
		int balance = money-money2;
		String balanceS = String.valueOf(balance);
		incomeLabel.setText(moneyI);
		expensesLabel.setText(moneyE);
		balanceLabel.setText(balanceS);
		dateTable.setOnMouseClicked(
				event->{
					tempMoney = dateTable.getSelectionModel().getSelectedItem();
				}
				);
	}
	public void launchRegister() throws Exception {
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/RegisterWindow.fxml"));		
		loader.setController(new RegisterController());
		Parent parent = (Parent) loader.load();
		
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		
		stage.show();
	}
	@FXML
    void registerMoney(ActionEvent event) {
try {
	launchRegister();
	Stage stage = (Stage) expensesLabel.getScene().getWindow();
	stage.close();
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
    }
	@FXML
    void clickDelete(ActionEvent event) {
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setHeaderText(null);
		alert.setTitle("Confirmation");
		alert.setContentText("¿Are you sure that delete the Action?");
		Optional<ButtonType> action = alert.showAndWait();
		if (action.get() == ButtonType.OK) {
			 MoneyData.getData().remove(tempMoney);
		      if( tempMoney.getType().equals("Income")){
		    	 int valuetemp = Money.getIncomesTotal();
		    	 valuetemp= valuetemp-tempMoney.getValue();
		    	 Money.setIncomesTotal(valuetemp);
		      }else {
		    	  int valuetemp = Money.getExpensesTotal();
		     	 valuetemp= valuetemp-tempMoney.getValue();
		     	 Money.setExpensesTotal(valuetemp);
		     	 
		      }
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
	@FXML
    void clickLogout(ActionEvent event)throws Exception {
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/LoginWindow.fxml"));		
		loader.setController(new LoginController());
		Parent parent = (Parent) loader.load();
		
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		
		stage.show();
		Stage stage2 = (Stage) incomeLabel.getScene().getWindow();
		stage2.close();
    }

    @FXML
    void clickProfile(ActionEvent event)throws Exception {
    	FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/ProfileWindow.fxml"));		
		loader.setController(new ProfileController());
		Parent parent = (Parent) loader.load();
		
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		
		stage.show();
		Stage stage2 = (Stage) incomeLabel.getScene().getWindow();
		stage2.close();
    }

	
}
