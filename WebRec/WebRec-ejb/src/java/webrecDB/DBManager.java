/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webrecDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import website.WebSite;
import website.sortByURL;
import website.sortByUsername;

/**
 *
 * @author Administrator
 */
@Stateless
public class DBManager implements DBManagerLocal {

    public DBManager() {
    }

    public boolean removeWebsite(int website_id) {
        boolean result = false;

        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebRecDB");
            EntityManager em = emf.createEntityManager();

            em.getTransaction().begin();

            Websites website = em.find(Websites.class, website_id);

            em.remove(website);

            em.getTransaction().commit();

            em.close();
            emf.close();

            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public boolean addWebsite(Users user, String url, String description) {
        boolean result = false;

        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebRecDB");
            EntityManager em = emf.createEntityManager();

            Websites website = new Websites(Integer.MIN_VALUE, url);
            website.setDescription(description);
            website.setCreator(user);

            em.getTransaction().begin();

            em.persist(website);

            em.getTransaction().commit();

            em.close();
            emf.close();

            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public boolean saveWebsite(int website_id, String url, String description) {
        boolean result = false;

        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebRecDB");
            EntityManager em = emf.createEntityManager();

            em.getTransaction().begin();

            Websites website = em.find(Websites.class, website_id);

            website.setUrl(url);
            website.setDescription(description);

            em.getTransaction().commit();

            em.close();
            emf.close();

            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public Websites getWebsite(int website_id) {
        Websites website = null;

        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebRecDB");
            EntityManager em = emf.createEntityManager();

            em.getTransaction().begin();

            website = em.find(Websites.class, website_id);

            em.close();
            emf.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return website;
    }

    public Users getUser(String username, String password) {
        Users user = null;
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebRecDB");
            EntityManager em = emf.createEntityManager();

            em.getTransaction().begin();

            List<Users> users = (List<Users>) em.createNamedQuery("Users.findAll").getResultList();

            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getUsername().equals(username) && users.get(i).getPassword().equals(password)) {
                    user = users.get(i);
                }
            }

            em.close();
            emf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    public boolean rateWebsite(Users user, int website_id, int rate) {
        boolean result = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/webrecdb", "root", "password");

            CallableStatement s = conn.prepareCall("CALL addRating(?,?,?,?)");

            s.registerOutParameter(4, java.sql.Types.BOOLEAN);

            s.setInt(1, website_id);
            s.setInt(2, user.getUserId());
            s.setInt(3, rate);

            s.execute();

            result = s.getBoolean(4);

            s.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public boolean addUser(String username, String password) {
        boolean result = false;
        try {
            short isAdmin = 0, lockedAccount = 0;

            Users user = new Users(null, username, password, isAdmin, lockedAccount);

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebRecDB");
            EntityManager em = emf.createEntityManager();

            em.getTransaction().begin();

            em.persist(user);

            em.getTransaction().commit();

            em.close();
            emf.close();

            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public boolean makeAdmin(int user_id) {
        boolean result = false;

        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebRecDB");
            EntityManager em = emf.createEntityManager();

            em.getTransaction().begin();

            Users user = em.find(Users.class, user_id);

            if (user.getIsAdmin() == 0) {
                short lockAccount = 1;
                user.setIsAdmin(lockAccount);
            } else {
                short lockAccount = 0;
                user.setIsAdmin(lockAccount);
            }

            em.getTransaction().commit();

            em.close();
            emf.close();

            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public boolean lockAccount(int user_id) {
        boolean result = false;

        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebRecDB");
            EntityManager em = emf.createEntityManager();

            em.getTransaction().begin();

            Users user = em.find(Users.class, user_id);

            if (user.getLockedAccount() == 0) {
                short lockAccount = 1;
                user.setLockedAccount(lockAccount);
            } else {
                short lockAccount = 0;
                user.setLockedAccount(lockAccount);
            }

            em.getTransaction().commit();

            em.close();
            emf.close();

            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public boolean deleteUSer(int user_id) {
        boolean result = false;

        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebRecDB");
            EntityManager em = emf.createEntityManager();

            em.getTransaction().begin();

            Users user = em.find(Users.class, user_id);

            em.remove(user);

            em.getTransaction().commit();

            em.close();
            emf.close();

            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public boolean resetUserPassword(int user_id) {
        boolean result = false;

        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebRecDB");
            EntityManager em = emf.createEntityManager();

            em.getTransaction().begin();

            Users user = em.find(Users.class, user_id);

            user.setPassword("password");

            em.getTransaction().commit();

            em.close();
            emf.close();

            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public ArrayList<Users> getUserList() {
        ArrayList<Users> users = new ArrayList<Users>();

        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebRecDB");
            EntityManager em = emf.createEntityManager();

            em.getTransaction().begin();

            List<Users> uSers = (List<Users>) em.createNamedQuery("Users.findAll").getResultList();

            for (int i = 0; i < uSers.size(); i++) {
                users.add(uSers.get(i));
            }

            em.close();
            emf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public ArrayList<WebSite> getWebList() {
        ArrayList<WebSite> WebSites = new ArrayList<WebSite>();

        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebRecDB");
            EntityManager em = emf.createEntityManager();

            em.getTransaction().begin();

            List<Websites> websites = (List<Websites>) em.createNamedQuery("Websites.findAll").getResultList();

            for (int i = 0; i < websites.size(); i++) {
                WebSite website = new WebSite(websites.get(i).getWebsiteId());

                website.setUrl(websites.get(i).getUrl());
                website.setCreator(websites.get(i).getCreator().getUsername());
                website.setDescription(websites.get(i).getDescription());

                double rating = 0, count = 0;
                for (int j = 0; j < websites.get(i).getRatingsList().size(); j++) {
                    rating = +websites.get(i).getRatingsList().get(j).getRating();
                    count++;
                }
                rating = rating / count;

                website.setRating((int) rating);

                WebSites.add(website);
            }

            em.close();
            emf.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        Collections.sort(WebSites);

        return WebSites;
    }

    public ArrayList<WebSite> getWebListSortByURL() {
        ArrayList<WebSite> WebSites = new ArrayList<WebSite>();

        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebRecDB");
            EntityManager em = emf.createEntityManager();

            em.getTransaction().begin();

            List<Websites> websites = (List<Websites>) em.createNamedQuery("Websites.findAll").getResultList();

            for (int i = 0; i < websites.size(); i++) {
                WebSite website = new WebSite(websites.get(i).getWebsiteId());

                website.setUrl(websites.get(i).getUrl());
                website.setCreator(websites.get(i).getCreator().getUsername());
                website.setDescription(websites.get(i).getDescription());

                double rating = 0, count = 0;
                for (int j = 0; j < websites.get(i).getRatingsList().size(); j++) {
                    rating = +websites.get(i).getRatingsList().get(j).getRating();
                    count++;
                }
                rating = rating / count;

                website.setRating((int) rating);

                WebSites.add(website);
            }

            em.close();
            emf.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        Collections.sort(WebSites, new sortByURL());

        return WebSites;
    }

    public ArrayList<WebSite> getWebListSortByUsername() {
        ArrayList<WebSite> WebSites = new ArrayList<WebSite>();

        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebRecDB");
            EntityManager em = emf.createEntityManager();

            em.getTransaction().begin();

            List<Websites> websites = (List<Websites>) em.createNamedQuery("Websites.findAll").getResultList();

            for (int i = 0; i < websites.size(); i++) {
                WebSite website = new WebSite(websites.get(i).getWebsiteId());

                website.setUrl(websites.get(i).getUrl());
                website.setCreator(websites.get(i).getCreator().getUsername());
                website.setDescription(websites.get(i).getDescription());

                double rating = 0, count = 0;
                for (int j = 0; j < websites.get(i).getRatingsList().size(); j++) {
                    rating = +websites.get(i).getRatingsList().get(j).getRating();
                    count++;
                }
                rating = rating / count;

                website.setRating((int) rating);

                WebSites.add(website);
            }

            em.close();
            emf.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        Collections.sort(WebSites, new sortByUsername());

        return WebSites;
    }
}
