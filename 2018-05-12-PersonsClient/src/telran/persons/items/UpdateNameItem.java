package telran.persons.items;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import telran.persons.dto.PersonsApiConstsnts;
import telran.persons.dto.UpdateName;
import telran.view.InputOutput;

public class UpdateNameItem extends PersonsItem {

	public UpdateNameItem(InputOutput inputOutput) {
		super(inputOutput);
	}
	@Override
	public String displayedName() {
		
		return "Update name";
	}
	@Override
	public void action() {
		int id=inputOutput.getInteger("enter person id");
		String newName=inputOutput.getString("enter new name");
		UpdateName update=new UpdateName(newName, id);
		HttpEntity<UpdateName> requestEntity=new HttpEntity<>(update,headers);
		ResponseEntity<Boolean> response=restTemplate
				.exchange(url+PersonsApiConstsnts.UPDATE_NAME,HttpMethod.POST, requestEntity, Boolean.class);
		if(response.getBody()) inputOutput.displayLine("success");
		else inputOutput.displayLine("error");
	}

}
