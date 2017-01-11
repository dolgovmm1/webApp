package ru.dolgov.web.dbService;

import ru.dolgov.web.dbService.dataSet.UserDataSet;

/**
 * BigComp
 * 04.01.2017.
 */
public interface DbService{

    public void printConnectInfo() throws DbException;

    public UserDataSet getUserByLogin(String login) throws DbException;

    public long addUser(String login, String password)throws DbException;

    public UserDataSet getUser(long id) throws DbException;
}
