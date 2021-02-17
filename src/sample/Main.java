package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//import java.awt.*;
//public class ConnectionUtil {
//    Connection conn=null;
//    public static Connection conDB()
//    {
//        try{
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con= DriverManager.getConnection("jdbc:mysql://localhost/keptoo","root","");
//            return con;
//        }catch (Exception ex){
//            return null;
//        }
//    }
//}

public class Main extends Application {

        Stage window;
        TableView<Game> gamesCollection;
        TextField nameInput, priceInput, releaseDateInput;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("My games");

        //name column

        TableColumn<Game, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        //price column
        TableColumn<Game, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        //release date column
        TableColumn<Game, Integer> releaseDateColumn = new TableColumn<>("Release Date");
        releaseDateColumn.setMinWidth(200);
        releaseDateColumn.setCellValueFactory(new PropertyValueFactory<>("releaseDate"));

        //Name input
        nameInput = new TextField();
        nameInput.setPromptText("Name");
        nameInput.setMinWidth(100);

        //Name input
        priceInput = new TextField();
        priceInput.setPromptText("Price");

        //Name input
        releaseDateInput = new TextField();
        releaseDateInput.setPromptText("Release Date");

        //Button

        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addButtonClicked());
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteBUttonClicked());
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameInput, priceInput, releaseDateInput, addButton, deleteButton);

        gamesCollection = new TableView<>();
        gamesCollection.setItems(getGames());
        gamesCollection.getColumns().addAll(nameColumn, priceColumn, releaseDateColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(gamesCollection, hBox);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    public void addButtonClicked() {
        Game game = new Game();
        game.setName(nameInput.getText());
        game.setPrice(Double.parseDouble(priceInput.getText()));
        game.setReleaseDate(Integer.parseInt(releaseDateInput.getText()));
        gamesCollection.getItems().add(game);
        nameInput.clear();
        priceInput.clear();
        releaseDateInput.clear();
    }

    public void deleteBUttonClicked() {
        ObservableList<Game> gameSelected, allgames;
        allgames = gamesCollection.getItems();
        gameSelected = gamesCollection.getSelectionModel().getSelectedItems();
        gameSelected.forEach(allgames::remove);

    }

    //Get all the Games
    public ObservableList<Game> getGames() {
        ObservableList<Game> games = FXCollections.observableArrayList();
        games.add(new Game("Rainbow six siege", 30, 2016));
        games.add(new Game("Call of duty MW", 60, 2019));
        games.add(new Game("Destiny 2", 30, 2018));
        games.add(new Game("Battlefield 1", 30, 2016));
        games.add(new Game("Battlefield V", 60, 2018));
        games.add(new Game("Assassins Creed Origins", 30, 2018));
        return games;

    }

}
