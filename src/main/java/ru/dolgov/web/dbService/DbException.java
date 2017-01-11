package ru.dolgov.web.dbService;

/**
 * BigComp
 * 04.01.2017.
 */
public class DbException extends Exception{
    public DbException(Throwable throwable){
        super(throwable);
    }
}
