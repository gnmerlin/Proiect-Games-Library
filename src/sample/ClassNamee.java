package sample;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ClassNamee {
    MouseEvent mMouseEvent;


    public ClassNamee(MouseEvent me) {
        mMouseEvent = me;
    }

    public void arataCoordonateMouse() {
        System.out.println("pe x:" + mMouseEvent.getScreenX() +  "pe y:" + mMouseEvent.getScreenY());
    }
}
