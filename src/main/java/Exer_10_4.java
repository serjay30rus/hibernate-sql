import model.Purchaselist;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

// ЗАДАНИЕ 10.4.

           // Напишите код новой таблицы LinkedPurchaseList, которая заполняется на основании данных таблицы PurchaseList.
           // Таблица должна содержать следующие поля:  student_id, course_id.


public class Exer_10_4 {

    public static void main(String[] args) {
        StandardServiceRegistry reg = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(reg).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Purchaselist> newPurchaseList = session.createQuery("from Purchaselist").getResultList();
        for (Purchaselist purchase : newPurchaseList) {
            System.out.println(
                    purchase.getKey().getStudentName() + " | " +
                    purchase.getKey().getCourseName() + " | " +
                    purchase.getPrice() + " | " +
                    purchase.getSubscriptionDate()
            );
        }

        transaction.commit();
        sessionFactory.close();

    }
}