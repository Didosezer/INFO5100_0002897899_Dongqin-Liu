package com.example.demo2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calculator4 extends Application {

    private TextField display = new TextField();
    private double num1 = 0;
    private String operator = "";

    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(10);

        display.setEditable(false);
        pane.add(display, 0, 0, 4, 1);

        Button[] numButtons = new Button[10];
        for (int i = 0; i < 10; i++) {
            numButtons[i] = new Button(String.valueOf(i));
            numButtons[i].setOnAction(e -> display.setText(display.getText() + ((Button) e.getSource()).getText()));
        }

        Button addButton = createOperatorButton("+");
        Button subtractButton = createOperatorButton("-");
        Button multiplyButton = createOperatorButton("*");
        Button divideButton = createOperatorButton("/");
        Button equalsButton = new Button("=");
        equalsButton.setOnAction(e -> calculate());

        Button clearButton = new Button("C");
        clearButton.setOnAction(e -> display.clear());

        pane.add(numButtons[1], 0, 1);
        pane.add(numButtons[2], 1, 1);
        pane.add(numButtons[3], 2, 1);
        pane.add(addButton, 3, 1);

        pane.add(numButtons[4], 0, 2);
        pane.add(numButtons[5], 1, 2);
        pane.add(numButtons[6], 2, 2);
        pane.add(subtractButton, 3, 2);

        pane.add(numButtons[7], 0, 3);
        pane.add(numButtons[8], 1, 3);
        pane.add(numButtons[9], 2, 3);
        pane.add(multiplyButton, 3, 3);

        pane.add(numButtons[0], 1, 4);
        pane.add(divideButton, 3, 4);
        pane.add(equalsButton, 2, 4);
        pane.add(clearButton, 0, 4);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Button createOperatorButton(String op) {
        Button button = new Button(op);
        button.setOnAction(e -> {
            num1 = Double.parseDouble(display.getText());
            operator = op;
            display.clear();
        });
        return button;
    }

    private void calculate() {
        double num2 = Double.parseDouble(display.getText());
        switch (operator) {
            case "+":
                display.setText(String.valueOf(num1 + num2));
                break;
            case "-":
                display.setText(String.valueOf(num1 - num2));
                break;
            case "*":
                display.setText(String.valueOf(num1 * num2));
                break;
            case "/":
                if (num2 != 0) {
                    display.setText(String.valueOf(num1 / num2));
                } else {
                    display.setText("Error");
                }
                break;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}