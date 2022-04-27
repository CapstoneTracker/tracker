package capstone.tracker.controller;
import java.util.List;

import capstone.tracker.entity.Product;
import capstone.tracker.repository.ProductRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/product")
@RestController
public class ProductController {
    @Autowired
    private ProductRepository repository;

    @PostMapping("/insert")
    public Product saveMember(@RequestBody Product product) {
        //Map<String, Integer> map
        // System.out.println(map.get("clientname")+"//"+ intParser(map.get("age"))+"//"+ map.get("address"));
        //return repository.save(new Product(map.get("uID"), map.get("prodName"), map.get("loc"), map.get("qty"), map.get("date")));
        System.out.println(product.getProdName() + " / " + product.getLoc() + "/" + product.getQty() + "/" + product.getDate());
        return repository.save(product);
    }

    @PostMapping("/insertAll")
    public List<Product> saveMembers(List<Product> members) {
        return repository.saveAll(members);
    }
    
    @GetMapping("/getAll")
    public List<Product> getMembers() {
        return repository.findAll();
    }

    @PostMapping("/getById/{id}")
    public Product getMemberById(@PathVariable("id")  int id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping("/delete/{id}")
    public String deleteMember(@PathVariable("id") int id) {
        repository.deleteById(id);
        return "member removed !! " + id;
    }

    @PostMapping("/update")
    public Product updateMember(Product product) {
        Product existingMember = repository.findById(product.getUID()).orElse(null);
        existingMember.setUID(product.getUID());

        return repository.save(existingMember);
    }

    int intParser(String age){
        try{
            return Integer.parseInt(age);
        } catch(ClassCastException e){
            e.printStackTrace();
            return 0;
        }
    }
}
