package com.app.Other;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MultipleGradientPaint;
import java.awt.RadialGradientPaint;
import java.awt.geom.Point2D;
import javax.swing.JPanel;


public class ColorPanel extends JPanel{
    
    

  @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int width = getWidth();
        int height = getHeight();

        Color color1 = new Color(52, 143, 80);
        Color color2 = new Color(86, 180, 211);
        Color color3 = new Color(51, 51, 51);

        float[] fractions = {0.0f, 0.5f, 1.0f};
        Color[] colors = {color1, color2, color3};

        Point2D center = new Point2D.Float(width / 2, height / 2);
        float radius = width / 2;

        MultipleGradientPaint paint = new RadialGradientPaint(center, radius, fractions, colors);

        g2d.setPaint(paint);
        g2d.fillRect(0, 0, width, height);
    }
    
}
