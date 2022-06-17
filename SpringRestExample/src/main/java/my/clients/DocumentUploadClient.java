package my.clients;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;

import javax.imageio.ImageIO;


import org.json.JSONObject;
import org.springframework.util.Base64Utils;

public class DocumentUploadClient {
	public static void main(String[] args) {
		String string = "";
		try {
 
			// Step1: Let's 1st read file from fileSystem
			// Change CrunchifyJSON.txt path here
//			InputStream crunchifyInputStream = new FileInputStream("D:/Vikas/test/scenery.jpg");
//			InputStreamReader crunchifyReader = new InputStreamReader(crunchifyInputStream);
//			BufferedReader br = new BufferedReader(crunchifyReader);
//			String line;
//			while ((line = br.readLine()) != null) {
//				string += line + "\n";
//			}
// 
//			byte[]   bytesEncoded = Base64.encode(string.toString().getBytes());
			
			//this byte array works
			byte[] bytesEncoded = Files.readAllBytes(new File("D:/my pics/_DSC0111.JPG").toPath());
			
			String stringEncodedImage = Base64Utils.encodeToString(bytesEncoded);			
			
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("image", stringEncodedImage);
			jsonObject.put("imageName", "xyz.jpg");
			System.out.println("outgoing json:::::"+jsonObject);
 
			
			
			
			// Step2: Now pass JSON File Data to REST Service
			try {
//				URL url = new URL("http://localhost:9090/SpringRestfulWebServicesWithJSONExample-0.0.1-SNAPSHOT/myDocDemo/uploadDocument");
				//URL url = new URL("http://localhost:9292/SpringRestExample/myDocDemo/uploadDocument");
				URL url = new URL("http://localhost:8080/SpringRestExample/myDocDemo/uploadDocument");
				URLConnection connection = url.openConnection();
				connection.setDoOutput(true);
				connection.setRequestProperty("Content-Type", "application/json");
				connection.setConnectTimeout(5000);
				connection.setReadTimeout(5000);
				OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
				out.write(jsonObject.toString());
				out.close();
 
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
 
				String output = in.readLine();
				while (output != null) {
					System.out.println(output);
					output = in.readLine();
				}
				System.out.println("\nCrunchify REST Service Invoked Successfully..");
				in.close();
			} catch (Exception e) {
				System.out.println("\nError while calling Crunchify REST Service");
				System.out.println(e);
			}
 
			//br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public byte[] extractBytes (String ImageName) throws IOException {
		 // open image
		 File imgPath = new File(ImageName);
		 BufferedImage bufferedImage = ImageIO.read(imgPath);

		 // get DataBufferBytes from Raster
		 WritableRaster raster = bufferedImage .getRaster();
		 DataBufferByte data   = (DataBufferByte) raster.getDataBuffer();

		 return ( data.getData() );
		}
}
