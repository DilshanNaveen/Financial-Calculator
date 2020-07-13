    package com.company;

    import com.company.loancalculator.LoanCalculator;
    import com.company.simplesavings.SimpleSavingsFutureValue;
    import javafx.application.Application;
    import javafx.geometry.Insets;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.scene.control.Label;
    import javafx.scene.image.Image;
    import javafx.scene.layout.AnchorPane;
    import javafx.stage.Stage;


    import static com.company.compoundinterest.CompoundInterestCalculator.displayCompoundInterest;

    public class FinancialCalculator extends Application {

        public static void main(String[] args) {
            launch(args);
        }

        @Override
        public void start(Stage financialCalculator) throws Exception {
            financialCalculator.setTitle("Financial Calculator");

            AnchorPane financialCalculatorPane = new AnchorPane();
            financialCalculatorPane.setPadding(new Insets(50, 50, 50, 50));

            Scene mainScene = new Scene(financialCalculatorPane, 1280, 900);

            Label title = new Label("Financial Calculator");
            AnchorPane.setLeftAnchor(title, 350.0);
            AnchorPane.setTopAnchor(title, 10.0);

            // Compound Interest Savings Button.
            Button compoundInterestSavings = new Button("Compound Interest");
            compoundInterestSavings.setOnAction(e -> displayCompoundInterest(financialCalculator, mainScene));
            AnchorPane.setTopAnchor(compoundInterestSavings, 120.0);
            AnchorPane.setLeftAnchor(compoundInterestSavings, 350.0);
            compoundInterestSavings.setPrefWidth(500);
            compoundInterestSavings.setPrefHeight(100);

            // Simple Savings Button.
            Button simpleSavingsButton = new Button("Simple Savings");
            simpleSavingsButton.setOnAction(e -> SimpleSavingsFutureValue.displaySimpleSavings(financialCalculator, mainScene));
            AnchorPane.setTopAnchor(simpleSavingsButton, 260.0);
            AnchorPane.setLeftAnchor(simpleSavingsButton, 350.0);
            simpleSavingsButton.setPrefWidth(500);
            simpleSavingsButton.setPrefHeight(100);

            // Loans Calculator Button.
            Button loanCalculatorButton = new Button("Loans Calculator");
            loanCalculatorButton.setOnAction(e -> LoanCalculator.displayLoanCalculator(financialCalculator, mainScene));
            AnchorPane.setTopAnchor(loanCalculatorButton, 410.0);
            AnchorPane.setLeftAnchor(loanCalculatorButton, 350.0);
            loanCalculatorButton.setPrefWidth(500);
            loanCalculatorButton.setPrefHeight(100);

            // Mortgage Calculator Button.
            Button mortgageCalculatorButton = new Button("Mortgage Calculator");
            AnchorPane.setTopAnchor(mortgageCalculatorButton, 560.0);
            AnchorPane.setLeftAnchor(mortgageCalculatorButton, 350.0);
            mortgageCalculatorButton.setPrefWidth(500);
            mortgageCalculatorButton.setPrefHeight(100);

            // Close Button.
            Button closeButton = new Button("Close");
            AnchorPane.setTopAnchor(closeButton, 710.0);
            AnchorPane.setLeftAnchor(closeButton, 350.0);
            closeButton.setPrefWidth(500);
            closeButton.setPrefHeight(100);
            closeButton.setOnAction(e -> financialCalculator.close());

            // Help Button.
            Button helpButton = new Button("Help");
            helpButton.getStyleClass().add("help-style");
            AnchorPane.setTopAnchor(helpButton, 760.0);
            AnchorPane.setLeftAnchor(helpButton, 1000.0);
            helpButton.setPrefWidth(200);
            helpButton.setPrefHeight(50);


            financialCalculatorPane.getChildren().addAll(title, compoundInterestSavings, simpleSavingsButton, loanCalculatorButton, mortgageCalculatorButton, closeButton, helpButton);
            mainScene.getStylesheets().add("MenuStylesheet.css");
            financialCalculator.setResizable(false);
            financialCalculator.getIcons().add(new Image(getClass().getResource("icon.png").toExternalForm()));
            financialCalculator.setScene(mainScene);
            financialCalculator.show();
        }

    }
