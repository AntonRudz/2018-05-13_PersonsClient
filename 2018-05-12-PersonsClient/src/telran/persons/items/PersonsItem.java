package telran.persons.items;

import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import telran.view.AbstractItem;
import telran.view.InputOutput;

public abstract class PersonsItem extends AbstractItem{

	public PersonsItem(InputOutput inputOutput) {
		super(inputOutput);
		}
	static protected String url = "http://localhost:8080/";
	static protected RestTemplate restTemplate=new RestTemplate();
	static protected HttpHeaders headers=new HttpHeaders();
	
}
