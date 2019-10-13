package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.business_controllers.SaleBusinessController;
import es.upm.miw.apaw_ep_themes.dtos.SaleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(SaleResource.SALES)
public class SaleResource {
    public static final String SALES = "/sales";
    private SaleBusinessController saleBusinessController;
    @Autowired
    public SaleResource (SaleBusinessController saleBusinessController){
        this.saleBusinessController = saleBusinessController;
    }

    @PostMapping

    public SaleDto create(@RequestBody SaleDto saleDto){
        saleDto.validate();
        return this.saleBusinessController.create(saleDto);
    }
}
