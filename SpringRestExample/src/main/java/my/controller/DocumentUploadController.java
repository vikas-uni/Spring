package my.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import my.model.ImageDemoData;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/*
 * Vikas
 * This is a demo service to test document upload like image,pdf,etc.
 * @RestController, it tells the Spring context that current class will act as Spring REST web service.
 */
@Controller
@RequestMapping(value = "/myDocDemo")
public class DocumentUploadController {

	@RequestMapping(value = "/uploadDocument", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String uploadDocument(@RequestBody ImageDemoData imageData,
			BindingResult result){
		
		// Get name of uploaded file.
				String fileName = imageData.getImageName();

				// Path where the uploaded file will be stored.
				String path = "D:/Java codes/" + fileName;

				
				// Now create the output file on the server.
				File outputFile = new File(path);

				
				//FileOutputStream writer = null;
				int totalBytes = 0;
				try {
					outputFile.createNewFile();

					
					
					

					
	                byte[] imageFileBytes = Base64Utils.decodeFromString(imageData.getImage());
	                BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageFileBytes));
	                if(img != null){
	                       ImageIO.write(img, "jpg", outputFile);
	                       img.flush();
	                       
	                }else{
	                       
	                }
					
					// Create writer for 'outputFile' to write data read from
					// 'uploadedFileRef'
					//writer = new FileOutputStream(outputFile);

					// Iteratively read data from 'uploadedFileRef' and write to
					// 'outputFile';
					
						//writer.write(imageData.getImage());
						
					
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					
				}

				return "File uploaded successfully! Total Bytes Read=" + totalBytes;
		
	}
	
	//----for uploading PDF-----------test-----------------
	//@ResponseBody annotation is used to map the response object in the response body. 
	//Once the response object is returned by the handler method, MappingJackson2HttpMessageConverter 
	//kicks in and convert it to JSON response.
	@RequestMapping(method = RequestMethod.POST, value = "/uploadPdf")
	@ResponseBody
	public String handleFileUpload(@RequestParam("file") MultipartFile file,
								   RedirectAttributes redirectAttributes) {

		if (!file.isEmpty()) {
			try {
				Files.copy(file.getInputStream(), Paths.get("d:/", file.getOriginalFilename()));
				redirectAttributes.addFlashAttribute("message",
						"You successfully uploaded " + file.getOriginalFilename() + "!");
			} catch (IOException|RuntimeException e) {
				redirectAttributes.addFlashAttribute("message", "Failued to upload " + file.getOriginalFilename() + " => " + e.getMessage());
			}
		} else {
			redirectAttributes.addFlashAttribute("message", "Failed to upload " + file.getOriginalFilename() + " because it was empty");
		}

		return "redirect:/";
	}

}
