package DBTrouble;

import org.sqlite.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DbHandler {

    // Константа, в которой хранится адрес подключения
    private static final String CON_STR = "jdbc:sqlite:myfin.db";

    // Используем шаблон одиночка, чтобы не плодить множество
    // экземпляров класса DbHandler
    private static DbHandler instance = null;

    public static synchronized DbHandler getInstance() throws SQLException {
        if (instance == null)
            instance = new DbHandler();
        return instance;
    }

    // Объект, в котором будет храниться соединение с БД
    private Connection connection;

    private DbHandler() throws SQLException {
        // Регистрируем драйвер, с которым будем работать
        // в нашем случае Sqlite
        DriverManager.registerDriver(new JDBC());
        // Выполняем подключение к базе данных
        this.connection = DriverManager.getConnection(CON_STR);
    }

    public List<Product> getAllProducts() {

        // Statement используется для того, чтобы выполнить sql-запрос
        try (Statement statement = this.connection.createStatement()) {
            // В данный список будем загружать наши продукты, полученные из БД
            List<Product> products = new ArrayList<Product>();
            // В resultSet будет храниться результат нашего запроса,
            // который выполняется командой statement.executeQuery()
            ResultSet resultSet = statement.executeQuery("SELECT id, good, price, category_name FROM products");
            // Проходимся по нашему resultSet и заносим данные в products
            while (resultSet.next()) {
                products.add(new Product(resultSet.getInt("id"),
                        resultSet.getString("good"),
                        resultSet.getDouble("price"),
                        resultSet.getString("category_name")));
            }
            // Возвращаем наш список
            return products;

        } catch (SQLException e) {
            e.printStackTrace();
            // Если произошла ошибка - возвращаем пустую коллекцию
            return Collections.emptyList();
        }
    }

    // Добавление продукта в БД
    public void addProduct(Product product) {
        // Создадим подготовленное выражение, чтобы избежать SQL-инъекций
        try (PreparedStatement statement = this.connection.prepareStatement(
                "INSERT INTO Products(`good`, `price`, `category_name`) " +
                        "VALUES(?, ?, ?)")) {
            statement.setObject(1, product.good);
            statement.setObject(2, product.price);
            statement.setObject(3, product.category_name);
            // Выполняем запрос
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Удаление продукта по id
    public void deleteProduct(int id) {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "DELETE FROM Products WHERE id = ?")) {
            statement.setObject(1, id);
            // Выполняем запрос
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public LinkedList<String> getPlain() {
        LinkedList<String> list = new LinkedList<>();
        try (Statement statement = this.connection.createStatement()) {

//            ResultSet resultSet = statement.executeQuery("EXPLAIN QUERY PLAN SELECT id, good, price, category_name FROM products");
//            ResultSet resultSet = statement.executeQuery("PRAGMA table_info(products)"); //инфо о данных в таблице
//            ResultSet resultSet = statement.executeQuery("SELECT name FROM sqlite_master WHERE type='table'"); //список таблиц в БД
//            ResultSet resultSet1 = statement.executeQuery("CREATE INDEX ind_col_a ON products (id);"); //
//            resultSet1.getString(1);
//REINDEX dbname.tblname  - перестройка индекса
            statement.executeQuery("DROP INDEX products.ind_col_a"); //удаление индекса
            ResultSet resultSet = statement.executeQuery("PRAGMA index_list(products)"); //выводит индексы на БД


            while (resultSet.next()) {
                list.add( resultSet.getString(1)+ " " + resultSet.getString(2)+" " +resultSet.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}