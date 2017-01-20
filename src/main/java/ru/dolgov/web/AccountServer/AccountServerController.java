package ru.dolgov.web.AccountServer;

/**
 * Class implrement getting fields AccountServer in MBean jconsole
 * @author M. Dolgov
 * 07.01.2017.
 */
public class AccountServerController implements AccountServerControllerMBean {
    private AccountServer accountServer;

    /**
     * Constructor
     * @param accountServer
     */
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
