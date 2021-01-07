package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Button btTeste;
    @FXML
    private TextField txtNumber1;
    @FXML
    private TextField txtNumber2;

    @FXML
    private Label labelResult;

//    @FXML
//    public void onBtTestAction(){
////        Alerts.showAlert("Alert title", "Alert header", "Hello World", Alert.AlertType.INFORMATION);
//    }

    public void onBtSumAction(){
        try{
            Locale.setDefault(Locale.US);
            double number1 = Double.parseDouble(txtNumber1.getText());
            double number2 = Double.parseDouble(txtNumber2.getText());
            double sum = number1 + number2;
            labelResult.setText(String.format("%.2f", sum));
        }catch(NumberFormatException e){
            Alerts.showAlert("Error", "Parse error", e.getMessage(), Alert.AlertType.ERROR);
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Constraints.setTextFieldDouble(txtNumber1);
        Constraints.setTextFieldDouble(txtNumber2);
        Constraints.setTextFieldMaxLength(txtNumber1, 12);
        Constraints.setTextFieldMaxLength(txtNumber2, 12);
    }
}
