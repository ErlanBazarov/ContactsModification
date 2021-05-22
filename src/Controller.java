import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.Callback;

public class Controller {

    @FXML
    private ListView<Contact> contactsListView;

    @FXML
    private Label firstNameLabel;

    @FXML
    private Label lastNameLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private Label phoneNumberLabel;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField phoneNumberTextField;

    private final ObservableList<Contact> contacts = FXCollections.observableArrayList();

    public void initialize() {
      contacts.add(new Contact("erlan", "bazarov", "haha@mail.ru", "+99622211322", "images/download.png"));
      contacts.add(new Contact("david", "smith", "lol@mail.ru", "+321123213", "images/download.png"));
      contacts.add(new Contact("asda", "bqtw", "easdsa@mail.ru", "+24132132", "images/download.png"));
      contactsListView.setItems(contacts.sor);

      contactsListView.getSelectionModel().selectedItemProperty().addListener(
        new ChangeListener<Contact>(){
          @Override
          public void changed(javafx.beans.value.ObservableValue<? extends Contact> arg0, Contact oldValue, Contact newValue) {
            firstNameTextField.setText(newValue.getFirstName());
            lastNameTextField.setText(newValue.getLastName());
            emailTextField.setText(newValue.getEmail());
            phoneNumberTextField.setText(newValue.getPhoneNumber());
          };
        }
      );

      contactsListView.setCellFactory(
        new Callback<ListView<Contact>, ListCell<Contact>>() {
          @Override
          public ListCell<Contact> call(ListView<Contact> listView) {
            return new ImageTextCell();
          }
        }
      );
    }

}
