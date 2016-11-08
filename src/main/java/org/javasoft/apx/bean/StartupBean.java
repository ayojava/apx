/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javasoft.apx.bean;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.javasoft.apx.model.Country;
import static org.javasoft.apx.rest.intf.RestURL.COUNTRIES_URL;
import org.omnifaces.cdi.Eager;

/**
 *
 * @author ayojava
 */
@Slf4j
@Eager
@Named("startUpBean")
@ApplicationScoped
public class StartupBean {

    private Client client;

    @Getter
    private List<Country> allCountries;

    @Inject
    private ServletContext context;

    @PostConstruct
    public void init() {
        log.info("Real Path ::: {} ", context.getRealPath("/"));
        loadCountries();
    }

    private void loadCountries() {
        try {
            client = ClientBuilder.newClient();
            allCountries = client.target(COUNTRIES_URL).path("all").
                    request(MediaType.APPLICATION_JSON).get(new GenericType<List<Country>>() {
            });
        } catch (Exception ex) {
            allCountries = new ArrayList<>();
            client.close();
            log.error("Exception ::: ", ex);
        }
    }
}
