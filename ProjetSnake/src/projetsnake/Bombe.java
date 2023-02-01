/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetsnake;

import java.util.Random;

public class Bombe  {
    int x_bombe;
    int y_bombe;

    public Bombe(int x_diamant, int y_diamant) {
     
        Random random = new Random();
        this.x_bombe = random.nextInt(20);
        this.y_bombe = random.nextInt(20);
    }
}
