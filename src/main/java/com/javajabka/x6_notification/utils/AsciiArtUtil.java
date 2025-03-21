package com.javajabka.x6_notification.utils;

import lombok.experimental.UtilityClass;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

@UtilityClass
public class AsciiArtUtil {

    public String getAsciiArtMessage() {
        int width = 200;
        int height = 30;

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setFont(new Font("SansSerif", Font.PLAIN, 14));

        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.drawString("Message received", 10, 20);

        StringBuilder asciiWord = new StringBuilder().append("\n");
        StringBuilder asciiWordTemp = new StringBuilder();

        for (int y = 0; y < height; y++) {
            asciiWordTemp.setLength(0);

            for (int x = 0; x < width; x++) {
                asciiWordTemp.append(image.getRGB(x, y) == -16777216 ? " " : "*");
            }

            if (asciiWordTemp.toString().trim().isEmpty()) {
                continue;
            }
            asciiWord.append(asciiWordTemp).append("\n");
        }

        return asciiWord.toString();
    }
}