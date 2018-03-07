package service.command;

import entity.Book;

import java.util.Set;

public interface Command {
    Set<Book> parsing();
}
