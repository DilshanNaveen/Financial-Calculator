package com.company.simplesavings.presentValue.controllers;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

public class PresentValueController {

    private static DecimalFormat roundNumber = new DecimalFormat("0.00");

    public static boolean calculateSavings(TextField futureValueTextField, TextField interestRateTextField, TextField yearsTimeTextField, Label futureValueLabel){
        try {
            double futureValue =  Double.parseDouble(futureValueTextField.getText());
            double interestRate = Double.parseDouble(interestRateTextField.getText());
            double yearsTime  = Double.parseDouble(yearsTimeTextField.getText());


            double rd=interestRate/100;
            double presentValue = futureValue /(Math.pow((1+(rd/12)),12*yearsTime));

            futureValueLabel.setText(String.valueOf("PV (Present Value) : $" + roundNumber.format(presentValue)));

            // -------- saving data in to json file --------------

            //Creating a JSONObject object
            JSONObject jsonObject = new JSONObject();

            //Inserting key-value pairs into the json object
            jsonObject.put("PV (Present Value) : ", "$" + roundNumber.format(presentValue));

            try {
                FileWriter file = new FileWriter("presentValueCal.json");
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
