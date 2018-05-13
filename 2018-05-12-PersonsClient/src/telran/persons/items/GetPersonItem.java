package telran.persons.items;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import telran.persons.dto.Person;
import telran.persons.dto.PersonsApiConstsnts;
import telran.view.InputOutput;

public class GetPersonItem extends PersonsItem{

	public GetPersonItem(InputOutput inputOutput) {
		super(inputOutput);
	}

	@Override
	public String displayedName() {
		return "Get person";
	}

	@Override
	public void action() {
		int id=inputOutput.getInteger("enter person id");
		HttpEntity<String> requestEntity=new HttpEntity<>(headers);
		ResponseEntity<Person> response=restTemplate
				.exchange(url+PersonsApiConstsnts.GET_PERSON+"?id="+id,HttpMethod.GET, requestEntity, Person.class);
		Person person=response.getBody();
		if(person==null)inputOutput.displayLine("person not exist");
		else inputOutput.displayLine(person);
	}

}
