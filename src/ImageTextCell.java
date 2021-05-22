import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * ImageTextCell
 */
public class ImageTextCell extends ListCell<Contact> {
  private VBox vBox = new VBox(8.0);
  private ImageView imageView = new ImageView();
  private Label nameLabel = new Label();
  public ImageTextCell() {
    vBox.getChildren().add(imageView);
    vBox.getChildren().add(nameLabel);
  }

  @Override
  protected void updateItem(Contact contact, boolean empty) {
    super.updateItem(contact, empty);

    if (empty || contact == null)
      setGraphic(null);
    else{
      imageView.setImage(new Image(contact.getImagePath()));
      nameLabel.setText(contact.getFirstName() + " " + contact.getLastName());
      setGraphic(vBox);
    }
  }

  

  
  
}