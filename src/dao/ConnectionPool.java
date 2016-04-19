package dao;

import domen.exception.InternalServerError;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * User: настя
 * Date: 02.12.13
 * Time: 16:57
 */
final public class ConnectionPool {

    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_hospital?encoding=UTF-8&useUnicode=true&characterEncoding=UTF-8";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    private static final String ERROR_LOAD_DRIVER = "ошибка загрузки драйвера MySQL";
    private static final String ERROR_WAITING_POOL_READ = "ошибка одновременного чтения из пула соединений";
    private static final String ERROR_DATA_BASE_CONNECT = "ошибка установления соединения";

    private static Logger logger = Logger.getLogger(ConnectionPool.class);

    private BlockingQueue<Connection> connections = new LinkedBlockingQueue<Connection>();

    private ConnectionPool() {
    }

    synchronized public Connection getConnection() {
        Connection connection = null;
        while (connection == null) {
            try {
                if (connections.isEmpty()) {
                    connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                } else {
                    connection = connections.take();
                    if (!connection.isValid(0)) {
                        connection = null;
                    }
                }
            } catch (InterruptedException e) {
                logger.warn(ERROR_WAITING_POOL_READ, e);
                throw new InternalServerError(e);
            } catch (SQLException e) {
                logger.error(ERROR_DATA_BASE_CONNECT, e);
                throw new InternalServerError(e);
            }
        }
        return connection;
    }

    public void freeConnection(Connection connection) {
        try {
            connections.put(connection);
        } catch (InterruptedException e) {
            logger.warn(ERROR_DATA_BASE_CONNECT, e);
        }
    }

    static {
        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            logger.error(ERROR_LOAD_DRIVER, e);
            throw new InternalServerError(e);
        }
    }

    private static ConnectionPool instance = new ConnectionPool();

    public static ConnectionPool getInstance() {
        return instance;
    }

}
