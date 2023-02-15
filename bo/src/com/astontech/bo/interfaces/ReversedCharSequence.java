package com.astontech.bo.interfaces;

public class ReversedCharSequence implements CharSequence {

    private String string;

    public ReversedCharSequence(String string) {
        System.out.println("String is " + string);
        char[] strArray = string.toCharArray();
        char[] reversedArray = strArray.clone();

        int j = strArray.length - 1;
        for (int i = 0; i < strArray.length; i++) {
            reversedArray[j] = strArray[i];
            j--;
        }
        this.string = new String(reversedArray);
        System.out.println("Reversed String to " + this.string);
    }

    @Override
    public int length() {
        return string.length();
    }

    @Override
    public char charAt(int i) {
        return string.charAt(i);
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        return string.subSequence(i, i1);
    }

    @Override
    public String toString() {
        return string;
    }
}
