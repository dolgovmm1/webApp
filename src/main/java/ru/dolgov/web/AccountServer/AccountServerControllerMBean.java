package ru.dolgov.web.AccountServer;

/**
 * Interface declared getting fields AccountServer in MBean jconsole
 * @author M. Dolgov
 * 07.01.2017.
 */
public interface AccountServerControllerMBean {
    public int getUsersLimit();

    public int getUsersCount();

    public void setUsersLimit(int usersLimit);
}
