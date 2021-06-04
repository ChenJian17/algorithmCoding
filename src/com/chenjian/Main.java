package com.chenjian;

public class Main {

    public static void main(String[] args) {
	// write your code here
        final ThreadLocal<Main> holder = ThreadLocal.withInitial(Main::new);
    }
}
