

import java.util.*;


  public static void main(String[] args) { 

        // The HashMap
        HashMap<String, Contact> contacts = new HashMap<>();

        // add 5 names
        contacts.put("Ada Lovelace", new Contact("Ada Lovelace", "+1 617 555 0101")); 
        contacts.put("Bruce Cassidy", new Contact("Bruce Cassidy", "+1 618 123 2345")); 
        contacts.put("John Wayne", new Contact("John Wayne", "+1 617 456 3345")); 
        contacts.put("Kanye West", new Contact("Kanye West", "+1 917 367 8825")); 
        contacts.put("Celine Dion", new Contact("Celine Dion", "+1 654 987 8101")); 
        contacts.put("Bruce Wayne", new Contact("Bruce Wayne", "+1 546 982 6754")); 

        // Look up Ada
        Contact lookup = contacts.get("Ada Lovelace");
        if (lookup != null) System.out.println(lookup);
        else System.out.println("Contact Not Found");

        // Look up Charlie T
        Contact lookup2 = contacts.get("Charles Thibault");
        if (lookup2 != null) System.out.println(lookup2);
        else System.out.println("Contact Not Found");

        // The ArrayList
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());  
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));  

        System.out.println("========== Sorted list of Contacts ===================");
        for (Contact contact : sorted) {
        System.out.println(contact);
        }
    }



