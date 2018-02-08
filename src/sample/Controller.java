package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML public ComboBox<String> model;
    @FXML public TextField quantity;
    @FXML public Label status;
//    @FXML public ComboBox<String> cargoType;

    public void submit(ActionEvent evt){
        String selectedBike = "Not selected";
        if (!model.getSelectionModel().isEmpty()) selectedBike = model.getSelectionModel().getSelectedItem();
        int quantityBike = Integer.parseInt(quantity.getText());
//        String selectedCargo = cargoType.getSelectionModel().getSelectedItem();

        try {
            validateOrder(selectedBike,quantityBike);
        } catch (TooManyBikesException e) {
            status.setText(e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    public void validateOrder(String selectedBike, int quantity) throws TooManyBikesException{
        if (quantity<=0){
            status.setText("Must be above zero");
        }else {
            switch (selectedBike){
                case "Kuban":
                    if (quantity>5) throw new TooManyBikesException();
                    else status.setText("Kuban OK!");
                    break;
                case "Sartr":
                    if (quantity>8) throw new TooManyBikesException();
                    else status.setText("Sartr OK!");
                    break;
                case "Ural":
                    if (quantity>3) throw new TooManyBikesException();
                    else status.setText("Ural OK");
                    break;
                case "Not selected":
                    status.setText("Choose model");
                    break;
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        model.getItems().setAll("Kuban","Sartr","Ural");

    }
}
