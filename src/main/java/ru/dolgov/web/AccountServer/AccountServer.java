package ru.dolgov.web.AccountServer;

/**
 * BigComp
 * 07.01.2017.
 */
public interface AccountServer {
    void addNewUser();

    void removeUser();

    int getUserLimit();

    void setUsersLimit(int usersLimit);

    int getUsersCount();
}
