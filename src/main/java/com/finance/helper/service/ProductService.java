package com.finance.helper.service;

import com.finance.helper.dto.AddProductRequest;
import com.finance.helper.dto.ManageProductRequest;
import com.finance.helper.dto.GetFollowedProductsRequest;
import com.finance.helper.dto.UserProductResponse;
import com.finance.helper.entity.Product;
import com.finance.helper.dto.ProductInfo;
import com.finance.helper.entity.UserProduct;
import com.finance.helper.mapper.AddProductRequestMapper;
import com.finance.helper.repository.ProductRepository;
import com.finance.helper.repository.UserProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    InvestorService investorService;
    @Autowired
    UserProductRepository userProductRepository;
    @Autowired
    AddProductRequestMapper addProductRequestMapper;
    @Autowired
    AlphaVantageService alphaVantageService;

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public List<UserProductResponse> addUserProduct(AddProductRequest req) throws Exception {

        UserProduct userProduct = userProductRepository.saveAndFlush(addProductRequestMapper.map(req));

        return getUserFollowedProducts(req.getUsername());
    }
    public List<UserProductResponse> getFollowedProducts(GetFollowedProductsRequest req) throws Exception {

        return getUserFollowedProducts(req.getUsername());
    }

    public List<UserProductResponse> deleteUserProduct(ManageProductRequest req) throws Exception {

        userProductRepository.delete(req.getUserProductResponse().getUserProduct());
        userProductRepository.flush();
        return  getUserFollowedProducts(req.getUserProductResponse().getUserProduct().getInvestor().getEmail());
    }

    private List<UserProductResponse> getUserFollowedProducts(String username) throws Exception{
        List<UserProductResponse> response = new ArrayList<UserProductResponse>();
        List<UserProduct> productsList = userProductRepository.findByInvestor(investorService.getInvestorByemail(username));
        for(UserProduct up:productsList){
            UserProductResponse upr = new UserProductResponse();
            ProductInfo productInfo = alphaVantageService.getProductInfo(up.getProduct().getSymbol());
            if(productInfo != null && productInfo.getGlobalQuote()!=null){

                upr.setGlobalQuote(productInfo.getGlobalQuote());
                upr.setUserProduct(up);
                response.add(upr);
            }else {
                continue;
            }


        }
        return response;
    }

    public UserProductResponse getUserProduct(ManageProductRequest req) throws Exception {
        UserProduct userProduct = userProductRepository.getOne(req.getUserProductResponse().getUserProduct().getId());
        UserProductResponse userProductResponse = new UserProductResponse();
        userProductResponse.setUserProduct(userProduct);
        ProductInfo productInfo = alphaVantageService.getProductInfo(userProduct.getProduct().getSymbol());
        userProductResponse.setGlobalQuote(productInfo.getGlobalQuote());

        return userProductResponse;
    }
}
