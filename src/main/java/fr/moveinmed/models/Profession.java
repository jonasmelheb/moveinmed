package fr.moveinmed.models;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "profession")
public class Profession implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profession")
    private Long id;


    private String name;


    private String active;

    @OneToMany(mappedBy = "profession")
    private List<Professional> professionals;

    public Profession() {
    }

    public Profession(String name, List<Professional> professionals) {
        this.name = name;
        this.professionals = professionals;
    }

    public Profession(Long id, String name, List<Professional> professionals) {
        this.id = id;
        this.name = name;
        this.professionals = professionals;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public List<Professional> getProfessionals() {
        return professionals;
    }

    public void setProfessionals(List<Professional> professionals) {
        this.professionals = professionals;
    }

    @Override
    public String toString() {
        return "Profession{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", active='" + active + '\'' +
                ", professionals=" + professionals +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profession that = (Profession) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(active, that.active) && Objects.equals(professionals, that.professionals);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, active, professionals);
    }
}
