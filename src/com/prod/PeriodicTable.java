package com.prod;

import com.prod.Elements.Element;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.image.Image;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;

/**
 * -----
 *
 * @author Elijah Sanderson
 * @author Reilly LeBlanc
 * @version 1.0.1
 * @since 1.0
 */

public class PeriodicTable extends Application {

    /**
     * Starts the application
     *
     * @param primaryStage the main stage of the application
     */
    @Override
    public void start(Stage primaryStage) throws Exception {

        // create root StackPane
        StackPane root = new StackPane();

        // create GridPane
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);

        root.getChildren().add(grid);

        // create panes for each category
        Pane alkali = new Pane();
        Pane alkaline = new Pane();
        Pane lanthanides = new Pane();
        Pane actinides = new Pane();
        Pane transitionMetals = new Pane();
        Pane postTransitionMetals = new Pane();
        Pane metalloids = new Pane();
        Pane reactiveNonmetals = new Pane();
        Pane nobleGases = new Pane();
        Pane unknown = new Pane();

        // add all to grid pane
        grid.getChildren().addAll(alkali, alkaline, lanthanides, actinides, transitionMetals, postTransitionMetals,
                metalloids, reactiveNonmetals, nobleGases, unknown);

        // set elements
        ArrayList<StackPane> elementList = new ArrayList<>();

        for (Elements.Element element : Elements.Element.values()) {
            setElement(element, grid, elementList);
        }

        // create new scene

        Scene scene = new Scene(root, 1280, 720);
        scene.setFill(Color.web("#434345"));

        // add listeners to each element
        for (StackPane stack : elementList) {
            addListeners(root, stack, grid, scene);
        }

        // show stage
        primaryStage.getIcons().add(new Image("file:images/icon.png"));
        primaryStage.setTitle("Periodic Table of Elements");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Sets each element's cell in the Periodic Table.
     *
     * @param element     the element
     * @param grid        the main GridPane
     * @param elementList the list of element StackPanes
     */
    private void setElement(Elements.Element element, GridPane grid, ArrayList<StackPane> elementList) {
        // create new StackPane and rectangle
        StackPane stack = new StackPane();
        Rectangle rect = new Rectangle(60, 60);

        // get fill color
        Color color;
        switch (element.getCategory()) {
            case ACTINIDE:
                color = Color.PALEVIOLETRED;
                break;
            case ALKALI:
                color = Color.CRIMSON;
                break;
            case ALKALINE_EARTH:
                color = Color.CORAL;
                break;
            case LANTHANIDE:
                color = Color.PLUM;
                break;
            case METALLOID:
                color = Color.BURLYWOOD;
                break;
            case NOBLE_GAS:
                color = Color.AQUA;
                break;
            case POST_TRANSITION:
                color = Color.LIGHTSLATEGRAY;
                break;
            case REACTIVE_NONMETAL:
                color = Color.GOLD;
                break;
            case TRANSITION:
                color = Color.DARKSALMON;
                break;
            case UNKNOWN:
            default:
                color = Color.LIGHTGRAY;
                break;
        }

        // set fill and stroke color of rectangle
        rect.setFill(color);
        rect.setStroke(Color.WHITE);

        // add text
        Text text = new Text(element.getAtomicNumber() + "\n" + element.name());
        text.setFill(Color.WHITE);
        text.setStroke(Color.BLACK);

        // add all to StackPane
        stack.getChildren().addAll(rect, text);

        // add StackPane and its specific row and column to the GridPane
        grid.add(stack, element.getGroup() - 1, element.getPeriod() - 1);

        // add StackPane to the ArrayList of elements
        elementList.add(stack);
    }

    /**
     * Adds event listeners to the scene.
     *
     * @param stack StackPane representative of an element
     * @param grid  the main GridPane
     * @param scene the main scene
     */
    private void addListeners(StackPane root, StackPane stack, GridPane grid, Scene scene) {
        stack.setOnMouseEntered(e ->scene.setCursor(Cursor.HAND));

        stack.setOnMouseExited(e -> scene.setCursor(Cursor.DEFAULT));

        stack.setOnMouseReleased(e -> {
            try {
                openElement(root, stack, grid, scene);
            } catch (MalformedURLException e2) {
                e2.printStackTrace();
            }
        });


    }

