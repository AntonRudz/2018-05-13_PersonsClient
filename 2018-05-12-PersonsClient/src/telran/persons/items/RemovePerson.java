package telran.persons.items;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import telran.persons.dto.PersonsApiConstsnts;
import telran.view.InputOutput;

public class RemovePerson extends PersonsItem {

	public RemovePerson(InputOutput inputOutput) {
		super(inputOutput);
	}

	@Override
	public String displayedName() {
		return "Remove person";
	}

	@Override
	public void action() {
		int id=inputOutput.getInteger("enter person id");
		HttpEntity<String> requestEntity=new HttpEntity<>(headers);
		ResponseEntity<Boolean> response=restTemplate
				.exchange(url+PersonsApiConstsnts.REMOVE_PERSON+"?id="+id,HttpMethod.POST, requestEntity, Boolean.class);
		if(response.getBody()) inputOutput.displayLine("Success");
		else inputOutput.displayLine("error");
	}

}
