package Textures.Example1;

import Textures.AnimListener;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class HomeEntryPage extends AnimListener implements GLEventListener, ActionListener {
   public int count = 0;

    NormalGame ar;

    {

        ar = new NormalGame();
    }

   String name ="";
    String textureName = "Bground.png";
    Textures.TextureReader.Texture texture;
    int[] textureIndex = new int[1];

    private static final int WINDOW_WIDTH = 1000; //640
    private static final int WINDOW_HEIGHT = 900;

    private static final String TITLE_STRING = "River Raid ";
//    private static final int FPS = 60;
//

    private final JFrame frame;
    private final JButton normalGame;
    private final JButton hackerMode;
    private  JButton easyGame;

    private final JButton HelpButton;
    private final JButton exitButton;
    private final JButton instruction;
    public HomeEntryPage() {
        // Set up the JFrame
        frame = new JFrame(TITLE_STRING);
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setBackground(Color.white);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//EXIT_ON_CLOSE
        frame.setLayout(new BorderLayout());

        // Set up the GLCanvas and FPSAnimator
        GLCanvas canvas = new GLCanvas();
        canvas.addGLEventListener(this);
        frame.add(canvas, BorderLayout.CENTER);
        // Set up the buttons
        instruction = new JButton ( "instraction" );
        instruction.addActionListener(this);
        normalGame = new JButton("normal Game");
        normalGame.addActionListener(this);
        hackerMode = new JButton("hacker Mode");
        hackerMode.addActionListener(this);
        easyGame = new JButton("easy Game");
        easyGame.addActionListener(this);
        JButton choosePlaneButton = new JButton(" " + "Choose a plane ");
        choosePlaneButton.addActionListener(this);
        choosePlaneButton.setVisible(false);
        HelpButton = new JButton("Info");
        HelpButton.addActionListener(this);
        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLUE);
        buttonPanel.setSize(530, 450);
        buttonPanel.add(normalGame);
        buttonPanel.add(hackerMode);
        buttonPanel.add(easyGame);
        buttonPanel.add(choosePlaneButton);

        buttonPanel.add(HelpButton);
        buttonPanel.add(instruction);
     //   exitButton.setSize(700, 780);
        buttonPanel.add(exitButton);
        // frame.setSize(140, 290);
        frame.add(buttonPanel, BorderLayout.NORTH);
       frame.setLocationRelativeTo(null);

        frame.setIconImage(new ImageIcon(
                "C:\\Users\\Abdou\\Desktop\\icon2.png").getImage());

        // instruction.setVisible(false);
        frame.setVisible(true);
        frame.setSize(900, 1000);
        frame.setResizable(false);
       // setSize();
    }

    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();
        if (source == normalGame) {
            // Start normal game

              name=JOptionPane.showInputDialog(frame,"Enter Your Name");
              if(name==null){
                  new HomeEntryPage();
                  frame. dispose();
                    return;
              }
            HelpButton.setVisible(false);
            instruction.setVisible(false);
            hackerMode.setVisible(false);
            frame. setVisible(false);

            String s = "HI  "+name+" Are you ready ?";
            int     response = JOptionPane.showConfirmDialog(frame,  s  , "ready?", JOptionPane.YES_NO_OPTION);
            if ( response==JOptionPane.YES_OPTION) {
                Anim f;

                    f = new Anim(new NormalGame());

                newGame();
                f.setVisible(true);
                f.setResizable(false);
                frame. dispose();

            }


            if (response==JOptionPane.NO_OPTION) {
                new HomeEntryPage();
                frame. dispose();
            }

        } else if (e.getSource() == hackerMode) {
            name=JOptionPane.showInputDialog(frame,"Enter Your Name");
            HelpButton.setVisible(false);
            instruction.setVisible(false);
            hackerMode.setVisible(false);
            frame. setVisible(false);

            String s = "HI  "+name+" Are you ready ?";
            int     response = JOptionPane.showConfirmDialog(frame,  s  , "ready?", JOptionPane.YES_NO_OPTION);
            if ( response==JOptionPane.YES_OPTION) {
                Anim f;

                f = new Anim(new hackerMode( ));

                newGame();
                f.setVisible(true);
                f.setResizable(false);
                frame. dispose();

            }


            if (response==JOptionPane.NO_OPTION) {
                new HomeEntryPage();
                frame. dispose();
            }


        }
        else if (e.getSource() == easyGame) {
            name=JOptionPane.showInputDialog(frame,"Enter Your Name");
            HelpButton.setVisible(false);
            instruction.setVisible(false);
            hackerMode.setVisible(false);
            frame. setVisible(false);

            String s = "HI  "+name+" Are you ready ?";
            int     response = JOptionPane.showConfirmDialog(frame,  s  , "ready?", JOptionPane.YES_NO_OPTION);
            if ( response==JOptionPane.YES_OPTION) {
                Anim f;

                f = new Anim(new EasyGame( ));

                newGame();
                f.setVisible(true);
                f.setResizable(false);
                frame. dispose();

            }


            if (response==JOptionPane.NO_OPTION) {
                new HomeEntryPage();
                frame. dispose();
            }


        }
        else if (e.getSource() == instruction) {

            JOptionPane.showMessageDialog(frame,
                    "1.Use the left right button to move the plane \n"
                            + "2.press Space to shoot bullets.\n"
                            +"10 points for hit first enemy (ship)\n "
                            +"50 points for hit second enemy (plane)\n "
                            +"if hit fuel every enemy in it is zone will destroyed\n"+" and  you will git 30 points\n "
                            +"3.Try to survive and overcome the enemy."
            );

        }
        else if (source == exitButton) {
            //  to Exit the game
            System.exit(0);

        }else if (source == HelpButton) {

            JOptionPane.showMessageDialog(frame,  " team members\n"+"1- omar kenawi\n"+"2-ali yasser\n"+"3-Abdelrahman ibrahem \n"+"4-ali nasser \n"+"4-mounir maged\n");
        }

    }

    public void init(GLAutoDrawable drawable) {
        // Set up the OpenGL context here

        GL gl = drawable.getGL();

        gl.glClearColor(0.0f, 0.9f, 0.5f, 0.0f); //This Will Clear The Background Color To blue+green


        gl.glEnable(GL.GL_TEXTURE_2D);  // Enable Texture Mapping
        gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);

        //number of textures, array to hold the indeces
        gl.glGenTextures(1, textureIndex, 0);

        try {
            texture = Textures.TextureReader.readTexture(assetsFolderName + "//" + textureName, true);
            gl.glBindTexture(GL.GL_TEXTURE_2D, textureIndex[0]);

//          mipmapsFromPNG(gl, new GLU(), texture[i]);
            new GLU().gluBuild2DMipmaps(
                    GL.GL_TEXTURE_2D,
                    GL.GL_RGBA, // Internal Texel Format,
                    texture.getWidth(), texture.getHeight(),
                    GL.GL_RGBA, // External format from image,
                    GL.GL_UNSIGNED_BYTE,
                    texture.getPixels() // Imagedata
            );
        } catch (IOException e) {

            e.printStackTrace();
        }

    }


    @Override
    public void display(GLAutoDrawable glad) {

        GL gl = glad.getGL();
      //  gl.glEnable(GL.GL_TEXTURE_2D);
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);       //Clear The Screen And The Depth Buffer
        gl.glLoadIdentity();
      //  gl.glDisable(GL.GL_TEXTURE_2D);
        DrawBackground(gl);
    }

    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {

        //        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public void displayChanged(GLAutoDrawable glad, boolean bln, boolean bln1) {
        //      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void DrawBackground(GL gl) {

        gl.glEnable(GL.GL_BLEND);	// Turn Blending On
        gl.glBindTexture(GL.GL_TEXTURE_2D, textureIndex[0]);

        //gl.glScaled(0.5, 0.5, 0);
        gl.glBegin(GL.GL_QUADS);
        // Front Face
        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(-1f, -1f, -1.0f);
        gl.glTexCoord2f(1.0f, 0.0f);
        gl.glVertex3f(1.0f, -1.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, -1.0f);
        gl.glTexCoord2f(0.0f, 1.0f);
        gl.glVertex3f(-1.0f, 1.0f, -1.0f);
        gl.glEnd();

        gl.glDisable(GL.GL_BLEND);
    }
    @Override
    public void keyTyped(KeyEvent e) {
        //      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //write code hire


        //       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //write code to make color


        //      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void newGame() {
        //start counter in text field
        javax.swing.Timer timer = new Timer(1000, e -> {
            //start counter in text field
            count++;


        });
        timer.start();
    }
}
