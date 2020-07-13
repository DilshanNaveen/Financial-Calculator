package com.company.simplesavings.interestRate.controllers;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

public class InterestRateController{

    private static DecimalFormat roundNumber = new DecimalFormat("0.00");

    public static boolean calculateSavings(TextField futureValueTextField, TextField presentValueTextField, TextField yearsTimeTextField, Label interestRateLabel){
        try {
            double futureValue  = Double.parseDouble(futureValueTextField.getText());
            double presentValue =  Double.parseDouble(presentValueTextField.getText());
            double yearsTime = Double.parseDouble(yearsTimeTextField.getText());

            double rd=12*((Math.pow((futureValue/presentValue),(1/(12*yearsTime))))-1);
            double interestRate = rd*100;

            interestRateLabel.setText(String.valueOf("I/Y (Interest Rate) : " + roundNumber.format(interestRate) + "%"));

            // -------- saving data in to json file --------------

            //Creating a JSONObject object
            JSONObject jsonObject = new JSONObject();

            //Inserting key-value pairs into the json object
            jsonObject.put("I/Y (Interest Rate) : ", roundNumber.format(interestRate) + "%");

            try {
                FileWriter file = new FileWriter("interestRateController.json");
                file.write(jsonObject.toJSONString());
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }catch (NumberFormatException e){
            System.out.println("Please enter Valid Inputs");
            return false;
        }
    }

    public static void clearTextFields(TextField futureValueTextField, TextField presentValueTextField, TextField yearsTimeTextField) {
        futureValueTextField.setText("");
        presentValueTextField.setText("");
        yearsTimeTextField.setText("");
    }

}
