package my.project;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import my.project.view.MainWindowsController;

public class Main extends Application {
	private Stage stage;
	private BorderPane backgroud;
	@Override
	public void start(Stage primaryStage) throws IOException {
		this.stage=primaryStage;
		this.stage.setTitle("»æÍ¼°å");
		initial();
		showMainWindows();
	}
	public void initial() throws IOException{
		  FXMLLoader loader = new FXMLLoader();
		  loader.setLocation(Main.class.getResource("view/backgroud.fxml"));
		  backgroud= (BorderPane)loader.load();
		  Scene scene=new Scene(backgroud);
		  stage.setScene(scene);
		  stage.show();
	}
	public void showMainWindows() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/MainWindows.fxml"));
        AnchorPane pane=(AnchorPane)loader.load();
        backgroud.setCenter(pane);
        MainWindowsController controller=loader.getController();
        controller.setMainWindows(this);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
