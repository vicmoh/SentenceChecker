/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import static java.time.Clock.system;
import java.util.Scanner;

/**
 *
 * @author Vicky Mohamamd
 */
public class Lab1 {

    /**
     * @param args handling user input
     */
    public static void main(String[] args) {
        //create variable
        String[] stringArray = new String[10];
        int menu = 20;
        int arrayIndex = 0;
        int numOfChar = 0;
        int numOfVow = 0;
        int chooseIndex = 0;
        int found = 0;
        Scanner reader = new Scanner(System.in);
        Scanner intScanner = new Scanner(System.in);
        
        //display the options
        System.out.println("1. Enter a sentence");
        System.out.println("2. Print all sentences entered, in the order they were entere");
        System.out.println("4. Print the total number of sentences entered");
        System.out.println("5. Print the total number of characters in all sentence");
        System.out.println("6. Print the number of vowels in all sentence");
        System.out.println("6. Print the number of vowels in all sentence");
        System.out.println("8. Search for a word using case-insensitive comparisons");
        System.out.println("9. Search for a word using case-sensitive comparisons");
        System.out.println("10. Quit");
        
        while(menu != 10){
            //ask the user
            System.out.println("Which option do you want?");
            menu = intScanner.nextInt();
         
            //choose menu
            if(menu == 1){
                if(arrayIndex <= 9 ){
                    System.out.println("Enter a sentence:");
                    stringArray[arrayIndex] = reader.nextLine();
                    arrayIndex++;
                }else{
                    System.out.println("No input allowed, maximum input is 10");
                }//end if
            }else if(menu == 2){
                System.out.println("Printing the list of sentence in order...");
                for(int x=0; x < arrayIndex; x++){
                    System.out.println(stringArray[x]);
                }//end for loop
            }else if (menu == 3){
                System.out.println("Printing the list of sentence in reverse...");
                for(int x=arrayIndex-1; x >= 0; x--){
                    System.out.println(stringArray[x]);
                }//end for loop
            }if (menu == 4){
                System.out.println("You entered " + arrayIndex + " sentences.");
            }if (menu == 5){
                for(int x=0; x < arrayIndex; x++){
                    numOfChar = numOfChar + stringArray[x].length();
                }//end for loop
                System.out.println("There are " + numOfChar + " characters.");
            } if(menu == 6){
                for (int x=0; x < arrayIndex; x++){
                    for(int y=0; y < stringArray[x].length(); y++){
                        if(stringArray[x].charAt(y) == 'a' || stringArray[x].charAt(y) == 'i' ||
                           stringArray[x].charAt(y) == 'u' || stringArray[x].charAt(y) == 'e' ||
                           stringArray[x].charAt(y) == 'o' || stringArray[x].charAt(y) == 'A' ||
                           stringArray[x].charAt(y) == 'I' || stringArray[x].charAt(y) == 'U' ||
                           stringArray[x].charAt(y) == 'E' || stringArray[x].charAt(y) == 'O'){
                           numOfVow++;
                        }//end if
                    }//end for loop
                }//end for loop
                System.out.println("There are " + numOfVow + " vowels.");
            }if(menu == 7){
                System.out.println("Enter the index of the sentence: ");
                chooseIndex = intScanner.nextInt();
                if(chooseIndex >= 1 && chooseIndex <= 10){
                    System.out.println("Displaying sentence number " + (chooseIndex));
                    System.out.println("The sentence is \"" + stringArray[chooseIndex-1] + "\"");
                }else{
                    System.out.println("Invalid input");
                }//end if
            }else if(menu == 8){
                //ask the word
                System.out.println("Enter the word to search:");
                String search = reader.nextLine();
                //find the same word
                for (int x=0; x<arrayIndex; x++){
                    //find the word
                    String[] word = stringArray[x].split(" ");
                    //finding the same word in the line
                    for(int y=0; y<word.length; y++){
                        if(search.equalsIgnoreCase(word[y])){
                            found++;
                            //System.out.println(word[y]); 
                        }//end if
                    }//end for loop
                }//end loop
                //print the number of word found
                System.out.println("Found " + found + " words that match " + search);
                found = 0;
            }else if(menu == 9){
                 //ask the word
                System.out.println("Enter the word to search:");
                String search = reader.nextLine();
                //find the same word
                for (int x=0; x<arrayIndex; x++){
                    //find the word
                    String[] word = stringArray[x].split(" ");
                    //finding the same word
                    for(int y=0; y<word.length; y++){
                        if(search.equals(word[y])){
                            found++;
                            //System.out.println(word[y]); 
                        }//end if
                    }//end for loop
                }//end loop
                //print the number of word found
                System.out.println("Found " + found + " words that match " + search);
                found = 0;
            }else if(menu == 10){
                System.out.println("Program has exited");
            }else if(menu < 1 || menu > 10){
                System.out.println("Invalid input");
            }//enf if
        }//end while
    }//end main
}//end class
