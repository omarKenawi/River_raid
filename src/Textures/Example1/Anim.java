package Textures.Example1;

import Textures.AnimListener;
import com.sun.opengl.util.Animator;
import com.sun.opengl.util.FPSAnimator;

import javax.media.opengl.GLCanvas;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Anim extends JFrame {

    public static void main(String[] args) throws UnsupportedAudioFileException , IOException,LineUnavailableException {
        new HomeEntryPage();
      //  new Anim(new NormalGame());

    }

    public Anim(AnimListener aListener) {
        GLCanvas glcanvas;
        Animator animator;
        AnimListener listener = aListener;
        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(listener);
        glcanvas.addKeyListener(listener);
        getContentPane().add(glcanvas, BorderLayout.CENTER);
        animator = new FPSAnimator(40);
        animator.add(glcanvas);
        animator.start();

        setTitle("River raid");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 1000);
        setLocationRelativeTo(null);
          setVisible(true);
        setFocusable(true);
        glcanvas.requestFocus();
    }
}

