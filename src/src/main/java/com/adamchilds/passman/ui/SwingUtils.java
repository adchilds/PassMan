package com.adamchilds.passman.ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Provides useful static functions and constants for creating Swing-based UIs.
 *
 * @author Adam Childs
 */
public class SwingUtils {

    /**
     * Creates a new instance of a {@link JPanel} and sets the opacity of the panel to 0. Transparent {@link JPanel}s
     * are useful to allow components below them to display color or content.
     *
     * @param components any components that should be added to the given JPanel upon creation
     * @return a transparent {@link JPanel}
     */
    public static JPanel createTransparentJPanel(Component... components) {
        JPanel panel = new JPanel();
        panel.setOpaque(false);

        for (Component component : components) {
            panel.add(component);
        }

        return panel;
    }

    /**
     * Creates a new instance of a {@link RoundedBorder}, useful for adding a radius to {@link Component}s that support
     * {@link Border}s.
     *
     * @param radius the radius of the border to set
     * @param isOpaque defines whether or not the border is opaque
     * @return a new {@link RoundedBorder} with the given {@code radius}
     */
    public static RoundedBorder roundedBorder(int radius, boolean isOpaque) {
        return new RoundedBorder(radius, isOpaque);
    }

    /**
     * Forces a rounded border to components that accept the setBorder() method
     *
     * @author Adam Childs
     * @since 1.0
     */
    private static class RoundedBorder implements Border {
        private int radius;
        private boolean isOpaque;

        public RoundedBorder(int radius, boolean isOpaque) {
            this.radius = radius;
            this.isOpaque = isOpaque;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isBorderOpaque() {
            return isOpaque;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }
    }

}