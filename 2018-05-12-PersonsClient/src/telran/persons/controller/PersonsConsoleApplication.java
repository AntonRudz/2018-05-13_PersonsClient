package telran.persons.controller;


import java.util.ArrayList;

import telran.persons.items.AddPersonItem;
import telran.persons.items.GetPersonItem;
import telran.persons.items.RemovePerson;
import telran.persons.items.UpdateNameItem;
import telran.view.ConsoleInputOutput;
import telran.view.InputOutput;
import telran.view.Item;
import telran.view.Menu;
import telran.view.MenuWithExit;


public class PersonsConsoleApplication {
	public static void main(String[] args) {
		ArrayList<Item> items=new ArrayList<>();
		InputOutput inputOutput=new ConsoleInputOutput();
		items.add(new AddPersonItem(inputOutput));
		items.add(new RemovePerson(inputOutput));
		items.add(new GetPersonItem(inputOutput));
		items.add(new UpdateNameItem(inputOutput));
		
		Menu menu=new MenuWithExit(items, inputOutput);
		menu.runMenu();

	}
}
