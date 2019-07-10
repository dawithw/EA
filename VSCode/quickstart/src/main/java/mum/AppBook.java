package mum;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

public class AppBook {
    private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        initPersistenceContext();
        createThreeBooks();
        printTable();
        //changeAndDeleteBooks();
        findDelete();
        getReferenceDelete();
        printTable();
    }

    public static void initPersistenceContext() {
        emf = Persistence.createEntityManagerFactory("cs544");
    }

    public static void createThreeBooks() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // Create 3 books
        Book book1 = createBook("Introduction to EA", "111-111-1234", "Tina", 20, new Date(2012-1900,2,10));
        Book book2 = createBook("Advanced EA Topics", "111-111-2222", "Michael", 40, new Date(2014-1900,5,12));
        Book book3 = createBook("EA for Dummies", "111-111-4000", "Assad", 10, new Date(2013-1900,1,12));

        // Save the books
        em.persist(book1);
        em.persist(book2);
        em.persist(book3);

        em.getTransaction().commit();
        em.close();
    }

    public static void printTable() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // retrieve and print all books
        TypedQuery<Book> query = em.createQuery("from Book", Book.class);
        List<Book> bookList = query.getResultList();
        for (Book book : bookList) {
            System.out.println("Book -- Title = " + book.getTitle()
                            + ", ISBN = " + book.getISBN()
                            + ", Price= " + book.getPrice()
                            + ", Author = " + book.getAuthor()
                            + ", Published Date = " + book.getPublish_date());
        }
        em.getTransaction().commit();
        em.close();
    }

    public static void changeAndDeleteBooks() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Book book = em.createQuery("from Book where price=40", Book.class).getSingleResult();
        book.setTitle("Advanced Enterprise Architecture");
        book.setPrice(100);

        Book assadBook = em.createQuery("from Book where author='Assad'", Book.class).getSingleResult();
        em.remove(assadBook);

        em.getTransaction().commit();
        em.close();
    }

    public static void findDelete() {
        System.out.println("Find and Delete ------------------------ ");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        System.out.println("START >>>>>>>>>>>>> em.find()");
        Book book = em.find(Book.class, 1);
        em.flush();
        System.out.println("DONE >>>>>>>>>>>>> em.find()");

        System.out.println(" START >>>>>>>>>>>>> em.remove()");
        em.remove(book);
        em.flush();
        System.out.println("DONE >>>>>>>>>>>>> em.remove()");

        em.getTransaction().commit();
        em.close();
    }

    public static void getReferenceDelete() {
        System.out.println("Get reference and Delete ------------------------ ");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        System.out.println(">>>>>>>>>>>>> em.getReference()");
        Book book = em.getReference(Book.class, 2);
        em.flush();
        System.out.println("DONE >>>>>>>>>>>>> em.getReference()");

        System.out.println(" START >>>>>>>>>>>>> em.remove()");
        em.remove(book);
        em.flush();
        System.out.println(" DONE >>>>>>>>>>>>> em.remove()");
        em.getTransaction().commit();
        em.close();
    }

    public static Book createBook(String title, String isbn, String author, double price, Date date) {
        Book book = new Book();
        book.setTitle(title);
        book.setISBN(isbn);
        book.setAuthor(author);
        book.setPrice(price);
        book.setPublish_date(date);
        return book;
    }
}
