package control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import main.Main;
import model.Money;
public class ProfileController implements Initializable{

	@FXML
    private Label balanceLabel;

    @FXML
    private Label expensesLabel;

    @FXML
    private Label incomeLabel;

    @FXML
    private Label passwordLabel;

    @FXML
    private Label userLabel;
    
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
		userLabel.setText(LoginController.getUserGeneral());
		passwordLabel.setText(LoginController.getPasswordGeneral());
	}
}
