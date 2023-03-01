/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet_snake;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException; 
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackListener;

public class GestionMP3 extends Thread {
    private String nomMP3;
    
    public void setnomMP3(String nomMP3) {
        try {
            this.nomMP3 = "file:///" + new java.io.File(".").getCanonicalPath() + "/src/Musique/" + nomMP3;
        } catch (IOException ex) {
            Logger.getLogger(GestionMP3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run() {
        try {
            AdvancedPlayer player = new AdvancedPlayer (
                    new java.net.URL(nomMP3).openStream(),
                    javazoom.jl.player.FactoryRegistry.systemRegistry().createAudioDevice()
            );
            player.play();
        } catch (JavaLayerException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
