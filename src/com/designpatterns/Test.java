package com.designpatterns;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Test {
    public static class MakeSound {
        private final int BUFFER_SIZE = 128_000;
        private File soundFile;
        private AudioInputStream audioStream;
        private AudioFormat audioFormat;
        private SourceDataLine sourceLine;

        public void playSound(String fileName) {
            try {
                soundFile = new File(fileName);
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
            try {
                audioStream = AudioSystem.getAudioInputStream(soundFile);
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
            audioFormat = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
            try {
                sourceLine = (SourceDataLine) AudioSystem.getLine(info);
                sourceLine.open(audioFormat);
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
            sourceLine.start();
            int nBytesRead = 0;
            byte[] abData = new byte[BUFFER_SIZE];
            while (nBytesRead != -1) {
                try {
                    nBytesRead = audioStream.read(abData, 0, abData.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (nBytesRead >= 0) {
                    int nBytesWritten = sourceLine.write(abData, 0, nBytesRead);
                }
            }
            sourceLine.drain();
            sourceLine.close();
        }
    }

    public static void main(String[] args) {
        MakeSound player = new MakeSound();
        player.playSound("Gloria - Belite manastiri.wav");
    }
}
