package ch.makery.address;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ch.makery.address.model.*;
import ch.makery.address.view.PersonOverviewController;


public class MainApp extends Application {

   // private ObservableList<Person> personData = FXCollections.observableArrayList();

    /**
     * Constructor
     */
//    public MainApp() {
//        // Add some sample data
//        personData.add(new Person("Hans", "Muster"));
//        personData.add(new Person("Ruth", "Mueller"));
//        personData.add(new Person("Heinz", "Kurz"));
//        personData.add(new Person("Cornelia", "Meier"));
//        personData.add(new Person("Werner", "Meyer"));
//        personData.add(new Person("Lydia", "Kunz"));
//        personData.add(new Person("Anna", "Best"));
//        personData.add(new Person("Stefan", "Meier"));
//        personData.add(new Person("Martin", "Mueller"));
//    }
  
    /**
     * Returns the data as an observable list of Persons. 
     * @return
     */
//    public ObservableList<Person> getPersonData() {
//        return personData;
//    }
    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddressApp");

        initRootLayout();

        showPersonOverview();
    }
    
    /**
     * Initializes the root layout.
     * @throws IOException 
     */
    public void initRootLayout() throws IOException {
       // Load root layout from fxml file.
    	FXMLLoader loader = new FXMLLoader();
          loader.setLocation(MainApp.class.getResource("view/test.fxml"));
          rootLayout = (BorderPane) loader.load();            
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
    }

    /**
     * Shows the person overview inside the root layout.
     */

    public void showPersonOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/PersonOverveiw.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(personOverview);

            // Give the controller access to the main app.
            PersonOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Returns the main stage.
     * @return
     */
//    public Stage getPrimaryStage() {
//        return primaryStage;
//    }

    public static void main(String[] args) {
        launch(args);
    }
}