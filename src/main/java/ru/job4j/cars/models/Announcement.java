package ru.job4j.cars.models;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * Class Announcement
 * Класс характеризует объявление.
 * @author Dmitry Razumov
 * @version 1
 */
@Entity
@Table(name = "announcements")
public class Announcement {
    /**
     * Идентификатор объявления.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Описание объявления.
     */
    private String description;
    /**
     * Дата и время создания объявления.
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    /**
     * Статус объявления.
     */
    private boolean status;
    /**
     * Фото для объявления.
     */
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "photo_id")
    private Photo photo;
    /**
     * Автомобиль.
     */
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "car_id")
    private Car car;
    /**
     * Пользователь.
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * Фабрика создает объявление.
     * @param description Описание.
     * @param car Автомобиль.
     * @param user Пользователь.
     * @return Объявление.
     */
    public static Announcement of(String description, Car car, User user) {
        Announcement adt = new Announcement();
        adt.description = description;
        long droppedMillis = 1000 * (System.currentTimeMillis() / 1000);
        adt.created = new Date(droppedMillis);
        adt.car = car;
        adt.user = user;
        return adt;
    }

    /**
     * Метод возвращает идентификатор.
     * @return Идентификатор.
     */
    public int getId() {
        return id;
    }

    /**
     * Метод задает идентификатор.
     * @param id Идентификатор.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Метод возвращает описание.
     * @return Описание.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Метод задает описание.
     * @param description Описание.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Метод возвращает дату и время создания.
     * @return Дата и время.
     */
    public Date getCreated() {
        return created;
    }

    /**
     * Метод задает дату и время.
     * @param created Дата и время.
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * Метод возвращает статус.
     * @return Статус.
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * Метод задает статус.
     * @param status Статус.
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * Метод возвращает фото.
     * @return Фото.
     */
    public Photo getPhoto() {
        return photo;
    }

    /**
     * Метод задает фото.
     * @param photo Фото.
     */
    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    /**
     * Метод возвращает автомобиль.
     * @return Автомобиль.
     */
    public Car getCar() {
        return car;
    }

    /**
     * Метод задает автомобиль.
     * @param car Автомобиль.
     */
    public void setCar(Car car) {
        this.car = car;
    }

    /**
     * Метод возвращает пользователя.
     * @return Пользователь.
     */
    public User getUser() {
        return user;
    }

    /**
     * Метод задает пользователя.
     * @param user Пользователь.
     */
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Announcement that = (Announcement) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Announcement{"
                + "id=" + id
                + ", description='" + description + '\''
                + ", created=" + created
                + ", status=" + status
                + ", photo=" + photo
                + ", car=" + car
                + ", user=" + user
                + '}';
    }
}
