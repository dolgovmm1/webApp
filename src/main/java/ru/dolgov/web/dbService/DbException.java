package ru.dolgov.web.dbService;

/**
 * Wrapper Hibernate exception
 * @author M. Dolgov
 * 04.01.2017.
 */
public class DbException extends Exception{
    public DbException(Throwable throwable){
        super(throwable);
    }
}
