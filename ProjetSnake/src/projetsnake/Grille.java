/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetsnake;

public class Grille {

    protected int[][] tab;
    
    private int i_fruit;
    private int j_fruit;

    public Grille(int nbcases_x, int nbcases_y) {
        tab = new int[nbcases_x][nbcases_y];
        
        // Initialisation du serpent
        tab [0][0] = 3; // Queue
        tab [0][1] = 2; // Corps
        tab [0][2] = 1; // Tête        
        
        Fruit fruit = new Fruit(i_fruit,j_fruit);
        if (tab[fruit.getX_fruit()][fruit.getY_fruit()] == 0)
            tab[fruit.getX_fruit()][fruit.getY_fruit()] = 5;
        
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                System.out.print(tab[i][j]);
            }
            System.out.println("");  
        }
        
        
        
            
        
    }

    @Override
    public String toString() {
        return "Grille : " + tab;
    }
    
        

}
