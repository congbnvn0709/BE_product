package be.manageproducts.serviceImpls;

import be.manageproducts.ResponseData;
import be.manageproducts.dto.product.response.ProductSearchResponse;
import be.manageproducts.dto.product.request.SearchProductDTO;
import be.manageproducts.dto.product.request.ProductDTO;
import be.manageproducts.enums.Constants;
import be.manageproducts.enums.ErrorCode;
import be.manageproducts.models.Product;
import be.manageproducts.repositorys.ProductRepository;
import be.manageproducts.services.ProductService;
import be.manageproducts.spectifications.ProductSpetification;
import com.google.cloud.storage.*;
import com.google.firebase.cloud.StorageClient;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ModelMapper modelMapper;

    private final ProductSpetification productSpetification;

    private static final String endPoint = "https://firebasestorage.googleapis.com/v0/b/";

    @Override
    public ResponseData getListProduct(SearchProductDTO productDTO) {
        ProductSearchResponse productResponse = new ProductSearchResponse();
        ResponseData responseData = ResponseData.OK();
        try {
            List<Product> products = productSpetification.searchProduct(productDTO.getName(), productDTO.getProductType()).stream().skip((long) productDTO.getPageIndex() * productDTO.getPageSize()).limit(((long) productDTO.getPageSize())).toList();
            productResponse.setProductDTOList(products.stream().map(item -> modelMapper.map(item, ProductDTO.class)).collect(Collectors.toList()));
            productResponse.setTotalElements(products.size());
            productResponse.setTotalPages((int) Math.ceil((double) products.size() / productDTO.getPageSize()));

        } catch (Exception e) {
            e.printStackTrace();
            responseData = ResponseData.builder().message(ErrorCode.UNKNOWN.getMessage()).errorCode(ErrorCode.UNKNOWN.getErrorCode()).data(null).build();
            return responseData;
        }
        responseData.setData(productResponse);
        return responseData;
    }

    @Override
    @Transactional
    public ResponseData createProduct(ProductDTO productDTO) {
        Product productEntity = null;
        ResponseData responseData = ResponseData.OK();
        try {
            String imageUrl = uploadFile(productDTO.getImageFile());
            productEntity = Product.builder()
                    .name(productDTO.getName())
                    .productType(productDTO.getProductType())
                    .imageUrl(imageUrl)
                    .status(Constants.ACTIVE)
                    .price(productDTO.getPrice())
                    .createdAt(new Timestamp(new Date().getTime()))
                    .build();
            productRepository.save(productEntity);
        } catch (Exception e) {
            responseData = ResponseData.builder().message(ErrorCode.UNKNOWN.getMessage()).errorCode(ErrorCode.UNKNOWN.getErrorCode()).data(null).build();
            e.printStackTrace();
            return responseData;
        }
        responseData.setData(modelMapper.map(productEntity, ProductDTO.class));
        return responseData;
    }

    @Override
    @Transactional
    public ResponseData updateProduct(ProductDTO productDTO) {
        ResponseData responseData = ResponseData.OK();
        Optional<Product> product;
        Product productEntity = null;
        try {
            product = productRepository.findProductById(productDTO.getId());
            if (product.isEmpty()) {
                return null;
            }

            String imageUrl = uploadFile(productDTO.getImageFile());
            productEntity = Product.builder()
                    .id(productDTO.getId())
                    .name(productDTO.getName())
                    .productType(productDTO.getProductType())
                    .imageUrl(imageUrl)
                    .status(Constants.ACTIVE)
                    .price(productDTO.getPrice())
                    .updatedAt(new Timestamp(new Date().getTime()))
                    .build();
            productRepository.save(productEntity);
        } catch (Exception e) {
            responseData = ResponseData.builder().message(ErrorCode.UNKNOWN.getMessage()).errorCode(ErrorCode.UNKNOWN.getErrorCode()).data(null).build();
            e.printStackTrace();
            return responseData;
        }
        responseData.setData(modelMapper.map(productEntity, ProductDTO.class));
        return responseData;
    }

    @Override
    @Transactional
    public ResponseData deleteProduct(Integer id) {
        ResponseData responseData = ResponseData.OK();
        Optional<Product> product = null;
        try {
            product = productRepository.findProductById(id);
            if (product == null) {
                responseData = ResponseData.builder().message(ErrorCode.NOT_FOUND.getMessage()).errorCode(ErrorCode.NOT_FOUND.getErrorCode()).data(null).build();
                return responseData;
            }
            productRepository.deleteProduct(id);
        } catch (Exception e) {
            responseData = ResponseData.builder().message(ErrorCode.UNKNOWN.getMessage()).errorCode(ErrorCode.UNKNOWN.getErrorCode()).data(null).build();
            e.printStackTrace();
            return responseData;
        }
        responseData.setData(true);
        return responseData;
    }

    @Override
    public ResponseData getDetailProduct(Integer id) {
        ResponseData responseData = ResponseData.OK();

        Optional<Product> product = null;
        try {
            product = productRepository.findProductById(id);
            if (product.isEmpty()) {
                responseData = ResponseData.builder().message(ErrorCode.NOT_FOUND.getMessage()).errorCode(ErrorCode.NOT_FOUND.getErrorCode()).data(null).build();
                return responseData;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String uploadFile(MultipartFile multipartFile) {
        String fileName = multipartFile.getOriginalFilename();
        String fileUrl = null;
        try {

            Blob fileUploaded = StorageClient.getInstance().bucket().create(fileName, multipartFile.getInputStream(), multipartFile.getContentType());
            fileUrl = endPoint + fileUploaded.getBucket() + "/o/" + fileName + "?alt=media";

            return fileUrl;
        } catch (Exception e) {
            e.printStackTrace();
            return "Upload false";
        }
    }
}
