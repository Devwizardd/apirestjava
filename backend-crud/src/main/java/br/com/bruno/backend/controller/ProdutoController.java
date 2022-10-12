package br.com.bruno.backend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bruno.backend.exception.ResourceNotFoundException;
import br.com.bruno.backend.model.Produto;
import br.com.bruno.backend.repository.ProdutoRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	// get all clients
	@GetMapping("/produtos")
	public List<Produto> getAllProduto(){
		return produtoRepository.findAll();
	}		
	
	// create client rest api
	@PostMapping("/produtos")
	public Produto createProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	// get client by id rest api
	@GetMapping("/produtos/{id}")
	public ResponseEntity<Produto> getProdutoById(@PathVariable Long id) {
		Produto produto = produtoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("produto não existe :" + id));
		return ResponseEntity.ok(produto);
	}
	
	// update client rest api
	
	@PutMapping("/produtos/{id}")
	public ResponseEntity<Produto> updateProduto(@PathVariable Long id, @RequestBody Produto ProdutoDetails){
		Produto produto = produtoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("produto nao existe :" + id));
		
		produto.setName(ProdutoDetails.getName());
		produto.setCreatedDate(ProdutoDetails.getCreatedDate());
		
		Produto updatedProduto = produtoRepository.save(produto);
		return ResponseEntity.ok(updatedProduto);
	}
	
	// delete client rest api
	@DeleteMapping("/produtos/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteProduto(@PathVariable Long id){
		Produto produto = produtoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("produto nao existe :" + id));
		
		produtoRepository.delete(produto);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deletado", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}
