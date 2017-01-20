package ru.dolgov.web.dbService.dataSet;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Class for work with database.
 * This class described table Users in database
 * @author Dolgov
 * 04.01.2017.
 */
@Entity
@Table(name = "users")
public class UserDataSet implements Serializable{
    private static final long serialVersionUID = -8706689714326132798L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", unique = true, updatable = false, nullable = false)
    private String name;

    @Column(name = "password", updatable = true, nullable = false)
    private String password;

    @SuppressWarnings("UnuserDeclaration")
    public UserDataSet(){
    }

    @SuppressWarnings("UnusedDeclaration")
    public UserDataSet(String name, long id){
        this.id = id;
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDataSet(String name, String password){
        this.setId(-1);
        this.setName(name);
        this.setPassword(password);
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    @SuppressWarnings("UnusedDeclaration")
    public String getName() {
        return name;
    }

    /**
     * Returns a string representation of the object. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * <p>
     * The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "UserDataSet{" +
                "Id = " + id +
                " Name = " + name + '\'' + "}";
    }
}
