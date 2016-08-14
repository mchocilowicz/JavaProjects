package pl.spring.projekt.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.multipart.MultipartFile;

import pl.spring.projekt.service.ProductService;
import pl.spring.projekt.service.RecipeService;
import pl.spring.projekt.service.UserService;

public class MultipartFileConverter implements Converter<MultipartFile,byte[]> {

	@Autowired
	RecipeService recipeService;
	
	@Autowired
	ProductService productService;
	
	
	@Override
	public byte[] convert(MultipartFile  source) {
		try{
			if(!source.isEmpty())
				return source.getBytes();
		}catch(Exception e){}
		
		return null;
	}

}
