package lk.iit.level6.concurrent.assignment;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Machine implements ServiceTicketMachine {
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition haveTonerLevel = lock.newCondition();
    private final Condition havePaperLevel = lock.newCondition();
    private final Condition noResource = lock.newCondition();
    private int paperLevel;
    private int tonerLevel;

    public Machine(int paperLevel, int tonerLevel) {
        this.paperLevel = paperLevel;
        this.tonerLevel = tonerLevel;
    }

    private boolean isResourceAvailable() {
        return paperLevel > 0 && tonerLevel >= TicketMachine.MINIMUM_TONER_LEVEL;
    }

    private void printTicket() {
        tonerLevel -= 1;
        paperLevel -= 1;
    }

    @Override
    public void replaceTonerCartridge() {
        try {
            lock.lock();

            while (tonerLevel >= TicketMachine.MINIMUM_TONER_LEVEL) {
                System.out.println("Have toner");
                haveTonerLevel.await();
            }

            tonerLevel = TicketMachine.FULL_TONER_LEVEL;
            System.out.println(Thread.currentThread().getName() + " Filled the Toner");

            noResource.signalAll();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
           lock.unlock();
        }
    }

    @Override
    public void refillTicketPaper() {
        try {
            lock.lock();

            while ((paperLevel + TicketMachine.SHEETS_PER_PACK) > TicketMachine.FULL_PAPER_TRAY) {
                System.out.println("Have paper");
                havePaperLevel.await();
            }

            paperLevel += TicketMachine.SHEETS_PER_PACK;
            System.out.println(Thread.currentThread().getName() + " Filled the Paper");

            noResource.signalAll();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
    @Override
    public void printTicket(Ticket ticket) {

        try {
            lock.lock();

            while (!isResourceAvailable()) {

                System.out.println("No resource available");
                noResource.await();
            }
            printTicket();
            System.out.println("Ticket printed by " + Thread.currentThread().getName() + "Ticket : " + ticket.toString());

            havePaperLevel.signalAll();
            haveTonerLevel.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int getPaperLevel() {
        return paperLevel;
    }

    @Override
    public int getTonerLevel() {
        return tonerLevel;
    }
}
