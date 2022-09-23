package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {
    @OneToOne(mappedBy = "car")
    private User user;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;

    public Car() {}

    public Car(String model,int series) {
        this.model = model;
        this.series = series;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", series=" + series +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;

        Car car = (Car) o;

        if (id != car.id) return false;
        if (getSeries() != car.getSeries()) return false;
        if (!getUser().equals(car.getUser())) return false;
        return getModel().equals(car.getModel());
    }

    @Override
    public int hashCode() {
        int result = getUser().hashCode();
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + getModel().hashCode();
        result = 31 * result + getSeries();
        return result;
    }
}