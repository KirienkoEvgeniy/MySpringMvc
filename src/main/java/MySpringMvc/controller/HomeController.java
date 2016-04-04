package MySpringMvc.controller;

import MySpringMvc.dao.StatisticFileDAO;

import MySpringMvc.dao.StatisticRowFileDAO;

import MySpringMvc.model.RowFile;
import MySpringMvc.model.StatFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;


@Controller
public class HomeController {

	@Autowired
	private StatisticFileDAO statisticFileDAO;

	@RequestMapping(value="/")
	public ModelAndView listFile(ModelAndView model) throws IOException {
		List<StatFile> listFile = statisticFileDAO.list();
		model.addObject("listFile", listFile);
		model.setViewName("statFile");

		return model;
	}
		@Autowired
		private StatisticRowFileDAO statisticRoeFileDAO;

		@RequestMapping(value="/Row")
		public ModelAndView listRowFile(ModelAndView model) throws IOException{
			List<RowFile> listRowFile = statisticRoeFileDAO.list();
			model.addObject("listRowFile", listRowFile);
			model.setViewName("rowFilee");

			return model;

	}
	//	public @ResponseBody  List<RowFile> liststatistic() throws IOException {
//		return  statisticRowFileDAO.list();
//	@RequestMapping(value = "/newContact", method = RequestMethod.GET)
//	public ModelAndView newContact(ModelAndView model) {
//		Contact newContact = new Contact();
//		model.addObject("contact", newContact);
//		model.setViewName("ContactForm");
//		return model;
//	}
//
//	@RequestMapping(value = "/saveContact", method = RequestMethod.POST)
//	public ModelAndView saveContact(@ModelAttribute Contact contact) {
//		contactDAO.saveOrUpdate(contact);
//		return new ModelAndView("redirect:/");
//	}
//
//	@RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
//	public ModelAndView deleteContact(HttpServletRequest request) {
//		int contactId = Integer.parseInt(request.getParameter("id"));
//		contactDAO.delete(contactId);
//		return new ModelAndView("redirect:/");
//	}
//
//	@RequestMapping(value = "/editContact", method = RequestMethod.GET)
//	public ModelAndView editContact(HttpServletRequest request) {
//		int contactId = Integer.parseInt(request.getParameter("id"));
//		Contact contact = contactDAO.get(contactId);
//		ModelAndView model = new ModelAndView("ContactForm");
//		model.addObject("contact", contact);
//
//		return model;
//	}




//	@RequestMapping(value="/listStatistic")
//	public ModelAndView liststatistic(ModelAndView model) throws IOException {
//		List<RowFile> listContact = statisticRowFileDAO.list();
//		model.addObject("listContact", listContact);
//		model.setViewName("home");
//
//		return model;
//	}



}





















//		@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//
//		String formattedDate = dateFormat.format(date);
//
//		model.addAttribute("serverTime", formattedDate );
//
//		return "home";
//	}

//}
