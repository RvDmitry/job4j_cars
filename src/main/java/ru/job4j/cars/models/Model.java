package ru.job4j.cars.models;

import javax.persistence.*;
import java.util.Objects;

/**
 * Class Model
 * Класс характеризует модель автомобиля.
 * @author Dmitry Razumov
 * @version 1
 */
@Entity
@Table(name = "models")
public class Model {
    /**
     * Идентификатор модели.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Наименование модели.
     */
    private String name;
    /**
     * Марка автомобиля.
     */
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

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
     * Метод возвращает модель.
     * @return Модель.
     */
    public String getName() {
        return name;
    }

    /**
     * Метод задает модель.
     * @param name Модель.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Метод возвращает марку.
     * @return Марка.
     */
    public Brand getBrand() {
        return brand;
    }

    /**
     * Метод задает марку.
     * @param brand Марку.
     */
    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Model model = (Model) o;
        return id == model.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Model{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", brand=" + brand
                + '}';
    }
}
