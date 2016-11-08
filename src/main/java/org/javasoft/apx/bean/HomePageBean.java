/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javasoft.apx.bean;

import java.io.Serializable;
import java.util.List;
import static java.util.stream.Collectors.toList;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.javasoft.apx.model.Country;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author ayojava
 */
@Slf4j
@Named("homePageBean")
@ViewScoped
public class HomePageBean implements Serializable{
    
    @Inject
    private StartupBean startUpBean;
    
    @Getter
    private List<Country> allCountries;
    
    @Getter @Setter
    private Country selectedCountry;
    
    @PostConstruct
    public void init() {
        loadTable();
    }
    
    private void loadTable(){
        if(startUpBean.getAllCountries().isEmpty()){
            allCountries =startUpBean.getAllCountries();
        }else{
            allCountries = startUpBean.getAllCountries().stream().limit(80).collect(toList());
        }
    }
    
    public void onRowSelect(SelectEvent event) {
       log.info("=== Country ==== {} " , ((Country)event.getObject()).getName());
        //log.info("=== Country ==== {} " , selectedCountry.getName());
    }
    
    public void onRowUnSelect(SelectEvent event) {
       log.info("=== Country ==== {} " , ((Country)event.getObject()).getName());
        //log.info("=== Country ==== {} " , selectedCountry.getName());
    }
}