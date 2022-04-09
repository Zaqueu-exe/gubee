package br.com.alves.application;

import br.com.alves.entities.Comment;
import br.com.alves.entities.Post;

import java.util.Date;

public class Program {

    public static void main(String[] args) {

        Date moment = new Date();
        String title = "Traveling to New Zealand";
        String content = "I'm going to visit this wonderful country!";
        int likes = 12;

        Post post1 = new Post(moment, title, content, likes);
        post1.addComment(new Comment("Have a nice trip"));
        post1.addComment(new Comment("Wow that's awesome!"));

        Date moment1 = new Date();
        title = "Good night guys";
        content = "See you tomorrow";
        likes = 5;

        Post post2 = new Post(moment1, title, content, likes);
        post2.addComment(new Comment("Good night"));
        post2.addComment(new Comment("May the force be with you"));

        System.out.println(post1);
        System.out.println("---------------------------");
        System.out.println(post2);

    }
}
