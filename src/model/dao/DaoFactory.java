package model.dao;
import model.dao.impl.UserDaoMongoDB;

public class DaoFactory {
    public static UserDao createUserDao() {
        return new UserDaoMongoDB();
    }
}