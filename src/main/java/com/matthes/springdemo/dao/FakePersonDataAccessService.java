package com.matthes.springdemo.dao;

import com.matthes.springdemo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        if(id == null) {
            DB.add(person);
        } else {
            DB.add(new Person(id, person.getName()));
        }
;        return 1; // success
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {

        // 7 best ways to loop through lists in Java:
        // https://coderstea.in/post/java/7-best-ways-you-can-loop-through-lists-in-java/

        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();

/*        for(int i=0; i<DB.size(); i++) {
            Person person = DB.get(i);
            if(person.getId() == id) {
                return Optional.of(person);
            }
        }
        return Optional.empty();
*/


    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> personMaybe = selectPersonById(id);
        if(personMaybe.isEmpty()) {
            return 0;
        } else {
            DB.remove(personMaybe.get());
            return 1;
        }
    }

    @Override
    public int updatePersonById(UUID id, Person update) {
        return selectPersonById(id).map(person -> {
            int indexOfPersonToUpdate = DB.indexOf(person);
            if (indexOfPersonToUpdate >= 0) {
                DB.set(indexOfPersonToUpdate, new Person(id, update.getName()));
                return 1;
            } else {
                return 0;
            }
        }).orElse(0);
    }
}
