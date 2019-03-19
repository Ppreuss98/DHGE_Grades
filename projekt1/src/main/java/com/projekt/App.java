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
        String user = input.nextLine();
        System.out.println("Passwort: ");
        String pw = input.nextLine();


        form.getInputByName("matrnr").setValueAttribute(user);
        form.getInputByName("passw").setValueAttribute(pw);

        try {
            page2 = form.getInputByValue("Notenauskunft (Bildschirm)").click();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
