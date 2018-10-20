package demo.Controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import demo.model.Seller;
import demo.dao.SellerDao;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
//@RequestMapping("")
public class SiteController {
    private static final Logger log = LogManager.getLogger(SiteController.class);

    private final SellerDao sellerDao = new SellerDao();

//    @RequestMapping(
//            path="",
//            method = RequestMethod.GET,
//            produces = MediaType.TEXT_PLAIN_VALUE
//    )
    @GetMapping("/main")
//    public ResponseEntity online() {
    public String online(Map<String, Object> model) {
//    public String online(Model model) {
        List<Seller> all = sellerDao.getAll();
        String responseBody = all.stream()
                .map(Seller::getName)
                .collect(Collectors.joining("\n"));

//        return ResponseEntity.ok().body(responseBody);
        List<Seller> allI = sellerDao.getAll();
        model.put("sellers", allI);
        return "main";
    }
}
