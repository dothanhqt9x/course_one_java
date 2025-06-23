package com.btspring.btspring2.controller;


import com.btspring.btspring2.anotation.CheckLogin;
import com.btspring.btspring2.anotation.CheckRole;
import com.btspring.btspring2.convert.ProductMapper;
import com.btspring.btspring2.model.dto.response.BoughtProductResponseDTO;
import com.btspring.btspring2.model.dto.response.JwtResponseDTO;
import com.btspring.btspring2.model.entity.ProductEntity;
import com.btspring.btspring2.model.entity.UserEntity;
import com.btspring.btspring2.model.entity.UserProductEntity;
import com.btspring.btspring2.service.ProductService;
import com.btspring.btspring2.service.UserProductService;
import com.btspring.btspring2.service.UserService;
import com.btspring.btspring2.util.JWTUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/client")
public class ClientController {

    private JWTUtil jwtUtil;
    private UserService userService;
    private ProductService productService;
    private ProductMapper productMapper;
    private UserProductService userProductService;

    public ClientController(JWTUtil jwtUtil, UserService userService, ProductService productService,
                            ProductMapper productMapper, UserProductService userProductService) {
        this.jwtUtil = jwtUtil;
        this.userService = userService;
        this.productService = productService;
        this.productMapper = productMapper;
        this.userProductService = userProductService;
    }


    @CheckLogin
    @CheckRole("client")
    @GetMapping("/error-role")
    public String errorRole() {
        return "notAdminRole";
    }

    @CheckLogin
    @CheckRole("client")
    @GetMapping("/{id}/buy")
    public String buy(Model model, HttpServletRequest request, @PathVariable int id) {

        String token = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("token".equals(cookie.getName())) {
                    token = cookie.getValue();
                    break;
                }
            }
        }
        if (token != null) {
            JwtResponseDTO jwtResponseDTO = jwtUtil.verifyToken(token);
            if (jwtResponseDTO != null) {
                model.addAttribute("clientInfo", userService.getUserById(jwtResponseDTO.getUserId()));
                model.addAttribute("listProduct", productService.getAllProducts());

                List<UserProductEntity> userProductEntityList = userProductService.findByUserId(jwtResponseDTO.getUserId());

                List<BoughtProductResponseDTO> boughtProductResponseDTOList = new ArrayList<>();
                for (UserProductEntity userProductEntity : userProductEntityList) {
                    ProductEntity productEntity = productService.getProductById(userProductEntity.getProductId());
                    if(productEntity != null) {
                        boughtProductResponseDTOList.add(
                                new BoughtProductResponseDTO(productEntity, userProductEntity.getQuantityBuy())
                        );
                    }
                }
                model.addAttribute("boughtList", boughtProductResponseDTOList);



            }

        }
        return "client/client-buy";
    }

    @CheckLogin
    @CheckRole("client")
    @GetMapping("/buy-success")
    public String buySuccess() {
        return "client/client-buy-success";
    }

    @CheckLogin
    @CheckRole("client")
    @PostMapping("/buy")
    public String buy(Model model, @RequestParam String name, @RequestParam int quantity, HttpServletRequest request) {

        String token = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("token".equals(cookie.getName())) {
                    token = cookie.getValue();
                    break;
                }
            }
        }

        if (token != null) {
            JwtResponseDTO jwtResponseDTO = jwtUtil.verifyToken(token);
            if (jwtResponseDTO != null) {
                int userId = jwtResponseDTO.getUserId();
                UserEntity user = userService.getUserById(userId);
                List<ProductEntity> productList = productService.getProductByName(name);

                if (productList != null && !productList.isEmpty()) {
                    ProductEntity productEntity = productList.get(0);

                    if (productEntity.getQuantity() >= quantity) {
                        productEntity.setQuantity(productEntity.getQuantity() - quantity);
                        productService.addProduct(productMapper.toProductRequestDTO(productEntity));

                        UserProductEntity existing = userProductService.findByUserIdAndProductId(userId, productEntity.getId());
                        if (existing != null) {
                            existing.setQuantityBuy(existing.getQuantityBuy() + quantity);
                        } else {
                            existing = new UserProductEntity(0, userId, productEntity.getId(), quantity);
                        }
                        userProductService.save(existing);

                        model.addAttribute("clientInfo", user);
                        model.addAttribute("product", productEntity);
                        return "client/client-buy-success";
                    } else {
                        model.addAttribute("error", "Số lượng không đủ.");
                    }
                } else {
                    model.addAttribute("error", "Không tìm thấy sản phẩm.");
                }
            }
        }

        return "client/client-buy-error";
    }




}
