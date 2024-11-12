package ZJava.Exception;

import java.io.IOException;

public class ThrowException {
    public void helper() throws NullPointerException {
        throw new NullPointerException();
    }

    public void method() {
        helper();
    }
    
    public void accessDBHelper() throws IOException {
        throw new IOException();
    }

    public void accessDB() {
        try {
            accessDBHelper();
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            // sys
        }
    }

    public void subAccessDB(int type) throws InterruptedException, ClassNotFoundException {
        if(type == 1) {
            throw new InterruptedException("WOW");
        } else if(type == 2) {
            throw new ClassNotFoundException("KATT");
        }
    }

    public void history() {
        try {
            subAccessDB(2);
        } catch(InterruptedException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Finally block");
        }
    }

    public void rawThrow() throws Exception {
        throw new Exception("Giga Inet Jnet");
    }

    public void invokeRawType() {
        try {
            rawThrow();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int sampleMethod() {
        try {
            System.out.println("In the Try block");
            return 5;
        } catch(NullPointerException e) {
            System.out.println("In the Catch block");
            System.out.println(e.getMessage());
        } finally {
            System.out.println("In the finally block");
        }
        System.out.println("Method End");
        return 0;
    }

    public void caller() {
        System.out.println(sampleMethod());
    }

    public void callerMethod() {
        throw new ClassCastException();
    }
}
