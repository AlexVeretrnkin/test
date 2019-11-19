package ua.procamp.util;

/**
 * {@link MutableInt} Is an object that wraps {int} basic type and
 *  provides an ability to work with integers as a mutable object.
 */
public class MutableInt {
    private int value;

    public MutableInt(int value) {
        this.value = value;
    }

    public void increment() {
        this.value += 1;
    }

    public void decrement() {
        this.value -= 1;
    }

    public void set(int value) {
        this.value = value;
    }

    public int get() {
        return this.value;
    }

    public int getAsInt() {
        return this.value;
    }

    public String toString() {
        return String.valueOf(this.value);
    }
}
