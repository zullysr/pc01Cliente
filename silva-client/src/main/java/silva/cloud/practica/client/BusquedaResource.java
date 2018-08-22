package silva.cloud.practica.client;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest/buscar/client")
public class BusquedaResource {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping
	@RequestMapping("/{id}")
	public String buscar(@RequestParam Integer id) {
		String url ="http://localhost:8071/rest/buscar/server/{id}";
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("id", id);
		return restTemplate.getForObject(url, String.class, parameters);
	}
}
