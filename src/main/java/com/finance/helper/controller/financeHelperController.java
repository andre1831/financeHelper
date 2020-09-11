package com.finance.helper.controller;

import com.finance.helper.Exceptions.FinanceHelperBussinessException;
import com.finance.helper.dto.AddAlarmRequest;
import com.finance.helper.dto.AddProductRequest;
import com.finance.helper.dto.DeleteAlarmRequest;
import com.finance.helper.dto.GetAlarmRequest;
import com.finance.helper.dto.UserProductResponse;
import com.finance.helper.entity.Alarm;
import com.finance.helper.entity.Attribute;
import com.finance.helper.entity.City;
import com.finance.helper.entity.Country;
import com.finance.helper.dto.CountryRequest;
import com.finance.helper.dto.ManageProductRequest;
import com.finance.helper.dto.GetFollowedProductsRequest;
import com.finance.helper.dto.GlobalQuote;
import com.finance.helper.entity.Investor;
import com.finance.helper.dto.NewInvestorRequest;
import com.finance.helper.entity.Product;
import com.finance.helper.dto.ProductInfoRequest;
import com.finance.helper.service.AlarmService;
import com.finance.helper.service.AlphaVantageService;
import com.finance.helper.service.AttributeService;
import com.finance.helper.service.GeoService;
import com.finance.helper.service.InvestorService;
import com.finance.helper.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;


@RestController
public class financeHelperController {
    @Autowired
    AlphaVantageService alphaVantageService;
    @Autowired
    InvestorService investorService;
    @Autowired
    GeoService geoService;
    @Autowired
    ProductService productService;
    @Autowired
    AttributeService attributeService;
    @Autowired
    AlarmService alarmService;

    @RequestMapping(value = "/product-info", method = RequestMethod.POST)
    public @ResponseBody
    GlobalQuote
    getProductInfo(@RequestBody @Valid ProductInfoRequest symbol) throws Exception {
        return alphaVantageService.getProductInfo(symbol.getSymbol()).getGlobalQuote();
    }

    @PostMapping(value = "/new-investor",produces = { "application/json" }, consumes = { "application/json" })
    public ResponseEntity<Investor> createInvestor(@RequestBody @Valid NewInvestorRequest newInvestorRequest) {
        try {
            return new ResponseEntity<>(investorService.createInvestor(newInvestorRequest), HttpStatus.OK);
        } catch (FinanceHelperBussinessException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_ACCEPTABLE, "No fue posible crear el Usuario, verifique la información introducida", e);

        }
    }

    @RequestMapping(value = "/countries-list", method = RequestMethod.GET)
    public @ResponseBody
    List<Country>
    getCountries() throws Exception {
        return geoService.getCountries();
    }

    @RequestMapping(value = "/cities-list", method = RequestMethod.POST)
    public @ResponseBody
    List<City>
    getCountries(@RequestBody @Valid CountryRequest countryId) throws Exception {
        return geoService.getCityByCountryid(countryId.getId());
    }

    @RequestMapping(value = "/products-list", method = RequestMethod.GET)
    public @ResponseBody
    List<Product>
    getProducts() throws Exception {
        return productService.getProducts();
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public @ResponseBody
    List<Product>
    getFollowedProducts() throws Exception {
        return productService.getProducts();
    }

    @RequestMapping(value = "/add-product", method = RequestMethod.POST)
    public @ResponseBody
    List<UserProductResponse>
    addFollowedProduct(@RequestBody AddProductRequest request) throws Exception {
        return productService.addUserProduct(request);
    }

    @RequestMapping(value = "/followed-products", method = RequestMethod.POST)
    public @ResponseBody
    List<UserProductResponse>
    getFollowedProducts(@RequestBody GetFollowedProductsRequest request) throws Exception {
        return productService.getFollowedProducts(request);
    }

    @RequestMapping(value = "/delete-product", method = RequestMethod.POST)
    public @ResponseBody
    List<UserProductResponse>
    deleteFollowedProduct(@RequestBody ManageProductRequest request) throws Exception {
        return productService.deleteUserProduct(request);
    }

    @RequestMapping(value = "/get-product", method = RequestMethod.POST)
    public @ResponseBody
    UserProductResponse
    getFollowedProduct(@RequestBody ManageProductRequest request) throws Exception {
        return productService.getUserProduct(request);
    }

    @RequestMapping(value = "/get-attributes", method = RequestMethod.GET)
    public @ResponseBody
    List<Attribute>
    getAttributes()  {
        return attributeService.getAttributes();
    }

    @RequestMapping(value = "/add-alarm", method = RequestMethod.POST)
    public @ResponseBody
    List<Alarm>
    createAlarm(@RequestBody AddAlarmRequest request)  {
        return alarmService.createAlarm(request);
    }

    @RequestMapping(value = "/get-alarms", method = RequestMethod.POST)
    public @ResponseBody
    List<Alarm>
    getAlarmS(@RequestBody GetAlarmRequest request)  {
        return alarmService.getAlarms(request);
    }

    @RequestMapping(value = "/delete-alarm", method = RequestMethod.POST)
    public @ResponseBody
    List<Alarm>
    deleteAlarm(@RequestBody DeleteAlarmRequest request)  {
        return alarmService.deleteAlarm(request);
    }

}
