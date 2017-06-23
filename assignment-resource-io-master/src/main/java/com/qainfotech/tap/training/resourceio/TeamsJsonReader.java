package com.qainfotech.tap.training.resourceio;

import com.qainfotech.tap.training.resourceio.exceptions.ObjectNotFoundException;
import com.qainfotech.tap.training.resourceio.model.Individual;
import com.qainfotech.tap.training.resourceio.model.Team;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Ramandeep RamandeepSingh AT QAInfoTech.com
 */
public class TeamsJsonReader {

	/**
	 * get a list of individual objects from db json file
	 * 
	 * @return
	 * @throws IOException
	 * @throws FileNotFoundException
	 */

	List<Individual> myObjList, myObjList1, myObjList2, myObjList3 = new List<Individual>() {

		@Override
		public <T> T[] toArray(T[] a) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Object[] toArray() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Individual> subList(int fromIndex, int toIndex) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int size() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Individual set(int index, Individual element) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean retainAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean removeAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Individual remove(int index) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean remove(Object o) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public ListIterator<Individual> listIterator(int index) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ListIterator<Individual> listIterator() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int lastIndexOf(Object o) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Iterator<Individual> iterator() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public int indexOf(Object o) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Individual get(int index) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean containsAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean contains(Object o) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void clear() {
			// TODO Auto-generated method stub

		}

		@Override
		public boolean addAll(int index, Collection<? extends Individual> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean addAll(Collection<? extends Individual> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void add(int index, Individual element) {
			// TODO Auto-generated method stub

		}

		@Override
		public boolean add(Individual e) {
			// TODO Auto-generated method stub
			return false;
		}
	};

	public List<Individual> getListOfIndividuals() throws FileNotFoundException, IOException {

		JSONParser parser = new JSONParser();

		JSONObject obj = null;
		try {
			obj = (JSONObject) parser.parse(new FileReader("src/main/resources/db.json"));
		} catch (org.json.simple.parser.ParseException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}

		JSONObject jsonObject = (JSONObject) obj;

		// System.out.println(jsonObject);

		JSONArray second = (JSONArray) jsonObject.get("individuals");

		Individual obj1;
		JSONObject myobj;

		// JSONParser myparse = new JSONParser();

		for (int i = 0; i < second.size(); i++) {

			myobj = (JSONObject) second.get(i);

			System.out.println(myobj.get("name"));

			System.out.println(myobj.get("active"));

			System.out.println(myobj.get("id"));
			obj1 = new Individual(myobj.get("name").toString(), Integer.parseInt(myobj.get("id").toString()),
					Boolean.parseBoolean(myobj.get("active").toString()));

			myObjList.add(obj1);

			System.out.println(second.get(i));

		}

		System.out.println(second.toString());
		return myObjList;

		// throw new UnsupportedOperationException("Not implemented.");
	}

	/**
	 * get individual object by id
	 * 
	 * @param id
	 *            individual id
	 * @return
	 * @throws com.qainfotech.tap.training.resourceio.exceptions.ObjectNotFoundException
	 */
	public Individual getIndividualById(Integer id) throws ObjectNotFoundException {

		for (int i = 0; i < myObjList.size(); i++) {
			if (myObjList.get(i).getId() == id) {

				return myObjList.get(i);

			}

		}

		throw new UnsupportedOperationException("Not implemented.");

	}

	/**
	 * get individual object by name
	 * 
	 * @param name
	 * @return
	 * @throws com.qainfotech.tap.training.resourceio.exceptions.ObjectNotFoundException
	 */
	public Individual getIndividualByName(String name) throws ObjectNotFoundException {

		for (int i = 0; i < myObjList.size(); i++) {
			if (myObjList.get(i).getName().equals(name)) {

				return myObjList.get(i);

			}

		}

		throw new UnsupportedOperationException("Not implemented.");
	}

	/**
	 * get a list of individual objects who are not active
	 * 
	 * @return List of inactive individuals object
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public List<Individual> getListOfInactiveIndividuals() throws FileNotFoundException, IOException {

		JSONParser parser = new JSONParser();

		JSONObject obj = null;
		try {
			obj = (JSONObject) parser.parse(new FileReader("src/main/resources/db.json"));
		} catch (org.json.simple.parser.ParseException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}

		JSONObject jsonObject = (JSONObject) obj;

		// System.out.println(jsonObject);

		JSONArray second = (JSONArray) jsonObject.get("individuals");

		Individual obj1;
		JSONObject myobj;

		// JSONParser myparse = new JSONParser();

		for (int i = 0; i < second.size(); i++) {

			myobj = (JSONObject) second.get(i);

			if (Boolean.parseBoolean(myobj.get("active").toString()) == false) {
				// System.out.println(myobj.get("id"));
				obj1 = new Individual(myobj.get("name").toString(), Integer.parseInt(myobj.get("id").toString()),
						Boolean.parseBoolean(myobj.get("active").toString()));

				myObjList2.add(obj1);

				// System.out.println(second.get(i));
			}
		}

		// System.out.println(second.toString());
		return myObjList2;

		// throw new UnsupportedOperationException("Not implemented.");
	}

	/**
	 * get a list of individual objects who are active
	 * 
	 * @return List of active individuals object
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public List<Individual> getListOfActiveIndividuals() throws FileNotFoundException, IOException {

		JSONParser parser = new JSONParser();

		JSONObject obj = null;
		try {
			obj = (JSONObject) parser.parse(new FileReader("src/main/resources/db.json"));
		} catch (org.json.simple.parser.ParseException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}

		JSONObject jsonObject = (JSONObject) obj;

		// System.out.println(jsonObject);

		JSONArray second = (JSONArray) jsonObject.get("individuals");

		Individual obj1;
		JSONObject myobj;

		// JSONParser myparse = new JSONParser();

		for (int i = 0; i < second.size(); i++) {

			myobj = (JSONObject) second.get(i);

			if (Boolean.parseBoolean(myobj.get("active").toString()) == false) {
				// System.out.println(myobj.get("id"));
				obj1 = new Individual(myobj.get("name").toString(), Integer.parseInt(myobj.get("id").toString()),
						Boolean.parseBoolean(myobj.get("active").toString()));

				myObjList3.add(obj1);

				// System.out.println(second.get(i));
			}
		}

		// System.out.println(second.toString());
		return myObjList3;

		// throw new UnsupportedOperationException("Not implemented.");
	}

	
	
	List<Team> myObjList5 = new List<Team>() {
		
		@Override
		public <T> T[] toArray(T[] a) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Object[] toArray() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public List<Team> subList(int fromIndex, int toIndex) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public int size() {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public Team set(int index, Team element) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public boolean retainAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean removeAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public Team remove(int index) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public boolean remove(Object o) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public ListIterator<Team> listIterator(int index) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public ListIterator<Team> listIterator() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public int lastIndexOf(Object o) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public Iterator<Team> iterator() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public int indexOf(Object o) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public Team get(int index) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public boolean containsAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean contains(Object o) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public void clear() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public boolean addAll(int index, Collection<? extends Team> c) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean addAll(Collection<? extends Team> c) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public void add(int index, Team element) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public boolean add(Team e) {
			// TODO Auto-generated method stub
			return false;
		}
	};
	
	/**
	 * get a list of team objects from db json
	 * 
	 * @return
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public List<Team> getListOfTeams() throws FileNotFoundException, IOException {
		JSONParser parser = new JSONParser();

		JSONObject obj = null;
		try {
			obj = (JSONObject) parser.parse(new FileReader("src/main/resources/db.json"));
		} catch (org.json.simple.parser.ParseException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}

		JSONObject jsonObject = (JSONObject) obj;

		// System.out.println(jsonObject);

		JSONArray second = (JSONArray) jsonObject.get("teams");

		Team obj1;
		JSONObject myobj;

		// JSONParser myparse = new JSONParser();

		for (int i = 0; i < second.size(); i++) {

			myobj = (JSONObject) second.get(i);

			
				obj1 = new Team(myobj.get("name").toString(), Integer.parseInt(myobj.get("id").toString()),myObjList);;

				myObjList5.add(obj1);

				// System.out.println(second.get(i));
			}
		

		// System.out.println(second.toString());
		return myObjList5;

	//	throw new UnsupportedOperationException("Not implemented.");

	}

	public static void main(String... S) throws IOException {

		Object my = new TeamsJsonReader().getListOfIndividuals();

	}
}
