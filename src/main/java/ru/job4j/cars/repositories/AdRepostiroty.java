package ru.job4j.cars.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import ru.job4j.cars.models.Announcement;
import ru.job4j.cars.models.Brand;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

/**
 * Class AdRepostiroty
 *
 * @author Dmitry Razumov
 * @version 1
 */
public class AdRepostiroty {

    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    /**
     * Метод возвращает объявления за последний день.
     * @return Список объявлений.
     */
    public List<Announcement> findAdsLastDay() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date startDate = cal.getTime();
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        Date endDate = cal.getTime();
        return this.tx(session -> {
            Query query = session.createQuery(
                    "select ads from Announcement ads "
                            + "join fetch ads.user "
                            + "join fetch ads.photo "
                            + "join fetch ads.car c "
                            + "join fetch c.body "
                            + "join fetch c.engine "
                            + "join fetch c.model m "
                            + "join fetch m.brand "
                            + "where ads.created between :startDate and :endDate"
            )
                    .setParameter("startDate", startDate)
                    .setParameter("endDate", endDate);
            return query.list();
        });
    }

    /**
     * Метод возвращает список объявлений с фото.
     * @return Список объявлений.
     */
    public List<Announcement> findAdsWithPhoto() {
        return this.tx(session -> {
            Query query = session.createQuery(
                    "select ads from Announcement ads "
                            + "join fetch ads.user "
                            + "join fetch ads.car c "
                            + "join fetch c.body "
                            + "join fetch c.engine "
                            + "join fetch c.model m "
                            + "join fetch m.brand "
                            + "join fetch ads.photo ph "
                            + "where ph is not null "
            );
            return query.list();
        });
    }

    /**
     * Метод возвращает список объявлений по заданной марке.
     * @param brand Марка автомобилей.
     * @return Список объявлений.
     */
    public List<Announcement> findAdsByBrand(Brand brand) {
        return this.tx(session -> {
            Query query = session.createQuery(
                    "select ads from Announcement ads "
                            + "join fetch ads.user "
                            + "join fetch ads.photo "
                            + "join fetch ads.car c "
                            + "join fetch c.body "
                            + "join fetch c.engine "
                            + "join fetch c.model m "
                            + "join fetch m.brand b "
                            + "where b.name = :name "
            )
                    .setParameter("name", brand.getName());
            return query.list();
        });
    }

    /**
     * Метод закрывает соединение с БД.
     * @throws Exception Исключение.
     */
    public void close() throws Exception {
        StandardServiceRegistryBuilder.destroy(registry);
    }

    /**
     * Метод реализует обертку над всеми транзакциями Hibernate к базе данных.
     * @param command Запрос к базе данных, который нужно выполнить.
     * @param <T> Тип возвращаемого значения.
     * @return Результат запроса.
     */
    private <T> T tx(final Function<Session, T> command) {
        final Session session = sf.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            T rsl = command.apply(session);
            tx.commit();
            return rsl;
        } catch (final Exception e) {
            tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}
