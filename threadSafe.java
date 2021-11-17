class Table1 {

    private static Table1 table1;
    private static String customerNameBooked;

    private Table1(String customerName)
    {

        System.out.println("Table1 is now Booked for "
                + customerName);

        // Booking under the same person
        customerNameBooked = customerName;
    }

    public static Table1
    getTable1Instance(String customerName)
    {

        // If table is nor book/reserve
        if (table1 == null) {

            // book under the derired customer name
            table1 = new Table1(customerName);
        }

        // If table is already booked
        else

            // Calling th method
            tableBooked(customerName);
        return table1;
    }

    private static void tableBooked(String customerName)
    {

        System.out.println(
                "Sorry " + customerName
                        + " Table 1 is already Booked for "
                        + customerNameBooked);
    }
}

class Restaurant {

    // Main driver method
    public static void main(String args[])
    {
        Thread t1 = new Thread(new Runnable() {
            public void run()
            {

                // Getting the table status
                Table1 customer1
                        = Table1.getTable1Instance("ABC");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            // run() method for this thread
            public void run()
            {

                Table1 customer2
                        = Table1.getTable1Instance("XYZ");
            }
        });

        Thread t3 = new Thread(new Runnable() {
            // run() method for this thread
            public void run()
            {

                Table1 customer3
                        = Table1.getTable1Instance("PQR");
            }
        });

        t1.start();
        t2.start();

        // Try block to check for exceptions if any
        try {

            Thread.sleep(1000);
        }
        
        catch (InterruptedException e) {
        }

        // Now starting the last thread via same means
        t3.start();
    }
}
