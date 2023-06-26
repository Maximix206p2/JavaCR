package org.itstep;

import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;
import org.itstep.rsql.CustomRsqlVisitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> users() {
        return userService.findAll();
    }

    @GetMapping("/users/page")
    public Page<User> findAll() {
        Pageable pageable = PageRequest.of(0, 10);
        return (Page<User>) userService.findAll(pageable);
    }

    //page-size, offset-limit
    @GetMapping(value = "/users", params = {"page", "size"})
    public Page<User> paginationUsers(@RequestParam("page") int page,
                                      @RequestParam("size") int size) throws IOException {
        Pageable pageable = PageRequest.of(page, size);
        return userService.findAll(pageable);
    }

    @GetMapping(value = "/users", params = {"offset", "limit"})
    public Page<User> paginationUsers2(@RequestParam("offset") int offset,
                                       @RequestParam("limit") int limit) throws IOException {
        Pageable pageable = PageRequest.of(offset / limit, limit);
        return userService.findAll(pageable);
    }

    @GetMapping(value = "/users/sort", params = {"name", "order"})
    public List<User> sort(@RequestParam("name") String name,
                           @RequestParam("order") String order) {
        Sort.Direction direction = Sort.Direction.ASC;
        if (order.equals("desc"))
            direction = Sort.Direction.DESC;
        return userService.findByOrderByName(Sort.by(direction, name));
    }

    @GetMapping(value = "/users/sort", params = {"name", "order","page", "size"})
    public Page<User> sortPagination(@RequestParam("name") String name,
                                     @RequestParam("order") String order,
                                     @RequestParam("page") String page,
                                     @RequestParam("size") String size) {
        Sort.Direction direction = Sort.Direction.ASC;
        if (order.equals("desc"))
            direction = Sort.Direction.DESC;
        return userService.findAll(PageRequest.of(Integer.parseInt(page), Integer.parseInt(size), Sort.by(direction, name)));
    }

    //http://localhost:8080/users?page=0&size=10&sort=name,desc&sort=surname,desc
    @GetMapping(value = "/users", params = {"sort","page","size"})
    public Page<User> sortManyPagination(@RequestParam("sort") String[] sort,
                                         @RequestParam("page") int page,
                                         @RequestParam("size") int size) {
        //System.out.println(sort.length);
        List<Sort.Order> orders = new ArrayList<>();
        if (sort[0].contains(",")){
            for (String order:sort){
                String[] oneSort = order.split(",");
                orders.add(new Sort.Order(getSortDirection(oneSort[1]), oneSort[0]));
            }
        }
            else
                orders.add(new Sort.Order(getSortDirection(sort[1]), sort[0]));
            Pageable pageable = PageRequest.of(page, size, Sort.by(orders));
            Page<User> users = userService.findAll(pageable);
            return users;
    }

    //ASC, DESC
    private Sort.Direction getSortDirection(String order){
        Sort.Direction direction = Sort.Direction.ASC;
        if (order.toUpperCase().equals("DESC"))
            direction = Sort.Direction.DESC;
        return direction;
    }

    /*
    http://localhost:8080/users?size=10&page=0&sort=surname,asc&search=name==Петр;surname==Агеев
    http://localhost:8080/users?size=10&page=0&sort=surname,asc&search=name!=Иван;surname==Иванов
    http://localhost:8080/users?size=10&page=0&sort=surname,asc&search=name<Антон
    http://localhost:8080/users?size=10&page=0&sort=surname,asc&search=name==В*;surname==И*
    http://localhost:8080/users?size=10&page=0&sort=surname,asc&search=name==*ви*
    http://localhost:8080/users?size=10&page=0&sort=surname,asc&search=name=in=(Юрий,Яков)
     */

    @GetMapping(value = "/users", params = {"sort","page","size", "search"})
    public Page<User> sortManyPaginationSearch(@RequestParam("sort") String[] sort,
                                         @RequestParam("page") int page,
                                         @RequestParam("size") int size,
                                         @RequestParam("search") String search) {
        //System.out.println(sort.length);
        List<Sort.Order> orders = new ArrayList<>();
        if (sort[0].contains(",")){
            for (String order:sort){
                String[] oneSort = order.split(",");
                orders.add(new Sort.Order(getSortDirection(oneSort[1]), oneSort[0]));
            }
        }
        else
            orders.add(new Sort.Order(getSortDirection(sort[1]), sort[0]));
        Pageable pageable = PageRequest.of(page, size, Sort.by(orders));
        Node rootNode = new RSQLParser().parse(search);
        Specification<User> specification = rootNode.accept(new CustomRsqlVisitor<User>());
        Page<User> users = userService.findAll(specification,pageable);
        return users;
    }
}