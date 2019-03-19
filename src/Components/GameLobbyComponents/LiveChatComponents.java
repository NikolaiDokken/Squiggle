package Components.GameLobbyComponents;

import Database.DBConnection;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


/**
 * The LiveChatComponents class includes the different methods
 * and JavaFX code in order to implement the livechat.
 *
 * @author maxto
 */

public class LiveChatComponents {
    private static Timer timer = null;
    private static ScrollPane sp;
    private static ArrayList<String> messages = new ArrayList<>();

    //-----------Right-----------//

    /**
     * Implements the layout of the livechat in the gamelobby
     */
    public static VBox liveChatUI(){
        VBox vb = new VBox();
        Label livechatLabel = new Label("Live chat:");
        livechatLabel.setFont(new Font(20));
        livechatLabel.setPadding(new Insets(0,130, 0, 0));
        //livechatLabel.setAlignment(Pos.TOP_LEFT);
        sp = new ScrollPane();
        Text lc = new Text();
        sp.setContent(lc);
        sp.setFitToWidth(true);
        sp.setFitToHeight(true);

        TextField tf = new TextField();
        Button btn = new Button("enter");
        btn.setDefaultButton(true);
        HBox hb = new HBox();
        hb.getChildren().addAll(tf,btn);
        vb.getChildren().addAll(livechatLabel, sp,hb);
        vb.setAlignment(Pos.BOTTOM_CENTER);
        showMessages(lc, tf);

        btn.setOnAction(e -> {
            String text = tf.getText();
            if(checkWord(text)){

                lc.setText("Correct word");
            }else{
                System.out.println("Wrong word");
            }
            DBConnection.insertMessage(text);
            //showMessages(lc, tf);
            tf.clear();
        });

        return vb;
    }

    /**
     * Shows the messages written in the chat.
     * Gets the messages from methods in DBConnection
     * @param chatText Text-object which displays the messages
     * @param inputText
     */
    private static void showMessages(Text chatText, TextField inputText) {
        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                ArrayList<String> newMessages = DBConnection.getNewMessages();
                if (newMessages == null) {
                    return;
                }
                messages.addAll(newMessages);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < messages.size(); i++) {
                    sb.append(messages.get(i));
                    sb.append("\n");
                }
                sp.setVvalue(1.0);
                for (int i = 0; i < messages.size(); i++) {
                    sb.append(messages.get(i));
                    sb.append("\n");
                }
                chatText.setText(sb.toString());

            }
        };
        timer.schedule(task, 0, +5000);
    }

    /**
     * Turns of the timer when called
     */
    public static void turnOfTimer() {
        if (timer != null) {
            timer.cancel();
        }
    }

    public static boolean checkWord(String word) {
        boolean correct = false;
        if(word.equals(WordComponents.getWord())){
            correct = true;
        }else{ }
        return correct;
    }
}
