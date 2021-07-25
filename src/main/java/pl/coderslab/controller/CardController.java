package pl.coderslab.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Card;
import pl.coderslab.entity.User;
import pl.coderslab.repository.CardRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/app/card")
public class CardController {

    private final CardRepository cardRepository;

    @ModelAttribute("user")
    public User user(HttpServletRequest request){return (User) request.getSession().getAttribute("user");}

    public CardController(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @RequestMapping("/all")
    public String list(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        model.addAttribute("cards",cardRepository.findByUser((User) session.getAttribute("user")));
        List<Card> user = cardRepository.findByUser((User) session.getAttribute("user"));
        return "cards/list";
    }
}
