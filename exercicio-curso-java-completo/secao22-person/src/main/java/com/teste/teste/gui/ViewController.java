package com.teste.teste.gui;

import com.teste.teste.gui.util.Alerts;
import com.teste.teste.gui.util.Constraints;
import com.teste.teste.model.entites.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class ViewController implements Initializable {

    @FXML
    private ComboBox<Person> comboBoxPerson;

    @FXML
    private Button btAll;

    @FXML
    public void onBtAllAction(){
        for(Person p : comboBoxPerson.getItems()){
            System.out.println(p);
        }
    }

    @FXML
    private ObservableList<Person> obsList;

    public void onComboBoxPersonAction() {
        Person person = comboBoxPerson.getSelectionModel().getSelectedItem();
        System.out.println(person);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Person> list = new ArrayList<>();
        list.add(new Person(1, "Maria", "maria@gmail.com"));
        list.add(new Person(2, "joao", "joao@gmail.com"));
        list.add(new Person(3, "pedro", "pedro@gmail.com"));
        list.add(new Person(4, "Marta", "marta@gmail.com"));

        obsList = FXCollections.observableArrayList(list);
        comboBoxPerson.setItems(obsList);

        Callback<ListView<Person>, ListCell<Person>> factory = lv -> new ListCell<Person>() {
            @Override
            protected void updateItem(Person item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item.getName());
            }
        };
        comboBoxPerson.setCellFactory(factory);
        comboBoxPerson.setButtonCell(factory.call(null));
    }
}
