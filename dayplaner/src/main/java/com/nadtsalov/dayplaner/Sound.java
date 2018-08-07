package com.nadtsalov.dayplaner;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class Sound {
    public void makeSound(){
        try {
            // Open an audio input stream.
            URL url = this.getClass().getClassLoader().getResource("done.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            // Get a sound clip resource.
            Clip clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException er) {
            er.printStackTrace();
        } catch (IOException er) {
            er.printStackTrace();
        } catch (LineUnavailableException er) {
            er.printStackTrace();
        }
    }
}
