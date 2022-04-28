package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public class HelloController {
    MysqlConn conn = new MysqlConn();

    @FXML
    private TextField dzialanie;


    @FXML
    private Button clear;

    @FXML
    private Button cztery;

    @FXML
    private Button dwa;

    @FXML
    private Button dzielenie;

    @FXML
    private Button dziewiec;

    @FXML
    private Button jeden;

    @FXML
    private Button minus;

    @FXML
    private Button mnozenie;

    @FXML
    private Button osiem;

    @FXML
    private Button piec;

    @FXML
    private Button plus;

    @FXML
    private Button pokazWynik;

    @FXML
    private Button siedem;

    @FXML
    private Button szesc;

    @FXML
    private Button trzy;
    @FXML
    private Button zero;
    private String operation;
    private float firstNumber;
    private float wynik;


    @FXML
    protected void onHelloButtonClick(ActionEvent event) throws SQLException {
      Obliczanie obl = new Obliczanie(event);
      obl.metoda();

        if(event.getSource() == jeden){
            dzialanie.setText(dzialanie.getText() + '1');
        }
        else if(event.getSource() == dwa) {
            dzialanie.setText(dzialanie.getText() + '2');
        }
        else if(event.getSource() == trzy) {
            dzialanie.setText(dzialanie.getText() + '3');
        }
        else if(event.getSource() == cztery) {
            dzialanie.setText(dzialanie.getText() + '4');
        }
        else if(event.getSource() == piec) {
            dzialanie.setText(dzialanie.getText() + '5');
        }
        else if(event.getSource() == szesc) {
            dzialanie.setText(dzialanie.getText() + '6');
        }
        else if(event.getSource() == siedem) {
            dzialanie.setText(dzialanie.getText() + '7');
        }
        else if(event.getSource() == osiem) {
            dzialanie.setText(dzialanie.getText() + '8');
        }
        else if(event.getSource() == dziewiec) {
            dzialanie.setText(dzialanie.getText() + '9');
        }
        else if(event.getSource() == zero) {
            dzialanie.setText(dzialanie.getText() + '0');
        }
        else if(event.getSource() == clear) {
            dzialanie.setText("");
        }
        else if(event.getSource() == plus) {
            firstNumber = Float.parseFloat(dzialanie.getText());
            operation = "+";
            dzialanie.setText("");
        }

        else if(event.getSource() == minus) {
            firstNumber = Float.parseFloat(dzialanie.getText());
            operation = "-";
            dzialanie.setText("");
        }

        else if(event.getSource() == mnozenie) {
            firstNumber = Float.parseFloat(dzialanie.getText());
            operation = "*";
            dzialanie.setText("");
        }
        else if(event.getSource() == dzielenie) {
            firstNumber = Float.parseFloat(dzialanie.getText());
            operation = "/";
            dzialanie.setText("");
        }
        else if(event.getSource() == pokazWynik) {
            float secondNumber = Float.parseFloat(dzialanie.getText());

            switch (operation) {
                case "+": {
                    wynik = firstNumber + secondNumber;
                    dzialanie.setText(String.valueOf(wynik));

                    PreparedStatement preparedStatement = conn.preparedStatement("INSERT INTO base_obliczenie (`pierwsza_liczba`, `operator`, `druga_liczba`, `wynik_dzialania`) VALUES (?, ?, ?, ?);");
                    preparedStatement.setString(1, String.valueOf(firstNumber));
                    preparedStatement.setString(2, operation);
                    preparedStatement.setString(3, String.valueOf(secondNumber));
                    preparedStatement.setString(4, String.valueOf(wynik));

                    preparedStatement.execute();
                    preparedStatement.close();

                    break;
                }
                case "-": {
                    wynik = firstNumber - secondNumber;
                    dzialanie.setText(String.valueOf(wynik));
                    PreparedStatement preparedStatement = conn.preparedStatement("INSERT INTO base_obliczenie (`pierwsza_liczba`, `operator`, `druga_liczba`, `wynik_dzialania`) VALUES (?, ?, ?, ?);");
                    preparedStatement.setString(1, String.valueOf(firstNumber));
                    preparedStatement.setString(2, operation);
                    preparedStatement.setString(3, String.valueOf(secondNumber));
                    preparedStatement.setString(4, String.valueOf(wynik));

                    preparedStatement.execute();
                    preparedStatement.close();
                    break;

                }
                case "*": {
                    wynik = firstNumber * secondNumber;
                    dzialanie.setText(String.valueOf(wynik));
                    PreparedStatement preparedStatement = conn.preparedStatement("INSERT INTO base_obliczenie (`pierwsza_liczba`, `operator`, `druga_liczba`, `wynik_dzialania`) VALUES (?, ?, ?, ?);");
                    preparedStatement.setString(1, String.valueOf(firstNumber));
                    preparedStatement.setString(2, operation);
                    preparedStatement.setString(3, String.valueOf(secondNumber));
                    preparedStatement.setString(4, String.valueOf(wynik));

                    preparedStatement.execute();
                    preparedStatement.close();
                    break;
                }
                case "/": {
                    wynik = firstNumber / secondNumber;
                    dzialanie.setText(String.valueOf(wynik));
                    PreparedStatement preparedStatement = conn.preparedStatement("INSERT INTO base_obliczenie (`pierwsza_liczba`, `operator`, `druga_liczba`, `wynik_dzialania`) VALUES (?, ?, ?, ?);");
                    preparedStatement.setString(1, String.valueOf(firstNumber));
                    preparedStatement.setString(2, operation);
                    preparedStatement.setString(3, String.valueOf(secondNumber));
                    preparedStatement.setString(4, String.valueOf(wynik));

                    preparedStatement.execute();
                    preparedStatement.close();
                    break;
                }
            }
        }

    }

}