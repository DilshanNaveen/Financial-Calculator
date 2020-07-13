package com.company.loancalculator.totalprice;

import com.company.loancalculator.totalprice.controllers.TotalPriceController;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class TotalPrice{

    public static TextField selectedTextField;

    public static void selectTextField(TextField textfield) {
        selectedTextField = textfield;
    }

    public static void displayTotalPriceCalculator( Stage savingsCalculator, Scene mainScene, Scene loanCalculatorScene) {
        savingsCalculator.setTitle("Loan Calculator - Total Price");

        AnchorPane rootSavingsCalculator = new AnchorPane();
        rootSavingsCalculator.setPadding(new Insets(30, 40, 40, 40));

        AnchorPane dataEnteringSection = new AnchorPane();
        dataEnteringSection.setPadding(new Insets(10, 10, 10, 10));

        AnchorPane resultSection = new AnchorPane();
        dataEnteringSection.setPadding(new Insets(10, 10, 10, 10));

        AnchorPane numberPadRoot = new AnchorPane();
        numberPadRoot.setPadding(new Insets(5, 45, 20, 45));


        // --------------- Cal Buttons -------------

        // Monthly Payment Button.
        Button monthlyPaymentButton = new Button("Monthly Payment");
        monthlyPaymentButton.setOnAction(e -> {
            savingsCalculator.setScene(loanCalculatorScene);
            savingsCalculator.setTitle("Loan Calculator - Monthly Payment");
        });

        AnchorPane.setTopAnchor(monthlyPaymentButton, 20.0);
        AnchorPane.setLeftAnchor(monthlyPaymentButton, 20.0);
        monthlyPaymentButton.setFont(Font.font("Arial", FontWeight.NORMAL, 15));
        monthlyPaymentButton.setMinWidth(60);
        monthlyPaymentButton.setMaxHeight(40);

        // Total Price Button.
        Button totalPriceButton = new Button("Total Price");
        AnchorPane.setTopAnchor(totalPriceButton, 20.0);
        AnchorPane.setLeftAnchor(totalPriceButton, 180.0);
        totalPriceButton.setFont(Font.font("Arial", FontWeight.NORMAL, 15));
        totalPriceButton.setMinWidth(60);
        totalPriceButton.setMaxHeight(40);


        // ------------ data input section -----------------

        // Auto Price Label.
        Label autoPriceLabel = new Label("Auto Price : $ ");
        AnchorPane.setTopAnchor(autoPriceLabel, 75.0);
        AnchorPane.setLeftAnchor(autoPriceLabel, 20.0);

        // Auto Price TextField.
        TextField autoPriceTextField = new TextField();
        autoPriceTextField.setOnMouseClicked(e -> selectTextField(autoPriceTextField));
        AnchorPane.setTopAnchor(autoPriceTextField, 70.0);
        AnchorPane.setLeftAnchor(autoPriceTextField, 180.0);
        AnchorPane.setRightAnchor(autoPriceTextField, 20.0);

        // Loan Terms Label.
        Label loanTermsLabel = new Label("Loan Terms : ");
        AnchorPane.setTopAnchor(loanTermsLabel, 137.0);
        AnchorPane.setLeftAnchor(loanTermsLabel, 20.0);

        // Loan Terms TextField.
        TextField loanTermsTextField = new TextField();
        loanTermsTextField.setOnMouseClicked(e -> selectTextField(loanTermsTextField));
        AnchorPane.setTopAnchor(loanTermsTextField, 130.0);
        AnchorPane.setLeftAnchor(loanTermsTextField, 180.0);
        AnchorPane.setRightAnchor(loanTermsTextField, 20.0);

        // Interest Rate Label.
        Label interestLabel = new Label("Interest Rate : ");
        AnchorPane.setTopAnchor(interestLabel, 190.0);
        AnchorPane.setLeftAnchor(interestLabel, 20.0);

        // Percentage mark for Interest.
        Label percentageMarkLabel = new Label("%");
        AnchorPane.setTopAnchor(percentageMarkLabel, 193.0);
        AnchorPane.setLeftAnchor(percentageMarkLabel, 360.0);

        // Interest Rate TextField.
        TextField interestTextField = new TextField();
        interestTextField.setOnMouseClicked(e -> selectTextField(interestTextField));
        AnchorPane.setTopAnchor(interestTextField, 190.0);
        AnchorPane.setLeftAnchor(interestTextField, 180.0);
        AnchorPane.setRightAnchor(interestTextField, 20.0);

        // Down payment Label.
        Label downPaymentLabel = new Label("Down payment : $ ");
        AnchorPane.setTopAnchor(downPaymentLabel, 252.0);
        AnchorPane.setLeftAnchor(downPaymentLabel, 20.0);

        // Down payment TextField.
        TextField downPaymentTextField = new TextField();
        downPaymentTextField.setOnMouseClicked(e -> selectTextField(downPaymentTextField));
        AnchorPane.setTopAnchor(downPaymentTextField, 250.0);
        AnchorPane.setLeftAnchor(downPaymentTextField, 180.0);
        AnchorPane.setRightAnchor(downPaymentTextField, 20.0);

        // Trade in Value Label.
        Label tradedValueLabel = new Label("Trade in Value : $ ");
        AnchorPane.setTopAnchor(tradedValueLabel, 312.0);
        AnchorPane.setLeftAnchor(tradedValueLabel, 20.0);

        // Trade in Value TextField.
        TextField tradePaymentTextField = new TextField();
        tradePaymentTextField.setOnMouseClicked(e -> selectTextField(tradePaymentTextField));
        AnchorPane.setTopAnchor(tradePaymentTextField, 310.0);
        AnchorPane.setLeftAnchor(tradePaymentTextField, 180.0);
        AnchorPane.setRightAnchor(tradePaymentTextField, 20.0);

        // Sales Tax Label.
        Label salesTaxLabel = new Label("Sales Tax : $ ");
        AnchorPane.setTopAnchor(salesTaxLabel, 367.0);
        AnchorPane.setLeftAnchor(salesTaxLabel, 20.0);

        // Percentage mark for Sales Tax TextField.
        Label percentageMarkSalesLabel = new Label("%");
        AnchorPane.setTopAnchor(percentageMarkSalesLabel, 373.0);
        AnchorPane.setLeftAnchor(percentageMarkSalesLabel, 360.0);

        // Sales Tax TextField.
        TextField salesTaxTextField = new TextField();
        salesTaxTextField.setOnMouseClicked(e -> selectTextField(salesTaxTextField));
        AnchorPane.setTopAnchor(salesTaxTextField, 370.0);
        AnchorPane.setLeftAnchor(salesTaxTextField, 180.0);
        AnchorPane.setRightAnchor(salesTaxTextField, 20.0);

        // Title Registration and other fees Label.
        Label otherFeesLabel = new Label("TR and other fees : $");
        AnchorPane.setTopAnchor(otherFeesLabel, 432.0);
        AnchorPane.setLeftAnchor(otherFeesLabel, 20.0);

        // Title Registration and other fees TextField.
        TextField otherFeesTextField = new TextField();
        otherFeesTextField.setOnMouseClicked(e -> selectTextField(otherFeesTextField));
        AnchorPane.setTopAnchor(otherFeesTextField, 430.0);
        AnchorPane.setLeftAnchor(otherFeesTextField, 180.0);
        AnchorPane.setRightAnchor(otherFeesTextField, 20.0);

        // Calculate Button.
        Button calculateButton = new Button("Calculate");
        calculateButton.getStyleClass().add("calculateButton");
        AnchorPane.setTopAnchor(calculateButton, 490.0);
        AnchorPane.setLeftAnchor(calculateButton, 180.0);
        AnchorPane.setRightAnchor(calculateButton, 20.0);
        AnchorPane.setBottomAnchor(calculateButton, 20.0);
        calculateButton.setMinWidth(100);
        calculateButton.setMinHeight(50);

        // --------- result Section ---------

        // Results Label.
        Label resultsLabel = new Label("Results");
        resultsLabel.getStyleClass().add("result-label");
        AnchorPane.setTopAnchor(resultsLabel, 20.0);
        AnchorPane.setLeftAnchor(resultsLabel, 20.0);
        AnchorPane.setRightAnchor(resultsLabel, 560.0);

        // Monthly Payment Price.
        Label monthlyPaymentLabel = new Label("Monthly Payment : $");
        AnchorPane.setTopAnchor(monthlyPaymentLabel, 69.0);
        AnchorPane.setLeftAnchor(monthlyPaymentLabel, 30.0);

        // Total Loan Amount.
        Label totalLoanAmountLabel = new Label("Total Loan Amount : $");
        AnchorPane.setTopAnchor(totalLoanAmountLabel, 112.0);
        AnchorPane.setLeftAnchor(totalLoanAmountLabel, 30.0);

        // Sale Tax.
        Label saleTaxLabel = new Label("Sale Tax : ");
        AnchorPane.setTopAnchor(saleTaxLabel, 163.0);
        AnchorPane.setLeftAnchor(saleTaxLabel, 30.0);

        // Upfront Payment.
        Label upfrontPaymentLabel = new Label("Upfront Payment : $");
        AnchorPane.setTopAnchor(upfrontPaymentLabel, 210.0);
        AnchorPane.setLeftAnchor(upfrontPaymentLabel, 30.0);

        // Total of 60 Loan Payments.
        Label totalLoanPaymentsLabel = new Label("Total of 60 Loan Payments : $");
        AnchorPane.setTopAnchor(totalLoanPaymentsLabel, 257.0);
        AnchorPane.setLeftAnchor(totalLoanPaymentsLabel, 30.0);

        // Total Loan Interest
        Label totalLoanInterestLabel = new Label("Total Loan Interest : $");
        AnchorPane.setTopAnchor(totalLoanInterestLabel, 304.0);
        AnchorPane.setLeftAnchor(totalLoanInterestLabel, 30.0);

        // Total Cost (price, interest, tax, fees)
        Label totalCostLabel = new Label("Total Cost : $");
        AnchorPane.setTopAnchor(totalCostLabel, 351.0);
        AnchorPane.setLeftAnchor(totalCostLabel, 30.0);
        AnchorPane.setBottomAnchor(totalCostLabel, 20.0);

        // Action
        calculateButton.setOnAction(e -> TotalPriceController.calculateTotalLoan(autoPriceTextField, loanTermsTextField, interestTextField, downPaymentTextField, tradePaymentTextField, salesTaxTextField, otherFeesTextField, monthlyPaymentLabel, totalLoanAmountLabel, saleTaxLabel, upfrontPaymentLabel, totalLoanPaymentsLabel, totalLoanInterestLabel, totalCostLabel));

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
        clearButton.setOnAction(e -> TotalPriceController.clearTextFields(autoPriceTextField, loanTermsTextField, interestTextField, downPaymentTextField, tradePaymentTextField, salesTaxTextField, otherFeesTextField));
        AnchorPane.setTopAnchor(clearButton, 303.0);
        AnchorPane.setLeftAnchor(clearButton, 175.0);
        clearButton.setPrefWidth(155);
        clearButton.setPrefHeight(70);

        // Back Button.
        Button backButton = new Button("Back");
        backButton.getStyleClass().add("back-button");
        AnchorPane.setTopAnchor(backButton, 690.0);
        AnchorPane.setLeftAnchor(backButton, 20.0);
        backButton.setPrefWidth(210);
        backButton.setPrefHeight(70);

        backButton.setOnAction(e -> {
            savingsCalculator.setTitle("Finance Calculator");
            savingsCalculator.setScene(mainScene);
        });

        // History Button.
        Button openHistoryButton = new Button("History");
        openHistoryButton.getStyleClass().add("history-button");
        AnchorPane.setTopAnchor(openHistoryButton, 690.0);
        AnchorPane.setLeftAnchor(openHistoryButton, 250.0);
        openHistoryButton.setPrefWidth(210);
        openHistoryButton.setPrefHeight(70);

        // Close Button.
        Button closeButton = new Button("Close");
        closeButton.getStyleClass().add("close-button");
        AnchorPane.setTopAnchor(closeButton, 690.0);
        AnchorPane.setLeftAnchor(closeButton, 480.0);
        closeButton.setPrefWidth(210);
        closeButton.setPrefHeight(70);
        closeButton.setOnAction(e -> savingsCalculator.close());

        //  ------ adding contents to panes ------

        dataEnteringSection.getChildren().addAll(monthlyPaymentButton, totalPriceButton, autoPriceLabel, autoPriceTextField, loanTermsLabel, loanTermsTextField, interestLabel, interestTextField, percentageMarkLabel, downPaymentLabel, downPaymentTextField, tradedValueLabel, tradePaymentTextField, salesTaxLabel, salesTaxTextField, percentageMarkSalesLabel, otherFeesLabel, otherFeesTextField, calculateButton);
        dataEnteringSection.getStyleClass().add("section-style");

        resultSection.getChildren().addAll(resultsLabel, monthlyPaymentLabel, totalLoanAmountLabel, saleTaxLabel, upfrontPaymentLabel, totalLoanPaymentsLabel, totalLoanInterestLabel, totalCostLabel);
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
        AnchorPane.setTopAnchor(numberPadRoot, 450.0);
        AnchorPane.setLeftAnchor(numberPadRoot, 750.0);

        rootSavingsCalculator.getChildren().addAll(dataEnteringSection, resultSection, numberPadRoot, backButton, openHistoryButton, closeButton);
        Scene totalPriceScene = new Scene(rootSavingsCalculator, 1280, 900);
        totalPriceScene.getStylesheets().add("Stylesheet.css");
        savingsCalculator.setResizable(false);
        savingsCalculator.setScene(totalPriceScene);
        savingsCalculator.show();
    }
    public static void setKeyPadInput(String keyPadValue) {
        String textInTextField = selectedTextField.getText();

        if (".".equals(keyPadValue)) {
            if (!textInTextField.contains(".")) {
                textInTextField = textInTextField + keyPadValue;
                selectedTextField.setText(textInTextField);
            }
        } else {
            textInTextField = textInTextField + keyPadValue;
            selectedTextField.setText(textInTextField);
        }
        if (!selectedTextField.isFocused()) {
            selectedTextField.requestFocus();
        }
    }

    public static void clearSelectedTextField() {
        String textInTextField = selectedTextField.getText();

        if (textInTextField.length() > 0) {
            textInTextField = textInTextField.substring(0, textInTextField.length() - 1);
            selectedTextField.setText(textInTextField);
        }
    }
}
