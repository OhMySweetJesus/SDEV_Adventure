package com.ivytech.adventure;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import java.util.Scanner;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.geometry.Pos;

import java.io.IOException;


public class HelloApplication extends Application {
    public static Player player = new Player();
    public static final int WIDTH = 640;
    public static final int HEIGHT = 480;
    protected Text text = new Text(50, 50, "JAVAFX Programming");
    public static final Color bgColor = Color.valueOf("#1d1d1d");
    public static final Color fontColor = Color.valueOf("#808080");
    public static final BackgroundFill bgFill = new BackgroundFill(bgColor, new CornerRadii(10), new Insets(10));
    public static final Background bg = new Background(bgFill);
    public static final Font font = Font.font("Courier", FontWeight.BOLD, 15);

    @Override
    public void start(Stage stage) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BorderPane pane = new BorderPane();
        Label startLabel = new Label("Welcome to SDEV Adventure");
        startLabel.setStyle("-fx-text-fill: #888888; -fx-font-size: 16px;");
        Button startButton = new Button("START");
        pane.setCenter(startLabel);
        pane.setBottom(startButton);
        startButton.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10));
        pane.setBackground(bg);
        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        startButton.setOnAction(e -> scene2(stage));
        stage.setTitle("SDEV Adventure");
        stage.setScene(scene);
        stage.show();
    }
    public static void scene2(Stage stage) {
        BorderPane pane = new BorderPane();
        Button getSword = new Button("Pick up sword");
        Button walkToHouse = new Button("Walk towards house");
//        ImageView greenField = new ImageView("greenField.jpg");
        Label introLabel = new Label("You wake up in a field of grass. \nYou stand up and see a \nhouse in the distance.\n" +
                "On the ground is a sword.");
        introLabel.setStyle("-fx-text-fill: #888888; -fx-font-size: 16px;");
        introLabel.setTextAlignment(TextAlignment.CENTER);
        introLabel.setFont(font);
        pane.setCenter(introLabel);
//        greenField.setFitHeight(200);
//        greenField.setFitWidth(200);
//        pane.add(greenField, 0, 1, 1, 2);
        GridPane.setColumnSpan(pane, 2);
        pane.setRight(getSword);
        pane.setLeft(walkToHouse);
        pane.setPadding(new Insets(10));
        pane.setBackground(bg);
        Scene scene2 = new Scene(pane, WIDTH, HEIGHT);
        getSword.setOnAction(e -> {
            Item sword = new Item(10, 15, 0, 0);
            player.setInventory(sword);
            Label swordPickupMessage = new Label("You picked up a sword!");
            swordPickupMessage.setStyle("-fx-text-fill: #FF8888; -fx-font-size: 16px;");
            pane.setBottom(swordPickupMessage);
        });
        walkToHouse.setOnAction(e -> scene3(stage));

        stage.setScene(scene2);
    }

    public static void scene3(Stage stage) {
        BorderPane pane = new BorderPane();
        Button checkMailbox = new Button("Check the mailbox");
        Button breakIntoTheHouse = new Button("Break into the house");
        Label scene3Label = new Label("You arrive at the house.\n It is a large, white Victorian house with boarded up windows.\n" +
                " The flag on the mailbox is up.\n");
        scene3Label.setFont(font);
        scene3Label.setStyle("-fx-text-fill: #888888; -fx-font-size: 16px;");
        scene3Label.setTextAlignment(TextAlignment.CENTER);
        pane.setCenter(scene3Label);
        pane.setRight(checkMailbox);
        pane.setLeft(breakIntoTheHouse);
        pane.setPadding(new Insets(10));
        pane.setBackground(bg);
        Scene scene2 = new Scene(pane, WIDTH, HEIGHT);
        checkMailbox.setOnAction(e -> {
            Item potion = new Item(1, 0, 0, 50);
            Label potionPickupMessage = new Label("You picked up a potion!");
            player.setInventory(potion);
            potionPickupMessage.setStyle("-fx-text-fill: #FF8888; -fx-font-size: 16px;");
            pane.setBottom(potionPickupMessage);
        });
        breakIntoTheHouse.setOnAction(e -> scene4(stage));

        stage.setScene(scene2);
    }
    public static void scene4(Stage stage) {
        BorderPane pane = new BorderPane();
        Button fight = new Button("Fight");
        Button run = new Button("Run");
        Label bearLabel = new Label("You break into the house and find an angry bear waiting for you.\n" +
                "Will you fight the bear, or try to run away?\n");
        bearLabel.setFont(font);
        bearLabel.setStyle("-fx-text-fill: #888888; -fx-font-size: 16px;");
        bearLabel.setTextAlignment(TextAlignment.CENTER);
        pane.setCenter(bearLabel);
        pane.setLeft(fight);
        pane.setRight(run);
        pane.setPadding(new Insets(10));
        pane.setBackground(bg);
        Scene scene2 = new Scene(pane, WIDTH, HEIGHT);
        fight.setOnAction(e -> run(stage));
        run.setOnAction(e -> run(stage));

        stage.setScene(scene2);
    }
    public static void fight(Stage stage) {
        GridPane pane = new GridPane();
        Button attack = new Button("Attack");
        Button defend = new Button("Defend");
        pane.add(new Label("You break into the house and find an angry bear waiting for you.\n" +
                "Will you fight the bear, or try to run away?\n"), 0, 0);
        pane.add(attack, 0, 3);
        pane.add(defend, 0, 2);
        pane.setPadding(new Insets(10));
        pane.setBackground(bg);
        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        attack.setOnAction(e -> fight(stage));
        defend.setOnAction(e -> run(stage));

        stage.setScene(scene);
    }

    public static void run(Stage stage) {
        Pane pane = new StackPane();
        Label deathLabel = new Label("You have died :(");
        deathLabel.setFont(font);
        deathLabel.setStyle("-fx-text-fill: #FF8888; -fx-font-size: 16px;");
        deathLabel.setTextAlignment(TextAlignment.CENTER);
        pane.getChildren().add(deathLabel);
        pane.setPadding(new Insets(10));
        pane.setBackground(bg);
        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        stage.setScene(scene);
    }
    public static void main(String[] args) {
        launch();
    }
}