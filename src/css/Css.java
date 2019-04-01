package css;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.File;

public class Css {
    public static String selectorButton(){
        return "-fx-background-color: rgba(255, 255, 255 ,0); " +
                "-fx-font-weight: bold ; " +
                "-fx-font-size: 7em; " +
                "-fx-text-fill: white; " +
                "-fx-font-family: ariel;";
    }

    public static String toolTip(){
        return "-fx-background-color: cornflowerblue;";
    }

    public static String confirmButton(){
        return "-fx-font-size: 15pt;";
    }

    public static void setStyle(Button button) {
        button.setStyle("-fx-background-color: #ff94a9;" +
                "-fx-border-color: #9a4a7c;" +
                "-fx-border-width: 3px;");
    }

    public static void setStyle(TextField field) {
        field.setStyle("-fx-background-color: rgb(255,255,255);" +
                "-fx-border-color: #9a4a7c;" +
                "-fx-border-width: 3px;");

    }

    public static void setBackground(GridPane grid){
        String url = new File("resources/SquiggleTheme.png").toURI().toString();
        grid.setStyle("-fx-background-image: url(" + url + ");");
    }

    public static void setText(Label label){
        label.setStyle("-fx-text-fill: #fefff3; -fx-font-size: 17px; -fx-font-weight: BOLD");
    }

    public static void buttonStyle(Button button){
        button.setStyle("-fx-background-color: " +
                //"linear-gradient(#ffd65b, #e68400), " +
                //"linear-gradient(#ffef84, #f2ba44), " +
                //"linear-gradient(#ffea6a, #efaa22), " +
                "linear-gradient(#ff5fa8 0%, #f81de9 50%, #c90dee 100%), " +
                "linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));" +
                "-fx-background-radius: 30; " +
                "-fx-background-insets: 0,1,2,3,0; " +
                "-fx-text-fill: #ffffff; " +
                "-fx-font-weight: bold; " +
                "-fx-font-size: 14px; " +
                "-fx-padding: 10 20 10 20; " +
                "-fx-cursor: hand");
    }

    public static void buttonStyleRed(Button button){
        button.setStyle("-fx-padding: 8 15 15 15;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 8;\n" +
                "    -fx-background-color: \n" +
                "        linear-gradient(from 0% 93% to 0% 100%, #9a4a7c 0%, #9a4a7c 100%),\n" +
                "        #9b119d,\n" +
                "        #d86e3a,\n" +
                "        radial-gradient(center 50% 50%, radius 100%, #f81de9, #c90dee);\n" +
                "    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 2,0,0,1 );\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 1.1em;");
    }
}
