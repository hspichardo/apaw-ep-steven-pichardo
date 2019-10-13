package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.business_controllers.SaleBusinessController;
import es.upm.miw.apaw_ep_themes.dtos.SaleBasicDto;
import es.upm.miw.apaw_ep_themes.dtos.SaleDto;
import es.upm.miw.apaw_ep_themes.dtos.SalePatchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(SaleResource.SALES)
public class SaleResource {
    public static final String SALES = "/sales";
    static final String ID_ID = "/{id}";
    private SaleBusinessController saleBusinessController;
    @Autowired
    public SaleResource (SaleBusinessController saleBusinessController){
        this.saleBusinessController = saleBusinessController;
    }

    @PostMapping

    public SaleBasicDto create(@RequestBody SaleDto saleDto){
        saleDto.validate();
        return this.saleBusinessController.create(saleDto);
    }

    @PatchMapping(value = ID_ID)

    public void patch(@PathVariable String id, @RequestBody SalePatchDto salePatchDto){
        salePatchDto.validate();
        this.saleBusinessController.patch(id,salePatchDto);
    }
}
