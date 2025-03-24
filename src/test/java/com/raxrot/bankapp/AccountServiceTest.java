package com.raxrot.bankapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceTest {

    private AccountService accountService;

    @BeforeEach
    void setUp(){
        accountService=new AccountService();
    }

    @Test
    void testCreateAccount(){
       Account account =
               accountService.createAccount(123L,"Vlad Bulahov",500.0);

       assertNotNull(account);

       assertEquals("Vlad Bulahov",account.getHolderName());
       assertEquals(500.0,account.getBalance());
       assertEquals(123L,account.getAccountNumber());
    }

    @Test
    void testUpdateAccount(){
        Account account =
                accountService.createAccount(123L,"Vlados Bulahovos",500.0);
       Account updatedAccount = accountService.updateAccount(123L,"Vlad Bulahov");

       assertEquals("Vlad Bulahov",updatedAccount.getHolderName());

       assertThrows(AccountNotFoundException.class,()->{
           accountService.updateAccount(1234L,"Vlad Bulahov");
       });
    }

    @Test
    void testGetAccount(){
        Account account =
                accountService.createAccount(123L,"Vlad Bulahov",500.0);
        Account retrievedAccount = accountService.getAccount(123L);
        assertNotNull(retrievedAccount);
        assertEquals("Vlad Bulahov",retrievedAccount.getHolderName());
        assertEquals(500.0,retrievedAccount.getBalance());
        assertThrows(AccountNotFoundException.class,()->{
            accountService.getAccount(1234L);
        });
    }

    @Test
    void testDeleteAccount(){
        Account account =
                accountService.createAccount(123L,"Vlad Bulahov",500.0);
        accountService.removeAccount(account.getAccountNumber());
        assertThrows(AccountNotFoundException.class,()->{
            accountService.removeAccount(123L);
        });
    }

    @Test
    void testDeposit(){
        Account account =
                accountService.createAccount(123L,"Vlad Bulahov",500.0);
        accountService.deposit(account.getAccountNumber(),500.0);

        assertThrows(AccountNotFoundException.class,()->{
            accountService.deposit(1235L,500.0);
        });

        assertEquals(1000.0,account.getBalance());

        assertThrows(IllegalArgumentException.class,()->{
            accountService.deposit(123L,-500.0);
        });
    }

    @Test
    void testWithdraw(){
        Account account =
                accountService.createAccount(123L,"Vlad Bulahov",500.0);
        accountService.withdraw(account.getAccountNumber(),200.0);

        assertThrows(AccountNotFoundException.class,()->{
            accountService.deposit(1235L,500.0);
        });

        assertEquals(300.0,account.getBalance());

        assertThrows(IllegalArgumentException.class,()->{
            accountService.withdraw(123L,-500.0);
        });

        assertThrows(IllegalArgumentException.class,()->{
            accountService.withdraw(123L,1000.0);
        });
    }

    @Test
    void testTransfer(){
        Account fromAccount =
                accountService.createAccount(123L,"Vlad Bulahov",500.0);
        Account toAccount =
                accountService.createAccount(1234L,"Vlados Bulahovs",500.0);
        accountService.transferMoney(fromAccount.getAccountNumber(),toAccount.getAccountNumber(),200.0);

        assertThrows(AccountNotFoundException.class,()->{
            accountService.transferMoney(12345L,toAccount.getAccountNumber(),1000.0);
        });
        assertThrows(AccountNotFoundException.class,()->{
            accountService.transferMoney(toAccount.getAccountNumber(),12345L,1000.0);
        });

        assertThrows(IllegalArgumentException.class,()->{
            accountService.transferMoney(fromAccount.getAccountNumber(),toAccount.getAccountNumber(),5000.0);
        });
        assertThrows(IllegalArgumentException.class,()->{
            accountService.transferMoney(fromAccount.getAccountNumber(),toAccount.getAccountNumber(),-50.0);
        });

        assertEquals(300.0,fromAccount.getBalance());
        assertEquals(700.0,toAccount.getBalance());
    }
}