package DBTrouble;

import java.sql.*;
import java.util.List;

public class DBTrouble {
    // неоптимальный запрос на БД, требующий анализ плана запроса, постройки индекса на БД

    public static void main(String[] args) {
        try {
            // Создаем экземпляр по работе с БД
            DbHandler dbHandler = DbHandler.getInstance();
            // Добавляем запись
            //dbHandler.addProduct(new Product("Музей", 200, "Развлечения"));
            // Получаем все записи и выводим их на консоль
            for (int i = 7; i < 15; i++) {
                dbHandler.addProduct(new Product(i, "dsafsadf", 123d, "fsdfdsf"));
            }

            List<Product> products = dbHandler.getAllProducts();
            for (Product product : products) {
                System.out.println(product.toString());
            }

            System.out.println(dbHandler.getPlain());
            // Удаление записи с id = 8
            //dbHandler.deleteProduct(8);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
