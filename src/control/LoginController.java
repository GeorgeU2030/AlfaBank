package control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.Main;
import javafx.scene.control.PasswordField;
public class LoginController {

	private static String passwordGeneral="123456";
	private static String userGeneral="Domiciano";
	@FXML
    private PasswordField passwordPF;

	    @FXML
	    private TextField userTF;

	    @FXML
	    void clickEnter(ActionEvent event) {

	    	String password = passwordPF.getText();
	    	String user = userTF.getText();
	    	if(user.equals(userGeneral)&&password.equals(passwordGeneral)) {
	    		try {
					chargeMenu();
					Stage stage = (Stage) passwordPF.getScene().getWindow();
					stage.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}else {
	    		Alert alert = new Alert(Alert.AlertType.ERROR);
	            alert.setHeaderText(null);
	            alert.setTitle("ERROR");
	            alert.setContentText("THE USER ISN'T REGISTERED OR PASSWORD IS INCORRECT");
	            alert.showAndWait();
	            passwordPF.setText("");
	            userTF.setText("");
	    	}
	    }
	    public void chargeMenu() throws Exception{
	    	FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/MenuWindow.fxml"));		
			loader.setController(new MenuController());
			Parent parent = (Parent) loader.load();
			
			Stage stage = new Stage();
			Scene scene = new Scene(parent);
			stage.setScene(scene);
			
			stage.show();
	    }
		public static String getPasswordGeneral() {
			return passwordGeneral;
		}
		public static void setPasswordGeneral(String passwordGeneral) {
			LoginController.passwordGeneral = passwordGeneral;
		}
		public static String getUserGeneral() {
			return userGeneral;
		}
		public static void setUserGeneral(String userGeneral) {
			LoginController.userGeneral = userGeneral;
		}
	    
}
