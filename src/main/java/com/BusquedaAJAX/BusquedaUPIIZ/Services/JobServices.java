package com.BusquedaAJAX.BusquedaUPIIZ.Services;


import com.BusquedaAJAX.BusquedaUPIIZ.Models.JobModel;
import com.BusquedaAJAX.BusquedaUPIIZ.Repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServices implements JobRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<JobModel> findSuggestions(String query) {
        String sql = "SELECT id, nombre FROM jobs WHERE nombre IS NOT NULL AND LOWER(nombre) LIKE ? LIMIT 10";

        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(JobModel.class),
                "%" + query.toLowerCase() + "%"
        );

    }
}
