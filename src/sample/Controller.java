package sample;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;

public class Controller {

    @FXML
    private ComboBox<ItemType> cbb_itemType;


    @FXML
    public void initialize(){
        cbb_itemType.getItems().addAll(ItemType.AUDIO,ItemType.VISUAL,
                ItemType.AUDIOMOBILE,ItemType.VISUALMOBILE);
        cbb_itemType.setValue(ItemType.AUDIO);
    }
}

