package com.loja_virtual.produtos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 		// Devido ao Lombok usando @Data não é necessario fazer get e set e hashcode
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Faz com que a BD tenha responsabilidade de fazer o incremento do ID
    private Long id;
    private String name;
    private String code;
    
}