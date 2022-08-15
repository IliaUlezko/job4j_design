package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");
        System.out.println("***************");

        byte first = 123;
        short second = 14275;
        int third = 2_134_657;
        long fourth = 23_145_657_498L;

        LOG.debug("First number equals {}, second equals {}.", first, second);
        LOG.debug("Third number equals {}, fourth equals {}.", third, fourth);

        float number = 123.14F;
        double pi = 3.14159;

        LOG.debug("First number equals {}, second equals {}.", number, pi);

        char example = 'F';
        boolean result = false;

        LOG.debug("The character is {}, result equals {}.", example, result);
    }
}