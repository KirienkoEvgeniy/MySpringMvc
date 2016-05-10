package LuxTz.controller;

import LuxTz.model.StatFile;
import LuxTz.service.FileStatisticService;
import LuxTz.service.RowStatisticService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;


@Controller
public class HomeController {

	@Autowired
	private FileStatisticService fileService;
	@Autowired
	private RowStatisticService rowService;

	@RequestMapping(value="/")
	public ModelAndView listFile(ModelAndView model) throws IOException {
		List<StatFile> listFile = fileService.getAllFilesStatistic();
		model.addObject("listFile", listFile);
		model.setViewName("statFile");

		return model;
	}
	@RequestMapping(value="/statFileCondition")
	public ModelAndView listFileCondition (@RequestParam Integer rowsNumber, ModelAndView model) throws IOException {
		List<StatFile> listFileCondition = fileService.getAllFilesStatisticCondition(rowsNumber);
		model.addObject("listFileCondition", listFileCondition);
		model.setViewName("statFileCondition");
		return model;
	}
	@RequestMapping(value="/statFileCondition")
	public ModelAndView listFileCalculate (@RequestParam String fileName, String text, ModelAndView model) throws IOException {
//		List<StatFile> listFileCondition = fileService.getAllFilesStatisticCondition(rowsNumber);
//		model.addObject("listFileCondition", listFileCondition);
//		model.setViewName("statFileCondition");
		return model;
	}
}