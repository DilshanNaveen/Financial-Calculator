package com.company.compoundinterest.AnnuityPayment.controllers;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AnnuityPaymentController {

    private static DecimalFormat roundNumber = new DecimalFormat("0.00");

    public static boolean calculateSavings(TextField futureValueTextField, TextField noPeriodsTextField, TextField startPrincipalTextField, TextField interestTextField, Label futureValueLabel, Label presentValueLabel, Label numberPeriodsLabel, Label interestRateLabel, Label periodicPaymentLabel, Label startingInvestmentLabel, Label totalPrincipalLabel, Label totalInterestLabel){
        try {

            double fVValue = Double.parseDouble(futureValueTextField.getText());
            double numberPeriods = Double.parseDouble(noPeriodsTextField.getText());
            double interestRate = Double.parseDouble(interestTextField.getText());
            double rD = interestRate/100;
            double totalInterest = 0;
            double startPrincipal = Double.parseDouble(startPrincipalTextField.getText());
            double startBalance = startPrincipal;
            double startingInvestment = startPrincipal;
            double periodicPayment =(fVValue-startPrincipal*Math.pow(1+rD,numberPeriods))/((Math.pow(1+rD,numberPeriods)-1)/rD);
            double pValue = fVValue/Math.pow(1+rD,numberPeriods);

            for(int i=1;i<=numberPeriods;i++){
                double totalInterestValue = startBalance*rD;

                totalInterest += totalInterestValue;
                double EB=startBalance + totalInterestValue + periodicPayment;
                double totalPrincipal = startPrincipal+ periodicPayment;
                startPrincipal = totalPrincipal;
                startBalance = EB;

                if(i ==numberPeriods ){
                    futureValueLabel.setText(String.valueOf("FV (Future Value) : $" + roundNumber.format(fVValue)));
                    presentValueLabel.setText(String.valueOf("Present value : $" + roundNumber.format(pValue)));
                    numberPeriodsLabel.setText(String.valueOf("N (Number of Periods) : $" + numberPeriods));
                    interestRateLabel.setText(String.valueOf("I/Y (Interest Rate) : " + interestRate + "%"));
                    periodicPaymentLabel.setText(String.valueOf("PMT (Periodic Payment) : $" + roundNumber.format(periodicPayment)));
                    startingInvestmentLabel.setText(String.valueOf("Starting Investment : $" + roundNumber.format(startingInvestment)));
                    totalPrincipalLabel.setText(String.valueOf("Total Principal : $" + roundNumber.format(totalPrincipal)));
                    totalInterestLabel.setText(String.valueOf("Total Interest : $" + roundNumber.format(totalInterest)));
                    // -------- saving data in to json file --------------

                    //Creating a JSONObject object
                    JSONObject dataObject = new JSONObject();

                    //Inserting key-value pairs into the json object
                    dataObject.put("FV (Future Value) : ", "$" + roundNumber.format(fVValue));
                    dataObject.put("Present value : ", "$" + roundNumber.format(pValue));
                    dataObject.put("N (Number of Periods) : ", "$" + numberPeriods);
                    dataObject.put("I/Y (Interest Rate) : ", interestRate + "%");
                    dataObject.put("PMT (Periodic Payment) : ", "$" + roundNumber.format(periodicPayment));
                    dataObject.put("Starting Investment : ", "$" + roundNumber.format(startingInvestment));
                    dataObject.put("Total Principal : ", "$" + roundNumber.format(totalPrincipal));
                    dataObject.put("Total Interest : ", "$" + roundNumber.format(totalInterest));

                    // Create ID using data and time data.
                    DateTimeFormatter calculationID = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
                    LocalDateTime now = LocalDateTime.now();

                    JSONObject finalDataObject = new JSONObject();
                    finalDataObject.put(calculationID.format(now), dataObject);

                    try {
                        FileWriter file = new FileWriter("annuitypaymentcal.json");
                        file.write(finalDataObject.toJSONString());
                        file.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return true;
        }catch (NumberFormatException e){
            System.out.println("Please enter Valid Inputs");
            return false;
        }
    }
    public static void clearTextFields(TextField futureValueTextField , TextField noPeriodsTextField, TextField startPrincipalTextField, TextField interestTextField) {
        futureValueTextField.setText("");
        noPeriodsTextField.setText("");
        startPrincipalTextField.setText("");
        interestTextField.setText("");
    }
}
