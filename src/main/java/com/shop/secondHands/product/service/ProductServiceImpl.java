package com.shop.secondHands.product.service;

import com.shop.secondHands.admin.dto.AdminProductDto;
import com.shop.secondHands.product.dto.ProductDto;
import com.shop.secondHands.product.entity.Product;
import com.shop.secondHands.product.exception.ProductNotFoundException;
import com.shop.secondHands.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<ProductDto> products() {
        return ProductDto.of(productRepository.findAll());
    }

    @Override
    public ProductDto product(Integer id) {
        return ProductDto.of(productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("해당 게시물을 찾을 수 없습니다.")));
    }

    public void save(AdminProductDto adminProductDto, Boolean productHide, MultipartFile productImage) throws IOException {
        String image = saveFile(productImage);
        productRepository.save(Product.toEntity(adminProductDto, image, productHide));
    }

    private String saveFile(MultipartFile imageFile) throws IOException {
        String _imageName = imageFile.getOriginalFilename();
        String path = System.getProperty("user.dir") + "/src/main/resources/static/files/";

        UUID uuid = UUID.randomUUID();
        String imageName = uuid + "_" + _imageName;

        File file = new File(path, imageName);
        imageFile.transferTo(file);

        return imageName;
    }

    public Product findByProductId(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("상품을 찾을 수 없습니다."));
    }
}
