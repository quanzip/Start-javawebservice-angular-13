package com.example.test.using_autocloseable;

public class Main {
    public static void main(String[] args) {

    }

    class Quanzip implements AutoCloseable{

        @Override
        public void close() throws Exception {
            try {
                finalize();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }


    }
}
