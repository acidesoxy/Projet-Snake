/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetsnake;

import java.util.Random;

public class Diamant  {
    int x_diamant;
    int y_diamant;

    public Diamant(int x_diamant, int y_diamant) {
      
        Random random = new Random();
        this.x_diamant = random.nextInt(20);
        this.y_diamant = random.nextInt(20);
    }
}
