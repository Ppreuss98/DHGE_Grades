package com.projekt;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;
import java.util.Scanner;

/**
 * Hello world!
 */


public class App {

    public static void main(String[] args) {

        HtmlPage page2 = null;
        HtmlPage page = null;

        page = connectToHTML();     //getting the Login-Page

        HtmlForm form = page.getForms().get(0);
        System.out.println(form);

        //Set Input into Login and log in
        form.getInputByName("matrnr").setValueAttribute(userInput());
        form.getInputByName("passw").setValueAttribute(passwordInput());

        try {
            page2 = form.getInputByValue("Notenauskunft (Bildschirm)").click();
            //System.out.println(page2.asText());
            String text = page2.asText();
            String[] texts = text.split("Semester");
            String part2 = texts[2];
            System.out.println(part2);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static HtmlPage connectToHTML() {
        WebClient webClient = new WebClient();
        HtmlPage page = null;
        try {
            page = webClient.getPage("https://gera.dhge.de/SelfService/start.php");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return page;
    }

    private static String userInput() { //Creating Scanner and User Input Prompt
        // Scanner input = new Scanner(System.in);
        System.out.println("Matrikelnummer: ");
        //String user = input.nextLine();
        String user = "G180055WI";
        return user;
    }

    private static String passwordInput() {
        System.out.println("Passwort: ");
        //String pw = input.nextLine();
        String pw = "leonj1109!";
        return pw;
    }
}
