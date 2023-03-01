/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet_snake;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class Jeu extends JPanel implements ActionListener {

    static final int hauteur = 600;
    static final int largeur = 600;
    static final int taille_case = 30; // possible de changer la valeur pour changer le nombre de cases
    static final int taille_jeu = (hauteur * largeur) / (taille_case * taille_case);
    final int x[] = new int[taille_jeu];
    final int y[] = new int[taille_jeu];

    int corps = 3;
    int fruits_manges;
    int fruit_x;
    int fruit_y;
    char direction = 'D'; // D = droit
    boolean enmarche = false;

    Timer timer;
    Random random;

    Jeu() {
        random = new Random();
        this.setPreferredSize(new Dimension(hauteur, largeur));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        Debut();
    }

    public void Debut() {
        Fruit(); // Apparition d'un nouveau fruit
        enmarche = true;
        timer = new Timer(150, this);
        timer.start();
    }
    
    public void Fruit() {
        fruit_x = random.nextInt((int) (largeur / taille_case)) * taille_case;
        fruit_y = random.nextInt((int) (hauteur / taille_case)) * taille_case;
    }

    public void MangeFruit() {
        if ((x[0] == fruit_x) && (y[0] == fruit_y)) {
            corps++; // Le corps du serpent grandit d'1 case
            fruits_manges++; // Le nb de fruits mangés augmente de 1
            Fruit(); // Génération d'un nouveau fruit
        }
    }

    public void Mouvements() {

        for (int i = corps; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        if (direction == 'D') { // Droite
            x[0] = x[0] + taille_case;
        } else if (direction == 'G') { // Gauche
            x[0] = x[0] - taille_case;
        } else if (direction == 'H') { // Haut
            y[0] = y[0] - taille_case;
        } else { // Bas
            y[0] = y[0] + taille_case;
        }
    }

    public void Collision() {

        // Vérifie si la tête du serpent se cogne avec le corps
        for (int i = corps; i > 0; i--) {
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                enmarche = false;
            }
        }

        // PROPOSITION : mettre des >= ou <= pour éviter que la tête ne sorte du jeu...?
        // Vérifie si la tête du serpent se cogne avec le bord gauche
        if (x[0] < 0) {
            enmarche = false;
        }

        // Vérifie si la tête du serpent se cogne avec le bord droit
        if (x[0] > largeur) {
            enmarche = false;
        }

        // Vérifie si la tête du serpent se cogne avec le bord haut
        if (y[0] < 0) {
            enmarche = false;
        }

        // Vérifie si la tête du serpent se cogne avec le bord bas
        if (y[0] > hauteur) {
            enmarche = false;
        }

        if (!enmarche) {
            timer.stop();
        }
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {

        if (enmarche) {

            // Facultatif c'est uniquement pour visualiser le quadrillage
            for (int i = 0; i < hauteur / taille_case; i++) {
                g.drawLine(i * taille_case, 0, i * taille_case, hauteur);
                g.drawLine(0, i * taille_case, largeur, i * taille_case);
            }

            // Dessin du fruit à sa position aléatoire
            g.setColor(Color.green);
            g.fillOval(fruit_x, fruit_y, taille_case, taille_case);

            // Dessin du serpent
            for (int i = 0; i < corps; i++) {
                if (i == 0) {
                    g.setColor(Color.red);
                    g.fillRect(x[i], y[i], taille_case, taille_case);
                } else {
                    g.setColor(Color.orange);
                    g.fillRect(x[i], y[i], taille_case, taille_case);
                }
            }
        } else {
            FinJeu(g);
        }

    }

    public void FinJeu(Graphics g) { // Voir dans les TP que l'on a fait pour l'ouverture d'une fenêtre de fin de jeu
        // Affichage fin du jeu + score
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (enmarche) {
            Mouvements();
            MangeFruit();
            Collision();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {

                case KeyEvent.VK_RIGHT: // Flèche droite
                    if (direction != 'G') {
                        direction = 'D';
                    }
                    break;

                case KeyEvent.VK_LEFT: // Flèche gauche
                    if (direction != 'D') {
                        direction = 'G';
                    }
                    break;

                case KeyEvent.VK_UP: // Flèche du haut
                    if (direction != 'B') {
                        direction = 'H';
                    }
                    break;

                case KeyEvent.VK_DOWN: // Flèche du bas
                    if (direction != 'H') {
                        direction = 'B';
                    }
                    break;
            }
        }
    }

}
