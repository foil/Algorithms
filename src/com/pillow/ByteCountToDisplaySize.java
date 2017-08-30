package com.pillow;

import java.util.Locale;

public class ByteCountToDisplaySize {
    private static String byteCountToDisplaySize(long bytes, boolean si) {
        int unit = si ? 1000 : 1024;
        if (bytes < unit) return bytes + " B";
        int exp = (int) (Math.log(bytes) / Math.log(unit));
        String pre = (si ? "KMGTPE" : "KMGTPE").charAt(exp - 1) + (si ? "" : "i");
        return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
    }

    private static String bytes2Str(int bytes) {
        int exp = 0, unit = 0;
        int []i = new int[] {bytes, 0};
        String pre = "KMGTPE";
        while (exp <= pre.length()) {
            unit = bytes >> 10;
            if (unit == 0)
                break;
            exp++;
            i[0] = unit;
            i[1] = bytes - (unit << 10);
            bytes = unit;
        }
        int dec = (i[1] * 10 + 1023) >> 10;
        if (dec == 10) {
            i[0] ++;
            dec = 0;
        }
        return exp > 0?
                String.format(Locale.ENGLISH, "%d.%d%sB", i[0], dec, pre.charAt(exp - 1)):
                String.format(Locale.ENGLISH, "%dB", i[0]);
    }
}
