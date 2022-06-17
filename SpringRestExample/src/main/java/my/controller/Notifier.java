package my.controller;

import java.util.HashMap;
import java.util.Map;

import my.model.NotificationDTO;
import my.utils.MailSender;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RequestMapping("/notification")
public class Notifier {

	
	
	// ##########################################################################################
			@RequestMapping(value = "/notify", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
			@ResponseBody
			public Map<String, Object> notifications(@RequestBody NotificationDTO notificationDTO,
					BindingResult result) {
				boolean success = false;
				try {
					String from = "vikas.gond@infogain.com";
					String toAddr = notificationDTO.getEmail().getTo();
					String cc = notificationDTO.getEmail().getCc();
					System.out.println("to add is::"+notificationDTO.getEmail().getTo());
					MailSender mailSender = new MailSender();
					success = mailSender.sendNotification(notificationDTO);

				} catch (Exception ex) {
					//logger.info("Exception in sending mail  " + ex);
					ex.printStackTrace();
				}

				if (!success) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("error", "Exception in sending mail");
					return map;
				} else {

					Map<String, Object> resposeMap = new HashMap<String, Object>();
					resposeMap.put("sentTo", notificationDTO.getEmail().getTo());
					resposeMap.put("mobile", notificationDTO.getSms().getNumber());

					return resposeMap;
				}
			}

			// ##############################################################################

	
	
	
	
	
}
