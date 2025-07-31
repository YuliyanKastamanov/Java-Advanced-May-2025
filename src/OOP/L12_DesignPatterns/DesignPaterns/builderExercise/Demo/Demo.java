package com.company.builderPattern.builderExercise.Demo;

public class Demo {

    public static void main(String[] args) {


        Contact contact = Contact.builder()
                .name("Yuli")
                .email("yuli.kastamanov@gmail.com")
                .company("Softuni")
                .build();

    }
}
