package com.zen.test.human;

/**
 * @author zen
 * @since 20161214.
 */
public interface Human {

    default int getAge() {
        return 0;
    }

    Sex getSex();
}
