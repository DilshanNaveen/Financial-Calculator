package com.company.simplesavings.time.controllers;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

public class TimeController {

    private static DecimalFormat roundNumber = new DecimalFormat("0");

    public static boolean calculateSavings(TextField futureValueTextField, TextField interestRateTextField, TextField presentValueTextField, Label yearsTimeLabel){
        try {
            double futureValue =  Double.parseDouble(futureValueTextField.getText());
            double interestRate = Double.parseDouble(interestRateTextField.getText());
            double presentValue  = Double.parseDouble(presentValueTextField.getText());
            double rd = interestRate / 100;
            double yearsTime =(Math.log(futureValue/presentValue))/(12*(Math.log(1+(rd/12))));

            yearsTimeLabel.setText(String.valueOf("Time in years : " + roundNumber.format(yearsTime)));

            // -------- saving data in to json file --------------

            //Creating a JSONObject object
            JSONObject jsonObject = new JSONObject();

            //Inserting key-value pairs into the json object
            jsonObject.put("Time in years : ", roundNumber.format(yearsTime));

            try {
                FileWriter file = new FileWriter("timeYearsCal.json");
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

    public static void clearTextFields(TextField futureValueTextField, TextField interestRateTextField, TextField presentValueTextField) {
        futureValueTextField.setText("");
        interestRateTextField.setText("");
        presentValueTextField.setText("");
    }

}
