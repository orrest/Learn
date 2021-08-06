package jlang.multithread.synchronize;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ThreadlocalTest {
    public static final ThreadLocal<SimpleDateFormat> dateFormat =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    public static void main(String[] args) {
        String dateStamp = dateFormat.get().format(new Date());
    }
}
