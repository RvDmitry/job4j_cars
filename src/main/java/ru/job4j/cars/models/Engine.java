package ru.job4j.cars.models;

import javax.persistence.*;
import java.util.Objects;

/**
 * Class Engine
 * Класс характеризует двигатель автомобиля.
 * @author Dmitry Razumov
 * @version 1
 */
@Entity
@Table(name = "engines")
public class Engine {
    /**
     * Идентификатор двигателя.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Наименование двигателя.
     */
    private String name;
    /**
     * Мощность двигателя.
     */
    private int power;
    /**
     * Объем двигателя.
     */
    private double volume;

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
     * Метод возвращает наименование двигателя.
     * @return Наименование.
     */
    public String getName() {
        return name;
    }

    /**
     * Метод задает наименование двигателя.
     * @param name Наименование.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Метод возвращает мощность двигателя.
     * @return Мощность.
     */
    public int getPower() {
        return power;
    }

    /**
     * Метод задает мощность двигателя.
     * @param power Мощность.
     */
    public void setPower(int power) {
        this.power = power;
    }

    /**
     * Метод возвращает объем двигателя.
     * @return Объем.
     */
    public double getVolume() {
        return volume;
    }

    /**
     * Метод задает объем двигателя.
     * @param volume Объем.
     */
    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Engine engine = (Engine) o;
        return id == engine.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Engine{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", power=" + power
                + ", volume=" + volume
                + '}';
    }
}
