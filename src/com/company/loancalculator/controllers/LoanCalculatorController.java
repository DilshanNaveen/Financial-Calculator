package com.company.loancalculator.controllers;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoanCalculatorController {

    private static final DecimalFormat roundNumber = new DecimalFormat("0.00");

    public static boolean calculateLoan(TextField monthlyPayTextField, TextField loanTermsTextField, TextField interestTextField, TextField downPaymentTextField, TextField tradePaymentTextField, TextField salesTaxTextField, TextField otherFeesTextField, Label vehiclePriceLabel, Label totalLoanAmountLabel, Label saleTaxLabel, Label upfrontPaymentLabel, Label totalLoanPaymentsLabel, Label totalLoanInterestLabel, Label totalCostLabel) {
        try {

            double monthlyPay = Double.parseDouble(monthlyPayTextField.getText());
            double loanTerms = Double.parseDouble(loanTermsTextField.getText());
            double interest = Double.parseDouble(interestTextField.getText());
            double downPayment = Double.parseDouble(downPaymentTextField.getText());
            double tradePayment = Double.parseDouble(tradePaymentTextField.getText());
            double salesTax = Double.parseDouble(salesTaxTextField.getText());
            double otherFees = Double.parseDouble(otherFeesTextField.getText());
            double interestRateD = interest / 100;
            double loanAmount = (monthlyPay * (1 - Math.pow((12 + interestRateD) / 12, -loanTerms))) / (interestRateD / 12);
            double bB = loanAmount;
            double vehiclePrice = loanAmount + downPayment;
            double valueTotal = 0;

            for (int i = 1; i <= loanTerms; i++) {
                double IRValue = bB * (interestRateD / 12);
                valueTotal += IRValue;
                double principal = monthlyPay - IRValue;
                double eB = bB - principal;
                bB = eB;


                if (i == loanTerms) {
                    double STValue = vehiclePrice * salesTax / 100;
                    double UP = downPayment + STValue + otherFees;
                    double totalA = loanAmount + valueTotal;
                    double totalC = totalA + UP + tradePayment;

                    System.out.println("Vehicle Price : $" + roundNumber.format(vehiclePrice));
                    System.out.println("Total Loan Amount : $" + roundNumber.format(loanAmount));
                    System.out.println("Sale Tax : $" + roundNumber.format(STValue));
                    System.out.println("Upfront Payment : $" + roundNumber.format(UP));
                    System.out.println("Total of 60 Loan Payments : $" + roundNumber.format(totalA));
                    System.out.println("Total Loan Interest : $" + roundNumber.format(valueTotal));
                    System.out.println("Total Cost : $" + roundNumber.format(totalC));

                    vehiclePriceLabel.setText("Vehicle Price : $" + roundNumber.format(vehiclePrice));
                    totalLoanAmountLabel.setText("Total Loan Amount : $" + roundNumber.format(loanAmount));
                    saleTaxLabel.setText("Sale Tax : $" + roundNumber.format(STValue));
                    upfrontPaymentLabel.setText("Upfront Payment : $" + roundNumber.format(UP));
                    totalLoanPaymentsLabel.setText("Total of 60 Loan Payments : $" + roundNumber.format(totalA));
                    totalLoanInterestLabel.setText("Total Loan Interest : $" + roundNumber.format(valueTotal));
                    totalCostLabel.setText("Total Cost : $" + roundNumber.format(totalC));

                    // -------- saving data in to json file --------------

                    //Creating a JSONObject object
                    JSONObject dataObject = new JSONObject();

                    //Inserting key-value pairs into the json object
                    dataObject.put("Vehicle Price : ", "$" + roundNumber.format(vehiclePrice));
                    dataObject.put("Total Loan Amount : ", "$" + roundNumber.format(loanAmount));
                    dataObject.put("Sale Tax : ", "$" + roundNumber.format(STValue));
                    dataObject.put("Upfront Payment : ", "$" + roundNumber.format(UP));
                    dataObject.put("Total of 60 Loan Payments : ", "$" + roundNumber.format(totalA));
                    dataObject.put("Total Loan Interest : ", "$" + roundNumber.format(valueTotal));
                    dataObject.put("Total Cost : ", "$" + roundNumber.format(totalC));

                    // Create ID using data and time data.
                    DateTimeFormatter calculationID = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
                    LocalDateTime now = LocalDateTime.now();

                    JSONObject finalDataObject = new JSONObject();
                    finalDataObject.put(calculationID.format(now), dataObject);

                    try {
                        FileWriter file = new FileWriter("monthlypaymentcal.json");
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
