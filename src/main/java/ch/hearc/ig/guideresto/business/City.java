package ch.hearc.ig.guideresto.business;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="City")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator ="SEQ_CITY")
    @SequenceGenerator(name="SEQ_CITY",
                        sequenceName ="seq_VILLES",
                        initialValue =1,
                        allocationSize = 1)
    @Column(name="numero")
    private Integer id;

    @Column(name="codePostale",nullable = false)
    private String zipCode;

    @Column(name="nom_ville", nullable = false, length = 30)
    private String cityName;

    private Set<Restaurant> restaurants;

    public City() {
        this(null, null);
    }

    public City(String zipCode, String cityName) {
        this(null, zipCode, cityName);
    }
    
    public City(Integer id, String zipCode, String cityName) {
        this.id = id;
        this.zipCode = zipCode;
        this.cityName = cityName;
        this.restaurants = new HashSet();
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String city) {
        this.cityName = city;
    }

    public Set<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(Set<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }
}