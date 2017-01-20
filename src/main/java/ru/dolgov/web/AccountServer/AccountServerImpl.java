package ru.dolgov.web.AccountServer;

/**
 * Class implement mechanism for work with counter logged users and setting users limit
 * @author M. Dolgov
 * 07.01.2017.
 */
public class AccountServerImpl implements AccountServer {
    private int usersCount;
    private int usersLimit;

    public AccountServerImpl(int usersLimit) {
        this.usersCount = 0;
        this.usersLimit = usersLimit;
    }

    @Override
    public void addNewUser() {
        this.usersCount += 1;
    }

    @Override
    public void removeUser() {
        this.usersCount -= 1;
    }

    @Override
    public int getUserLimit() {
        return usersLimit;
    }

    @Override
    public void setUsersLimit(int usersLimit) {
        this.usersLimit = usersLimit;
    }

    @Override
    public int getUsersCount() {
        return usersCount;
    }
}
