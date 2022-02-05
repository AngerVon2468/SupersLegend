package com.superworldsun.superslegend.util.cookingpot;

import java.text.DecimalFormat;

public final class MathUtils {
    //Code credited to Si_hen, this code is a modified version of their crockpot mod
    public static boolean fuzzyEquals(final double a, final double b) {
        return Math.abs(a - b) * 1000000000000.0D <= Math.min(Math.abs(a), Math.abs(b));
    }

    public static boolean fuzzyEquals(final float a, final float b) {
        return Math.abs(a - b) * 100000.0F <= Math.min(Math.abs(a), Math.abs(b));
    }

    public static boolean fuzzyIsZero(final double d) {
        return Math.abs(d) <= 0.000000000001D;
    }

    public static boolean fuzzyIsZero(final float f) {
        return Math.abs(f) <= 0.00001F;
    }

    /**
     * @deprecated Use {@link StringUtils#format(double, String)} instead.
     */
    @Deprecated
    public static String format(final double d, final String pattern) {
        return new DecimalFormat(pattern).format(d);
    }

    /**
     * @deprecated Use {@link StringUtils#format(float, String)} instead.
     */
    @Deprecated
    public static String format(final float f, final String pattern) {
        return new DecimalFormat(pattern).format(f);
    }
}