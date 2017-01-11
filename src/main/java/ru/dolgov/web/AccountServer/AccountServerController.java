package ru.dolgov.web.AccountServer;

/**
 * BigComp
 * 07.01.2017.
 */
public class AccountServerController implements AccountServerControllerMBean {
    private AccountServer accountServer;

    public AccountServerController(AccountServer accountServer) {
        this.accountServer = accountServer;
    }

    @Override
    public int getUsersLimit() {
        return accountServer.getUserLimit();
    }

    @Override
    public int getUsersCount() {
        return accountServer.getUsersCount();
    }

    @Override
    public void setUsersLimit(int usersLimit) {
        this.accountServer.setUsersLimit(usersLimit);
    }
}
