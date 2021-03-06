package ru.job4j.cars.models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * Class Brand
 * Класс характеризует марку автомобиля.
 * @author Dmitry Razumov
 * @version 1
 */
@Entity
@Table(name = "brands")
public class Brand {
    /**
     * Идентификатор марки.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Наименование марки.
     */
    private String name;
    /**
     * Список моделей принадлежащих марке.
     */
    @OneToMany(mappedBy = "brand")
    private List<Model> models;

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
     * Метод возвращает марку.
     * @return Марка.
     */
    public String getName() {
        return name;
    }

    /**
     * Метод задает марку.
     * @param name Марка.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Метод возвращает список моделей.
     * @return Список моделей.
     */
    public List<Model> getModels() {
        return models;
    }

    /**
     * Метод задает список моделей.
     * @param models Список моделей.
     */
    public void setModels(List<Model> models) {
        this.models = models;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Brand brand = (Brand) o;
        return id == brand.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Brand{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
