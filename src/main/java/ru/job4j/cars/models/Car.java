package ru.job4j.cars.models;

import javax.persistence.*;
import java.util.Objects;

/**
 * Class Car
 * Класс характеризует автомобиль.
 * @author Dmitry Razumov
 * @version 1
 */
@Entity
@Table(name = "cars")
public class Car {
    /**
     * Идентификатор автомобиля.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Год выпуска.
     */
    private int year;
    /**
     * Модель автомобиля.
     */
    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;
    /**
     * Тип кузова.
     */
    @ManyToOne
    @JoinColumn(name = "body_id")
    private Body body;
    /**
     * Тип двигателя.
     */
    @ManyToOne
    @JoinColumn(name = "engine_id")
    private Engine engine;
    /**
     * Объявление.
     */
    @OneToOne (mappedBy = "car")
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
     * Метод возвращает год выпуска.
     * @return Год выпуска.
     */
    public int getYear() {
        return year;
    }

    /**
     * Метод задает год выпуска.
     * @param year Год выпуска.
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Метод возвращает модель.
     * @return Модель.
     */
    public Model getModel() {
        return model;
    }

    /**
     * Метод задает модель.
     * @param model Модель.
     */
    public void setModel(Model model) {
        this.model = model;
    }

    /**
     * Метод возвращает тип кузова.
     * @return Кузов.
     */
    public Body getBody() {
        return body;
    }

    /**
     * Метод задает тип кузова.
     * @param body Кузов.
     */
    public void setBody(Body body) {
        this.body = body;
    }

    /**
     * Метод возвращает тип двигателя.
     * @return Двигатель.
     */
    public Engine getEngine() {
        return engine;
    }

    /**
     * Метод задает тип двигателя.
     * @param engine Двигатель.
     */
    public void setEngine(Engine engine) {
        this.engine = engine;
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
        Car car = (Car) o;
        return id == car.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Car{"
                + "id=" + id
                + ", year=" + year
                + ", model=" + model
                + ", body=" + body
                + ", engine=" + engine
                + '}';
    }
}
