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
        WebClient webClient = new WebClient();
        HtmlPage page = null;
        HtmlPage page2 = null;
        try {
            page = webClient.getPage("https://gera.dhge.de/SelfService/start.php");
        } catch (IOException e) {
            e.printStackTrace();
        }
        HtmlForm form = page.getForms().get(0);
        System.out.println(form);

        //Creating Scanner and User Input Prompt
        Scanner input = new Scanner(System.in);
        System.out.println("Matrikelnummer: ");
        //String user = input.nextLine();
        String user = "G180055WI";
        System.out.println("Passwort: ");
        //String pw = input.nextLine();
        String pw = "leonj1109!";


        form.getInputByName("matrnr").setValueAttribute(user);
        form.getInputByName("passw").setValueAttribute(pw);

        try {
            page2 = form.getInputByValue("Notenauskunft (Bildschirm)").click();
            //System.out.println(page2.asText());
            String text = page2.asText();
            String[] texts = text.split("Semester" );
            String part2 = texts[2];
            System.out.println(part2);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
