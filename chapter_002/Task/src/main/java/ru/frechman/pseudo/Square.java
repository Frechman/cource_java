package ru.frechman.pseudo;

public class Square implements Shape {

    @Override
    public String draw() {
        StringBuilder sb = new StringBuilder()
                .append("++++").append(System.lineSeparator())
                .append("+  +").append(System.lineSeparator())
                .append("+  +").append(System.lineSeparator())
                .append("++++").append(System.lineSeparator());
        return sb.toString();
    }
}
