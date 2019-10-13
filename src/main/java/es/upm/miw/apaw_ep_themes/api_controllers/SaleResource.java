package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.business_controllers.SaleBusinessController;
import es.upm.miw.apaw_ep_themes.dtos.SaleBasicDto;
import es.upm.miw.apaw_ep_themes.dtos.SaleDto;
import es.upm.miw.apaw_ep_themes.dtos.SalePatchDto;
import es.upm.miw.apaw_ep_themes.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(SaleResource.SALES)
public class SaleResource {
    public static final String SALES = "/sales";
    static final String ID_ID = "/{id}";
    public static final String SEARCH = "/search";
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
    @GetMapping(value = SEARCH)
    public List<SaleBasicDto> find (@RequestParam String q){
        if (!"numelements".equals(q.split(":")[0])) {
            throw new BadRequestException("query param q is incorrect, missing 'numelements:'");
        }
        return this.saleBusinessController.findbyQuantityofElements(Integer.parseInt(q.split(":")[1]));
    }
}
