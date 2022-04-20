//package coms309.backend.authCode;
//
//import java.security.SecureRandom;
//import java.util.Objects;
//import java.util.Random;
//
//public class RandAlphaNum {
//
//    public static final String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//    public static final String numbers = "0123456789";
//    public static final String alphanum = alpha + numbers;
//    public static final int length = 5;
//
//    private final Random random;
//
//    private final char[] symbols;
//
//    private final char[] buf;
//
//    public RandAlphaNum(int length, Random random, String symbols) {
//        if (length < 1) throw new IllegalArgumentException();
//        if (symbols.length() < 2) throw new IllegalArgumentException();
//        this.random = Objects.requireNonNull(random);
//        this.symbols = symbols.toCharArray();
//        this.buf = new char[length];
//    }
//
//    /**
//     * Create an alphanumeric string generator.
//     */
//    public RandAlphaNum(int length, Random random) {
//        this(length, random, alphanum);
//    }
//
//    /**
//     * Create an alphanumeric strings from a secure generator.
//     */
//    public RandAlphaNum(int length) {
//        this(length, new SecureRandom());
//    }
//
//    //    /**
////     * Create session identifiers.
////     */
////    public RandomString() {
////        this(5);
////    }
//
//}
