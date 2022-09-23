package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

   @OneToOne
   @MapsId
   @JoinColumn(name = "car_id",
           referencedColumnName = "id")
   private Car car;

   @Id
   @Column(name = "id")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "email")
   private String email;

   public User() {}
   
   public User(String firstName, String lastName, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public Car getCar() {
      return car;
   }
   public void setCar(Car car) {
      this.car = car;
   }

   @Override
   public String toString() {
      return "User{" +
              "id=" + id +
              ", firstName='" + firstName + '\'' +
              ", lastName='" + lastName + '\'' +
              ", email='" + email + '\'' +
              '}';
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof User)) return false;

      User user = (User) o;

      if (!getCar().equals(user.getCar())) return false;
      if (!getId().equals(user.getId())) return false;
      if (!getFirstName().equals(user.getFirstName())) return false;
      if (!getLastName().equals(user.getLastName())) return false;
      return getEmail().equals(user.getEmail());
   }

   @Override
   public int hashCode() {
      int result = getCar().hashCode();
      result = 31 * result + getId().hashCode();
      result = 31 * result + getFirstName().hashCode();
      result = 31 * result + getLastName().hashCode();
      result = 31 * result + getEmail().hashCode();
      return result;
   }
}
