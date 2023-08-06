package com.sheb.filtertools.highlight;

public enum IconPlacement {
    LEFT_TOP(0, 0),
    LEFT_BOTTOM(0, 1),
    RIGHT_TOP(1, 0),
    RIGHT_BOTTOM(1, 1);

    private final float leftPercent;
    private final float topPercent;

    IconPlacement(float leftPercent, float topPercent) {
        this.leftPercent = leftPercent;
        this.topPercent = topPercent;
    }

    public int translateX(int x) {
        return (int) Math.floor(x + 8 * this.leftPercent);
    }

    public int translateY(int y) {
        return (int) Math.floor(y + 8 * this.topPercent);
    }
}
