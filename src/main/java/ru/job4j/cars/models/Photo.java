package ru.job4j.cars.models;

import javax.persistence.*;
import java.util.Objects;

/**
 * Class Photo
 * Класс характеризует фото.
 * @author Dmitry Razumov
 * @version 1
 */
@Entity
@Table(name = "photos")
public class Photo {
    /**
     * Идентификатор фото.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Объявление.
     */
    @OneToOne (mappedBy = "photo")
    private Announcement adt;

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
     * Метод возвращает объявление.
     * @return Объявление.
     */
    public Announcement getAdt() {
        return adt;
    }

    /**
     * Метод задает объявление.
     * @param adt Объявление.
     */
    public void setAdt(Announcement adt) {
        this.adt = adt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Photo photo = (Photo) o;
        return id == photo.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Photo{" + "id=" + id + '}';
    }
}
