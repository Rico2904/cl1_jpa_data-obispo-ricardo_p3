package pe.edu._0.cl1_jpa_data_obispo_ricardo.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name="country")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    @Id
    private String code;
    private String name;
    private String continent;
    private String region;
    private double surfacearea;
    private Integer indepyear;
    private int population;
    private double lifeexpectancy;
    private Double gnp;
    private double gnpold;
    private String  localname;
    private String governmentform;
    private String headofstate;
    private int capital;
    private String code2;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<CountryLanguage> languages;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<City> cities;


}