package ru.dolgov.web.AccountServer;

/**
 * Interface declared mechanism for work with counter logged users and setting users limit
 * @author M. Dolgov
 * 07.01.2017.
 */
public interface AccountServer {
    void addNewUser();

    void removeUser();

    int getUserLimit();

    void setUsersLimit(int usersLimit);

    int getUsersCount();
}
