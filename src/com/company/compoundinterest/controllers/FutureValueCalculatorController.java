package com.company.compoundinterest.controllers;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class FutureValueCalculatorController {

    private static DecimalFormat roundNumber = new DecimalFormat("0.00");

    public static boolean calculateSavings(TextField noPeriodsTextField, TextField sPrincipalLabelTextField, TextField interestTextField, TextField pmiTextField, Label futureValue, Label numberPeriods, Label interestRate, Label periodicPayment, Label startingInvestmentLabel, Label totalPrincipal){
        try {
            ArrayList<String> tableData = new ArrayList();

            double noPeriods = Double.parseDouble(noPeriodsTextField.getText());
            double sPrincipal = Double.parseDouble(sPrincipalLabelTextField.getText());
            double startingInvestment = sPrincipal;
            double sBalance = sPrincipal;
            double interest = Double.parseDouble(interestTextField.getText());
            double pmi = Double.parseDouble(pmiTextField.getText());


            for (int period = 1; period <= noPeriods; period++) {
                double intValue = sBalance * interest / 100;
                double eBalance = sBalance + intValue + pmi;
                double ePrincipal = sPrincipal + pmi;

                sPrincipal = ePrincipal;
                sBalance = eBalance;

                if (period == noPeriods) {
                    String eBalanceString = roundNumber.format(eBalance);

                    futureValue.setText(String.valueOf("FV (Future Value) : $" + eBalanceString));
                    numberPeriods.setText(String.valueOf("N (Number of Periods) : $" + noPeriods));
                    interestRate.setText(String.valueOf("I/Y (Interest Rate) : " + interest + "%"));
                    periodicPayment.setText(String.valueOf("PMT (Periodic Payment) : $" + pmi));
                    startingInvestmentLabel.setText(String.valueOf("Starting Investment : $" + startingInvestment));
                    totalPrincipal.setText(String.valueOf("Total Principal : $" + ePrincipal));

                    // -------- saving data in to json file --------------

                    //Creating a JSONObject object
                    JSONObject dataObject = new JSONObject();

                    //Inserting key-value pairs into the json object
                    dataObject.put("FV (Future Value) : ", "$" + eBalanceString);
                    dataObject.put("N (Number of Periods) : ", "$" + noPeriods);
                    dataObject.put("I/Y (Interest Rate) : ", interest + "%");
                    dataObject.put("PMT (Periodic Payment) : ", "$" + pmi);
                    dataObject.put("Starting Investment : ", "$" + startingInvestment);
                    dataObject.put("Total Principal : ", "$" + ePrincipal);

                    // Create ID using data and time data.
                    DateTimeFormatter calculationID = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
                    LocalDateTime now = LocalDateTime.now();

                    JSONObject finalDataObject = new JSONObject();
                    finalDataObject.put(calculationID.format(now), dataObject);

                    try {
                        FileWriter file = new FileWriter("futurecvaluecal.json");
                        file.write(finalDataObject.toJSONString());
                        file.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("JSON file created: " + finalDataObject);
                }
            }
            return true;
        }catch (NumberFormatException e){
            System.out.println("Please enter Valid Inputs");
            return false;
        }
    }
    public static void clearTextFields(TextField noPeriodsTextField, TextField sPrincipalLabelTextField, TextField interestTextField, TextField pmiTextField) {
        noPeriodsTextField.setText("");
        sPrincipalLabelTextField.setText("");
        interestTextField.setText("");
        pmiTextField.setText("");
    }
}
