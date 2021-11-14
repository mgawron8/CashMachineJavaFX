package rocks.zipcode.atm;

import com.sun.tools.javac.comp.Flow;
import javafx.scene.control.ComboBox;
import rocks.zipcode.atm.bank.AccountData;
import rocks.zipcode.atm.bank.Bank;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;

/**
 * @author ZipCodeWilmington
 */
public class CashMachineApp extends Application {

    private TextField fieldlogin = new TextField();
    private TextField fielddeposit = new TextField();
    private TextField fieldwithdraw = new TextField();
    private CashMachine cashMachine = new CashMachine(new Bank());

    private Parent createContent() {
        VBox vbox = new VBox(10);
        vbox.setPrefSize(600, 600);
        vbox.setStyle("");

        TextArea areaInfo = new TextArea();

        Button btnSubmit = new Button("Login");
        Button btnDeposit = new Button("Deposit");
        Button btnWithdraw = new Button("Withdraw");
        Button btnLogOut = new Button("Logout");
        Button btnNewAccount = new Button("Create New Account");

        btnDeposit.setDisable(true);
        btnWithdraw.setDisable(true);
        btnLogOut.setDisable(true);


        ComboBox loginChoices = new ComboBox();
        loginChoices.getItems().add("1");
        loginChoices.getItems().add("2");
        loginChoices.getItems().add("911");
        loginChoices.getItems().add("1000");
        loginChoices.getItems().add("2000");



        // code for what the login button does
        btnSubmit.setOnAction(e -> {
            String loginChoice = (String) loginChoices.getValue();
            int id = Integer.parseInt(loginChoice);
            cashMachine.login(id);
            fieldlogin.setText("");
            btnDeposit.setDisable(false);
            btnWithdraw.setDisable(false);
            btnLogOut.setDisable(false);
            btnSubmit.setDisable(true);
            btnNewAccount.setDisable(true);
            areaInfo.setText(cashMachine.toString());

        });

        //code for what the deposit button does
        btnDeposit.setOnAction(e -> {
            Float amount = Float.parseFloat(fielddeposit.getText());
            cashMachine.deposit(amount);
            fielddeposit.setText("");
            areaInfo.setText(cashMachine.toString());
        });

       //code for what the withdraw button does
        btnWithdraw.setOnAction(e -> {
            Float amount = Float.parseFloat(fieldwithdraw.getText());
            cashMachine.withdraw(amount);
            fieldwithdraw.setText("");
            areaInfo.setText(cashMachine.toString());
        });

        //code for what the logout button does
        btnLogOut.setOnAction(e -> {
            cashMachine.logOut();
            btnDeposit.setDisable(true);
            btnWithdraw.setDisable(true);
            btnLogOut.setDisable(true);
            btnSubmit.setDisable(false);
            btnNewAccount.setDisable(false);
            areaInfo.setText(cashMachine.toString());
        });
        //code for create a new account button
        btnNewAccount.setOnAction(e ->{

        });

        FlowPane flowpaneID = new FlowPane();
        flowpaneID.getChildren().add(loginChoices);
        flowpaneID.getChildren().add(btnSubmit);
        flowpaneID.getChildren().add(btnLogOut);

        FlowPane flowpaneDeposit = new FlowPane();
        flowpaneDeposit.getChildren().add(fielddeposit);
        flowpaneDeposit.getChildren().add(btnDeposit);

        FlowPane flowpaneWithdraw = new FlowPane();
        flowpaneWithdraw.getChildren().add(fieldwithdraw);
        flowpaneWithdraw.getChildren().add(btnWithdraw);

        vbox.getChildren().addAll(flowpaneID,flowpaneDeposit,flowpaneWithdraw, areaInfo,btnNewAccount);
        return vbox;
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(createContent()));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
