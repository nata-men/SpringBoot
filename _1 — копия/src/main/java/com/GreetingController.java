package com;

import com.domain.*;
import com.repos.AdminRepo;
import com.repos.StatRepo;
import com.repos.TipRepo;
import com.repos.ZayvkaRepo;
import javafx.print.Collation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class GreetingController {
    @Autowired
    private ZayvkaRepo zayvkaRepo;

    @Autowired
    private TipRepo tipRepo;

    @Autowired
    private StatRepo statusRepo;

    @Autowired
    private AdminRepo adminRepo;

    @GetMapping("greeting")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @PostMapping("greeting")
    public String auto(@RequestParam String login, @RequestParam String password, Map<String, Object> model) {
        if ( !adminRepo.findByLogin(login).isEmpty()){
            if (adminRepo.findByLogin(login).get(0).getPassword().equals(password)) {
                Iterable<Zayvka> zayvkas = zayvkaRepo.findAll();
                Iterable<Statuses>statusesIterable = statusRepo.findAll();
                List<ZShow> zShows = new ArrayList<ZShow>();
                for (Zayvka zayvka : zayvkas) {
                    TipGruz tipGruz = tipRepo.findById(zayvka.getId_tip()).get(0);
                    Statuses statuses = statusRepo.findById(zayvka.getId_status()).get(0);
                    ZShow zShow = new ZShow(zayvka.getId(),zayvka.getName(),zayvka.getAdress_to(),zayvka.getAdress_from(),
                            zayvka.getTonnazh(),zayvka.getDate(),tipGruz.getTip(),statuses.getStatus_name(),zayvka.getTel());
                    zShows.add(zShow);
                }
                model.put("messages", zShows);
                model.put("statuses",statusesIterable);
                return "admin";
            } else {
                return "greeting";
            }
        }else {
            return "greeting";}
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Zayvka> zayvkas = zayvkaRepo.findAll();

        model.put("messages", zayvkas);

        Iterable<TipGruz> tipGruzs = tipRepo.findAll();
        model.put("tipg",tipGruzs);

        return "main";
    }

    @PostMapping("/main")
    public String add(@RequestParam String tname, @RequestParam int tonnzh, @RequestParam String ad_from, @RequestParam String ad_to, @RequestParam String dates, @RequestParam Integer tip, @RequestParam String phone,Map<String, Object> model) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        Date datee = format.parse(dates);
        Zayvka zayvka = new Zayvka(tname,  ad_to, ad_from, tonnzh, datee, tip, 2,phone);
        zayvkaRepo.save(zayvka);
        return "sucsses";
    }

    @GetMapping("admin")
    public String adminn(Map<String, Object> model) {
        return "greeting";
    }

    @PostMapping("admin")
    public String admin(@RequestParam Integer stat, @RequestParam Integer idd, Map<String, Object> model) {
        Zayvka zayvka = zayvkaRepo.findById(idd).get(0);
        zayvka.setId_status(stat);
        zayvkaRepo.save(zayvka);

        Iterable<Zayvka> zayvkas = zayvkaRepo.findAll();
        Iterable<Statuses>statusesIterable = statusRepo.findAll();
        List<ZShow> zShows = new ArrayList<ZShow>();
        for (Zayvka zayvkaa : zayvkas) {
            TipGruz tipGruz = tipRepo.findById(zayvkaa.getId_tip()).get(0);
            Statuses statuses = statusRepo.findById(zayvkaa.getId_status()).get(0);
            ZShow zShow = new ZShow(zayvkaa.getId(),zayvkaa.getName(),zayvkaa.getAdress_to(),zayvkaa.getAdress_from(),
                    zayvkaa.getTonnazh(),zayvkaa.getDate(),tipGruz.getTip(),statuses.getStatus_name(),zayvkaa.getTel());
            zShows.add(zShow);
        }

        model.put("statuses",statusesIterable);
        model.put("messages", zShows);

        return "admin";
    }

    @PostMapping("sucsses")
    public String sucsses(Map<String, Object> model){
        return "main";
    }

    @PostMapping("search")
        public String search(@RequestParam String stat,Map<String, Object> model){
            Iterable<Zayvka> zayvkas = zayvkaRepo.findAll();
            Iterable<Statuses>statusesIterable = statusRepo.findAll();
            List<ZShow> zShows = new ArrayList<ZShow>();
            for (Zayvka zayvkaa : zayvkas) {
                TipGruz tipGruz = tipRepo.findById(zayvkaa.getId_tip()).get(0);
                Statuses statuses = statusRepo.findById(zayvkaa.getId_status()).get(0);
                ZShow zShow = new ZShow(zayvkaa.getId(),zayvkaa.getName(),zayvkaa.getAdress_to(),zayvkaa.getAdress_from(),
                        zayvkaa.getTonnazh(),zayvkaa.getDate(),tipGruz.getTip(),statuses.getStatus_name(),zayvkaa.getTel());
                if (stat.equals(zShow.getStatus())){zShows.add(zShow);}
            }

            model.put("statuses",statusesIterable);
            model.put("messages", zShows);
            return "admin";
        }

}