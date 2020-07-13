package com.company.loancalculator.totalprice.controllers;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TotalPriceController {

    private static final DecimalFormat roundNumber = new DecimalFormat("0.00");

    public static boolean calculateTotalLoan(TextField autoPriceTextField, TextField loanTermsTextField, TextField interestTextField, TextField downPaymentTextField, TextField tradePaymentTextField, TextField salesTaxTextField, TextField otherFeesTextField, Label monthlyPaymentLabel, Label totalLoanAmountLabel, Label saleTaxLabel, Label upfrontPaymentLabel, Label totalLoanPaymentsLabel, Label totalLoanInterestLabel, Label totalCostLabel) {
        try {

            double autoPrice = Double.parseDouble(autoPriceTextField.getText());
            double loanTerms = Double.parseDouble(loanTermsTextField.getText());
            double interestRate = Double.parseDouble(interestTextField.getText());
            double interestRateD = interestRate / 100;
            double downPayment = Double.parseDouble(downPaymentTextField.getText());
            double tradePayment = Double.parseDouble(tradePaymentTextField.getText());
            double salesTax = Double.parseDouble(salesTaxTextField.getText());
            double otherFees = Double.parseDouble(otherFeesTextField.getText());
            double loanAmount = autoPrice - downPayment - tradePayment;
            double bB = loanAmount;
            double monthlyPayment = (loanAmount * (interestRateD / 12)) / (1 - Math.pow((12 + interestRateD) / 12, (-loanTerms)));
            double valueTotal = 0;

            for (int i = 1; i <= loanTerms; i++) {
                double IValue = bB * (interestRateD / 12);
                valueTotal += IValue;
                double principal = monthlyPayment - IValue;
                double EB = bB - principal;
                bB = EB;
                if (i == loanTerms) {
                    double STValue = autoPrice * salesTax / 100;
                    double upFrontPayment = downPayment + STValue + otherFees;
                    double totalA = loanAmount + valueTotal;
                    double totalCost = totalA + upFrontPayment + tradePayment;
                    monthlyPaymentLabel.setText("Monthly Pay : $" + roundNumber.format(monthlyPayment));
                    totalLoanAmountLabel.setText("Total Loan Amount : $" + roundNumber.format(loanAmount));
                    saleTaxLabel.setText("Sale Tax : $" + roundNumber.format(STValue));
                    upfrontPaymentLabel.setText("Upfront Payment : $" + roundNumber.format(upFrontPayment));
                    totalLoanPaymentsLabel.setText("Total of 60 Loan Payments : $" + roundNumber.format(totalA));
                    totalLoanInterestLabel.setText("Total Loan Interest : $" + roundNumber.format(valueTotal));
                    totalCostLabel.setText("Total Cost : $" + roundNumber.format(totalCost));


                    // -------- saving data in to a json file --------------

                    //Creating a JSONObject object
                    JSONObject dataObject = new JSONObject();

                    //Inserting key-value pairs into the json object
                    dataObject.put("Monthly Pay: ", "$" + roundNumber.format(monthlyPayment));
                    dataObject.put("Total Loan Amount : ", "$" + roundNumber.format(loanAmount));
                    dataObject.put("Sale Tax : ", "$" + roundNumber.format(STValue));
                    dataObject.put("Upfront Payment : ", "$" + roundNumber.format(upFrontPayment));
                    dataObject.put("Total of 60 Loan Payments : ", "$" + roundNumber.format(totalA));
                    dataObject.put("Total Loan Interest : ", "$" + roundNumber.format(valueTotal));
                    dataObject.put("Total Cost : ", "$" + roundNumber.format(totalCost));

                    // Creating a ID using data and time data.
                    DateTimeFormatter calculationID = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
                    LocalDateTime now = LocalDateTime.now();

                    JSONObject finalDataObject = new JSONObject();
                    finalDataObject.put(calculationID.format(now), dataObject);

                    try {
                        FileWriter file = new FileWriter("totalprice.json");
                        file.write(finalDataObject.toJSONString());
                        file.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("JSON file created: " + finalDataObject);
                }
            }
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Please enter Valid Inputs");
            return false;
        }
    }

    public static void clearTextFields(TextField monthlyPayTextField, TextField loanTermsTextField, TextField interestTextField, TextField downPaymentTextField, TextField tradePaymentTextField, TextField salesTaxTextField, TextField otherFeesTextField) {
        monthlyPayTextField.setText("");
        loanTermsTextField.setText("");
        interestTextField.setText("");
        downPaymentTextField.setText("");
        tradePaymentTextField.setText("");
        interestTextField.setText("");
        salesTaxTextField.setText("");
        otherFeesTextField.setText("");
    }
}
