/**
   *Author: Yee H. Wong
  *CLID: yxw0087
  *Class: CMPS 360
  *Assignment: Project 1
   *Due Date: 10/21/14
  *Description: Simulate a simply infix integer calculator using JavaFX
 */

package calculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculatorController implements Initializable {

    boolean replace;
    int value, current;
    String operation;
    int input_num;
    @FXML
    private Label label;
    @FXML
    private TextField input;

    /**
     * Default constructor of CalculatorController
     */
    public CalculatorController() {
        value = 0;
        current = 0;
        operation = "";
        replace = false;
    }

    @FXML
    /**
     * Method to be invoked when button 1 is pressed.
     */
    private void one(ActionEvent event) {

        if (operation == "") {
            if (replace == true) {
                value = 1;
                label.setText(String.valueOf(value));
                replace = false;
            } else {
                value = Integer.parseInt(String.valueOf(value) + "1");
                label.setText(String.valueOf(value));
            }
        } else {
            current = Integer.parseInt(String.valueOf(current) + "1");
            label.setText(String.valueOf(current));
        }

    }

    @FXML
    /**
     * Method to be invoked when button 2 is pressed.
     */
    private void two(ActionEvent event) {

        if (operation == "") {
            if (replace == true) {
                value = 2;
                label.setText(String.valueOf(value));
                replace = false;
            } else {
                value = Integer.parseInt(String.valueOf(value) + "2");
                label.setText(String.valueOf(value));
            }
        } else {
            current = Integer.parseInt(String.valueOf(current) + "2");
            label.setText(String.valueOf(current));
        }
    }

    @FXML
    /**
     * Method to be invoked when button 3 is pressed.
     */
    private void three(ActionEvent event) {

        if (operation == "") {
            if (replace == true) {
                value = 3;
                label.setText(String.valueOf(value));
                replace = false;
            } else {
                value = Integer.parseInt(String.valueOf(value) + "3");
                label.setText(String.valueOf(value));
            }
        } else {
            current = Integer.parseInt(String.valueOf(current) + "3");
            label.setText(String.valueOf(current));
        }
    }

    @FXML
    /**
     * Method to be invoked when button 4 is pressed.
     */
    private void four(ActionEvent event) {

        if (operation == "") {
            if (replace == true) {
                value = 4;
                label.setText(String.valueOf(value));
                replace = false;
            } else {
                value = Integer.parseInt(String.valueOf(value) + "4");
                label.setText(String.valueOf(value));
            }
        } else {
            current = Integer.parseInt(String.valueOf(current) + "4");
            label.setText(String.valueOf(current));
        }
    }

    @FXML
    /**
     * Method to be invoked when button 5 is pressed.
     */
    private void five(ActionEvent event) {

        if (operation == "") {
            if (replace == true) {
                value = 5;
                label.setText(String.valueOf(value));
                replace = false;
            } else {
                value = Integer.parseInt(String.valueOf(value) + "5");
                label.setText(String.valueOf(value));
            }
        } else {
            current = Integer.parseInt(String.valueOf(current) + "5");
            label.setText(String.valueOf(current));
        }
    }

    @FXML
    /**
     * Method to be invoked when button 6 is pressed.
     */
    private void six(ActionEvent event) {

        if (operation == "") {
            if (replace == true) {
                value = 6;
                label.setText(String.valueOf(value));
                replace = false;
            } else {
                value = Integer.parseInt(String.valueOf(value) + "6");
                label.setText(String.valueOf(value));
            }
        } else {
            current = Integer.parseInt(String.valueOf(current) + "6");
            label.setText(String.valueOf(current));
        }
    }

    @FXML
    /**
     * Method to be invoked when button 7 is pressed.
     */
    private void seven(ActionEvent event) {

        if (operation == "") {
            if (replace == true) {
                value = 7;
                label.setText(String.valueOf(value));
                replace = false;
            } else {
                value = Integer.parseInt(String.valueOf(value) + "7");
                label.setText(String.valueOf(value));
            }
        } else {
            current = Integer.parseInt(String.valueOf(current) + "7");
            label.setText(String.valueOf(current));
        }
    }

    @FXML
    /**
     * Method to be invoked when button 8 is pressed.
     */
    private void eight(ActionEvent event) {

        if (operation == "") {
            if (replace == true) {
                value = 8;
                label.setText(String.valueOf(value));
                replace = false;
            } else {
                value = Integer.parseInt(String.valueOf(value) + "8");
                label.setText(String.valueOf(value));
            }
        } else {
            current = Integer.parseInt(String.valueOf(current) + "8");
            label.setText(String.valueOf(current));
        }
    }

    @FXML
    /**
     * Method to be invoked when button 9 is pressed.
     */
    private void nine(ActionEvent event) {

        if (operation == "") {
            if (replace == true) {
                value = 9;
                label.setText(String.valueOf(value));
                replace = false;
            } else {
                value = Integer.parseInt(String.valueOf(value) + "9");
                label.setText(String.valueOf(value));
            }
        } else {
            current = Integer.parseInt(String.valueOf(current) + "9");
            label.setText(String.valueOf(current));
        }
    }

    @FXML
    /**
     * Method to be invoked when button 0 is pressed.
     */
    private void zero(ActionEvent event) {

        if (operation == "") {
            if (replace == true) {
                value = 0;
                label.setText(String.valueOf(value));
                replace = false;
            } else {
                value = Integer.parseInt(String.valueOf(value) + "0");
                label.setText(String.valueOf(value));
            }
        } else {
            current = Integer.parseInt(String.valueOf(current) + "0");
            label.setText(String.valueOf(current));
        }
    }

    @FXML
    /**
     * Method to be invoked when button Clr is pressed.
     */
    private void clear(ActionEvent event) {

        value = 0;
        label.setText(String.valueOf(value));
        operation = "";
        replace = false;
        input.clear();
    }

    @FXML
    /**
     * Method to be invoked when button = is pressed.
     */
    private void equal(ActionEvent event) {

        switch (operation) {
            case "plus":
                value += current;
                break;
            case "minus":
                value -= current;
                break;
            case "multiply":
                value *= current;
                break;
            case "divide":
                value /= current;
                break;
            default:
                break;
        }
        current = 0;
        label.setText(String.valueOf(value));
        operation = "";
        replace = true;
    }

    @FXML
    /**
     * Method to be invoked when button + is pressed.
     */
    private void plus(ActionEvent event) {
        switch (operation) {
            case "plus":
                value += current;
                break;
            case "minus":
                value -= current;
                break;
            case "multiply":
                value *= current;
                break;
            case "divide":
                value /= current;
                break;
            default:
                break;
        }
        operation = "plus";
        current = 0;
        label.setText(String.valueOf(value));
        replace = false;
    }

    @FXML
    /**
     * Method to be invoked when button - is pressed.
     */
    private void minus(ActionEvent event) {
        switch (operation) {
            case "plus":
                value += current;
                break;
            case "minus":
                value -= current;
                break;
            case "multiply":
                value *= current;
                break;
            case "divide":
                value /= current;
                break;
            default:
                break;
        }
        operation = "minus";
        current = 0;
        label.setText(String.valueOf(value));
        replace = false;
    }

    @FXML
    /**
     * Method to be invoked when button / is pressed.
     */
    private void divide(ActionEvent event) {
        switch (operation) {
            case "plus":
                value += current;
                break;
            case "minus":
                value -= current;
                break;
            case "multiply":
                value *= current;
                break;
            case "divide":
                value /= current;
                break;
            default:
                break;
        }
        operation = "divide";
        current = 0;
        label.setText(String.valueOf(value));
        replace = false;
    }

    @FXML
    /**
     * Method to be invoked when button x is pressed.
     */
    private void multiply(ActionEvent event) {
        switch (operation) {
            case "plus":
                value += current;
                break;
            case "minus":
                value -= current;
                break;
            case "multiply":
                value *= current;
                break;
            case "divide":
                value /= current;
                break;
            default:
                break;
        }
        operation = "multiply";
        current = 0;
        label.setText(String.valueOf(value));
        replace = false;
    }
    
    @FXML
    /**
     * Method to be invoked when the close option from the drop down 
     * menu of calculator is pressed.
     */
    private void close(ActionEvent event) {
        System.exit(0);
    }
    
    @FXML
    /**
     * Method to be invoked when user chose to type in the numbers from keyboard.
     * The enter key must be pressed after user key in the numbers.
     */
    private void input(ActionEvent event) {
        if (operation == "") {
            value = Integer.parseInt(input.getText());
            label.setText(String.valueOf(value));
            input.clear();

        } else {
            current = Integer.parseInt(input.getText());
            label.setText(String.valueOf(current));
            input.clear();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {        
    }

}
