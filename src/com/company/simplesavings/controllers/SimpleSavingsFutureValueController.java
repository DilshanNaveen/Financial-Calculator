package com.company.simplesavings.controllers;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

public class SimpleSavingsFutureValueController {

    private static DecimalFormat roundNumber = new DecimalFormat("0.00");

    public static boolean calculateSavings(TextField noPeriodsTextField, TextField sPrincipalLabelTextField, TextField interestTextField, Label futureValueLabel){
        try {
            double yearsTime  = Double.parseDouble(noPeriodsTextField.getText());
            double interestRate = Double.parseDouble(sPrincipalLabelTextField.getText());
            double presentValue =  Double.parseDouble(interestTextField.getText());
            double rd = interestRate/100;

            double futureValue = presentValue*(Math.pow((1+(rd/12)),(12* yearsTime)));

            futureValueLabel.setText(String.valueOf("FV (Future Value) : $" + roundNumber.format(futureValue)));

            // -------- saving data in to json file --------------

            //Creating a JSONObject object
            JSONObject jsonObject = new JSONObject();

            //Inserting key-value pairs into the json object
            jsonObject.put("FV (Future Value) : ", "$" + roundNumber.format(futureValue));

            try {
                FileWriter file = new FileWriter("SimpleSavingsFutureValuecCal.json");
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

    public static void clearTextFields(TextField noPeriodsTextField, TextField sPrincipalLabelTextField, TextField interestTextField) {
        noPeriodsTextField.setText("");
        interestTextField.setText("");
        sPrincipalLabelTextField.setText("");
    }

}
