package ru.dolgov.web.AccountServer;

/**
 * BigComp
 * 07.01.2017.
 */
public interface AccountServerControllerMBean {
    public int getUsersLimit();

    public int getUsersCount();

    public void setUsersLimit(int usersLimit);
}
