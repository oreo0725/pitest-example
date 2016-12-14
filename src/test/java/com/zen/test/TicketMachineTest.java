package com.zen.test;

import com.zen.test.human.Human;
import com.zen.test.human.Sex;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.zen.test.TicketMachine.DISCOUNT_FOR_FEMALE;

/**
 * zen.oreo.test.TicketMachine Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Dec 14, 2016</pre>
 */
public class TicketMachineTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: sellTicket(Human zen.oreo.test.human)
     */
    @Test
    public void testSellTicket_to_male() throws Exception {
        TicketMachine tm = new TicketMachine(10);

        Human man = new Person(18, Sex.MALE);

        Ticket t = tm.sellTicket(man);

        Assert.assertEquals(TicketMachine.ORIGIN_PRICE, t.getPrice(), 0.00000001f);
    }

    /**
     * Method: queryTicketPrice(Human zen.oreo.test.human)
     */
    @Test
    public void testSellTicket_to_female() throws Exception {
        TicketMachine tm = new TicketMachine(10);
        Human woman = new Person(19, Sex.FEMALE);
        Ticket t = tm.sellTicket(woman);

        Assert.assertEquals(TicketMachine.ORIGIN_PRICE * DISCOUNT_FOR_FEMALE, t.getPrice(), 0.00000001f);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testSellTicket_to_non_adult() throws Exception {
        TicketMachine tm = new TicketMachine(10);
        Human woman = new Person(12, Sex.FEMALE);
        Ticket t = tm.sellTicket(woman);

    }

    @Test(expected = UnsupportedOperationException.class)
    public void testSellTicket_to_no_ticket() throws Exception {
        TicketMachine tm = new TicketMachine(0);
        Human woman = new Person(19, Sex.FEMALE);
        Ticket t = tm.sellTicket(woman);

    }

    @Test
    public void testSellTicket_to_male_with_discount() throws Exception {
        TicketMachine tm = new TicketMachine(2);
        Human man = new Person(45, Sex.MALE);
        Ticket t = tm.sellTicket(man);

        Assert.assertEquals(TicketMachine.ORIGIN_PRICE * DISCOUNT_FOR_FEMALE, t.getPrice(), 0.00000001f);
    }
} 
