package button;

import game_server.GamePlayManager;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.JLabel;

public class ButtonEvent implements MouseListener {//lấy interface từ event chuột
    private final GamePlayManager gameControl;

    public ButtonEvent(GamePlayManager gameControl) {
        this.gameControl = gameControl;
    }

    private void drawText(JLabel btn) {
        btn.setFont(GamePlayManager.FONT_DISPLAY);
        btn.setText(" " + gameControl.getTeam()); //xem nút vùa ấn là O | X
        Color color = (gameControl.getTeam().equals("O")) ? Color.RED : Color.BLUE;//chon team neu là O thi mau do ko thi mau xanh
        btn.setForeground(color);//set màu cho text trong label bnt
        btn.setFont(new Font("Tahoma", Font.BOLD, 135));
        String nextTurn = (gameControl.getTeam().equals("O")) ? "X" : "O";//đạt nextTurn là gì nếu hiện tại là O thì trả về giá trị ngược lại
        gameControl.setTextTurn("Turn: " + nextTurn);
    }

    @Override
    public void mousePressed(MouseEvent me) {
        JLabel btn = (JLabel) me.getSource();
        String index = btn.getText();
        System.out.println("ec " + index);
        // check if button is not cliced
        if (!index.matches(" X| O")) {//nếu chưa có X hoạc O thì chạy
            // check is your turn
            if (gameControl.isYourTurn()) {//Xem thử có phải lượt mình không
                gameControl.setYourTurn(false);
                drawText(btn);
                gameControl.sendData("click|" + index + "|" + gameControl.getRoomID() + "|" + gameControl.getFriend());
                gameControl.getListButton().get(Integer.parseInt(index)).setStatus(gameControl.getTeam());
                    //đạt tên các cái vừa được ấn team nào X | O
                return;
            }
            gameControl.displayMessage("Not your turn!");
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

}
