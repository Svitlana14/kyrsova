package com.joreijarr.studycontrol.controllers;

import com.joreijarr.studycontrol.models.Notes;
import com.joreijarr.studycontrol.models.Clients;
import com.joreijarr.studycontrol.containers.notesContainer;
import com.joreijarr.studycontrol.models.Products;
import com.joreijarr.studycontrol.models.Users;
import com.joreijarr.studycontrol.repo.ProductsRepository;
import com.joreijarr.studycontrol.repo.ClientsRepository;
import com.joreijarr.studycontrol.repo.NoteRepository;
import com.joreijarr.studycontrol.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class startController {


    public Boolean authorized = false;
    public Users current_user;
    @Autowired
    public UsersRepository usersRepository;

    @Autowired
    public NoteRepository noteRepository;

    @Autowired
    public ProductsRepository productsRepository;

    @Autowired
    public ClientsRepository clientsRepository;


    @GetMapping("/exit")
    public String exit(Model model)
    {
        current_user = null;
        authorized = false;
        return "redirect:/";
    }


    @GetMapping("/")
    public String index(Model model)
    {
        model.addAttribute("title", "Головна");
        if(authorized)
        {
            model.addAttribute("fullname", current_user.getUser_fullname());
                return "index_user";
        }
        else
        {
            return "redirect:/authorize";
        }

    }


    @GetMapping("/authorize")
    public String start(Model model) {

        model.addAttribute("title", "Авторизація");
        if(!authorized)
        {
            return "authorize";
        }
        else
        {
            return "redirect:/";
        }
    }


    @PostMapping("/authorize")
    public String authorize(Model model, @RequestParam String user_login, @RequestParam String user_password)
    {
        Iterable<Users> users_it = usersRepository.findAll();
        List<Users> users = new ArrayList<>();
        users_it.forEach(users::add);
        for (int i = 0; i < users.size(); i++)
        {
            if(users.get(i).getUser_login().equals(user_login) && users.get(i).getUser_password().equals(user_password))
            {
                authorized = true;
                current_user = users.get(i);
                break;
            }
        }
        return "redirect:/";
    }





    @GetMapping("/registration")
    public String registration(Model model)
    {
        model.addAttribute("title", "Реєстрація");
        if(!authorized)
        {
            return "registration";
        }
        else
        {
            return "redirect:/";
        }
    }


    @PostMapping("/registration")
    public String registration(Model model, @RequestParam String user_login, @RequestParam String user_password,
                               @RequestParam String user_fullname)
    {
        Users new_user = new Users(user_login, user_password, user_fullname);
        usersRepository.save(new_user);
        return "redirect:/authorize";
    }





    @GetMapping("/notes")
    public String mans(Model model) {

        model.addAttribute("title", "Записи");

        Iterable<Products> products_it = productsRepository.findAll();
        List<Products> products = new ArrayList<>();
        products_it.forEach(products::add);

        Iterable<Clients> clients_it = clientsRepository.findAll();
        List<Clients> clients = new ArrayList<>();
        clients_it.forEach(clients::add);

            Iterable<Notes> notes_it = noteRepository.findAll();
            List<Notes> notes = new ArrayList<>();
            notes_it.forEach(notes::add);

            List<notesContainer> cnt = new ArrayList<>();
            for(int i = 0; i < notes.size(); i++)
            {
                notesContainer tmp = new notesContainer();
                tmp.note_date = notes.get(i).note_date;
                tmp.note_time = notes.get(i).note_time;
                for(int j = 0; j < products.size(); j++)
                {
                    if(Math.toIntExact(products.get(j).getProduct_id()) == Integer.parseInt(notes.get(i).getProduct()))
                    {
                        tmp.product = products.get(j).getName();
                        break;
                    }
                }


                for(int j = 0; j < clients.size(); j++)
                {
                    if(Math.toIntExact(clients.get(j).getClient_id()) == Integer.parseInt(notes.get(i).getClient()))
                    {
                        tmp.client = clients.get(j).getFull_name();
                        break;
                    }
                }

                cnt.add(tmp);
            }


            model.addAttribute("notes", cnt);
            return "notes_page";
    }

    @GetMapping("/notes/add")
    public String notesAdd(Model model) {
        Iterable<Products> products_it = productsRepository.findAll();
        List<Products> products = new ArrayList<>();
        products_it.forEach(products::add);

        Iterable<Clients> clients_it = clientsRepository.findAll();
        List<Clients> clients = new ArrayList<>();
        clients_it.forEach(clients::add);
        model.addAttribute("clients", clients);
        model.addAttribute("products", products);
        model.addAttribute("title", "Новий запис");
            return "notes_add";
    }

    @PostMapping("/notes/add")
    public String notesAdd_Post(Model model, @RequestParam String client_id,
                               @RequestParam String product_id,
                               @RequestParam String note_date,
                               @RequestParam String note_time) {
        Notes note = new Notes(client_id, product_id, note_date, note_time);
        noteRepository.save(note);
        return "redirect:/notes";
    }




    @GetMapping("/products")
    public String products(Model model) {

        model.addAttribute("title", "Процедури");

            Iterable<Products> products_it = productsRepository.findAll();
            List<Products> products = new ArrayList<>();
            products_it.forEach(products::add);
            model.addAttribute("products", products);
            return "products_page";
    }


    @GetMapping("/products/add")
    public String productsAdd(Model model) {
        model.addAttribute("title", "Нова процедура");
        return "products_add";
    }


    @PostMapping("/products/add")
    public String productsAdd_Post(Model model, @RequestParam String name,
                                 @RequestParam String description,
                                 @RequestParam String price) {
        Products products = new Products(name, description, price);
        productsRepository.save(products);
        return "redirect:/products";
    }



    @GetMapping("/clients")
    public String clients(Model model) {

        model.addAttribute("title", "Клієнти");
        Iterable<Clients> clients_it = clientsRepository.findAll();
        List<Clients> clients = new ArrayList<>();
        clients_it.forEach(clients::add);
        model.addAttribute("clients", clients);
        return "clients_page";
    }


    @GetMapping("/clients/add")
    public String pairsAdd(Model model) {
        model.addAttribute("title", "Новий клієнт");
        return "clients_add";
    }


    @PostMapping("/clients/add")
    public String pairsAdd_Post(Model model, @RequestParam String full_name,
                                @RequestParam String dob,
                                @RequestParam String email,
                                @RequestParam String phone) {
        Clients pair = new Clients(full_name, dob, email, phone);
        clientsRepository.save(pair);
        return "redirect:/clients";
    }

















}