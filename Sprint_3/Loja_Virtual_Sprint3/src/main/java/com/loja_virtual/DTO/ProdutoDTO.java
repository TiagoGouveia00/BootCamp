package com.loja_virtual.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProdutoDTO {
	
	@NotNull(message = "Não pode ser null")
	private String name;

	@NotBlank // Este metodo de validação faz com que o campo de texto não seja aceite se estiver vazia
	private String code;
}
