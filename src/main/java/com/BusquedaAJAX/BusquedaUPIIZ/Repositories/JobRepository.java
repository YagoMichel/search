package com.BusquedaAJAX.BusquedaUPIIZ.Repositories;

import com.BusquedaAJAX.BusquedaUPIIZ.Models.JobModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository {
    List<JobModel> findSuggestions(String query);
}