    /**
     * Opens a new window of the desired element.
     *
     * @param stack the StackPane which holds the specific element
     * @throws MalformedURLException
     */
    private void openElement(StackPane root, StackPane stack, GridPane grid, Scene scene) throws MalformedURLException {

        // get contents of element via its StackPane
        // get fill color
        Paint fill = ((Rectangle) stack.getChildren().get(0)).getFill();

        // get atomic number
        String s = ((Text) stack.getChildren().get(1)).getText();
        String elemSymbol = s.substring(s.indexOf("\n") + 1);

        // get element using elemSymbol
        Element element = Elements.Element.valueOf(elemSymbol);

        // create new window for the selected element
        StackPane window = new StackPane();
        Rectangle windowRect = new Rectangle(750, 400);
        windowRect.setFill(Color.WHITE);
        windowRect.setStroke(Color.SLATEGRAY);
        windowRect.setStrokeWidth(3.0);

        // create element cell
        Rectangle cell = new Rectangle(300, 300);
        cell.setFill(fill);
        cell.setTranslateX(
                -((windowRect.getWidth() - cell.getWidth()) / 2 - (windowRect.getHeight() - cell.getHeight()) / 2));

        // call setWindowInfo() to set the window and the elementGrid
        GridPane elementGrid = setWindowInfo(fill, element, grid, window, windowRect, cell, scene);

        // call setCellInfo() to set the cell and get the cellGrid
        GridPane cellGrid = setCellInfo(element, grid, windowRect, cell, scene);

        // finalize window
        window.getChildren().addAll(windowRect, cell, cellGrid, elementGrid);
        window.setTranslateY(scene.getHeight());

        // transition in
        transitionIn(window, grid, scene);

        // add window to the root StackPane
        root.getChildren().addAll(window);
    }

