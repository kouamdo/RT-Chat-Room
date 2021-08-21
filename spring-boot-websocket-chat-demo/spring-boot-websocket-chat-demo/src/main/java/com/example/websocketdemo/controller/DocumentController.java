package com.example.websocketdemo.controller;

import java.awt.List;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.websocketdemo.model.Document;
import com.example.websocketdemo.repository.DocumentRepository;

import com.example.websocketdemo.model.ChatMessage;
import org.springframework.ui.Model;

@RestController
public class DocumentController {

	@Autowired
	private DocumentRepository repo ;
		
	
	@PostMapping("/FileServices.html/upload")
	public ModelAndView uploadDOcument(@RequestParam("document") MultipartFile[] MultipartFile , @RequestParam("coment") String coment , 
			@RequestParam("canal") String canal, Model model) throws IOException
	{
		
		Arrays.asList(MultipartFile).stream().forEach(file ->{
			
			Document doc = new Document(0, canal, coment, canal) ;
			
			doc.setName(file.getOriginalFilename()) ;
			
			try {
				doc.setContent(file.getBytes()) ;
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			doc.setSize(file.getSize()) ;
			
			doc.setComent(coment) ;
			
			doc.setCanal(canal);
			
			doc.setUploaddate(new Date());
			
			repo.save(doc);
		});
		
		model.addAttribute("message", "File has been Upload Succesfully");
		
		return new ModelAndView("redirect:/FileServices.html");
	}
	
}
