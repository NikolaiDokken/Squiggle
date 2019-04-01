package Components.Threads;

import Components.GameLobbyComponents.CanvasComponents;
import Components.GameLobbyComponents.GameLogicComponents;
import Components.UserInfo;
import Database.DBConnection;
import Scenes.GameLobby;
import Scenes.MainScene;
import com.sun.tools.javac.Main;

import java.util.Timer;
import java.util.TimerTask;

import static Components.GameLobbyComponents.AvatarComponents.updateData;
import static Components.GameLobbyComponents.CanvasComponents.makeDrawable;
import static Components.GameLobbyComponents.CanvasComponents.updateImage;
import static Components.GameLobbyComponents.TimerComponent.setTimerText;
import static Components.GameLobbyComponents.TimerComponent.timeRemaining;

public class Timers {

    private static Timer heartBeat;
    private static boolean readyReset = false;
    private static boolean start;

    public static void startHeartBeat() {
        start = true;
        heartBeat();
    }

    private static void heartBeat(){
        heartBeat = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (start) {
                    if (timeRemaining == 80) {
                        makeDrawable(CanvasComponents.getGc());
                    }
                    if (timeRemaining % 5 == 0) {
                        updateData();
                        if (UserInfo.getDrawRound() == GameLogicComponents.getCurrentRound()) {
                            updateImage();
                        } else {
                            CanvasComponents.setImage();
                        }
                    }
                    if (timeRemaining > 80) {
                        if (!readyReset) {
                            readyReset = true;
                        }
                        setTimerText(false);
                    } else if (timeRemaining > 0) {
                        setTimerText(true);
                    } else {
                        if (readyReset) {
                            GameLogicComponents.incrementRoundCounter();
                            GameLogicComponents.reset();
                            readyReset = false;
                        }
                    }
                }

            }
        };
        heartBeat.schedule(task, 0, +1000);
    }

    public static void stopHeartBeat() {
        start = false;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (heartBeat != null) {
            heartBeat.cancel();
            heartBeat.purge();
        }
    }
}