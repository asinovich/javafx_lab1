package org.example;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField side1;

    @FXML
    private TextField side2;

    @FXML
    private TextField side3;

    @FXML
    private Text text1;

    @FXML
    private Text text2;

    @FXML
    private Text text3;

    @FXML
    void buttonChek(ActionEvent event) {

        if(chekTextFieldEmpty() || !chekTextFieldNumber()){     //Проверка на введённые дынные
            errorMessage("Стороны треугольника должны быть заполнены числами");
            setResultTest("Нет", "Нет" ,"Нет");
        }
        else{

            int firstSide = Integer.parseInt(side1.getText());
            int secondSide = Integer.parseInt(side2.getText());
            int thirdSide = Integer.parseInt(side3.getText());
            Util u = new Util();

            if(firstSide < 1 || secondSide < 1 || thirdSide < 1){
                errorMessage("Стороны треугольника должны быть больше 0");
            }
            else if(firstSide + secondSide <= thirdSide || secondSide + thirdSide <= secondSide || firstSide + thirdSide <= secondSide){
                errorMessage("Треугольник с такими сторонами не сущиствует");
            }
            else if(firstSide == secondSide && secondSide == thirdSide){
                setResultTest("Да", "Нет" ,"Нет");
            }
            else if(firstSide == secondSide || secondSide == thirdSide || firstSide == thirdSide) {
                if (u.pythagoras(firstSide, secondSide, thirdSide)) {
                    setResultTest("Нет", "Да" ,"Да");
                    return;
                }
                setResultTest("Нет", "Да" ,"Нет");

            }
            else if(u.pythagoras(firstSide, secondSide, thirdSide)){
                setResultTest("Нет", "Нет" ,"Да");
            }
            else{
                setResultTest("Нет", "Нет" ,"Нет");
            }

        }

    }

    @FXML
    void initialize() { }

    //Вывод результата на экран
    public void setResultTest(String txt1, String txt2, String txt3){
        text1.setText(txt1);
        text2.setText(txt2);
        text3.setText(txt3);
    }

    //Проверка сторон треугольника на число
    public boolean chekTextFieldNumber(){

        try{
            Integer.parseInt(side1.getText());
            Integer.parseInt(side2.getText());
            Integer.parseInt(side3.getText());
        }catch (Exception e){
            return false;
        }
        return true;
    }

    //Проверка сторон треугольника на пустоту
    public boolean chekTextFieldEmpty(){

        if(side1.getText().equals("") || side2.getText().equals("") || side3.getText().equals("")){
            return true;
        }
        return false;
    }

    //Предупреждениие об ошибки
    public void errorMessage(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ошибка");
        alert.setHeaderText(message);
        alert.showAndWait();
    }



}





