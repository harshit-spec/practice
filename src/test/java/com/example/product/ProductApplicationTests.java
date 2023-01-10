package com.example.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.example.product.entity.Products;
import com.example.product.repository.ProductRepository;
import com.example.product.service.ProductService;

@SpringBootTest
class ProductApplicationTests {

	@Test
	void contextLoads() {
	}
	@MockBean
	private ProductRepository productRepository;
		@Autowired
	private ProductService productService;
		
	@Test
		public void getAllTest() {
			when(productRepository.findAll()).thenReturn(Stream.of(new Products("1","screw","tools",500,500),
					new Products("2","driver","tools",5,500)).collect(Collectors.toList()));
			assertEquals(2, productService.getAllProducts().size());
		}
	
	@Test
	public void saveTest() {
		Products product = new Products("1","screw","tools",50,500);
		when(productRepository.save(product)).thenReturn(product);
		assertEquals(product,productService.addProduct(product));
	}
	
	@Test
	public void deleteTest() {
		Products product = new Products("1","screw","tools",50,500);
		productService.deleteProducts("1");
		verify(productRepository,times(1)).deleteById("1");
	}
	
	@Test
	public void updateTest()  {
		Products product = new Products("2","wrench","tools",10,1000);
		String id = product.getId();
		product.setCost(100);
		productRepository.save(product);
		when(productRepository.findById(id)).thenReturn(Optional.of(product));
		assertEquals(product,productService.updateProducts(product, id));
	}
	@Test
	public void getTest() {
		Products product = new Products("2","soap","skin care",200,20000);

		when(productRepository.findById(anyString())).thenReturn(Optional.of(product));
		assertEquals(product,productService.getProducts("id"));
	}

}
