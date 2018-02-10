package org.thinkbigthings.katas.interviews;

import java.util.*;
import org.thinkbigthings.katas.interviews.Exercise3.Person;
import static org.junit.Assert.*;
import org.junit.Test;

public class Exercise3Test {

    @Test
    public void testAsElement() {

        Set<Person> people = new HashSet<>();

        Person p1 = new Person(1);
        people.add(p1);
        people.add(p1);

        // TODO modify the Person class so that this test passes
        // assertEquals(1, people.size());
    }
}
