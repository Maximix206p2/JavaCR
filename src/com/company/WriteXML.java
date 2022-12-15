package com.company;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.Arrays;

//https://stackoverflow.com/questions/51916221/javax-xml-bind-jaxbexception-implementation-of-jaxb-api-has-not-been-found-on-mo
public class WriteXML {
    public static void main(String[] args) {
        writePersons();
    }

    public static void writePersons() {
        Person person = new Person(1, "Alex");
        person.addEmail("alex@gmail.com");
        person.addEmail("alex@rambler.ru");

        Person person2 = new Person(2, "Alex2");
        person2.addEmail("alex@gmail.com");
        person2.addEmail("alex@rambler.ru");

        Persons persons = new Persons();
        persons.addPerson(person);
        persons.addPerson(person2);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Persons.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML

            //Print XML String to file
            jaxbMarshaller.marshal(persons, new File("src/com/company/data/persons.xml"));

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
