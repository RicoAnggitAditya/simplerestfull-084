/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplerestfull.simpleresfull;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author acer
 */
@RestController
public class ProductServiceController {
    private static Map<String, Product> productRepo = new HashMap<>();
   
    static {
      Product honey = new Product();
      honey.setId("1");
      honey.setName("Honey");
      honey.setPrice(10000);
      honey.setQty(10);
      honey.setTotal();
      
      productRepo.put(honey.getId(), honey);
      
      Product almond = new Product();
      almond.setId("2");
      almond.setName("Almond");
      almond.setPrice(20000);
      almond.setQty(10);
      almond.setTotal();
  
      productRepo.put(almond.getId(), almond);
   }
   
    // Untuk DELETE API (berfungsi untuk menghapus data)
   @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
   public ResponseEntity<Object> delete(@PathVariable("id") String id) { 
      productRepo.remove(id);
      return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
   }
   
   // Untuk PUT (berfungsi untuk edit data)
   @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
   public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) { 
       
       if(!productRepo.containsKey(id)){
            return new ResponseEntity<>("Produk tidak ada, mohon cek kembali", HttpStatus.NOT_FOUND);
        }
        else{
            productRepo.remove(id);
            product.setId(id);
            productRepo.put(id, product);
            return new  ResponseEntity<>("Product is updated Successfully",HttpStatus.OK);
        }
   }
   
   // Untuk POST (berfungsi untuk menambahkan data)
   @RequestMapping(value = "/products", method = RequestMethod.POST)
   public ResponseEntity<Object> createProduct(@RequestBody Product product) {
      
       if(productRepo.containsKey(product.getId())){
            return new ResponseEntity<>("ID tidak boleh sama, mohon untuk cek kembali", HttpStatus.OK);
        }
        else{
            productRepo.put(product.getId(), product);
            return new ResponseEntity<>("Product is created Successfully", HttpStatus.CREATED);
        }
   }
   
   // Untuk GET (menampilkan data)
   @RequestMapping(value = "/products")
   public ResponseEntity<Object> getProduct() {
      return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
   }
    
}
