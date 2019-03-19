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
            String[] texts = text.split("\n");
            String[] texts2 = text.split("Semester");
            int anzahlFaecher = getSubjects(texts2[2]);
            split(texts, anzahlFaecher);
            //System.out.println(texts[10]);
            System.out.println("Durchschnitt:\t\t\t" + getAverage(texts, anzahlFaecher));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void split(String[] texts, int anzahlFaecher) {
        String[] semester = new String[anzahlFaecher];
        String[] subject = new String[anzahlFaecher];
        String[] mark = new String[anzahlFaecher];
        System.out.println("semester\tsubject\t\tmark");
        int h = 0;
        for (int i = 10; i < anzahlFaecher + 10; i++) {
            String[] texts1 = texts[i].split("\t");
            semester[h] = texts1[0];
            subject[h] = texts1[1];
            mark[h] = texts1[2];

            System.out.println(semester[h] + "\t\t\t" + subject[h] + "\t\t\t" + mark[h]);
            h++;
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

    //Creating Scanner and User Input Prompt
    private static String userInput() {
        Scanner input = new Scanner(System.in);
        System.out.println("Matrikelnummer: ");
        String user = input.nextLine();
        //String user = "G180055WI";
        return user;
    }

    private static String passwordInput() {
        Scanner input = new Scanner(System.in);
        System.out.println("Passwort: ");
        String pw = input.nextLine();

        input.close();
        return pw;


    }


    public static int getSubjects(String part) {

        int subjects = (part.split("\n").length) - 3;

        return subjects;
    }

    private static float getAverage(String[] texts, int anzahlFaecher){
        float average = 0;
            String[] mark = new String[anzahlFaecher];
            int h = 0;
            for (int i = 10; i < anzahlFaecher + 10; i++){
                String[] texts1 = texts[i].split("\t");
                mark[h] = texts1[2];
                h++;
            }

            int marks = 0;
            for (int i = 0; i < mark.length; i++){
                if (!mark[i].isEmpty()){
                    average += Float.parseFloat(mark[i]);
                    marks++;
                }
            }


        return average / marks;
    }
}
