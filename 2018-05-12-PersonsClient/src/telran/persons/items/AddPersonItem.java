package telran.persons.items;

import java.time.LocalDate;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import telran.persons.dto.Person;
import telran.persons.dto.PersonsApiConstsnts;
import telran.view.InputOutput;

public class AddPersonItem extends PersonsItem {

	public AddPersonItem(InputOutput inputOutput) {
		super(inputOutput);
	}

	@Override
	public String displayedName() {
		return "Add person";
	}

	@Override
	public void action() {
		Person person=getPerson();
		HttpEntity<Person> requestEntity=new HttpEntity<>(person,headers);
		ResponseEntity<Boolean> response=restTemplate
				.exchange(url+PersonsApiConstsnts.ADD_PERSON,HttpMethod.POST, requestEntity, Boolean.class);
		if(response.getBody()) inputOutput.displayLine("Success");
		else inputOutput.displayLine("error");
	}

	private Person getPerson() {
		int id=inputOutput.getInteger("enter person id");
		String name=inputOutput.getString("enter name");
		LocalDate birthDate=inputOutput.getDate("enter birth date", "yyyy-MM-dd");
		
		return new Person(id, name, birthDate);
	}

}
