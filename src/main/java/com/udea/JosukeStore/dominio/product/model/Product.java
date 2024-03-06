package com.udea.JosukeStore.dominio.product.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, name = "product_code")
    private String producCode;

    @Column(unique = true, nullable = false, name = "product_name")
    private String productName;

    @Column(nullable = false, name = "product_description")
    private String productDescription;

    @Column(nullable = false)
    private Float price;

    @Column(nullable = false, name = "is_available")
    private Boolean isAvailable;

    @Column(nullable = false, name = "url_product_image")
    private String urlProductImage;

    private Product(ProductBuilder productBuilder) {
        this.producCode = productBuilder.code;
        this.productName = productBuilder.name;
        this.productDescription = productBuilder.description;
        this.price = productBuilder.price;
        this.isAvailable = productBuilder.isAvailable;
        this.urlProductImage = productBuilder.urlProductImage;
    }

    public static class ProductBuilder {
        String code;
        String name;
        String description;
        Float price;
        Boolean isAvailable;
        String urlProductImage;

        public ProductBuilder(String code, String name, String description, Float price, Boolean isAvailable){
            this.code = code;
            this.name = name;
            this.description = description;
            this.price = price;
            this.isAvailable = isAvailable;
        }

        public ProductBuilder setUrlProductImage(String base64Image){
            // Aquí es donde codificarías la imagen y la almacenarías en un servidor.
            // Luego, guardarías la URL de la imagen en el objeto.
            this.urlProductImage = "https://www.bing.com/images/create/un-gato-programador2c-que-parezca-real-no-una-caric/1-65e8b1de88e242f8a2bcdd4afaa8ca8e?id=QpuCq3bBBR3oOPLnPN7V6w%3d%3d&view=detailv2&idpp=genimg&thId=OIG1.0fLX69uNsKLML7OFKEUO&FORM=GCRIDP&mode=overlay";
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}
