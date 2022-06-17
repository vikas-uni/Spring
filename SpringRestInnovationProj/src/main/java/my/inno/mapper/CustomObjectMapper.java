package my.inno.mapper;



import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * 
 * @author vikas.gond
 *Jackson has different API like ObjectMapper, JsonParser and JsonGenerator etc. 
 *We can read JSON from different resources like String variable, file or any network. 
 *ObjectMapper is most important class which acts as codec or data binder. 
 *ObjectMapper can write java object into JSON file and read JSON file into java Object. 
 *Jackson provides faster Streaming API i.e JsonParser and JsonGenerator. 
 *JsonParser reads JSON file and JsonGenerator writes java object or map into JSON 
 *file using coded object. While creating java class to map to and from JSON we must 
 *keep a default constructor because Jackson API creates java class instance using default 
 *constructor. 
 */
public class CustomObjectMapper extends ObjectMapper {

	private static final long serialVersionUID = 1L;
	

	public CustomObjectMapper() {
		// To prevent serialization of "null" values in the MAP
		configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);		
		setSerializationInclusion(Include.NON_NULL);
		setSerializationInclusion(Include.NON_EMPTY);
		
		// ObjectId Serializer
	/*	SimpleModule module = new SimpleModule("ObjectIdmodule");
		module.addSerializer(ArrayList.class, new ObjectIdSerializer());
		this.registerModule(module);*/

		/*// DateTime Serializer
		SimpleModule moduleDT = new SimpleModule("DateTimemodule");
		module.addSerializer(DateTime.class, new DateTimeSerializer());
		this.registerModule(moduleDT);*/
	}
}
