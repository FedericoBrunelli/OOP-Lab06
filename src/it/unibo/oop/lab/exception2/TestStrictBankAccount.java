package it.unibo.oop.lab.exception2;

import org.junit.Test;

/**
 * JUnit test to test
 * {@link StrictBankAccount}.
 * 
 */
public final class TestStrictBankAccount {

    /**
     * Used to test Exceptions on {@link StrictBankAccount}.
     */
   @Test
    public void testBankOperations() {
        /*
         * 1) Creare due StrictBankAccountImpl assegnati a due AccountHolder a
         * scelta, con ammontare iniziale pari a 10000 e nMaxATMTransactions=10
         * 
         * 2) Effetture un numero di operazioni a piacere per verificare che le
         * eccezioni create vengano lanciate soltanto quando opportuno, cioè in
         * presenza di un id utente errato, oppure al superamento del numero di
         * operazioni ATM gratuite.
         */
    	AccountHolder ah1 = new AccountHolder("fede", "bruno", 101);
    	AccountHolder ah2 = new AccountHolder("davi", "pesce", 102);
    	StrictBankAccount ba1 = new StrictBankAccount(101, 4000, 50);
    	StrictBankAccount ba2 = new StrictBankAccount(102, 2000, 10);
    	ba1.deposit(101, 200);
    	ba2.deposit(100, 200);
    	for (int i = 0; i < 20; i++) {
    		System.out.println("ba2: " + ba2.getBalance());
    		ba2.withdrawFromATM(102, 150);
    	}
    	
    	ba2.withdraw(102, 2100);
		System.out.println("\nba2: " + ba2.getBalance());
    }
}
