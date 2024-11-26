package pe.edu._0.cl1_jpa_data_obispo_ricardo.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor


public class CountryLanguageId {

    private String countrycode;
    private String language;
}