    /**
     * Opens a web page.
     *
     * @param url URL of the web page
     */
    private static void openWebpage(String url) {
        try {
            Desktop.getDesktop().browse(new URL(url).toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Slides the element's pop-up window into the screen.
     *
     * @param window pop-up window
     * @param grid   main GridPane
     * @param scene  main Scene
     */
    private void transitionIn(StackPane window, GridPane grid, Scene scene) {
        // blur the periodic table GridPane
        grid.setEffect(new GaussianBlur());

        // transition
        Line pathIn = new Line(scene.getWidth() / 2, 2 * scene.getHeight(), scene.getWidth() / 2,
                scene.getHeight() / 2);
        PathTransition transition = new PathTransition();
        transition.setNode(window);
        transition.setDuration(Duration.seconds(0.5));
        transition.setPath(pathIn);
        transition.play();
    }

    /**
     * Slides the element's pop-up window out of the screen.
     *
     * @param window pop-up window
     * @param grid   main GridPane
     * @param scene  main Scene
     */
    private void transitionOut(StackPane window, GridPane grid, Scene scene) {
        // remove blur on periodic table GridPane
        grid.setEffect(null);

        // transition
        Line pathOut = new Line(scene.getWidth() / 2, scene.getHeight() / 2, scene.getWidth() / 2,
                2 * scene.getHeight());
        PathTransition transition = new PathTransition();
        transition.setNode(window);
        transition.setDuration(Duration.seconds(0.5));
        transition.setPath(pathOut);
        transition.play();
    }

    /**
     * Sets all information about the element inside the element's pop-up window.
     *
     * @param fill
     * @param element
     * @param grid
     * @param window
     * @param windowRect
     * @param cell
     * @param scene
     * @return
     */
    private GridPane setWindowInfo(Paint fill, Element element, GridPane grid, StackPane window, Rectangle windowRect,
                                   Rectangle cell, Scene scene) {
        // add specific info in the window
        // create GridPane for element's info
        GridPane elementGrid = new GridPane();

        int atomicNum = element.getAtomicNumber();
        String fullName = String.valueOf(element.getFullName());
        double atomicMass = element.getAtomicMass();
        double meltingPoint = element.getMeltingPoint();
        double boilingPoint = element.getBoilingPoint();
        double density = element.getDensity();
        String phase = String.valueOf(element.getPhase()).toLowerCase();
        String category = String.valueOf(element.getCategory()).toLowerCase();
        boolean isRadioactive = element.isRadioactive();
        String elementUrl;

        // Default Mercury brings you to the planet page
        if (fullName == "Mercury") {
            elementUrl = String.format("https://en.wikipedia.org/wiki/Mercury_(element)");
        } else {
            elementUrl = String.format("https://en.wikipedia.org/wiki/%s", String.valueOf(fullName));
        }

        // format meltingPoint for each element
        Text txtMeltingPoint = formatMeltingPoint(meltingPoint);

        // format boilingPoint for each element
        Text txtBoilingPoint = formatBoilingPoint(boilingPoint);

        // format density for each element
        Text txtDensity = formatDensity(density);

        // format phase for each element
        Text txtPhase = formatPhase(phase);

        // format category for each element
        Text txtCategory = formatCategory(category, fill);

        // format isRadioactive for each element
        Text txtIsRadioactive = formatIsRadioactive(isRadioactive);

        // add all text to an ArrayList
        ArrayList<Text> textList = new ArrayList<>();

        textList.add(new Text("Atomic Number:\t"));
        textList.add(new Text("Atomic Mass:"));
        textList.add(new Text("Melting Point:"));
        textList.add(new Text("Boiling Point:"));
        textList.add(new Text("Density:"));
        textList.add(new Text("Phase:"));
        textList.add(new Text("Category:"));
        textList.add(new Text("Radioactive:"));

        textList.add(new Text(String.format("%d", atomicNum)));
        textList.add(new Text(String.format("%.2f", atomicMass)));
        textList.add(txtMeltingPoint);
        textList.add(txtBoilingPoint);
        textList.add(txtDensity);
        textList.add(txtPhase);
        textList.add(txtCategory);
        textList.add(txtIsRadioactive);

        textList.forEach(e -> e.setFont(Font.font("", 20)));

        // add all text to elementGrid
        for (int i = 0; i < (textList.size() / 2); i++) {
            elementGrid.add(textList.get(i), 0, i);
        }

        for (int i = (textList.size() / 2); i < textList.size(); i++) {
            elementGrid.add(textList.get(i), 1, i - textList.size() / 2);
        }

        // set elementGrid's position
        elementGrid.setTranslateX(scene.getWidth() / 2 + (windowRect.getWidth() - 2 * cell.getWidth()) / 6);
        elementGrid.setTranslateY((scene.getHeight() - cell.getHeight()) / 2);
        elementGrid.setVgap(grid.getVgap());

        // add buttons to the window
        Button back = new Button("Back to Table");
        Button openWiki = new Button("Open Wikipedia Page");



        // implement buttons
        back.setOnAction(e -> transitionOut(window, grid, scene));

        openWiki.setOnAction(e -> openWebpage(elementUrl));


        // add buttons to elementGrid
        elementGrid.add(back, 0, 9);
        elementGrid.add(openWiki, 1, 9);

        // return elementGrid
        return elementGrid;
    }

    /**
     * Sets the cell info in the specific element's pop-up window.
     *
     * @param element    element called
     * @param grid       main GridPane of the Periodic Table
     * @param windowRect rectangle of the pop-up window
     * @param cell       rectangle of the cell in the pop-up window
     * @param scene      main Scene of the Periodic Table
     */
    private GridPane setCellInfo(Element element, GridPane grid, Rectangle windowRect, Rectangle cell, Scene scene) {
        // create GridPane for element's cell
        GridPane cellGrid = new GridPane();

        ArrayList<Text> cellTextList = new ArrayList<>();

        cellTextList.add(new Text(String.valueOf(element.getAtomicNumber())));
        cellTextList.add(new Text(String.valueOf(element.name())));
        cellTextList.add(new Text(""));
        cellTextList.add(new Text(String.valueOf(element.getFullName())));
        cellTextList.add(new Text(String.valueOf(element.getAtomicMass())));

        cellTextList.get(0).setFont(Font.font("", 35));
        // cellTextList.get(1).setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/SF-Pro-Display-Bold.otf"),
        // 100));
        cellTextList.get(1).setFont(Font.font("SF Pro Display", FontWeight.BOLD, 100));
        cellTextList.get(2).setFont(Font.font("", 10));
        cellTextList.get(3).setFont(Font.font("", 35));
        cellTextList.get(4).setFont(Font.font("", 35));

        for (int i = 0; i < cellTextList.size(); i++) {
            cellGrid.add(cellTextList.get(i), 0, i);
        }

        cellGrid.setTranslateX((scene.getWidth() - windowRect.getWidth()) / 2
                + (windowRect.getWidth() - 2 * cell.getWidth()) / 3 + grid.getHgap());
        cellGrid.setTranslateY((scene.getHeight() - windowRect.getHeight()) / 2
                + (windowRect.getHeight() - cell.getHeight()) / 2 + grid.getHgap());

        return cellGrid;
    }

    private Text formatMeltingPoint(double meltingPoint) {
        Text txtMeltingPoint;

        if (meltingPoint == 0) {
            txtMeltingPoint = new Text("unknown");
            txtMeltingPoint.setFill(Color.LIGHTGRAY);
            return txtMeltingPoint;
        } else {
            txtMeltingPoint = new Text(String.format("%.2f K", meltingPoint));
            return txtMeltingPoint;
        }
    }

    private Text formatBoilingPoint(double boilingPoint) {
        Text txtBoilingPoint;

        if (boilingPoint == 0) {
            txtBoilingPoint = new Text("unknown");
            txtBoilingPoint.setFill(Color.LIGHTGRAY);
            return txtBoilingPoint;
        } else {
            txtBoilingPoint = new Text(String.format("%.2f K", boilingPoint));
            return txtBoilingPoint;
        }
    }

    private Text formatDensity(double density) {
        Text txtDensity;

        if (density == 0) {
            txtDensity = new Text("unknown");
            txtDensity.setFill(Color.LIGHTGRAY);
            return txtDensity;
        } else {
            txtDensity = new Text(String.format("%.2f g/L", density));
            return txtDensity;
        }
    }

    private Text formatPhase(String phase) {
        Text txtPhase = new Text(phase);

        switch (phase) {
            case "solid":
                txtPhase.setFill(Color.DARKSLATEGRAY);
                break;
            case "liquid":
                txtPhase.setFill(Color.MEDIUMBLUE);
                break;
            case "gas":
                txtPhase.setFill(Color.LIGHTGREEN);
            case "unknown":
            default:
                txtPhase.setFill(Color.LIGHTGRAY);
        }

        return txtPhase;
    }

    private Text formatCategory(String category, Paint fill) {
        Text txtCategory = switch (category) {
            case "alkali" -> new Text("alkali metal");
            case "alkaline_earth" -> new Text("alkaline earth");
            case "transition" -> new Text("transition metal");
            case "post_transition" -> new Text("post-transition");
            case "lanthanide" -> new Text("lanthanide");
            case "actinide" -> new Text("actinide");
            case "metalloid" -> new Text("metalloid");
            case "reactive_nonmetal" -> new Text("nonmetal");
            case "noble_gas" -> new Text("noble gas");
            default -> new Text("unknown");
        };

        txtCategory.setFill(fill);

        return txtCategory;
    }

    private Text formatIsRadioactive(boolean isRadioactive) {
        Text txtIsRadioactive;
        if (isRadioactive) {
            txtIsRadioactive = new Text("yes");
            txtIsRadioactive.setFill(Color.LIMEGREEN);
        } else {
            txtIsRadioactive = new Text("no");
            txtIsRadioactive.setFill(Color.DARKRED);
        }

        return txtIsRadioactive;
    }

    /**
     * Launches application
     *
     * @param args -unused-
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
}
