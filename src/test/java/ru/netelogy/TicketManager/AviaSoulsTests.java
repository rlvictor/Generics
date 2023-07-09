package ru.netelogy.TicketManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

class AviaSoulsTests {

    @Test
    public void testSortTicketsSeveralTrips() {

        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "IST", 200, 10, 12);
        Ticket ticket2 = new Ticket("MSK", "IST", 100, 11, 14);
        Ticket ticket3 = new Ticket("MSK", "NYK", 200, 10, 16);
        Ticket ticket4 = new Ticket("MSK", "IST", 400, 7, 7);
        Ticket ticket5 = new Ticket("SPB", "IST", 800, 4, 9);
        Ticket ticket6 = new Ticket("MSK", "IST", 200, 6, 10);
        Ticket ticket7 = new Ticket("SVO", "MSK", 300, 15, 18);
        Ticket ticket8 = new Ticket("MSK", "IST", 500, 7, 8);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.search("MSK", "IST");
        Ticket[] expected = {ticket2, ticket1, ticket6, ticket4, ticket8};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketsOneTrips() {

        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "IST", 200, 10, 12);
        Ticket ticket2 = new Ticket("MSK", "IST", 100, 11, 14);
        Ticket ticket3 = new Ticket("MSK", "NYK", 200, 10, 16);
        Ticket ticket4 = new Ticket("MSK", "IST", 400, 7, 7);
        Ticket ticket5 = new Ticket("SPB", "IST", 800, 4, 9);
        Ticket ticket6 = new Ticket("MSK", "IST", 200, 6, 10);
        Ticket ticket7 = new Ticket("SVO", "MSK", 300, 15, 18);
        Ticket ticket8 = new Ticket("MSK", "IST", 500, 7, 8);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.search("SVO", "MSK");
        Ticket[] expected = {ticket7};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketsNullTrips() {

        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "IST", 200, 10, 12);
        Ticket ticket2 = new Ticket("MSK", "IST", 100, 11, 14);
        Ticket ticket3 = new Ticket("MSK", "NYK", 200, 10, 16);
        Ticket ticket4 = new Ticket("MSK", "IST", 400, 7, 7);
        Ticket ticket5 = new Ticket("SPB", "IST", 800, 4, 9);
        Ticket ticket6 = new Ticket("MSK", "IST", 200, 6, 10);
        Ticket ticket7 = new Ticket("SVO", "MSK", 300, 15, 18);
        Ticket ticket8 = new Ticket("MSK", "IST", 500, 7, 8);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.search("SVO", "IST");
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void testSortTicketsWithComparatorSeveralTrips() {

        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "IST", 200, 10, 12);
        Ticket ticket2 = new Ticket("MSK", "IST", 100, 11, 14);
        Ticket ticket3 = new Ticket("MSK", "NYK", 200, 10, 16);
        Ticket ticket4 = new Ticket("MSK", "IST", 400, 7, 17);
        Ticket ticket5 = new Ticket("SPB", "IST", 800, 4, 9);
        Ticket ticket6 = new Ticket("MSK", "IST", 200, 6, 10);
        Ticket ticket7 = new Ticket("SVO", "MSK", 300, 15, 18);
        Ticket ticket8 = new Ticket("MSK", "IST", 500, 7, 8);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("MSK", "IST", comparator);
        Ticket[] expected = {ticket8, ticket1, ticket2, ticket6, ticket4};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketsWithComparatorOneTrips() {

        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "IST", 200, 10, 12);
        Ticket ticket2 = new Ticket("MSK", "IST", 100, 11, 14);
        Ticket ticket3 = new Ticket("MSK", "NYK", 200, 10, 16);
        Ticket ticket4 = new Ticket("MSK", "IST", 400, 7, 17);
        Ticket ticket5 = new Ticket("SPB", "IST", 800, 4, 9);
        Ticket ticket6 = new Ticket("MSK", "IST", 200, 6, 10);
        Ticket ticket7 = new Ticket("SVO", "MSK", 300, 15, 18);
        Ticket ticket8 = new Ticket("MSK", "IST", 500, 7, 8);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("SVO", "MSK", comparator);
        Ticket[] expected = {ticket7};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketsWithComparatorNullTrips() {

        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "IST", 200, 10, 12);
        Ticket ticket2 = new Ticket("MSK", "IST", 100, 11, 14);
        Ticket ticket3 = new Ticket("MSK", "NYK", 200, 10, 16);
        Ticket ticket4 = new Ticket("MSK", "IST", 400, 7, 17);
        Ticket ticket5 = new Ticket("SPB", "IST", 800, 4, 9);
        Ticket ticket6 = new Ticket("MSK", "IST", 200, 6, 10);
        Ticket ticket7 = new Ticket("SVO", "MSK", 300, 15, 18);
        Ticket ticket8 = new Ticket("MSK", "IST", 500, 7, 8);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("SPB", "SVO", comparator);
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

}
