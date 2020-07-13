package com.company.compoundinterest.StartingPrincipal;

import com.company.compoundinterest.AnnuityPayment.AnnuityPayment;
import com.company.compoundinterest.AnnuityPayment.controllers.AnnuityPaymentController;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class StartingPrincipal {
    public static void selectTextField(TextField textfield) { selectedTextField = textfield; }
    public static TextField selectedTextField;

    public static void displayStartingPrincipal( Stage savingsCalculator, Scene mainScene, Scene compoundInterestScene) {
        savingsCalculator.setTitle("Finance Calculator - Start Principal");

        AnchorPane rootSavingsCalculator = new AnchorPane();
        rootSavingsCalculator.setPadding(new Insets(30, 40, 40, 40));

        AnchorPane dataEnteringSection = new AnchorPane();
        dataEnteringSection.setPadding(new Insets(10, 10, 10, 10));

        AnchorPane resultSection = new AnchorPane();
        dataEnteringSection.setPadding(new Insets(10, 10, 10, 10));

        AnchorPane numberPadRoot = new AnchorPane();
        numberPadRoot.setPadding(new Insets(5, 45, 20, 45));


         // --------------- Cal Buttons -------------

        // FV Button.
        Button fvButton = new Button("FV");
        AnchorPane.setTopAnchor(fvButton, 20.0);
        AnchorPane.setLeftAnchor(fvButton, 20.0);
        fvButton.setFont(Font.font("Arial", FontWeight.NORMAL, 15));
        fvButton.setMinWidth(60);
        fvButton.setMaxHeight(40);

        fvButton.setOnAction(e -> {
            savingsCalculator.setTitle("Finance Calculator - Future Value Calculator");
            savingsCalculator.setScene(compoundInterestScene);
        });

        // PMT Button.
        Button pmtButton = new Button("PMT");
        pmtButton.setOnAction(e -> AnnuityPayment.displayAnnuityPayment(savingsCalculator, mainScene, compoundInterestScene));
        AnchorPane.setTopAnchor(pmtButton, 20.0);
        AnchorPane.setLeftAnchor(pmtButton, 90.0);
        pmtButton.setFont(Font.font("Arial", FontWeight.NORMAL, 15));
        pmtButton.setMinWidth(60);
        pmtButton.setMaxHeight(40);

        // I/Y Button.
        Button iyButton = new Button("I/Y");
        AnchorPane.setTopAnchor(iyButton, 20.0);
        AnchorPane.setLeftAnchor(iyButton, 160.0);
        iyButton.setFont(Font.font("Arial", FontWeight.NORMAL, 15));
        iyButton.setMinWidth(60);
        iyButton.setMaxHeight(40);

        // N Button.
        Button nButton = new Button("N");
        AnchorPane.setTopAnchor(nButton, 20.0);
        AnchorPane.setLeftAnchor(nButton, 230.0);
        nButton.setFont(Font.font("Arial", FontWeight.NORMAL, 15));
        nButton.setMinWidth(60);
        nButton.setMaxHeight(40);

        // Start Principal Button.
        Button startPrincipalButton = new Button("SP");
        AnchorPane.setTopAnchor(startPrincipalButton, 20.0);
        AnchorPane.setLeftAnchor(startPrincipalButton, 300.0);
        startPrincipalButton.setFont(Font.font("Arial", FontWeight.NORMAL, 15));
        startPrincipalButton.setMinWidth(60);
        startPrincipalButton.setMaxHeight(40);

        // ------------ data input section -----------------

        // Future Value.
        Label futureValueLabel = new Label("Future Value : $");
        AnchorPane.setTopAnchor(futureValueLabel, 67.0);
        AnchorPane.setLeftAnchor(futureValueLabel, 20.0);

        TextField futureValueTextField = new TextField();
        futureValueTextField.setOnMouseClicked(e -> selectTextField(futureValueTextField));
        AnchorPane.setTopAnchor(futureValueTextField, 70.0);
        AnchorPane.setLeftAnchor(futureValueTextField, 180.0);
        AnchorPane.setRightAnchor(futureValueTextField, 20.0);

        // No of Periods.
        Label noPeriodsLabel = new Label("No of Periods : $ ");
        AnchorPane.setTopAnchor(noPeriodsLabel, 117.0);
        AnchorPane.setLeftAnchor(noPeriodsLabel, 20.0);

        TextField noPeriodsTextField = new TextField();
        noPeriodsTextField.setOnMouseClicked(e -> selectTextField(noPeriodsTextField));
        AnchorPane.setTopAnchor(noPeriodsTextField, 120.0);
        AnchorPane.setLeftAnchor(noPeriodsTextField, 180.0);
        AnchorPane.setRightAnchor(noPeriodsTextField, 20.0);

        // I/Y (Interest).
        Label interestLabel = new Label("I/Y (Interest) :  ");
        AnchorPane.setTopAnchor(interestLabel, 164.0);
        AnchorPane.setLeftAnchor(interestLabel, 20.0);

        TextField interestTextField = new TextField();
        interestTextField.setOnMouseClicked(e -> selectTextField(interestTextField));
        AnchorPane.setTopAnchor(interestTextField, 167.0);
        AnchorPane.setLeftAnchor(interestTextField, 180.0);

        // Percentage mark for Interest.
        Label percentageMarkLabel = new Label("%");
        AnchorPane.setTopAnchor(percentageMarkLabel, 170.0);
        AnchorPane.setLeftAnchor(percentageMarkLabel, 360.0);

        // Start Principal.
        Label startPrincipalLabel = new Label("Start Principal : $ ");
        AnchorPane.setTopAnchor(startPrincipalLabel, 211.0);
        AnchorPane.setLeftAnchor(startPrincipalLabel, 20.0);

        TextField startPrincipalTextField = new TextField();
        startPrincipalTextField.setOnMouseClicked(e -> selectTextField(startPrincipalTextField));
        AnchorPane.setTopAnchor(startPrincipalTextField, 214.0);
        AnchorPane.setLeftAnchor(startPrincipalTextField, 180.0);
        AnchorPane.setRightAnchor(startPrincipalTextField, 20.0);


        // Calculate Button.
        Button calculateButton = new Button("Calculate");
        calculateButton.getStyleClass().add("calculateButton");
        AnchorPane.setTopAnchor(calculateButton, 271.0);
        AnchorPane.setLeftAnchor(calculateButton, 180.0);
        AnchorPane.setRightAnchor(calculateButton, 20.0);
        AnchorPane.setBottomAnchor(calculateButton, 10.0);
        calculateButton.setMinWidth(100);
        calculateButton.setMinHeight(50);


        // --------- result Section ---------

        // Results Label.
        Label resultsLabel = new Label("Results");
        resultsLabel.getStyleClass().add("result-label");
        AnchorPane.setTopAnchor(resultsLabel, 20.0);
        AnchorPane.setLeftAnchor(resultsLabel, 20.0);
        AnchorPane.setRightAnchor(resultsLabel, 560.0);

        // Future Value.
        Label futureValue = new Label("FV (Future Value) : ");
        AnchorPane.setTopAnchor(futureValue, 69.0);
        AnchorPane.setLeftAnchor(futureValue, 30.0);


        // Number of Periods.
        Label presentValue = new Label("PV (Present Value) : ");
        AnchorPane.setTopAnchor(presentValue, 112.0);
        AnchorPane.setLeftAnchor(presentValue, 30.0);

        // Number of Periods.
        Label numberPeriods = new Label("N (Number of Periods) : ");
        AnchorPane.setTopAnchor(numberPeriods, 163.0);
        AnchorPane.setLeftAnchor(numberPeriods, 30.0);


        // Interest Rate.
        Label interestRate = new Label("I/Y (Interest Rate) : ");
        AnchorPane.setTopAnchor(interestRate, 210.0);
        AnchorPane.setLeftAnchor(interestRate, 30.0);


        // Periodic Payment.
        Label periodicPayment = new Label("PMT (Periodic Payment) :");
        AnchorPane.setTopAnchor(periodicPayment, 257.0);
        AnchorPane.setLeftAnchor(periodicPayment, 30.0);


        // Starting Investment.
        Label startingInvestmentLabel = new Label("Starting Investment : ");
        AnchorPane.setTopAnchor(startingInvestmentLabel, 304.0);
        AnchorPane.setLeftAnchor(startingInvestmentLabel, 30.0);


        // Total Principal
        Label totalPrincipal = new Label("Total Principal : ");
        AnchorPane.setTopAnchor(totalPrincipal, 351.0);
        AnchorPane.setLeftAnchor(totalPrincipal, 30.0);

        // Total Interest
        Label totalInterest = new Label("Total Interest : ");
        AnchorPane.setTopAnchor(totalInterest, 398.0);
        AnchorPane.setLeftAnchor(totalInterest, 30.0);
        AnchorPane.setBottomAnchor(totalInterest, 20.0);


        // Action
        calculateButton.setOnAction(e -> {
            AnnuityPaymentController.calculateSavings(futureValueTextField, noPeriodsTextField, interestTextField, startPrincipalTextField, futureValue, presentValue, numberPeriods ,interestRate, periodicPayment, startingInvestmentLabel, totalPrincipal, totalInterest);
            //
        });

        // ----------- key pad Section ----------------

        // numberPadRoot.
        Label numberPadTitle = new Label("Number Pad");
        numberPadTitle.getStyleClass().add("number-label");
        AnchorPane.setTopAnchor(numberPadTitle, 10.0);
        AnchorPane.setLeftAnchor(numberPadTitle, 80.0);


        // Number seven Key.
        Button numberSevenKey = new Button("7");
        numberSevenKey.setOnAction(e -> setKeyPadInput(numberSevenKey.getText()));
        AnchorPane.setTopAnchor(numberSevenKey, 60.0);
        AnchorPane.setLeftAnchor(numberSevenKey, 10.0);
        numberSevenKey.setMinWidth(70);
        numberSevenKey.setMinHeight(70);

        // Number eight key.
        Button numberEightKey = new Button("8");
        numberEightKey.setOnAction(e -> setKeyPadInput(numberEightKey.getText()));
        AnchorPane.setTopAnchor(numberEightKey, 60.0);
        AnchorPane.setLeftAnchor(numberEightKey, 95.0);
        numberEightKey.setMinWidth(70);
        numberEightKey.setMinHeight(70);

        // Number nine key.
        Button numberNineKey = new Button("9");
        numberNineKey.setOnAction(e -> setKeyPadInput(numberNineKey.getText()));
        AnchorPane.setTopAnchor(numberNineKey, 60.0);
        AnchorPane.setLeftAnchor(numberNineKey, 180.0);
        numberNineKey.setMinWidth(70);
        numberNineKey.setMinHeight(70);

        // Number six key.
        Button numberSixKey = new Button("6");
        numberSixKey.setOnAction(e -> setKeyPadInput(numberSixKey.getText()));
        AnchorPane.setTopAnchor(numberSixKey, 143.0);
        AnchorPane.setLeftAnchor(numberSixKey, 180.0);
        numberSixKey.setMinWidth(70);
        numberSixKey.setMinHeight(70);

        // Number five key.
        Button numberFiveKey = new Button("5");
        numberFiveKey.setOnAction(e -> setKeyPadInput(numberFiveKey.getText()));
        AnchorPane.setTopAnchor(numberFiveKey, 143.0);
        AnchorPane.setLeftAnchor(numberFiveKey, 95.0);
        numberFiveKey.setMinWidth(70);
        numberFiveKey.setMinHeight(70);

        // Number four key.
        Button numberFourKey = new Button("4");
        numberFourKey.setOnAction(e -> setKeyPadInput(numberFourKey.getText()));
        AnchorPane.setTopAnchor(numberFourKey, 143.00);
        AnchorPane.setLeftAnchor(numberFourKey, 10.0);
        numberFourKey.setMinWidth(70);
        numberFourKey.setMinHeight(70);

        // Number three key.
        Button numberThreeKey = new Button("3");
        numberThreeKey.setOnAction(e -> setKeyPadInput(numberThreeKey.getText()));
        AnchorPane.setTopAnchor(numberThreeKey, 223.0);
        AnchorPane.setLeftAnchor(numberThreeKey, 180.0);
        numberThreeKey.setMinWidth(70);
        numberThreeKey.setMinHeight(70);

        // Number Two Key.
        Button numberTwoKey = new Button("2");
        numberTwoKey.setOnAction(e -> setKeyPadInput(numberTwoKey.getText()));
        AnchorPane.setTopAnchor(numberTwoKey, 223.0);
        AnchorPane.setLeftAnchor(numberTwoKey, 95.0);
        numberTwoKey.setMinWidth(70);
        numberTwoKey.setMinHeight(70);

        // Number one Key.
        Button numberOneKey = new Button("1");
        numberOneKey.setOnAction(e -> setKeyPadInput(numberOneKey.getText()));
        AnchorPane.setTopAnchor(numberOneKey, 223.0);
        AnchorPane.setLeftAnchor(numberOneKey, 10.0);
        numberOneKey.setMinWidth(70);
        numberOneKey.setMinHeight(70);

        // Number Zero key.
        Button numberZeroButton = new Button("0");
        numberZeroButton.setOnAction(e -> setKeyPadInput(numberZeroButton.getText()));
        AnchorPane.setTopAnchor(numberZeroButton, 223.0);
        AnchorPane.setLeftAnchor(numberZeroButton, 265.0);
        numberZeroButton.setMinWidth(70);
        numberZeroButton.setMinHeight(70);

        // Negative Mark Key.
        Button numberNegativeMarkKey = new Button("-");
        numberNegativeMarkKey.setOnAction(e -> setKeyPadInput(numberNegativeMarkKey.getText()));
        AnchorPane.setTopAnchor(numberNegativeMarkKey, 143.00);
        AnchorPane.setLeftAnchor(numberNegativeMarkKey, 265.0);
        AnchorPane.setRightAnchor(numberNegativeMarkKey, 10.0);
        numberNegativeMarkKey.setMinWidth(70);
        numberNegativeMarkKey.setMinHeight(70);

        // Decimal point key.
        Button numberDecimalPointKey = new Button(".");
        numberDecimalPointKey.setOnAction(e -> setKeyPadInput(numberDecimalPointKey.getText()));
        AnchorPane.setTopAnchor(numberDecimalPointKey, 60.0);
        AnchorPane.setLeftAnchor(numberDecimalPointKey, 265.0);
        numberDecimalPointKey.setMinWidth(70);
        numberDecimalPointKey.setMinHeight(70);

        // BackSpace Button Button.
        Button backSpaceButton = new Button("<--");
        backSpaceButton.setOnAction(e -> clearSelectedTextField());
        AnchorPane.setTopAnchor(backSpaceButton, 303.0);
        AnchorPane.setLeftAnchor(backSpaceButton, 10.0);
        backSpaceButton.setPrefWidth(155);
        backSpaceButton.setPrefHeight(70);

        // Clear Button.
        Button clearButton = new Button("Clear");
        clearButton.setOnAction(e -> AnnuityPaymentController.clearTextFields(futureValueTextField, noPeriodsTextField, interestTextField, startPrincipalTextField));
        AnchorPane.setTopAnchor(clearButton, 303.0);
        AnchorPane.setLeftAnchor(clearButton, 175.0);
        clearButton.setPrefWidth(155);
        clearButton.setPrefHeight(70);

        // Back Button.
        Button backButton = new Button("Back");
        backButton.getStyleClass().add("back-button");
        AnchorPane.setTopAnchor(backButton, 640.0);
        AnchorPane.setLeftAnchor(backButton, 500.0);
        backButton.setPrefWidth(210);
        backButton.setPrefHeight(70);
        backButton.setOnAction(e -> {
            savingsCalculator.setTitle("Finance Calculator");
            savingsCalculator.setScene(mainScene);
        });

        // History Button.
        Button openHistoryButton = new Button("History");
        openHistoryButton.getStyleClass().add("history-button");
        AnchorPane.setTopAnchor(openHistoryButton, 640.0);
        AnchorPane.setLeftAnchor(openHistoryButton, 740.0);
        openHistoryButton.setPrefWidth(210);
        openHistoryButton.setPrefHeight(70);

        // Close Button.
        Button closeButton = new Button("Close");
        closeButton.getStyleClass().add("close-button");
        AnchorPane.setTopAnchor(closeButton, 640.0);
        AnchorPane.setLeftAnchor(closeButton, 980.0);
        closeButton.setPrefWidth(210);
        closeButton.setPrefHeight(70);
        closeButton.setOnAction(e -> savingsCalculator.close() );

        //  ------ adding contents to panes ------

        dataEnteringSection.getChildren().addAll(fvButton, pmtButton, iyButton, nButton, startPrincipalButton, futureValueLabel, futureValueTextField, noPeriodsLabel, noPeriodsTextField, startPrincipalLabel, startPrincipalTextField, interestLabel, interestTextField, percentageMarkLabel, calculateButton);
        dataEnteringSection.getStyleClass().add("section-style");

        resultSection.getChildren().addAll(resultsLabel, futureValue, presentValue, numberPeriods, interestRate, periodicPayment, startingInvestmentLabel, totalPrincipal, totalInterest);
        resultSection.getStyleClass().add("section-style");

        numberPadRoot.getChildren().addAll(numberPadTitle, numberSevenKey, numberEightKey, numberNineKey, numberSixKey, numberFiveKey, numberFourKey, numberThreeKey, numberTwoKey, numberOneKey, numberZeroButton, numberNegativeMarkKey, numberDecimalPointKey, backSpaceButton, clearButton);
        numberPadRoot.getStyleClass().add("number-pad");

        //  ------ positioning panes ------

        // data entering section
        AnchorPane.setTopAnchor(dataEnteringSection, 20.0);
        AnchorPane.setLeftAnchor(dataEnteringSection, 20.0);

        // results display section
        AnchorPane.setTopAnchor(resultSection, 20.0);
        AnchorPane.setLeftAnchor(resultSection, 500.0);

        // number pad section
        AnchorPane.setTopAnchor(numberPadRoot, 400.0);
        AnchorPane.setLeftAnchor(numberPadRoot, 20.0);

        rootSavingsCalculator.getChildren().addAll(dataEnteringSection, resultSection, numberPadRoot, backButton, openHistoryButton, closeButton);

        Scene startingPrincipalScene = new Scene(rootSavingsCalculator, 1280, 900);
        startingPrincipalScene.getStylesheets().add("Stylesheet.css");
        savingsCalculator.setScene(startingPrincipalScene);
        savingsCalculator.show();
    }

    public static void setKeyPadInput(String keyPadValue) {
        String textInTextField = selectedTextField.getText();

        if(".".equals(keyPadValue)) {
            if(!textInTextField.contains(".")) {
                textInTextField = textInTextField + keyPadValue;
                selectedTextField.setText(textInTextField);
            }
        }else{
            textInTextField = textInTextField + keyPadValue;
            selectedTextField.setText(textInTextField);
        }
        if(!selectedTextField.isFocused()) {
            selectedTextField.requestFocus();
        }
    }
    public static void clearSelectedTextField() {
        String textInTextField = selectedTextField.getText();

        if(textInTextField.length() > 0) {
            textInTextField = textInTextField.substring(0, textInTextField.length() - 1);
            selectedTextField.setText(textInTextField);
        }
    }
}
