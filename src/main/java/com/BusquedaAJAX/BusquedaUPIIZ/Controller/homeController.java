package com.BusquedaAJAX.BusquedaUPIIZ.Controller;

import com.BusquedaAJAX.BusquedaUPIIZ.Models.JobModel;

import com.BusquedaAJAX.BusquedaUPIIZ.Services.JobServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class homeController {
    @Autowired
    JobServices jobServices;

    @GetMapping("/")
    public String home() {
        return "index.html";

    }
    @GetMapping("/api/search/suggestions")
    @ResponseBody
    public List<JobModel> sugerencias(@RequestParam(required = false) String query) {

            return jobServices.findSuggestions(query);

    }
}
