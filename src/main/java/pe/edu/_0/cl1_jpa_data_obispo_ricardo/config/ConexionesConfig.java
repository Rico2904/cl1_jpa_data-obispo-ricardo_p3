package pe.edu._0.cl1_jpa_data_obispo_ricardo.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConexionesConfig {

    @Bean
    public HikariDataSource hikariDataSource() {
        HikariConfig config = new HikariConfig();

        // Variables de entorno o valores por defecto
        String dbUrl = System.getenv("DB_WORLD_URL") != null ? System.getenv("DB_WORLD_URL") : "jdbc:mysql://localhost:3306/world";
        String dbUser = System.getenv("DB_WORLD_USER") != null ? System.getenv("DB_WORLD_USER") : "root";
        String dbPass = System.getenv("DB_WORLD_PASS") != null ? System.getenv("DB_WORLD_PASS") : "123456";

        // Configuración de Hikari
        config.setJdbcUrl(dbUrl);
        config.setUsername(dbUser);
        config.setPassword(dbPass);
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");

        // Configuración
        config.setMaximumPoolSize(30);
        config.setMinimumIdle(4);
        config.setIdleTimeout(240000);
        config.setConnectionTimeout(45000);

        return new HikariDataSource(config);
    }

}
