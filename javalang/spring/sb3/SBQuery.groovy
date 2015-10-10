@Grab("thymeleaf-spring4")
@Controller
class SBQApp {
    def chapters = ["Baldur ate the cake", "Mymsy ate the cake", "Butters is to blame say Mymsy and Baldur"]

    @RequestMapping("/")
    def home(@RequestParam(value="name", defaultValue="World") String n) {
      new ModelAndView("jqstuff").addObject("name", n).addObject("chapters", chapters)
    }
}