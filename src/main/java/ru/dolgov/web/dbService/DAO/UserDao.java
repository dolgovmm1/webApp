package ru.dolgov.web.dbService.DAO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import ru.dolgov.web.dbService.dataSet.UserDataSet;

/**
 * Class implement mechanism o work with database over Hibernate
 * @author M. Dolgov
 * 04.01.2017.
 */
public class UserDao {
    static final Logger log = LogManager.getLogger(UserDao.class.getName());
    private Session session;

    /**
     * Constructor
     * @param session
     */
    public UserDao(Session session){
        log.debug("Created UserDao");
        this.session = session;
    }

    /**
     * Method to get record about user by Id
     * @param id long
     * @return UserDataSet
     * @throws HibernateException
     */
    public UserDataSet get(long id) throws HibernateException{
        log.debug("Get UserDataSet by id = " + id);
        return (UserDataSet) session.get(UserDataSet.class, id);
    }

    /**
     * Method to insert new user into table
     * @param name String
     * @param password String
     * @return userId long
     * @throws HibernateException
     */
    public long insertUser(String name, String password) throws HibernateException{
        log.debug("Insert user into DB");
        return (Long) session.save(new UserDataSet(name, password));
    }

    /**
     * Method to get record about user by name
     * @param name String
     * @return UserDataSet
     * @throws HibernateException
     */
    public UserDataSet getUser(String name) throws HibernateException{
        log.debug("Get UserDataSet by name = " + name);
        Criteria criteria = session.createCriteria(UserDataSet.class);
        return ((UserDataSet) criteria.add(Restrictions.eq("name", name)).uniqueResult());
    }

    /**
     * Method to get user id by name
     * @param name String
     * @return Id long
     * @throws HibernateException
     */
    public long getUserId(String name) throws HibernateException{
        log.debug("Get UserID by name = " + name);
        Criteria criteria = session.createCriteria(UserDataSet.class);
        return ((UserDataSet) criteria.add(Restrictions.eq("name", name)).uniqueResult()).getId();
    }
}
