package silva.cloud.practica.client;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest/buscar/client/{id}")
public class BusquedaResource {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping
	public String buscar(@PathVariable Integer id) {
		String url ="http://localhost:8071/rest/buscar/server/busca/{id}";
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("id", id);
		return restTemplate.getForObject(url, String.class, parameters);
	}
}
