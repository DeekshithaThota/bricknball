import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game_imp extends JPanel  implements KeyListener, ActionListener {
    private boolean play= false;
    private int score=0;
    private int total_bricks=21;
    private Timer time;
    private int delay=8;

    private int player_X=310;
    private int BallposX=120;
    private int BallposY=350;
    private int ballxdir=-1;
    private int ballydir=-2;
    //JButton b = new JButton("Replay");
    public Game_imp(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        time=new Timer(delay,this);
        time.start();
    }
    public void paint(Graphics g){
        //Background
        g.setColor(Color.black);
        g.fillRect(1,1,690,590);
        //borders
        g.setColor(Color.cyan);
        g.fillRect(0,0,3,592);
        g.fillRect(0,0,692,3);
        g.fillRect(683,0,3,592);
        //paddle
        g.setColor(Color.red);
        g.fill3DRect(player_X,550,100,8,true);
        //ball
        g.setColor(Color.orange);
        g.fillOval(BallposX,BallposY,20,20);
         //blocks
        int n=7,m=total_bricks/n;
        g.setColor(Color.pink);
        for(int i=1;i<n-1;i++){
            for(int j=1;j<m;j++){
                g.fillRect(i*100,j*40,100,40);
                g.draw3DRect(i*100,j*40,100,40,true);
            }
        }

        if(BallposY>570){
            play=false;
            ballydir=0;
            ballxdir=0;
            g.setColor(Color.red);
            g.setFont(new Font("serif",Font.BOLD,30));
            g.drawString("Game Over,score:"+total_bricks+"\n"+"Press Enter to restart",190,300);
            //add(b);b.setBackground(Color.WHITE);
        }
        for(int i=1;i<n-1;i++){
            for(int j=1;j<m;j++){
                if((new Rectangle(BallposX,BallposY,20,20)).intersects(new Rectangle(i*100,j*40,100,40))){

                    g.setColor(Color.WHITE);
                    g.fillRect(i*100,j*40,100,40);

                }
            }
        }


        g.dispose();

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        time.start();

        if (play) {
            BallposX += ballxdir;
            BallposY += ballydir;
            if (BallposX < 0) {
                ballxdir = -ballxdir;

            }
            if (BallposY < 0) {

                ballydir = -ballydir;
            }
            if (BallposX > 670) {
                ballxdir = -ballxdir;
            }
            if (BallposX >= player_X && BallposX < player_X + 100 && BallposY == 530) {
                ballydir = -ballydir;
            }


            repaint();

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (player_X >= 600) {
                player_X = 600;
            } else {
                play = true;
                player_X +=20;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (player_X < 10) {
                player_X = 10;
            } else {
                play = true;
                player_X -= 20;
            }
        }
        if (e.getKeyCode()==KeyEvent.VK_ENTER && !play){
            score=0;
            total_bricks=21;
            player_X=310;
            BallposX=120;
            BallposY=350;
            ballxdir=-1;
            ballydir=-2;

        }

    }


    @Override
    public void keyReleased(KeyEvent e) {

    }
}



