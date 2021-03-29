package ru.job4j.cars.models;

import javax.persistence.*;
import java.util.Objects;

/**
 * Class Body
 * Класс характеризует тип кузова.
 * @author Dmitry Razumov
 * @version 1
 */
@Entity
@Table(name = "body")
public class Body {
    /**
     * Идентификатор кузова.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Наименование кузова.
     */
    private String name;

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
     * Метод возвращает тип.
     * @return Тип.
     */
    public String getName() {
        return name;
    }

    /**
     * Метод задает тип.
     * @param name Тип.
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Body body = (Body) o;
        return id == body.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Body{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
