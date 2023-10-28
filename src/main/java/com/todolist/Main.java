package com.todolist;

import java.util.Scanner;

public class Main {
    public static String[] model = new String[5];

    public static void main(String[] args) {
        testDeleteTodo();
    }

    /**
     * Menampilkan semua todolist
     */
    public static void showTodoList(){
        for(int i = 0; i < model.length; i++){
            String todo = model[i];
            Integer nomor = i + 1;

            if(todo != null){
                System.out.println(nomor + ". " + todo);
            }
        }
    }

    public static void testShowTodolist(){
        model[0] = "Todo saya yang pertama";
        model[1] = "Apa weh kepo";
        showTodoList();
    }

    /**
     * Menambahkan todo ke list
     */
    public static void addTodo(String todo){
        // cek list penuh atau tidak
        Boolean isFull = true;
        for(String data : model){
            if(data == null){
                isFull = false;
                break;
            }
        }

        // jika penuh, resize 2x lipat
        if(isFull){
            String[] temp = model;
            model = new String[model.length * 2];

            for(int i = 0; i < temp.length; i++){
                model[i] = temp[i];
            }
        }

        // assign ke list
        for(int i = 0; i < model.length; i++){
            if(model[i] == null){
                model[i] = todo;
                break;
            }
        }

    }

    public static void testAddTodo(){
        addTodo("Ingin Makan 1");
        addTodo("Ingin Makan 2");
        addTodo("Ingin Makan 3");
        addTodo("Ingin Makan 4");

        showTodoList();
    }

    /**
     * Menghapus todo dari list
     */
    public static void deleteTodo(int nomor){
        String[] temp = model;

        // Hapus sesuai nomor
        for(int i = 0; i < model.length; i++){
            if((i + 1) == nomor){
                // delete data
                model[i] = null;
            }
        }

        // perbaiki urutan yang telah kosong
        for(int i = 0; i < model.length; i++){
            if(model[i] == null && i + 1 < model.length){
                model[i] = model[i + 1];
                model[i + 1] = null;
            }
        }

    }

    public static void testDeleteTodo(){
        addTodo("Ingin Makan 1");
        addTodo("Ingin Makan 2");
        addTodo("Ingin Makan 3");
        addTodo("Ingin Makan 4");

        showTodoList();

        deleteTodo(3);
        System.out.println();
        showTodoList();

    }

    /**
     * Menampilkan view / screen todolist
     */
    public static void viewShowTodo(){

    }

    /**
     * Menampilkan view / screen add todolist
     */
    public static void viewAddTodo(){

    }

    /**
     * Menampilkan view /screen delete todolist
     */
    public static void viewDeleteTodo(){

    }
}
