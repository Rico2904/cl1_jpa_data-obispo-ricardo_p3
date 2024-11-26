package pe.edu._0.cl1_jpa_data_obispo_ricardo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="countrylanguage")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class CountryLanguage {

    @EmbeddedId
    private CountryLanguageId countryLanguageId;
    private String isofficial;
    private double percentage;


    @ManyToOne
    @JoinColumn(name ="CountryCode")
    @MapsId("countrycode")
    private Country country;





}